package kotlinx.serialization.json.internal;

import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i {
    public static final i a;
    public static final char[] b;
    public static final byte[] c;

    static {
        i iVar = new i();
        a = iVar;
        b = new char[Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE];
        c = new byte[126];
        iVar.f();
        iVar.e();
    }

    private i() {
    }

    private final void a(char c2, char c3) {
        b(c2, c3);
    }

    private final void b(int i, char c2) {
        if (c2 != 'u') {
            b[c2] = (char) i;
        }
    }

    private final void c(char c2, byte b2) {
        d(c2, b2);
    }

    private final void d(int i, byte b2) {
        c[i] = b2;
    }

    private final void e() {
        for (int i = 0; i < 33; i++) {
            d(i, Byte.MAX_VALUE);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(',', (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c('\"', (byte) 1);
        c('\\', (byte) 2);
    }

    private final void f() {
        for (int i = 0; i < 32; i++) {
            b(i, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a('/', '/');
        a('\"', '\"');
        a('\\', '\\');
    }
}
