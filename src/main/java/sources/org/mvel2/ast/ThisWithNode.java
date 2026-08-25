package org.mvel2.ast;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.WithNode;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class ThisWithNode extends WithNode {
    public ThisWithNode(char[] cArr, int i, int i2, int i3, int i4, int i6, ParserContext parserContext) {
        super(cArr, i, i2, i3, i4, i6, parserContext);
    }

    @Override // org.mvel2.ast.WithNode, org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return getReducedValueAccelerated(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.ast.WithNode, org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (obj2 == null) {
            throw new CompileException("with-block against null pointer (this)", this.expr, this.start);
        }
        for (WithNode.ParmValuePair parmValuePair : this.withExpressions) {
            if (parmValuePair.getSetExpression() != null) {
                org.mvel2.d.t(parmValuePair.getSetExpression(), obj2, variableResolverFactory, parmValuePair.getStatement().getValue(obj, obj2, variableResolverFactory));
            } else {
                parmValuePair.getStatement().getValue(obj2, obj2, variableResolverFactory);
            }
        }
        return obj2;
    }
}
