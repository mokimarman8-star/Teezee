package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface Encoder<T> {
    boolean encode(@NonNull T t, @NonNull File file, @NonNull Options options);
}
