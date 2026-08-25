package kl;

import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.push.bean.MsgStyle;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class e {
    private static final String[] a = {"0", MsgStyle.CUSTOM_LEFT_PIC, "2", MsgStyle.NATIVE_STANDARD, MsgStyle.CUSTOM_BUTTON, MsgStyle.CUSTOM_LEFT_PIC_EMOJI, "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String a(String str) {
        try {
            return b(MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5).digest(str.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(c(b));
        }
        return stringBuffer.toString();
    }

    private static String c(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = a;
        sb.append(strArr[i / 16]);
        sb.append(strArr[i % 16]);
        return sb.toString();
    }
}
