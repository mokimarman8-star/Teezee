package v5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.sP.Sj.Ym;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class b {
    private static Context a = null;
    private static String b = null;
    private static boolean c = false;
    private static Ym d = null;
    private static int e = 1;
    public static boolean f;

    public static Ym a() {
        if (d == null) {
            Ym.Sj sj = new Ym.Sj("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            d = sj.Sj(10000L, timeUnit).sP(10000L, timeUnit).TKC(10000L, timeUnit).Sj();
        }
        return d;
    }

    public static boolean b() {
        return f;
    }

    public static Context c() {
        return a;
    }

    public static void d(int i) {
        e = i;
    }

    public static void e(Context context, String str) {
        a = context;
        b = str;
    }

    public static void f(Ym ym) {
        d = ym;
    }

    public static void g(boolean z) {
        c = z;
    }

    public static boolean h() {
        return c;
    }

    public static String i() {
        if (TextUtils.isEmpty(b)) {
            try {
                File file = new File(c().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                b = file.getAbsolutePath();
            } catch (Throwable unused) {
            }
        }
        return b;
    }

    public static int j() {
        return e;
    }
}
