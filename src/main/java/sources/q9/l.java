package q9;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class l {

    private static class a {
        private final UUID a;
        private final int b;
        private final byte[] c;

        public a(UUID uuid, int i, byte[] bArr) {
            this.a = uuid;
            this.b = i;
            this.c = bArr;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    private static a d(byte[] bArr) {
        d0 d0Var = new d0(bArr);
        if (d0Var.f() < 32) {
            return null;
        }
        d0Var.P(0);
        if (d0Var.n() != d0Var.a() + 4 || d0Var.n() != 1886614376) {
            return null;
        }
        int c = q9.a.c(d0Var.n());
        if (c > 1) {
            s.i("PsshAtomUtil", "Unsupported pssh version: " + c);
            return null;
        }
        UUID uuid = new UUID(d0Var.w(), d0Var.w());
        if (c == 1) {
            d0Var.Q(d0Var.H() * 16);
        }
        int H = d0Var.H();
        if (H != d0Var.a()) {
            return null;
        }
        byte[] bArr2 = new byte[H];
        d0Var.j(bArr2, 0, H);
        return new a(uuid, c, bArr2);
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        a d = d(bArr);
        if (d == null) {
            return null;
        }
        if (uuid.equals(d.a)) {
            return d.c;
        }
        s.i("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + d.a + TmcConstants.EXTENSION_SEPARATOR);
        return null;
    }

    public static UUID f(byte[] bArr) {
        a d = d(bArr);
        if (d == null) {
            return null;
        }
        return d.a;
    }

    public static int g(byte[] bArr) {
        a d = d(bArr);
        if (d == null) {
            return -1;
        }
        return d.b;
    }
}
