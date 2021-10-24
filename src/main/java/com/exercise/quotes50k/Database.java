package com.exercise.quotes50k;

import com.exercise.quotes50k.repositories.QuotesRepository;
import com.exercise.quotes50k.models.Quotes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Database implements CommandLineRunner {

	private final QuotesRepository quotesRepository;

	public Database(QuotesRepository productRepository) {
		this.quotesRepository = productRepository;
	}


	/* TODO To Populate MongoDB read below */

	@Override
	public void run(String[] args) {

		/* TODO Uncomment code to populate your new and empty Collection with 50000 items from a given source */

		/*
		final String uri = "https://quote-garden.herokuapp.com/api/v3/quotes?limit=1000&page=";

		this.quotesRepository.deleteAll();

		RestTemplate restTemplate = new RestTemplate();

		Quotes result;

		for(int i = 1; i<51; i++){
			result = restTemplate.getForObject(uri + String.valueOf(i), Quotes.class);
			this.quotesRepository.saveAll(result.getData());
		}
		*/

	}

}
