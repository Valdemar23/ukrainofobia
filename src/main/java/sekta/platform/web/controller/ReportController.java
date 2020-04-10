/*
package sekta.platform.web.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import master.OsUtils;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sekta.platform.core.entity.Description;
import sekta.platform.core.entity.Tag;
import sekta.platform.core.entity.Webpage;
import sekta.platform.core.entity.Website;
import sekta.platform.core.service.DescriptionService;
import sekta.platform.core.service.TagService;
import sekta.platform.core.service.WebpageService;
import sekta.platform.core.service.WebsiteService;
import sun.security.krb5.internal.crypto.Des;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping("report")
public class ReportController {
    @Autowired//дана анотація бере із Дома (Context/Container) WebpageService що живе в Home, а не створює новий пустий WebsiteDao, цей WebpageService створюєс власне самий Spring в результаті своєї роботи
    WebpageService webpageService;
    @Autowired
    TagService tagService;
    @Autowired
    DescriptionService descriptionService;
    @Autowired
    WebsiteService websiteService;

    static int FONT_SIZE_BIG = 40;
    static int FONT_SIZE_SMALL=16;
    static int OFFSET=32;

    @RequestMapping(value="",method=RequestMethod.GET)
    public String confirmCreateReport(){
        return "report";
    }

    @RequestMapping(value="getReport",method = RequestMethod.POST)
    public String createReport() throws Exception {
        final BaseFont bf=BaseFont.createFont("/usr/share/fonts/truetype/freefont/FreeSans.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font cyrylic=new Font(bf,14);

        Document document = new Document();//begin create report
        PdfWriter.getInstance(document, new FileOutputStream("target/Report.pdf"));
        Integer amountWebsites=websiteService.getAllWebsites().size();
        Integer amountWebpages=webpageService.getAllWebpages().size();
        Integer amountTags=tagService.getAllTags().size();
        Integer amountDescriptions=descriptionService.getAllDescriptions().size();

        List<Description> descriptionList= descriptionService.getAllDescriptions();
        List<Description>originalVal=new ArrayList<>();

        document.open();



        //config for fonts
        Font font1 = FontFactory.getFont(FontFactory.HELVETICA, FONT_SIZE_BIG, Font.BOLD);
        Font font2 = new Font(Font.FontFamily.HELVETICA, FONT_SIZE_SMALL, Font.ITALIC | Font.UNDERLINE);
        Font font3=new Font(Font.FontFamily.HELVETICA,OFFSET,Font.BOLD);
        //BaseFont cyrylica=BaseFont.createFont(BaseFont.HELVETICA, "Cp1251", BaseFont.NOT_EMBEDDED);

        Paragraph title = new Paragraph("REPORT", font1);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(FONT_SIZE_BIG);
        document.add(title);

        // параграф с текстом
        Paragraph h2 = new Paragraph("STATICS DATA ABOUT PARSING RESULT", font3);
        h2.setAlignment(Element.ALIGN_CENTER);
        h2.setSpacingAfter(FONT_SIZE_BIG/2);
        document.add(h2);

        int amountRecognizedComments=0;
        for(Description description:descriptionList){
            if(description.getValue().contains("~")){

            }else{
                amountRecognizedComments++;
            }
        }

        useGlue(document,"Websites",amountWebsites,font2);//Glue is opportunity use 2 text align on one row
        useGlue(document,"Webpages",amountWebpages,font2);//Glue is opportunity use 2 text align on one row
        useGlue(document,"Tags",amountTags,font2);//Glue is opportunity use 2 text align on one row
        useGlue(document,"Recognized comments",amountDescriptions+"/"+amountRecognizedComments,font2);//Glue is opportunity use 2 text align on one row
        useGlue(document,"Date",new Date(),font2);//Glue is opportunity use 2 text align on one row

        Paragraph h3 =new Paragraph("CLASSIFICATED COMMENTS",cyrylic);
        h3.setAlignment(Element.ALIGN_CENTER);
        h3.setSpacingBefore(FONT_SIZE_BIG);
        h3.setSpacingAfter(FONT_SIZE_BIG/2);
        document.add(h3);

        PdfPTable table = new PdfPTable(5);//begin inserting table
        table.setWidthPercentage(100);
        table.setWidths(new float[] { 6, 10,10,60,14 });
        addTableHeader(table);



        for(Description description:descriptionList){
            if(description.getValue().contains("~")){

            }else{
                originalVal.add(description);
                System.out.println(description.toString());
            }
        }

        addRows(table,originalVal,cyrylic);
        document.add(table);

        Paragraph footer = new Paragraph("Thanks for cooperation");//by Saponov Konstantin & Co
        footer.setAlignment(Element.ALIGN_CENTER);
        footer.setSpacingBefore(FONT_SIZE_BIG);
        document.add(footer);
        document.close();

        ProcessBuilder processBuilder=null;
        if(OsUtils.isLinux()) {
            processBuilder = new ProcessBuilder("/bin/bash", "-c", "sensible-browser target/Report.pdf");///home/jackiechan/Documents/IdeaProjects/yoda-master-jedi/
        }
        if(OsUtils.isWindows()){
            processBuilder = new ProcessBuilder("cmd.exe", "/C", "target\\Report.pdf");
        }
        processBuilder.start();
        System.out.println(OsUtils.getOsName());

        return "redirect:/";
    }

    private static void useGlue(Document document,String title,Object amount,Font font){
        Chunk glue=new Chunk(new VerticalPositionMark());
        Paragraph p=new Paragraph(title,font);
        p.add(new Chunk(glue));
        p.add(String.valueOf(amount));

        try {
            document.add(p);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("ID", "SOURCE","TAG","COMMENT", "VALUE")//
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table,List<Description> descriptionList,Font font) {
        for(Description description:descriptionList){
            Tag tag=description.getTag();
            Webpage webpage=tag.getWebpage();

            PdfPCell c1 = new PdfPCell(new Phrase(String.valueOf(description.getId()),font));//for cyrylic
            PdfPCell c2=new PdfPCell(new Phrase(String.valueOf(webpage.getName()),font));//for cyrylic
            PdfPCell c3=new PdfPCell(new Phrase(String.valueOf(tag.getText()),font));
            PdfPCell c4 = new PdfPCell(new Phrase(String.valueOf(description.getAttribute()),font));//for cyrylic
            PdfPCell c5= new PdfPCell(new Phrase(String.valueOf(description.getValue()),font));//for cyrylic

            table.addCell(c1);
            table.addCell(c2);
            table.addCell(c3);
            table.addCell(c4);
            table.addCell(c5);
        }
    }
}*/
