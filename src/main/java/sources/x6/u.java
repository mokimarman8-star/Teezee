package x6;

import com.cloud.hisavana.abtestkit.db.ABRoomDatabase_Impl;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class u extends androidx.room.f {
    public u(ABRoomDatabase_Impl aBRoomDatabase_Impl) {
        super(aBRoomDatabase_Impl);
    }

    public final String e() {
        return "DELETE FROM `hisavana_ab_room` WHERE `layer_id` = ?";
    }

    public final void j(z3.h hVar, Object obj) {
        hVar.c(1, ((z) obj).getLayerId());
    }
}
