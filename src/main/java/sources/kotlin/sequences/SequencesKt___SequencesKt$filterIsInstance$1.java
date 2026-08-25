package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class SequencesKt___SequencesKt$filterIsInstance$1 implements Function1<Object, Boolean> {
    public static final SequencesKt___SequencesKt$filterIsInstance$1 a = new SequencesKt___SequencesKt$filterIsInstance$1();

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Object obj) {
        Intrinsics.n(3, "R");
        return Boolean.valueOf(obj instanceof Object);
    }
}
