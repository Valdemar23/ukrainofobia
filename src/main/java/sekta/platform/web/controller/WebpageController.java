package sekta.platform.web.controller;

import org.hibernate.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sekta.platform.ai.examples.NaiveBayesExample;
import sekta.platform.core.entity.Description;
import sekta.platform.core.entity.Tag;
import sekta.platform.core.entity.Webpage;
import sekta.platform.core.entity.Website;
import sekta.platform.core.service.DescriptionService;
import sekta.platform.core.service.TagService;
import sekta.platform.core.service.WebpageService;
import sekta.platform.core.service.WebsiteService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by natad on 25.05.2016.
 */
@Controller
@RequestMapping("parse-site")
public class WebpageController {

    @Autowired//дана анотація бере із Дома (Context/Container) WebpageService що живе в Home, а не створює новий пустий WebsiteDao, цей WebpageService створюєс власне самий Spring в результаті своєї роботи
    WebpageService webpageService;
    @Autowired
    TagService tagService;
    @Autowired
    DescriptionService descriptionService;
    @Autowired
    WebsiteService websiteService;

    public static Webpage WEBPAGE;

    @RequestMapping("")//
    public String getAll(ModelMap model){
/*        List<Webpage> webpages = webpageService.getAllWebpages();
        model.addAttribute("webpages", webpages);*/
        return "parse";
    }



    @RequestMapping(value = "parseWebPage", method = RequestMethod.POST)
    public String createWebpage(@RequestParam("webpageName") String webpageName,
                                @RequestParam("tag") String nameTag,
                                RedirectAttributes redirectAttributes) throws IOException {

        CheckingAndProcessingDataController checkerAndProcesser=new CheckingAndProcessingDataController();
        boolean isEmpty = checkerAndProcesser.checkOnExistEmptyData(webpageName,nameTag);
        if(isEmpty)return "empty";
        String domen=checkerAndProcesser.trimDomen(webpageName);//обрізання URL

        Website website=checkerAndProcesser.checkOnExistRepeatedData(domen,websiteService);
        Webpage webpage=checkerAndProcesser.checkOnExistRepeatedData(webpageName,website,webpageService);

        Tag tag=new Tag();
        tag.setText(nameTag);
        tag.setWebpage(webpage);
        tagService.createTag(tag);
        redirectAttributes.addFlashAttribute("message", "User successfully created!");

        Document document = null;
        try {
            document = Jsoup.connect(webpageName).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("TITLE: " + document.title());
        NaiveBayesExample object = new NaiveBayesExample();//add to DB

        Elements commentCopy = document.select(nameTag);//class
        Session session;
        Description description = new Description();//сюди варто додати поділ на триграми разом із наївним баєсом

        for (Element element : commentCopy) {
            session=descriptionService.getCurrentSessionFactory().openSession();
            if (!element.text().equals("")) {
                String line = object.start(element.text());
                String content;
                if (element.text().length() > 2000) {
                    content = element.text();
                    content = content.substring(0, 1999);
                } else {
                    content = element.text();
                }
                try {
                    session.beginTransaction();
                    description.setAttribute(content);
                    description.setValue(line);
                    description.setTag(tag);
                    session.save(description);
                    session.getTransaction().commit();
                    session.close();
                } catch (Exception e) {
                    session.close();
                    e.printStackTrace();
                }
                System.out.format("The sentense \"%s\" was classified as \"%s\".%n", element.text(), line);
            }
        }
        return "success-parsing-data";
    }
}
