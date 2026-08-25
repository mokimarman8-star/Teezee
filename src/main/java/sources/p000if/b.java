package p000if;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b implements HostnameVerifier {
    public static final b a = new b();
    private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private b() {
    }

    public static List a(X509Certificate x509Certificate) {
        List b2 = b(x509Certificate, 7);
        List b3 = b(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(b2.size() + b3.size());
        arrayList.addAll(b2);
        arrayList.addAll(b3);
        return arrayList;
    }

    private static List b(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    static boolean d(String str) {
        return b.matcher(str).matches();
    }

    private boolean e(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    private boolean f(String str, X509Certificate x509Certificate) {
        String b2;
        String lowerCase = str.toLowerCase(Locale.US);
        List b3 = b(x509Certificate, 2);
        int size = b3.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (e(lowerCase, (String) b3.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (b2 = new a(x509Certificate.getSubjectX500Principal()).b("cn")) == null) {
            return false;
        }
        return e(lowerCase, b2);
    }

    private boolean g(String str, X509Certificate x509Certificate) {
        List b2 = b(x509Certificate, 7);
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase((String) b2.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean c(String str, X509Certificate x509Certificate) {
        return d(str) ? g(str, x509Certificate) : f(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return c(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
