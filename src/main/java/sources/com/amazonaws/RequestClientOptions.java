package com.amazonaws;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class RequestClientOptions {
    private final Map a = new EnumMap(Marker.class);

    public enum Marker {
        USER_AGENT
    }

    private String b(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str + " " + str2;
    }

    public void a(String str) {
        Map map = this.a;
        Marker marker = Marker.USER_AGENT;
        String str2 = (String) map.get(marker);
        if (str2 == null) {
            str2 = "";
        }
        d(marker, b(str2, str));
    }

    public String c(Marker marker) {
        return (String) this.a.get(marker);
    }

    public void d(Marker marker, String str) {
        this.a.put(marker, str);
    }
}
