package com.exercise.quotes50k.services;

import com.exercise.quotes50k.cache.CacheInterface;
import com.exercise.quotes50k.models.Quote;
import com.exercise.quotes50k.repositories.QuotesRepository;
import com.exercise.quotes50k.view.DataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


@RestController
public class RestApiController {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiController.class);

    private final QuotesRepository quotesRepository;
    private final CacheInterface cacheInterface;

    public RestApiController(QuotesRepository quotesRepository, CacheInterface cacheInterface) {
        this.quotesRepository = quotesRepository;
        this.cacheInterface = cacheInterface;
    }

    @GetMapping("/allquotes")
    public List<Quote> getQuotes() {
        return quotesRepository.findAll();
    }

    @GetMapping("/allquotesfast")
    public List<Quote> getQuotesFast() throws ExecutionException {
        return cacheInterface.getGenericCache();
    }

    @GetMapping("/search")
    public DataResponse getQuotes(@QueryParam("id") String id, @QueryParam("author") String author) {
        if (id != null && author == null) {
            return new DataResponse(quotesRepository.findById(id).stream().collect(Collectors.toList()));
        } else if (id != null) {
            return new DataResponse(quotesRepository.findQuotesByIdAndAuthor(id, author));
        } else {
            return new DataResponse(quotesRepository.findQuotesByAuthor(author));
        }
    }

    @GetMapping("/detailedsearch")
    public DataResponse getQuotes(@QueryParam("id") String id,
                                  @QueryParam("text") String text,
                                  @QueryParam("author") String author,
                                  @QueryParam("genre") String genre,
                                  @QueryParam("__v") Long __v) {

        LOG.info("Info regarding Quote details: " + id + " " + text + " " + author + " " + genre + " " + __v);

        return new DataResponse((List<Quote>) quotesRepository.findBy(id, text, author, genre, __v));
    }


}
