package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ComparisonsKt__ComparisonsKt$thenComparator$1<T> implements Comparator {
    final /* synthetic */ Function2<T, T, Integer> $comparison;
    final /* synthetic */ Comparator<T> $this_thenComparator;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$thenComparator$1(Comparator<T> comparator, Function2<? super T, ? super T, Integer> function2) {
        this.$this_thenComparator = comparator;
        this.$comparison = function2;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.$this_thenComparator.compare(t, t2);
        return compare != 0 ? compare : ((Number) this.$comparison.invoke(t, t2)).intValue();
    }
}
