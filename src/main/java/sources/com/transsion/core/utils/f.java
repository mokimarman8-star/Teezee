package com.transsion.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.transsion.gslb.BuildConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class f {
    private static Map c = new HashMap();
    private static final Set d = new HashSet(0);
    private static final Object e = null;
    private static Context f = null;
    private SharedPreferences a;
    private SharedPreferences.Editor b;

    private f(String str) {
        Context context = f;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            this.a = sharedPreferences;
            if (sharedPreferences != null) {
                this.b = sharedPreferences.edit();
            }
        }
    }

    public static void a(Context context) {
        f = context;
    }

    public static synchronized f e(String str) {
        f fVar;
        synchronized (f.class) {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("please make sure you have valid file name");
            }
            fVar = (f) c.get(str);
            if (fVar == null) {
                fVar = new f(str);
                c.put(str, fVar);
            }
        }
        return fVar;
    }

    public boolean b(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    public boolean c(String str, boolean z) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? z : sharedPreferences.getBoolean(str, z);
    }

    public float d(String str, float f2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? f2 : sharedPreferences.getFloat(str, f2);
    }

    public int f(String str, int i) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? i : sharedPreferences.getInt(str, i);
    }

    public long g(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    public long h(String str, long j) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? j : sharedPreferences.getLong(str, j);
    }

    public String i(String str) {
        return !TextUtils.isEmpty(str) ? j(str, BuildConfig.FLAVOR) : BuildConfig.FLAVOR;
    }

    public String j(String str, String str2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public Set k(String str, Set set) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? set : sharedPreferences.getStringSet(str, set);
    }

    public void l(String str, boolean z) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.b) == null) {
            return;
        }
        editor.putBoolean(str, z);
        this.b.apply();
    }

    public void m(String str, float f2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.b) == null) {
            return;
        }
        editor.putFloat(str, f2);
        this.b.apply();
    }

    public void n(String str, int i) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.b) == null) {
            return;
        }
        editor.putInt(str, i);
        this.b.apply();
    }

    public void o(String str, long j) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.b) == null) {
            return;
        }
        editor.putLong(str, j);
        this.b.apply();
    }

    public void p(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.b) == null) {
            return;
        }
        editor.putString(str, str2);
        this.b.apply();
    }

    public void q(String str, Set set) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.b) == null) {
            return;
        }
        editor.putStringSet(str, set);
        this.b.apply();
    }

    public void r(String str) {
        SharedPreferences.Editor editor = this.b;
        if (editor != null) {
            editor.remove(str);
            this.b.apply();
        }
    }
}
