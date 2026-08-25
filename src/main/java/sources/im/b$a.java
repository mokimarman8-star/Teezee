package im;

import android.app.Activity;
import com.transsion.gslb.BuildConfig;
import com.transsion.memberapi.MemberSource;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b$a {
    public static /* synthetic */ void a(b bVar, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkShowAdState");
        }
        if ((i & 1) != 0) {
            function0 = null;
        }
        bVar.A(function0);
    }

    public static /* synthetic */ void b(b bVar, Function2 function2, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: claimMemberShipReward");
        }
        if ((i & 1) != 0) {
            function2 = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        bVar.y(function2, function0);
    }

    public static /* synthetic */ void c(b bVar, Activity activity, MemberSource memberSource, c cVar, boolean z, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startMemberPage");
        }
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str = BuildConfig.FLAVOR;
        }
        bVar.u(activity, memberSource, cVar, z2, str);
    }
}
