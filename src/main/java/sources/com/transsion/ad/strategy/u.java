package com.transsion.ad.strategy;

import com.transsion.ad.monopoly.model.MbAdPlansBean;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u {
    public static final u a = new u();
    private static boolean b = true;
    private static long c;
    private static int d;

    private u() {
    }

    public final int a() {
        if (b) {
            d = e.a.b().getInt("newUserAdShieldHour", 0);
        }
        return d;
    }

    public final long b() {
        if (b) {
            c = e.a.b().getLong("userCreateTime", 0L);
        }
        return c;
    }

    public final boolean c() {
        if (b) {
            e eVar = e.a;
            c = eVar.b().getLong("userCreateTime", 0L);
            d = eVar.b().getInt("newUserAdShieldHour", 0);
        }
        b = false;
        return d != 0 && System.currentTimeMillis() - c < (((long) d) * ((long) 3600)) * ((long) 1000);
    }

    public final void d(MbAdPlansBean mbAdPlansBean) {
        Integer newUserAdShieldHour;
        Long userCreateTime;
        e eVar = e.a;
        eVar.b().putLong("userCreateTime", (mbAdPlansBean == null || (userCreateTime = mbAdPlansBean.getUserCreateTime()) == null) ? 0L : userCreateTime.longValue());
        eVar.b().putInt("newUserAdShieldHour", (mbAdPlansBean == null || (newUserAdShieldHour = mbAdPlansBean.getNewUserAdShieldHour()) == null) ? 0 : newUserAdShieldHour.intValue());
        b = true;
        xh.a.c(xh.a.a, "NewUserShieldStrategy --> saveNewUserShieldData() --> 保存新用户屏蔽数据 --> userCreateTime = " + (mbAdPlansBean != null ? mbAdPlansBean.getUserCreateTime() : null) + ", newUserAdShieldHour = " + (mbAdPlansBean != null ? mbAdPlansBean.getNewUserAdShieldHour() : null), 0, false, 2, null);
    }
}
