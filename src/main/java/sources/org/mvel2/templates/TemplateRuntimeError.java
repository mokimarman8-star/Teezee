package org.mvel2.templates;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class TemplateRuntimeError extends RuntimeException {
    public TemplateRuntimeError() {
    }

    public TemplateRuntimeError(String str) {
        super(str);
    }

    public TemplateRuntimeError(String str, Throwable th) {
        super(str, th);
    }

    public TemplateRuntimeError(Throwable th) {
        super(th);
    }
}
