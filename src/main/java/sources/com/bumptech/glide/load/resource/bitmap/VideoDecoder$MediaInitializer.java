package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
interface VideoDecoder$MediaInitializer<T> {
    void initializeExtractor(MediaExtractor mediaExtractor, T t) throws IOException;

    void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, T t);
}
