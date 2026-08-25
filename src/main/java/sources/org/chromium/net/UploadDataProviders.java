package org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.nio.ByteBuffer;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UploadDataProviders {
    private UploadDataProviders() {
    }

    public static UploadDataProvider create(ParcelFileDescriptor parcelFileDescriptor) {
        return qz.a.a(parcelFileDescriptor);
    }

    public static UploadDataProvider create(File file) {
        return qz.a.b(file);
    }

    public static UploadDataProvider create(ByteBuffer byteBuffer) {
        return qz.a.c(byteBuffer);
    }

    public static UploadDataProvider create(byte[] bArr) {
        return qz.a.d(bArr);
    }

    public static UploadDataProvider create(byte[] bArr, int i, int i2) {
        return qz.a.e(bArr, i, i2);
    }
}
