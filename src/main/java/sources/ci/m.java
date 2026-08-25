package ci;

import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.gslb.BuildConfig;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m {
    public static final m a = new m();

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence c(byte b) {
        return StringsKt.A0(String.valueOf(b & 255), 3, '0');
    }

    public final String b(String str) {
        String format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
        MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
        byte[] bytes = (format + str).getBytes(Charsets.b);
        Intrinsics.g(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.e(digest);
        return StringsKt.y1(ArraysKt.l0(digest, BuildConfig.FLAVOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: ci.l
            public final Object invoke(Object obj) {
                CharSequence c;
                c = m.c(((Byte) obj).byteValue());
                return c;
            }
        }, 30, (Object) null), 8);
    }

    public final boolean d(String str, String str2) {
        Intrinsics.h(str, "inputPwd");
        return Intrinsics.c(str, b(str2));
    }
}
