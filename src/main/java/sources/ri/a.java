package ri;

import android.database.Cursor;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(d dVar, String str, String str2) {
        Cursor m0 = dVar.m0("PRAGMA table_info(" + str + ")");
        try {
            int columnIndex = m0.getColumnIndex("name");
            if (columnIndex < 0) {
                CloseableKt.a(m0, (Throwable) null);
                return false;
            }
            while (m0.moveToNext()) {
                if (Intrinsics.c(m0.getString(columnIndex), str2)) {
                    CloseableKt.a(m0, (Throwable) null);
                    return true;
                }
            }
            Unit unit = Unit.a;
            CloseableKt.a(m0, (Throwable) null);
            return false;
        } finally {
        }
    }
}
