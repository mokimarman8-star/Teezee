package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import c.d;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class PostMessageService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private d.a f1162a = new a();

    class a extends d.a {
        a() {
        }

        @Override // c.d
        public void E0(c.a aVar, String str, Bundle bundle) {
            aVar.O0(str, bundle);
        }

        @Override // c.d
        public void n(c.a aVar, Bundle bundle) {
            aVar.R0(bundle);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f1162a;
    }
}
