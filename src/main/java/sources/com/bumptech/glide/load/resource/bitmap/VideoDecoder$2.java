package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Option;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class VideoDecoder$2 implements Option.CacheKeyUpdater<Integer> {
    private final ByteBuffer buffer = ByteBuffer.allocate(4);

    VideoDecoder$2() {
    }

    @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
    public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (this.buffer) {
            this.buffer.position(0);
            messageDigest.update(this.buffer.putInt(num.intValue()).array());
        }
    }
}
