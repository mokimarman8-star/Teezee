package androidx.media3.exoplayer.util;

import androidx.media3.common.util.m;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract /* synthetic */ class b {

    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f11712a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f11713b;

        a(Executor executor, m mVar) {
            this.f11712a = executor;
            this.f11713b = mVar;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f11712a.execute(runnable);
        }

        @Override // androidx.media3.exoplayer.util.c
        public void release() {
            this.f11713b.accept(this.f11712a);
        }
    }

    public static c a(Executor executor, m mVar) {
        return new a(executor, mVar);
    }
}
