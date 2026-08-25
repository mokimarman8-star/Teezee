package ij;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.gslb.BuildConfig;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();
    private static final HashMap b = new HashMap();

    private d() {
    }

    public static final String c(Context context) {
        Intrinsics.h(context, "context");
        ArrayList d = a.d(context, "SHA1");
        if (d == null || d.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        Object obj = d.get(0);
        Intrinsics.g(obj, "get(...)");
        return (String) obj;
    }

    private final String e(Signature signature, String str) {
        try {
            byte[] digest = MessageDigest.getInstance(str).digest(signature.toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString((b2 & 255) | 256);
                Intrinsics.g(hexString, "toHexString(...)");
                String substring = hexString.substring(1, 3);
                Intrinsics.g(substring, "substring(...)");
                String upperCase = substring.toUpperCase(Locale.ROOT);
                Intrinsics.g(upperCase, "toUpperCase(...)");
                sb.append(upperCase);
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Throwable unused) {
            return BuildConfig.FLAVOR;
        }
    }

    private final Signature[] f(Context context, String str) {
        Signature[] a2;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT < 28) {
                Signature[] signatureArr = packageManager.getPackageInfo(Utils.a().getPackageName(), 64).signatures;
                return signatureArr == null ? new Signature[0] : signatureArr;
            }
            SigningInfo a3 = com.cloud.tmc.miniutils.util.a.a(packageManager.getPackageInfo(Utils.a().getPackageName(), 134217728));
            if (a3 != null && (a2 = com.cloud.tmc.miniutils.util.c.a(a3)) != null) {
                return a2;
            }
            return new Signature[0];
        } catch (Exception e) {
            e.printStackTrace();
            return new Signature[0];
        }
    }

    public final String a(Context context) {
        Intrinsics.h(context, "context");
        ArrayList d = d(context, EncoderUtil.ALGORITHM_MD5);
        if (d == null || d.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        Object obj = d.get(0);
        Intrinsics.g(obj, "get(...)");
        return (String) obj;
    }

    public final String b(Context context) {
        Intrinsics.h(context, "context");
        ArrayList d = d(context, "SHA256");
        if (d == null || d.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        Object obj = d.get(0);
        Intrinsics.g(obj, "get(...)");
        return (String) obj;
    }

    public final ArrayList d(Context context, String str) {
        String e;
        ArrayList arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            ArrayList arrayList2 = (ArrayList) b.get(str);
            if (arrayList2 != null) {
                return arrayList2;
            }
            arrayList = new ArrayList();
            try {
                for (Signature signature : f(context, packageName)) {
                    int hashCode = str.hashCode();
                    if (hashCode == -1850268089) {
                        if (str.equals("SHA256")) {
                            e = e(signature, "SHA256");
                            arrayList.add(e);
                        }
                        e = "error!";
                        arrayList.add(e);
                    } else if (hashCode != 76158) {
                        if (hashCode == 2543909 && str.equals("SHA1")) {
                            e = e(signature, "SHA1");
                            arrayList.add(e);
                        }
                        e = "error!";
                        arrayList.add(e);
                    } else {
                        if (str.equals(EncoderUtil.ALGORITHM_MD5)) {
                            e = e(signature, EncoderUtil.ALGORITHM_MD5);
                            arrayList.add(e);
                        }
                        e = "error!";
                        arrayList.add(e);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            b.put(str, arrayList);
        }
        return arrayList;
    }
}
