package com.mbridge.msdk.tracker.network;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class q {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final List<g> d;
    public final boolean e;
    public final long f;

    private q(int i, byte[] bArr, Map<String, String> map, List<g> list, boolean z, long j) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
        this.e = z;
        this.f = j;
    }

    public q(int i, byte[] bArr, boolean z, long j, List<g> list) {
        this(i, bArr, a(list), list, z, j);
    }

    private static Map<String, String> a(List<g> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g gVar : list) {
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }
}
