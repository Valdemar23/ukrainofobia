package sekta.platform.core.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.entity.Webpage;

import java.util.List;

/**
 * Created by natad on 25.05.2016.
 */
@Transactional
@Repository//this is class will work with DB
public interface WebpageService extends JpaRepository<Webpage,Long> {//interface CRUD
}
