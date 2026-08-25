package androidx.media3.common;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ParserException extends IOException {
    public final boolean contentIsMalformed;
    public final int dataType;

    protected ParserException(@Nullable String str, @Nullable Throwable th, boolean z5, int i5) {
        super(str, th);
        this.contentIsMalformed = z5;
        this.dataType = i5;
    }

    public static ParserException createForMalformedContainer(@Nullable String str, @Nullable Throwable th) {
        return new ParserException(str, th, true, 1);
    }

    public static ParserException createForMalformedDataOfUnknownType(@Nullable String str, @Nullable Throwable th) {
        return new ParserException(str, th, true, 0);
    }

    public static ParserException createForMalformedManifest(@Nullable String str, @Nullable Throwable th) {
        return new ParserException(str, th, true, 4);
    }

    public static ParserException createForManifestWithUnsupportedFeature(@Nullable String str, @Nullable Throwable th) {
        return new ParserException(str, th, false, 4);
    }

    public static ParserException createForUnsupportedContainerFeature(@Nullable String str) {
        return new ParserException(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String message = super.getMessage();
        StringBuilder sb = new StringBuilder();
        if (message != null) {
            str = message + " ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("{contentIsMalformed=");
        sb.append(this.contentIsMalformed);
        sb.append(", dataType=");
        sb.append(this.dataType);
        sb.append("}");
        return sb.toString();
    }
}
