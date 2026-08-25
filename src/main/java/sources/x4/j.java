package x4;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private float f18513a;

    /* renamed from: b, reason: collision with root package name */
    private int f18514b;

    public void a(float f5) {
        float f6 = this.f18513a + f5;
        this.f18513a = f6;
        int i5 = this.f18514b + 1;
        this.f18514b = i5;
        if (i5 == Integer.MAX_VALUE) {
            this.f18513a = f6 / 2.0f;
            this.f18514b = i5 / 2;
        }
    }
}
