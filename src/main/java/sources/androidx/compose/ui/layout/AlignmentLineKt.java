package androidx.compose.ui.layout;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class AlignmentLineKt {

    /* renamed from: a, reason: collision with root package name */
    private static final h f4091a = new h(AlignmentLineKt$FirstBaseline$1.INSTANCE);

    /* renamed from: b, reason: collision with root package name */
    private static final h f4092b = new h(AlignmentLineKt$LastBaseline$1.INSTANCE);

    public static final h a() {
        return f4091a;
    }

    public static final h b() {
        return f4092b;
    }

    public static final int c(a aVar, int i5, int i6) {
        return ((Number) aVar.a().invoke(Integer.valueOf(i5), Integer.valueOf(i6))).intValue();
    }
}
