package rj;

import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.GameLayoutType;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public final void a(AhaGameAllGames ahaGameAllGames, int i, long j, GameLayoutType gameLayoutType) {
        Intrinsics.h(ahaGameAllGames, "game");
        Intrinsics.h(gameLayoutType, "itemType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("id", String.valueOf(ahaGameAllGames.getId()));
        linkedHashMap.put("name", String.valueOf(ahaGameAllGames.getName()));
        linkedHashMap.put("position", String.valueOf(i));
        linkedHashMap.put("link", String.valueOf(ahaGameAllGames.getLink()));
        linkedHashMap.put("browse_duration", String.valueOf(j));
        linkedHashMap.put("item_type", gameLayoutType.toString());
        com.transsion.baselib.helper.a.a.e("game_center", linkedHashMap);
    }

    public final void b(AhaGameAllGames ahaGameAllGames, int i, GameLayoutType gameLayoutType) {
        Intrinsics.h(ahaGameAllGames, "game");
        Intrinsics.h(gameLayoutType, "itemType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("id", String.valueOf(ahaGameAllGames.getId()));
        linkedHashMap.put("name", String.valueOf(ahaGameAllGames.getName()));
        linkedHashMap.put("position", String.valueOf(i));
        linkedHashMap.put("link", String.valueOf(ahaGameAllGames.getLink()));
        linkedHashMap.put("item_type", gameLayoutType.toString());
        com.transsion.baselib.helper.a.a.f("game_center", linkedHashMap);
    }

    public final void c(AhaGameAllGames ahaGameAllGames, long j) {
        List K0;
        Intrinsics.h(ahaGameAllGames, "game");
        List peoplePlaying = ahaGameAllGames.getPeoplePlaying();
        if (peoplePlaying == null || (K0 = CollectionsKt.K0(peoplePlaying, 4)) == null) {
            return;
        }
        int i = 0;
        for (Object obj : K0) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            a((AhaGameAllGames) obj, i, j, ahaGameAllGames.getGameLayoutType());
            i = i2;
        }
    }
}
