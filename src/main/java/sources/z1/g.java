package z1;

import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f18794a;

    /* renamed from: b, reason: collision with root package name */
    public final long f18795b;

    /* renamed from: c, reason: collision with root package name */
    public final List f18796c;

    /* renamed from: d, reason: collision with root package name */
    public final List f18797d;

    /* renamed from: e, reason: collision with root package name */
    public final e f18798e;

    public g(String str, long j5, List list, List list2) {
        this(str, j5, list, list2, null);
    }

    public g(String str, long j5, List list, List list2, e eVar) {
        this.f18794a = str;
        this.f18795b = j5;
        this.f18796c = Collections.unmodifiableList(list);
        this.f18797d = Collections.unmodifiableList(list2);
        this.f18798e = eVar;
    }

    public int a(int i5) {
        int size = this.f18796c.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (((a) this.f18796c.get(i6)).f18749b == i5) {
                return i6;
            }
        }
        return -1;
    }
}
