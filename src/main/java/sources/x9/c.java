package x9;

import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.util.s;
import i9.e0;
import x9.g;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c implements g.b {
    private final int[] a;
    private final a0[] b;

    public c(int[] iArr, a0[] a0VarArr) {
        this.a = iArr;
        this.b = a0VarArr;
    }

    public int[] a() {
        int[] iArr = new int[this.b.length];
        int i = 0;
        while (true) {
            a0[] a0VarArr = this.b;
            if (i >= a0VarArr.length) {
                return iArr;
            }
            iArr[i] = a0VarArr[i].G();
            i++;
        }
    }

    public void b(long j) {
        for (a0 a0Var : this.b) {
            a0Var.a0(j);
        }
    }

    @Override // x9.g.b
    public e0 track(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i3 >= iArr.length) {
                s.c("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
                return new i9.k();
            }
            if (i2 == iArr[i3]) {
                return this.b[i3];
            }
            i3++;
        }
    }
}
