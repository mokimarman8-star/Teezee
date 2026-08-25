package androidx.compose.ui.text.style;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(int i5, int i6, int i7) {
        return i5 | (i6 << 8) | (i7 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(int i5) {
        return i5 & 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(int i5) {
        return (i5 >> 8) & 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(int i5) {
        return (i5 >> 16) & 255;
    }
}
