package y3;

import android.database.SQLException;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {
    public static final void a(b bVar, String str) {
        Intrinsics.h(bVar, "<this>");
        Intrinsics.h(str, "sql");
        e F0 = bVar.F0(str);
        try {
            F0.C0();
            AutoCloseableKt.a(F0, (Throwable) null);
        } finally {
        }
    }

    public static final Void b(int i5, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error code: " + i5);
        if (str != null) {
            sb.append(", message: " + str);
        }
        throw new SQLException(sb.toString());
    }
}
