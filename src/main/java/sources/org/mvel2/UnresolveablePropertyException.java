package org.mvel2;

import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class UnresolveablePropertyException extends RuntimeException {
    private String name;

    public UnresolveablePropertyException(String str) {
        super("unable to resolve token: " + str);
        this.name = str;
    }

    public UnresolveablePropertyException(ASTNode aSTNode) {
        super("unable to resolve token: " + aSTNode.getName());
        this.name = aSTNode.getName();
    }

    public UnresolveablePropertyException(ASTNode aSTNode, Throwable th) {
        super("unable to resolve token: " + aSTNode.getName(), th);
        this.name = aSTNode.getName();
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return null;
    }

    public String getName() {
        return this.name;
    }
}
