package org.mvel2.templates.res;

import f00.d;
import g00.c;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class IfNode extends Node {
    protected Node elseNode;
    protected Node trueNode;

    public IfNode(int i, String str, char[] cArr, int i2, int i3) {
        super(i, str, cArr, i2, i3);
        while (true) {
            int i4 = this.cEnd;
            if (i4 <= this.cStart || !m.q0(cArr[i4])) {
                return;
            } else {
                this.cEnd--;
            }
        }
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        this.trueNode = this.next;
        this.next = this.terminus;
        return true;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        int i = this.cEnd;
        int i2 = this.cStart;
        if (i == i2 || ((Boolean) org.mvel2.d.p(this.contents, i2, i - i2, obj, variableResolverFactory, Boolean.class)).booleanValue()) {
            return this.trueNode.eval(dVar, cVar, obj, variableResolverFactory);
        }
        Node node = this.next;
        if (node != null) {
            return node.eval(dVar, cVar, obj, variableResolverFactory);
        }
        return null;
    }

    public Node getElseNode() {
        return this.elseNode;
    }

    public Node getTrueNode() {
        return this.trueNode;
    }

    public void setElseNode(ExpressionNode expressionNode) {
        this.elseNode = expressionNode;
    }

    public void setTrueNode(ExpressionNode expressionNode) {
        this.trueNode = expressionNode;
    }
}
