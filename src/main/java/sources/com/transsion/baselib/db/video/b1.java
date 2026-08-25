package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b1 implements a1 {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `video_land_ad` (`resourceId`,`startAdDayKey`,`endAdDayKey`) VALUES (?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, VideoLandAdBean videoLandAdBean) {
            if (videoLandAdBean.getResourceId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, videoLandAdBean.getResourceId());
            }
            eVar.c(2, videoLandAdBean.getStartAdDayKey());
            eVar.c(3, videoLandAdBean.getEndAdDayKey());
        }
    }

    public b1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List a() {
        return Collections.emptyList();
    }
}
