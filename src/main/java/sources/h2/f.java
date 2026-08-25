package h2;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.g3;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f15466a = new ArrayList();

    private int f(long j5) {
        for (int i5 = 0; i5 < this.f15466a.size(); i5++) {
            if (j5 < ((h3.e) this.f15466a.get(i5)).f15479b) {
                return i5;
            }
        }
        return this.f15466a.size();
    }

    @Override // h2.a
    public ImmutableList a(long j5) {
        int f5 = f(j5);
        if (f5 == 0) {
            return ImmutableList.of();
        }
        h3.e eVar = (h3.e) this.f15466a.get(f5 - 1);
        long j6 = eVar.f15481d;
        return (j6 == -9223372036854775807L || j5 < j6) ? eVar.f15478a : ImmutableList.of();
    }

    @Override // h2.a
    public long b(long j5) {
        if (this.f15466a.isEmpty() || j5 < ((h3.e) this.f15466a.get(0)).f15479b) {
            return -9223372036854775807L;
        }
        for (int i5 = 1; i5 < this.f15466a.size(); i5++) {
            long j6 = ((h3.e) this.f15466a.get(i5)).f15479b;
            if (j5 == j6) {
                return j6;
            }
            if (j5 < j6) {
                h3.e eVar = (h3.e) this.f15466a.get(i5 - 1);
                long j7 = eVar.f15481d;
                return (j7 == -9223372036854775807L || j7 > j5) ? eVar.f15479b : j7;
            }
        }
        h3.e eVar2 = (h3.e) g3.g(this.f15466a);
        long j8 = eVar2.f15481d;
        return (j8 == -9223372036854775807L || j5 < j8) ? eVar2.f15479b : j8;
    }

    @Override // h2.a
    public long c(long j5) {
        if (this.f15466a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j5 < ((h3.e) this.f15466a.get(0)).f15479b) {
            return ((h3.e) this.f15466a.get(0)).f15479b;
        }
        for (int i5 = 1; i5 < this.f15466a.size(); i5++) {
            h3.e eVar = (h3.e) this.f15466a.get(i5);
            if (j5 < eVar.f15479b) {
                long j6 = ((h3.e) this.f15466a.get(i5 - 1)).f15481d;
                return (j6 == -9223372036854775807L || j6 <= j5 || j6 >= eVar.f15479b) ? eVar.f15479b : j6;
            }
        }
        long j7 = ((h3.e) g3.g(this.f15466a)).f15481d;
        if (j7 == -9223372036854775807L || j5 >= j7) {
            return Long.MIN_VALUE;
        }
        return j7;
    }

    @Override // h2.a
    public void clear() {
        this.f15466a.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    @Override // h2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(h3.e eVar, long j5) {
        boolean z5;
        int size;
        androidx.media3.common.util.a.a(eVar.f15479b != -9223372036854775807L);
        if (eVar.f15479b <= j5) {
            long j6 = eVar.f15481d;
            if (j6 == -9223372036854775807L || j5 < j6) {
                z5 = true;
                for (size = this.f15466a.size() - 1; size >= 0; size--) {
                    if (eVar.f15479b >= ((h3.e) this.f15466a.get(size)).f15479b) {
                        this.f15466a.add(size + 1, eVar);
                        return z5;
                    }
                    if (((h3.e) this.f15466a.get(size)).f15479b <= j5) {
                        z5 = false;
                    }
                }
                this.f15466a.add(0, eVar);
                return z5;
            }
        }
        z5 = false;
        while (size >= 0) {
        }
        this.f15466a.add(0, eVar);
        return z5;
    }

    @Override // h2.a
    public void e(long j5) {
        int f5 = f(j5);
        if (f5 == 0) {
            return;
        }
        long j6 = ((h3.e) this.f15466a.get(f5 - 1)).f15481d;
        if (j6 == -9223372036854775807L || j6 >= j5) {
            f5--;
        }
        this.f15466a.subList(0, f5).clear();
    }
}
