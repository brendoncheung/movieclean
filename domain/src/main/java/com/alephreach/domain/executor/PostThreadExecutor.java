package com.alephreach.domain.executor;

import io.reactivex.Scheduler;

public interface PostThreadExecutor {

    Scheduler getScheudler();

}
