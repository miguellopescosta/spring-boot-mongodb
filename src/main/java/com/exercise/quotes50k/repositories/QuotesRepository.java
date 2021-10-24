package com.exercise.quotes50k.repositories;

import com.exercise.quotes50k.models.Quote;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;

public interface QuotesRepository extends MongoRepository<Quote, String> {

    @Query("{ 'quoteAuthor' : ?0 }")
    List<Quote> findUsersByAuthor(String quoteAuthor);

    @Query("{ '_id': ?0,'quoteAuthor' : ?0 }")
    List<Quote> findUsersByIdAndAuthor(String id, String quoteAuthor);

    default List<Quote> findBy(String id,
                                   String text,
                                   String author,
                                   String genre,
                                   Long __v) {
        Quote quote = new Quote(id, text, author, genre, __v);

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("quoteText", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("quoteAuthor", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("quoteGenre", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());


        Example<Quote> info = Example.of(quote,customExampleMatcher);

        return findAll(info);
    }


}
