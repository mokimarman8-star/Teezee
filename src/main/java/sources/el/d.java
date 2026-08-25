package el;

import android.net.Uri;
import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class d implements e {
    private volatile byte[] b;
    private final String c;

    public d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url must be can not null or empty");
        }
        this.c = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
    }

    @Override // el.e
    public void a(MessageDigest messageDigest) {
        if (this.b == null) {
            this.b = this.c.getBytes(e.a);
        }
        messageDigest.update(this.b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return kl.e.a(this.c).equals(kl.e.a(((d) obj).c));
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode() * 31;
    }
}
