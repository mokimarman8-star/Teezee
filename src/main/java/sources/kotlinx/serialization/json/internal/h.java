package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h {
    public static final h a = new h();
    private static final ArrayDeque b = new ArrayDeque();
    private static int c;
    private static final int d;

    static {
        Object obj;
        try {
            Result$Companion result$Companion = Result.Companion;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.g(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            obj = Result.constructor-impl(StringsKt.v(property));
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        d = num != null ? num.intValue() : 1048576;
    }

    private h() {
    }

    public final void a(char[] array) {
        Intrinsics.h(array, "array");
        synchronized (this) {
            try {
                int i = c;
                if (array.length + i < d) {
                    c = i + array.length;
                    b.addLast(array);
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final char[] b() {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) b.q();
            if (cArr != null) {
                c -= cArr.length;
            } else {
                cArr = null;
            }
        }
        return cArr == null ? new char[128] : cArr;
    }
}
