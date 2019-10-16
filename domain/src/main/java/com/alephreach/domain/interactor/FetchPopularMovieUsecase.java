package com.alephreach.domain.interactor;

import com.alephreach.domain.MovieRepository;
import com.alephreach.domain.executor.PostThreadExecutor;
import com.alephreach.domain.model.Movie;

import java.util.List;

import io.reactivex.Observable;

public class FetchPopularMovieUsecase extends BaseObservableUsecase<List<Movie>, Void> {

    private final MovieRepository mMovieRepository;

    public FetchPopularMovieUsecase(PostThreadExecutor executor, MovieRepository repository) {
        super(executor);
        mMovieRepository = repository;
    }

    @Override
    public Observable<List<Movie>> buildObservableUsecase(Void param) {
        return mMovieRepository.getMovies();
    }
}
