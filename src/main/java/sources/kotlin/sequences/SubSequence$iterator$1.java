package kotlin.sequences;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"kotlin/sequences/SubSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "a", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", "()Z", "next", "()Ljava/lang/Object;", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "b", "I", "getPosition", "()I", "setPosition", "(I)V", "position", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SubSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    private final Iterator iterator;

    /* renamed from: b, reason: from kotlin metadata */
    private int position;
    final /* synthetic */ SubSequence c;

    SubSequence$iterator$1(SubSequence subSequence) {
        Sequence sequence;
        this.c = subSequence;
        sequence = subSequence.sequence;
        this.iterator = sequence.getA();
    }

    /* JADX WARN: Incorrect condition in loop: B:2:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a() {
        int i;
        while (r0 < i && this.iterator.hasNext()) {
            this.iterator.next();
            this.position++;
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        a();
        int i2 = this.position;
        i = this.c.endIndex;
        return i2 < i && this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        int i;
        a();
        int i2 = this.position;
        i = this.c.endIndex;
        if (i2 >= i) {
            throw new NoSuchElementException();
        }
        this.position++;
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
