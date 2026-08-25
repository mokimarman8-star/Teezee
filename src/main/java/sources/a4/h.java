package a4;

import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;
import z3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class h implements e.c {
    @Override // z3.e.c
    public e a(e.b bVar) {
        Intrinsics.h(bVar, "configuration");
        return new FrameworkSQLiteOpenHelper(bVar.f18869a, bVar.f18870b, bVar.f18871c, bVar.f18872d, bVar.f18873e);
    }
}
