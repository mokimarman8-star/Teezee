package q9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.util.d0;
import i9.a0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class m {
    private static final com.google.common.base.o d = com.google.common.base.o.f(':');
    private static final com.google.common.base.o e = com.google.common.base.o.f('*');
    private final List a = new ArrayList();
    private int b = 0;
    private int c;

    private static final class a {
        public final int a;
        public final long b;
        public final int c;

        public a(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }
    }

    private void a(i9.m mVar, a0 a0Var) {
        d0 d0Var = new d0(8);
        mVar.readFully(d0Var.d(), 0, 8);
        this.c = d0Var.q() + 8;
        if (d0Var.n() != 1397048916) {
            a0Var.a = 0L;
        } else {
            a0Var.a = mVar.getPosition() - (this.c - 12);
            this.b = 2;
        }
    }

    private static int b(String str) {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw ParserException.createForMalformedContainer("Invalid SEF name", (Throwable) null);
        }
    }

    private void d(i9.m mVar, a0 a0Var) {
        long length = mVar.getLength();
        int i = this.c - 20;
        d0 d0Var = new d0(i);
        mVar.readFully(d0Var.d(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            d0Var.Q(2);
            short s = d0Var.s();
            if (s == 2192 || s == 2816 || s == 2817 || s == 2819 || s == 2820) {
                this.a.add(new a(s, (length - this.c) - d0Var.q(), d0Var.q()));
            } else {
                d0Var.Q(8);
            }
        }
        if (this.a.isEmpty()) {
            a0Var.a = 0L;
        } else {
            this.b = 3;
            a0Var.a = ((a) this.a.get(0)).b;
        }
    }

    private void e(i9.m mVar, List list) {
        long position = mVar.getPosition();
        int length = (int) ((mVar.getLength() - mVar.getPosition()) - this.c);
        d0 d0Var = new d0(length);
        mVar.readFully(d0Var.d(), 0, length);
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = (a) this.a.get(i);
            d0Var.P((int) (aVar.b - position));
            d0Var.Q(4);
            int q = d0Var.q();
            int b = b(d0Var.A(q));
            int i2 = aVar.c - (q + 8);
            if (b == 2192) {
                list.add(f(d0Var, i2));
            } else if (b != 2816 && b != 2817 && b != 2819 && b != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    private static SlowMotionData f(d0 d0Var, int i) {
        ArrayList arrayList = new ArrayList();
        List i2 = e.i(d0Var.A(i));
        for (int i3 = 0; i3 < i2.size(); i3++) {
            List i4 = d.i((CharSequence) i2.get(i3));
            if (i4.size() != 3) {
                throw ParserException.createForMalformedContainer((String) null, (Throwable) null);
            }
            try {
                arrayList.add(new SlowMotionData.Segment(Long.parseLong((String) i4.get(0)), Long.parseLong((String) i4.get(1)), 1 << (Integer.parseInt((String) i4.get(2)) - 1)));
            } catch (NumberFormatException e2) {
                throw ParserException.createForMalformedContainer((String) null, e2);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public int c(i9.m mVar, a0 a0Var, List list) {
        int i = this.b;
        long j = 0;
        if (i == 0) {
            long length = mVar.getLength();
            if (length != -1 && length >= 8) {
                j = length - 8;
            }
            a0Var.a = j;
            this.b = 1;
        } else if (i == 1) {
            a(mVar, a0Var);
        } else if (i == 2) {
            d(mVar, a0Var);
        } else {
            if (i != 3) {
                throw new IllegalStateException();
            }
            e(mVar, list);
            a0Var.a = 0L;
        }
        return 1;
    }

    public void g() {
        this.a.clear();
        this.b = 0;
    }
}
