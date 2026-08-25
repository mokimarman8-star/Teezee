package com.transsion.transfer.androidasync;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class r implements st.d {
    st.d a;
    int b;
    ByteBufferList c = new ByteBufferList();

    private boolean a(p pVar) {
        if (this.b > this.c.C()) {
            return false;
        }
        st.d dVar = this.a;
        this.a = null;
        dVar.C(pVar, this.c);
        return true;
    }

    @Override // st.d
    public void C(p pVar, ByteBufferList byteBufferList) {
        do {
            byteBufferList.g(this.c, Math.min(byteBufferList.C(), this.b - this.c.C()));
            byteBufferList.C();
            if (!a(pVar)) {
                break;
            }
        } while (this.a != null);
        byteBufferList.C();
    }

    public void b(int i, st.d dVar) {
        this.b = i;
        this.a = dVar;
        this.c.B();
    }
}
