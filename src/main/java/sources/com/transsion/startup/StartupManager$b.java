package com.transsion.startup;

import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class StartupManager$b implements com.tencent.mmkv.a {
    StartupManager$b() {
    }

    public void a(MMKVLogLevel mMKVLogLevel, String str, int i, String str2, String str3) {
        if (mMKVLogLevel == MMKVLogLevel.LevelError) {
            a.a.l(wf.a.a, "MMKV_HANDLER", "Error: " + str3, false, 4, (Object) null);
            return;
        }
        a.a.f(wf.a.a, "MMKV_HANDLER", "Debug: " + str3, false, 4, (Object) null);
    }

    public MMKVRecoverStrategic b(String str) {
        a.a.l(wf.a.a, "MMKV_HANDLER", "CRC Check Fail for ID: " + str + ". Discarding...", false, 4, (Object) null);
        return MMKVRecoverStrategic.OnErrorDiscard;
    }

    public boolean c() {
        return false;
    }

    public MMKVRecoverStrategic d(String str) {
        a.a.l(wf.a.a, "MMKV_HANDLER", "File Length Error for ID: " + str + ". Discarding...", false, 4, (Object) null);
        return MMKVRecoverStrategic.OnErrorDiscard;
    }
}
