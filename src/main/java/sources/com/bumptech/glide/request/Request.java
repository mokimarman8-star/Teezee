package com.bumptech.glide.request;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface Request {
    void begin();

    void clear();

    boolean isAnyResourceSet();

    boolean isCleared();

    boolean isComplete();

    boolean isEquivalentTo(Request request);

    boolean isRunning();

    void pause();
}
