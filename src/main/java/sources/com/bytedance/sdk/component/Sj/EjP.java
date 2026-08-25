package com.bytedance.sdk.component.Sj;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class EjP<P, R> extends com.bytedance.sdk.component.Sj.sP<P, R> {
    private boolean Sj = true;
    private vS TKC;
    private Sj sP;

    interface Sj {
        void Sj(Object obj);

        void Sj(Throwable th);
    }

    public interface sP {
        EjP Sj();
    }

    private boolean vS() {
        if (this.Sj) {
            return true;
        }
        uA.Sj(new IllegalStateException("Jsb async call already finished: " + Sj() + ", hashcode: " + hashCode()));
        return false;
    }

    protected void EjP() {
        this.Sj = false;
        this.TKC = null;
    }

    void HiB() {
        EjP();
    }

    @Override // com.bytedance.sdk.component.Sj.sP
    public /* bridge */ /* synthetic */ String Sj() {
        return super.Sj();
    }

    protected final void Sj(R r) {
        if (vS()) {
            this.sP.Sj(r);
            EjP();
        }
    }

    protected abstract void Sj(P p, vS vSVar) throws Exception;

    void Sj(P p, vS vSVar, Sj sj) throws Exception {
        this.TKC = vSVar;
        this.sP = sj;
        Sj(p, vSVar);
    }

    protected final void Sj(Throwable th) {
        if (vS()) {
            this.sP.Sj(th);
            EjP();
        }
    }

    protected final void TKC() {
        Sj((Throwable) null);
    }
}
