package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class TrieNodeKt$filterTo$1 extends Lambda implements Function1<Object, Boolean> {
    public static final TrieNodeKt$filterTo$1 INSTANCE = new TrieNodeKt$filterTo$1();

    public TrieNodeKt$filterTo$1() {
        super(1);
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m153invoke(Object obj) {
        return Boolean.valueOf(obj != a.f2722d.a());
    }
}
