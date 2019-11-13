package com.innovect.manytomany.controller;


import com.innovect.manytomany.models.Post;
import com.innovect.manytomany.models.Tag;
import com.innovect.manytomany.services.PostService;
import com.innovect.manytomany.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class Controller {

    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;
    @RequestMapping("/getAll")
    public Iterable<Post> getAll(){
        return postService.getAll();
    }

    @RequestMapping("/tags")
    public Set<Tag> getTags(){
        return tagService.getAllTags();
    }

    @RequestMapping("/save-data")
    public void savePosts(){
        postService.savePosts();
    }
}
