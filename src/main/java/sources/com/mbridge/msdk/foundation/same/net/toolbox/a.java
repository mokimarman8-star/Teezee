package com.mbridge.msdk.foundation.same.net.toolbox;

import com.mbridge.msdk.tracker.network.g;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    public final byte[] a;
    public final List<g> b;
    public final Map<String, String> c;
    public final int d;

    public a(int i, byte[] bArr, List<g> list) {
        this(i, bArr, a(list), list);
    }

    private a(int i, byte[] bArr, Map<String, String> map, List<g> list) {
        this.d = i;
        this.a = bArr;
        this.c = map;
        if (list == null) {
            this.b = null;
        } else {
            this.b = Collections.unmodifiableList(list);
        }
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
