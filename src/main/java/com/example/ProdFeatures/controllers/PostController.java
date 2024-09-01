package com.example.ProdFeatures.controllers;

import com.example.ProdFeatures.dto.PostDTO;
import com.example.ProdFeatures.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO post){
        return postService.createNewPost(post);
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable("postId") Long id){
        return postService.getPostById(id);
    }

    @PutMapping("/{postId}")
    public PostDTO updatePostById(@RequestBody PostDTO inputPost, @PathVariable Long postId){
        return postService.updatePostById(inputPost ,postId);
    }
}
