package org.mvel2.ast;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.CompiledAccExpression;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class IndexedAssignmentNode extends ASTNode implements a {
    private transient CompiledAccExpression accExpr;
    private String assignmentVar;
    private boolean col;
    private char[] index;
    private char[] indexTarget;
    private String name;
    private int register;
    private ExecutableStatement statement;
    private char[] stmt;

    public IndexedAssignmentNode(char[] cArr, int i, int i2, int i3, int i4, String str, int i6, ParserContext parserContext) {
        super(parserContext);
        this.col = false;
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        this.register = i6;
        if (i4 != -1) {
            this.name = str;
            m.k(str);
            char[] w = m.w(str, cArr, i, i2, i4);
            this.stmt = w;
            ExecutableStatement executableStatement = (ExecutableStatement) m.J0(w, parserContext);
            this.statement = executableStatement;
            this.egressType = executableStatement.getKnownEgressType();
        } else {
            int B = m.B(cArr, i, i2, '=');
            if (B != -1) {
                this.name = m.x(cArr, i, B - i);
                this.assignmentVar = str;
                int i7 = B + 1;
                int E0 = m.E0(cArr, i7);
                this.start = E0;
                if (E0 >= i + i2) {
                    throw new CompileException("unexpected end of statement", cArr, i7);
                }
                int i8 = i2 - (E0 - i);
                this.offset = i8;
                this.stmt = m.K0(cArr, E0, i8);
                ExecutableStatement executableStatement2 = (ExecutableStatement) m.I0(cArr, this.start, this.offset, parserContext);
                this.statement = executableStatement2;
                this.egressType = executableStatement2.getKnownEgressType();
                int length = this.name.length();
                char[] charArray = this.name.toCharArray();
                this.indexTarget = charArray;
                short a = (short) org.mvel2.util.b.a('[', 0, length, charArray);
                this.endOfName = a;
                boolean z = a > 0;
                this.col = z;
                if (z) {
                    int i9 = this.fields | ASTNode.COLLECTION;
                    this.fields = i9;
                    if ((i9 & 16) != 0) {
                        this.accExpr = (CompiledAccExpression) org.mvel2.d.k(this.indexTarget, parserContext);
                    }
                    this.name = this.name.substring(0, this.endOfName);
                    char[] cArr2 = this.indexTarget;
                    int i10 = this.endOfName;
                    this.index = m.K0(cArr2, i10, cArr2.length - i10);
                }
                m.k(this.name);
            } else {
                String str2 = new String(cArr);
                this.name = str2;
                m.k(str2);
                this.assignmentVar = str;
            }
        }
        if ((i3 & 16) != 0) {
            parserContext.addVariable(str, this.egressType);
        }
    }

    public IndexedAssignmentNode(char[] cArr, int i, int i2, int i3, int i4, ParserContext parserContext) {
        this(cArr, i, i2, i3, -1, null, i4, parserContext);
    }

    @Override // org.mvel2.ast.ASTNode
    public String getAbsoluteName() {
        return this.name;
    }

    @Override // org.mvel2.ast.a
    public String getAssignmentVar() {
        return this.assignmentVar;
    }

    public char[] getExpression() {
        return this.stmt;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        m.k(this.name);
        if (this.col) {
            Object value = variableResolverFactory.getIndexedVariableResolver(this.register).getValue();
            String str = new String(this.index);
            Object q = org.mvel2.d.q(this.stmt, obj, variableResolverFactory);
            org.mvel2.d.y(value, str, q);
            return q;
        }
        int i = this.register;
        String str2 = this.name;
        Object q2 = org.mvel2.d.q(this.stmt, obj, variableResolverFactory);
        variableResolverFactory.createIndexedVariable(i, str2, q2);
        return q2;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        char[] cArr;
        if (this.accExpr == null && (cArr = this.indexTarget) != null) {
            this.accExpr = (CompiledAccExpression) org.mvel2.d.h(cArr);
        }
        if (this.col) {
            CompiledAccExpression compiledAccExpression = this.accExpr;
            Object value = this.statement.getValue(obj, obj2, variableResolverFactory);
            compiledAccExpression.setValue(obj, obj2, variableResolverFactory, value);
            return value;
        }
        if (this.statement == null) {
            if (variableResolverFactory.isIndexedFactory()) {
                variableResolverFactory.createIndexedVariable(this.register, this.name, null);
                return Void.class;
            }
            variableResolverFactory.createVariable(this.name, this.statement.getValue(obj, obj2, variableResolverFactory));
            return Void.class;
        }
        if (!variableResolverFactory.isIndexedFactory()) {
            String str = this.name;
            Object value2 = this.statement.getValue(obj, obj2, variableResolverFactory);
            variableResolverFactory.createVariable(str, value2);
            return value2;
        }
        int i = this.register;
        String str2 = this.name;
        Object value3 = this.statement.getValue(obj, obj2, variableResolverFactory);
        variableResolverFactory.createIndexedVariable(i, str2, value3);
        return value3;
    }

    public int getRegister() {
        return this.register;
    }

    public String getVarName() {
        return this.name;
    }

    @Override // org.mvel2.ast.ASTNode
    public boolean isAssignment() {
        return true;
    }

    @Override // org.mvel2.ast.a
    public boolean isNewDeclaration() {
        return false;
    }

    public void setRegister(int i) {
        this.register = i;
    }

    @Override // org.mvel2.ast.a
    public void setValueStatement(ExecutableStatement executableStatement) {
        this.statement = executableStatement;
    }
}
