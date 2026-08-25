package rf;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    public static final a a = new a();
    private static String b = TtmlNode.ANONYMOUS_REGION_ID;

    private a() {
    }

    public final String a() {
        if (!b(b)) {
            String str = b;
            Intrinsics.e(str);
            return str;
        }
        TimeZone timeZone = TimeZone.getDefault();
        String id2 = timeZone.getID();
        if (b(id2)) {
            String displayName = timeZone.getDisplayName(false, 0);
            if (b(displayName)) {
                b = TtmlNode.ANONYMOUS_REGION_ID;
                displayName = "unknown";
            } else {
                b = displayName;
            }
            id2 = displayName;
            Intrinsics.g(id2, "{\n            val name =…e\n            }\n        }");
        } else {
            b = id2;
            Intrinsics.g(id2, "{\n            zoneStr = …\n            id\n        }");
        }
        return id2;
    }

    public final boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public final boolean c(Map map) {
        return (map == null || map.isEmpty()) ? false : true;
    }
}
