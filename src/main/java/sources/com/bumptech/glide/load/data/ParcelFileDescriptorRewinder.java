package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {
    private final InternalRewinder rewinder;

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.rewinder = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean isSupported() {
        return !"robolectric".equals(Build.FINGERPRINT);
    }

    public void cleanup() {
    }

    @NonNull
    /* renamed from: rewindAndGet, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor m22rewindAndGet() throws IOException {
        return this.rewinder.rewind();
    }
}
