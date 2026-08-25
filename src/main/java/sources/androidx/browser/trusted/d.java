package androidx.browser.trusted;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d {

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Parcelable[] f1213a;

        a(Parcelable[] parcelableArr) {
            this.f1213a = parcelableArr;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.f1213a);
            return bundle;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f1214a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1215b;

        b(String str, int i5) {
            this.f1214a = str;
            this.f1215b = i5;
        }

        public static b a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new b(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f1216a;

        c(String str) {
            this.f1216a = str;
        }

        public static c a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new c(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* renamed from: androidx.browser.trusted.d$d, reason: collision with other inner class name */
    static class C0007d {

        /* renamed from: a, reason: collision with root package name */
        public final String f1217a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1218b;

        /* renamed from: c, reason: collision with root package name */
        public final Notification f1219c;

        /* renamed from: d, reason: collision with root package name */
        public final String f1220d;

        C0007d(String str, int i5, Notification notification, String str2) {
            this.f1217a = str;
            this.f1218b = i5;
            this.f1219c = notification;
            this.f1220d = str2;
        }

        public static C0007d a(Bundle bundle) {
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            d.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            d.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            d.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new C0007d(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1221a;

        e(boolean z5) {
            this.f1221a = z5;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.f1221a);
            return bundle;
        }
    }

    static void a(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return;
        }
        throw new IllegalArgumentException("Bundle must contain " + str);
    }
}
