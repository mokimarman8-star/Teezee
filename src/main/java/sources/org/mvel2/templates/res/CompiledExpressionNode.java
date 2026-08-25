package org.mvel2.templates.res;

import g00.c;
import java.io.Serializable;
import org.mvel2.ParserContext;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class CompiledExpressionNode extends ExpressionNode {
    private Serializable ce;

    public CompiledExpressionNode(int i, String str, char[] cArr, int i2, int i3, ParserContext parserContext) {
        this.begin = i;
        this.name = str;
        this.contents = cArr;
        this.cStart = i2;
        int i4 = i3 - 1;
        this.cEnd = i4;
        this.end = i3;
        this.ce = d.e(cArr, i2, i4 - i2, parserContext);
    }

    @Override // org.mvel2.templates.res.ExpressionNode, org.mvel2.templates.res.Node
    public Object eval(f00.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        cVar.append(String.valueOf(d.r(this.ce, obj, variableResolverFactory)));
        Node node = this.next;
        if (node != null) {
            return node.eval(dVar, cVar, obj, variableResolverFactory);
        }
        return null;
    }

    @Override // org.mvel2.templates.res.ExpressionNode
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExpressionNode:");
        sb.append(this.name);
        sb.append("{");
        char[] cArr = this.contents;
        sb.append(cArr == null ? "" : new String(cArr));
        sb.append("} (start=");
        sb.append(this.begin);
        sb.append(";end=");
        sb.append(this.end);
        sb.append(")");
        return sb.toString();
    }
}
