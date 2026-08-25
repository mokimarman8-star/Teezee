package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MutablePreferences extends c {

    /* renamed from: a, reason: collision with root package name */
    private final Map f7505a;

    /* renamed from: b, reason: collision with root package name */
    private final b f7506b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MutablePreferences() {
        this(r2, false, 3, r2);
        Map map = null;
    }

    public MutablePreferences(Map map, boolean z5) {
        Intrinsics.h(map, "preferencesMap");
        this.f7505a = map;
        this.f7506b = new b(z5);
    }

    public /* synthetic */ MutablePreferences(Map map, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? new LinkedHashMap() : map, (i5 & 2) != 0 ? true : z5);
    }

    @Override // androidx.datastore.preferences.core.c
    public Map a() {
        Pair pair;
        Set<Map.Entry> entrySet = this.f7505a.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.e(MapsKt.e(CollectionsKt.v(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.g(copyOf, "copyOf(this, size)");
                pair = new Pair(key, copyOf);
            } else {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return a.b(linkedHashMap);
    }

    @Override // androidx.datastore.preferences.core.c
    public Object b(c.a aVar) {
        Intrinsics.h(aVar, "key");
        Object obj = this.f7505a.get(aVar);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.g(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final void e() {
        if (this.f7506b.a()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[LOOP:0: B:16:0x002f->B:31:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        boolean z5;
        if (!(obj instanceof MutablePreferences)) {
            return false;
        }
        MutablePreferences mutablePreferences = (MutablePreferences) obj;
        Map map = mutablePreferences.f7505a;
        if (map == this.f7505a) {
            return true;
        }
        if (map.size() != this.f7505a.size()) {
            return false;
        }
        Map map2 = mutablePreferences.f7505a;
        if (!map2.isEmpty()) {
            for (Map.Entry entry : map2.entrySet()) {
                Object obj2 = this.f7505a.get(entry.getKey());
                if (obj2 != null) {
                    Object value = entry.getValue();
                    if (!(value instanceof byte[])) {
                        z5 = Intrinsics.c(value, obj2);
                    } else if ((obj2 instanceof byte[]) && Arrays.equals((byte[]) value, (byte[]) obj2)) {
                        z5 = true;
                    }
                    if (z5) {
                        return false;
                    }
                }
                z5 = false;
                if (z5) {
                }
            }
        }
        return true;
    }

    public final void f() {
        this.f7506b.b(true);
    }

    public final void g(c.b... bVarArr) {
        Intrinsics.h(bVarArr, "pairs");
        e();
        if (bVarArr.length <= 0) {
            return;
        }
        c.b bVar = bVarArr[0];
        throw null;
    }

    public final Object h(c.a aVar) {
        Intrinsics.h(aVar, "key");
        e();
        return this.f7505a.remove(aVar);
    }

    public int hashCode() {
        Iterator it = this.f7505a.entrySet().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            i5 += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return i5;
    }

    public final void i(c.a aVar, Object obj) {
        Intrinsics.h(aVar, "key");
        j(aVar, obj);
    }

    public final void j(c.a aVar, Object obj) {
        Intrinsics.h(aVar, "key");
        e();
        if (obj == null) {
            h(aVar);
            return;
        }
        if (obj instanceof Set) {
            this.f7505a.put(aVar, a.a((Set) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            this.f7505a.put(aVar, obj);
            return;
        }
        Map map = this.f7505a;
        byte[] bArr = (byte[]) obj;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.g(copyOf, "copyOf(this, size)");
        map.put(aVar, copyOf);
    }

    public String toString() {
        return CollectionsKt.s0(this.f7505a.entrySet(), ",\n", "{\n", "\n}", 0, (CharSequence) null, new Function1<Map.Entry<c.a, Object>, CharSequence>() { // from class: androidx.datastore.preferences.core.MutablePreferences$toString$1
            public final CharSequence invoke(Map.Entry<c.a, Object> entry) {
                Intrinsics.h(entry, "entry");
                Object value = entry.getValue();
                return "  " + entry.getKey().a() + " = " + (value instanceof byte[] ? ArraysKt.l0((byte[]) value, ", ", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null) : String.valueOf(entry.getValue()));
            }
        }, 24, (Object) null);
    }
}
