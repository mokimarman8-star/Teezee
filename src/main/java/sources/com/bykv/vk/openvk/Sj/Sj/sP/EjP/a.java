package com.bykv.vk.openvk.Sj.Sj.sP.EjP;

import com.bykv.vk.openvk.Sj.Sj.sP.EjP.b;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class a implements b {
    private b.InterfaceC0014b a;
    private b.f b;
    private b.d c;
    private b.g d;
    private b.c e;
    private b.e f;
    private b.a g;
    protected boolean h = false;

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public void Sj(boolean z) {
        this.h = z;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void a(b.g gVar) {
        this.d = gVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void b(b.d dVar) {
        this.c = dVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void c(b.a aVar) {
        this.g = aVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void d(b.f fVar) {
        this.b = fVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void e(b.e eVar) {
        this.f = eVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void h(b.c cVar) {
        this.e = cVar;
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.EjP.b
    public final void j(b.InterfaceC0014b interfaceC0014b) {
        this.a = interfaceC0014b;
    }

    protected final void k() {
        try {
            b.g gVar = this.d;
            if (gVar != null) {
                gVar.TKC(this);
            }
        } catch (Throwable unused) {
        }
    }

    public void l() {
        this.a = null;
        this.c = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    protected final void m(int i) {
        try {
            b.d dVar = this.c;
            if (dVar != null) {
                dVar.Sj(this, i);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void n(int i, int i2, int i3, int i4) {
        try {
            b.c cVar = this.e;
            if (cVar != null) {
                cVar.Sj(this, i, i2, i3, i4);
            }
        } catch (Throwable unused) {
        }
    }

    protected final boolean o(int i, int i2) {
        try {
            b.e eVar = this.f;
            if (eVar != null) {
                if (eVar.Sj(this, i, i2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    protected final void p() {
        try {
            b.f fVar = this.b;
            if (fVar != null) {
                fVar.Sj(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void q() {
        try {
            b.InterfaceC0014b interfaceC0014b = this.a;
            if (interfaceC0014b != null) {
                interfaceC0014b.sP(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final boolean r(int i, int i2) {
        try {
            b.a aVar = this.g;
            if (aVar != null) {
                if (aVar.sP(this, i, i2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
