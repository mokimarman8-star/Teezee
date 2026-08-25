package k2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c0 implements s {

    /* renamed from: a, reason: collision with root package name */
    private final s f16132a;

    public c0(s sVar) {
        this.f16132a = sVar;
    }

    @Override // k2.s
    public void advancePeekPosition(int i5) {
        this.f16132a.advancePeekPosition(i5);
    }

    @Override // k2.s
    public boolean advancePeekPosition(int i5, boolean z5) {
        return this.f16132a.advancePeekPosition(i5, z5);
    }

    @Override // k2.s
    public int b(byte[] bArr, int i5, int i6) {
        return this.f16132a.b(bArr, i5, i6);
    }

    @Override // k2.s
    public long getLength() {
        return this.f16132a.getLength();
    }

    @Override // k2.s
    public long getPeekPosition() {
        return this.f16132a.getPeekPosition();
    }

    @Override // k2.s
    public long getPosition() {
        return this.f16132a.getPosition();
    }

    @Override // k2.s
    public void peekFully(byte[] bArr, int i5, int i6) {
        this.f16132a.peekFully(bArr, i5, i6);
    }

    @Override // k2.s
    public boolean peekFully(byte[] bArr, int i5, int i6, boolean z5) {
        return this.f16132a.peekFully(bArr, i5, i6, z5);
    }

    @Override // k2.s, androidx.media3.common.j
    public int read(byte[] bArr, int i5, int i6) {
        return this.f16132a.read(bArr, i5, i6);
    }

    @Override // k2.s
    public void readFully(byte[] bArr, int i5, int i6) {
        this.f16132a.readFully(bArr, i5, i6);
    }

    @Override // k2.s
    public boolean readFully(byte[] bArr, int i5, int i6, boolean z5) {
        return this.f16132a.readFully(bArr, i5, i6, z5);
    }

    @Override // k2.s
    public void resetPeekPosition() {
        this.f16132a.resetPeekPosition();
    }

    @Override // k2.s
    public int skip(int i5) {
        return this.f16132a.skip(i5);
    }

    @Override // k2.s
    public void skipFully(int i5) {
        this.f16132a.skipFully(i5);
    }
}
