package com.bumptech.glide.load.engine;

import com.bumptech.glide.request.ResourceCallback;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class EngineJob$ResourceCallbackAndExecutor {
    final ResourceCallback cb;
    final Executor executor;

    EngineJob$ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
        this.cb = resourceCallback;
        this.executor = executor;
    }

    public boolean equals(Object obj) {
        if (obj instanceof EngineJob$ResourceCallbackAndExecutor) {
            return this.cb.equals(((EngineJob$ResourceCallbackAndExecutor) obj).cb);
        }
        return false;
    }

    public int hashCode() {
        return this.cb.hashCode();
    }
}
