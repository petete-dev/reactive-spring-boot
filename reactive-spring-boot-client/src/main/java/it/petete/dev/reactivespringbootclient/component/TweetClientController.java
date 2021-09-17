package it.petete.dev.reactivespringbootclient.component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import it.petete.dev.reactivespringbootclient.model.TweetDto;
import lombok.extern.java.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Log
public class TweetClientController {

	private final WebClient client;

	public TweetClientController(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://spring-boot-reactive-server:8080").build();
	}

	public Flux<TweetDto> getAllTweetsClient() {
		return this.client.get().uri("/tweets").accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(TweetDto.class)
				// .map(TweetDto::getText)
				;
	}

	public Mono<TweetDto> createTweets() {

		TweetDto newTweet = new TweetDto(UUID.randomUUID().toString(), UUID.randomUUID().toString(), new Date());

		return this.client.post().uri("/tweets").accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(newTweet), TweetDto.class)
				.retrieve()
				.bodyToMono(TweetDto.class)
				;
	}

	@Async
	@Scheduled(fixedRate = 2000)
	public void callGetAllTweetsClient() {
		log.info("Calling GET /tweets endpoint.");

		Optional<List<TweetDto>> list = getAllTweetsClient().collectList().blockOptional();
		if ( list.isPresent() ) {
			
			for (TweetDto tweet : list.get()) {
				log.info("ID:" + tweet.getId() + " TEXT:" + tweet.getText() + " CREATED_DATE:" + tweet.getCreatedAt());
			}

		} else {
			log.info("No tweet presents");
		}
		
	}

	@Async
	@Scheduled(fixedRate = 5000)
	public void callCreateTweets() {
		log.info("Calling POST /tweets endpoint.");
		TweetDto tweet = createTweets().block();
		if (tweet != null ) {
			log.info("ID:" + tweet.getId() + " TEXT:" + tweet.getText() + " CREATED_DATE:" + tweet.getCreatedAt());
		}
	}

}