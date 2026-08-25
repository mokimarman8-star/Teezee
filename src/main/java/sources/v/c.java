package v;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private Object f18036a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f18037b;

    /* renamed from: c, reason: collision with root package name */
    private int f18038c;

    public c(Object obj, Map map) {
        this.f18036a = obj;
        this.f18037b = map;
    }

    private final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f18038c < this.f18037b.size();
    }

    @Override // java.util.Iterator
    public Object next() {
        a();
        Object obj = this.f18036a;
        this.f18038c++;
        Object obj2 = this.f18037b.get(obj);
        if (obj2 != null) {
            this.f18036a = ((a) obj2).c();
            return obj;
        }
        throw new ConcurrentModificationException("Hash code of an element (" + obj + ") has changed after it was added to the persistent set.");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
