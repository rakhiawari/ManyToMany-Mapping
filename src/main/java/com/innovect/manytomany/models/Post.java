package com.innovect.manytomany.models;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column(name = "post_description", nullable = false)
    private String description;

    /*@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at", nullable = false)
    private Date postedAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at", nullable = false)
    private Date lastUpdatedAt = new Date();*/

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "post_tags", joinColumns = {@JoinColumn(name = "post_id")}, inverseJoinColumns =
            {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();


    public Post(){}
    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Set<Tag> getTagSet() {
        return tags;
    }

    public void setTagSet(Set<Tag> tagSet) {
        this.tags = tagSet;
    }
}
