package androidx.recyclerview.widget;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class d implements j {

    /* renamed from: a, reason: collision with root package name */
    final j f12933a;

    /* renamed from: b, reason: collision with root package name */
    int f12934b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f12935c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f12936d = -1;

    /* renamed from: e, reason: collision with root package name */
    Object f12937e = null;

    public d(j jVar) {
        this.f12933a = jVar;
    }

    public void a() {
        int i5 = this.f12934b;
        if (i5 == 0) {
            return;
        }
        if (i5 == 1) {
            this.f12933a.onInserted(this.f12935c, this.f12936d);
        } else if (i5 == 2) {
            this.f12933a.onRemoved(this.f12935c, this.f12936d);
        } else if (i5 == 3) {
            this.f12933a.onChanged(this.f12935c, this.f12936d, this.f12937e);
        }
        this.f12937e = null;
        this.f12934b = 0;
    }

    @Override // androidx.recyclerview.widget.j
    public void onChanged(int i5, int i6, Object obj) {
        int i7;
        if (this.f12934b == 3) {
            int i8 = this.f12935c;
            int i9 = this.f12936d;
            if (i5 <= i8 + i9 && (i7 = i5 + i6) >= i8 && this.f12937e == obj) {
                this.f12935c = Math.min(i5, i8);
                this.f12936d = Math.max(i9 + i8, i7) - this.f12935c;
                return;
            }
        }
        a();
        this.f12935c = i5;
        this.f12936d = i6;
        this.f12937e = obj;
        this.f12934b = 3;
    }

    @Override // androidx.recyclerview.widget.j
    public void onInserted(int i5, int i6) {
        int i7;
        if (this.f12934b == 1 && i5 >= (i7 = this.f12935c)) {
            int i8 = this.f12936d;
            if (i5 <= i7 + i8) {
                this.f12936d = i8 + i6;
                this.f12935c = Math.min(i5, i7);
                return;
            }
        }
        a();
        this.f12935c = i5;
        this.f12936d = i6;
        this.f12934b = 1;
    }

    @Override // androidx.recyclerview.widget.j
    public void onMoved(int i5, int i6) {
        a();
        this.f12933a.onMoved(i5, i6);
    }

    @Override // androidx.recyclerview.widget.j
    public void onRemoved(int i5, int i6) {
        int i7;
        if (this.f12934b == 2 && (i7 = this.f12935c) >= i5 && i7 <= i5 + i6) {
            this.f12936d += i6;
            this.f12935c = i5;
        } else {
            a();
            this.f12935c = i5;
            this.f12936d = i6;
            this.f12934b = 2;
        }
    }
}
