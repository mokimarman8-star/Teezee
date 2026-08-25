package bk;

import ak.d;
import ak.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.UserManager;
import android.text.TextUtils;
import androidx.profileinstaller.b;
import com.transsion.athena.attribution.AttrConstant;
import com.transsion.gslb.BuildConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a {
    private static a b;
    private static Context c;
    private SharedPreferences a;

    private a(Context context) {
        c = context.getApplicationContext();
        c(context);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (b == null) {
                    b = new a(context);
                }
                aVar = b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    private SharedPreferences c(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null) {
                return sharedPreferences;
            }
            if (context == null) {
                return null;
            }
            try {
                this.a = context.getSharedPreferences(AttrConstant.SP_NAME, 0);
            } catch (Exception unused) {
            }
            return this.a;
        }
        try {
            if (com.google.android.gms.internal.auth.a.a((UserManager) context.getSystemService("user"))) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(AttrConstant.SP_NAME, 0);
                this.a = sharedPreferences2;
                return sharedPreferences2;
            }
            SharedPreferences sharedPreferences3 = b.a(context).getSharedPreferences(AttrConstant.SP_NAME, 0);
            this.a = sharedPreferences3;
            return sharedPreferences3;
        } catch (Exception unused2) {
            return null;
        }
    }

    public String b(String str) {
        if (c == null || !e.b().a(c)) {
            return BuildConfig.FLAVOR;
        }
        if (this.a == null) {
            this.a = c(c);
        }
        if (this.a == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            d dVar = new d(c);
            String string = this.a.getString(str, BuildConfig.FLAVOR);
            if (TextUtils.isEmpty(string)) {
                return BuildConfig.FLAVOR;
            }
            String[] split = string.split("_");
            int length = split.length;
            byte[] d = dVar.d(dVar.a(split[1]));
            int length2 = d.length;
            byte[] bArr = new byte[32];
            byte[] bArr2 = new byte[16];
            System.arraycopy(d, 0, bArr, 0, 32);
            System.arraycopy(d, 32, bArr2, 0, 16);
            ak.a aVar = new ak.a(bArr, bArr2);
            return new String(aVar.d(aVar.a(split[0])));
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public void d(String str, String str2) {
        if (c == null) {
            throw new Exception("context is null");
        }
        if (!e.b().a(c)) {
            throw new Exception("key not created");
        }
        if (this.a == null) {
            this.a = c(c);
        }
        if (this.a == null) {
            throw new Exception("sp is null");
        }
        try {
            ak.b bVar = new ak.b();
            d dVar = new d(c);
            String c2 = bVar.c(bVar.e(str2));
            String c3 = dVar.c(dVar.e(bVar.i()));
            this.a.edit().putString(str, c2 + "_" + c3).apply();
        } catch (Exception unused) {
        }
    }
}
