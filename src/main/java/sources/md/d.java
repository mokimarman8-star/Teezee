package md;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d {
    private final a a;
    private final List b;

    public d(a aVar) {
        this.a = aVar;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    private b a(int i) {
        if (i >= this.b.size()) {
            List list = this.b;
            b bVar = (b) list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                a aVar = this.a;
                bVar = bVar.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.b.add(bVar);
            }
        }
        return (b) this.b.get(i);
    }

    public void b(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b a = a(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] e = new b(this.a, iArr2).j(i, 1).b(a)[1].e();
        int length2 = i - e.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(e, 0, iArr, length + length2, e.length);
    }
}
