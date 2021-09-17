package it.petete.dev.reactivespringbootclient.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TweetDto {
	private String id;
	private String text;
	private Date createdAt;
}