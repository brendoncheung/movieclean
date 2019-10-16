package com.alephreach.domain;

import com.alephreach.domain.model.Movie;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;


public interface MovieRepository {

    Observable<List<Movie>> getMovies();
    Observable<List<Movie>> getBookmarkedMovies();
    Completable bookmarkMovie();
    Completable unbookmarkMovie();


}
