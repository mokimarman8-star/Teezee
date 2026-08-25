package org.mvel2.templates.res;

import g00.c;
import java.io.Serializable;
import org.mvel2.ParserContext;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class CompiledTerminalExpressionNode extends TerminalExpressionNode {
    private Serializable ce;

    public CompiledTerminalExpressionNode(Node node, ParserContext parserContext) {
        this.begin = node.begin;
        this.name = node.name;
        char[] cArr = node.contents;
        int i = node.cStart;
        this.ce = d.e(cArr, i, node.cEnd - i, parserContext);
    }

    @Override // org.mvel2.templates.res.TerminalExpressionNode, org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.TerminalExpressionNode, org.mvel2.templates.res.Node
    public Object eval(f00.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        return d.r(this.ce, obj, variableResolverFactory);
    }
}
