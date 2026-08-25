package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.g;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class Union extends ASTNode {
    private transient org.mvel2.compiler.a accessor;
    private ASTNode main;

    public Union(char[] cArr, int i, int i2, int i3, ASTNode aSTNode, ParserContext parserContext) {
        super(cArr, i, i2, i3, parserContext);
        this.main = aSTNode;
    }

    @Override // org.mvel2.ast.ASTNode
    public org.mvel2.compiler.a getAccessor() {
        return this.accessor;
    }

    public Class getLeftEgressType() {
        return this.main.getEgressType();
    }

    public ASTNode getMain() {
        return this.main;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return g.m(this.expr, this.start, this.offset, this.main.getReducedValue(obj, obj2, variableResolverFactory), variableResolverFactory, obj2, this.pCtx);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        org.mvel2.compiler.a aVar = this.accessor;
        if (aVar != null) {
            return aVar.getValue(this.main.getReducedValueAccelerated(obj, obj2, variableResolverFactory), obj2, variableResolverFactory);
        }
        try {
            org.mvel2.optimizers.a d = org.mvel2.optimizers.b.d();
            this.accessor = d.optimizeAccessor(this.pCtx, this.expr, this.start, this.offset, this.main.getReducedValueAccelerated(obj, obj2, variableResolverFactory), obj2, variableResolverFactory, false, this.main.getEgressType());
            return d.getResultOptPass();
        } finally {
            org.mvel2.optimizers.b.a();
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ASTNode aSTNode = this.main;
        sb.append(aSTNode != null ? aSTNode.toString() : "");
        sb.append("-[union]->");
        org.mvel2.compiler.a aVar = this.accessor;
        sb.append(aVar != null ? aVar.toString() : "");
        return sb.toString();
    }
}
