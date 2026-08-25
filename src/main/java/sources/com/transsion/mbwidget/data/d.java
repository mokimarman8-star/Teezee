package com.transsion.mbwidget.data;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    public final boolean a(SportMatch sportMatch) {
        Intrinsics.h(sportMatch, "match");
        return sportMatch.getStatus() == MatchStatus.UNKNOWN || sportMatch.getStatus() == MatchStatus.ENDED;
    }

    public final boolean b(SportMatch sportMatch) {
        Intrinsics.h(sportMatch, "match");
        if (sportMatch.getStatus() != MatchStatus.UNKNOWN) {
            return sportMatch.getStatus() == MatchStatus.ING;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis >= sportMatch.getMatchTime() && currentTimeMillis <= sportMatch.getMatchTime() + 7200000;
    }
}
