package y9;

import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.g3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b {
    private final Map a;
    private final Map b;
    private final Map c;
    private final Random d;

    public b() {
        this(new Random());
    }

    b(Random random) {
        this.c = new HashMap();
        this.d = random;
        this.a = new HashMap();
        this.b = new HashMap();
    }

    private static void b(Object obj, long j, Map map) {
        if (map.containsKey(obj)) {
            j = Math.max(j, ((Long) p0.j((Long) map.get(obj))).longValue());
        }
        map.put(obj, Long.valueOf(j));
    }

    private List c(List list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h(elapsedRealtime, this.a);
        h(elapsedRealtime, this.b);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            z9.b bVar = (z9.b) list.get(i);
            if (!this.a.containsKey(bVar.b) && !this.b.containsKey(Integer.valueOf(bVar.c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(z9.b bVar, z9.b bVar2) {
        int compare = Integer.compare(bVar.c, bVar2.c);
        return compare != 0 ? compare : bVar.b.compareTo(bVar2.b);
    }

    public static int f(List list) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            hashSet.add(Integer.valueOf(((z9.b) list.get(i)).c));
        }
        return hashSet.size();
    }

    private static void h(long j, Map map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.remove(arrayList.get(i));
        }
    }

    private z9.b k(List list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            i += ((z9.b) list.get(i2)).d;
        }
        int nextInt = this.d.nextInt(i);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            z9.b bVar = (z9.b) list.get(i4);
            i3 += bVar.d;
            if (nextInt < i3) {
                return bVar;
            }
        }
        return (z9.b) g3.g(list);
    }

    public void e(z9.b bVar, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        b(bVar.b, elapsedRealtime, this.a);
        int i = bVar.c;
        if (i != Integer.MIN_VALUE) {
            b(Integer.valueOf(i), elapsedRealtime, this.b);
        }
    }

    public int g(List list) {
        HashSet hashSet = new HashSet();
        List c = c(list);
        for (int i = 0; i < c.size(); i++) {
            hashSet.add(Integer.valueOf(((z9.b) c.get(i)).c));
        }
        return hashSet.size();
    }

    public void i() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
    }

    public z9.b j(List list) {
        List c = c(list);
        if (c.size() < 2) {
            return (z9.b) g3.f(c, (Object) null);
        }
        Collections.sort(c, new Comparator() { // from class: y9.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d;
                d = b.d((z9.b) obj, (z9.b) obj2);
                return d;
            }
        });
        ArrayList arrayList = new ArrayList();
        int i = ((z9.b) c.get(0)).c;
        int i2 = 0;
        while (true) {
            if (i2 >= c.size()) {
                break;
            }
            z9.b bVar = (z9.b) c.get(i2);
            if (i == bVar.c) {
                arrayList.add(new Pair(bVar.b, Integer.valueOf(bVar.d)));
                i2++;
            } else if (arrayList.size() == 1) {
                return (z9.b) c.get(0);
            }
        }
        z9.b bVar2 = (z9.b) this.c.get(arrayList);
        if (bVar2 != null) {
            return bVar2;
        }
        z9.b k = k(c.subList(0, arrayList.size()));
        this.c.put(arrayList, k);
        return k;
    }
}
