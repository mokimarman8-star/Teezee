package s9;

import android.util.SparseArray;
import com.cloud.tmc.kernel.constants.LauncherLifecycleType;
import com.google.android.exoplayer2.p1;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class j implements i0.c {
    private final int a;
    private final List b;

    public j() {
        this(0);
    }

    public j(int i) {
        this(i, ImmutableList.of());
    }

    public j(int i, List list) {
        this.a = i;
        this.b = list;
    }

    private d0 b(i0.b bVar) {
        return new d0(d(bVar));
    }

    private k0 c(i0.b bVar) {
        return new k0(d(bVar));
    }

    private List d(i0.b bVar) {
        String str;
        int i;
        if (e(32)) {
            return this.b;
        }
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(bVar.d);
        List list = this.b;
        while (d0Var.a() > 0) {
            int D = d0Var.D();
            int e = d0Var.e() + d0Var.D();
            if (D == 134) {
                list = new ArrayList();
                int D2 = d0Var.D() & 31;
                for (int i2 = 0; i2 < D2; i2++) {
                    String A = d0Var.A(3);
                    int D3 = d0Var.D();
                    boolean z = (D3 & 128) != 0;
                    if (z) {
                        i = D3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte D4 = (byte) d0Var.D();
                    d0Var.Q(1);
                    list.add(new p1.b().e0(str).V(A).F(i).T(z ? com.google.android.exoplayer2.util.f.b((D4 & 64) != 0) : null).E());
                }
            }
            d0Var.P(e);
        }
        return list;
    }

    private boolean e(int i) {
        return (i & this.a) != 0;
    }

    @Override // s9.i0.c
    public i0 a(int i, i0.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new w(new t(bVar.b));
            }
            if (i == 21) {
                return new w(new r());
            }
            if (i == 27) {
                if (e(4)) {
                    return null;
                }
                return new w(new p(b(bVar), e(1), e(8)));
            }
            if (i == 36) {
                return new w(new q(b(bVar)));
            }
            if (i == 89) {
                return new w(new l(bVar.c));
            }
            if (i != 138) {
                if (i == 172) {
                    return new w(new f(bVar.b));
                }
                if (i == 257) {
                    return new c0(new v("application/vnd.dvb.ait"));
                }
                if (i == 134) {
                    if (e(16)) {
                        return null;
                    }
                    return new c0(new v("application/x-scte35"));
                }
                if (i != 135) {
                    switch (i) {
                        case 15:
                            if (!e(2)) {
                                break;
                            }
                            break;
                        case 16:
                            break;
                        case LauncherLifecycleType.LAUNCHER_MINIAPP_START /* 17 */:
                            if (!e(2)) {
                                break;
                            }
                            break;
                        default:
                            switch (i) {
                                case 130:
                                    if (!e(64)) {
                                    }
                                    break;
                            }
                    }
                    return null;
                }
                return new w(new c(bVar.b));
            }
            return new w(new k(bVar.b));
        }
        return new w(new n(c(bVar)));
    }

    @Override // s9.i0.c
    public SparseArray createInitialPayloadReaders() {
        return new SparseArray();
    }
}
