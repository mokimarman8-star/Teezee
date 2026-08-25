package org.mvel2.templates.res;

import g00.c;
import java.io.Serializable;
import org.mvel2.ParserContext;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class CompiledIfNode extends IfNode {
    private Serializable ce;

    public CompiledIfNode(int i, String str, char[] cArr, int i2, int i3, ParserContext parserContext) {
        super(i, str, cArr, i2, i3);
        while (true) {
            int i4 = this.cEnd;
            if (i4 <= this.cStart || !m.q0(cArr[i4])) {
                break;
            } else {
                this.cEnd--;
            }
        }
        int i6 = this.cStart;
        int i7 = this.cEnd;
        if (i6 != i7) {
            this.ce = d.e(cArr, i6, i7 - i2, parserContext);
        }
    }

    @Override // org.mvel2.templates.res.IfNode, org.mvel2.templates.res.Node
    public Object eval(f00.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        Serializable serializable = this.ce;
        if (serializable == null || ((Boolean) d.s(serializable, obj, variableResolverFactory, Boolean.class)).booleanValue()) {
            return this.trueNode.eval(dVar, cVar, obj, variableResolverFactory);
        }
        Node node = this.next;
        if (node != null) {
            return node.eval(dVar, cVar, obj, variableResolverFactory);
        }
        return null;
    }
}
