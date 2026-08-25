package tb;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import tb.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class h implements c {
    private static final Charset d = Charset.forName(C.UTF8_NAME);
    private final File a;
    private final int b;
    private g c;

    class a implements g.d {
        final /* synthetic */ byte[] a;
        final /* synthetic */ int[] b;

        a(byte[] bArr, int[] iArr) {
            this.a = bArr;
            this.b = iArr;
        }

        @Override // tb.g.d
        public void read(InputStream inputStream, int i) {
            try {
                inputStream.read(this.a, this.b[0], i);
                int[] iArr = this.b;
                iArr[0] = iArr[0] + i;
            } finally {
                inputStream.close();
            }
        }
    }

    private static class b {
        public final byte[] a;
        public final int b;

        b(byte[] bArr, int i) {
            this.a = bArr;
            this.b = i;
        }
    }

    h(File file, int i) {
        this.a = file;
        this.b = i;
    }

    private void f(long j, String str) {
        if (this.c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i = this.b / 4;
            if (str.length() > i) {
                str = "..." + str.substring(str.length() - i);
            }
            this.c.j(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(d));
            while (!this.c.p() && this.c.T() > this.b) {
                this.c.w();
            }
        } catch (IOException e) {
            qb.g.f().e("There was a problem writing to the Crashlytics log.", e);
        }
    }

    private b g() {
        if (!this.a.exists()) {
            return null;
        }
        h();
        g gVar = this.c;
        if (gVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[gVar.T()];
        try {
            this.c.n(new a(bArr, iArr));
        } catch (IOException e) {
            qb.g.f().e("A problem occurred while reading the Crashlytics log file.", e);
        }
        return new b(bArr, iArr[0]);
    }

    private void h() {
        if (this.c == null) {
            try {
                this.c = new g(this.a);
            } catch (IOException e) {
                qb.g.f().e("Could not open log file: " + this.a, e);
            }
        }
    }

    @Override // tb.c
    public void a() {
        CommonUtils.f(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
    }

    @Override // tb.c
    public String b() {
        byte[] c = c();
        if (c != null) {
            return new String(c, d);
        }
        return null;
    }

    @Override // tb.c
    public byte[] c() {
        b g = g();
        if (g == null) {
            return null;
        }
        int i = g.b;
        byte[] bArr = new byte[i];
        System.arraycopy(g.a, 0, bArr, 0, i);
        return bArr;
    }

    @Override // tb.c
    public void d() {
        a();
        this.a.delete();
    }

    @Override // tb.c
    public void e(long j, String str) {
        h();
        f(j, str);
    }
}
