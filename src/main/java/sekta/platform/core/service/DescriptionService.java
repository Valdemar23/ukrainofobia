package sekta.platform.core.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.entity.Description;

import java.util.List;

/**
 * Created by natad on 29.05.2016.
 */
@Transactional
@Repository//this is class will work with DB
public interface DescriptionService extends JpaRepository<Description,Long> {//interface CRUD
}
