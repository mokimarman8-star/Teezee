package com.cloud.sdk.commonutil.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class i {
    private static Map c = new HashMap();
    private static final Set d = new HashSet(0);
    private static final Object e = null;
    private static Context f = null;
    private SharedPreferences a;
    private SharedPreferences.Editor b;

    private i(String str) {
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

    public static synchronized i d(String str) {
        i iVar;
        synchronized (i.class) {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("please make sure you have valid file name");
            }
            iVar = (i) c.get(str);
            if (iVar == null) {
                iVar = new i(str);
                c.put(str, iVar);
            }
        }
        return iVar;
    }

    public void b() {
        SharedPreferences.Editor editor = this.b;
        if (editor != null) {
            editor.clear();
            this.b.apply();
        }
    }

    public boolean c(String str, boolean z) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? z : sharedPreferences.getBoolean(str, z);
    }

    public int e(String str, int i) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? i : sharedPreferences.getInt(str, i);
    }

    public long f(String str, long j) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? j : sharedPreferences.getLong(str, j);
    }

    public String g(String str, String str2) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public Set h(String str, Set set) {
        SharedPreferences sharedPreferences;
        return (TextUtils.isEmpty(str) || (sharedPreferences = this.a) == null) ? set : sharedPreferences.getStringSet(str, set);
    }

    public void i(String str, boolean z) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.b) == null) {
            return;
        }
        editor.putBoolean(str, z);
        this.b.apply();
    }

    public void j(String str, int i) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.b) == null) {
            return;
        }
        editor.putInt(str, i);
        this.b.apply();
    }

    public void k(String str, long j) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || (editor = this.b) == null) {
            return;
        }
        editor.putLong(str, j);
        this.b.apply();
    }

    public void l(String str, String str2) {
        SharedPreferences.Editor editor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (editor = this.b) == null) {
            return;
        }
        editor.putString(str, str2);
        this.b.apply();
    }

    public void m(String str) {
        SharedPreferences.Editor editor = this.b;
        if (editor != null) {
            editor.remove(str);
            this.b.apply();
        }
    }
}
