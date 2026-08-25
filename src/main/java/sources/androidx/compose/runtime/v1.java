package androidx.compose.runtime;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class v1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3051a = new Object();

    public static final int a(int i5) {
        int i6 = 306783378 & i5;
        int i7 = 613566756 & i5;
        return (i5 & (-920350135)) | (i7 >> 1) | i6 | ((i6 << 1) & i7);
    }
}
