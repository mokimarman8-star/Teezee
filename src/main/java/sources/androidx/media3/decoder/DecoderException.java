package androidx.media3.decoder;

import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DecoderException extends Exception {
    public DecoderException(String str) {
        super(str);
    }

    public DecoderException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public DecoderException(@Nullable Throwable th) {
        super(th);
    }
}
