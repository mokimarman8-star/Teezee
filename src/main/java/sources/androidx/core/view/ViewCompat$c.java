package androidx.core.view;

import android.text.TextUtils;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewCompat$c extends ViewCompat$f {
    ViewCompat$c(int i5, Class cls, int i6, int i7) {
        super(i5, cls, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.core.view.ViewCompat$f
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public CharSequence c(View view) {
        return ViewCompat$n.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.core.view.ViewCompat$f
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void d(View view, CharSequence charSequence) {
        ViewCompat$n.g(view, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.core.view.ViewCompat$f
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean g(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
