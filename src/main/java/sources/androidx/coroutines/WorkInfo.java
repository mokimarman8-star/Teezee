package androidx.coroutines;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class WorkInfo {

    /* renamed from: a, reason: collision with root package name */
    private UUID f13851a;

    /* renamed from: b, reason: collision with root package name */
    private State f13852b;

    /* renamed from: c, reason: collision with root package name */
    private C0210d f13853c;

    /* renamed from: d, reason: collision with root package name */
    private Set f13854d;

    /* renamed from: e, reason: collision with root package name */
    private C0210d f13855e;

    /* renamed from: f, reason: collision with root package name */
    private int f13856f;

    /* renamed from: g, reason: collision with root package name */
    private final int f13857g;

    public WorkInfo(UUID uuid, State state, C0210d c0210d, List list, C0210d c0210d2, int i5, int i6) {
        this.f13851a = uuid;
        this.f13852b = state;
        this.f13853c = c0210d;
        this.f13854d = new HashSet(list);
        this.f13855e = c0210d2;
        this.f13856f = i5;
        this.f13857g = i6;
    }

    public State a() {
        return this.f13852b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f13856f == workInfo.f13856f && this.f13857g == workInfo.f13857g && this.f13851a.equals(workInfo.f13851a) && this.f13852b == workInfo.f13852b && this.f13853c.equals(workInfo.f13853c) && this.f13854d.equals(workInfo.f13854d)) {
            return this.f13855e.equals(workInfo.f13855e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f13851a.hashCode() * 31) + this.f13852b.hashCode()) * 31) + this.f13853c.hashCode()) * 31) + this.f13854d.hashCode()) * 31) + this.f13855e.hashCode()) * 31) + this.f13856f) * 31) + this.f13857g;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f13851a + "', mState=" + this.f13852b + ", mOutputData=" + this.f13853c + ", mTags=" + this.f13854d + ", mProgress=" + this.f13855e + '}';
    }
}
