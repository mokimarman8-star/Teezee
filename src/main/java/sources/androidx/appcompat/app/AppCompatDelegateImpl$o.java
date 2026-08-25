package androidx.appcompat.app;

import android.content.IntentFilter;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class AppCompatDelegateImpl$o extends AppCompatDelegateImpl$n {

    /* renamed from: c, reason: collision with root package name */
    private final c0 f247c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f248d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppCompatDelegateImpl$o(AppCompatDelegateImpl appCompatDelegateImpl, c0 c0Var) {
        super(appCompatDelegateImpl);
        this.f248d = appCompatDelegateImpl;
        this.f247c = c0Var;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$n
    IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        return intentFilter;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$n
    public int c() {
        return this.f247c.d() ? 2 : 1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$n
    public void d() {
        this.f248d.f();
    }
}
