package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class LayoutInflaterCompat$a implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    final LayoutInflaterFactory f7146a;

    LayoutInflaterCompat$a(LayoutInflaterFactory layoutInflaterFactory) {
        this.f7146a = layoutInflaterFactory;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f7146a.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.f7146a.onCreateView(null, str, context, attributeSet);
    }

    public String toString() {
        return getClass().getName() + "{" + this.f7146a + "}";
    }
}
