package com.transsion.mbwidget.data;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class c {
    public static final ServerMatchItem a(List list) {
        Object obj;
        Object obj2;
        if (list == null) {
            list = CollectionsKt.l();
        }
        if (list.isEmpty()) {
            return null;
        }
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (MatchStatus.INSTANCE.a(((ServerMatchItem) obj).getStatus()) == MatchStatus.NOT_START) {
                break;
            }
        }
        ServerMatchItem serverMatchItem = (ServerMatchItem) obj;
        if (serverMatchItem != null) {
            return serverMatchItem;
        }
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (MatchStatus.INSTANCE.a(((ServerMatchItem) obj2).getStatus()) == MatchStatus.ING) {
                break;
            }
        }
        ServerMatchItem serverMatchItem2 = (ServerMatchItem) obj2;
        if (serverMatchItem2 != null) {
            return serverMatchItem2;
        }
        return null;
    }

    public static final SportMatch b(ServerMatchItem serverMatchItem) {
        ServerTeam team1;
        ServerTeam team2;
        String abbreviation;
        Long x;
        Intrinsics.h(serverMatchItem, "<this>");
        SportType a = SportType.INSTANCE.a(serverMatchItem.getType());
        SportMatch sportMatch = null;
        if (a == null || (team1 = serverMatchItem.getTeam1()) == null || (team2 = serverMatchItem.getTeam2()) == null) {
            return null;
        }
        String abbreviation2 = team1.getAbbreviation();
        if (abbreviation2 != null) {
            String str = !StringsKt.q0(abbreviation2) ? abbreviation2 : null;
            if (str != null && (abbreviation = team2.getAbbreviation()) != null) {
                String str2 = !StringsKt.q0(abbreviation) ? abbreviation : null;
                if (str2 != null) {
                    String id = serverMatchItem.getId();
                    if (id == null) {
                        return null;
                    }
                    String avatar = team1.getAvatar();
                    String avatar2 = team2.getAvatar();
                    String startTime = serverMatchItem.getStartTime();
                    sportMatch = new SportMatch(id, a, str, avatar, str2, avatar2, (startTime == null || (x = StringsKt.x(startTime)) == null) ? 0L : x.longValue(), serverMatchItem.getDeeplink(), MatchStatus.INSTANCE.a(serverMatchItem.getStatus()));
                }
            }
        }
        return sportMatch;
    }
}
