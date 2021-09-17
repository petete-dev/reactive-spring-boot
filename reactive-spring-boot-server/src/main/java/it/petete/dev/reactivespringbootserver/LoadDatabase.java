package it.petete.dev.reactivespringbootserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import it.petete.dev.reactivespringbootserver.model.*;
import it.petete.dev.reactivespringbootserver.repository.*;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Configuration
@Slf4j
public class LoadDatabase {
	    
    @Autowired
    private TweetRepository tweetRepository;
 

	@EventListener(value = ContextRefreshedEvent.class)
	void init() {
		initTweets();
	}

    private void initTweets() {
        log.info("Start data initialization  ...");
        this.tweetRepository
            .deleteAll()
            .thenMany(
                Flux
                    .just("Tweet one", "Tweet two")
                    .flatMap(
                        text -> this.tweetRepository.save(new Tweet(text))
                    )
            )
            .log()
            .subscribe(
                null,
                null,
                () -> log.info("done initialization...")
            );
    }
}