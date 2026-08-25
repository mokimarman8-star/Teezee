package x6;

import androidx.room.l0;
import com.cloud.hisavana.abtestkit.db.ABRoomDatabase_Impl;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class x extends l0 {
    public x(ABRoomDatabase_Impl aBRoomDatabase_Impl) {
        super(aBRoomDatabase_Impl);
    }

    public final String e() {
        return "UPDATE hisavana_ab_room SET request_time = ? WHERE layer_id = ?";
    }
}
