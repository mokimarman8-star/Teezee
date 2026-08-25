package l7;

import android.os.Build;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.i;
import com.tencent.mmkv.MMKV;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class a {
    private static final a c = new a();
    private b a;
    private boolean b;

    private a() {
        this.b = false;
        try {
            this.b = a();
            c.Log().e("AdxPreferencesHelper", "mmkv is available: " + this.b);
            if (this.b) {
                this.a = b.c();
            }
        } catch (Throwable unused) {
            c.Log().e("AdxPreferencesHelper", "init mmkv error, com.tencent.mmkv.MMKV not found!");
            this.a = null;
        }
    }

    private boolean a() {
        try {
            int i = MMKV.j;
            if (Build.VERSION.SDK_INT < 35) {
                return true;
            }
            String h = b.c().h();
            c.Log().e("AdxPreferencesHelper", "mmkvVersion: " + h);
            if (h.startsWith("v0.")) {
                return false;
            }
            try {
                if (!h.startsWith("v1.")) {
                    return true;
                }
                String[] split = h.split("\\.");
                if (split.length != 3) {
                    return false;
                }
                int parseInt = Integer.parseInt(split[1]);
                return parseInt > 3 || (parseInt == 3 && Integer.parseInt(split[2]) >= 14);
            } catch (Throwable th) {
                c.Log().w("AdxPreferencesHelper", "checkMMKVAvailable error, e= " + th.getMessage());
                return false;
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    public static a e() {
        return c;
    }

    public void b() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a();
        } else {
            i.d("hisavana_sdk").b();
        }
    }

    public boolean c(String str) {
        return d(str, false);
    }

    public boolean d(String str, boolean z) {
        b bVar = this.a;
        return bVar != null ? bVar.b(str, z) : i.d("hisavana_sdk").c(str, z);
    }

    public int f(String str) {
        return g(str, 0);
    }

    public int g(String str, int i) {
        b bVar = this.a;
        return bVar != null ? bVar.d(str, i) : i.d("hisavana_sdk").e(str, i);
    }

    public long h(String str) {
        return i(str, 0L);
    }

    public long i(String str, long j) {
        b bVar = this.a;
        return bVar != null ? bVar.e(str, j) : i.d("hisavana_sdk").f(str, j);
    }

    public String j(String str) {
        return k(str, "");
    }

    public String k(String str, String str2) {
        b bVar = this.a;
        return bVar != null ? bVar.f(str, str2) : i.d("hisavana_sdk").g(str, str2);
    }

    public Set l(String str) {
        return m(str, new HashSet());
    }

    public Set m(String str, Set set) {
        b bVar = this.a;
        return bVar != null ? bVar.g(str, set) : i.d("hisavana_sdk").h(str, set);
    }

    public boolean n() {
        return this.b;
    }

    public void o(String str, boolean z) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.i(str, z);
        } else {
            i.d("hisavana_sdk").i(str, z);
        }
    }

    public void p(String str, int i) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.j(str, i);
        } else {
            i.d("hisavana_sdk").j(str, i);
        }
    }

    public void q(String str, long j) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.k(str, j);
        } else {
            i.d("hisavana_sdk").k(str, j);
        }
    }

    public void r(String str, String str2) {
        b bVar = this.a;
        if (bVar == null) {
            i.d("hisavana_sdk").l(str, str2);
        } else {
            bVar.l(str, str2);
        }
    }

    public void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = this.a;
        if (bVar != null) {
            bVar.m(str);
        } else {
            i.d("hisavana_sdk").m(str);
        }
    }
}
