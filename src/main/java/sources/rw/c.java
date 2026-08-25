package rw;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.transsion.wrapperad.install.appinfo.AppChangeInfo;
import com.transsion.wrapperad.install.open.ChangeType;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final AppChangeInfo a(Context context, String packageName, ChangeType type) {
        Object obj;
        Long valueOf;
        Object obj2;
        String str;
        InstallSourceInfo installSourceInfo;
        String installingPackageName;
        Drawable loadIcon;
        Object obj3;
        ApplicationInfo applicationInfo;
        CharSequence loadLabel;
        Intrinsics.h(context, "context");
        Intrinsics.h(packageName, "packageName");
        Intrinsics.h(type, "type");
        PackageManager packageManager = context.getPackageManager();
        try {
            Result$Companion result$Companion = Result.Companion;
            obj = Result.constructor-impl(packageManager.getPackageInfo(packageName, 0));
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        PackageInfo packageInfo = (PackageInfo) obj;
        ApplicationInfo applicationInfo2 = packageInfo != null ? packageInfo.applicationInfo : null;
        String obj4 = (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (loadLabel = applicationInfo.loadLabel(packageManager)) == null) ? null : loadLabel.toString();
        String str2 = packageInfo != null ? packageInfo.versionName : null;
        if (packageInfo == null) {
            valueOf = null;
        } else {
            valueOf = Build.VERSION.SDK_INT >= 28 ? Long.valueOf(f7.a.a(packageInfo)) : Long.valueOf(packageInfo.versionCode);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                installSourceInfo = packageManager.getInstallSourceInfo(packageName);
                installingPackageName = installSourceInfo.getInstallingPackageName();
                obj2 = Result.constructor-impl(installingPackageName);
            } catch (Throwable th2) {
                Result$Companion result$Companion3 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.a(th2));
            }
            if (Result.isFailure-impl(obj2)) {
                obj2 = null;
            }
            str = (String) obj2;
        } else {
            str = packageManager.getInstallerPackageName(packageName);
        }
        String str3 = str;
        if (applicationInfo2 != null) {
            try {
                loadIcon = applicationInfo2.loadIcon(packageManager);
            } catch (Throwable th3) {
                Result$Companion result$Companion4 = Result.Companion;
                obj3 = Result.constructor-impl(ResultKt.a(th3));
            }
        } else {
            loadIcon = null;
        }
        obj3 = Result.constructor-impl(loadIcon);
        return new AppChangeInfo(packageName, obj4, str2, valueOf, str3, type, (Drawable) (Result.isFailure-impl(obj3) ? null : obj3));
    }
}
