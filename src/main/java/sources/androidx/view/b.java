package androidx.view;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Application f8284a;

    public b(Application application) {
        Intrinsics.h(application, "application");
        this.f8284a = application;
    }

    public Application b() {
        Application application = this.f8284a;
        Intrinsics.f(application, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return application;
    }
}
