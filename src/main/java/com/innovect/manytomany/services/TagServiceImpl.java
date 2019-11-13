package com.innovect.manytomany.services;

import com.innovect.manytomany.models.Tag;
import com.innovect.manytomany.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Set<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
