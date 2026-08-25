package bz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b {
    private static b c;
    private SharedPreferences a;
    private Context b;

    private b(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized b b(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (c == null) {
                    c = new b(context);
                }
                bVar = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private SharedPreferences e(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(com.transsion.sdk.oneid.b.k(context) + "_tcrypto", 0);
                this.a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception unused) {
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.a = context.getSharedPreferences(com.transsion.sdk.oneid.b.k(context) + "_tcrypto", 0);
        } catch (Exception unused2) {
        }
        return this.a;
    }

    public int a(String str) {
        Context context = this.b;
        if (context == null) {
            return -1;
        }
        if (this.a == null) {
            this.a = e(context);
        }
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return -1;
        }
        try {
            return sharedPreferences.getInt(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    public void c(String str, int i) {
        Context context = this.b;
        if (context == null) {
            return;
        }
        if (this.a == null) {
            this.a = e(context);
        }
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putInt(str, i).apply();
        } catch (Exception e) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
        }
    }

    public void d(String str, String str2) {
        Context context = this.b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.a == null) {
            this.a = e(context);
        }
        if (this.a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!rp.c.b().a(this.b)) {
                throw new Exception("keystore encrypt error");
            }
            rp.b bVar = new rp.b();
            String c2 = bVar.c(bVar.e(str2));
            if (TextUtils.isEmpty(c2)) {
                throw new Exception("rsaCrypter encrypt error");
            }
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString(str, c2);
            edit.apply();
        } catch (Exception e) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
            throw e;
        }
    }

    public String f(String str) {
        Context context = this.b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.a == null) {
            this.a = e(context);
        }
        if (this.a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!rp.c.b().a(this.b)) {
                throw new Exception("keystore decrypt error");
            }
            String string = this.a.getString(str, HttpUrl.FRAGMENT_ENCODE_SET);
            if (!TextUtils.isEmpty(string) && !string.contains("_")) {
                rp.b bVar = new rp.b();
                String str2 = new String(bVar.d(bVar.a(string)));
                if (TextUtils.isEmpty(str2)) {
                    throw new Exception("rsaCrypter decrypt error");
                }
                return str2;
            }
            return HttpUrl.FRAGMENT_ENCODE_SET;
        } catch (Exception e) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
            throw e;
        }
    }

    public void g(String str, String str2) {
        Context context = this.b;
        if (context == null) {
            return;
        }
        if (this.a == null) {
            this.a = e(context);
        }
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception e) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
        }
    }

    public String h(String str) {
        Context context = this.b;
        if (context == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (this.a == null) {
            this.a = e(context);
        }
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        try {
            return sharedPreferences.getString(str, HttpUrl.FRAGMENT_ENCODE_SET);
        } catch (Exception e) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }
}
