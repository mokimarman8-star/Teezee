package com.transsion.sdk.oneid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.sdk.oneid.data.AppIdInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class OneID {
    static transient boolean c = true;
    static int d;
    private static volatile OneID e;
    private final e a;
    private final Context b;

    class a extends TypeToken<ConcurrentHashMap<Integer, AppIdInfo>> {
        a(OneID oneID) {
        }
    }

    private OneID(Context context) {
        this.b = context;
        this.a = e.a(context.getApplicationContext());
        ll.a.b(context.getApplicationContext());
    }

    public static void c(Context context, int i) {
        e eVar;
        if (context != null && e == null) {
            synchronized (OneID.class) {
                try {
                    if (e == null) {
                        e = new OneID(context);
                    }
                } finally {
                }
            }
        }
        OneID oneID = e;
        if (oneID.b == null || (eVar = oneID.a) == null) {
            return;
        }
        eVar.b(i);
    }

    public static void d(Context context, int i, int i2) {
        if (d == 0) {
            d = i2;
        }
        c(context, i);
    }

    public static OneID e() {
        if (e != null) {
            return e;
        }
        throw new IllegalStateException("You should call OneID.init first!");
    }

    public static boolean f() {
        return c;
    }

    public String a(int i) {
        AppIdInfo appIdInfo;
        if (this.b == null) {
            throw new OneIDException("OneID not init yet");
        }
        e eVar = this.a;
        String str = "";
        String i2 = eVar != null ? eVar.i(i) : "";
        if (!TextUtils.isEmpty(i2)) {
            return i2;
        }
        try {
            String h = bz.b.b(this.b).h("appid_info_list");
            if (!TextUtils.isEmpty(h) && (appIdInfo = (AppIdInfo) ((ConcurrentHashMap) new Gson().fromJson(h, new a(this).getType())).get(Integer.valueOf(i))) != null) {
                i2 = appIdInfo.odid;
                str = appIdInfo.msg;
            }
        } catch (Exception e3) {
            b.m(Log.getStackTraceString(e3));
        }
        if (!TextUtils.isEmpty(i2)) {
            return i2;
        }
        if (TextUtils.isEmpty(str)) {
            str = "Please try later";
        }
        throw new OneIDException(str);
    }

    public String b() {
        e eVar = this.a;
        return eVar != null ? eVar.h() : "";
    }
}
