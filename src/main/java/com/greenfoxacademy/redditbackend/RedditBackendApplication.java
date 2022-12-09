package com.greenfoxacademy.redditbackend;

import com.greenfoxacademy.redditbackend.Models.Post;
import com.greenfoxacademy.redditbackend.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditBackendApplication implements CommandLineRunner {

    PostRepository postRepository;

    @Autowired
    public RedditBackendApplication(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RedditBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Post post = new Post("google", "google.com");
        Post post2 = new Post("greenfox", "greenfoxacademy.com");
        Post post3 = new Post("reddit", "reddit.com");
        Post post4 = new Post("500px", "500px.com");
        Post post5 = new Post("instagram", "instagram.com");
        Post post6 = new Post("facebook", "facebook.com");

        postRepository.save(post);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
        postRepository.save(post6);
    }
}
