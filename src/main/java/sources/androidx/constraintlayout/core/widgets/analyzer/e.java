package androidx.constraintlayout.core.widgets.analyzer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class e extends DependencyNode {

    /* renamed from: m, reason: collision with root package name */
    public int f5843m;

    public e(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof j) {
            ((DependencyNode) this).e = DependencyNode$Type.HORIZONTAL_DIMENSION;
        } else {
            ((DependencyNode) this).e = DependencyNode$Type.VERTICAL_DIMENSION;
        }
    }

    public void d(int i5) {
        if (((DependencyNode) this).j) {
            return;
        }
        ((DependencyNode) this).j = true;
        ((DependencyNode) this).g = i5;
        for (u0.a aVar : ((DependencyNode) this).k) {
            aVar.a(aVar);
        }
    }
}
