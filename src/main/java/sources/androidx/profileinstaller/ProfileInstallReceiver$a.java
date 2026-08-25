package androidx.profileinstaller;

import androidx.profileinstaller.h;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ProfileInstallReceiver$a implements h.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProfileInstallReceiver f12631a;

    ProfileInstallReceiver$a(ProfileInstallReceiver profileInstallReceiver) {
        this.f12631a = profileInstallReceiver;
    }

    @Override // androidx.profileinstaller.h.c
    public void a(int i5, Object obj) {
        h.f12659b.a(i5, obj);
        this.f12631a.setResultCode(i5);
    }

    @Override // androidx.profileinstaller.h.c
    public void b(int i5, Object obj) {
        h.f12659b.b(i5, obj);
    }
}
