package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.o;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface e {
    void accept(o oVar, Object obj);

    boolean cancelled();

    boolean done();

    Throwable error();

    int leave(int i);
}
