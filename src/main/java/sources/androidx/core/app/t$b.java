package androidx.core.app;

import android.app.Notification;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class t$b implements t$e {

    /* renamed from: a, reason: collision with root package name */
    final String f6954a;

    /* renamed from: b, reason: collision with root package name */
    final int f6955b;

    /* renamed from: c, reason: collision with root package name */
    final String f6956c;

    /* renamed from: d, reason: collision with root package name */
    final Notification f6957d;

    t$b(String str, int i5, String str2, Notification notification) {
        this.f6954a = str;
        this.f6955b = i5;
        this.f6956c = str2;
        this.f6957d = notification;
    }

    @Override // androidx.core.app.t$e
    public void a(e.a aVar) {
        aVar.S0(this.f6954a, this.f6955b, this.f6956c, this.f6957d);
    }

    public String toString() {
        return "NotifyTask[packageName:" + this.f6954a + ", id:" + this.f6955b + ", tag:" + this.f6956c + "]";
    }
}
