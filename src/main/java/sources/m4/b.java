package m4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.athena.taaneh.aethna;
import com.transsion.athena.taaneh.athena;
import rp.c;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static b f16546c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f16547a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f16548b;

    private b(Context context) {
        this.f16548b = context.getApplicationContext();
    }

    public static synchronized b b(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (f16546c == null) {
                    f16546c = new b(context);
                }
                bVar = f16546c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private SharedPreferences d(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(athena.d(context) + "_tcrypto", 0);
                this.f16547a = sharedPreferences;
                return sharedPreferences;
            } catch (Exception e5) {
                aethna.b(Log.getStackTraceString(e5));
                return null;
            }
        }
        SharedPreferences sharedPreferences2 = this.f16547a;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        if (context == null) {
            return null;
        }
        try {
            this.f16547a = context.getSharedPreferences(athena.d(context) + "_tcrypto", 0);
        } catch (Exception e6) {
            aethna.b(Log.getStackTraceString(e6));
        }
        return this.f16547a;
    }

    public String a(String str) {
        Context context = this.f16548b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f16547a == null) {
            this.f16547a = d(context);
        }
        if (this.f16547a == null) {
            throw new Exception("sp is null");
        }
        if (!c.b().a(this.f16548b)) {
            throw new Exception("keystore decrypt error");
        }
        String string = this.f16547a.getString(str, "");
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

    public void c(String str, String str2) {
        Context context = this.f16548b;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (this.f16547a == null) {
            this.f16547a = d(context);
        }
        if (this.f16547a == null) {
            throw new Exception("sp is null");
        }
        try {
            if (!c.b().a(this.f16548b)) {
                throw new Exception("keystore encrypt error");
            }
            rp.b bVar = new rp.b();
            String c5 = bVar.c(bVar.e(str2));
            if (TextUtils.isEmpty(c5)) {
                throw new Exception("rsaCrypter encrypt error");
            }
            SharedPreferences.Editor edit = this.f16547a.edit();
            edit.putString(str, c5);
            edit.apply();
        } catch (Exception e5) {
            aethna.b(Log.getStackTraceString(e5));
            throw e5;
        }
    }
}
