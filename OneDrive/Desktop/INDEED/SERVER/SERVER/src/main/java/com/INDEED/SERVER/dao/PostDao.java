package com.INDEED.SERVER.dao;

import com.INDEED.SERVER.model.PostModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<PostModal, Long> {
    // Custom query methods can be defined here if needed
}
