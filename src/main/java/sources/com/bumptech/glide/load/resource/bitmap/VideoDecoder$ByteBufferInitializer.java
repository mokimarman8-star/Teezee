package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class VideoDecoder$ByteBufferInitializer implements VideoDecoder$MediaInitializer<ByteBuffer> {
    VideoDecoder$ByteBufferInitializer() {
    }

    private MediaDataSource getMediaDataSource(final ByteBuffer byteBuffer) {
        return new MediaDataSource() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder$ByteBufferInitializer.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return byteBuffer.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= byteBuffer.limit()) {
                    return -1;
                }
                byteBuffer.position((int) j);
                int min = Math.min(i2, byteBuffer.remaining());
                byteBuffer.get(bArr, i, min);
                return min;
            }
        };
    }

    @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
    public void initializeExtractor(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
        mediaExtractor.setDataSource(getMediaDataSource(byteBuffer));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
    public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
        mediaMetadataRetriever.setDataSource(getMediaDataSource(byteBuffer));
    }
}
