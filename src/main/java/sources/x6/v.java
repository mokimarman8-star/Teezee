package x6;

import androidx.room.l0;
import com.cloud.hisavana.abtestkit.db.ABRoomDatabase_Impl;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class v extends l0 {
    public v(ABRoomDatabase_Impl aBRoomDatabase_Impl) {
        super(aBRoomDatabase_Impl);
    }

    public final String e() {
        return "DELETE FROM hisavana_ab_room WHERE layer_id IN (SELECT layer_id FROM hisavana_ab_room ORDER BY request_time ASC LIMIT ?)";
    }
}
