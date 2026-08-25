package a;

import androidx.annotation.Keep;
import com.therouter.router.RouteItem;
import com.therouter.router.RouteMapKt;
import com.therouter.router.d;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class RouterMap__TheRouter__1347258790 implements d {
    public static final String COUNT = "1";
    public static final String ROUTERMAP0 = "[{\"path\":\"/fission/invitation_code\",\"className\":\"com.transsion.fission.FissionInvitationCodeActivity\",\"action\":\"\",\"description\":\"\",\"params\":{}}]";
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void addRoute() {
        RouteMapKt.c(new RouteItem("/fission/invitation_code", "com.transsion.fission.FissionInvitationCodeActivity", "", ""));
    }

    public void init() {
        addRoute();
    }
}
