package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import f7.a;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qb.g;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class JniNativeApi implements e {
    private static final boolean b;
    private static final FilenameFilter c = new FilenameFilter() { // from class: com.google.firebase.crashlytics.ndk.d
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean g;
            g = JniNativeApi.g(file, str);
            return g;
        }
    };
    private final Context a;

    static {
        boolean z;
        try {
            System.loadLibrary("crashlytics");
            z = true;
        } catch (UnsatisfiedLinkError e) {
            g.f().d("libcrashlytics could not be loaded. This APK may not have been compiled for this device's architecture. NDK crashes will not be reported to Crashlytics:\n" + e.getLocalizedMessage());
            z = false;
        }
        b = z;
    }

    public JniNativeApi(Context context) {
        this.a = context;
    }

    public static void c(List list, PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            Collections.addAll(list, strArr);
        }
        File file = new File(applicationInfo.dataDir, String.format("files/splitcompat/%s/verified-splits", e(packageInfo)));
        if (!file.exists()) {
            g.f().b("No dynamic features found at " + file.getAbsolutePath());
            return;
        }
        File[] listFiles = file.listFiles(c);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        g.f().b("Found " + listFiles.length + " APKs in " + file.getAbsolutePath());
        for (File file2 : listFiles) {
            g.f().b("Adding " + file2.getName() + " to classpath.");
            list.add(file2.getAbsolutePath());
        }
    }

    private static int d() {
        return Build.VERSION.SDK_INT >= 24 ? 9216 : 1024;
    }

    private static String e(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(a.a(packageInfo)) : Integer.toString(packageInfo.versionCode);
    }

    public static boolean f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean g(File file, String str) {
        return str.toLowerCase().endsWith(".apk");
    }

    private native boolean nativeInit(String[] strArr, Object obj);

    public boolean a(String str, AssetManager assetManager) {
        String[] h = h(Build.CPU_ABI);
        if (h.length < 2) {
            return false;
        }
        return b && nativeInit(new String[]{h[0], h[1], str}, assetManager);
    }

    public String[] h(String str) {
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), d());
            ArrayList<String> arrayList = new ArrayList(10);
            arrayList.add(packageInfo.applicationInfo.sourceDir);
            if (f()) {
                c(arrayList, packageInfo);
            }
            String[] strArr = packageInfo.applicationInfo.sharedLibraryFiles;
            if (strArr != null) {
                Collections.addAll(arrayList, strArr);
            }
            ArrayList arrayList2 = new ArrayList(10);
            File parentFile = new File(packageInfo.applicationInfo.nativeLibraryDir).getParentFile();
            if (parentFile != null) {
                arrayList2.add(new File(parentFile, str).getPath());
                if (str.startsWith("arm64")) {
                    arrayList2.add(new File(parentFile, "arm64").getPath());
                } else if (str.startsWith("arm")) {
                    arrayList2.add(new File(parentFile, "arm").getPath());
                }
            }
            for (String str2 : arrayList) {
                if (str2.endsWith(".apk")) {
                    arrayList2.add(str2 + "!/lib/" + str);
                }
            }
            arrayList2.add(System.getProperty("java.library.path"));
            arrayList2.add(packageInfo.applicationInfo.nativeLibraryDir);
            String str3 = File.pathSeparator;
            return new String[]{TextUtils.join(str3, arrayList), TextUtils.join(str3, arrayList2)};
        } catch (PackageManager.NameNotFoundException e) {
            g.f().e("Unable to compose package paths", e);
            throw new RuntimeException(e);
        }
    }
}
