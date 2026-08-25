package qn;

import androidx.media3.common.f0;
import androidx.media3.common.i0;
import androidx.media3.common.r;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {
    public static final f0 a(i0 i0Var, d dVar) {
        Intrinsics.h(i0Var, "<this>");
        Intrinsics.h(dVar, "mediaTrackGroup");
        r4 it = i0Var.a().iterator();
        Intrinsics.g(it, "iterator(...)");
        while (it.hasNext()) {
            i0.a aVar = (i0.a) it.next();
            if (Intrinsics.c(aVar.a().b, dVar.c()) && aVar.a().c == dVar.e()) {
                return aVar.a();
            }
        }
        return null;
    }

    public static final b b(r rVar) {
        Intrinsics.h(rVar, "<this>");
        return new b(rVar.a, rVar.b, rVar.d, rVar.e, rVar.h, rVar.i, rVar.j, rVar.k, rVar.v, rVar.w, rVar.x, rVar.y, rVar.z);
    }

    public static final c c(i0 i0Var) {
        Intrinsics.h(i0Var, "<this>");
        if (i0Var.b()) {
            return new c(null, 1, null);
        }
        int size = i0Var.a().size();
        d[] dVarArr = new d[size];
        for (int i = 0; i < size; i++) {
            Object obj = i0Var.a().get(i);
            Intrinsics.g(obj, "get(...)");
            dVarArr[i] = d((i0.a) obj);
        }
        ImmutableList copyOf = ImmutableList.copyOf(dVarArr);
        Intrinsics.g(copyOf, "copyOf(...)");
        return new c(copyOf);
    }

    public static final d d(i0.a aVar) {
        Intrinsics.h(aVar, "<this>");
        int i = aVar.a;
        b[] bVarArr = new b[i];
        for (int i2 = 0; i2 < i; i2++) {
            r b = aVar.b(i2);
            Intrinsics.g(b, "getTrackFormat(...)");
            bVarArr[i2] = b(b);
        }
        return new d(aVar.a, aVar.a().b, aVar.a().c, aVar.e(), bVarArr);
    }
}
