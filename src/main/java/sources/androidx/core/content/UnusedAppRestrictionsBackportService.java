package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import w0.b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private b.a f6993a = new a();

    class a extends b.a {
        a() {
        }

        @Override // w0.b
        public void I0(w0.a aVar) {
            if (aVar == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new g(aVar));
        }
    }

    protected abstract void a(g gVar);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f6993a;
    }
}
