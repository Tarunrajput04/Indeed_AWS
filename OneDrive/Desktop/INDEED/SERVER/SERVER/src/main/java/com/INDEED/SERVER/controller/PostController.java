package com.INDEED.SERVER.controller;
import com.INDEED.SERVER.dto.PostDTO;
import com.INDEED.SERVER.model.PostModal;
import com.INDEED.SERVER.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
// Add RestControllerAdvice to the controller class
@RestControllerAdvice
public class PostController {

    final PostService postService;

    @PostMapping("/post")
    public PostModal savePost(@Valid @RequestBody PostDTO postDTORequest) {
        log.info("Saving post #####");
        return this.postService.savePost(postDTORequest);
    }

    @GetMapping("/posts")
    public List<PostModal> getAllPosts() {
        log.info("getting all post ###");
        return this.postService.getAllPosts();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String put = errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}