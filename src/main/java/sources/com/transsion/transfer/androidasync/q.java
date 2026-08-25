package com.transsion.transfer.androidasync;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class q implements p {
    private boolean a;
    st.a b;
    st.d c;

    @Override // com.transsion.transfer.androidasync.p
    public void F(st.d dVar) {
        this.c = dVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public st.d G() {
        return this.c;
    }

    public final st.a L() {
        return this.b;
    }

    protected void M(Exception exc) {
        if (this.a) {
            return;
        }
        this.a = true;
        if (L() != null) {
            L().g(exc);
        }
    }

    @Override // com.transsion.transfer.androidasync.p
    public final void h(st.a aVar) {
        this.b = aVar;
    }

    @Override // com.transsion.transfer.androidasync.p
    public String s() {
        return null;
    }
}
