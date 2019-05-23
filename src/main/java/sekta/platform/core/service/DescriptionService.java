package sekta.platform.core.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sekta.platform.core.entity.Description;

import java.util.List;

/**
 * Created by natad on 29.05.2016.
 */
public interface DescriptionService {//interface CRUD
    List<Description> getAllDescriptions();
    Description getDescriptionById(Long id);
    Description createDescription(Description description);



    Session getSession();
    SessionFactory getCurrentSessionFactory();



    Description updateDescripton(Description description);
    void deleteDescription(Long descriptionId);
}
