package com.blankj.utilcode.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class j {
    private static final Map a = new ConcurrentHashMap(64);

    private static void a(long j) {
        Map map = a;
        if (map.size() < 64) {
            return;
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (j >= ((Long) ((Map.Entry) it.next()).getValue()).longValue()) {
                it.remove();
            }
        }
    }

    public static boolean b(View view, long j) {
        return c(String.valueOf(view.hashCode()), j);
    }

    public static boolean c(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The key is null.");
        }
        if (j < 0) {
            throw new IllegalArgumentException("The duration is less than 0.");
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        a(elapsedRealtime);
        Map map = a;
        Long l = (Long) map.get(str);
        if (l != null && elapsedRealtime < l.longValue()) {
            return false;
        }
        map.put(str, Long.valueOf(elapsedRealtime + j));
        return true;
    }
}
