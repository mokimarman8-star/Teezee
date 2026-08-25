package com.transsion.transfer.androidasync;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class n implements s {
    s a;
    boolean b;
    st.j d;
    boolean f;
    final ByteBufferList c = new ByteBufferList();
    int e = Integer.MAX_VALUE;

    public n(s sVar) {
        m(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        boolean s;
        st.j jVar;
        if (this.b) {
            return;
        }
        synchronized (this.c) {
            this.a.n(this.c);
            s = this.c.s();
        }
        if (s && this.f) {
            this.a.d();
        }
        if (!s || (jVar = this.d) == null) {
            return;
        }
        jVar.a();
    }

    @Override // com.transsion.transfer.androidasync.s
    public void B(st.j jVar) {
        this.d = jVar;
    }

    @Override // com.transsion.transfer.androidasync.s
    public AsyncServer a() {
        return this.a.a();
    }

    @Override // com.transsion.transfer.androidasync.s
    public void d() {
        if (a().o() != Thread.currentThread()) {
            a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.d();
                }
            });
            return;
        }
        synchronized (this.c) {
            try {
                if (this.c.r()) {
                    this.f = true;
                } else {
                    this.a.d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g(boolean z) {
        this.b = z;
        if (z) {
            return;
        }
        p();
    }

    public boolean h() {
        return this.c.r() || this.b;
    }

    @Override // com.transsion.transfer.androidasync.s
    public void i(st.a aVar) {
        this.a.i(aVar);
    }

    protected void j(ByteBufferList byteBufferList) {
    }

    @Override // com.transsion.transfer.androidasync.s
    public st.j k() {
        return this.d;
    }

    public int l() {
        return this.c.C();
    }

    public void m(s sVar) {
        this.a = sVar;
        sVar.B(new st.j() { // from class: com.transsion.transfer.androidasync.k
            @Override // st.j
            public final void a() {
                n.this.p();
            }
        });
    }

    @Override // com.transsion.transfer.androidasync.s
    public void n(ByteBufferList byteBufferList) {
        if (a().o() == Thread.currentThread()) {
            j(byteBufferList);
            if (!h()) {
                this.a.n(byteBufferList);
            }
            synchronized (this.c) {
                byteBufferList.f(this.c);
            }
            return;
        }
        synchronized (this.c) {
            try {
                if (this.c.C() >= this.e) {
                    return;
                }
                j(byteBufferList);
                byteBufferList.f(this.c);
                a().D(new Runnable() { // from class: com.transsion.transfer.androidasync.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.this.p();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o(int i) {
        this.e = i;
    }
}
