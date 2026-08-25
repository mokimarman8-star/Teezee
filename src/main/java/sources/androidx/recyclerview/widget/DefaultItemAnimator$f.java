package androidx.recyclerview.widget;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DefaultItemAnimator$f {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView$a0 f12724a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView$a0 f12725b;

    /* renamed from: c, reason: collision with root package name */
    public int f12726c;

    /* renamed from: d, reason: collision with root package name */
    public int f12727d;

    /* renamed from: e, reason: collision with root package name */
    public int f12728e;

    /* renamed from: f, reason: collision with root package name */
    public int f12729f;

    private DefaultItemAnimator$f(RecyclerView$a0 recyclerView$a0, RecyclerView$a0 recyclerView$a02) {
        this.f12724a = recyclerView$a0;
        this.f12725b = recyclerView$a02;
    }

    DefaultItemAnimator$f(RecyclerView$a0 recyclerView$a0, RecyclerView$a0 recyclerView$a02, int i5, int i6, int i7, int i8) {
        this(recyclerView$a0, recyclerView$a02);
        this.f12726c = i5;
        this.f12727d = i6;
        this.f12728e = i7;
        this.f12729f = i8;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.f12724a + ", newHolder=" + this.f12725b + ", fromX=" + this.f12726c + ", fromY=" + this.f12727d + ", toX=" + this.f12728e + ", toY=" + this.f12729f + '}';
    }
}
