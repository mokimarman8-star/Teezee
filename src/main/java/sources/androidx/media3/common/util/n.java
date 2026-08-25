package androidx.media3.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class n implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    private final Object f9087a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Map f9088b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Set f9089c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    private List f9090d = Collections.emptyList();

    public void a(Object obj) {
        synchronized (this.f9087a) {
            try {
                ArrayList arrayList = new ArrayList(this.f9090d);
                arrayList.add(obj);
                this.f9090d = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.f9088b.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f9089c);
                    hashSet.add(obj);
                    this.f9089c = Collections.unmodifiableSet(hashSet);
                }
                this.f9088b.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(Object obj) {
        synchronized (this.f9087a) {
            try {
                Integer num = (Integer) this.f9088b.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f9090d);
                arrayList.remove(obj);
                this.f9090d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f9088b.remove(obj);
                    HashSet hashSet = new HashSet(this.f9089c);
                    hashSet.remove(obj);
                    this.f9089c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f9088b.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int count(Object obj) {
        int intValue;
        synchronized (this.f9087a) {
            try {
                intValue = this.f9088b.containsKey(obj) ? ((Integer) this.f9088b.get(obj)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return intValue;
    }

    public Set elementSet() {
        Set set;
        synchronized (this.f9087a) {
            set = this.f9089c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator it;
        synchronized (this.f9087a) {
            it = this.f9090d.iterator();
        }
        return it;
    }
}
