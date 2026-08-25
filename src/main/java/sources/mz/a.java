package mz;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import okhttp3.HttpUrl;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.u;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a extends org.apache.tools.ant.types.e implements u, Cloneable {
    private List a = new ArrayList();
    private Collection b = null;
    private boolean c = true;

    private synchronized Collection e() {
        try {
            if (this.b != null) {
                if (!j()) {
                }
            }
            this.b = g();
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    @Override // org.apache.tools.ant.types.u
    public synchronized boolean a() {
        if (isReference()) {
            return ((a) getCheckedRef()).a();
        }
        dieOnCircularReference();
        Iterator it = this.a.iterator();
        boolean z = true;
        while (z && it.hasNext()) {
            z = ((u) it.next()).a();
        }
        if (z) {
            return true;
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            if (!(it2.next() instanceof c)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.q
    public Object clone() {
        try {
            a aVar = (a) super.clone();
            aVar.a = new ArrayList(this.a);
            aVar.b = null;
            return aVar;
        } catch (CloneNotSupportedException e) {
            throw new BuildException(e);
        }
    }

    public synchronized void d(u uVar) {
        Project project;
        try {
            if (isReference()) {
                throw noChildrenAllowed();
            }
            if (uVar == null) {
                return;
            }
            if (Project.q(uVar) == null && (project = getProject()) != null) {
                project.K(uVar);
            }
            this.a.add(uVar);
            b.c(this);
            this.b = null;
            setChecked(false);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.tools.ant.types.e
    protected synchronized void dieOnCircularReference(Stack stack, Project project) {
        try {
            if (isChecked()) {
                return;
            }
            if (isReference()) {
                super.dieOnCircularReference(stack, project);
            } else {
                for (Object obj : this.a) {
                    if (obj instanceof org.apache.tools.ant.types.e) {
                        stack.push(obj);
                        org.apache.tools.ant.types.e.invokeCircularReferenceCheck((org.apache.tools.ant.types.e) obj, stack, project);
                        stack.pop();
                    }
                }
                setChecked(true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected abstract Collection g();

    protected final synchronized List i() {
        dieOnCircularReference();
        return Collections.unmodifiableList(this.a);
    }

    @Override // org.apache.tools.ant.types.u
    public final synchronized Iterator iterator() {
        if (isReference()) {
            return ((a) getCheckedRef()).iterator();
        }
        dieOnCircularReference();
        return new b(this, e().iterator());
    }

    public synchronized boolean j() {
        return this.c;
    }

    public synchronized void k(boolean z) {
        this.c = z;
    }

    @Override // org.apache.tools.ant.types.u
    public synchronized int size() {
        if (isReference()) {
            return ((a) getCheckedRef()).size();
        }
        dieOnCircularReference();
        return e().size();
    }

    @Override // org.apache.tools.ant.types.e
    public synchronized String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        if (e().size() == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(File.pathSeparatorChar);
            }
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }
}
