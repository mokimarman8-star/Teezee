package r3;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final int f17585a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f17586b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17587c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f17588d;

    /* renamed from: e, reason: collision with root package name */
    public int f17589e;

    public w(int i5, int i6) {
        this.f17585a = i5;
        byte[] bArr = new byte[i6 + 3];
        this.f17588d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i5, int i6) {
        if (this.f17586b) {
            int i7 = i6 - i5;
            byte[] bArr2 = this.f17588d;
            int length = bArr2.length;
            int i8 = this.f17589e;
            if (length < i8 + i7) {
                this.f17588d = Arrays.copyOf(bArr2, (i8 + i7) * 2);
            }
            System.arraycopy(bArr, i5, this.f17588d, this.f17589e, i7);
            this.f17589e += i7;
        }
    }

    public boolean b(int i5) {
        if (!this.f17586b) {
            return false;
        }
        this.f17589e -= i5;
        this.f17586b = false;
        this.f17587c = true;
        return true;
    }

    public boolean c() {
        return this.f17587c;
    }

    public void d() {
        this.f17586b = false;
        this.f17587c = false;
    }

    public void e(int i5) {
        androidx.media3.common.util.a.g(!this.f17586b);
        boolean z5 = i5 == this.f17585a;
        this.f17586b = z5;
        if (z5) {
            this.f17589e = 3;
            this.f17587c = false;
        }
    }
}
