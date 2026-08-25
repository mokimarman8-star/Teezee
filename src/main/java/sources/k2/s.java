package k2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface s extends androidx.media3.common.j {
    void advancePeekPosition(int i5);

    boolean advancePeekPosition(int i5, boolean z5);

    int b(byte[] bArr, int i5, int i6);

    long getLength();

    long getPeekPosition();

    long getPosition();

    void peekFully(byte[] bArr, int i5, int i6);

    boolean peekFully(byte[] bArr, int i5, int i6, boolean z5);

    @Override // androidx.media3.common.j
    int read(byte[] bArr, int i5, int i6);

    void readFully(byte[] bArr, int i5, int i6);

    boolean readFully(byte[] bArr, int i5, int i6, boolean z5);

    void resetPeekPosition();

    int skip(int i5);

    void skipFully(int i5);
}
