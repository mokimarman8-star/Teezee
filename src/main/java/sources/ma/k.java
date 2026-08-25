package ma;

import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class k implements da.i {
    private final List a;
    private final long[] b;
    private final long[] c;

    public k(List list) {
        this.a = Collections.unmodifiableList(new ArrayList(list));
        this.b = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            e eVar = (e) list.get(i);
            int i2 = i * 2;
            long[] jArr = this.b;
            jArr[i2] = eVar.b;
            jArr[i2 + 1] = eVar.c;
        }
        long[] jArr2 = this.b;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.c = copyOf;
        Arrays.sort(copyOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(e eVar, e eVar2) {
        return Long.compare(eVar.b, eVar2.b);
    }

    @Override // da.i
    public List getCues(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            long[] jArr = this.b;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                e eVar = (e) this.a.get(i);
                da.b bVar = eVar.a;
                if (bVar.e == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: ma.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b;
                b = k.b((e) obj, (e) obj2);
                return b;
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((e) arrayList2.get(i3)).a.b().h((-1) - i3, 1).a());
        }
        return arrayList;
    }

    @Override // da.i
    public long getEventTime(int i) {
        com.google.android.exoplayer2.util.a.a(i >= 0);
        com.google.android.exoplayer2.util.a.a(i < this.c.length);
        return this.c[i];
    }

    @Override // da.i
    public int getEventTimeCount() {
        return this.c.length;
    }

    @Override // da.i
    public int getNextEventTimeIndex(long j) {
        int e = p0.e(this.c, j, false, false);
        if (e < this.c.length) {
            return e;
        }
        return -1;
    }
}
