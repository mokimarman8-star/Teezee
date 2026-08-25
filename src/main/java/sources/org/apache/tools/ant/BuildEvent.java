package org.apache.tools.ant;

import java.util.EventObject;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class BuildEvent extends EventObject {
    private static final long serialVersionUID = 4538050075952288486L;
    private Throwable exception;
    private String message;
    private int priority;
    private Project project;
    private t target;
    private u task;

    public BuildEvent(Project project) {
        super(project);
        this.priority = 3;
        this.project = project;
        this.target = null;
        this.task = null;
    }

    public BuildEvent(t tVar) {
        super(tVar);
        this.priority = 3;
        this.project = tVar.e();
        this.target = tVar;
        this.task = null;
    }

    public BuildEvent(u uVar) {
        super(uVar);
        this.priority = 3;
        this.project = uVar.getProject();
        this.target = uVar.g();
        this.task = uVar;
    }

    public Throwable getException() {
        return this.exception;
    }

    public String getMessage() {
        return this.message;
    }

    public int getPriority() {
        return this.priority;
    }

    public Project getProject() {
        return this.project;
    }

    public t getTarget() {
        return this.target;
    }

    public u getTask() {
        return this.task;
    }

    public void setException(Throwable th) {
        this.exception = th;
    }

    public void setMessage(String str, int i) {
        this.message = str;
        this.priority = i;
    }
}
