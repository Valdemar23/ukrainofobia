package sekta.platform.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.dao.TagDao;
import sekta.platform.core.entity.Tag;

/**
 * Created by natad on 28.05.2016.
 */
@Transactional
@Repository//this is class will work with DB
public class TagDaoImpl extends BaseDaoImpl<Tag> implements TagDao {//цей буде повноцінним завдяки наслідуванню і реалізовуватиме ...
    @Override
    public Tag getById(Long id) {
        return (Tag) sessionFactory.getCurrentSession().get(Tag.class, id);
    }
}
