package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface DataRewinder<T> {

    public interface Factory<T> {
        @NonNull
        DataRewinder<T> build(@NonNull T t);

        @NonNull
        Class<T> getDataClass();
    }

    void cleanup();

    @NonNull
    T rewindAndGet() throws IOException;
}
