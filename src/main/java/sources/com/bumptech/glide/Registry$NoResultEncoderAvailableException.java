package com.bumptech.glide;

import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Registry$NoResultEncoderAvailableException extends Registry$MissingComponentException {
    public Registry$NoResultEncoderAvailableException(@NonNull Class<?> cls) {
        super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
    }
}
