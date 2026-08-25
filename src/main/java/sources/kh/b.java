package kh;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tn.tranpay.device.TNDeviceHelper;
import kh.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
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
        String simpleName = b.class.getSimpleName();
        this.a = simpleName;
        if (context instanceof Application) {
            this.b = context;
        } else {
            this.b = context.getApplicationContext();
        }
        try {
            if (context.bindService(intent, this, 1)) {
                return;
            }
            lh.a aVar = lh.a.a;
            Intrinsics.g(simpleName, "TAG");
            aVar.b("Service binding failed", simpleName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ b(Context context, Intent intent, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, intent);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0042 -> B:8:0x0053). Please report as a decompilation issue!!! */
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Intrinsics.h(componentName, "name");
        Intrinsics.h(iBinder, "service");
        try {
            try {
                try {
                    String id = a.AbstractBinderC0053a.X0(iBinder).getId();
                    TNDeviceHelper tNDeviceHelper = TNDeviceHelper.a;
                    Intrinsics.g(id, "oaid");
                    tNDeviceHelper.h(id);
                    String str = this.a;
                    Intrinsics.g(str, "TAG");
                    lh.a.a.b("onServiceConnected oaid=" + id, str);
                    Context context = this.b;
                    if (context != null) {
                        context.unbindService(this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.h(componentName, "name");
    }
}
