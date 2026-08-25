package c00;

import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableLiteral;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;
import org.mvel2.util.p;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b implements org.mvel2.compiler.a {
    public ExecutableStatement a;

    public b(String str, Class cls, Object obj, VariableResolverFactory variableResolverFactory, ParserContext parserContext) {
        this.a = (ExecutableStatement) m.J0(str.toCharArray(), parserContext);
        Class T = m.T(cls);
        Class knownEgressType = this.a.getKnownEgressType();
        if (this.a.getKnownEgressType() == null || p.f(T, knownEgressType)) {
            return;
        }
        if ((this.a instanceof ExecutableLiteral) && org.mvel2.b.a(knownEgressType, T)) {
            try {
                this.a = new ExecutableLiteral(org.mvel2.b.b(this.a.getValue(obj, variableResolverFactory), T));
                return;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (parserContext == null || !parserContext.isStrongTyping()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("was expecting type: ");
        sb.append(T);
        sb.append("; but found type: ");
        sb.append(knownEgressType == null ? "null" : knownEgressType.getName());
        throw new RuntimeException(sb.toString());
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.a.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return this.a.getValue(obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return null;
    }
}
