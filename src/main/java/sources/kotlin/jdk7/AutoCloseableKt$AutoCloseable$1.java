package kotlin.jdk7;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class AutoCloseableKt$AutoCloseable$1 implements AutoCloseable {
    final /* synthetic */ Function0 a;

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.a.invoke();
    }
}
