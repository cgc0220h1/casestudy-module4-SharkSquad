package com.concamap.repositories;

import com.concamap.model.Category;
import com.concamap.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
    Iterable<Post> findAllByStatus(int status);

    Iterable<Post> findAllByStatus(int status, Sort sort);

    Page<Post> findAllByStatus(int status, Pageable pageable);

    Optional<Post> findByStatusAndId(int status, int id);

    Page<Post> findAllByStatusAndCreatedDateBefore(int status, Timestamp createdDate, Pageable pageable);

    Page<Post> findByStatusAndCategory(int status, Category category, Pageable pageable);

    Page<Post> findAllByStatusAndCreatedDateBetween(int status, Timestamp startDate, Timestamp endDate, Pageable pageable);

    Page<Post> findAllByStatusAndTitleContains(int status, String title, Pageable pageable);

    List<Post> findAllByStatusAndTitleContains(int status, String title);

    Page<Post> findAllByStatusAndContentContains(int status, String content, Pageable pageable);

    List<Post> findAllByStatusAndContentContains(int status, String content);

    Page<Post> findAllByStatusAndTitleContainsAndContentContains(int status, String title, String content, Pageable pageable);
}
