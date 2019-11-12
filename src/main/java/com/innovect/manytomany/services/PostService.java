package com.innovect.manytomany.services;


import com.innovect.manytomany.models.Post;
import com.innovect.manytomany.models.Tag;
import com.innovect.manytomany.repository.PostRepository;
import com.innovect.manytomany.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
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

        post.getTagSet().add(tag);
        post.getTagSet().add(tag1);

        tag.getPostSet().add(post);
        tag1.getPostSet().add(post);

       //Save to repository
        postRepository.save(post);
    }
}
