package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class ActiveResources$ResourceWeakReference extends WeakReference<EngineResource<?>> {
    final boolean isCacheable;
    final Key key;

    @Nullable
    Resource<?> resource;

    ActiveResources$ResourceWeakReference(@NonNull Key key, @NonNull EngineResource<?> engineResource, @NonNull ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
        super(engineResource, referenceQueue);
        this.key = (Key) Preconditions.checkNotNull(key);
        this.resource = (engineResource.isMemoryCacheable() && z) ? (Resource) Preconditions.checkNotNull(engineResource.getResource()) : null;
        this.isCacheable = engineResource.isMemoryCacheable();
    }

    void reset() {
        this.resource = null;
        clear();
    }
}
