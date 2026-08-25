package cf;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.core.app.t;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class c {
    public static final c a = new c();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: cf.b
        public final Object invoke() {
            MMKV g;
            g = c.g();
            return g;
        }
    });

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV g() {
        MMKV I = MMKV.I("kv_permission_x");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final boolean b(Context context) {
        Intrinsics.h(context, "context");
        return t.b(context).a();
    }

    public final boolean c(Context context) {
        Intrinsics.h(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Object systemService = context.getSystemService("appops");
        AppOpsManager appOpsManager = systemService instanceof AppOpsManager ? (AppOpsManager) systemService : null;
        Integer valueOf = appOpsManager != null ? Integer.valueOf(appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), context.getPackageName())) : null;
        return valueOf != null && valueOf.intValue() == 0;
    }

    public final MMKV d() {
        return (MMKV) b.getValue();
    }

    public final a e(FragmentActivity fragmentActivity) {
        Intrinsics.h(fragmentActivity, "activity");
        return new a(fragmentActivity);
    }

    public final boolean f(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "permission");
        return androidx.core.content.b.checkSelfPermission(context, str) == 0;
    }
}
