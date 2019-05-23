package sekta.platform.core.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sekta.platform.core.dao.DescriptionDao;
import sekta.platform.core.entity.Description;
import sekta.platform.core.service.DescriptionService;

import java.util.List;

/**
 * Created by natad on 29.05.2016.
 */
@Service
public class DescriptionServiceImpl implements DescriptionService {//realisation interface CRUD
    @Autowired
    DescriptionDao descriptionDao;

    @Override
    public List<Description> getAllDescriptions() {
        return descriptionDao.findAll();
    }

    @Override
    public Description getDescriptionById(Long id) {
        return descriptionDao.getById(id);
    }

    @Override
    public Session getSession(){return descriptionDao.getSession();}

    @Override
    public SessionFactory getCurrentSessionFactory(){return descriptionDao.getCurrentSessionFactory();}

    @Override
    public Description createDescription(Description description) {
        descriptionDao.create(description);
        return description;
    }

    @Override
    public Description updateDescripton(Description description) {
        descriptionDao.update(description);
        return description;
    }

    @Override
    public void deleteDescription(Long descriptionId) {
        Description description = new Description();
        description.setId(descriptionId);
        descriptionDao.delete(description);
    }
}
