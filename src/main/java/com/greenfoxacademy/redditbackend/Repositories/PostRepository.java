package com.greenfoxacademy.redditbackend.Repositories;

import com.greenfoxacademy.redditbackend.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface PostRepository extends JpaRepository<Post, Long> {

}
