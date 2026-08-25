package b00;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class c implements a {
    private ParserContext a;
    private Object b;
    private Class c;
    private char[] d;
    private int e;
    private int f;
    private int h;
    private int i;
    private org.mvel2.compiler.a k;
    private org.mvel2.compiler.a l;
    private boolean j = false;
    private long g = System.currentTimeMillis();

    public c(ParserContext parserContext, Object obj, Class cls, char[] cArr, int i, int i2, int i3, org.mvel2.compiler.a aVar) {
        this.a = parserContext;
        this.b = obj;
        this.c = cls;
        this.l = aVar;
        this.k = aVar;
        this.h = i3;
        this.d = cArr;
        this.e = i;
        this.f = i2;
    }

    private Object b(ParserContext parserContext, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (DynamicOptimizer.isOverloaded()) {
            DynamicOptimizer.enforceTenureLimit();
        }
        org.mvel2.compiler.a optimizeCollection = org.mvel2.optimizers.b.b("ASM").optimizeCollection(parserContext, this.b, this.c, this.d, this.e, this.f, obj, obj2, variableResolverFactory);
        this.l = optimizeCollection;
        return optimizeCollection.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // b00.a
    public void a() {
        this.l = this.k;
        this.j = false;
        this.i = 0;
        this.g = System.currentTimeMillis();
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.c;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.j) {
            int i = this.i + 1;
            this.i = i;
            if (i > DynamicOptimizer.tenuringThreshold) {
                if (System.currentTimeMillis() - this.g < DynamicOptimizer.timeSpan) {
                    this.j = true;
                    return b(this.a, obj, obj2, variableResolverFactory);
                }
                this.i = 0;
                this.g = System.currentTimeMillis();
            }
        }
        return this.l.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        this.i++;
        return this.l.setValue(obj, obj2, variableResolverFactory, obj3);
    }
}
