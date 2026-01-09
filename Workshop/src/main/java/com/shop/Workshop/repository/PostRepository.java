package com.shop.Workshop.repository;

import com.shop.Workshop.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': {$regex:  ?0, $options:  'i'} }")
    List<Post> findByTitle(String text);

    @Query("{  '$and':[" +
            "{  $or:    [{ 'title': {$regex: ?0, $options: 'i' }}, " +
            "           { 'body':  {$regex: ?0, $options:  'i'}}," +
            "           { 'comments.comment': {$regex:  ?0, $options:  'i'}}]}, " +
            "{ 'date': {$gte: ?1} }, " +
            "{ 'date': {$lte: ?2} }]} ")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
