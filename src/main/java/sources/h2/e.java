package h2;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class e implements a {

    /* renamed from: b, reason: collision with root package name */
    private static final Ordering f15464b = Ordering.natural().onResultOf(new com.google.common.base.f() { // from class: h2.c
        public final Object apply(Object obj) {
            Long h5;
            h5 = e.h((h3.e) obj);
            return h5;
        }
    }).compound(Ordering.natural().reverse().onResultOf(new com.google.common.base.f() { // from class: h2.d
        public final Object apply(Object obj) {
            Long i5;
            i5 = e.i((h3.e) obj);
            return i5;
        }
    }));

    /* renamed from: a, reason: collision with root package name */
    private final List f15465a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long h(h3.e eVar) {
        return Long.valueOf(eVar.f15479b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long i(h3.e eVar) {
        return Long.valueOf(eVar.f15480c);
    }

    @Override // h2.a
    public ImmutableList a(long j5) {
        if (!this.f15465a.isEmpty()) {
            if (j5 >= ((h3.e) this.f15465a.get(0)).f15479b) {
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < this.f15465a.size(); i5++) {
                    h3.e eVar = (h3.e) this.f15465a.get(i5);
                    if (j5 >= eVar.f15479b && j5 < eVar.f15481d) {
                        arrayList.add(eVar);
                    }
                    if (j5 < eVar.f15479b) {
                        break;
                    }
                }
                ImmutableList sortedCopyOf = ImmutableList.sortedCopyOf(f15464b, arrayList);
                ImmutableList.a builder = ImmutableList.builder();
                for (int i6 = 0; i6 < sortedCopyOf.size(); i6++) {
                    builder.l(((h3.e) sortedCopyOf.get(i6)).f15478a);
                }
                return builder.n();
            }
        }
        return ImmutableList.of();
    }

    @Override // h2.a
    public long b(long j5) {
        if (this.f15465a.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j5 < ((h3.e) this.f15465a.get(0)).f15479b) {
            return -9223372036854775807L;
        }
        long j6 = ((h3.e) this.f15465a.get(0)).f15479b;
        for (int i5 = 0; i5 < this.f15465a.size(); i5++) {
            long j7 = ((h3.e) this.f15465a.get(i5)).f15479b;
            long j8 = ((h3.e) this.f15465a.get(i5)).f15481d;
            if (j8 > j5) {
                if (j7 > j5) {
                    break;
                }
                j6 = Math.max(j6, j7);
            } else {
                j6 = Math.max(j6, j8);
            }
        }
        return j6;
    }

    @Override // h2.a
    public long c(long j5) {
        int i5 = 0;
        long j6 = -9223372036854775807L;
        while (true) {
            if (i5 >= this.f15465a.size()) {
                break;
            }
            long j7 = ((h3.e) this.f15465a.get(i5)).f15479b;
            long j8 = ((h3.e) this.f15465a.get(i5)).f15481d;
            if (j5 < j7) {
                j6 = j6 == -9223372036854775807L ? j7 : Math.min(j6, j7);
            } else {
                if (j5 < j8) {
                    j6 = j6 == -9223372036854775807L ? j8 : Math.min(j6, j8);
                }
                i5++;
            }
        }
        if (j6 != -9223372036854775807L) {
            return j6;
        }
        return Long.MIN_VALUE;
    }

    @Override // h2.a
    public void clear() {
        this.f15465a.clear();
    }

    @Override // h2.a
    public boolean d(h3.e eVar, long j5) {
        androidx.media3.common.util.a.a(eVar.f15479b != -9223372036854775807L);
        androidx.media3.common.util.a.a(eVar.f15480c != -9223372036854775807L);
        boolean z5 = eVar.f15479b <= j5 && j5 < eVar.f15481d;
        for (int size = this.f15465a.size() - 1; size >= 0; size--) {
            if (eVar.f15479b >= ((h3.e) this.f15465a.get(size)).f15479b) {
                this.f15465a.add(size + 1, eVar);
                return z5;
            }
        }
        this.f15465a.add(0, eVar);
        return z5;
    }

    @Override // h2.a
    public void e(long j5) {
        int i5 = 0;
        while (i5 < this.f15465a.size()) {
            long j6 = ((h3.e) this.f15465a.get(i5)).f15479b;
            if (j5 > j6 && j5 > ((h3.e) this.f15465a.get(i5)).f15481d) {
                this.f15465a.remove(i5);
                i5--;
            } else if (j5 < j6) {
                return;
            }
            i5++;
        }
    }
}
