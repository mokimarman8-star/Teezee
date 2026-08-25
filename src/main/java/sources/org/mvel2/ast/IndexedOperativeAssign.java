package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class IndexedOperativeAssign extends ASTNode {
    private final int operation;
    private final int register;
    private ExecutableStatement statement;

    public IndexedOperativeAssign(char[] cArr, int i, int i2, int i3, int i4, int i6, ParserContext parserContext) {
        super(parserContext);
        this.operation = i3;
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        this.register = i4;
        if ((i6 & 16) != 0) {
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, i, i2, parserContext);
            this.statement = executableStatement;
            this.egressType = executableStatement.getKnownEgressType();
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        VariableResolver indexedVariableResolver = variableResolverFactory.getIndexedVariableResolver(this.register);
        Object g = a00.a.g(indexedVariableResolver.getValue(), this.operation, org.mvel2.d.o(this.expr, this.start, this.offset, obj, variableResolverFactory));
        indexedVariableResolver.setValue(g);
        return g;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        VariableResolver indexedVariableResolver = variableResolverFactory.getIndexedVariableResolver(this.register);
        Object g = a00.a.g(indexedVariableResolver.getValue(), this.operation, this.statement.getValue(obj, obj2, variableResolverFactory));
        indexedVariableResolver.setValue(g);
        return g;
    }
}
