package x6;

import com.cloud.hisavana.abtestkit.db.ABRoomDatabase_Impl;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class t extends androidx.room.h {
    public t(ABRoomDatabase_Impl aBRoomDatabase_Impl) {
        super(aBRoomDatabase_Impl);
    }

    public final String e() {
        return "INSERT OR REPLACE INTO `hisavana_ab_room` (`layer_id`,`request_time`,`ab_info`) VALUES (?,?,?)";
    }

    public final void j(z3.h hVar, Object obj) {
        z zVar = (z) obj;
        hVar.c(1, zVar.getLayerId());
        hVar.c(2, zVar.getRequestTime());
        if (zVar.getInfo() == null) {
            hVar.g(3);
        } else {
            hVar.V(3, zVar.getInfo());
        }
    }
}
