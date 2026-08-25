package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoader;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Registry$NoModelLoaderAvailableException extends Registry$MissingComponentException {
    public Registry$NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
    }

    public Registry$NoModelLoaderAvailableException(@NonNull Object obj) {
        super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
    }

    public <M> Registry$NoModelLoaderAvailableException(@NonNull M m, @NonNull List<ModelLoader<M, ?>> list) {
        super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
    }
}
