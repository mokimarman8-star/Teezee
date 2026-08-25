package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout$a;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatDelegateImpl$b implements ContentFrameLayout$a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f230a;

    AppCompatDelegateImpl$b(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f230a = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout$a
    public void a() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout$a
    public void onDetachedFromWindow() {
        this.f230a.j0();
    }
}
