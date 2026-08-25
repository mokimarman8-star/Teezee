package fl;

import android.util.LruCache;
import com.transsion.api.gateway.utils.EncoderUtil;
import fl.k;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kl.c;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class i {
    private final LruCache a = new LruCache(1000);
    private final kl.f b = kl.c.c(10, new a(this));

    class a implements c.a {
        a(i iVar) {
        }

        @Override // kl.c.a
        public Object create() {
            try {
                return new b(MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static final class b implements c.b {
        private final MessageDigest a;
        private final k b = new k.b(null);

        b(MessageDigest messageDigest) {
            this.a = messageDigest;
        }

        @Override // kl.c.b
        public k getVerifier() {
            return this.b;
        }
    }

    public String a(el.e eVar) {
        String str;
        synchronized (this.a) {
            str = (String) this.a.get(eVar);
        }
        if (str == null) {
            b bVar = (b) this.b.acquire();
            try {
                eVar.a(bVar.a);
                str = d.a(bVar.a.digest());
            } finally {
                this.b.release(bVar);
            }
        }
        synchronized (this.a) {
            this.a.put(eVar, str);
        }
        return str;
    }
}
