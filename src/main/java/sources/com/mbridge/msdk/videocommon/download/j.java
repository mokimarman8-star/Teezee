package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class j {
    private AtomicBoolean a;
    private AtomicBoolean b;

    private static final class b {
        private static final j a = new j();
    }

    private j() {
    }

    public static j a() {
        return b.a;
    }

    public boolean a(int i) {
        if (MBridgeConstans.DEBUG) {
            o0.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i + ", key: REWARD_VIDEO_REFACTOR_FOR_CAMPAIGN_REQUEST");
        }
        if (i != 94 && i != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.b = new AtomicBoolean(q0.a().a("r_v_r_f_c_r", false));
        } catch (Exception e) {
            this.b = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e.getMessage());
            }
        }
        return this.b.get();
    }

    public boolean b(int i) {
        if (MBridgeConstans.DEBUG) {
            o0.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i + ", key: REWARD_VIDEO_REFACTOR_FOR_LOAD");
        }
        if (i != 94 && i != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.a = new AtomicBoolean(q0.a().a("r_v_r_f_l", false));
        } catch (Exception e) {
            this.a = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e.getMessage());
            }
        }
        return this.a.get();
    }
}
