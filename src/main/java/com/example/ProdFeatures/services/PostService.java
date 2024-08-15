package com.example.ProdFeatures.services;

import com.example.ProdFeatures.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO post);
}
