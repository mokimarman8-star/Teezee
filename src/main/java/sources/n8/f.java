package n8;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class f {
    private static String a(byte[] bArr, String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.reset();
        return Base64.encodeToString(messageDigest.digest(bArr), 0);
    }

    public static void b(HttpsURLConnection httpsURLConnection, Set set, Set set2) {
        for (Certificate certificate : httpsURLConnection.getServerCertificates()) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            String a = a(x509Certificate.getEncoded(), "SHA-1");
            if (set != null && set.contains(a)) {
                return;
            }
            String a2 = a(x509Certificate.getPublicKey().getEncoded(), "SHA-1");
            if (set2 != null && set2.contains(a2)) {
                return;
            }
        }
        throw new CertificateException("Unable to find valid certificate or public key.");
    }
}
