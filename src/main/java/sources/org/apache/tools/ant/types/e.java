package org.apache.tools.ant.types;

import java.util.Stack;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ComponentHelper;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.IdentityStack;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class e extends org.apache.tools.ant.q implements Cloneable {
    protected boolean checked = true;
    protected r ref;

    public static void invokeCircularReferenceCheck(e eVar, Stack stack, Project project) {
        eVar.dieOnCircularReference(stack, project);
    }

    protected void checkAttributesAllowed() {
        if (isReference()) {
            throw tooManyAttributes();
        }
    }

    protected void checkChildrenAllowed() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
    }

    protected BuildException circularReference() {
        return new BuildException("This data type contains a circular reference.");
    }

    @Override // org.apache.tools.ant.q
    public Object clone() throws CloneNotSupportedException {
        e eVar = (e) super.clone();
        eVar.setDescription(getDescription());
        if (getRefid() != null) {
            eVar.setRefid(getRefid());
        }
        eVar.setChecked(isChecked());
        return eVar;
    }

    protected void dieOnCircularReference() {
        dieOnCircularReference(getProject());
    }

    protected void dieOnCircularReference(Stack stack, Project project) throws BuildException {
        if (this.checked || !isReference()) {
            return;
        }
        Object b = this.ref.b(project);
        if (b instanceof e) {
            IdentityStack identityStack = IdentityStack.getInstance(stack);
            if (identityStack.contains(b)) {
                throw circularReference();
            }
            identityStack.push(b);
            ((e) b).dieOnCircularReference(identityStack, project);
            identityStack.pop();
        }
        this.checked = true;
    }

    protected void dieOnCircularReference(Project project) {
        if (this.checked || !isReference()) {
            return;
        }
        dieOnCircularReference(new IdentityStack(this), project);
    }

    protected Object getCheckedRef() {
        return getCheckedRef(getProject());
    }

    protected Object getCheckedRef(Class cls, String str) {
        return getCheckedRef(cls, str, getProject());
    }

    protected Object getCheckedRef(Class cls, String str, Project project) {
        if (project == null) {
            throw new BuildException("No Project specified");
        }
        dieOnCircularReference(project);
        Object b = this.ref.b(project);
        if (cls.isAssignableFrom(b.getClass())) {
            return b;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Class ");
        stringBuffer.append(b.getClass());
        stringBuffer.append(" is not a subclass of ");
        stringBuffer.append(cls);
        log(stringBuffer.toString(), 3);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.ref.a());
        stringBuffer2.append(" doesn't denote a ");
        stringBuffer2.append(str);
        throw new BuildException(stringBuffer2.toString());
    }

    protected Object getCheckedRef(Project project) {
        return getCheckedRef(getClass(), getDataTypeName(), project);
    }

    protected String getDataTypeName() {
        return ComponentHelper.o(getProject(), this, true);
    }

    public r getRefid() {
        return this.ref;
    }

    protected boolean isChecked() {
        return this.checked;
    }

    public boolean isReference() {
        return this.ref != null;
    }

    protected BuildException noChildrenAllowed() {
        return new BuildException("You must not specify nested elements when using refid");
    }

    protected void setChecked(boolean z) {
        this.checked = z;
    }

    public void setRefid(r rVar) {
        this.ref = rVar;
        this.checked = false;
    }

    public String toString() {
        String description = getDescription();
        if (description == null) {
            return getDataTypeName();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getDataTypeName());
        stringBuffer.append(" ");
        stringBuffer.append(description);
        return stringBuffer.toString();
    }

    protected BuildException tooManyAttributes() {
        return new BuildException("You must not specify more than one attribute when using refid");
    }
}
