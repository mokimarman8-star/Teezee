package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.h;
import v3.m;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    static void a(h.c cVar) {
        if (Build.VERSION.SDK_INT < 24) {
            cVar.a(13, (Object) null);
        } else {
            Process.sendSignal(Process.myPid(), 10);
            cVar.a(12, (Object) null);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            h.k(context, new m(), new a(this), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if ("WRITE_SKIP_FILE".equals(string)) {
                    h.l(context, new m(), new a(this));
                    return;
                } else {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        h.c(context, new m(), new a(this));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            a(new a(this));
            return;
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        a aVar = new a(this);
        if ("DROP_SHADER_CACHE".equals(string2)) {
            a.b(context, aVar);
        } else {
            aVar.a(16, (Object) null);
        }
    }
}
