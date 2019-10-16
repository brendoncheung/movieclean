package com.alephreach.data.repository;

import com.alephreach.data.model.MovieEntity;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRemote {

    Observable<List<MovieEntity>> getMovies();


}
