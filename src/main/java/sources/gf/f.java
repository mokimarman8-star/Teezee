package gf;

import com.permissionx.guolindev.dialog.RationaleDialog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class f {
    private final o0 a;
    private final e b;

    public f(o0 o0Var, e eVar) {
        Intrinsics.h(o0Var, "pb");
        Intrinsics.h(eVar, "chainTask");
        this.a = o0Var;
        this.b = eVar;
    }

    public final void a(List list) {
        Intrinsics.h(list, "permissions");
        this.a.l(list);
    }

    public final void b(List list) {
        Intrinsics.h(list, "permissions");
        this.b.a(list);
    }

    public final void c(List list, ff.a aVar) {
        Intrinsics.h(list, "permissions");
        Intrinsics.h(aVar, "dialogInfo");
        this.a.O(this.b, false, list, aVar);
    }

    public final void d(RationaleDialog rationaleDialog) {
        Intrinsics.h(rationaleDialog, "dialog");
        this.a.N(this.b, true, rationaleDialog);
    }

    public final void e(List list, ff.a aVar) {
        Intrinsics.h(list, "permissions");
        Intrinsics.h(aVar, "dialogInfo");
        this.a.O(this.b, true, list, aVar);
    }
}
