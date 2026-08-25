package tx;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    public final String a(File file) {
        Intrinsics.h(file, "file");
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            fileInputStream.close();
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.g(format, "format(...)");
                sb.append(format);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean b(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return StringsKt.H(str, str2, true);
    }
}
