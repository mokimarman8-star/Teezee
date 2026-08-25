package ma;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class h extends da.h {
    private final d0 o;
    private final c p;

    public h() {
        super("WebvttDecoder");
        this.o = new d0();
        this.p = new c();
    }

    private static int x(d0 d0Var) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = d0Var.e();
            String p = d0Var.p();
            i = p == null ? 0 : "STYLE".equals(p) ? 2 : p.startsWith("NOTE") ? 1 : 3;
        }
        d0Var.P(i2);
        return i;
    }

    private static void y(d0 d0Var) {
        while (!TextUtils.isEmpty(d0Var.p())) {
        }
    }

    @Override // da.h
    protected da.i w(byte[] bArr, int i, boolean z) {
        e m;
        this.o.N(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            i.e(this.o);
            while (!TextUtils.isEmpty(this.o.p())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int x = x(this.o);
                if (x == 0) {
                    return new k(arrayList2);
                }
                if (x == 1) {
                    y(this.o);
                } else if (x == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.o.p();
                    arrayList.addAll(this.p.d(this.o));
                } else if (x == 3 && (m = f.m(this.o, arrayList)) != null) {
                    arrayList2.add(m);
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }
}
