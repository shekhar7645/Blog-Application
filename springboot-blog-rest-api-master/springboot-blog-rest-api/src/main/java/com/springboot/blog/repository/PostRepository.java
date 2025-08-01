package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByCategoryId(Long categoryId);

}
    //Purpose: Handles database interactions for Post.
    // Methods: Comes with out-of-the-box methods like save,
    // findById, findAll, deleteById, etc.

