package wg;

import com.bumptech.glide.load.Key;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    public static final C0160a a = new C0160a(null);
    private static final String[] b = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* renamed from: wg.a$a, reason: collision with other inner class name */
    public static final class C0160a {
        private C0160a() {
        }

        public /* synthetic */ C0160a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(byte[] bArr) {
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArr) {
                stringBuffer.append(c(b));
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.g(stringBuffer2, "toString(...)");
            return stringBuffer2;
        }

        private final String c(byte b) {
            int i = b;
            if (b < 0) {
                i = b + 256;
            }
            return a.b[i / 16] + a.b[i % 16];
        }

        public final String a(String str) {
            Intrinsics.h(str, "data");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bytes = str.getBytes(Charsets.b);
                Intrinsics.g(bytes, "getBytes(...)");
                byte[] digest = messageDigest.digest(bytes);
                Intrinsics.g(digest, "digest(...)");
                return b(digest);
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }

        public final String d(String str) {
            Intrinsics.h(str, "buf");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Intrinsics.g(messageDigest, "getInstance(...)");
                Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
                Intrinsics.g(forName, "forName(...)");
                byte[] bytes = str.getBytes(forName);
                Intrinsics.g(bytes, "getBytes(...)");
                messageDigest.update(bytes);
                String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                if (bigInteger.length() >= 32) {
                    Intrinsics.e(bigInteger);
                    return bigInteger;
                }
                String str2 = "";
                for (int i = 0; i < 32 - bigInteger.length(); i++) {
                    str2 = '0' + str2;
                }
                return str2 + bigInteger;
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
    }
}
