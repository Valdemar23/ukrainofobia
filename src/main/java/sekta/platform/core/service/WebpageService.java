package sekta.platform.core.service;

import sekta.platform.core.entity.Webpage;

import java.util.List;

/**
 * Created by natad on 25.05.2016.
 */
public interface WebpageService {//interface CRUD
    List<Webpage> getAllWebpages();
    Webpage getWebpageById(Long id);
    Webpage createWebpage(Webpage webpage);
    Webpage updateWebpage(Webpage webpage);
    void deleteWebpage(Long id);
    List<Webpage> findByWebsiteId(Long website);
    List<Webpage> findByTitle(String webpageTitle);
}
