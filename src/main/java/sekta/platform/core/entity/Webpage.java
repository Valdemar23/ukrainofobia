package sekta.platform.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Webpage extends Base {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    private Long id;*/
    private String name;

    @OneToMany(mappedBy =  "webpage")
    private List<Tag> tags = new ArrayList<Tag>();

    @ManyToOne
    @JoinColumn(name = "website_id")
    private Website website;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }
}