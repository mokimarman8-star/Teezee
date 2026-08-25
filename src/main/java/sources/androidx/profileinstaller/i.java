package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class i implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f12660a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12661b;

    public /* synthetic */ i(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f12660a = profileInstallerInitializer;
        this.f12661b = context;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j5) {
        ProfileInstallerInitializer.e(this.f12660a, this.f12661b, j5);
    }
}
