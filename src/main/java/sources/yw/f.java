package yw;

import android.text.format.Formatter;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    private final String a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final long e;
    private final long f;

    public f(String path, String state, boolean z, boolean z2) {
        long j;
        Intrinsics.h(path, "path");
        Intrinsics.h(state, "state");
        this.a = path;
        this.b = state;
        this.c = z;
        this.d = z2;
        long j2 = 0;
        try {
            j = n.k(path);
        } catch (Throwable unused) {
            j = 0;
        }
        this.e = j;
        try {
            j2 = n.j(path);
        } catch (Throwable unused2) {
        }
        this.f = j2;
    }

    public final long a() {
        return this.f;
    }

    public final String b() {
        return this.a;
    }

    public final boolean c() {
        return this.c;
    }

    public String toString() {
        return "SDCardInfo {path = " + this.a + ", state = " + this.b + ", isRemovable = " + this.c + ", isEmulated = " + this.d + ", totalSize = " + Formatter.formatFileSize(Utils.a(), this.e) + ", availableSize = " + Formatter.formatFileSize(Utils.a(), this.f) + "}";
    }
}
