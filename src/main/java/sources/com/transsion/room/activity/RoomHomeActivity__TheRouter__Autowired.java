package com.transsion.room.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class RoomHomeActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof RoomHomeActivity) {
            RoomHomeActivity roomHomeActivity = (RoomHomeActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    String str = (String) aVar.a("java.lang.String", roomHomeActivity, new b("java.lang.String", "ops", 0, BuildConfig.FLAVOR, "com.transsion.room.activity.RoomHomeActivity", "insertPostOps", false, "No desc."));
                    if (str != null) {
                        roomHomeActivity.insertPostOps = str;
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", roomHomeActivity, new b("java.lang.String", "post_id", 0, BuildConfig.FLAVOR, "com.transsion.room.activity.RoomHomeActivity", "insertPostId", false, "No desc."));
                    if (str2 != null) {
                        roomHomeActivity.insertPostId = str2;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
