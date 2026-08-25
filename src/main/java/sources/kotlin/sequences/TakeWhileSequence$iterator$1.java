package kotlin.sequences;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"kotlin/sequences/TakeWhileSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "a", "()V", "next", "()Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", "()Z", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "b", "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "c", "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V", "nextItem", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class TakeWhileSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    private final Iterator iterator;

    /* renamed from: b, reason: from kotlin metadata */
    private int nextState;

    /* renamed from: c, reason: from kotlin metadata */
    private Object nextItem;
    final /* synthetic */ TakeWhileSequence d;

    TakeWhileSequence$iterator$1(TakeWhileSequence takeWhileSequence) {
        Sequence sequence;
        this.d = takeWhileSequence;
        sequence = takeWhileSequence.sequence;
        this.iterator = sequence.getA();
        this.nextState = -1;
    }

    private final void a() {
        Function1 function1;
        if (this.iterator.hasNext()) {
            Object next = this.iterator.next();
            function1 = this.d.predicate;
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                this.nextState = 1;
                this.nextItem = next;
                return;
            }
        }
        this.nextState = 0;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState == -1) {
            a();
        }
        return this.nextState == 1;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (this.nextState == -1) {
            a();
        }
        if (this.nextState == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.nextItem;
        this.nextItem = null;
        this.nextState = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
