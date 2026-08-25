package o9;

import com.google.android.exoplayer2.util.d0;
import i9.m;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class f {
    private final d0 a = new d0(8);
    private int b;

    private long a(m mVar) {
        int i = 0;
        mVar.peekFully(this.a.d(), 0, 1);
        int i2 = this.a.d()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        mVar.peekFully(this.a.d(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.d()[i] & 255) + (i5 << 8);
        }
        this.b += i4 + 1;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(m mVar) {
        long length = mVar.getLength();
        long j = 1024;
        if (length != -1 && length <= 1024) {
            j = length;
        }
        int i = (int) j;
        mVar.peekFully(this.a.d(), 0, 4);
        long F = this.a.F();
        this.b = 4;
        while (F != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            mVar.peekFully(this.a.d(), 0, 1);
            F = ((F << 8) & (-256)) | (this.a.d()[0] & 255);
        }
        long a = a(mVar);
        long j2 = this.b;
        if (a == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j2 + a >= length) {
            return false;
        }
        while (true) {
            int i3 = this.b;
            long j3 = j2 + a;
            if (i3 >= j3) {
                return ((long) i3) == j3;
            }
            if (a(mVar) == Long.MIN_VALUE) {
                return false;
            }
            long a2 = a(mVar);
            if (a2 < 0 || a2 > 2147483647L) {
                break;
            }
            if (a2 != 0) {
                int i4 = (int) a2;
                mVar.advancePeekPosition(i4);
                this.b += i4;
            }
        }
    }
}
