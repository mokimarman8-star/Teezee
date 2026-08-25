package kotlin.io;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.BufferedInputStream;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\t\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\u0015¨\u0006\u001b"}, d2 = {"kotlin/io/ByteStreamsKt$iterator$1", "Lkotlin/collections/ByteIterator;", HttpUrl.FRAGMENT_ENCODE_SET, "a", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", "()Z", HttpUrl.FRAGMENT_ENCODE_SET, "nextByte", "()B", HttpUrl.FRAGMENT_ENCODE_SET, "I", "getNextByte", "()I", "setNextByte", "(I)V", "b", "Z", "getNextPrepared", "setNextPrepared", "(Z)V", "nextPrepared", "c", "getFinished", "setFinished", "finished", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ByteStreamsKt$iterator$1 extends ByteIterator {

    /* renamed from: a, reason: from kotlin metadata */
    private int nextByte;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean nextPrepared;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean finished;
    final /* synthetic */ BufferedInputStream d;

    private final void a() {
        if (this.nextPrepared || this.finished) {
            return;
        }
        int read = this.d.read();
        this.nextByte = read;
        this.nextPrepared = true;
        this.finished = read == -1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        a();
        return !this.finished;
    }

    @Override // kotlin.collections.ByteIterator
    public byte nextByte() {
        a();
        if (this.finished) {
            throw new NoSuchElementException("Input stream is over.");
        }
        byte b = (byte) this.nextByte;
        this.nextPrepared = false;
        return b;
    }
}
