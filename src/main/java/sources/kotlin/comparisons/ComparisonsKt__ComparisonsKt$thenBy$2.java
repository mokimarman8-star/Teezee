package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ComparisonsKt__ComparisonsKt$thenBy$2<T> implements Comparator {
    final /* synthetic */ Comparator<Object> $comparator;
    final /* synthetic */ Function1<T, Object> $selector;
    final /* synthetic */ Comparator<T> $this_thenBy;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$thenBy$2(Comparator<T> comparator, Comparator<Object> comparator2, Function1<? super T, Object> function1) {
        this.$this_thenBy = comparator;
        this.$comparator = comparator2;
        this.$selector = function1;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.$this_thenBy.compare(t, t2);
        if (compare != 0) {
            return compare;
        }
        Comparator<Object> comparator = this.$comparator;
        Function1<T, Object> function1 = this.$selector;
        return comparator.compare(function1.invoke(t), function1.invoke(t2));
    }
}
