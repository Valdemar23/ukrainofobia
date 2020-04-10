package sekta.platform.core.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.entity.Website;

import java.util.List;

/**
 * Created by natad on 18.05.2016.
 */
@Transactional
@Repository//this is class will work with DB
public interface WebsiteService extends JpaRepository<Website,Long> {//interface CRUD
}
