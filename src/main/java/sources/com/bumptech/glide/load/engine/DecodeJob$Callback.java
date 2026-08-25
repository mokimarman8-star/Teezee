package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
interface DecodeJob$Callback<R> {
    void onLoadFailed(GlideException glideException);

    void onResourceReady(Resource<R> resource, DataSource dataSource, boolean z);

    void reschedule(DecodeJob<?> decodeJob);
}
