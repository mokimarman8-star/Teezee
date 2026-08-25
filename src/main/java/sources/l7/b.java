package l7;

import android.util.Log;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.e;
import com.tencent.mmkv.MMKV;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b {
    private static final b b = new b();
    private MMKV a;

    private b() {
        try {
            MMKV.C(e.a());
            this.a = MMKV.I("HisavanaMMKV");
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "Hisavana MMKV init error " + e.getMessage());
        }
    }

    public static b c() {
        return b;
    }

    public void a() {
        try {
            this.a.clear();
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "clear " + Log.getStackTraceString(e));
        }
    }

    public boolean b(String str, boolean z) {
        try {
            return this.a.getBoolean(str, z);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "getBoolean " + Log.getStackTraceString(e));
            return z;
        }
    }

    public int d(String str, int i) {
        try {
            return this.a.getInt(str, i);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "getInt " + Log.getStackTraceString(e));
            return i;
        }
    }

    public long e(String str, long j) {
        try {
            return this.a.getLong(str, j);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "getLong " + Log.getStackTraceString(e));
            return j;
        }
    }

    public String f(String str, String str2) {
        try {
            return this.a.getString(str, str2);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "getString " + Log.getStackTraceString(e));
            return str2;
        }
    }

    public Set g(String str, Set set) {
        try {
            return this.a.getStringSet(str, set);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "getStringSet " + Log.getStackTraceString(e));
            return set;
        }
    }

    public String h() {
        try {
            return MMKV.version();
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "MMKV.version() " + Log.getStackTraceString(e));
            return "";
        }
    }

    public void i(String str, boolean z) {
        try {
            this.a.putBoolean(str, z);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "putBoolean " + Log.getStackTraceString(e));
        }
    }

    public void j(String str, int i) {
        try {
            this.a.putInt(str, i);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "putInt " + Log.getStackTraceString(e));
        }
    }

    public void k(String str, long j) {
        try {
            this.a.putLong(str, j);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "putLong " + Log.getStackTraceString(e));
        }
    }

    public void l(String str, String str2) {
        try {
            this.a.putString(str, str2);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "putString " + Log.getStackTraceString(e));
        }
    }

    public void m(String str) {
        try {
            this.a.M(str);
        } catch (Exception e) {
            c.Log().e("HisavanaMMKV", "getStringSet " + Log.getStackTraceString(e));
        }
    }
}
