package sekta.platform.core.dao;

import sekta.platform.core.entity.Description;

/**
 * Created by natad on 29.05.2016.
 */
public interface DescriptionDao extends BaseDao<Description> {//дао реалізовується тільки в стані (persistence)
    Description getById(Long id);
}
