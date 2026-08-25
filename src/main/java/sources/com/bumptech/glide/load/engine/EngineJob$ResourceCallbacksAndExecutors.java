package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class EngineJob$ResourceCallbacksAndExecutors implements Iterable<EngineJob$ResourceCallbackAndExecutor> {
    private final List<EngineJob$ResourceCallbackAndExecutor> callbacksAndExecutors;

    EngineJob$ResourceCallbacksAndExecutors() {
        this(new ArrayList(2));
    }

    EngineJob$ResourceCallbacksAndExecutors(List<EngineJob$ResourceCallbackAndExecutor> list) {
        this.callbacksAndExecutors = list;
    }

    private static EngineJob$ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback resourceCallback) {
        return new EngineJob$ResourceCallbackAndExecutor(resourceCallback, Executors.directExecutor());
    }

    void add(ResourceCallback resourceCallback, Executor executor) {
        this.callbacksAndExecutors.add(new EngineJob$ResourceCallbackAndExecutor(resourceCallback, executor));
    }

    void clear() {
        this.callbacksAndExecutors.clear();
    }

    boolean contains(ResourceCallback resourceCallback) {
        return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(resourceCallback));
    }

    EngineJob$ResourceCallbacksAndExecutors copy() {
        return new EngineJob$ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
    }

    boolean isEmpty() {
        return this.callbacksAndExecutors.isEmpty();
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<EngineJob$ResourceCallbackAndExecutor> iterator() {
        return this.callbacksAndExecutors.iterator();
    }

    void remove(ResourceCallback resourceCallback) {
        this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(resourceCallback));
    }

    int size() {
        return this.callbacksAndExecutors.size();
    }
}
