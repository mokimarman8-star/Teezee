package p4;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: c, reason: collision with root package name */
    private final d f16908c;

    /* renamed from: e, reason: collision with root package name */
    protected y4.c f16910e;

    /* renamed from: a, reason: collision with root package name */
    final List f16906a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    private boolean f16907b = false;

    /* renamed from: d, reason: collision with root package name */
    protected float f16909d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private Object f16911f = null;

    /* renamed from: g, reason: collision with root package name */
    private float f16912g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f16913h = -1.0f;

    public interface b {
        void a();
    }

    private static final class c implements d {
        private c() {
        }

        @Override // p4.a.d
        public boolean a(float f5) {
            throw new IllegalStateException("not implemented");
        }

        @Override // p4.a.d
        public y4.a b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // p4.a.d
        public boolean c(float f5) {
            return false;
        }

        @Override // p4.a.d
        public float d() {
            return 0.0f;
        }

        @Override // p4.a.d
        public float e() {
            return 1.0f;
        }

        @Override // p4.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    private interface d {
        boolean a(float f5);

        y4.a b();

        boolean c(float f5);

        float d();

        float e();

        boolean isEmpty();
    }

    private static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        private final List f16914a;

        /* renamed from: c, reason: collision with root package name */
        private y4.a f16916c = null;

        /* renamed from: d, reason: collision with root package name */
        private float f16917d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        private y4.a f16915b = f(0.0f);

        e(List list) {
            this.f16914a = list;
        }

        private y4.a f(float f5) {
            List list = this.f16914a;
            y4.a aVar = (y4.a) list.get(list.size() - 1);
            if (f5 >= aVar.f()) {
                return aVar;
            }
            for (int size = this.f16914a.size() - 2; size >= 1; size--) {
                y4.a aVar2 = (y4.a) this.f16914a.get(size);
                if (this.f16915b != aVar2 && aVar2.a(f5)) {
                    return aVar2;
                }
            }
            return (y4.a) this.f16914a.get(0);
        }

        @Override // p4.a.d
        public boolean a(float f5) {
            y4.a aVar = this.f16916c;
            y4.a aVar2 = this.f16915b;
            if (aVar == aVar2 && this.f16917d == f5) {
                return true;
            }
            this.f16916c = aVar2;
            this.f16917d = f5;
            return false;
        }

        @Override // p4.a.d
        public y4.a b() {
            return this.f16915b;
        }

        @Override // p4.a.d
        public boolean c(float f5) {
            if (this.f16915b.a(f5)) {
                return !this.f16915b.i();
            }
            this.f16915b = f(f5);
            return true;
        }

        @Override // p4.a.d
        public float d() {
            return ((y4.a) this.f16914a.get(0)).f();
        }

        @Override // p4.a.d
        public float e() {
            return ((y4.a) this.f16914a.get(r0.size() - 1)).c();
        }

        @Override // p4.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    private static final class f implements d {

        /* renamed from: a, reason: collision with root package name */
        private final y4.a f16918a;

        /* renamed from: b, reason: collision with root package name */
        private float f16919b = -1.0f;

        f(List list) {
            this.f16918a = (y4.a) list.get(0);
        }

        @Override // p4.a.d
        public boolean a(float f5) {
            if (this.f16919b == f5) {
                return true;
            }
            this.f16919b = f5;
            return false;
        }

        @Override // p4.a.d
        public y4.a b() {
            return this.f16918a;
        }

        @Override // p4.a.d
        public boolean c(float f5) {
            return !this.f16918a.i();
        }

        @Override // p4.a.d
        public float d() {
            return this.f16918a.f();
        }

        @Override // p4.a.d
        public float e() {
            return this.f16918a.c();
        }

        @Override // p4.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    a(List list) {
        this.f16908c = p(list);
    }

    private float g() {
        if (this.f16912g == -1.0f) {
            this.f16912g = this.f16908c.d();
        }
        return this.f16912g;
    }

    private static d p(List list) {
        return list.isEmpty() ? new c() : list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.f16906a.add(bVar);
    }

    protected y4.a b() {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        y4.a b5 = this.f16908c.b();
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        return b5;
    }

    float c() {
        if (this.f16913h == -1.0f) {
            this.f16913h = this.f16908c.e();
        }
        return this.f16913h;
    }

    protected float d() {
        Interpolator interpolator;
        y4.a b5 = b();
        if (b5 == null || b5.i() || (interpolator = b5.f18665d) == null) {
            return 0.0f;
        }
        return interpolator.getInterpolation(e());
    }

    float e() {
        if (this.f16907b) {
            return 0.0f;
        }
        y4.a b5 = b();
        if (b5.i()) {
            return 0.0f;
        }
        return (this.f16909d - b5.f()) / (b5.c() - b5.f());
    }

    public float f() {
        return this.f16909d;
    }

    public Object h() {
        float e5 = e();
        if (this.f16910e == null && this.f16908c.a(e5)) {
            return this.f16911f;
        }
        y4.a b5 = b();
        Interpolator interpolator = b5.f18666e;
        Object i5 = (interpolator == null || b5.f18667f == null) ? i(b5, d()) : j(b5, e5, interpolator.getInterpolation(e5), b5.f18667f.getInterpolation(e5));
        this.f16911f = i5;
        return i5;
    }

    abstract Object i(y4.a aVar, float f5);

    protected Object j(y4.a aVar, float f5, float f6, float f7) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public boolean k() {
        return this.f16910e != null;
    }

    public void l() {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseKeyframeAnimation#notifyListeners");
        }
        for (int i5 = 0; i5 < this.f16906a.size(); i5++) {
            ((b) this.f16906a.get(i5)).a();
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseKeyframeAnimation#notifyListeners");
        }
    }

    public void m() {
        this.f16907b = true;
    }

    public void n(float f5) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseKeyframeAnimation#setProgress");
        }
        if (this.f16908c.isEmpty()) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseKeyframeAnimation#setProgress");
                return;
            }
            return;
        }
        if (f5 < g()) {
            f5 = g();
        } else if (f5 > c()) {
            f5 = c();
        }
        if (f5 == this.f16909d) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseKeyframeAnimation#setProgress");
            }
        } else {
            this.f16909d = f5;
            if (this.f16908c.c(f5)) {
                l();
            }
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseKeyframeAnimation#setProgress");
            }
        }
    }

    public void o(y4.c cVar) {
        y4.c cVar2 = this.f16910e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f16910e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
