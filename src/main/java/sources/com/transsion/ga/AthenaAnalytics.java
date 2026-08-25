package com.transsion.ga;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.api.o1;
import com.tencent.mmkv.MMKV;
import com.transsion.athena.aidl.AthenaTrackService;
import com.transsion.athena.attribution.ReferrerTask;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.TrackDataWrapper;
import com.transsion.athena.enatha.athena;
import com.transsion.athena.enatha.enatha;
import com.transsion.athena.taaneh.aatnhe;
import com.transsion.athena.taaneh.aethna;
import com.transsion.athena.taaneh.anehat;
import com.transsion.athena.taaneh.ehatna;
import com.transsion.core.log.ObjectLogUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class AthenaAnalytics {
    private static volatile AthenaAnalytics h;
    private static List n;
    private static athena o;
    public static int p;
    private static boolean q;
    private static boolean r;
    private athena a;
    private com.transsion.athena.athena c;
    private boolean d;
    private static b f = new b() { // from class: com.transsion.ga.b
        public final String a(String str) {
            String i2;
            i2 = AthenaAnalytics.i(str);
            return i2;
        }
    };
    private static volatile int g = 1;
    private static long i = 0;
    private static volatile int j = -1;
    private static volatile long k = 0;
    private static String l = null;
    private static Context m = null;
    ExecutorService b = null;
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();

    private AthenaAnalytics() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, TrackData trackData, long j2) {
        try {
            if (this.c == null || !this.d) {
                if (V()) {
                    x(str, trackData, j2);
                } else if (this.e.size() < 100) {
                    this.e.add(new TrackDataWrapper(str, trackData, j2));
                }
            } else if (trackData.c() < 524288) {
                this.b.submit((Runnable) new a(this, str, trackData, j2));
            } else {
                aethna.b("TrackByAidl trackData size is too large, ignored !!");
            }
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
    }

    private static boolean B() {
        return m.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") == 0;
    }

    private athena C() {
        athena a;
        if (this.a == null && m != null) {
            if (g == 2 && !anehat.c(m)) {
                g = 1;
            }
            Context context = m;
            int i2 = g;
            if (i2 != 1) {
                if (i2 == 2) {
                    a = com.transsion.athena.enatha.aethna.a(context);
                } else if (i2 != 3) {
                    a = null;
                }
                this.a = a;
            }
            a = enatha.a(context);
            this.a = a;
        }
        return this.a;
    }

    public static void D(boolean z) {
        athena C;
        ehanat.d(z);
        if (h == null) {
            aethna.a("Init method not called.");
        } else {
            if (j != 0 || (C = h.C()) == null || z) {
                return;
            }
            C.a();
        }
    }

    static void E() {
        if ((g == 3 || F()) && j == 0) {
            com.transsion.athena.hatnea.athena.a().b();
        }
    }

    private static boolean F() {
        return (m == null || h == null || !ehanat.r()) ? false : true;
    }

    public static String G(Context context) {
        return ehatna.a();
    }

    public static String H(Context context, boolean z) {
        return z ? ehatna.b(context) : ehatna.a();
    }

    public static a I() {
        return null;
    }

    public static Context J() {
        return m;
    }

    public static AthenaAnalytics K(int i2) {
        return L(i2);
    }

    public static AthenaAnalytics L(long j2) {
        if (h == null) {
            synchronized (AthenaAnalytics.class) {
                try {
                    if (h == null) {
                        h = new AthenaAnalytics();
                        if (j == 0) {
                            athena C = h.C();
                            Handler handler = new Handler(Looper.getMainLooper());
                            w(C);
                            C.a(new aethna(C, (athena) null), 3000L);
                            z(C);
                            m(handler);
                            handler.postDelayed(new anehat(handler, (athena) null), 3600000L);
                            u(C);
                        } else {
                            AthenaAnalytics athenaAnalytics = h;
                            Context context = m;
                            athenaAnalytics.getClass();
                            try {
                                aethna.c("AthenaAnalytics bindTrackService");
                                Intent intent = new Intent(context, (Class<?>) AthenaTrackService.class);
                                intent.setPackage(context.getApplicationInfo().packageName);
                                context.bindService(intent, (ServiceConnection) new g(athenaAnalytics), 1);
                            } catch (Exception e) {
                                aethna.b(Log.getStackTraceString(e));
                            }
                        }
                    }
                } finally {
                }
            }
        }
        if (anehat.b(j2)) {
            int i2 = (int) j2;
            if (j == 0 && com.transsion.athena.data.athena.a(i2)) {
                Message message = new Message();
                message.what = 400;
                message.arg1 = i2;
                h.C().a(message, 0L);
            } else if (j == 1 && com.transsion.athena.data.athena.a(i2)) {
                aethna.a("multi process appid " + i2 + " register successful");
            }
        }
        return h;
    }

    public static b M() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N() {
        aatnhe.e(m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O() {
        if (k > 0) {
            AthenaAnalytics athenaAnalytics = h;
            athenaAnalytics.getClass();
            if (!F()) {
                aethna.a("Athena SDK isAthenaEnable = false");
                return;
            }
            Iterator it = com.transsion.athena.data.athena.a().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (num.intValue() != 9999) {
                    athenaAnalytics.g0("app_launch", null, num.intValue());
                }
            }
        }
    }

    public static void P(Context context, String str, int i2, boolean z) {
        Q(context, str, i2, z, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void Q(Context context, String str, int i2, boolean z, boolean z2) {
        int i3;
        String str2;
        if (context == null || i2 < 1000 || i2 > 9999) {
            throw new IllegalArgumentException("The parameter is illegal.");
        }
        if (m == null) {
            m = context.getApplicationContext();
        }
        ehanat.c(z);
        ehanat.a(str, z2);
        boolean z3 = false;
        if (z2) {
            com.transsion.athena.data.athena.b(i2);
            l(i2, false);
        }
        i.b(m);
        if (j == -1) {
            String str3 = l;
            try {
                try {
                    str2 = context.getApplicationContext().getApplicationInfo().processName;
                } catch (Exception e) {
                    ObjectLogUtils objectLogUtils = aethna.a;
                    aethna.b(Log.getStackTraceString(e));
                    str2 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = str2;
                }
                i3 = TextUtils.equals(str3, com.transsion.athena.taaneh.athena.d(context));
            } catch (Exception unused) {
                i3 = 1;
            }
            j = i3 ^ 1;
            if (j == 0 && p == 0 && ehanat.K) {
                p = new Random().nextInt(601) + 300;
            }
        }
        K(9999);
        K(i2);
        ehatna.a(context, i2, p);
        int i4 = anehat.e;
        try {
            int i6 = MMKV.j;
            z3 = true;
        } catch (ClassNotFoundException unused2) {
        }
        r = z3;
    }

    public static boolean R() {
        return Build.VERSION.SDK_INT >= 29 ? ehanat.J && B() : ehanat.F && y();
    }

    public static boolean S() {
        return g == 3;
    }

    public static boolean T() {
        return Build.VERSION.SDK_INT >= 29 ? ehanat.G && B() : ehanat.C && y();
    }

    public static boolean U() {
        return Build.VERSION.SDK_INT >= 29 ? ehanat.H && B() : ehanat.D && y();
    }

    public static boolean V() {
        return q && r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(19:6|(1:8)|9|(1:11)|12|(1:14)|15|(2:16|17)|(3:19|20|(2:23|21))|24|25|26|(1:28)(1:65)|29|30|31|(3:35|(4:38|(2:43|(3:48|49|50))(3:54|55|56)|51|36)|58)|60|61) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010c, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0128, code lost:
    
        com.transsion.athena.taaneh.aethna.b(r1.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a4, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00a5, code lost:
    
        com.transsion.athena.taaneh.aethna.b(r5.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec A[Catch: Exception -> 0x010c, TryCatch #1 {Exception -> 0x010c, blocks: (B:31:0x00cc, B:33:0x00dc, B:35:0x00e2, B:36:0x00e6, B:38:0x00ec, B:40:0x00f8, B:55:0x00fe, B:43:0x010e, B:46:0x0114, B:49:0x011a), top: B:30:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void W() {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ga.AthenaAnalytics.W():void");
    }

    static void X() {
        if (j != 0 || h == null || h.C() == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 600;
        h.C().a(obtain, 100L);
    }

    public static void Y(int i2) {
        if (m == null) {
            throw new RuntimeException("init Athena SDK first!");
        }
        int i3 = anehat.e;
        try {
            K(i2).C().a((Runnable) ReferrerTask.class.getConstructor(Context.class, Integer.TYPE).newInstance(m, Integer.valueOf(i2)), 3000L);
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = aethna.a;
            aethna.b(Log.getStackTraceString(e));
        }
    }

    public static void Z(short s, String str) {
        ehanat.a(s, str);
    }

    public static void a0(int i2, String str) {
        if (i2 < 1000 || i2 > 9999) {
            aethna.b("appId %d is illegal", new Object[]{Integer.valueOf(i2)});
        } else if (TextUtils.isEmpty(str)) {
            aethna.b("sdkVersion can not be null or empty");
        } else {
            ehanat.a(i2, str);
        }
    }

    public static void b0(boolean z) {
        ehanat.c(z);
        if (j == 0) {
            if (h == null) {
                aethna.a("Init method not called.");
                return;
            }
            athena C = h.C();
            if (C != null) {
                C.a(new athena(z));
            }
        }
    }

    public static void c0(int i2) {
        athena C;
        if (j != 0 || (C = h.C()) == null) {
            return;
        }
        C.a(i2);
    }

    public static void d0(boolean z) {
        ehanat.f(z);
    }

    public static void e0(int i2) {
        g = i2;
    }

    public static void f0() {
        if (h != null) {
            AthenaAnalytics athenaAnalytics = h;
            athenaAnalytics.getClass();
            if ((g == 3 || F()) && j == 0 && athenaAnalytics.C() != null) {
                athenaAnalytics.C().e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String i(String str) {
        return str;
    }

    private static void l(long j2, boolean z) {
        if (m == null) {
            return;
        }
        if (k == 0 || z) {
            k = j2;
        }
        athena athenaVar = o;
        if (athenaVar != null) {
            athenaVar.d(k);
            return;
        }
        athena athenaVar2 = new athena();
        o = athenaVar2;
        athenaVar2.d(k);
        ((Application) m).registerActivityLifecycleCallbacks(o);
    }

    private static void m(Handler handler) {
        handler.postDelayed(new c(), 6000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(athena athenaVar) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            if (Build.VERSION.SDK_INT >= 33) {
                o1.a(m, new h(), intentFilter, (String) null, athenaVar.b(), 4);
            } else {
                m.registerReceiver(new h(), intentFilter, null, athenaVar.b());
            }
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(String str, TrackData trackData, long j2) {
        try {
            this.c.a(str, trackData, j2);
            aethna.a(String.format(Locale.getDefault(), "TrackByAidl tid : %d, eventName : %s", Long.valueOf(j2), str));
        } catch (RemoteException e) {
            aethna.b("TrackByAidl " + e.getMessage());
        }
    }

    static boolean r(Class cls) {
        List list;
        return (cls == null || (list = n) == null || !list.contains(Integer.valueOf(cls.hashCode()))) ? false : true;
    }

    public static void s(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        ehanat.d(str, obj);
    }

    private static void u(athena athenaVar) {
        athenaVar.a(new f());
    }

    private void v(String str, TrackData trackData, long j2) {
        if (j == 0 || g == 2) {
            C().a(str, trackData, j2);
            return;
        }
        if (m != null) {
            String str2 = ehanat.h;
            try {
                if (!TextUtils.isEmpty("")) {
                    trackData.a().put("scode", "");
                }
                if (this.b == null) {
                    this.b = Executors.newSingleThreadExecutor();
                }
                A(str, trackData, j2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void w(athena athenaVar) {
        athenaVar.a(new d(athenaVar));
    }

    private static void x(String str, TrackData trackData, long j2) {
        try {
            if (trackData.c() > 524288) {
                aethna.b("TrackData size is too large, ignored !!");
                return;
            }
            MMKV.J("AthenaKV", 2).u(Process.myPid() + "_" + j2 + "_" + str + "_" + System.currentTimeMillis(), new TrackDataWrapper(str, trackData, j2));
            aethna.a(String.format(Locale.getDefault(), "SaveToMMKV tid : %d, eventName : %s", Long.valueOf(j2), str));
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
    }

    private static boolean y() {
        return m.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    private static void z(athena athenaVar) {
        athenaVar.a(new e(), 6000L);
    }

    public void g0(String str, TrackData trackData, int i2) {
        h0(str, trackData, i2);
    }

    public void h0(String str, TrackData trackData, long j2) {
        int i2 = anehat.e;
        int length = String.valueOf(j2).length();
        if ((length != 8 && length != 12 && length != 4) || TextUtils.isEmpty(str)) {
            aethna.a("The parameter tid : " + j2 + " or event name : " + str + " is illegal.");
            return;
        }
        if (!com.transsion.athena.data.athena.a(j2)) {
            aethna.a("The tid " + j2 + " is not belong the app");
            return;
        }
        try {
            if (trackData != null) {
                v(str, trackData, j2);
            } else {
                v(str, new TrackData(), j2);
            }
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
    }

    void k(int i2, long j2) {
        if (F() && j == 0 && C() != null) {
            Message message = new Message();
            message.what = i2;
            C().a(message, j2);
        }
    }
}
