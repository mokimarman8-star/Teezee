package org.apache.tools.ant;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.apache.tools.ant.o;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class w extends u {
    private String g;
    private String i;
    private Object j;
    private String h = HttpUrl.FRAGMENT_ENCODE_SET;
    private List k = null;
    private boolean l = false;

    public w(String str) {
        this.g = str;
    }

    private boolean E(String str, o oVar, Object obj, w wVar, RuntimeConfigurable runtimeConfigurable) {
        String e = r.e(wVar.y(), wVar.C());
        if (!oVar.s(str, e)) {
            return false;
        }
        o.d i = oVar.i(getProject(), str, obj, e, wVar);
        i.b(runtimeConfigurable.getPolyType());
        Object a = i.a();
        runtimeConfigurable.setCreator(i);
        runtimeConfigurable.setProxy(a);
        if (a instanceof u) {
            u uVar = (u) a;
            uVar.r(runtimeConfigurable);
            uVar.s(e);
            uVar.t(e);
        }
        if (a instanceof q) {
            ((q) a).setLocation(wVar.getLocation());
        }
        runtimeConfigurable.maybeConfigure(getProject());
        wVar.F(a, runtimeConfigurable);
        i.c();
        return true;
    }

    public String A() {
        return this.i;
    }

    public Object B() {
        return this.j;
    }

    public String C() {
        return this.g;
    }

    public u D() {
        Object obj = this.j;
        if (obj instanceof u) {
            return (u) obj;
        }
        return null;
    }

    protected void F(Object obj, RuntimeConfigurable runtimeConfigurable) {
        String y = y();
        o k = o.k(getProject(), obj.getClass());
        List<w> list = this.k;
        if (list != null) {
            int i = 0;
            for (w wVar : list) {
                RuntimeConfigurable child = runtimeConfigurable.getChild(i);
                try {
                    if (!E(y, k, obj, wVar, child)) {
                        if (obj instanceof v) {
                            ((v) obj).b(wVar);
                        } else {
                            k.t(getProject(), obj, wVar.C());
                        }
                    }
                    i++;
                } catch (UnsupportedElementException e) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(runtimeConfigurable.getElementTag());
                    stringBuffer.append(" doesn't support the nested \"");
                    stringBuffer.append(e.getElement());
                    stringBuffer.append("\" element.");
                    throw new BuildException(stringBuffer.toString(), e);
                }
            }
        }
    }

    protected Object G(w wVar, RuntimeConfigurable runtimeConfigurable) {
        ComponentHelper j = ComponentHelper.j(getProject());
        String x = wVar.x();
        Object e = j.e(wVar, wVar.y(), x);
        if (e == null) {
            throw z("task or type", x);
        }
        if (e instanceof w) {
            w wVar2 = (w) e;
            e = wVar2.G(wVar2, runtimeConfigurable);
        }
        if (e instanceof u) {
            ((u) e).q(g());
        }
        if (e instanceof q) {
            ((q) e).setLocation(getLocation());
        }
        return e;
    }

    public void H(String str) {
        if (str.equals("ant:current")) {
            str = ComponentHelper.j(getProject()).k();
        }
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        this.h = str;
    }

    public void I(String str) {
        this.i = str;
    }

    public void J(Object obj) {
        this.j = obj;
    }

    @Override // org.apache.tools.ant.u
    public String j() {
        Object obj = this.j;
        return (obj == null || !(obj instanceof u)) ? super.j() : ((u) obj).j();
    }

    @Override // org.apache.tools.ant.u
    public RuntimeConfigurable l() {
        return super.l();
    }

    @Override // org.apache.tools.ant.u
    public void n() {
        if (this.j != null) {
            return;
        }
        v(G(this, l()));
    }

    public void u(w wVar) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(wVar);
    }

    public void v(Object obj) {
        u uVar;
        this.j = obj;
        l().setProxy(this.j);
        Object obj2 = this.j;
        if (obj2 instanceof u) {
            uVar = (u) obj2;
            uVar.r(l());
            if (l().getId() != null) {
                g().g(this, (u) this.j);
            }
        } else {
            uVar = null;
        }
        if (uVar != null) {
            uVar.n();
        } else {
            l().maybeConfigure(getProject());
        }
        F(this.j, l());
    }

    public w w(Project project) {
        w wVar = new w(C());
        wVar.H(y());
        wVar.setProject(project);
        wVar.I(A());
        wVar.t(k());
        wVar.s(j());
        wVar.setLocation(getLocation());
        if (g() == null) {
            t tVar = new t();
            tVar.m(getProject());
            wVar.q(tVar);
        } else {
            wVar.q(g());
        }
        RuntimeConfigurable runtimeConfigurable = new RuntimeConfigurable(wVar, j());
        runtimeConfigurable.setPolyType(l().getPolyType());
        for (Map.Entry entry : l().getAttributeMap().entrySet()) {
            runtimeConfigurable.setAttribute((String) entry.getKey(), (String) entry.getValue());
        }
        runtimeConfigurable.addText(l().getText().toString());
        Enumeration children = l().getChildren();
        while (children.hasMoreElements()) {
            w w = ((w) ((RuntimeConfigurable) children.nextElement()).getProxy()).w(project);
            runtimeConfigurable.addChild(w.l());
            wVar.u(w);
        }
        return wVar;
    }

    protected String x() {
        return r.e(y(), C());
    }

    public String y() {
        return this.h;
    }

    protected BuildException z(String str, String str2) {
        return new BuildException(ComponentHelper.j(getProject()).f(str2, str), getLocation());
    }
}
