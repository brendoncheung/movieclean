package com.alephreach.domain.interactor;

import com.alephreach.domain.executor.PostThreadExecutor;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseCompletableUsecase<V> {

    private final PostThreadExecutor mExecutor;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public BaseCompletableUsecase(PostThreadExecutor executor) {
        mExecutor = executor;
    }

    public abstract Completable buildObservableUsecase(V param);

    public void execute (DisposableObserver disposableObserver, V param) {
        Completable obs = buildObservableUsecase(param)
                .subscribeOn(Schedulers.io())
                .observeOn(mExecutor.getScheudler());
    }

    private void addDisposable(Disposable d) {
        mCompositeDisposable.add(d);
    }

    public void dispose() {
        mCompositeDisposable.dispose();
    }


}
