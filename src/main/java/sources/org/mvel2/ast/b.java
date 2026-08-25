package org.mvel2.ast;

import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class b {
    protected final Function a;

    public b(Function function) {
        this.a = function;
    }

    public abstract Object a(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object[] objArr);

    public Function b() {
        return this.a;
    }
}
