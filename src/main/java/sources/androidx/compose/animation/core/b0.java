package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static final z f1404a = new u(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    private static final z f1405b = new u(0.0f, 0.0f, 0.2f, 1.0f);

    /* renamed from: c, reason: collision with root package name */
    private static final z f1406c = new u(0.4f, 0.0f, 1.0f, 1.0f);

    /* renamed from: d, reason: collision with root package name */
    private static final z f1407d = new z() { // from class: androidx.compose.animation.core.a0
        @Override // androidx.compose.animation.core.z
        public final float a(float f5) {
            float b5;
            b5 = b0.b(f5);
            return b5;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(float f5) {
        return f5;
    }

    public static final z c() {
        return f1404a;
    }

    public static final z d() {
        return f1407d;
    }
}
