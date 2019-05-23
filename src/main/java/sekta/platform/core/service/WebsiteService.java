package sekta.platform.core.service;

import sekta.platform.core.entity.Website;

import java.util.List;

/**
 * Created by natad on 18.05.2016.
 */
public interface WebsiteService {//interface CRUD
    List<Website> getAllWebsites();
    Website getWebsiteById(Long id);
    Website createWebsite(Website website);
    Website updateWebsite(Website website);
    void deleteWebsite(Long id);
}
