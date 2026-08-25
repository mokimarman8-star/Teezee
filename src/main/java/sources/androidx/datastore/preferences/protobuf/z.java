package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class z implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    private Iterator f7790a;

    public z(Iterator it) {
        this.f7790a = it;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f7790a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7790a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f7790a.remove();
    }
}
