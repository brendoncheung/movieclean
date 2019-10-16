package com.alephreach.data.repository;

import com.alephreach.data.model.MovieEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface MovieCache {
    // local movie database

    Completable clearMovies();
    Completable saveMovie(MovieEntity movie);

    Observable<List<MovieEntity>> getMovies();
    Observable<List<MovieEntity>> getBookmarkedMovies();

    Completable bookmarkMovie(String id);
    Completable unBookmarkMovie(String id);

    Single<Boolean> areMoviesCached();

    Completable setLastCacheTime(Long cacheTime);
    Flowable<Boolean> isProjectCacheExpired();




}









