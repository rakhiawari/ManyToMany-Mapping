package com.innovect.manytomany.models;


import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
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


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "post_tags", joinColumns = {@JoinColumn(name = "post_id")}, inverseJoinColumns =
            {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags;


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


    @JsonManagedReference
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }


}
