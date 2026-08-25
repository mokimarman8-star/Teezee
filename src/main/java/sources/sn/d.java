package sn;

import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final a a = new a(null);
    private static final String[] b = {"0", MsgStyle.CUSTOM_LEFT_PIC, "2", MsgStyle.NATIVE_STANDARD, MsgStyle.CUSTOM_BUTTON, MsgStyle.CUSTOM_LEFT_PIC_EMOJI, "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            Intrinsics.h(str, "buf");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5);
                Intrinsics.g(messageDigest, "getInstance(...)");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.g(forName, "forName(...)");
                byte[] bytes = str.getBytes(forName);
                Intrinsics.g(bytes, "getBytes(...)");
                messageDigest.update(bytes);
                String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                if (bigInteger.length() >= 32) {
                    Intrinsics.e(bigInteger);
                    return bigInteger;
                }
                int length = 32 - bigInteger.length();
                String str2 = BuildConfig.FLAVOR;
                for (int i = 0; i < length; i++) {
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
