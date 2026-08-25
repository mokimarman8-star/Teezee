package org.mvel2;

import java.io.Serializable;
import java.util.Map;
import org.mvel2.compiler.CompiledAccExpression;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.CachingMapVariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class d {
    static boolean a = Boolean.getBoolean("mvel2.debug.fileoutput");
    static String b;
    static boolean c;
    static boolean d;
    static boolean e;
    public static boolean f;
    public static boolean g;
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public static boolean k;
    static boolean l;

    static {
        b = System.getProperty("mvel2.debugging.file") == null ? "mvel_debug.txt" : System.getProperty("mvel2.debugging.file");
        c = Boolean.getBoolean("mvel2.advanced_debugging");
        d = Boolean.getBoolean("mvel2.weak_caching");
        e = Boolean.getBoolean("mvel2.disable.jit");
        f = Boolean.getBoolean("mvel2.invoked_meth_exceptions_bubble");
        g = Boolean.getBoolean("mvel2.compiler.allow_naked_meth_calls");
        h = Boolean.getBoolean("mvel2.compiler.allow_override_all_prophandling");
        i = Boolean.getBoolean("mvel2.compiler.allow_resolve_inner_classes_with_dotnotation");
        j = Boolean.getBoolean("mvel2.compiler.support_java_style_class_literals");
        k = Boolean.getBoolean("mvel2.compiler.allocate_type_literals_to_shared_symbol_table");
        l = true;
        if (System.getProperty("mvel2.optimizer") != null) {
            l = Boolean.getBoolean("mvel2.optimizer");
        }
    }

    public static void a(String str, ParserContext parserContext) {
        b(str.toCharArray(), parserContext);
    }

    public static void b(char[] cArr, ParserContext parserContext) {
        ExpressionCompiler expressionCompiler = new ExpressionCompiler(cArr, parserContext);
        expressionCompiler.setVerifyOnly(true);
        expressionCompiler.compile();
    }

    public static Class c(char[] cArr, ParserContext parserContext) {
        ExpressionCompiler expressionCompiler = new ExpressionCompiler(cArr, parserContext);
        expressionCompiler.setVerifyOnly(true);
        expressionCompiler.compile();
        return expressionCompiler.getReturnType();
    }

    public static Serializable d(String str, ParserContext parserContext) {
        return m.v0(new ExpressionCompiler(str, parserContext).compile());
    }

    public static Serializable e(char[] cArr, int i2, int i3, ParserContext parserContext) {
        return m.v0(new ExpressionCompiler(cArr, i2, i3, parserContext)._compile());
    }

    public static Serializable f(char[] cArr, ParserContext parserContext) {
        return m.v0(new ExpressionCompiler(cArr, parserContext).compile());
    }

    public static Serializable g(String str, Class cls, ParserContext parserContext) {
        return new CompiledAccExpression(str.toCharArray(), cls, parserContext);
    }

    public static Serializable h(char[] cArr) {
        return new CompiledAccExpression(cArr, Object.class, new ParserContext());
    }

    public static Serializable i(char[] cArr, int i2, int i3, ParserContext parserContext) {
        return new CompiledAccExpression(cArr, i2, i3, Object.class, parserContext);
    }

    public static Serializable j(char[] cArr, Class cls, ParserContext parserContext) {
        return new CompiledAccExpression(cArr, cls, parserContext);
    }

    public static Serializable k(char[] cArr, ParserContext parserContext) {
        return new CompiledAccExpression(cArr, Object.class, parserContext);
    }

    public static Object l(String str, Object obj, VariableResolverFactory variableResolverFactory) {
        return new MVELInterpretedRuntime(str, obj, variableResolverFactory).parse();
    }

    public static Object m(String str, Object obj, VariableResolverFactory variableResolverFactory, Class cls) {
        return b.b(new MVELInterpretedRuntime(str, obj, variableResolverFactory).parse(), cls);
    }

    public static Object n(String str, Map map) {
        CachingMapVariableResolverFactory cachingMapVariableResolverFactory = new CachingMapVariableResolverFactory(map);
        try {
            return new MVELInterpretedRuntime(str, (Object) null, cachingMapVariableResolverFactory).parse();
        } finally {
            cachingMapVariableResolverFactory.externalize();
        }
    }

    public static Object o(char[] cArr, int i2, int i3, Object obj, VariableResolverFactory variableResolverFactory) {
        return new MVELInterpretedRuntime(cArr, i2, i3, obj, variableResolverFactory).parse();
    }

    public static Object p(char[] cArr, int i2, int i3, Object obj, VariableResolverFactory variableResolverFactory, Class cls) {
        return b.b(new MVELInterpretedRuntime(cArr, i2, i3, obj, variableResolverFactory).parse(), cls);
    }

    public static Object q(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory) {
        return new MVELInterpretedRuntime(cArr, obj, variableResolverFactory).parse();
    }

    public static Object r(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return ((ExecutableStatement) obj).getValue(obj2, variableResolverFactory);
    }

    public static Object s(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Class cls) {
        return b.b(r(obj, obj2, variableResolverFactory), cls);
    }

    public static void t(Serializable serializable, Object obj, VariableResolverFactory variableResolverFactory, Object obj2) {
        ((CompiledAccExpression) serializable).setValue(obj, obj, variableResolverFactory, obj2);
    }

    public static String u() {
        return b;
    }

    public static Object v(String str, Object obj) {
        return g.k(str, obj);
    }

    public static boolean w() {
        return c;
    }

    public static boolean x() {
        return a;
    }

    public static void y(Object obj, String str, Object obj2) {
        g.z(obj, str, obj2);
    }
}
