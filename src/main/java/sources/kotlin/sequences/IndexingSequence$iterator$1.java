package kotlin.sequences;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"kotlin/sequences/IndexingSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/collections/IndexedValue;", "a", "()Lkotlin/collections/IndexedValue;", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", "()Z", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "b", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class IndexingSequence$iterator$1<T> implements Iterator<IndexedValue<? extends T>>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    private final Iterator iterator;

    /* renamed from: b, reason: from kotlin metadata */
    private int index;

    IndexingSequence$iterator$1(IndexingSequence indexingSequence) {
        Sequence sequence;
        sequence = indexingSequence.sequence;
        this.iterator = sequence.getA();
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IndexedValue next() {
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            CollectionsKt.u();
        }
        return new IndexedValue(i, this.iterator.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
