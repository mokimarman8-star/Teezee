package org.apache.tools.ant;

import java.util.Enumeration;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class u extends q {
    protected t a;
    protected String b;
    protected String c;
    protected RuntimeConfigurable d;
    private boolean e;
    private w f;

    private w i() {
        if (this.f == null) {
            w wVar = new w(this.c);
            this.f = wVar;
            wVar.setProject(getProject());
            this.f.t(this.c);
            this.f.s(this.b);
            this.f.setLocation(this.location);
            this.f.q(this.a);
            this.f.r(this.d);
            this.d.setProxy(this.f);
            p(this.d, this.f);
            this.a.g(this, this.f);
            this.f.n();
        }
        return this.f;
    }

    private void p(RuntimeConfigurable runtimeConfigurable, w wVar) {
        Enumeration children = runtimeConfigurable.getChildren();
        while (children.hasMoreElements()) {
            RuntimeConfigurable runtimeConfigurable2 = (RuntimeConfigurable) children.nextElement();
            w wVar2 = new w(runtimeConfigurable2.getElementTag());
            wVar.u(wVar2);
            wVar2.setProject(getProject());
            wVar2.r(runtimeConfigurable2);
            runtimeConfigurable2.setProxy(wVar2);
            p(runtimeConfigurable2, wVar2);
        }
    }

    public void e() {
    }

    public t g() {
        return this.a;
    }

    public String j() {
        return this.b;
    }

    public String k() {
        return this.c;
    }

    protected RuntimeConfigurable l() {
        return this.d;
    }

    @Override // org.apache.tools.ant.q
    public void log(String str) {
        log(str, 2);
    }

    @Override // org.apache.tools.ant.q
    public void log(String str, int i) {
        if (getProject() != null) {
            getProject().z(this, str, i);
        } else {
            super.log(str, i);
        }
    }

    public void m() {
    }

    public void n() {
        if (this.e) {
            i();
            return;
        }
        RuntimeConfigurable runtimeConfigurable = this.d;
        if (runtimeConfigurable != null) {
            runtimeConfigurable.maybeConfigure(getProject());
        }
    }

    public final void o() {
        Throwable th;
        if (this.e) {
            i().D().o();
            return;
        }
        getProject().l(this);
        BuildException buildException = null;
        try {
            try {
                n();
                fz.a.a(this);
                getProject().k(this, null);
            } catch (Error e) {
                throw e;
            } catch (BuildException e2) {
                if (e2.getLocation() == Location.UNKNOWN_LOCATION) {
                    e2.setLocation(getLocation());
                }
                try {
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    buildException = e2;
                    getProject().k(this, buildException);
                    throw th;
                }
            } catch (Exception e3) {
                BuildException buildException2 = new BuildException(e3);
                buildException2.setLocation(getLocation());
                throw buildException2;
            }
        } catch (Throwable th3) {
            th = th3;
            getProject().k(this, buildException);
            throw th;
        }
    }

    public void q(t tVar) {
        this.a = tVar;
    }

    public void r(RuntimeConfigurable runtimeConfigurable) {
        this.d = runtimeConfigurable;
    }

    public void s(String str) {
        this.b = str;
    }

    public void t(String str) {
        this.c = str;
    }
}
