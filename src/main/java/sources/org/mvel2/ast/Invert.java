package org.mvel2.ast;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.e;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class Invert extends ASTNode {
    private ExecutableStatement stmt;

    public Invert(char[] cArr, int i, int i2, int i3, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        if ((i3 & 16) != 0) {
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, i, i2, parserContext);
            this.stmt = executableStatement;
            e.c(parserContext, executableStatement, Integer.class, true);
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Object o = org.mvel2.d.o(this.expr, this.start, this.offset, obj, variableResolverFactory);
        if (o instanceof Integer) {
            return Integer.valueOf(~((Integer) o).intValue());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("was expecting type: Integer; but found type: ");
        sb.append(o == null ? "null" : o.getClass().getName());
        throw new CompileException(sb.toString(), this.expr, this.start);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return Integer.valueOf(~((Integer) this.stmt.getValue(obj, obj2, variableResolverFactory)).intValue());
    }
}
