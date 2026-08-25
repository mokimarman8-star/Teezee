package com.transsion.sdk.oneid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class d implements ServiceConnection {
    private final Context a;
    private final Handler.Callback b;
    private Messenger c;
    private final Messenger d = new Messenger((Handler) new a(this));

    public d(Context context, Handler.Callback callback) {
        this.a = context;
        this.b = callback;
    }

    static void c(d dVar) {
        dVar.getClass();
        try {
            if (dVar.c != null) {
                dVar.c = null;
                dVar.a.unbindService(dVar);
            }
        } catch (Exception e) {
            b.m(Log.getStackTraceString(e));
        }
    }

    public void b() {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.hoffnung", "com.transsion.dataservice.binder.DCService");
            this.a.bindService(intent, this, 1);
        } catch (Exception e) {
            b.m(Log.getStackTraceString(e));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b.i("onServiceConnected");
        try {
            Message obtain = Message.obtain((Handler) null, 100);
            Bundle bundle = new Bundle();
            bundle.putString("key", "oneid");
            obtain.setData(bundle);
            obtain.replyTo = this.d;
            Messenger messenger = new Messenger(iBinder);
            this.c = messenger;
            messenger.send(obtain);
        } catch (Exception e) {
            b.m(Log.getStackTraceString(e));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        b.i("onServiceDisconnected");
    }
}
