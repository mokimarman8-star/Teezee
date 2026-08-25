package io.reactivex.rxjava3.internal.util;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface h {
    boolean accept(i00.c cVar, Object obj);

    boolean cancelled();

    boolean done();

    Throwable error();

    int leave(int i);

    long produced(long j);

    long requested();
}
