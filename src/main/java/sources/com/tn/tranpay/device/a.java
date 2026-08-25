package com.tn.tranpay.device;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a {
    public static final C0038a a = new C0038a(null);
    private static final String[] b = {"0", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, "a", "b", "c", "d", "e", "f"};

    /* renamed from: com.tn.tranpay.device.a$a, reason: collision with other inner class name */
    public static final class C0038a {
        private C0038a() {
        }

        public /* synthetic */ C0038a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            Intrinsics.h(str, "buf");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Intrinsics.g(messageDigest, "getInstance(\"MD5\")");
                Charset forName = Charset.forName(TmcConstants.DEFAULT_ENCODING);
                Intrinsics.g(forName, "forName(...)");
                byte[] bytes = str.getBytes(forName);
                Intrinsics.g(bytes, "getBytes(...)");
                messageDigest.update(bytes);
                String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                if (bigInteger.length() >= 32) {
                    Intrinsics.g(bigInteger, "tempString");
                    return bigInteger;
                }
                String str2 = "";
                for (int i = 0; i < 32 - bigInteger.length(); i++) {
                    str2 = "0" + str2;
                }
                return str2 + bigInteger;
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
    }
}
