package kotlin.collections;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 implements Function1<Object, Integer> {
    final /* synthetic */ Function1 a;
    final /* synthetic */ Comparable b;

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Integer invoke(Object obj) {
        return Integer.valueOf(ComparisonsKt.d((Comparable) this.a.invoke(obj), this.b));
    }
}
