package lb;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    private final Bundle a = new Bundle();

    public final Bundle a() {
        return this.a;
    }

    public final void b(String str, long j) {
        Intrinsics.h(str, "key");
        this.a.putLong(str, j);
    }

    public final void c(String str, String str2) {
        Intrinsics.h(str, "key");
        Intrinsics.h(str2, "value");
        this.a.putString(str, str2);
    }
}
