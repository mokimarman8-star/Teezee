package ci;

import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n {
    public static final n a = new n();

    private n() {
    }

    public final String a(int i) {
        StringBuffer stringBuffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuffer stringBuffer2 = new StringBuffer();
        ThreadLocalRandom current = ThreadLocalRandom.current();
        int length = stringBuffer.length();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer2.append(stringBuffer.charAt(current.nextInt(length)));
        }
        String stringBuffer3 = stringBuffer2.toString();
        Intrinsics.g(stringBuffer3, "toString(...)");
        return stringBuffer3;
    }

    public final String b() {
        return a(12);
    }
}
