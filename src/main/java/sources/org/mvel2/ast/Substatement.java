package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class Substatement extends ASTNode {
    private ExecutableStatement statement;

    public Substatement(char[] cArr, int i, int i2, int i3, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        this.fields = i3;
        if ((i3 & 16) != 0) {
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, i, i2, parserContext);
            this.statement = executableStatement;
            this.egressType = executableStatement.getKnownEgressType();
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return org.mvel2.d.o(this.expr, this.start, this.offset, obj, variableResolverFactory);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return this.statement.getValue(obj, obj2, variableResolverFactory);
    }

    public ExecutableStatement getStatement() {
        return this.statement;
    }

    @Override // org.mvel2.ast.ASTNode
    public String toString() {
        ExecutableStatement executableStatement = this.statement;
        if (executableStatement != null) {
            return executableStatement.toString();
        }
        return "(" + new String(this.expr, this.start, this.offset) + ")";
    }
}
