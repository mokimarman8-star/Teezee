package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.ast.Proto;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class DeclProtoVarNode extends ASTNode implements a {
    private String name;

    public DeclProtoVarNode(String str, Proto proto, int i, ParserContext parserContext) {
        super(parserContext);
        this.egressType = Proto.b.class;
        this.name = str;
        m.k(str);
        if ((i & 16) != 0) {
            parserContext.addVariable(str, this.egressType, true);
        }
    }

    @Override // org.mvel2.ast.a
    public String getAssignmentVar() {
        return this.name;
    }

    public char[] getExpression() {
        return new char[0];
    }

    @Override // org.mvel2.ast.ASTNode
    public String getName() {
        return this.name;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!variableResolverFactory.isResolveable(this.name)) {
            variableResolverFactory.createVariable(this.name, null, this.egressType);
            return null;
        }
        throw new RuntimeException("variable defined within scope: " + this.name);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!variableResolverFactory.isResolveable(this.name)) {
            variableResolverFactory.createVariable(this.name, null, this.egressType);
            return null;
        }
        throw new RuntimeException("variable defined within scope: " + this.name);
    }

    @Override // org.mvel2.ast.ASTNode
    public boolean isAssignment() {
        return true;
    }

    @Override // org.mvel2.ast.a
    public boolean isNewDeclaration() {
        return true;
    }

    @Override // org.mvel2.ast.a
    public void setValueStatement(ExecutableStatement executableStatement) {
        throw new RuntimeException("illegal operation");
    }

    @Override // org.mvel2.ast.ASTNode
    public String toString() {
        return "var:" + this.name;
    }
}
