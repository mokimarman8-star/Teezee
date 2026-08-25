package androidx.palette.graphics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f12617e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f12618f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f12619g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f12620h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f12621i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f12622j;

    /* renamed from: a, reason: collision with root package name */
    final float[] f12623a;

    /* renamed from: b, reason: collision with root package name */
    final float[] f12624b;

    /* renamed from: c, reason: collision with root package name */
    final float[] f12625c = new float[3];

    /* renamed from: d, reason: collision with root package name */
    boolean f12626d = true;

    static {
        b bVar = new b();
        f12617e = bVar;
        m(bVar);
        p(bVar);
        b bVar2 = new b();
        f12618f = bVar2;
        o(bVar2);
        p(bVar2);
        b bVar3 = new b();
        f12619g = bVar3;
        l(bVar3);
        p(bVar3);
        b bVar4 = new b();
        f12620h = bVar4;
        m(bVar4);
        n(bVar4);
        b bVar5 = new b();
        f12621i = bVar5;
        o(bVar5);
        n(bVar5);
        b bVar6 = new b();
        f12622j = bVar6;
        l(bVar6);
        n(bVar6);
    }

    b() {
        float[] fArr = new float[3];
        this.f12623a = fArr;
        float[] fArr2 = new float[3];
        this.f12624b = fArr2;
        r(fArr);
        r(fArr2);
        q();
    }

    private static void l(b bVar) {
        float[] fArr = bVar.f12624b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void m(b bVar) {
        float[] fArr = bVar.f12624b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void n(b bVar) {
        float[] fArr = bVar.f12623a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    private static void o(b bVar) {
        float[] fArr = bVar.f12624b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void p(b bVar) {
        float[] fArr = bVar.f12623a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private void q() {
        float[] fArr = this.f12625c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    private static void r(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    public float a() {
        return this.f12625c[1];
    }

    public float b() {
        return this.f12624b[2];
    }

    public float c() {
        return this.f12623a[2];
    }

    public float d() {
        return this.f12624b[0];
    }

    public float e() {
        return this.f12623a[0];
    }

    public float f() {
        return this.f12625c[2];
    }

    public float g() {
        return this.f12625c[0];
    }

    public float h() {
        return this.f12624b[1];
    }

    public float i() {
        return this.f12623a[1];
    }

    public boolean j() {
        return this.f12626d;
    }

    void k() {
        int length = this.f12625c.length;
        float f5 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f6 = this.f12625c[i5];
            if (f6 > 0.0f) {
                f5 += f6;
            }
        }
        if (f5 != 0.0f) {
            int length2 = this.f12625c.length;
            for (int i6 = 0; i6 < length2; i6++) {
                float[] fArr = this.f12625c;
                float f7 = fArr[i6];
                if (f7 > 0.0f) {
                    fArr[i6] = f7 / f5;
                }
            }
        }
    }
}
