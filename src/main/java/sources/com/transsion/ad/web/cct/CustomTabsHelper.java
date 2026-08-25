package com.transsion.ad.web.cct;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.d;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CustomTabsHelper {
    public static final Companion a = new Companion(null);
    private static String b;

    public static final class Companion {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/ad/web/cct/CustomTabsHelper$Companion$Mode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "PRIORITY_CHROME", "DEFAULT_BROWSER", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Mode {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Mode[] $VALUES;
            public static final Mode PRIORITY_CHROME = new Mode("PRIORITY_CHROME", 0);
            public static final Mode DEFAULT_BROWSER = new Mode("DEFAULT_BROWSER", 1);

            private static final /* synthetic */ Mode[] $values() {
                return new Mode[]{PRIORITY_CHROME, DEFAULT_BROWSER};
            }

            static {
                Mode[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.a($values);
            }

            private Mode(String str, int i) {
            }

            public static EnumEntries<Mode> getEntries() {
                return $ENTRIES;
            }

            public static Mode valueOf(String str) {
                return (Mode) Enum.valueOf(Mode.class, str);
            }

            public static Mode[] values() {
                return (Mode[]) $VALUES.clone();
            }
        }

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Mode.values().length];
                try {
                    iArr[Mode.PRIORITY_CHROME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Mode.DEFAULT_BROWSER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean c(Context context, Intent intent) {
            List<ResolveInfo> queryIntentActivities;
            try {
                queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
                Intrinsics.g(queryIntentActivities, "queryIntentActivities(...)");
            } catch (RuntimeException unused) {
            }
            if (queryIntentActivities.isEmpty()) {
                return false;
            }
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ void e(Companion companion, Activity activity, d dVar, Uri uri, gi.a aVar, Mode mode, int i, Object obj) {
            if ((i & 16) != 0) {
                mode = Mode.PRIORITY_CHROME;
            }
            companion.d(activity, dVar, uri, aVar, mode);
        }

        public final String a(Context context) {
            Intrinsics.h(context, "context");
            if (CustomTabsHelper.b != null) {
                return CustomTabsHelper.b;
            }
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            String str = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            Intrinsics.g(queryIntentActivities, "queryIntentActivities(...)");
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                Intent intent2 = new Intent();
                intent2.setAction("android.support.customtabs.action.CustomTabsService");
                intent2.setPackage(resolveInfo.activityInfo.packageName);
                if (packageManager.resolveService(intent2, 0) != null) {
                    arrayList.add(resolveInfo.activityInfo.packageName);
                }
            }
            CustomTabsHelper.b = arrayList.isEmpty() ? null : (TextUtils.isEmpty(str) || c(context, intent) || !arrayList.contains(str)) ? (String) arrayList.get(0) : str;
            return CustomTabsHelper.b;
        }

        public final String b(Context context) {
            Intrinsics.h(context, "context");
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
            intent.setPackage("com.android.chrome");
            if (packageManager.resolveService(intent, 0) != null) {
                return "com.android.chrome";
            }
            for (String str : CollectionsKt.o(new String[]{"com.chrome.beta", "com.chrome.dev", "com.chrome.canary"})) {
                intent.setPackage(str);
                if (packageManager.resolveService(intent, 0) != null) {
                    return str;
                }
            }
            return a(context);
        }

        public final void d(Activity activity, d dVar, Uri uri, gi.a aVar, Mode mode) {
            String b;
            Intrinsics.h(activity, "activity");
            Intrinsics.h(dVar, "customTabsIntent");
            Intrinsics.h(uri, "uri");
            Intrinsics.h(mode, "mode");
            int i = a.a[mode.ordinal()];
            if (i == 1) {
                b = b(activity);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                b = a(activity);
            }
            if (b != null) {
                dVar.a.setPackage(b);
                dVar.a(activity, uri);
            } else if (aVar != null) {
                aVar.a(activity, uri);
            }
        }
    }
}
