package org.mvel2.ast;

import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class d extends b {
    private final VariableResolverFactory b;

    public d(Function function, VariableResolverFactory variableResolverFactory) {
        super(function);
        this.b = variableResolverFactory;
    }

    @Override // org.mvel2.ast.b
    public Object a(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object[] objArr) {
        return this.a.call(obj, obj2, new InvokationContextFactory(variableResolverFactory, this.b), objArr);
    }

    public VariableResolverFactory c() {
        return this.b;
    }

    public String toString() {
        return "function_prototype:" + this.a.getName();
    }
}
