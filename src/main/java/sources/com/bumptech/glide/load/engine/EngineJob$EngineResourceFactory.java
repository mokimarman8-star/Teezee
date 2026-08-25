package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class EngineJob$EngineResourceFactory {
    EngineJob$EngineResourceFactory() {
    }

    public <R> EngineResource<R> build(Resource<R> resource, boolean z, Key key, EngineResource.ResourceListener resourceListener) {
        return new EngineResource<>(resource, z, true, key, resourceListener);
    }
}
