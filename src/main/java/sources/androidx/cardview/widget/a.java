package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class a implements c {
    a() {
    }

    private d p(b bVar) {
        return (d) bVar.d();
    }

    @Override // androidx.cardview.widget.c
    public void a(b bVar, float f5) {
        p(bVar).h(f5);
    }

    @Override // androidx.cardview.widget.c
    public float b(b bVar) {
        return p(bVar).d();
    }

    @Override // androidx.cardview.widget.c
    public void c(b bVar, float f5) {
        bVar.f().setElevation(f5);
    }

    @Override // androidx.cardview.widget.c
    public float d(b bVar) {
        return p(bVar).c();
    }

    @Override // androidx.cardview.widget.c
    public ColorStateList e(b bVar) {
        return p(bVar).b();
    }

    @Override // androidx.cardview.widget.c
    public float f(b bVar) {
        return b(bVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.c
    public void g(b bVar) {
        o(bVar, d(bVar));
    }

    @Override // androidx.cardview.widget.c
    public void h(b bVar, Context context, ColorStateList colorStateList, float f5, float f6, float f7) {
        bVar.b(new d(colorStateList, f5));
        View f8 = bVar.f();
        f8.setClipToOutline(true);
        f8.setElevation(f6);
        o(bVar, f7);
    }

    @Override // androidx.cardview.widget.c
    public float i(b bVar) {
        return bVar.f().getElevation();
    }

    @Override // androidx.cardview.widget.c
    public void j(b bVar) {
        o(bVar, d(bVar));
    }

    @Override // androidx.cardview.widget.c
    public void k(b bVar) {
        if (!bVar.c()) {
            bVar.a(0, 0, 0, 0);
            return;
        }
        float d5 = d(bVar);
        float b5 = b(bVar);
        int ceil = (int) Math.ceil(e.a(d5, b5, bVar.e()));
        int ceil2 = (int) Math.ceil(e.b(d5, b5, bVar.e()));
        bVar.a(ceil, ceil2, ceil, ceil2);
    }

    @Override // androidx.cardview.widget.c
    public void l() {
    }

    @Override // androidx.cardview.widget.c
    public float m(b bVar) {
        return b(bVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.c
    public void n(b bVar, ColorStateList colorStateList) {
        p(bVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.c
    public void o(b bVar, float f5) {
        p(bVar).g(f5, bVar.c(), bVar.e());
        k(bVar);
    }
}
