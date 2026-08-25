package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class AppCompatDelegateImpl$m extends AppCompatDelegateImpl$n {

    /* renamed from: c, reason: collision with root package name */
    private final PowerManager f242c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f243d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppCompatDelegateImpl$m(AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
        super(appCompatDelegateImpl);
        this.f243d = appCompatDelegateImpl;
        this.f242c = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$n
    IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return intentFilter;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$n
    public int c() {
        return AppCompatDelegateImpl$h.a(this.f242c) ? 2 : 1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$n
    public void d() {
        this.f243d.f();
    }
}
