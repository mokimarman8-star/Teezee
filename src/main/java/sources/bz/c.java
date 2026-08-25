package bz;

import javax.crypto.KeyGenerator;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class c {
    public static String a() {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        if (encoded == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : encoded) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }
}
