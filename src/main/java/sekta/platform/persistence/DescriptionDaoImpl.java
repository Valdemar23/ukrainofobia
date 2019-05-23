package sekta.platform.persistence;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.dao.DescriptionDao;
import sekta.platform.core.entity.Description;

/**
 * Created by natad on 29.05.2016.
 */
@Transactional
@Repository//this is class will work with DB
public class DescriptionDaoImpl extends BaseDaoImpl<Description> implements DescriptionDao {//цей буде повноцінним завдяки наслідуванню і реалізовуватиме ...
    @Override
    public Description getById(Long id) {
        return (Description) sessionFactory.getCurrentSession().get(Description.class, id);
    }
    /*public Session getSessionFactory(){
        return sessionFactory.getCurrentSession();
    }*/
}
