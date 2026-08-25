package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class VideoDecoder$AssetFileDescriptorInitializer implements VideoDecoder$MediaInitializer<AssetFileDescriptor> {
    private VideoDecoder$AssetFileDescriptorInitializer() {
    }

    /* synthetic */ VideoDecoder$AssetFileDescriptorInitializer(VideoDecoder$1 videoDecoder$1) {
        this();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
    public void initializeExtractor(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) throws IOException {
        mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer
    public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }
}
