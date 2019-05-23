package sekta.platform.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends Base {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull
    private Long id;*/
    //@NotNull
    private String text;

    @ManyToOne
    @JoinColumn(name = "webpage_id")
    private Webpage webpage;

    @OneToMany(mappedBy =  "tag")
    private List<Description> descriptions = new ArrayList<Description>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Webpage getWebpage() {
        return webpage;
    }

    public void setWebpage(Webpage webpage) {
        this.webpage = webpage;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }
}
