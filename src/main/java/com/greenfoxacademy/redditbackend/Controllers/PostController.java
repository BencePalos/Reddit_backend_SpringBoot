package com.greenfoxacademy.redditbackend.Controllers;

import com.greenfoxacademy.redditbackend.Models.Post;
import com.greenfoxacademy.redditbackend.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.allPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostByID(@PathVariable("id")Long id){
        return ResponseEntity.ok(postService.findPostById(id));
    }

    @PostMapping
    public Post addPost(@RequestBody Post post){
    Post newPost = new Post(post.getTitle(), post.getUrl());
    postService.addPost(newPost);
    return newPost;
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Post> deletePost(@PathVariable("id") Long id){
        Post deletedPost = postService.findPostById(id);
        postService.deletePost(id);
        return ResponseEntity.ok(deletedPost);
    }

    @PutMapping("/{id}/upvote")
    public ResponseEntity<Post> upvotePost(@PathVariable("id")Long id){
        Post upvotedPost = postService.findPostById(id);
        upvotedPost.setScore(upvotedPost.getScore() + 1);
        postService.upVote(upvotedPost);
        return ResponseEntity.ok(upvotedPost);
    }
    @PutMapping("/{id}/downvote")
    public ResponseEntity<Post> downvotePost(@PathVariable("id") Long id){
        Post downvotedPost = postService.findPostById(id);
        if(downvotedPost.getScore() > 0)  downvotedPost.setScore(downvotedPost.getScore() -1);
        postService.downVote(downvotedPost);
        return ResponseEntity.ok(downvotedPost);
    }
}
