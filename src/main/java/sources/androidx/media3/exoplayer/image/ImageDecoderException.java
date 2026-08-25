package androidx.media3.exoplayer.image;

import androidx.annotation.Nullable;
import androidx.media3.decoder.DecoderException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ImageDecoderException extends DecoderException {
    public ImageDecoderException(String str) {
        super(str);
    }

    public ImageDecoderException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public ImageDecoderException(@Nullable Throwable th) {
        super(th);
    }
}
