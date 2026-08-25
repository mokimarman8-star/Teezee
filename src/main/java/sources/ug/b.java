package ug;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ug.a;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b implements ServiceConnection {
    public static final a c = new a(null);
    private final String a;
    private Context b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Intent intent) {
            Intrinsics.h(context, "context");
            Intrinsics.h(intent, "intent");
            new b(context, intent, null);
        }
    }

    private b(Context context, Intent intent) {
        this.a = b.class.getSimpleName();
        if (context instanceof Application) {
            this.b = context;
        } else {
            this.b = context.getApplicationContext();
        }
        try {
            context.bindService(intent, this, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ b(Context context, Intent intent, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Intrinsics.h(componentName, "name");
        Intrinsics.h(iBinder, "service");
        try {
            try {
                try {
                    String id = a.AbstractBinderC0153a.X0(iBinder).getId();
                    tg.b bVar = tg.b.a;
                    Intrinsics.e(id);
                    bVar.s(id);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onServiceConnected oaid=");
                    sb.append(id);
                    Context context = this.b;
                    if (context != null) {
                        context.unbindService(this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Context context2 = this.b;
                if (context2 != null) {
                    context2.unbindService(this);
                }
            }
        } catch (Throwable th) {
            try {
                Context context3 = this.b;
                if (context3 != null) {
                    context3.unbindService(this);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.h(componentName, "name");
    }
}
