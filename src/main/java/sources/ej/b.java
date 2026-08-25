package ej;

import android.text.TextUtils;
import com.transsion.baselib.report.recent_event.ActionEvent;
import com.transsion.push.PushConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final a a = new a(null);
    private static final ej.a b = new ej.a(30);
    private static final HashMap c;
    private static final HashMap d;
    private static final HashMap e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ActionEvent a(Map map, String str) {
            String str2 = (String) map.get("module_name");
            if (TextUtils.isEmpty(str2) || !b.c.containsKey(str2)) {
                if (!TextUtils.equals(str, "Trending")) {
                    return null;
                }
                Integer num = (Integer) b.d.get(str);
                return new ActionEvent(1, num != null ? num.intValue() : 0, f((String) map.get("post_id")), f((String) map.get("subject_id")), f((String) map.get("group_id")), 0, 0, 96, (DefaultConstructorMarker) null);
            }
            Integer num2 = (Integer) b.d.get(str);
            int intValue = num2 != null ? num2.intValue() : 0;
            String f = f((String) map.get("post_id"));
            String f2 = f((String) map.get("subject_id"));
            String f3 = f((String) map.get("group_id"));
            HashMap hashMap = b.c;
            if (str2 == null) {
                str2 = "0";
            }
            return new ActionEvent(((Number) MapsKt.i(hashMap, str2)).intValue(), intValue, f, f2, f3, 0, 0, 96, (DefaultConstructorMarker) null);
        }

        private final ActionEvent b(Map map, String str) {
            if (TextUtils.equals(str, "postdetail")) {
                Integer num = (Integer) b.d.get(str);
                return new ActionEvent(15, num != null ? num.intValue() : 0, f((String) map.get("post_id")), f((String) map.get("subject_id")), f((String) map.get("group_id")), 0, 0, 96, (DefaultConstructorMarker) null);
            }
            if (!TextUtils.equals(str, "searchpage")) {
                return null;
            }
            Integer num2 = (Integer) b.d.get(str);
            return new ActionEvent(19, num2 != null ? num2.intValue() : 0, "0", "0", "0", 0, 0, 96, (DefaultConstructorMarker) null);
        }

        private final ActionEvent c(String str, Map map, String str2) {
            if (!b.d.containsKey(str2)) {
                return null;
            }
            Integer num = (Integer) b.d.get(str2);
            int intValue = num != null ? num.intValue() : 0;
            String f = f((String) map.get("post_id"));
            String f2 = f((String) map.get("subject_id"));
            String f3 = f((String) map.get("group_id"));
            String str3 = (String) map.get("play_duration");
            int parseInt = str3 != null ? Integer.parseInt(str3) : 0;
            String str4 = (String) map.get("completeCount");
            int parseInt2 = str4 != null ? Integer.parseInt(str4) : 0;
            Integer num2 = (Integer) b.e.get(str);
            if (num2 != null) {
                return new ActionEvent(num2.intValue(), intValue, f, f2, f3, parseInt, parseInt2);
            }
            return null;
        }

        private final String f(String str) {
            return (TextUtils.isEmpty(str) || str == null) ? "0" : str;
        }

        public final void d(String str, String str2, Map map) {
            Intrinsics.h(str, "pageName");
            Intrinsics.h(str2, "event");
            Intrinsics.h(map, "map");
            ActionEvent a = TextUtils.equals(str2, PushConstants.PUSH_SERVICE_TYPE_CLICK) ? a(map, str) : TextUtils.equals(str2, "pt") ? b(map, str) : (TextUtils.equals(str2, "video_play") || TextUtils.equals(str2, "audio_play")) ? c(str2, map, str) : null;
            if (a != null) {
                b.b.offer(a);
            }
        }

        public final Queue e() {
            return b.b;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        c = hashMap;
        HashMap hashMap2 = new HashMap();
        d = hashMap2;
        HashMap hashMap3 = new HashMap();
        e = hashMap3;
        hashMap.put("unknow", 0);
        hashMap.put("like", 3);
        hashMap.put("dislike", 4);
        hashMap.put("want_to_see", 5);
        hashMap.put("i_have_seen", 6);
        hashMap.put("create_review", 7);
        hashMap.put("copylink", 8);
        hashMap.put("whatsup", 8);
        hashMap.put("Telegram", 8);
        hashMap.put("create_post", 9);
        hashMap.put("checkin", 10);
        hashMap.put("checkout", 11);
        hashMap.put("download", 12);
        hashMap.put("comment", 13);
        hashMap.put("want_to_see_cancel", 17);
        hashMap.put("searchpage", 19);
        hashMap.put("search", 20);
        hashMap.put("download_subject", 21);
        hashMap2.put("default", 0);
        hashMap2.put("Trending", 1);
        hashMap2.put("roomdetail", 2);
        hashMap2.put("subjectdetail", 3);
        hashMap2.put("postdetail", 4);
        hashMap3.put(PushConstants.PUSH_SERVICE_TYPE_CLICK, 1);
        hashMap3.put("audio_play", 2);
        hashMap3.put("video_play", 2);
        hashMap3.put("PT", 15);
    }
}
