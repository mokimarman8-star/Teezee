package b00;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.OptimizationNotSupported;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class d implements a {
    private char[] a;
    private int b;
    private int c;
    private int e;
    private int f;
    private ParserContext h;
    private org.mvel2.compiler.a i;
    private org.mvel2.compiler.a j;
    private boolean g = false;
    private long d = System.currentTimeMillis();

    public d(ParserContext parserContext, char[] cArr, int i, int i2, int i3, org.mvel2.compiler.a aVar) {
        this.j = aVar;
        this.i = aVar;
        this.e = i3;
        this.a = cArr;
        this.b = i;
        this.c = i2;
        this.h = parserContext;
    }

    private Object b(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (DynamicOptimizer.isOverloaded()) {
            DynamicOptimizer.enforceTenureLimit();
        }
        org.mvel2.optimizers.a b = org.mvel2.optimizers.b.b("ASM");
        int i = this.e;
        if (i == 0) {
            this.j = b.optimizeAccessor(this.h, this.a, this.b, this.c, obj, obj2, variableResolverFactory, false, null);
            return b.getResultOptPass();
        }
        if (i == 2) {
            org.mvel2.compiler.a optimizeCollection = b.optimizeCollection(this.h, obj, null, this.a, this.b, this.c, obj, obj2, variableResolverFactory);
            this.j = optimizeCollection;
            return optimizeCollection.getValue(obj, obj2, variableResolverFactory);
        }
        if (i != 3) {
            return null;
        }
        org.mvel2.compiler.a optimizeObjectCreation = b.optimizeObjectCreation(this.h, this.a, this.b, this.c, obj, obj2, variableResolverFactory);
        this.j = optimizeObjectCreation;
        return optimizeObjectCreation.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // b00.a
    public void a() {
        this.j = this.i;
        this.g = false;
        this.f = 0;
        this.d = System.currentTimeMillis();
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.i.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.g) {
            int i = this.f + 1;
            this.f = i;
            if (i > DynamicOptimizer.tenuringThreshold) {
                if (System.currentTimeMillis() - this.d < DynamicOptimizer.timeSpan) {
                    this.g = true;
                    try {
                        return b(obj, obj2, variableResolverFactory);
                    } catch (OptimizationNotSupported unused) {
                    }
                } else {
                    this.f = 0;
                    this.d = System.currentTimeMillis();
                }
            }
        }
        return this.j.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        this.f++;
        return this.j.setValue(obj, obj2, variableResolverFactory, obj3);
    }
}
