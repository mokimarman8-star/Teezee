package org.mvel2.templates.res;

import f00.d;
import g00.c;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class ExpressionNode extends Node {
    public ExpressionNode() {
    }

    public ExpressionNode(int i, String str, char[] cArr, int i2, int i3) {
        this.begin = i;
        this.name = str;
        this.contents = cArr;
        this.cStart = i2;
        this.cEnd = i3 - 1;
        this.end = i3;
    }

    public ExpressionNode(int i, String str, char[] cArr, int i2, int i3, Node node) {
        this.name = str;
        this.begin = i;
        this.contents = cArr;
        this.cStart = i2;
        this.cEnd = i3 - 1;
        this.end = i3;
        this.next = node;
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        char[] cArr = this.contents;
        int i = this.cStart;
        cVar.append(String.valueOf(org.mvel2.d.o(cArr, i, this.cEnd - i, obj, variableResolverFactory)));
        Node node = this.next;
        if (node != null) {
            return node.eval(dVar, cVar, obj, variableResolverFactory);
        }
        return null;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("ExpressionNode:");
        sb.append(this.name);
        sb.append("{");
        char[] cArr = this.contents;
        if (cArr == null) {
            str = "";
        } else {
            int i = this.cStart;
            str = new String(cArr, i, this.cEnd - i);
        }
        sb.append(str);
        sb.append("} (start=");
        sb.append(this.begin);
        sb.append(";end=");
        sb.append(this.end);
        sb.append(")");
        return sb.toString();
    }
}
