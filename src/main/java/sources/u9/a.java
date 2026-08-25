package u9;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.c0;
import com.google.common.base.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends g {
    private static Metadata c(c0 c0Var) {
        c0Var.r(12);
        int d = (c0Var.d() + c0Var.h(12)) - 4;
        c0Var.r(44);
        c0Var.s(c0Var.h(12));
        c0Var.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (c0Var.d() >= d) {
                break;
            }
            c0Var.r(48);
            int h = c0Var.h(8);
            c0Var.r(4);
            int d2 = c0Var.d() + c0Var.h(12);
            String str2 = null;
            while (c0Var.d() < d2) {
                int h2 = c0Var.h(8);
                int h3 = c0Var.h(8);
                int d3 = c0Var.d() + h3;
                if (h2 == 2) {
                    int h4 = c0Var.h(16);
                    c0Var.r(8);
                    if (h4 == 3) {
                        while (c0Var.d() < d3) {
                            str = c0Var.l(c0Var.h(8), c.a);
                            int h5 = c0Var.h(8);
                            for (int i = 0; i < h5; i++) {
                                c0Var.s(c0Var.h(8));
                            }
                        }
                    }
                } else if (h2 == 21) {
                    str2 = c0Var.l(h3, c.a);
                }
                c0Var.p(d3 * 8);
            }
            c0Var.p(d2 * 8);
            if (str != null && str2 != null) {
                arrayList.add(new AppInfoTable(h, str + str2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    protected Metadata b(d dVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new c0(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
