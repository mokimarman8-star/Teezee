package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface ResourceCallback {
    Object getLock();

    void onLoadFailed(GlideException glideException);

    void onResourceReady(Resource<?> resource, DataSource dataSource, boolean z);
}
