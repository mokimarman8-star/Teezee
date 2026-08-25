package androidx.core.net;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ParseException extends RuntimeException {
    public final String response;

    ParseException(String str) {
        super(str);
        this.response = str;
    }
}
