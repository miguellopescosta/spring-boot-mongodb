package com.exercise.quotes50k.cache;

import com.exercise.quotes50k.models.Quote;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CacheInterface {

    List<Quote> getGenericCache() throws ExecutionException;

    void refreshCache();

}
