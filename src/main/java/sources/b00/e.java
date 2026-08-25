package b00;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class e implements a {
    private char[] a;
    private int b;
    private int c;
    private boolean d = false;
    private int e = 0;
    private long f = System.currentTimeMillis();
    private ParserContext g;
    private final org.mvel2.compiler.a h;
    private org.mvel2.compiler.a i;

    public e(ParserContext parserContext, char[] cArr, int i, int i2, org.mvel2.compiler.a aVar) {
        this.i = aVar;
        this.h = aVar;
        this.g = parserContext;
        this.a = cArr;
        this.b = i;
        this.c = i2;
    }

    private Object b(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        if (DynamicOptimizer.isOverloaded()) {
            DynamicOptimizer.enforceTenureLimit();
        }
        this.i = org.mvel2.optimizers.b.b("ASM").optimizeSetAccessor(this.g, this.a, this.b, this.c, obj, obj2, variableResolverFactory, false, obj3, obj3 != null ? obj3.getClass() : Object.class);
        return obj3;
    }

    @Override // b00.a
    public void a() {
        this.i = this.h;
        this.d = false;
        this.e = 0;
        this.f = System.currentTimeMillis();
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.h.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        throw new RuntimeException("value cannot be read with this accessor");
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        if (!this.d) {
            int i = this.e + 1;
            this.e = i;
            if (i > DynamicOptimizer.tenuringThreshold) {
                if (System.currentTimeMillis() - this.f < DynamicOptimizer.timeSpan) {
                    this.d = true;
                    return b(obj, obj2, variableResolverFactory, obj3);
                }
                this.e = 0;
                this.f = System.currentTimeMillis();
            }
        }
        this.i.setValue(obj, obj2, variableResolverFactory, obj3);
        return obj3;
    }
}
