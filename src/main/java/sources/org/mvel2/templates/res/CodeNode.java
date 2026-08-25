package org.mvel2.templates.res;

import f00.d;
import g00.c;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class CodeNode extends Node {
    private int offset;
    private int start;

    public CodeNode() {
    }

    public CodeNode(int i, String str, char[] cArr, int i2, int i3) {
        this.begin = i;
        this.name = str;
        this.contents = cArr;
        this.start = i2;
        this.offset = (i3 - i2) - 1;
    }

    public CodeNode(int i, String str, char[] cArr, int i2, int i3, Node node) {
        this.name = str;
        this.begin = i;
        this.next = node;
        this.start = i2;
        this.offset = (i3 - i2) - 1;
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        org.mvel2.d.o(this.contents, this.start, this.offset, obj, variableResolverFactory);
        Node node = this.next;
        if (node != null) {
            return node.eval(dVar, cVar, obj, variableResolverFactory);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CodeNode:");
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
