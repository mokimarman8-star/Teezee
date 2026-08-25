package kotlin.sequences;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR&\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlin/sequences/TransformingIndexedSequence;", "T", "R", "Lkotlin/sequences/Sequence;", HttpUrl.FRAGMENT_ENCODE_SET, "iterator", "()Ljava/util/Iterator;", "a", "Lkotlin/sequences/Sequence;", "sequence", "Lkotlin/Function2;", HttpUrl.FRAGMENT_ENCODE_SET, "b", "Lkotlin/jvm/functions/Function2;", "transformer", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class TransformingIndexedSequence<T, R> implements Sequence<R> {

    /* renamed from: a, reason: from kotlin metadata */
    private final Sequence sequence;

    /* renamed from: b, reason: from kotlin metadata */
    private final Function2 transformer;

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getA() {
        return new TransformingIndexedSequence$iterator$1(this);
    }
}
