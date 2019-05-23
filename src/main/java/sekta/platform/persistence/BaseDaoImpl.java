package sekta.platform.persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.dao.BaseDao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by natad on 15.05.2016.
 */
@Transactional
@Repository//this is class will work with DB
public abstract class BaseDaoImpl<T> implements BaseDao<T> {//abstract realization CRUD-conception
    @Autowired//як я поняв дуже умна анотація яка бере із Дома (Context/Container) CardService що живе в Home, а не створює новий пустий WebsiteDao, цей CardService створюєс власне самий Spring в результаті своєї роботи
    protected SessionFactory sessionFactory;
    protected Class<T> entityClass;//будь-який клас сутностей

    public BaseDaoImpl() {//рефлексія яку я не вчив
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void create(T entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }//наскільки я зрозумів реалізація

    public void close() {
        sessionFactory.getCurrentSession().close();
    }

    public void isOpen() {
        sessionFactory.getCurrentSession().isOpen();// openSession();
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getCurrentSessionFactory(){
        return sessionFactory;
    }

    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }//наскільки я зрозумів реалізація

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }//наскільки я зрозумів реалізація

    public List<T> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
    }

    @Override
    public List<T> findAllByProperty(String propertyName, Object propertyValue) {
        String queryString = "from "+ entityClass.getName() +" where " + propertyName + "= ?";//sql-query in string var
        Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);//sql-query execution
        queryObject.setParameter(0, propertyValue);//i dont know
        return queryObject.list();
    }
}
