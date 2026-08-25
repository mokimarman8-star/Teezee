package m0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f16471a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Object[] f16472b = new Object[0];

    public static final int a(int[] iArr, int i5, int i6) {
        int i7 = i5 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i6) {
                i8 = i9 + 1;
            } else {
                if (i10 <= i6) {
                    return i9;
                }
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }
}
