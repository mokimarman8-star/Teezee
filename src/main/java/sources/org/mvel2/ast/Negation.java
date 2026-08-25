package org.mvel2.ast;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class Negation extends ASTNode {
    private ExecutableStatement stmt;

    public Negation(char[] cArr, int i, int i2, int i3, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        if ((i3 & 16) != 0) {
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, i, i2, parserContext);
            this.stmt = executableStatement;
            if (executableStatement.getKnownEgressType() != null && !m.f(this.stmt.getKnownEgressType()).isAssignableFrom(Boolean.class)) {
                throw new CompileException("negation operator cannot be applied to non-boolean type", cArr, i);
            }
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Class getEgressType() {
        return Boolean.class;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            return Boolean.valueOf(!((Boolean) org.mvel2.d.o(this.expr, this.start, this.offset, obj, variableResolverFactory)).booleanValue());
        } catch (ClassCastException e) {
            throw new CompileException("negation operator applied to non-boolean expression", this.expr, this.start, e);
        } catch (NullPointerException e3) {
            throw new CompileException("negation operator applied to a null value", this.expr, this.start, e3);
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return Boolean.valueOf(!((Boolean) this.stmt.getValue(obj, obj2, variableResolverFactory)).booleanValue());
    }

    public ExecutableStatement getStatement() {
        return this.stmt;
    }
}
