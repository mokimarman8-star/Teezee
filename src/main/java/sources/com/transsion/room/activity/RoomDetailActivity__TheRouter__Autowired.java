package com.transsion.room.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import com.therouter.router.b;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import mf.a;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class RoomDetailActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof RoomDetailActivity) {
            RoomDetailActivity roomDetailActivity = (RoomDetailActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Boolean bool = (Boolean) aVar.a("boolean", roomDetailActivity, new b("boolean", "need_start_room_home", 0, BuildConfig.FLAVOR, "com.transsion.room.activity.RoomDetailActivity", "isNeedStartRoomHome", false, "No desc."));
                    if (bool != null) {
                        roomDetailActivity.isNeedStartRoomHome = bool.booleanValue();
                    }
                } catch (Exception e) {
                    if (TheRouter.m()) {
                        e.printStackTrace();
                    }
                }
                try {
                    RoomItem roomItem = (RoomItem) aVar.a("com.transsion.moviedetailapi.bean.RoomItem", roomDetailActivity, new b("com.transsion.moviedetailapi.bean.RoomItem", "item", 0, BuildConfig.FLAVOR, "com.transsion.room.activity.RoomDetailActivity", "item", false, "No desc."));
                    if (roomItem != null) {
                        roomDetailActivity.item = roomItem;
                    }
                } catch (Exception e2) {
                    if (TheRouter.m()) {
                        e2.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", roomDetailActivity, new b("java.lang.String", "id", 0, BuildConfig.FLAVOR, "com.transsion.room.activity.RoomDetailActivity", "id", false, "No desc."));
                    if (str != null) {
                        roomDetailActivity.id = str;
                    }
                } catch (Exception e3) {
                    if (TheRouter.m()) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }
}
