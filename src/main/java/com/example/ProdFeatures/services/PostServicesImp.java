package com.example.ProdFeatures.services;

import com.example.ProdFeatures.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServicesImp implements PostService{

    @Override
    public List<PostDTO> getAllPosts() {
        return List.of();
    }

    @Override
    public PostDTO createNewPost(PostDTO post) {
        return null;
    }
}
