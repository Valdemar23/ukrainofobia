package sekta.platform.core.dao;

import sekta.platform.core.entity.Webpage;

/**
 * Created by natad on 25.05.2016.
 */
public interface WebpageDao extends BaseDao<Webpage> {//дао реалізовується тільки в стані (persistence)
    Webpage getById(Long id);
}
