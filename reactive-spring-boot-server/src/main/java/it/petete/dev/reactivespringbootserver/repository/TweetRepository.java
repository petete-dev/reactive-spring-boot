package it.petete.dev.reactivespringbootserver.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import it.petete.dev.reactivespringbootserver.model.*;

@Repository
public interface TweetRepository extends ReactiveCrudRepository<Tweet, String> {

}