package com.alephreach.domain.interactor;

import com.alephreach.domain.executor.PostThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseObservableUsecase<T, V> {

    private final PostThreadExecutor mExecutor;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public BaseObservableUsecase(PostThreadExecutor executor) {
        mExecutor = executor;
    }

    public abstract Observable<T> buildObservableUsecase(V param);

    public void execute (DisposableObserver disposableObserver, V param) {
        Observable obs = buildObservableUsecase(param)
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
