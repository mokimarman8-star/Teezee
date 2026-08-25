package org.mvel2.ast;

import org.mvel2.CompileException;
import org.mvel2.MVELInterpretedRuntime;
import org.mvel2.ParserContext;
import org.mvel2.compiler.CompiledAccExpression;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.g;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class AssignmentNode extends ASTNode implements a {
    private transient CompiledAccExpression accExpr;
    private String assignmentVar;
    private boolean col;
    private String index;
    private char[] indexTarget;
    private ExecutableStatement statement;
    private String varName;

    public AssignmentNode(char[] cArr, int i, int i2, int i3, ParserContext parserContext) {
        super(parserContext);
        this.col = false;
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        int B = m.B(cArr, i, i2, '=');
        if (B != -1) {
            String x = m.x(cArr, i, B - i);
            this.varName = x;
            this.assignmentVar = x;
            int i4 = B + 1;
            int E0 = m.E0(cArr, i4);
            this.start = E0;
            if (E0 >= i + i2) {
                throw new CompileException("unexpected end of statement", cArr, i4);
            }
            int i6 = i2 - (E0 - i);
            this.offset = i6;
            if ((i3 & 16) != 0) {
                ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, E0, i6, parserContext);
                this.statement = executableStatement;
                this.egressType = executableStatement.getKnownEgressType();
            }
            int length = this.varName.length();
            char[] charArray = this.varName.toCharArray();
            this.indexTarget = charArray;
            int a = org.mvel2.util.b.a('[', 0, length, charArray);
            this.endOfName = a;
            boolean z = a > 0;
            this.col = z;
            if (z) {
                int i7 = this.fields | ASTNode.COLLECTION;
                this.fields = i7;
                if ((i7 & 16) != 0) {
                    this.accExpr = (CompiledAccExpression) org.mvel2.d.k(this.indexTarget, parserContext);
                }
                this.varName = new String(cArr, i, this.endOfName);
                char[] cArr2 = this.indexTarget;
                int i8 = this.endOfName;
                this.index = new String(cArr2, i8, cArr2.length - i8);
            }
            try {
                m.k(this.varName);
            } catch (RuntimeException e) {
                throw new CompileException(e.getMessage(), cArr, i);
            }
        } else {
            try {
                String str = new String(cArr, i, i2);
                this.varName = str;
                m.k(str);
                this.assignmentVar = this.varName;
            } catch (RuntimeException e3) {
                throw new CompileException(e3.getMessage(), cArr, i);
            }
        }
        if ((i3 & 16) != 0) {
            parserContext.addVariable(this.varName, this.egressType);
        }
    }

    @Override // org.mvel2.ast.a
    public String getAssignmentVar() {
        return this.assignmentVar;
    }

    public char[] getExpression() {
        return m.K0(this.expr, this.start, this.offset);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        m.k(this.varName);
        MVELInterpretedRuntime mVELInterpretedRuntime = new MVELInterpretedRuntime(this.expr, this.start, this.offset, obj, variableResolverFactory, this.pCtx);
        if (!this.col) {
            return variableResolverFactory.createVariable(this.varName, mVELInterpretedRuntime.parse()).getValue();
        }
        Object value = variableResolverFactory.getVariableResolver(this.varName).getValue();
        String str = this.index;
        Object parse = mVELInterpretedRuntime.parse();
        g.A(value, variableResolverFactory, str, parse, this.pCtx);
        return parse;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        char[] cArr;
        if (this.accExpr == null && (cArr = this.indexTarget) != null) {
            this.accExpr = (CompiledAccExpression) org.mvel2.d.h(cArr);
        }
        if (this.col) {
            return this.accExpr.setValue(obj, obj2, variableResolverFactory, this.statement.getValue(obj, obj2, variableResolverFactory));
        }
        ExecutableStatement executableStatement = this.statement;
        if (executableStatement != null) {
            if (variableResolverFactory != null) {
                return variableResolverFactory.createVariable(this.varName, executableStatement.getValue(obj, obj2, variableResolverFactory)).getValue();
            }
            throw new CompileException("cannot assign variables; no variable resolver factory available", this.expr, this.start);
        }
        if (variableResolverFactory == null) {
            throw new CompileException("cannot assign variables; no variable resolver factory available", this.expr, this.start);
        }
        variableResolverFactory.createVariable(this.varName, null);
        return null;
    }

    @Override // org.mvel2.ast.a
    public boolean isNewDeclaration() {
        return false;
    }

    @Override // org.mvel2.ast.a
    public void setValueStatement(ExecutableStatement executableStatement) {
        this.statement = executableStatement;
    }

    @Override // org.mvel2.ast.ASTNode
    public String toString() {
        return this.assignmentVar + " = " + new String(this.expr, this.start, this.offset);
    }
}
