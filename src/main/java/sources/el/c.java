package el;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class c implements e {
    private final String b;
    private URL c;
    private volatile byte[] d;

    public c(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url must be can not null or empty");
        }
        this.b = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
    }

    @Override // el.e
    public void a(MessageDigest messageDigest) {
        if (this.d == null) {
            this.d = this.b.getBytes(e.a);
        }
        messageDigest.update(this.d);
    }

    public URL b() {
        if (this.c == null) {
            this.c = new URL(this.b);
        }
        return this.c;
    }

    public String toString() {
        return this.b;
    }
}
