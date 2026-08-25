package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected int f7893a;

    /* renamed from: b, reason: collision with root package name */
    protected ByteBuffer f7894b;

    /* renamed from: c, reason: collision with root package name */
    private int f7895c;

    /* renamed from: d, reason: collision with root package name */
    private int f7896d;

    /* renamed from: e, reason: collision with root package name */
    f f7897e = f.a();

    protected int a(int i5) {
        return i5 + this.f7894b.getInt(i5);
    }

    protected int b(int i5) {
        if (i5 < this.f7896d) {
            return this.f7894b.getShort(this.f7895c + i5);
        }
        return 0;
    }

    protected void c(int i5, ByteBuffer byteBuffer) {
        this.f7894b = byteBuffer;
        if (byteBuffer == null) {
            this.f7893a = 0;
            this.f7895c = 0;
            this.f7896d = 0;
        } else {
            this.f7893a = i5;
            int i6 = i5 - byteBuffer.getInt(i5);
            this.f7895c = i6;
            this.f7896d = this.f7894b.getShort(i6);
        }
    }

    protected int d(int i5) {
        int i6 = i5 + this.f7893a;
        return i6 + this.f7894b.getInt(i6) + 4;
    }

    protected int e(int i5) {
        int i6 = i5 + this.f7893a;
        return this.f7894b.getInt(i6 + this.f7894b.getInt(i6));
    }

    protected int f(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }
}
