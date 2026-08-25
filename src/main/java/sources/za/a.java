package za;

import android.graphics.Typeface;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a extends f {
    private final Typeface a;
    private final InterfaceC0205a b;
    private boolean c;

    /* renamed from: za.a$a, reason: collision with other inner class name */
    public interface InterfaceC0205a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0205a interfaceC0205a, Typeface typeface) {
        this.a = typeface;
        this.b = interfaceC0205a;
    }

    private void d(Typeface typeface) {
        if (this.c) {
            return;
        }
        this.b.a(typeface);
    }

    @Override // za.f
    public void a(int i) {
        d(this.a);
    }

    @Override // za.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.c = true;
    }
}
