package v0;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public float f18050a;

    /* renamed from: b, reason: collision with root package name */
    public int f18051b;

    /* renamed from: c, reason: collision with root package name */
    public int f18052c;

    /* renamed from: d, reason: collision with root package name */
    public int f18053d;

    /* renamed from: e, reason: collision with root package name */
    public int f18054e;

    public void a(View view) {
        this.f18051b = view.getLeft();
        this.f18052c = view.getTop();
        this.f18053d = view.getRight();
        this.f18054e = view.getBottom();
        this.f18050a = view.getRotation();
    }

    public int b() {
        return this.f18054e - this.f18052c;
    }

    public int c() {
        return this.f18053d - this.f18051b;
    }
}
