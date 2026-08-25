package com.transsion.ad.monopoly.plan;

import com.transsion.ad.monopoly.model.AdPlans;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdPlanUtil$getHighestEcpmAdPlan$$inlined$thenBy$1<T> implements Comparator {
    final /* synthetic */ Comparator $this_thenBy;

    public AdPlanUtil$getHighestEcpmAdPlan$$inlined$thenBy$1(Comparator comparator) {
        this.$this_thenBy = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.$this_thenBy.compare(t, t2);
        return compare != 0 ? compare : ComparisonsKt.d(((AdPlans) t).getSort(), ((AdPlans) t2).getSort());
    }
}
