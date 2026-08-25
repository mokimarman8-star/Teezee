package com.amazonaws.regions;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class Region {
    private final String a;
    private final String b;
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final Map e = new HashMap();

    Region(String str, String str2) {
        this.a = str;
        if (str2 == null || str2.isEmpty()) {
            this.b = "amazonaws.com";
        } else {
            this.b = str2;
        }
    }

    public static Region e(Regions regions) {
        return RegionUtils.a(regions.getName());
    }

    public static Region f(String str) {
        return RegionUtils.a(str);
    }

    public String a() {
        return this.b;
    }

    Map b() {
        return this.d;
    }

    Map c() {
        return this.e;
    }

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            return d().equals(((Region) obj).d());
        }
        return false;
    }

    public String g(String str) {
        return (String) this.c.get(str);
    }

    Map h() {
        return this.c;
    }

    public int hashCode() {
        return d().hashCode();
    }

    public boolean i(String str) {
        return this.c.containsKey(str);
    }

    public String toString() {
        return d();
    }
}
