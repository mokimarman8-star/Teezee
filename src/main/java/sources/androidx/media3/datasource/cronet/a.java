package androidx.media3.datasource.cronet;

import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class a extends UploadDataProvider {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f9588a;

    /* renamed from: b, reason: collision with root package name */
    private int f9589b;

    public a(byte[] bArr) {
        this.f9588a = bArr;
    }

    public long getLength() {
        return this.f9588a.length;
    }

    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        int min = Math.min(byteBuffer.remaining(), this.f9588a.length - this.f9589b);
        byteBuffer.put(this.f9588a, this.f9589b, min);
        this.f9589b += min;
        uploadDataSink.onReadSucceeded(false);
    }

    public void rewind(UploadDataSink uploadDataSink) {
        this.f9589b = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
