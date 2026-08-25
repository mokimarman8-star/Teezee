package org.mvel2.ast;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.CompiledAccExpression;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.g;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class DeepAssignmentNode extends ASTNode implements a {
    private CompiledAccExpression acc;
    private String property;
    private ExecutableStatement statement;

    public DeepAssignmentNode(char[] cArr, int i, int i2, int i3, int i4, String str, ParserContext parserContext) {
        super(parserContext);
        this.fields |= i3 | 2;
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        if (i4 != -1) {
            this.property = str;
            ExecutableStatement executableStatement = (ExecutableStatement) m.J0(m.w(str, cArr, i, i2, i4), parserContext);
            this.statement = executableStatement;
            this.egressType = executableStatement.getKnownEgressType();
        } else {
            int B = m.B(cArr, i, i2, '=');
            if (B != -1) {
                this.property = m.x(cArr, i, B - i);
                int i6 = B + 1;
                int E0 = m.E0(cArr, i6);
                this.start = E0;
                if (E0 >= i + i2) {
                    throw new CompileException("unexpected end of statement", cArr, i6);
                }
                int i7 = i2 - (E0 - i);
                this.offset = i7;
                if ((i3 & 16) != 0) {
                    this.statement = (ExecutableStatement) m.I0(cArr, E0, i7, parserContext);
                }
            } else {
                this.property = new String(cArr);
            }
        }
        if ((i3 & 16) != 0) {
            this.acc = (CompiledAccExpression) org.mvel2.d.i(this.property.toCharArray(), i, i2, parserContext);
        }
    }

    public DeepAssignmentNode(char[] cArr, int i, int i2, int i3, ParserContext parserContext) {
        this(cArr, i, i2, i3, -1, null, parserContext);
    }

    @Override // org.mvel2.ast.ASTNode
    public String getAbsoluteName() {
        String str = this.property;
        return str.substring(0, str.indexOf(46));
    }

    @Override // org.mvel2.ast.a
    public String getAssignmentVar() {
        return this.property;
    }

    public char[] getExpression() {
        return m.F0(this.expr, this.start, this.offset);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        String str = this.property;
        Object o = org.mvel2.d.o(this.expr, this.start, this.offset, obj, variableResolverFactory);
        g.A(obj, variableResolverFactory, str, o, this.pCtx);
        return o;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (this.statement == null) {
            this.statement = (ExecutableStatement) m.I0(this.expr, this.start, this.offset, this.pCtx);
            this.acc = (CompiledAccExpression) org.mvel2.d.j(this.property.toCharArray(), this.statement.getKnownEgressType(), this.pCtx);
        }
        CompiledAccExpression compiledAccExpression = this.acc;
        Object value = this.statement.getValue(obj, obj2, variableResolverFactory);
        compiledAccExpression.setValue(obj, obj2, variableResolverFactory, value);
        return value;
    }

    @Override // org.mvel2.ast.ASTNode
    public boolean isAssignment() {
        return true;
    }

    @Override // org.mvel2.ast.a
    public boolean isNewDeclaration() {
        return false;
    }

    @Override // org.mvel2.ast.a
    public void setValueStatement(ExecutableStatement executableStatement) {
        this.statement = executableStatement;
    }
}
