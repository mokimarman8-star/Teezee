package k9;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.common.collect.ImmutableList;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class g implements a {
    public final p1 a;

    public g(p1 p1Var) {
        this.a = p1Var;
    }

    private static String a(int i) {
        switch (i) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    private static String b(int i) {
        if (i == 1) {
            return "audio/raw";
        }
        if (i == 85) {
            return "audio/mpeg";
        }
        if (i == 255) {
            return "audio/mp4a-latm";
        }
        if (i == 8192) {
            return "audio/ac3";
        }
        if (i != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }

    private static a c(d0 d0Var) {
        d0Var.Q(4);
        int q = d0Var.q();
        int q2 = d0Var.q();
        d0Var.Q(4);
        int q3 = d0Var.q();
        String a = a(q3);
        if (a != null) {
            p1.b bVar = new p1.b();
            bVar.j0(q).Q(q2).e0(a);
            return new g(bVar.E());
        }
        s.i("StreamFormatChunk", "Ignoring track with unsupported compression " + q3);
        return null;
    }

    public static a d(int i, d0 d0Var) {
        if (i == 2) {
            return c(d0Var);
        }
        if (i == 1) {
            return e(d0Var);
        }
        s.i("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + p0.m0(i));
        return null;
    }

    private static a e(d0 d0Var) {
        int v = d0Var.v();
        String b = b(v);
        if (b == null) {
            s.i("StreamFormatChunk", "Ignoring track with unsupported format tag " + v);
            return null;
        }
        int v2 = d0Var.v();
        int q = d0Var.q();
        d0Var.Q(6);
        int c0 = p0.c0(d0Var.J());
        int v3 = d0Var.v();
        byte[] bArr = new byte[v3];
        d0Var.j(bArr, 0, v3);
        p1.b bVar = new p1.b();
        bVar.e0(b).H(v2).f0(q);
        if ("audio/raw".equals(b) && c0 != 0) {
            bVar.Y(c0);
        }
        if ("audio/mp4a-latm".equals(b) && v3 > 0) {
            bVar.T(ImmutableList.of(bArr));
        }
        return new g(bVar.E());
    }

    @Override // k9.a
    public int getType() {
        return 1718776947;
    }
}
