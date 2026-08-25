package kotlinx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public /* synthetic */ class CoroutineStart$a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[CoroutineStart.values().length];
        try {
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        a = iArr;
    }
}
