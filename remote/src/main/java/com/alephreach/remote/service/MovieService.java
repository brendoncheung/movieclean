package com.alephreach.remote.service;

import com.alephreach.data.model.MovieEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MovieService {

    @GET("movie/popular")
    Observable<List<MovieEntity>> getPopularMovies();


}
