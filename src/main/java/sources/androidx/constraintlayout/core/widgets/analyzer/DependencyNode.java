package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u0.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class DependencyNode implements a {
    WidgetRun d;
    int f;
    public int g;
    public a a = null;
    public boolean b = false;
    public boolean c = false;
    Type e = Type.UNKNOWN;
    int h = 1;
    e i = null;
    public boolean j = false;
    List k = new ArrayList();
    List l = new ArrayList();

    public DependencyNode(WidgetRun widgetRun) {
        this.d = widgetRun;
    }

    public void a(a aVar) {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            if (!((DependencyNode) it.next()).j) {
                return;
            }
        }
        this.c = true;
        a aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int i = 0;
        for (DependencyNode dependencyNode2 : this.l) {
            if (!(dependencyNode2 instanceof e)) {
                i++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i == 1 && dependencyNode.j) {
            e eVar = this.i;
            if (eVar != null) {
                if (!eVar.j) {
                    return;
                } else {
                    this.f = this.h * eVar.g;
                }
            }
            d(dependencyNode.g + this.f);
        }
        a aVar3 = this.a;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    public void b(a aVar) {
        this.k.add(aVar);
        if (this.j) {
            aVar.a(aVar);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (a aVar : this.k) {
            aVar.a(aVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.v());
        sb.append(":");
        sb.append(this.e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
