package com.innovect.manytomany.controller;


import com.innovect.manytomany.models.Post;
import com.innovect.manytomany.models.Tag;
import com.innovect.manytomany.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    PostService postService;

    @RequestMapping("/getAll")
    public List<Post> getAll(){
        return postService.getAll();
    }

    @RequestMapping("/save-data")
    public void savePosts(){
        postService.savePosts();
    }
}