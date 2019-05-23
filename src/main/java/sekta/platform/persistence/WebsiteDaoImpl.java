package sekta.platform.persistence;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import sekta.platform.core.dao.WebsiteDao;
import sekta.platform.core.entity.Website;

/**
 * Created by natad on 18.05.2016.
 */
@Transactional
@Repository//this is class will work with DB
public class WebsiteDaoImpl extends BaseDaoImpl<Website> implements WebsiteDao {//цей буде повноцінним завдяки наслідуванню і реалізовуватиме ...
    @Override
    public Website getById(Long id) {
        return (Website) sessionFactory.getCurrentSession().get(Website.class, id);
    }
}
