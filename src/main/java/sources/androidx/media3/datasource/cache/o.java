package androidx.media3.datasource.cache;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o implements m {

    /* renamed from: c, reason: collision with root package name */
    public static final o f9537c = new o(Collections.emptyMap());

    /* renamed from: a, reason: collision with root package name */
    private int f9538a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f9539b;

    public o() {
        this(Collections.emptyMap());
    }

    public o(Map map) {
        this.f9539b = Collections.unmodifiableMap(map);
    }

    private static void a(HashMap hashMap, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put((String) entry.getKey(), e(entry.getValue()));
        }
    }

    private static Map b(Map map, n nVar) {
        HashMap hashMap = new HashMap(map);
        g(hashMap, nVar.c());
        a(hashMap, nVar.b());
        return hashMap;
    }

    private static byte[] e(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(StandardCharsets.UTF_8);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    private static boolean f(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static void g(HashMap hashMap, List list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            hashMap.remove(list.get(i5));
        }
    }

    public o c(n nVar) {
        Map b5 = b(this.f9539b, nVar);
        return f(this.f9539b, b5) ? this : new o(b5);
    }

    public Set d() {
        return this.f9539b.entrySet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return f(this.f9539b, ((o) obj).f9539b);
    }

    @Override // androidx.media3.datasource.cache.m
    public final long get(String str, long j5) {
        byte[] bArr = (byte[]) this.f9539b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j5;
    }

    @Override // androidx.media3.datasource.cache.m
    public final String get(String str, String str2) {
        byte[] bArr = (byte[]) this.f9539b.get(str);
        return bArr != null ? new String(bArr, StandardCharsets.UTF_8) : str2;
    }

    public int hashCode() {
        if (this.f9538a == 0) {
            int i5 = 0;
            for (Map.Entry entry : this.f9539b.entrySet()) {
                i5 += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.f9538a = i5;
        }
        return this.f9538a;
    }
}
