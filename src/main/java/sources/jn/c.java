package jn;

import android.app.NotificationManager;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.blankj.utilcode.util.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a;
    private static boolean b;
    private static int c;
    private static int d;
    private static int e;
    private static volatile int f;
    private static final Lazy g;
    private static final Lazy h;

    public static final class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            c.a.d();
        }
    }

    static {
        c cVar = new c();
        a = cVar;
        b = true;
        c = 200;
        d = 100;
        e = 15;
        f = 100;
        g = LazyKt.b(new Function0() { // from class: jn.a
            public final Object invoke() {
                AudioManager i;
                i = c.i();
                return i;
            }
        });
        h = LazyKt.b(new Function0() { // from class: jn.b
            public final Object invoke() {
                NotificationManager j;
                j = c.j();
                return j;
            }
        });
        Utils.a().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, new a(new Handler()));
        e = cVar.f().getStreamMaxVolume(3);
        cVar.h();
    }

    private c() {
    }

    private final AudioManager f() {
        return (AudioManager) g.getValue();
    }

    private final NotificationManager g() {
        return (NotificationManager) h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioManager i() {
        Object systemService = Utils.a().getSystemService("audio");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager j() {
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    public final void c(int i, float f2) {
        float f3 = (i + f2) / 100.0f;
        int i2 = e;
        int i3 = (int) (f3 * i2);
        if (i3 <= 0) {
            i2 = 0;
        } else if (i3 < i2) {
            i2 = i3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("preVolume:");
        sb.append(i);
        sb.append(", volume:");
        sb.append(i2);
        try {
            if (f().isVolumeFixed() && !b) {
                return;
            }
            f().setStreamVolume(3, i2, 0);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void d() {
        int streamVolume = f().getStreamVolume(3);
        StringBuilder sb = new StringBuilder();
        sb.append("checkCurVolume volume:");
        sb.append(streamVolume);
        if (streamVolume < e) {
            int i = f;
            int i2 = e;
            int i3 = d;
            if ((i * i2) / i3 != streamVolume) {
                f = (streamVolume * i3) / i2;
            }
        }
    }

    public final int e() {
        return f;
    }

    public final void h() {
        b = g().isNotificationPolicyAccessGranted();
        int streamVolume = f().getStreamVolume(3);
        f = (d * streamVolume) / e;
        int i = f;
        int i2 = e;
        StringBuilder sb = new StringBuilder();
        sb.append("curVolume:");
        sb.append(i);
        sb.append(", volume:");
        sb.append(streamVolume);
        sb.append(" system:");
        sb.append(i2);
    }

    public final int k(int i) {
        int e2 = RangesKt.e(RangesKt.h(f + i, c), 0);
        if (e2 <= d) {
            c(f, i);
        }
        f = e2;
        return e2;
    }
}
