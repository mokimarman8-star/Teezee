package s4;

import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class p implements o {

    /* renamed from: a, reason: collision with root package name */
    final List f17809a;

    p(List list) {
        this.f17809a = list;
    }

    @Override // s4.o
    public List b() {
        return this.f17809a;
    }

    @Override // s4.o
    public boolean c() {
        if (this.f17809a.isEmpty()) {
            return true;
        }
        return this.f17809a.size() == 1 && ((y4.a) this.f17809a.get(0)).i();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f17809a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f17809a.toArray()));
        }
        return sb.toString();
    }
}
