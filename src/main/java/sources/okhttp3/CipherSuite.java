package okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\t"}, d2 = {"Lokhttp3/CipherSuite;", "", "javaName", "", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class CipherSuite {
    public static final Companion Companion;
    private static final Map<String, CipherSuite> INSTANCES;
    private static final Comparator<String> ORDER_BY_NAME;

    @JvmField
    public static final CipherSuite TLS_AES_128_CCM_8_SHA256;

    @JvmField
    public static final CipherSuite TLS_AES_128_CCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_AES_128_GCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_AES_256_GCM_SHA384;

    @JvmField
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256;

    @JvmField
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5;

    @JvmField
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384;

    @JvmField
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384;

    @JvmField
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384;

    @JvmField
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384;

    @JvmField
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384;

    @JvmField
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA;

    @JvmField
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA;

    @JvmField
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV;

    @JvmField
    public static final CipherSuite TLS_FALLBACK_SCSV;

    @JvmField
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5;

    @JvmField
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA;

    @JvmField
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5;

    @JvmField
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA;

    @JvmField
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5;

    @JvmField
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5;

    @JvmField
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5;

    @JvmField
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA;

    @JvmField
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA;

    @JvmField
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA;
    private final String javaName;

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        ORDER_BY_NAME = new Comparator<String>() { // from class: okhttp3.CipherSuite$Companion$ORDER_BY_NAME$1
            @Override // java.util.Comparator
            public int compare(String a, String b) {
                Intrinsics.h(a, "a");
                Intrinsics.h(b, "b");
                int min = Math.min(a.length(), b.length());
                for (int i = 4; i < min; i++) {
                    char charAt = a.charAt(i);
                    char charAt2 = b.charAt(i);
                    if (charAt != charAt2) {
                        return Intrinsics.j(charAt, charAt2) < 0 ? -1 : 1;
                    }
                }
                int length = a.length();
                int length2 = b.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        INSTANCES = new LinkedHashMap();
        TLS_RSA_WITH_NULL_MD5 = Companion.access$init(companion, "SSL_RSA_WITH_NULL_MD5", 1);
        TLS_RSA_WITH_NULL_SHA = Companion.access$init(companion, "SSL_RSA_WITH_NULL_SHA", 2);
        TLS_RSA_EXPORT_WITH_RC4_40_MD5 = Companion.access$init(companion, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        TLS_RSA_WITH_RC4_128_MD5 = Companion.access$init(companion, "SSL_RSA_WITH_RC4_128_MD5", 4);
        TLS_RSA_WITH_RC4_128_SHA = Companion.access$init(companion, "SSL_RSA_WITH_RC4_128_SHA", 5);
        TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.access$init(companion, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        TLS_RSA_WITH_DES_CBC_SHA = Companion.access$init(companion, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        TLS_RSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = Companion.access$init(companion, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        TLS_DHE_DSS_WITH_DES_CBC_SHA = Companion.access$init(companion, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.access$init(companion, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        TLS_DHE_RSA_WITH_DES_CBC_SHA = Companion.access$init(companion, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = Companion.access$init(companion, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        TLS_DH_anon_WITH_RC4_128_MD5 = Companion.access$init(companion, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = Companion.access$init(companion, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        TLS_DH_anon_WITH_DES_CBC_SHA = Companion.access$init(companion, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        TLS_KRB5_WITH_DES_CBC_SHA = Companion.access$init(companion, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        TLS_KRB5_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        TLS_KRB5_WITH_RC4_128_SHA = Companion.access$init(companion, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        TLS_KRB5_WITH_DES_CBC_MD5 = Companion.access$init(companion, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = Companion.access$init(companion, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        TLS_KRB5_WITH_RC4_128_MD5 = Companion.access$init(companion, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        TLS_KRB5_EXPORT_WITH_RC4_40_SHA = Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        TLS_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        TLS_DH_anon_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        TLS_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        TLS_DH_anon_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        TLS_RSA_WITH_NULL_SHA256 = Companion.access$init(companion, "TLS_RSA_WITH_NULL_SHA256", 59);
        TLS_RSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(companion, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        TLS_RSA_WITH_AES_256_CBC_SHA256 = Companion.access$init(companion, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.access$init(companion, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = Companion.access$init(companion, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.access$init(companion, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        TLS_DH_anon_WITH_AES_128_CBC_SHA256 = Companion.access$init(companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        TLS_DH_anon_WITH_AES_256_CBC_SHA256 = Companion.access$init(companion, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.access$init(companion, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = Companion.access$init(companion, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.access$init(companion, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        TLS_PSK_WITH_RC4_128_SHA = Companion.access$init(companion, "TLS_PSK_WITH_RC4_128_SHA", 138);
        TLS_PSK_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        TLS_PSK_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        TLS_PSK_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        TLS_RSA_WITH_SEED_CBC_SHA = Companion.access$init(companion, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        TLS_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        TLS_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        TLS_DH_anon_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        TLS_DH_anon_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        TLS_EMPTY_RENEGOTIATION_INFO_SCSV = Companion.access$init(companion, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        TLS_FALLBACK_SCSV = Companion.access$init(companion, "TLS_FALLBACK_SCSV", 22016);
        TLS_ECDH_ECDSA_WITH_NULL_SHA = Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        TLS_ECDH_ECDSA_WITH_RC4_128_SHA = Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        TLS_ECDHE_ECDSA_WITH_NULL_SHA = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        TLS_ECDH_RSA_WITH_NULL_SHA = Companion.access$init(companion, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        TLS_ECDH_RSA_WITH_RC4_128_SHA = Companion.access$init(companion, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        TLS_ECDHE_RSA_WITH_NULL_SHA = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        TLS_ECDHE_RSA_WITH_RC4_128_SHA = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        TLS_ECDH_anon_WITH_NULL_SHA = Companion.access$init(companion, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        TLS_ECDH_anon_WITH_RC4_128_SHA = Companion.access$init(companion, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = Companion.access$init(companion, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        TLS_ECDH_anon_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        TLS_ECDH_anon_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = Companion.access$init(companion, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(companion, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(companion, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(companion, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = Companion.access$init(companion, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        TLS_AES_128_GCM_SHA256 = Companion.access$init(companion, "TLS_AES_128_GCM_SHA256", 4865);
        TLS_AES_256_GCM_SHA384 = Companion.access$init(companion, "TLS_AES_256_GCM_SHA384", 4866);
        TLS_CHACHA20_POLY1305_SHA256 = Companion.access$init(companion, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        TLS_AES_128_CCM_SHA256 = Companion.access$init(companion, "TLS_AES_128_CCM_SHA256", 4868);
        TLS_AES_128_CCM_8_SHA256 = Companion.access$init(companion, "TLS_AES_128_CCM_8_SHA256", 4869);
    }

    private CipherSuite(String str) {
        this.javaName = str;
    }

    public /* synthetic */ CipherSuite(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @JvmStatic
    public static final synchronized CipherSuite forJavaName(String str) {
        CipherSuite forJavaName;
        synchronized (CipherSuite.class) {
            forJavaName = Companion.forJavaName(str);
        }
        return forJavaName;
    }

    @Deprecated
    @JvmName
    /* renamed from: -deprecated_javaName, reason: not valid java name and from getter */
    public final String getJavaName() {
        return this.javaName;
    }

    @JvmName
    public final String javaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }
}
