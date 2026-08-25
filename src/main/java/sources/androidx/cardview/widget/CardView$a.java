package androidx.cardview.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class CardView$a implements b {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f1222a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CardView f1223b;

    CardView$a(CardView cardView) {
        this.f1223b = cardView;
    }

    @Override // androidx.cardview.widget.b
    public void a(int i5, int i6, int i7, int i8) {
        this.f1223b.f.set(i5, i6, i7, i8);
        CardView cardView = this.f1223b;
        Rect rect = cardView.e;
        CardView.a(cardView, i5 + rect.left, i6 + rect.top, i7 + rect.right, i8 + rect.bottom);
    }

    @Override // androidx.cardview.widget.b
    public void b(Drawable drawable) {
        this.f1222a = drawable;
        this.f1223b.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.b
    public boolean c() {
        return this.f1223b.getUseCompatPadding();
    }

    @Override // androidx.cardview.widget.b
    public Drawable d() {
        return this.f1222a;
    }

    @Override // androidx.cardview.widget.b
    public boolean e() {
        return this.f1223b.getPreventCornerOverlap();
    }

    @Override // androidx.cardview.widget.b
    public View f() {
        return this.f1223b;
    }
}
