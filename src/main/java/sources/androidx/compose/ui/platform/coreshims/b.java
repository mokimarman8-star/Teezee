package androidx.compose.ui.platform.coreshims;

import android.view.autofill.AutofillId;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Object f4749a;

    private b(AutofillId autofillId) {
        this.f4749a = autofillId;
    }

    public static b b(AutofillId autofillId) {
        return new b(autofillId);
    }

    public AutofillId a() {
        return a.a(this.f4749a);
    }
}
