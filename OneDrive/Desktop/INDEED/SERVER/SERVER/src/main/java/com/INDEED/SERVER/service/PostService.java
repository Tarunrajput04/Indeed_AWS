package com.INDEED.SERVER.service;

import com.INDEED.SERVER.dto.PostDTO;
import com.INDEED.SERVER.model.PostModal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public PostModal savePost(PostDTO postDTO);
    public List<PostModal> getAllPosts();
}