package androidx.media3.exoplayer.audio;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class w0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f9918a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f9918a.post(runnable);
    }
}
