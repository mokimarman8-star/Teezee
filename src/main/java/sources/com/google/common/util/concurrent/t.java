package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface t extends ExecutorService {
    r submit(Callable callable);
}
