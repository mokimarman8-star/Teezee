package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class u1 extends JobSupport implements z {
    private final boolean a;

    public u1(t1 t1Var) {
        super(true);
        initParentJob(t1Var);
        this.a = U();
    }

    private final boolean U() {
        JobSupport t;
        t parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        u uVar = parentHandle$kotlinx_coroutines_core instanceof u ? (u) parentHandle$kotlinx_coroutines_core : null;
        if (uVar != null && (t = uVar.t()) != null) {
            while (!t.getHandlesException$kotlinx_coroutines_core()) {
                t parentHandle$kotlinx_coroutines_core2 = t.getParentHandle$kotlinx_coroutines_core();
                u uVar2 = parentHandle$kotlinx_coroutines_core2 instanceof u ? (u) parentHandle$kotlinx_coroutines_core2 : null;
                if (uVar2 != null && (t = uVar2.t()) != null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.z
    public boolean b(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new b0(th, false, 2, null));
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.a;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
