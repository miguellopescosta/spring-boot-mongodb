package com.exercise.quotes50k.cache;

import com.exercise.quotes50k.models.Quote;
import com.exercise.quotes50k.repositories.QuotesRepository;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Provider;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class GenericCache implements CacheInterface {

    private static final Logger LOG = LoggerFactory.getLogger(GenericCache.class);
    private static final String KEY = "QUOTES";
    private static final long interval = 5000;

    private final LoadingCache<String, List<Quote>> genericCache =
            CacheBuilder.newBuilder()
                    .expireAfterAccess(interval, TimeUnit.MILLISECONDS)
                    .build(new CacheLoader<String, List<Quote>>() {
                        @Override
                        public List<Quote> load(String key) throws Exception {
                            LOG.debug("Cache UPDATE");
                            return quotesRepositoryProvider.get().findAll();
                        }
                    });

    private final Provider<QuotesRepository> quotesRepositoryProvider;

    @Autowired
    public GenericCache(Provider<QuotesRepository> quotesRepositoryProvider) {
        this.quotesRepositoryProvider = quotesRepositoryProvider;
    }

    @Override
    public List<Quote> getGenericCache() throws ExecutionException {
        return genericCache.get(KEY);
    }

    @Override
    public void refreshCache() {
        genericCache.refresh(KEY);
    }

}
