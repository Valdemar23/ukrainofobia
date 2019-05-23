package sekta.platform.core.entity;

import javax.persistence.*;

/**
 * Created by Retro on 14.05.2016.
 */

@Entity
public class Website extends Base {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long websiteId;*/

    private String name;

    public Website() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsiteName() {
        return name;
    }

    public void setWebsiteName(String name) {
        this.name = name;
    }
}
