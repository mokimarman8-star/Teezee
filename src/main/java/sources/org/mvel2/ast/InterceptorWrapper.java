package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class InterceptorWrapper extends ASTNode {
    private yz.b interceptor;
    private ASTNode node;

    public InterceptorWrapper(yz.b bVar, ASTNode aSTNode, ParserContext parserContext) {
        super(parserContext);
        this.node = aSTNode;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        throw null;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        throw null;
    }
}
