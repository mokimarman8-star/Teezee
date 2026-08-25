package v9;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.p1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class w implements com.google.android.exoplayer2.k {
    public static final k.a f = new k.a() { // from class: v9.v
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            w f2;
            f2 = w.f(bundle);
            return f2;
        }
    };
    public final int a;
    public final String b;
    public final int c;
    private final p1[] d;
    private int e;

    public w(String str, p1... p1VarArr) {
        com.google.android.exoplayer2.util.a.a(p1VarArr.length > 0);
        this.b = str;
        this.d = p1VarArr;
        this.a = p1VarArr.length;
        int k = com.google.android.exoplayer2.util.w.k(p1VarArr[0].l);
        this.c = k == -1 ? com.google.android.exoplayer2.util.w.k(p1VarArr[0].k) : k;
        j();
    }

    public w(p1... p1VarArr) {
        this("", p1VarArr);
    }

    private static String e(int i) {
        return Integer.toString(i, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ w f(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e(0));
        return new w(bundle.getString(e(1), ""), (p1[]) (parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(p1.H, parcelableArrayList)).toArray(new p1[0]));
    }

    private static void g(String str, String str2, String str3, int i) {
        com.google.android.exoplayer2.util.s.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    private static String h(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static int i(int i) {
        return i | 16384;
    }

    private void j() {
        String h = h(this.d[0].c);
        int i = i(this.d[0].e);
        int i2 = 1;
        while (true) {
            p1[] p1VarArr = this.d;
            if (i2 >= p1VarArr.length) {
                return;
            }
            if (!h.equals(h(p1VarArr[i2].c))) {
                p1[] p1VarArr2 = this.d;
                g("languages", p1VarArr2[0].c, p1VarArr2[i2].c, i2);
                return;
            } else {
                if (i != i(this.d[i2].e)) {
                    g("role flags", Integer.toBinaryString(this.d[0].e), Integer.toBinaryString(this.d[i2].e), i2);
                    return;
                }
                i2++;
            }
        }
    }

    public w b(String str) {
        return new w(str, this.d);
    }

    public p1 c(int i) {
        return this.d[i];
    }

    public int d(p1 p1Var) {
        int i = 0;
        while (true) {
            p1[] p1VarArr = this.d;
            if (i >= p1VarArr.length) {
                return -1;
            }
            if (p1Var == p1VarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        w wVar = (w) obj;
        return this.b.equals(wVar.b) && Arrays.equals(this.d, wVar.d);
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = ((527 + this.b.hashCode()) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e(0), com.google.android.exoplayer2.util.d.d(Lists.l(this.d)));
        bundle.putString(e(1), this.b);
        return bundle;
    }
}
