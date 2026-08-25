package x;

import android.view.View;
import android.view.autofill.AutofillManager;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d implements g {

    /* renamed from: a, reason: collision with root package name */
    private final View f18218a;

    /* renamed from: b, reason: collision with root package name */
    private final w f18219b;

    /* renamed from: c, reason: collision with root package name */
    private final AutofillManager f18220c;

    public d(View view, w wVar) {
        this.f18218a = view;
        this.f18219b = wVar;
        AutofillManager a5 = b.a(view.getContext().getSystemService(a.a()));
        if (a5 == null) {
            throw new IllegalStateException("Autofill service could not be located.");
        }
        this.f18220c = a5;
        view.setImportantForAutofill(1);
    }

    public final AutofillManager a() {
        return this.f18220c;
    }

    public final w b() {
        return this.f18219b;
    }

    public final View c() {
        return this.f18218a;
    }
}
