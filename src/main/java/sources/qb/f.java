package qb;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {
    private final Context a;
    private b b = null;

    private class b {
        private final String a;
        private final String b;

        private b() {
            int p = CommonUtils.p(f.this.a, "com.google.firebase.crashlytics.unity_version", "string");
            if (p == 0) {
                if (!f.this.c("flutter_assets/NOTICES.Z")) {
                    this.a = null;
                    this.b = null;
                    return;
                } else {
                    this.a = "Flutter";
                    this.b = null;
                    g.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.a = "Unity";
            String string = f.this.a.getResources().getString(p);
            this.b = string;
            g.f().i("Unity Editor version is: " + string);
        }
    }

    public f(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        if (this.a.getAssets() == null) {
            return false;
        }
        try {
            InputStream open = this.a.getAssets().open(str);
            if (open == null) {
                return true;
            }
            open.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private b f() {
        if (this.b == null) {
            this.b = new b();
        }
        return this.b;
    }

    public static boolean g(Context context) {
        return CommonUtils.p(context, "com.google.firebase.crashlytics.unity_version", "string") != 0;
    }

    public String d() {
        return f().a;
    }

    public String e() {
        return f().b;
    }
}
