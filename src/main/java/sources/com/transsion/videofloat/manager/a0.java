package com.transsion.videofloat.manager;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a0 {
    public static final a0 a = new a0();
    private static final Map b = new LinkedHashMap();

    private a0() {
    }

    public final void a(String tag, com.transsion.player.orplayer.f player) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(player, "player");
        a.a.r(wf.a.a, "VideoFloat", new String[]{"PlayerView-----addPlayerView," + tag}, false, 4, (Object) null);
        b.put(tag, player);
    }

    public final com.transsion.player.orplayer.f b(String tag) {
        Intrinsics.h(tag, "tag");
        Map map = b;
        com.transsion.player.orplayer.f fVar = (com.transsion.player.orplayer.f) map.remove(tag);
        if (fVar == null) {
            if (!map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    wf.a.a.w("VideoFloat", "PlayerView---player null clear. release, tag:" + tag + ", curTag：" + entry.getKey(), true);
                    ((com.transsion.player.orplayer.f) entry.getValue()).release();
                }
                Iterator it = b.values().iterator();
                while (it.hasNext()) {
                    ((com.transsion.player.orplayer.f) it.next()).release();
                }
            }
            b.clear();
        }
        return fVar;
    }

    public final boolean c(com.transsion.player.orplayer.f fVar) {
        for (com.transsion.player.orplayer.f fVar2 : b.values()) {
            if (Intrinsics.c(fVar2, fVar)) {
                wf.a.a.c("VideoFloat", "hasPlayerCache，true player:" + fVar, true);
                return true;
            }
            wf.a.a.c("VideoFloat", "hasPlayerCache，false player:" + fVar + ", cachePayer:" + fVar2, true);
        }
        return false;
    }

    public final void d() {
        b.clear();
    }

    public final void e(String tag) {
        Intrinsics.h(tag, "tag");
        a.a.f(wf.a.a, "VideoFloat", "PlayerView-----removePlayerView", false, 4, (Object) null);
        b.remove(tag);
    }
}
