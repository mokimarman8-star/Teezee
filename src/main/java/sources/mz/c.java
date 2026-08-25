package mz;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.types.r;
import org.apache.tools.ant.types.t;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class c extends t {
    private static final org.apache.tools.ant.util.d j = org.apache.tools.ant.util.d.k();
    private static final int k = t.h("null file".getBytes());
    private File h;
    private File i;

    public c() {
    }

    public c(File file, String str) {
        u(j.q(file, str));
        t(file);
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.u
    public boolean a() {
        return !isReference() || ((c) getCheckedRef()).a();
    }

    @Override // org.apache.tools.ant.types.t, java.lang.Comparable
    public int compareTo(Object obj) {
        if (isReference()) {
            return ((Comparable) getCheckedRef()).compareTo(obj);
        }
        if (equals(obj)) {
            return 0;
        }
        if (!obj.getClass().equals(getClass())) {
            return super.compareTo(obj);
        }
        c cVar = (c) obj;
        File r = r();
        if (r == null) {
            return -1;
        }
        File r2 = cVar.r();
        if (r2 == null) {
            return 1;
        }
        return r.compareTo(r2);
    }

    @Override // org.apache.tools.ant.types.t
    public InputStream e() {
        return isReference() ? ((t) getCheckedRef()).e() : new FileInputStream(s());
    }

    @Override // org.apache.tools.ant.types.t
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        c cVar = (c) obj;
        return r() == null ? cVar.r() == null : r().equals(cVar.r());
    }

    @Override // org.apache.tools.ant.types.t
    public long g() {
        return isReference() ? ((t) getCheckedRef()).g() : s().lastModified();
    }

    @Override // org.apache.tools.ant.types.t
    public String getName() {
        if (isReference()) {
            return ((t) getCheckedRef()).getName();
        }
        File q = q();
        return q == null ? s().getName() : j.p(q, s());
    }

    @Override // org.apache.tools.ant.types.t
    public int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        return t.f * (r() == null ? k : r().hashCode());
    }

    @Override // org.apache.tools.ant.types.t
    public long i() {
        return isReference() ? ((t) getCheckedRef()).i() : s().length();
    }

    @Override // org.apache.tools.ant.types.t
    public boolean j() {
        return isReference() ? ((t) getCheckedRef()).j() : s().isDirectory();
    }

    @Override // org.apache.tools.ant.types.t
    public boolean k() {
        return isReference() ? ((t) getCheckedRef()).k() : s().exists();
    }

    public File q() {
        return isReference() ? ((c) getCheckedRef()).q() : this.i;
    }

    public File r() {
        return isReference() ? ((c) getCheckedRef()).r() : this.h;
    }

    protected File s() {
        if (r() != null) {
            return r();
        }
        throw new BuildException("file attribute is null!");
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (this.h != null || this.i != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    public void t(File file) {
        checkAttributesAllowed();
        this.i = file;
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.e
    public String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        File file = this.h;
        if (file == null) {
            return "(unbound file resource)";
        }
        return j.o(file.getAbsolutePath()).getAbsolutePath();
    }

    public void u(File file) {
        checkAttributesAllowed();
        this.h = file;
    }
}
