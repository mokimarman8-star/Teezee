package androidx.collection;

import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d {
    public static final void a(b bVar, int i5) {
        Intrinsics.h(bVar, "<this>");
        bVar.m(new int[i5]);
        bVar.l(new Object[i5]);
    }

    public static final int b(b bVar, int i5) {
        Intrinsics.h(bVar, "<this>");
        try {
            return n.a.a(bVar.e(), bVar.i(), i5);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(b bVar, Object obj, int i5) {
        Intrinsics.h(bVar, "<this>");
        int i6 = bVar.i();
        if (i6 == 0) {
            return -1;
        }
        int b5 = b(bVar, i5);
        if (b5 < 0 || Intrinsics.c(obj, bVar.c()[b5])) {
            return b5;
        }
        int i7 = b5 + 1;
        while (i7 < i6 && bVar.e()[i7] == i5) {
            if (Intrinsics.c(obj, bVar.c()[i7])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = b5 - 1; i8 >= 0 && bVar.e()[i8] == i5; i8--) {
            if (Intrinsics.c(obj, bVar.c()[i8])) {
                return i8;
            }
        }
        return ~i7;
    }

    public static final int d(b bVar) {
        Intrinsics.h(bVar, "<this>");
        return c(bVar, null, 0);
    }
}
