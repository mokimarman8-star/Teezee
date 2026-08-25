package na;

import android.os.SystemClock;
import com.google.android.exoplayer2.q3;
import com.google.android.exoplayer2.upstream.z;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import na.u;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class a0 {
    public static q3 a(u.a aVar, List[] listArr) {
        boolean z;
        ImmutableList.a aVar2 = new ImmutableList.a();
        for (int i = 0; i < aVar.d(); i++) {
            v9.y f = aVar.f(i);
            List list = listArr[i];
            for (int i2 = 0; i2 < f.a; i2++) {
                v9.w b = f.b(i2);
                boolean z2 = aVar.a(i, i2, false) != 0;
                int i3 = b.a;
                int[] iArr = new int[i3];
                boolean[] zArr = new boolean[i3];
                for (int i4 = 0; i4 < b.a; i4++) {
                    iArr[i4] = aVar.g(i, i2, i4);
                    int i5 = 0;
                    while (true) {
                        if (i5 >= list.size()) {
                            z = false;
                            break;
                        }
                        v vVar = (v) list.get(i5);
                        if (vVar.getTrackGroup().equals(b) && vVar.indexOf(i4) != -1) {
                            z = true;
                            break;
                        }
                        i5++;
                    }
                    zArr[i4] = z;
                }
                aVar2.j(new q3.a(b, z2, iArr, zArr));
            }
        }
        v9.y h = aVar.h();
        for (int i6 = 0; i6 < h.a; i6++) {
            v9.w b2 = h.b(i6);
            int[] iArr2 = new int[b2.a];
            Arrays.fill(iArr2, 0);
            aVar2.j(new q3.a(b2, false, iArr2, new boolean[b2.a]));
        }
        return new q3(aVar2.n());
    }

    public static q3 b(u.a aVar, v[] vVarArr) {
        List[] listArr = new List[vVarArr.length];
        for (int i = 0; i < vVarArr.length; i++) {
            v vVar = vVarArr[i];
            listArr[i] = vVar != null ? ImmutableList.of(vVar) : ImmutableList.of();
        }
        return a(aVar, listArr);
    }

    public static z.a c(s sVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = sVar.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (sVar.d(i2, elapsedRealtime)) {
                i++;
            }
        }
        return new z.a(1, 0, length, i);
    }
}
