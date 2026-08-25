package com.bumptech.glide;

import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Registry$NoSourceEncoderAvailableException extends Registry$MissingComponentException {
    public Registry$NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
        super("Failed to find source encoder for data class: " + cls);
    }
}
