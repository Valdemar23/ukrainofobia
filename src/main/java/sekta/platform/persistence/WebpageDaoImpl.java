package sekta.platform.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.dao.WebpageDao;
import sekta.platform.core.entity.Webpage;

/**
 * Created by natad on 25.05.2016.
 */
@Transactional
@Repository//this is class will work with DB
public class WebpageDaoImpl extends BaseDaoImpl<Webpage> implements WebpageDao {//цей буде повноцінним завдяки наслідуванню і реалізовуватиме ...
    @Override
    public Webpage getById(Long id) {
        return (Webpage) sessionFactory.getCurrentSession().get(Webpage.class, id);
    }
}
