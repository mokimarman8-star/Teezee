package i9;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface m extends com.google.android.exoplayer2.upstream.g {
    void advancePeekPosition(int i);

    boolean advancePeekPosition(int i, boolean z);

    int b(byte[] bArr, int i, int i2);

    long getLength();

    long getPeekPosition();

    long getPosition();

    void peekFully(byte[] bArr, int i, int i2);

    boolean peekFully(byte[] bArr, int i, int i2, boolean z);

    int read(byte[] bArr, int i, int i2);

    void readFully(byte[] bArr, int i, int i2);

    boolean readFully(byte[] bArr, int i, int i2, boolean z);

    void resetPeekPosition();

    int skip(int i);

    void skipFully(int i);
}
