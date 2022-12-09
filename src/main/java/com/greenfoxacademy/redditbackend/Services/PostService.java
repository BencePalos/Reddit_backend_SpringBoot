package com.greenfoxacademy.redditbackend.Services;

import com.greenfoxacademy.redditbackend.Models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
public List<Post> allPosts();
public Post findPostById(Long id);
public void addPost(Post post);
public void deletePost(Long id);
public void upVote(Post post);
public void downVote(Post post);

}
