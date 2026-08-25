package org.mvel2.templates.res;

import g00.c;
import g00.d;
import java.io.Serializable;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.StackDelimiterResolverFactory;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.TemplateError;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class CompiledNamedIncludeNode extends Node {
    private Serializable cIncludeExpression;
    private Serializable cPreExpression;

    public CompiledNamedIncludeNode(int i, String str, char[] cArr, int i2, int i3, ParserContext parserContext) {
        this.begin = i;
        this.name = str;
        this.contents = cArr;
        this.cStart = i2;
        this.cEnd = i3 - 1;
        this.end = i3;
        int a = d.a(cArr, i2);
        char[] cArr2 = this.contents;
        int i4 = this.cStart;
        this.cIncludeExpression = org.mvel2.d.e(cArr2, i4, a - i4, parserContext);
        char[] cArr3 = this.contents;
        if (a != cArr3.length) {
            int i6 = a + 1;
            this.cPreExpression = org.mvel2.d.e(cArr3, i6, this.cEnd - i6, parserContext);
        }
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(f00.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        StackDelimiterResolverFactory stackDelimiterResolverFactory = new StackDelimiterResolverFactory(variableResolverFactory);
        Serializable serializable = this.cPreExpression;
        if (serializable != null) {
            org.mvel2.d.r(serializable, obj, stackDelimiterResolverFactory);
        }
        if (this.next == null) {
            return cVar.append(String.valueOf(f00.d.f(dVar.h().a((String) org.mvel2.d.s(this.cIncludeExpression, obj, stackDelimiterResolverFactory, String.class)), obj, stackDelimiterResolverFactory, dVar.h())));
        }
        String str = (String) org.mvel2.d.s(this.cIncludeExpression, obj, stackDelimiterResolverFactory, String.class);
        CompiledTemplate a = dVar.h().a(str);
        if (a != null) {
            return this.next.eval(dVar, cVar.append(String.valueOf(f00.d.f(a, obj, stackDelimiterResolverFactory, dVar.h()))), obj, stackDelimiterResolverFactory);
        }
        throw new TemplateError("named template does not exist: " + str);
    }
}
