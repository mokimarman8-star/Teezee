package org.mvel2.templates.res;

import f00.a;
import f00.d;
import g00.c;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.templates.CompiledTemplate;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class DeclareNode extends Node {
    private Node nestedNode;

    public DeclareNode(int i, String str, char[] cArr, int i2, int i3) {
        this.begin = i;
        this.name = str;
        this.contents = cArr;
        this.cStart = i2;
        this.cEnd = i3 - 1;
        this.end = i3;
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        Node node2 = this.next;
        this.nestedNode = node2;
        while (node2.getNext() != null) {
            node2 = node2.next;
        }
        node2.next = new EndNode();
        this.next = this.terminus;
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        if (dVar.h() == null) {
            dVar.k(new a());
        }
        f00.c h = dVar.h();
        char[] cArr = this.contents;
        int i = this.cStart;
        h.b((String) org.mvel2.d.p(cArr, i, this.cEnd - i, obj, variableResolverFactory, String.class), new CompiledTemplate(dVar.j(), this.nestedNode));
        Node node = this.next;
        if (node != null) {
            return node.eval(dVar, cVar, obj, variableResolverFactory);
        }
        return null;
    }
}
