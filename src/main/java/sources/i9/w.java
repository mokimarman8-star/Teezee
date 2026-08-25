package i9;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class w implements m {
    private final m a;

    public w(m mVar) {
        this.a = mVar;
    }

    @Override // i9.m
    public void advancePeekPosition(int i) {
        this.a.advancePeekPosition(i);
    }

    @Override // i9.m
    public boolean advancePeekPosition(int i, boolean z) {
        return this.a.advancePeekPosition(i, z);
    }

    @Override // i9.m
    public int b(byte[] bArr, int i, int i2) {
        return this.a.b(bArr, i, i2);
    }

    @Override // i9.m
    public long getLength() {
        return this.a.getLength();
    }

    @Override // i9.m
    public long getPeekPosition() {
        return this.a.getPeekPosition();
    }

    @Override // i9.m
    public long getPosition() {
        return this.a.getPosition();
    }

    @Override // i9.m
    public void peekFully(byte[] bArr, int i, int i2) {
        this.a.peekFully(bArr, i, i2);
    }

    @Override // i9.m
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) {
        return this.a.peekFully(bArr, i, i2, z);
    }

    @Override // i9.m
    public int read(byte[] bArr, int i, int i2) {
        return this.a.read(bArr, i, i2);
    }

    @Override // i9.m
    public void readFully(byte[] bArr, int i, int i2) {
        this.a.readFully(bArr, i, i2);
    }

    @Override // i9.m
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) {
        return this.a.readFully(bArr, i, i2, z);
    }

    @Override // i9.m
    public void resetPeekPosition() {
        this.a.resetPeekPosition();
    }

    @Override // i9.m
    public int skip(int i) {
        return this.a.skip(i);
    }

    @Override // i9.m
    public void skipFully(int i) {
        this.a.skipFully(i);
    }
}
