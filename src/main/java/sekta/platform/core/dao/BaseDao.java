package sekta.platform.core.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Created by natad on 15.05.2016.
 */
public interface BaseDao<T> {//це дуже унікальна дао, тут власне тіпа прописаний interface CRUD

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    void isOpen();

    void close();

    Session getSession();

    SessionFactory getCurrentSessionFactory();

    List<T> findAll();

    List<T> findAllByProperty(String propertyName, Object propertyValue);

}
