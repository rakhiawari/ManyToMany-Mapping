package com.innovect.manytomany.services;


import com.innovect.manytomany.models.Post;
import com.innovect.manytomany.models.Tag;
import com.innovect.manytomany.repository.PostRepository;
import com.innovect.manytomany.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class PostService {

    @Autowired(required = true)
    private PostRepository postRepository;

    @Autowired(required = true)
    private TagRepository tagRepository;



    public Iterable<Post> getAll() {
        return postRepository.findAll();
    }

    public void savePosts() {

        //Post
        Post post=new Post("This is Title","This is Description");

        //Tags
        Tag tag=new Tag("Tag1");
        Tag tag1=new Tag("Tag2");

        Set<Tag> tagSet=new HashSet<>();
        tagSet.add(tag);
        tagSet.add(tag1);

        post.setTags(tagSet);


       /* post.getTags().add(tag);
        post.getTags().add(tag1);*/

       Set<Post> postSet=new HashSet<Post>();
       postSet.add(post);

       tag.setPosts(postSet);

        /*tag.getPosts().add(post);
        tag1.getPosts().add(post);*/

       //Save to repository
        try{
            postRepository.save(post);
        }
        catch (Exception e){
            e.getStackTrace();
        }

    }
}
