package sekta.platform.core.dao;

import sekta.platform.core.entity.Website;

/**
 * Created by natad on 18.05.2016.
 */
public interface WebsiteDao extends BaseDao<Website> {//дао реалізовується тільки в стані (persistence)
    Website getById(Long id);
}
