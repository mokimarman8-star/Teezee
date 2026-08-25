package dj;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.transsion.baselib.report.k;
import com.transsion.push.PushConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    private static boolean b;

    /* renamed from: dj.a$a, reason: collision with other inner class name */
    public static final class C0066a implements ByteAppManager.MiniAppLifecycleListener {
        C0066a() {
        }

        public void onCreate() {
        }

        public void onDestroy() {
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void onStart() {
            k.a.h();
        }

        public void onStop() {
            Log.e("yy", "onStop  activity:");
            k.a.u();
        }
    }

    private a() {
    }

    public final void a(Application application) {
        Intrinsics.h(application, "app");
        ByteAppManager.init(application);
        ByteAppManager.INSTANCE.registerMiniAppLifecycleListener(new C0066a());
    }

    public final void b(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "miniappDeeplink");
        ByteAppManager.launchMiniAppDeeplink(context, str);
    }

    public final void c(Activity activity, String str, String str2) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(str, PushConstants.PROVIDER_FIELD_APP_ID);
        Intrinsics.h(str2, "sceneId");
        ByteAppManager.launchMiniAppForId(activity, str, str2);
    }

    public final void d(Context context) {
        Intrinsics.h(context, "context");
        if (b) {
            return;
        }
        b = true;
        ByteAppManager.warmupMiniapp(context);
    }
}
