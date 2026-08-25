package okio;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"okio/Buffer$outputStream$1", "Ljava/io/OutputStream;", MRAIDPresenter.CLOSE, HttpUrl.FRAGMENT_ENCODE_SET, "flush", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "write", "data", HttpUrl.FRAGMENT_ENCODE_SET, "offset", HttpUrl.FRAGMENT_ENCODE_SET, "byteCount", "b", "okio"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class Buffer$outputStream$1 extends OutputStream {
    final /* synthetic */ Buffer this$0;

    Buffer$outputStream$1(Buffer buffer) {
        this.this$0 = buffer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.this$0 + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int b) {
        this.this$0.writeByte(b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] data, int offset, int byteCount) {
        Intrinsics.h(data, "data");
        this.this$0.write(data, offset, byteCount);
    }
}
