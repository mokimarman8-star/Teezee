package kotlin.collections.unsigned;

import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.CollectionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b extends a {
    public static String a(byte[] bArr) {
        String s0;
        return (bArr == null || (s0 = CollectionsKt.s0(UByteArray.a(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : s0;
    }

    public static String b(int[] iArr) {
        String s0;
        return (iArr == null || (s0 = CollectionsKt.s0(UIntArray.a(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : s0;
    }

    public static String c(short[] sArr) {
        String s0;
        return (sArr == null || (s0 = CollectionsKt.s0(UShortArray.a(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : s0;
    }

    public static String d(long[] jArr) {
        String s0;
        return (jArr == null || (s0 = CollectionsKt.s0(ULongArray.a(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : s0;
    }
}
