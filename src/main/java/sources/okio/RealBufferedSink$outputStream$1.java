package okio;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"okio/RealBufferedSink$outputStream$1", "Ljava/io/OutputStream;", MRAIDPresenter.CLOSE, HttpUrl.FRAGMENT_ENCODE_SET, "flush", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "write", "data", HttpUrl.FRAGMENT_ENCODE_SET, "offset", HttpUrl.FRAGMENT_ENCODE_SET, "byteCount", "b", "okio"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class RealBufferedSink$outputStream$1 extends OutputStream {
    final /* synthetic */ RealBufferedSink this$0;

    RealBufferedSink$outputStream$1(RealBufferedSink realBufferedSink) {
        this.this$0 = realBufferedSink;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.this$0.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        RealBufferedSink realBufferedSink = this.this$0;
        if (realBufferedSink.closed) {
            return;
        }
        realBufferedSink.flush();
    }

    public String toString() {
        return this.this$0 + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int b) {
        RealBufferedSink realBufferedSink = this.this$0;
        if (realBufferedSink.closed) {
            throw new IOException("closed");
        }
        realBufferedSink.bufferField.writeByte((byte) b);
        this.this$0.emitCompleteSegments();
    }

    @Override // java.io.OutputStream
    public void write(byte[] data, int offset, int byteCount) {
        Intrinsics.h(data, "data");
        RealBufferedSink realBufferedSink = this.this$0;
        if (realBufferedSink.closed) {
            throw new IOException("closed");
        }
        realBufferedSink.bufferField.write(data, offset, byteCount);
        this.this$0.emitCompleteSegments();
    }
}
