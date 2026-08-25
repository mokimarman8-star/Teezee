package org.mvel2.optimizers.impl.refl.nodes;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.b;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a implements org.mvel2.compiler.a {
    private org.mvel2.compiler.a a;
    private char[] b;
    private int c;
    private int d;
    private org.mvel2.compiler.a e;
    private ParserContext f;

    public a(ParserContext parserContext, org.mvel2.compiler.a aVar, char[] cArr, int i, int i2) {
        this.a = aVar;
        this.c = i;
        this.d = i2;
        this.b = cArr;
        this.f = parserContext;
    }

    private Object b(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (this.e != null) {
            return this.a.getValue(obj, obj2, variableResolverFactory);
        }
        Object value = this.a.getValue(obj, obj2, variableResolverFactory);
        org.mvel2.optimizers.a c = b.c();
        this.e = c.optimizeAccessor(this.f, this.b, this.c, this.d, value, obj2, variableResolverFactory, false, this.a.getKnownEgressType());
        return c.getResultOptPass();
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.e.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        org.mvel2.compiler.a aVar = this.e;
        return aVar == null ? b(obj, obj2, variableResolverFactory) : aVar.getValue(b(obj, obj2, variableResolverFactory), obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return this.e.setValue(b(obj, obj2, variableResolverFactory), obj2, variableResolverFactory, obj3);
    }
}
