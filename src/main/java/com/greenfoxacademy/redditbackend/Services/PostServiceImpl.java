package com.greenfoxacademy.redditbackend.Services;

import com.greenfoxacademy.redditbackend.Models.Post;
import com.greenfoxacademy.redditbackend.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> allPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void upVote(Post post) {
        postRepository.save(post);
    }

    @Override
    public void downVote(Post post) {
        postRepository.save(post);
    }
}
