package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Option;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class VideoDecoder$1 implements Option.CacheKeyUpdater<Long> {
    private final ByteBuffer buffer = ByteBuffer.allocate(8);

    VideoDecoder$1() {
    }

    @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
    public void update(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
        messageDigest.update(bArr);
        synchronized (this.buffer) {
            this.buffer.position(0);
            messageDigest.update(this.buffer.putLong(l.longValue()).array());
        }
    }
}
