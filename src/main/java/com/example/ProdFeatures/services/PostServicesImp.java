package com.example.ProdFeatures.services;

import com.example.ProdFeatures.dto.PostDTO;
import com.example.ProdFeatures.entities.PostEntity;
import com.example.ProdFeatures.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServicesImp implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO post) {
        PostEntity postEntity = modelMapper.map(post,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long id) {
        PostEntity postEntity =  postRepository.findById(id).orElse(null);
        return modelMapper.map(postEntity,PostDTO.class);
    }

    public PostDTO updatePostById(PostDTO inputPost, Long id){
        PostEntity olderPost = postRepository.findById(id).orElse(null);
        inputPost.setId(id);
        modelMapper.map(inputPost,olderPost);
        PostEntity savedPost = postRepository.save(olderPost);
        return modelMapper.map(savedPost, PostDTO.class);
    }
}
