package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class s {

    public static class a {
        public static final a b = new a(Utils.a().getPackageName(), Utils.a().getPackageName(), 3);
        private NotificationChannel a;

        public a(String str, CharSequence charSequence, int i) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.a = m.f.a(str, charSequence, i);
            }
        }

        public NotificationChannel b() {
            return this.a;
        }
    }

    public static Notification a(a aVar, Utils$b utils$b) {
        String id;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            m.c.a((NotificationManager) Utils.a().getSystemService("notification"), aVar.b());
        }
        NotificationCompat.m mVar = new NotificationCompat.m(Utils.a());
        if (i >= 26) {
            id = aVar.a.getId();
            mVar.n(id);
        }
        if (utils$b != null) {
            utils$b.accept(mVar);
        }
        return mVar.c();
    }
}
