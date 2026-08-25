package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.z;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class g {
    private static final z a = new z("NO_OWNER");
    private static final z b = new z("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z) {
        return new f(z);
    }

    public static /* synthetic */ a b(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(z);
    }
}
