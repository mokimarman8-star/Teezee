package org.mvel2.templates.res;

import g00.c;
import g00.d;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class NamedIncludeNode extends Node {
    int includeOffset;
    int includeStart;
    int preOffset;
    int preStart;

    public NamedIncludeNode(int i, String str, char[] cArr, int i2, int i3) {
        this.begin = i;
        this.name = str;
        this.contents = cArr;
        this.cStart = i2;
        this.cEnd = i3 - 1;
        this.end = i3;
        int a = d.a(cArr, 0);
        int i4 = this.cStart;
        this.includeStart = i4;
        this.includeOffset = a - i4;
        int i6 = a + 1;
        this.preStart = i6;
        this.preOffset = this.cEnd - i6;
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(f00.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        int i = this.preOffset;
        if (i != 0) {
            org.mvel2.d.o(this.contents, this.preStart, i, obj, variableResolverFactory);
        }
        Node node = this.next;
        return node != null ? node.eval(dVar, cVar.append(String.valueOf(f00.d.e(dVar.h().a((String) org.mvel2.d.p(this.contents, this.includeStart, this.includeOffset, obj, variableResolverFactory, String.class)), obj, variableResolverFactory))), obj, variableResolverFactory) : cVar.append(String.valueOf(f00.d.e(dVar.h().a((String) org.mvel2.d.p(this.contents, this.includeStart, this.includeOffset, obj, variableResolverFactory, String.class)), obj, variableResolverFactory)));
    }
}
