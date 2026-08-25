package ak;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.GregorianCalendar;
import javax.security.auth.x500.X500Principal;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class e {
    private static e a;

    private e() {
    }

    public static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            try {
                if (a == null) {
                    a = new e();
                }
                eVar = a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    private boolean c() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return (((PrivateKey) keyStore.getKey("crypto", null)) == null || keyStore.getCertificate("crypto").getPublicKey() == null) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(Context context) {
        if (c()) {
            return true;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.add(1, 100);
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder("crypto", 3);
            builder.setCertificateSubject(new X500Principal("CN=crypto")).setEncryptionPaddings("PKCS1Padding").setCertificateSerialNumber(BigInteger.valueOf(1337L)).setCertificateNotBefore(gregorianCalendar.getTime()).setCertificateNotAfter(gregorianCalendar2.getTime());
            keyPairGenerator.initialize(builder.build());
            keyPairGenerator.generateKeyPair();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
