package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class VideoDecoder$VideoDecoderException extends RuntimeException {
    private static final long serialVersionUID = -2556382523004027815L;

    VideoDecoder$VideoDecoderException() {
        super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
    }
}
