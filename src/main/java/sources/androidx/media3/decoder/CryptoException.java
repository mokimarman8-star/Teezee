package androidx.media3.decoder;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class CryptoException extends Exception {
    public final int errorCode;

    public CryptoException(int i5, String str) {
        super(str);
        this.errorCode = i5;
    }
}
