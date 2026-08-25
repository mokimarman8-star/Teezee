package ij;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.gslb.BuildConfig;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r {
    public static final r a = new r();

    private r() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:3:0x000f, B:5:0x0015, B:8:0x0025, B:10:0x002b, B:11:0x003a, B:13:0x0042, B:14:0x0046, B:16:0x0053, B:18:0x0073, B:23:0x0034, B:25:0x0038, B:26:0x001c), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[Catch: all -> 0x007d, LOOP:0: B:15:0x0051->B:16:0x0053, LOOP_END, TryCatch #0 {all -> 0x007d, blocks: (B:3:0x000f, B:5:0x0015, B:8:0x0025, B:10:0x002b, B:11:0x003a, B:13:0x0042, B:14:0x0046, B:16:0x0053, B:18:0x0073, B:23:0x0034, B:25:0x0038, B:26:0x001c), top: B:2:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(Context context) {
        Signature signature;
        Intrinsics.h(context, "context");
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            int i = Build.VERSION.SDK_INT;
            PackageInfo packageInfo = i >= 28 ? packageManager.getPackageInfo(packageName, 134217728) : packageManager.getPackageInfo(packageName, 64);
            if (i < 28) {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null) {
                    signature = signatureArr[0];
                    byte[] digest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5).digest(signature != null ? signature.toByteArray() : null);
                    StringBuilder sb = new StringBuilder();
                    while (r4 < r3) {
                    }
                    String sb2 = sb.toString();
                    Intrinsics.g(sb2, "toString(...)");
                    return sb2;
                }
                signature = null;
                byte[] digest2 = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5).digest(signature != null ? signature.toByteArray() : null);
                StringBuilder sb3 = new StringBuilder();
                while (r4 < r3) {
                }
                String sb22 = sb3.toString();
                Intrinsics.g(sb22, "toString(...)");
                return sb22;
            }
            SigningInfo a2 = com.cloud.tmc.miniutils.util.a.a(packageInfo);
            if (a2 != null) {
                signature = com.cloud.tmc.miniutils.util.c.a(a2)[0];
                byte[] digest22 = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5).digest(signature != null ? signature.toByteArray() : null);
                StringBuilder sb32 = new StringBuilder();
                for (byte b : digest22) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                    Intrinsics.g(format, "format(...)");
                    sb32.append(format);
                }
                String sb222 = sb32.toString();
                Intrinsics.g(sb222, "toString(...)");
                return sb222;
            }
            signature = null;
            byte[] digest222 = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5).digest(signature != null ? signature.toByteArray() : null);
            StringBuilder sb322 = new StringBuilder();
            while (r4 < r3) {
            }
            String sb2222 = sb322.toString();
            Intrinsics.g(sb2222, "toString(...)");
            return sb2222;
        } catch (Throwable unused) {
            return BuildConfig.FLAVOR;
        }
    }
}
