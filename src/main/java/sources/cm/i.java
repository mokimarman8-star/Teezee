package cm;

import android.provider.Settings;
import com.blankj.utilcode.util.Utils;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i {
    public static final i a = new i();

    private i() {
    }

    private final String a() {
        String string = Settings.Secure.getString(Utils.a().getContentResolver(), "android_id");
        if (string != null && string.length() != 0 && !Intrinsics.c(string, "9774d56d682e549c")) {
            d dVar = d.a;
            if (!Intrinsics.c(dVar.f().getString("cached_android_id", (String) null), string)) {
                dVar.f().putString("cached_android_id", string);
            }
            return string;
        }
        d dVar2 = d.a;
        String string2 = dVar2.f().getString("cached_android_id", (String) null);
        if (string2 != null && string2.length() != 0) {
            return string2;
        }
        String str = "fallback_" + System.currentTimeMillis() + '_' + ((int) (Math.random() * 1000000));
        dVar2.f().putString("cached_android_id", str);
        return str;
    }

    public static /* synthetic */ int c(i iVar, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return iVar.b(str, i);
    }

    private final int d(String str, int i) {
        MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
        byte[] bytes = str.getBytes(Charsets.b);
        Intrinsics.g(bytes, "getBytes(...)");
        Intrinsics.e(messageDigest.digest(bytes));
        return (int) ((ByteBuffer.wrap(CollectionsKt.N0(ArraysKt.A0(r5, 4))).order(ByteOrder.BIG_ENDIAN).getInt() & 4294967295L) % i);
    }

    public final int b(String str, int i) {
        Intrinsics.h(str, "key");
        if (i <= 0 || str.length() == 0) {
            return 0;
        }
        String a2 = a();
        String str2 = "ab_bucket__" + str;
        d dVar = d.a;
        int i2 = dVar.f().getInt(str2, -1);
        if (i2 >= 0 && i2 < i) {
            return i2;
        }
        int d = d("oneRoomBucketSalt@2024" + a2 + '_' + str, i);
        dVar.f().putInt(str2, d);
        return d;
    }
}
