package com.transsion.version.update;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.transsion.upgradesdk.manager.UpgradeSdkManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UpdateManager {
    public static final a f = new a(null);
    private static volatile UpdateManager g;
    private UpdateVersionRequest a = new UpdateVersionRequest();
    private final String b = "TECNO";
    private final String c = "INFINIX";
    private final String d = "ITEL";
    private final HashSet e = SetsKt.g("TECNO", "INFINIX", "ITEL");

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UpdateManager a() {
            UpdateManager updateManager = UpdateManager.g;
            if (updateManager == null) {
                synchronized (this) {
                    updateManager = new UpdateManager();
                    UpdateManager.g = updateManager;
                }
            }
            return updateManager;
        }
    }

    private final boolean f() {
        d dVar = d.a;
        boolean z = false;
        int i = dVar.b().getInt("key_last_installed_version_v2", 0);
        int f2 = com.blankj.utilcode.util.c.f();
        if (i != 0 && i < f2) {
            z = true;
        }
        if (z) {
            dVar.b().putInt("key_last_installed_version_v2", f2);
        }
        return z;
    }

    public static /* synthetic */ Object j(UpdateManager updateManager, Activity activity, String str, String str2, String str3, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        return updateManager.i(activity, str, str2, str3, z, continuation);
    }

    public final void c() {
        d dVar = d.a;
        int i = dVar.b().getInt("key_last_installed_version_v2", 0);
        String string = dVar.b().getString("key_user_clicked_dialog_type", HttpUrl.FRAGMENT_ENCODE_SET);
        if (!f() || string == null || string.length() <= 0) {
            return;
        }
        dVar.b().remove("key_user_clicked_dialog_type");
        e.a.b(MapsKt.l(TuplesKt.a("action", "update_success"), TuplesKt.a("last_version", String.valueOf(i)), TuplesKt.a("dialog_type", string)));
    }

    public final boolean d() {
        String str;
        Object obj;
        MMKV c = mg.a.a.c();
        if (c == null || (str = c.getString("phone_brand", Build.BRAND)) == null) {
            str = Build.BRAND;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a.a.f(wf.a.a, "update", "brand " + str, false, 4, (Object) null);
        Intrinsics.e(str);
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        Iterator it = this.e.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (StringsKt.W(upperCase, (String) next, false, 2, null)) {
                obj = next;
                break;
            }
        }
        return ((String) obj) != null;
    }

    public final void e(String appKey) {
        Intrinsics.h(appKey, "appKey");
        if (d()) {
            UpgradeSdkManager.getInstance().init(Utils.a(), appKey, false);
        }
    }

    public final boolean g() {
        return false;
    }

    public final void h(String str) {
        d dVar = d.a;
        dVar.b().putString("showed_target_version_name", str);
        dVar.b().putInt("update_dialog_showed_times", dVar.b().getInt("update_dialog_showed_times", 0) + 1);
        dVar.b().putLong("update_dialog_show_timestamp", System.currentTimeMillis());
        a.a.f(wf.a.a, "update", "记录展示版本为 " + str + "已展示次数为 " + dVar.b().getInt("update_dialog_showed_times", 0), false, 4, (Object) null);
    }

    public final Object i(Activity activity, String str, String str2, String str3, boolean z, Continuation continuation) {
        return Boxing.a(false);
    }
}
