package kotlin.sequences;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"kotlin/sequences/TransformingIndexedSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, "next", "()Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", "()Z", "a", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "b", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class TransformingIndexedSequence$iterator$1<R> implements Iterator<R>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    private final Iterator iterator;

    /* renamed from: b, reason: from kotlin metadata */
    private int index;
    final /* synthetic */ TransformingIndexedSequence c;

    TransformingIndexedSequence$iterator$1(TransformingIndexedSequence transformingIndexedSequence) {
        Sequence sequence;
        this.c = transformingIndexedSequence;
        sequence = transformingIndexedSequence.sequence;
        this.iterator = sequence.getA();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Function2 function2;
        function2 = this.c.transformer;
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            CollectionsKt.u();
        }
        return function2.invoke(Integer.valueOf(i), this.iterator.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
