package sekta.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.dao.WebpageDao;
import sekta.platform.core.entity.Webpage;
import sekta.platform.core.service.WebpageService;

import java.util.List;

/**
 * Created by natad on 25.05.2016.
 */
@Service
public class WebpageServiceImpl implements WebpageService {//realisation interface CRUD

    @Autowired
    private WebpageDao webpageDao;

    @Override
    @Transactional
    public List<Webpage> getAllWebpages() {
        List<Webpage> webpages = webpageDao.findAll();
        for (Webpage webpage : webpages) {
            webpage.getTags().size();
        }
        return webpages;
    }

    @Override
    @Transactional
    public Webpage getWebpageById(Long id) {
        return webpageDao.getById(id);
    }

    @Override
    @Transactional
    public Webpage createWebpage(Webpage webpage) {
        webpageDao.create(webpage);
        return webpage;
    }

    @Override
    @Transactional
    public Webpage updateWebpage(Webpage webpage) {
        webpageDao.update(webpage);
        return webpage;
    }

    @Override
    @Transactional
    public void deleteWebpage(Long id) {
        Webpage webpage = new Webpage();
        webpage.setId(id);
        webpageDao.delete(webpage);
    }

    @Transactional
    public List<Webpage> findByWebsiteId(Long website) {
        List<Webpage> webpages = webpageDao.findAllByProperty("creator.id", website);
        for (Webpage webpage : webpages) {
            webpage.getTags().size();
        }
        return webpages;
    }

    @Transactional
    public List<Webpage> findByTitle(String webpageTitle){
        List<Webpage> webpages = webpageDao.findAllByProperty("title", webpageTitle);
        for (Webpage webpage : webpages) {
            webpage.getTags().size();
        }
        return webpages;
    }
}
