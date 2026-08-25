package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.ast.Proto;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class ProtoVarNode extends ASTNode implements a {
    private String name;
    private ExecutableStatement statement;

    public ProtoVarNode(char[] cArr, int i, int i2, int i3, Proto proto, ParserContext parserContext) {
        super(parserContext);
        this.egressType = Proto.b.class;
        this.start = i;
        this.offset = i2;
        this.fields = i3;
        this.expr = cArr;
        int B = m.B(cArr, i, i2, '=');
        if (B != -1) {
            String x = m.x(cArr, 0, B);
            this.name = x;
            m.k(x);
            i3 |= ASTNode.ASSIGN;
            if ((i3 & 16) != 0) {
                this.statement = (ExecutableStatement) m.I0(cArr, B + 1, i2, parserContext);
            }
        } else {
            String str = new String(cArr, i, i2);
            this.name = str;
            m.k(str);
        }
        if ((i3 & 16) != 0) {
            parserContext.addVariable(this.name, this.egressType, true);
        }
    }

    @Override // org.mvel2.ast.a
    public String getAssignmentVar() {
        return this.name;
    }

    public char[] getExpression() {
        return this.expr;
    }

    @Override // org.mvel2.ast.ASTNode
    public String getName() {
        return this.name;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        String str = this.name;
        Object o = org.mvel2.d.o(this.expr, this.start, this.offset, obj2, variableResolverFactory);
        variableResolverFactory.createVariable(str, o, this.egressType);
        return o;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (this.statement == null) {
            this.statement = (ExecutableStatement) m.I0(this.expr, this.start, this.offset, this.pCtx);
        }
        String str = this.name;
        Object value = this.statement.getValue(obj, obj2, variableResolverFactory);
        variableResolverFactory.createVariable(str, value, this.egressType);
        return value;
    }

    @Override // org.mvel2.ast.a
    public boolean isNewDeclaration() {
        return true;
    }

    @Override // org.mvel2.ast.a
    public void setValueStatement(ExecutableStatement executableStatement) {
        this.statement = executableStatement;
    }
}
