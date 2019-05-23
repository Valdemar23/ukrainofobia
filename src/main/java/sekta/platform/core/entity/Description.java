package sekta.platform.core.entity;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;

@Entity
public class Description extends Base {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;*/
    //@NotNull
    private String attribute;
    //@NotNull
    private String value;
    /*@NotNull
    private Boolean isCorrect;*/

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /*public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }*/

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Description{" +
                "attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                ", tag=" + tag +
                ", id=" + id +
                '}';
    }
}
