package sekta.platform.core.dao;

import sekta.platform.core.entity.Tag;

/**
 * Created by natad on 28.05.2016.
 */
public interface TagDao extends BaseDao<Tag> {//дао реалізовується тільки в стані (persistence)
    Tag getById(Long id);
}
