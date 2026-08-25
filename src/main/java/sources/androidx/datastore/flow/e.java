package androidx.datastore.flow;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e extends v {

    /* renamed from: b, reason: collision with root package name */
    private final Object f7469b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7470c;

    public e(Object obj, int i5, int i6) {
        super(i6, null);
        this.f7469b = obj;
        this.f7470c = i5;
    }

    public final void b() {
        Object obj = this.f7469b;
        if ((obj != null ? obj.hashCode() : 0) != this.f7470c) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }

    public final Object c() {
        return this.f7469b;
    }
}
