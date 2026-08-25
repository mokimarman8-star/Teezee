package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    public final String a;
    public final String b;
    public final List c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final qb.f h;

    public a(String str, String str2, List list, String str3, String str4, String str5, String str6, qb.f fVar) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = fVar;
    }

    public static a a(Context context, g0 g0Var, String str, String str2, List list, qb.f fVar) {
        String packageName = context.getPackageName();
        String g = g0Var.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String b = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, list, g, packageName, b, str3, fVar);
    }

    private static String b(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(f7.a.a(packageInfo)) : Integer.toString(packageInfo.versionCode);
    }
}
