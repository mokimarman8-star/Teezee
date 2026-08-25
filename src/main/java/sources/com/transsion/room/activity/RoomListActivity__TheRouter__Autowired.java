package com.transsion.room.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class RoomListActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof RoomListActivity) {
            RoomListActivity roomListActivity = (RoomListActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", roomListActivity, new b("boolean", "is_select_room", 0, BuildConfig.FLAVOR, "com.transsion.room.activity.RoomListActivity", "isSelectRoom", false, "No desc."));
                    if (bool != null) {
                        roomListActivity.isSelectRoom = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    Integer num = (Integer) aVar.a("int", roomListActivity, new b("int", "index", 0, BuildConfig.FLAVOR, "com.transsion.room.activity.RoomListActivity", "index", false, "No desc."));
                    if (num != null) {
                        roomListActivity.index = num.intValue();
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
