package com.innovect.manytomany.repository;


import com.innovect.manytomany.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TagRepository extends CrudRepository<Tag,Integer> {

    Set<Tag> findAll();
}
