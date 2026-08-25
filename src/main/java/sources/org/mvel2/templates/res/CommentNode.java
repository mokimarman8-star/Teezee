package org.mvel2.templates.res;

import f00.d;
import g00.c;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class CommentNode extends Node {
    public CommentNode() {
    }

    public CommentNode(int i, String str, char[] cArr, int i2, int i3) {
        this.name = str;
        this.cEnd = i3;
        this.end = i3;
    }

    public CommentNode(int i, String str, char[] cArr, int i2, int i3, Node node) {
        this.begin = i;
        this.cEnd = i3;
        this.end = i3;
        this.next = node;
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        Node node = this.next;
        if (node != null) {
            return node.eval(dVar, cVar, obj, variableResolverFactory);
        }
        return null;
    }
}
