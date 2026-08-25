package com.transsion.fission;

import com.tencent.mmkv.MMKV;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l {
    public static final l a = new l();
    private static final MMKV b = MMKV.I("one_room_fission");

    private l() {
    }

    public final String a() {
        MMKV mmkv = b;
        if (mmkv != null) {
            return mmkv.getString("KEY_FISSION_INVITATION_CODE", (String) null);
        }
        return null;
    }

    public final String b() {
        MMKV mmkv = b;
        if (mmkv != null) {
            return mmkv.getString("KEY_FISSION_INVITE_REG", (String) null);
        }
        return null;
    }

    public final void c(String str) {
        MMKV mmkv = b;
        if (mmkv != null) {
            mmkv.putString("KEY_FISSION_INVITATION_CODE", str);
        }
    }
}
