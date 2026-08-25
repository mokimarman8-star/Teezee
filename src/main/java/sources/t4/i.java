package t4;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final List f17869a;

    /* renamed from: b, reason: collision with root package name */
    private PointF f17870b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17871c;

    public i() {
        this.f17869a = new ArrayList();
    }

    public i(PointF pointF, boolean z5, List list) {
        this.f17870b = pointF;
        this.f17871c = z5;
        this.f17869a = new ArrayList(list);
    }

    public List a() {
        return this.f17869a;
    }

    public PointF b() {
        return this.f17870b;
    }

    public void c(i iVar, i iVar2, float f5) {
        if (this.f17870b == null) {
            this.f17870b = new PointF();
        }
        this.f17871c = iVar.d() || iVar2.d();
        if (iVar.a().size() != iVar2.a().size()) {
            x4.f.c("Curves must have the same number of control points. Shape 1: " + iVar.a().size() + "\tShape 2: " + iVar2.a().size());
        }
        int min = Math.min(iVar.a().size(), iVar2.a().size());
        if (this.f17869a.size() < min) {
            for (int size = this.f17869a.size(); size < min; size++) {
                this.f17869a.add(new r4.a());
            }
        } else if (this.f17869a.size() > min) {
            for (int size2 = this.f17869a.size() - 1; size2 >= min; size2--) {
                List list = this.f17869a;
                list.remove(list.size() - 1);
            }
        }
        PointF b5 = iVar.b();
        PointF b6 = iVar2.b();
        f(x4.k.i(b5.x, b6.x, f5), x4.k.i(b5.y, b6.y, f5));
        for (int size3 = this.f17869a.size() - 1; size3 >= 0; size3--) {
            r4.a aVar = (r4.a) iVar.a().get(size3);
            r4.a aVar2 = (r4.a) iVar2.a().get(size3);
            PointF a5 = aVar.a();
            PointF b7 = aVar.b();
            PointF c5 = aVar.c();
            PointF a6 = aVar2.a();
            PointF b8 = aVar2.b();
            PointF c6 = aVar2.c();
            ((r4.a) this.f17869a.get(size3)).d(x4.k.i(a5.x, a6.x, f5), x4.k.i(a5.y, a6.y, f5));
            ((r4.a) this.f17869a.get(size3)).e(x4.k.i(b7.x, b8.x, f5), x4.k.i(b7.y, b8.y, f5));
            ((r4.a) this.f17869a.get(size3)).f(x4.k.i(c5.x, c6.x, f5), x4.k.i(c5.y, c6.y, f5));
        }
    }

    public boolean d() {
        return this.f17871c;
    }

    public void e(boolean z5) {
        this.f17871c = z5;
    }

    public void f(float f5, float f6) {
        if (this.f17870b == null) {
            this.f17870b = new PointF();
        }
        this.f17870b.set(f5, f6);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f17869a.size() + "closed=" + this.f17871c + '}';
    }
}
