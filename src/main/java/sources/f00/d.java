package f00;

import java.util.Map;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.res.Node;
import org.mvel2.util.g;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class d {
    private char[] a;
    private c b;
    private Node c;
    private String d;
    private g e;

    public d(char[] cArr, c cVar, Node node, String str) {
        this.a = cArr;
        this.b = cVar;
        this.c = node;
        this.d = str;
    }

    public static Object a(String str, Object obj, VariableResolverFactory variableResolverFactory) {
        return e(b.f(str), obj, variableResolverFactory);
    }

    public static Object b(String str, Map map) {
        return e(b.f(str), null, new MapVariableResolverFactory(map));
    }

    public static Object e(CompiledTemplate compiledTemplate, Object obj, VariableResolverFactory variableResolverFactory) {
        return g(compiledTemplate.getRoot(), compiledTemplate.getTemplate(), new StringBuilder(), obj, variableResolverFactory, null);
    }

    public static Object f(CompiledTemplate compiledTemplate, Object obj, VariableResolverFactory variableResolverFactory, c cVar) {
        return g(compiledTemplate.getRoot(), compiledTemplate.getTemplate(), new StringBuilder(), obj, variableResolverFactory, cVar);
    }

    public static Object g(Node node, char[] cArr, StringBuilder sb, Object obj, VariableResolverFactory variableResolverFactory, c cVar) {
        return new d(cArr, cVar, node, ".").d(sb, obj, variableResolverFactory);
    }

    public Object c(g00.c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        return this.c.eval(this, cVar, obj, variableResolverFactory);
    }

    public Object d(StringBuilder sb, Object obj, VariableResolverFactory variableResolverFactory) {
        return c(new h00.a(sb), obj, variableResolverFactory);
    }

    public c h() {
        return this.b;
    }

    public g i() {
        if (this.e == null) {
            g gVar = new g();
            this.e = gVar;
            gVar.q(this.d);
        }
        return this.e;
    }

    public char[] j() {
        return this.a;
    }

    public void k(c cVar) {
        this.b = cVar;
    }
}
