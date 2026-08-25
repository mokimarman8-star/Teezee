package kotlin.collections;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SlidingWindowKt$windowedSequence$$inlined$Sequence$1 implements Sequence<List<Object>> {
    final /* synthetic */ Sequence a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;
    final /* synthetic */ boolean e;

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getA() {
        return SlidingWindowKt.b(this.a.getA(), this.b, this.c, this.d, this.e);
    }
}
