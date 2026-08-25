package m1;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16486a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Violation f16487b;

    public /* synthetic */ a(String str, Violation violation) {
        this.f16486a = str;
        this.f16487b = violation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FragmentStrictMode.a(this.f16486a, this.f16487b);
    }
}
