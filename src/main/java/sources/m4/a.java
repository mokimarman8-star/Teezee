package m4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.athena.taaneh.aethna;
import rp.c;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f16543c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f16544a;

    /* renamed from: b, reason: collision with root package name */
    private Context f16545b;

    private a(Context context) {
        this.f16545b = context.getApplicationContext();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f16543c == null) {
                    f16543c = new a(context);
                }
                aVar = f16543c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private SharedPreferences f(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("tcrypto", 0);
                this.f16544a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception e5) {
                aethna.b(e5.getMessage());
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.f16544a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.f16544a = context.getSharedPreferences("tcrypto", 0);
        } catch (Exception e6) {
            aethna.b(e6.getMessage());
        }
        return this.f16544a;
    }

    public void b(String str, int i5) {
        Context context = this.f16545b;
        if (context == null) {
            return;
        }
        if (this.f16544a == null) {
            this.f16544a = f(context);
        }
        SharedPreferences sharedPreferences = this.f16544a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putInt(str, i5).apply();
        } catch (Exception e5) {
            aethna.b(Log.getStackTraceString(e5));
        }
    }

    public void c(String str, String str2) {
        Context context = this.f16545b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f16544a == null) {
            this.f16544a = f(context);
        }
        if (this.f16544a == null) {
            throw new Exception("sp is null");
        }
        if (!c.b().a(this.f16545b)) {
            throw new Exception("keystore encrypt error");
        }
        rp.b bVar = new rp.b();
        String c5 = bVar.c(bVar.e(str2));
        if (TextUtils.isEmpty(c5)) {
            throw new Exception("rsaCrypter encrypt error");
        }
        SharedPreferences.Editor edit = this.f16544a.edit();
        edit.putString(str, c5);
        edit.apply();
    }

    public boolean d(String str) {
        if (this.f16544a == null) {
            this.f16544a = f(this.f16545b);
        }
        SharedPreferences sharedPreferences = this.f16544a;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public int e(String str) {
        Context context = this.f16545b;
        if (context == null) {
            return -1;
        }
        if (this.f16544a == null) {
            this.f16544a = f(context);
        }
        SharedPreferences sharedPreferences = this.f16544a;
        if (sharedPreferences == null) {
            return -1;
        }
        try {
            return sharedPreferences.getInt(str, 0);
        } catch (Exception e5) {
            aethna.b(e5.getMessage());
            return -1;
        }
    }

    public void g(String str, String str2) {
        Context context = this.f16545b;
        if (context == null) {
            return;
        }
        if (this.f16544a == null) {
            this.f16544a = f(context);
        }
        SharedPreferences sharedPreferences = this.f16544a;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception e5) {
            aethna.b(Log.getStackTraceString(e5));
        }
    }

    public String h(String str) {
        Context context = this.f16545b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f16544a == null) {
            this.f16544a = f(context);
        }
        if (this.f16544a == null) {
            throw new Exception("sp is null");
        }
        if (!c.b().a(this.f16545b)) {
            throw new Exception("keystore decrypt error");
        }
        String string = this.f16544a.getString(str, "");
        if (TextUtils.isEmpty(string) || string.contains("_")) {
            return "";
        }
        rp.b bVar = new rp.b();
        String str2 = new String(bVar.d(bVar.a(string)));
        if (TextUtils.isEmpty(str2)) {
            throw new Exception("rsaCrypter decrypt error");
        }
        return str2;
    }

    public String i(String str) {
        Context context = this.f16545b;
        if (context == null) {
            return "";
        }
        if (this.f16544a == null) {
            this.f16544a = f(context);
        }
        SharedPreferences sharedPreferences = this.f16544a;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(str, "");
        } catch (Exception e5) {
            aethna.b(Log.getStackTraceString(e5));
            return "";
        }
    }
}
