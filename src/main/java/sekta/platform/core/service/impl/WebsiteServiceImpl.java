package sekta.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.dao.WebsiteDao;
import sekta.platform.core.entity.Website;
import sekta.platform.core.service.WebsiteService;

import java.util.List;

/**
 * Created by natad on 18.05.2016.
 */
@Service
public class WebsiteServiceImpl implements WebsiteService {//realisation interface CRUD
    @Autowired//дана анотація бере із Дома (Context/Container) WebsiteDao що живе в Home, а не створює новий пустий WebsiteDao, цей WebsiteDao створюєс власне самий Spring в результаті своєї роботи
            WebsiteDao websiteDao;

    @Override
    @Transactional
    public List<Website> getAllWebsites() {
        return websiteDao.findAll();
    }

    @Override
    @Transactional
    public Website getWebsiteById(Long id) {
        return websiteDao.getById(id);
    }

    @Override
    @Transactional
    public Website createWebsite(Website website) {
        websiteDao.create(website);
        return website;
    }

    @Override
    @Transactional
    public Website updateWebsite(Website website) {
        websiteDao.update(website);
        return website;
    }

    @Override
    @Transactional
    public void deleteWebsite(Long id) {
        Website website = new Website();
        website.setId(id);
        websiteDao.delete(website);
    }
}
