package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ComparisonsKt__ComparisonsKt$thenByDescending$1<T> implements Comparator {
    final /* synthetic */ Function1<T, Comparable<?>> $selector;
    final /* synthetic */ Comparator<T> $this_thenByDescending;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$thenByDescending$1(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
        this.$this_thenByDescending = comparator;
        this.$selector = function1;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int compare = this.$this_thenByDescending.compare(t, t2);
        if (compare != 0) {
            return compare;
        }
        Function1<T, Comparable<?>> function1 = this.$selector;
        return ComparisonsKt.d((Comparable) function1.invoke(t2), (Comparable) function1.invoke(t));
    }
}
