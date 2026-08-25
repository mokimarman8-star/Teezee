package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.sdk.openadsdk.utils.b;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.a;
import java.util.ArrayList;
import java.util.List;
import zc.c;
import zc.e;
import zc.h;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(b.a(applicationInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? "auto" : (Build.VERSION.SDK_INT < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? i(installerPackageName) : "";
    }

    private static String i(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.b());
        arrayList.add(a.g());
        arrayList.add(zc.h.b("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(zc.h.b("fire-core", "22.0.1"));
        arrayList.add(zc.h.b("device-name", i(Build.PRODUCT)));
        arrayList.add(zc.h.b("device-model", i(Build.DEVICE)));
        arrayList.add(zc.h.b("device-brand", i(Build.BRAND)));
        arrayList.add(zc.h.c("android-target-sdk", new h.a() { // from class: com.google.firebase.h
            public final String a(Object obj) {
                String e;
                e = FirebaseCommonRegistrar.e((Context) obj);
                return e;
            }
        }));
        arrayList.add(zc.h.c("android-min-sdk", new h.a() { // from class: com.google.firebase.i
            public final String a(Object obj) {
                String f;
                f = FirebaseCommonRegistrar.f((Context) obj);
                return f;
            }
        }));
        arrayList.add(zc.h.c("android-platform", new h.a() { // from class: com.google.firebase.j
            public final String a(Object obj) {
                String g;
                g = FirebaseCommonRegistrar.g((Context) obj);
                return g;
            }
        }));
        arrayList.add(zc.h.c("android-installer", new h.a() { // from class: com.google.firebase.k
            public final String a(Object obj) {
                String h;
                h = FirebaseCommonRegistrar.h((Context) obj);
                return h;
            }
        }));
        String a = e.a();
        if (a != null) {
            arrayList.add(zc.h.b("kotlin", a));
        }
        return arrayList;
    }
}
