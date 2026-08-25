package kotlin.sequences;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt___SequencesKt$minus$2;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$2", "Lkotlin/sequences/Sequence;", HttpUrl.FRAGMENT_ENCODE_SET, "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SequencesKt___SequencesKt$minus$2 implements Sequence<Object> {
    final /* synthetic */ Sequence a;
    final /* synthetic */ Object[] b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(Object[] objArr, Object obj) {
        return ArraysKt.L(objArr, obj);
    }

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getA() {
        Sequence sequence = this.a;
        final Object[] objArr = this.b;
        return SequencesKt___SequencesKt.q(sequence, new Function1() { // from class: ly.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean c;
                c = SequencesKt___SequencesKt$minus$2.c(objArr, obj);
                return Boolean.valueOf(c);
            }
        }).getA();
    }
}
