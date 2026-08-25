package org.mvel2.optimizers.impl.asm;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.OptimizationFailure;
import org.mvel2.ParserContext;
import org.mvel2.PropertyAccessException;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.ast.WithNode;
import org.mvel2.b;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.ExecutableLiteral;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.compiler.PropertyVerifier;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.AbstractOptimizer;
import org.mvel2.optimizers.OptimizationNotSupported;
import org.mvel2.util.i;
import org.mvel2.util.k;
import org.mvel2.util.m;
import org.mvel2.util.n;
import org.mvel2.util.p;
import org.mvel2.util.s;
import vz.g;
import vz.q;
import vz.r;
import vz.y;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class ASMAccessorOptimizer extends AbstractOptimizer implements org.mvel2.optimizers.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ARRAY = 0;
    private static final Object[] EMPTYARG;
    private static final Class[] EMPTYCLS;
    private static final int LIST = 1;
    private static String LIST_IMPL = null;
    private static final int MAP = 2;
    private static final String MAP_IMPL = "java/util/HashMap";
    private static String NAMESPACE = null;
    private static final int OPCODES_VERSION;
    private static final int VAL = 3;
    private static k classLoader;
    private s buildLog;
    private String className;
    private int compileDepth;
    private ArrayList<ExecutableStatement> compiledInputs;
    private Object ctx;
    private g cw;
    private boolean deferFinish;
    private boolean first;
    private Class ingressType;
    private boolean literal;
    private int maxlocals;
    private boolean methNull;
    private r mv;
    private boolean noinit;
    private boolean propNull;
    private Class returnType;
    private int stacksize;
    private Object thisRef;
    private long time;
    private Object val;
    private VariableResolverFactory variableFactory;

    private static class a extends ClassLoader {
        a(ClassLoader classLoader) {
            super(classLoader);
        }

        Class a(String str, byte[] bArr) {
            return defineClass(str, bArr, 0, bArr.length);
        }
    }

    static {
        String f = n.f();
        if (f.startsWith("1.4")) {
            OPCODES_VERSION = 48;
        } else if (f.startsWith("1.5")) {
            OPCODES_VERSION = 49;
        } else if (f.startsWith("1.6") || f.startsWith("1.7") || f.startsWith("1.8") || f.startsWith("9") || f.startsWith("10") || f.startsWith("11") || f.startsWith("12")) {
            OPCODES_VERSION = 50;
        } else {
            OPCODES_VERSION = 46;
        }
        String property = System.getProperty("mvel2.namespace");
        if (property == null) {
            NAMESPACE = "org/mvel2/";
        } else {
            NAMESPACE = property;
        }
        String property2 = System.getProperty("mvel2.jit.list_impl");
        if (property2 == null) {
            LIST_IMPL = NAMESPACE + "util/FastList";
        } else {
            LIST_IMPL = property2;
        }
        EMPTYARG = new Object[0];
        EMPTYCLS = new Class[0];
    }

    public ASMAccessorOptimizer() {
        this.first = true;
        this.noinit = $assertionsDisabled;
        this.deferFinish = $assertionsDisabled;
        this.literal = $assertionsDisabled;
        this.propNull = $assertionsDisabled;
        this.methNull = $assertionsDisabled;
        this.stacksize = 1;
        this.maxlocals = 1;
        this.compileDepth = 0;
        new g(1);
    }

    private ASMAccessorOptimizer(g gVar, r rVar, ArrayList<ExecutableStatement> arrayList, String str, s sVar, int i) {
        this.first = true;
        this.literal = $assertionsDisabled;
        this.propNull = $assertionsDisabled;
        this.methNull = $assertionsDisabled;
        this.stacksize = 1;
        this.maxlocals = 1;
        this.cw = gVar;
        this.mv = rVar;
        this.compiledInputs = arrayList;
        this.className = str;
        this.buildLog = sVar;
        this.compileDepth = i + 1;
        this.noinit = true;
        this.deferFinish = true;
    }

    private void _finishJIT() {
        if (this.deferFinish) {
            return;
        }
        Class cls = this.returnType;
        if (cls != null && cls.isPrimitive()) {
            wrapPrimitive(this.returnType);
        }
        if (this.returnType == Void.TYPE) {
            this.mv.j(1);
        }
        this.mv.j(176);
        dumpAdvancedDebugging();
        this.mv.u(this.stacksize, this.maxlocals);
        this.mv.f();
        r g = this.cw.g(1, "getKnownEgressType", "()Ljava/lang/Class;", null, null);
        this.mv = g;
        g.e();
        visitConstantClass(this.returnType);
        this.mv.j(176);
        this.mv.u(1, 1);
        this.mv.f();
        if (this.propNull) {
            this.cw.e(1, "nullPropertyHandler", "L" + NAMESPACE + "integration/PropertyHandler;", null, null).c();
        }
        if (this.methNull) {
            this.cw.e(1, "nullMethodHandler", "L" + NAMESPACE + "integration/PropertyHandler;", null, null).c();
        }
        buildInputs();
        s sVar = this.buildLog;
        if (sVar != null && sVar.length() != 0 && this.expr != null) {
            r g2 = this.cw.g(1, "toString", "()Ljava/lang/String;", null, null);
            this.mv = g2;
            g2.e();
            this.mv.o(new q());
            this.mv.p(this.buildLog.toString() + "\n\n## { " + new String(this.expr) + " }");
            this.mv.j(176);
            this.mv.o(new q());
            this.mv.u(1, 1);
            this.mv.f();
        }
        this.cw.d();
    }

    private int _getAccessor(Object obj, Class cls) {
        int i;
        if (obj instanceof List) {
            this.mv.E(187, LIST_IMPL);
            this.mv.j(89);
            this.mv.j(89);
            List list = (List) obj;
            intPush(list.size());
            this.mv.v(183, LIST_IMPL, "<init>", "(I)V");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (_getAccessor(it.next(), cls) != 3) {
                    this.mv.j(87);
                }
                this.mv.v(185, "java/util/List", "add", "(Ljava/lang/Object;)Z");
                this.mv.j(87);
                this.mv.j(89);
            }
            this.returnType = List.class;
            return 1;
        }
        if (obj instanceof Map) {
            this.mv.E(187, MAP_IMPL);
            this.mv.j(89);
            this.mv.j(89);
            Map map = (Map) obj;
            intPush(map.size());
            this.mv.v(183, MAP_IMPL, "<init>", "(I)V");
            for (Object obj2 : map.keySet()) {
                this.mv.E(192, "java/util/Map");
                if (_getAccessor(obj2, cls) != 3) {
                    this.mv.j(87);
                }
                if (_getAccessor(map.get(obj2), cls) != 3) {
                    this.mv.j(87);
                }
                this.mv.v(185, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                this.mv.j(87);
                this.mv.j(89);
            }
            this.returnType = Map.class;
            return 2;
        }
        if (!(obj instanceof Object[])) {
            if (cls.isArray()) {
                writeLiteralOrSubexpression(m.J0(((String) obj).toCharArray(), this.pCtx), m.T(cls));
            } else {
                writeLiteralOrSubexpression(m.J0(((String) obj).toCharArray(), this.pCtx));
            }
            return 3;
        }
        org.mvel2.compiler.a[] aVarArr = new org.mvel2.compiler.a[((Object[]) obj).length];
        if (cls != null) {
            i = 0;
            while (cls.getName().charAt(i) == '[') {
                i++;
            }
        } else {
            cls = Object[].class;
            i = 1;
        }
        try {
            Class T = m.T(cls);
            createArray(T, ((Object[]) obj).length);
            Class D = i > 1 ? m.D(null, m.A0('[', i - 1) + "L" + m.I(cls).getName() + ";", this.pCtx) : p.h(cls);
            this.mv.j(89);
            int i2 = 0;
            for (Object obj3 : (Object[]) obj) {
                intPush(i2);
                if (_getAccessor(obj3, D) != 3) {
                    this.mv.j(87);
                }
                if (T.isPrimitive()) {
                    unwrapPrimitive(T);
                }
                arrayStore(T);
                this.mv.j(89);
                i2++;
            }
            return 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("this error should never throw:" + m.I(cls).getName(), e);
        }
    }

    private void _initJIT() {
        if (d.w()) {
            this.buildLog = new s();
        }
        this.cw = new g(3);
        synchronized (Runtime.getRuntime()) {
            g gVar = this.cw;
            int i = OPCODES_VERSION;
            String str = "ASMAccessorImpl_" + String.valueOf(this.cw.hashCode()).replaceAll("\\-", "_") + (System.currentTimeMillis() / 10) + ((int) (Math.random() * 100.0d));
            this.className = str;
            gVar.a(i, 33, str, null, "java/lang/Object", new String[]{NAMESPACE + "compiler/Accessor"});
        }
        r g = this.cw.g(1, "<init>", "()V", null, null);
        g.e();
        g.F(25, 0);
        g.v(183, "java/lang/Object", "<init>", "()V");
        g.j(177);
        g.u(1, 1);
        g.f();
        r g2 = this.cw.g(1, "getValue", "(Ljava/lang/Object;Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;)Ljava/lang/Object;", null, null);
        this.mv = g2;
        g2.e();
    }

    private void _initJIT2() {
        if (d.w()) {
            this.buildLog = new s();
        }
        this.cw = new g(3);
        synchronized (Runtime.getRuntime()) {
            g gVar = this.cw;
            int i = OPCODES_VERSION;
            String str = "ASMAccessorImpl_" + String.valueOf(this.cw.hashCode()).replaceAll("\\-", "_") + (System.currentTimeMillis() / 10) + ((int) (Math.random() * 100.0d));
            this.className = str;
            gVar.a(i, 33, str, null, "java/lang/Object", new String[]{NAMESPACE + "compiler/Accessor"});
        }
        r g = this.cw.g(1, "<init>", "()V", null, null);
        g.e();
        g.F(25, 0);
        g.v(183, "java/lang/Object", "<init>", "()V");
        g.j(177);
        g.u(1, 1);
        g.f();
        r g2 = this.cw.g(1, "setValue", "(Ljava/lang/Object;Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        this.mv = g2;
        g2.e();
    }

    private org.mvel2.compiler.a _initializeAccessor() throws Exception {
        Object newInstance;
        if (this.deferFinish) {
            return null;
        }
        Class loadClass = loadClass(this.className, this.cw.r());
        try {
            if (this.compiledInputs.size() == 0) {
                newInstance = loadClass.newInstance();
            } else {
                Class<?>[] clsArr = new Class[this.compiledInputs.size()];
                for (int i = 0; i < this.compiledInputs.size(); i++) {
                    clsArr[i] = ExecutableStatement.class;
                }
                Constructor constructor = loadClass.getConstructor(clsArr);
                ArrayList<ExecutableStatement> arrayList = this.compiledInputs;
                newInstance = constructor.newInstance(arrayList.toArray(new ExecutableStatement[arrayList.size()]));
            }
            if (this.propNull) {
                Field field = loadClass.getField("nullPropertyHandler");
                yz.d.b();
                field.set(newInstance, null);
            }
            if (this.methNull) {
                Field field2 = loadClass.getField("nullMethodHandler");
                yz.d.a();
                field2.set(newInstance, null);
            }
            return (org.mvel2.compiler.a) newInstance;
        } catch (VerifyError e) {
            PrintStream printStream = System.out;
            printStream.println("**** COMPILER BUG! REPORT THIS IMMEDIATELY AT http://jira.codehaus.org/browse/MVEL");
            StringBuilder sb = new StringBuilder();
            sb.append("Expression: ");
            char[] cArr = this.expr;
            sb.append(cArr != null ? new String(cArr) : null);
            printStream.println(sb.toString());
            throw e;
        }
    }

    private void addPrintOut(String str) {
        this.mv.g(178, "java/lang/System", "out", "Ljava/io/PrintStream;");
        this.mv.p(str);
        this.mv.v(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
    }

    private Object addSubstatement(ExecutableStatement executableStatement) {
        this.compiledInputs.add(executableStatement);
        this.mv.F(25, 0);
        r rVar = this.mv;
        String str = this.className;
        StringBuilder sb = new StringBuilder();
        sb.append("p");
        sb.append(this.compiledInputs.size() - 1);
        rVar.g(180, str, sb.toString(), "L" + NAMESPACE + "compiler/ExecutableStatement;");
        this.mv.F(25, 2);
        this.mv.F(25, 3);
        this.mv.v(185, y.h(ExecutableStatement.class), "getValue", "(Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;)Ljava/lang/Object;");
        return null;
    }

    private void anyArrayCheck(Class cls) {
        if (cls == boolean[].class) {
            this.mv.E(192, "[Z");
            return;
        }
        if (cls == int[].class) {
            this.mv.E(192, "[I");
            return;
        }
        if (cls == float[].class) {
            this.mv.E(192, "[F");
            return;
        }
        if (cls == double[].class) {
            this.mv.E(192, "[D");
            return;
        }
        if (cls == short[].class) {
            this.mv.E(192, "[S");
            return;
        }
        if (cls == long[].class) {
            this.mv.E(192, "[J");
            return;
        }
        if (cls == byte[].class) {
            this.mv.E(192, "[B");
        } else if (cls == char[].class) {
            this.mv.E(192, "[C");
        } else {
            this.mv.E(192, "[Ljava/lang/Object;");
        }
    }

    private void buildInputs() {
        if (this.compiledInputs.size() == 0) {
            return;
        }
        s sVar = new s("(");
        int size = this.compiledInputs.size();
        for (int i = 0; i < size; i++) {
            this.cw.e(2, "p" + i, "L" + NAMESPACE + "compiler/ExecutableStatement;", null, null).c();
            sVar.d("L" + NAMESPACE + "compiler/ExecutableStatement;");
        }
        sVar.d(")V");
        r g = this.cw.g(1, "<init>", sVar.toString(), null, null);
        g.e();
        g.F(25, 0);
        g.v(183, "java/lang/Object", "<init>", "()V");
        int i2 = 0;
        while (i2 < size) {
            g.F(25, 0);
            int i3 = i2 + 1;
            g.F(25, i3);
            g.g(181, this.className, "p" + i2, "L" + NAMESPACE + "compiler/ExecutableStatement;");
            i2 = i3;
        }
        g.j(177);
        g.u(0, 0);
        g.f();
    }

    private void checkcast(Class cls) {
        this.mv.E(192, y.h(cls));
    }

    private org.mvel2.compiler.a compileAccessor() {
        Object obj = this.ctx;
        try {
            if (d.h) {
                while (true) {
                    if (this.cursor >= this.end) {
                        break;
                    }
                    int nextSubToken = nextSubToken();
                    if (nextSubToken == 0) {
                        obj = getBeanPropertyAO(obj, capture());
                    } else if (nextSubToken == 1) {
                        obj = getMethod(obj, capture());
                    } else if (nextSubToken == 2) {
                        obj = getCollectionPropertyAO(obj, capture());
                    } else if (nextSubToken == 3) {
                        obj = getWithProperty(obj);
                    }
                    if (this.fields == -1) {
                        if (obj != null) {
                            this.fields = 0;
                        } else if (this.nullSafe) {
                            throw new OptimizationNotSupported();
                        }
                    }
                    this.first = $assertionsDisabled;
                    if (this.nullSafe && this.cursor < this.end) {
                        this.mv.j(89);
                        q qVar = new q();
                        this.mv.n(199, qVar);
                        this.mv.j(176);
                        this.mv.o(qVar);
                    }
                }
            } else {
                while (true) {
                    if (this.cursor >= this.end) {
                        break;
                    }
                    int nextSubToken2 = nextSubToken();
                    if (nextSubToken2 == 0) {
                        obj = getBeanProperty(obj, capture());
                    } else if (nextSubToken2 == 1) {
                        obj = getMethod(obj, capture());
                    } else if (nextSubToken2 == 2) {
                        obj = getCollectionProperty(obj, capture());
                    } else if (nextSubToken2 == 3) {
                        obj = getWithProperty(obj);
                    }
                    if (this.fields == -1) {
                        if (obj != null) {
                            this.fields = 0;
                        } else if (this.nullSafe) {
                            throw new OptimizationNotSupported();
                        }
                    }
                    this.first = $assertionsDisabled;
                    if (this.nullSafe && this.cursor < this.end) {
                        this.mv.j(89);
                        q qVar2 = new q();
                        this.mv.n(199, qVar2);
                        this.mv.j(176);
                        this.mv.o(qVar2);
                    }
                }
            }
            this.val = obj;
            _finishJIT();
            return _initializeAccessor();
        } catch (IllegalAccessException e) {
            throw new PropertyAccessException(new String(this.expr), this.expr, this.st, e, this.pCtx);
        } catch (IndexOutOfBoundsException e3) {
            throw new PropertyAccessException(new String(this.expr), this.expr, this.st, e3, this.pCtx);
        } catch (NullPointerException e4) {
            throw new PropertyAccessException(new String(this.expr), this.expr, this.st, e4, this.pCtx);
        } catch (InvocationTargetException e5) {
            throw new PropertyAccessException(new String(this.expr), this.expr, this.st, e5, this.pCtx);
        } catch (PropertyAccessException e6) {
            throw new CompileException(e6.getMessage(), this.expr, this.st, e6);
        } catch (CompileException e7) {
            throw e7;
        } catch (OptimizationNotSupported e8) {
            throw e8;
        } catch (Exception e9) {
            throw new CompileException(e9.getMessage(), this.expr, this.st, e9);
        }
    }

    private void createArray(Class cls, int i) {
        intPush(i);
        if (cls.isPrimitive()) {
            this.mv.l(188, toPrimitiveTypeOperand(cls));
        } else {
            this.mv.E(189, y.h(cls));
        }
    }

    private void dataConversion(Class cls) {
        if (cls.equals(Object.class)) {
            return;
        }
        ldcClassConstant(cls);
        this.mv.v(184, NAMESPACE + "DataConversion", "convert", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
    }

    private boolean debug(String str) {
        s sVar = this.buildLog;
        if (sVar == null) {
            return true;
        }
        sVar.d(str).d("\n");
        return true;
    }

    private void dumpAdvancedDebugging() {
        if (this.buildLog == null) {
            return;
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("JIT Compiler Dump for: <<");
        char[] cArr = this.expr;
        sb.append(cArr == null ? null : new String(cArr));
        sb.append(">>\n-------------------------------\n");
        printStream.println(sb.toString());
        printStream.println(this.buildLog.toString());
        printStream.println("\n<END OF DUMP>\n");
        if (d.x()) {
            try {
                FileWriter Q = m.Q();
                Q.write(this.buildLog.toString());
                Q.flush();
                Q.close();
            } catch (IOException unused) {
            }
        }
    }

    private Object getBeanProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        boolean z;
        Class<?> cls;
        Object invoke;
        ParserContext parserContext = this.pCtx;
        if ((parserContext == null ? this.currType : parserContext.getVarOrInputTypeOrNull(str)) == Object.class && !this.pCtx.isStrongTyping()) {
            this.currType = null;
        }
        Class cls2 = this.returnType;
        if (cls2 != null && cls2.isPrimitive()) {
            wrapPrimitive(this.returnType);
        }
        boolean z2 = obj instanceof Class;
        if (z2) {
            if (d.j && "class".equals(str)) {
                ldcClassConstant((Class) obj);
                return obj;
            }
            cls = (Class) obj;
            z = true;
        } else if (obj != null) {
            cls = obj.getClass();
            z = false;
        } else {
            z = false;
            cls = null;
        }
        if (yz.d.f(cls)) {
            yz.d.c(cls);
            new StringBuilder().append("unable to compileShared: custom accessor does not support producing bytecode: ");
            throw null;
        }
        Member b = cls != null ? n.b(cls, str) : null;
        if (b != null && z && (b.getModifiers() & 8) == 0) {
            b = null;
        }
        if (b != null && yz.a.a()) {
            this.mv.F(25, 1);
            this.mv.p(b.getName());
            this.mv.F(25, 3);
            this.mv.v(184, NAMESPACE + "integration/GlobalListenerFactory", "notifyGetListeners", "(Ljava/lang/Object;Ljava/lang/String;L" + NAMESPACE + "integration/VariableResolverFactory;)V");
            yz.a.c(obj, b.getName(), this.variableFactory);
        }
        if (this.first) {
            if ("this".equals(str)) {
                this.mv.F(25, 2);
                return this.thisRef;
            }
            VariableResolverFactory variableResolverFactory = this.variableFactory;
            if (variableResolverFactory != null && variableResolverFactory.isResolveable(str)) {
                if (this.variableFactory.isIndexedFactory() && this.variableFactory.isTarget(str)) {
                    try {
                        int variableIndexOf = this.variableFactory.variableIndexOf(str);
                        loadVariableByIndex(variableIndexOf);
                        return this.variableFactory.getIndexedVariableResolver(variableIndexOf).getValue();
                    } catch (Exception unused) {
                        throw new OptimizationFailure(str);
                    }
                }
                try {
                    loadVariableByName(str);
                    return this.variableFactory.getVariableResolver(str).getValue();
                } catch (Exception e) {
                    throw new OptimizationFailure("critical error in JIT", e);
                }
            }
            this.mv.F(25, 1);
        }
        if (b instanceof Field) {
            return optimizeFieldMethodProperty(obj, str, cls, b);
        }
        if (b != null) {
            if (this.first) {
                this.mv.F(25, 1);
            }
            try {
                invoke = ((Method) b).invoke(obj, EMPTYARG);
                if (this.returnType != b.getDeclaringClass()) {
                    this.mv.E(192, y.h(b.getDeclaringClass()));
                }
                this.returnType = ((Method) b).getReturnType();
                if (b.getDeclaringClass().isInterface()) {
                    this.mv.v(185, y.h(b.getDeclaringClass()), b.getName(), y.i((Method) b));
                } else {
                    this.mv.v(182, y.h(b.getDeclaringClass()), b.getName(), y.i((Method) b));
                }
            } catch (IllegalAccessException e3) {
                Method method = (Method) b;
                Method z3 = m.z(method);
                if (z3 == null) {
                    throw new PropertyAccessException("could not access field: " + cls.getName() + "." + str, this.expr, this.st, e3, this.pCtx);
                }
                this.mv.E(192, y.h(z3.getDeclaringClass()));
                this.returnType = z3.getReturnType();
                this.mv.v(185, y.h(z3.getDeclaringClass()), b.getName(), y.i(method));
                invoke = z3.invoke(obj, EMPTYARG);
            } catch (IllegalArgumentException e4) {
                if (b.getDeclaringClass().equals(obj)) {
                    try {
                        throw new CompileException("name collision between innerclass: " + Class.forName(b.getDeclaringClass().getName() + "$" + str).getCanonicalName() + "; and bean accessor: " + str + " (" + b.toString() + ")", this.expr, this.tkStart);
                    } catch (ClassNotFoundException unused2) {
                        throw e4;
                    }
                }
                throw e4;
            }
            if (yz.d.e()) {
                if (invoke == null) {
                    yz.d.b();
                    b.getName();
                    throw null;
                }
                writeOutNullHandler(b, 0);
            }
            this.currType = p.i(this.returnType);
            return invoke;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str) || this.nullSafe) {
                this.mv.E(192, "java/util/Map");
                this.mv.p(str);
                this.mv.v(185, "java/util/Map", "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
                return map.get(str);
            }
        }
        if (this.first && "this".equals(str)) {
            this.mv.F(25, 2);
            return this.thisRef;
        }
        if ("length".equals(str) && obj.getClass().isArray()) {
            anyArrayCheck(obj.getClass());
            this.mv.j(190);
            wrapPrimitive(Integer.TYPE);
            return Integer.valueOf(Array.getLength(obj));
        }
        if (AbstractParser.LITERALS.containsKey(str)) {
            Object obj2 = AbstractParser.LITERALS.get(str);
            if (obj2 instanceof Class) {
                ldcClassConstant((Class) obj2);
            }
            return obj2;
        }
        Object tryStaticAccess = tryStaticAccess();
        if (tryStaticAccess != null) {
            if (tryStaticAccess instanceof Class) {
                ldcClassConstant((Class) tryStaticAccess);
                return tryStaticAccess;
            }
            if (!(tryStaticAccess instanceof Method)) {
                return optimizeFieldMethodProperty(obj, str, cls, (Field) tryStaticAccess);
            }
            Method method2 = (Method) tryStaticAccess;
            writeFunctionPointerStub(method2.getDeclaringClass(), method2);
            return tryStaticAccess;
        }
        if (z2) {
            Class cls3 = (Class) obj;
            for (Method method3 : cls3.getMethods()) {
                if (str.equals(method3.getName())) {
                    ParserContext parserContext2 = this.pCtx;
                    if (parserContext2 == null || parserContext2.getParserConfiguration() == null ? !d.g : !this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                        writeFunctionPointerStub(cls3, method3);
                        return method3;
                    }
                    this.mv.j(87);
                    this.mv.v(184, y.h(method3.getDeclaringClass()), method3.getName(), y.i(method3));
                    this.returnType = method3.getReturnType();
                    return method3.invoke(null, m.a);
                }
            }
            try {
                Class D = m.D(this.variableFactory, cls3.getName() + "$" + str, this.pCtx);
                ldcClassConstant(D);
                return D;
            } catch (ClassNotFoundException unused3) {
            }
        } else {
            ParserContext parserContext3 = this.pCtx;
            if (parserContext3 == null || parserContext3.getParserConfiguration() == null ? d.g : this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                return getMethod(obj, str);
            }
        }
        if (obj == null) {
            throw new PropertyAccessException("unresolvable property or identifier: " + str, this.expr, this.st, this.pCtx);
        }
        throw new PropertyAccessException("could not access: " + str + "; in class: " + obj.getClass().getName(), this.expr, this.st, this.pCtx);
    }

    private Object getBeanPropertyAO(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        return (obj == null || !yz.d.f(obj.getClass())) ? getBeanProperty(obj, str) : propHandlerByteCode(str, obj, obj.getClass());
    }

    private Object getCollectionProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        if (str.trim().length() > 0) {
            obj = getBeanProperty(obj, str);
            this.first = $assertionsDisabled;
        }
        this.currType = null;
        int i = this.cursor + 1;
        this.cursor = i;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.st);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.st);
        }
        String str2 = new String(this.expr, i, this.cursor - i);
        if (obj == null) {
            return null;
        }
        if (this.first) {
            this.mv.F(25, 1);
        }
        ExecutableStatement executableStatement = (ExecutableStatement) m.J0(str2.toCharArray(), this.pCtx);
        Object value = executableStatement.getValue(this.ctx, this.variableFactory);
        this.cursor++;
        if (obj instanceof Map) {
            this.mv.E(192, "java/util/Map");
            Class writeLiteralOrSubexpression = writeLiteralOrSubexpression(executableStatement);
            if (writeLiteralOrSubexpression != null && writeLiteralOrSubexpression.isPrimitive()) {
                wrapPrimitive(writeLiteralOrSubexpression);
            }
            this.mv.v(185, "java/util/Map", "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
            return ((Map) obj).get(value);
        }
        if (obj instanceof List) {
            this.mv.E(192, "java/util/List");
            writeLiteralOrSubexpression(executableStatement, Integer.TYPE);
            this.mv.v(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            return ((List) obj).get(((Integer) b.b(value, Integer.class)).intValue());
        }
        if (!obj.getClass().isArray()) {
            if (!(obj instanceof CharSequence)) {
                TypeDescriptor typeDescriptor = new TypeDescriptor(this.expr, this.start, this.length, 0);
                if (typeDescriptor.isArray()) {
                    try {
                        Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
                        ldcClassConstant(classReference);
                        return classReference;
                    } catch (Exception unused) {
                    }
                }
                throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.st);
            }
            this.mv.E(192, "java/lang/CharSequence");
            if (value instanceof Integer) {
                Integer num = (Integer) value;
                intPush(num.intValue());
                this.mv.v(185, "java/lang/CharSequence", "charAt", "(I)C");
                wrapPrimitive(Character.TYPE);
                return Character.valueOf(((CharSequence) obj).charAt(num.intValue()));
            }
            writeLiteralOrSubexpression(executableStatement, Integer.class);
            unwrapPrimitive(Integer.TYPE);
            this.mv.v(185, "java/lang/CharSequence", "charAt", "(I)C");
            wrapPrimitive(Character.TYPE);
            return Character.valueOf(((CharSequence) obj).charAt(((Integer) b.b(value, Integer.class)).intValue()));
        }
        this.mv.E(192, y.f(obj.getClass()));
        Class cls = Integer.TYPE;
        writeLiteralOrSubexpression(executableStatement, cls, value.getClass());
        Class I = m.I(obj.getClass());
        if (I.isPrimitive()) {
            if (I == cls) {
                this.mv.j(46);
            } else if (I == Character.TYPE) {
                this.mv.j(52);
            } else if (I == Boolean.TYPE) {
                this.mv.j(51);
            } else if (I == Double.TYPE) {
                this.mv.j(49);
            } else if (I == Float.TYPE) {
                this.mv.j(48);
            } else if (I == Short.TYPE) {
                this.mv.j(53);
            } else if (I == Long.TYPE) {
                this.mv.j(47);
            } else if (I == Byte.TYPE) {
                this.mv.j(51);
            }
            wrapPrimitive(I);
        } else {
            this.mv.j(50);
        }
        return Array.get(obj, ((Integer) b.b(value, Integer.class)).intValue());
    }

    private Object getCollectionPropertyAO(Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        if (str.length() > 0) {
            obj = getBeanProperty(obj, str);
            this.first = $assertionsDisabled;
        }
        this.currType = null;
        int i = this.cursor + 1;
        this.cursor = i;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.st);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.st);
        }
        String str2 = new String(this.expr, i, this.cursor - i);
        if (obj == null) {
            return null;
        }
        ExecutableStatement executableStatement = (ExecutableStatement) m.H0(str2.toCharArray());
        Object value = executableStatement.getValue(this.ctx, this.variableFactory);
        this.cursor++;
        if (obj instanceof Map) {
            if (yz.d.f(Map.class)) {
                return propHandlerByteCode(str2, obj, Map.class);
            }
            if (this.first) {
                this.mv.F(25, 1);
            }
            this.mv.E(192, "java/util/Map");
            Class writeLiteralOrSubexpression = writeLiteralOrSubexpression(executableStatement);
            if (writeLiteralOrSubexpression != null && writeLiteralOrSubexpression.isPrimitive()) {
                wrapPrimitive(writeLiteralOrSubexpression);
            }
            this.mv.v(185, "java/util/Map", "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
            return ((Map) obj).get(value);
        }
        if (obj instanceof List) {
            if (yz.d.f(List.class)) {
                return propHandlerByteCode(str2, obj, List.class);
            }
            if (this.first) {
                this.mv.F(25, 1);
            }
            this.mv.E(192, "java/util/List");
            writeLiteralOrSubexpression(executableStatement, Integer.TYPE);
            this.mv.v(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            return ((List) obj).get(((Integer) b.b(value, Integer.class)).intValue());
        }
        if (obj.getClass().isArray()) {
            if (yz.d.f(Array.class)) {
                return propHandlerByteCode(str2, obj, Array.class);
            }
            if (this.first) {
                this.mv.F(25, 1);
            }
            this.mv.E(192, y.f(obj.getClass()));
            Class cls = Integer.TYPE;
            writeLiteralOrSubexpression(executableStatement, cls, value.getClass());
            Class I = m.I(obj.getClass());
            if (I.isPrimitive()) {
                if (I == cls) {
                    this.mv.j(46);
                } else if (I == Character.TYPE) {
                    this.mv.j(52);
                } else if (I == Boolean.TYPE) {
                    this.mv.j(51);
                } else if (I == Double.TYPE) {
                    this.mv.j(49);
                } else if (I == Float.TYPE) {
                    this.mv.j(48);
                } else if (I == Short.TYPE) {
                    this.mv.j(53);
                } else if (I == Long.TYPE) {
                    this.mv.j(47);
                } else if (I == Byte.TYPE) {
                    this.mv.j(51);
                }
                wrapPrimitive(I);
            } else {
                this.mv.j(50);
            }
            return Array.get(obj, ((Integer) b.b(value, Integer.class)).intValue());
        }
        if (!(obj instanceof CharSequence)) {
            char[] cArr = this.expr;
            int i2 = this.start;
            TypeDescriptor typeDescriptor = new TypeDescriptor(cArr, i2, this.end - i2, 0);
            if (typeDescriptor.isArray()) {
                try {
                    Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
                    ldcClassConstant(classReference);
                    return classReference;
                } catch (Exception unused) {
                }
            }
            throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.st);
        }
        if (yz.d.f(CharSequence.class)) {
            return propHandlerByteCode(str2, obj, CharSequence.class);
        }
        if (this.first) {
            this.mv.F(25, 1);
        }
        this.mv.E(192, "java/lang/CharSequence");
        if (value instanceof Integer) {
            Integer num = (Integer) value;
            intPush(num.intValue());
            this.mv.v(185, "java/lang/CharSequence", "charAt", "(I)C");
            wrapPrimitive(Character.TYPE);
            return Character.valueOf(((CharSequence) obj).charAt(num.intValue()));
        }
        writeLiteralOrSubexpression(executableStatement, Integer.class);
        unwrapPrimitive(Integer.TYPE);
        this.mv.v(185, "java/lang/CharSequence", "charAt", "(I)C");
        wrapPrimitive(Character.TYPE);
        return Character.valueOf(((CharSequence) obj).charAt(((Integer) b.b(value, Integer.class)).intValue()));
    }

    private a getContextClassLoader() {
        if (this.pCtx == null) {
            return null;
        }
        return new a(this.pCtx.getClassLoader());
    }

    public static k getMVELClassLoader() {
        return classLoader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x054d, code lost:
    
        if (r9 == (r2.getParameterTypes().length - 1)) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0305, code lost:
    
        if ((r11[r11.length - 1] instanceof org.mvel2.compiler.ExecutableAccessor) == false) goto L129;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0463  */
    /* JADX WARN: Type inference failed for: r10v37, types: [java.lang.Object, org.mvel2.compiler.ExecutableStatement[]] */
    /* JADX WARN: Type inference failed for: r10v45, types: [org.mvel2.compiler.ExecutableStatement[]] */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.mvel2.compiler.ExecutableStatement[]] */
    /* JADX WARN: Type inference failed for: r25v0, types: [org.mvel2.compiler.AbstractParser, org.mvel2.optimizers.AbstractOptimizer, org.mvel2.optimizers.impl.asm.ASMAccessorOptimizer] */
    /* JADX WARN: Type inference failed for: r5v13, types: [org.mvel2.compiler.ExecutableStatement] */
    /* JADX WARN: Type inference failed for: r5v16, types: [org.mvel2.compiler.ExecutableStatement] */
    /* JADX WARN: Type inference failed for: r8v11, types: [org.mvel2.compiler.ExecutableStatement] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2, types: [org.mvel2.compiler.ExecutableStatement] */
    /* JADX WARN: Type inference failed for: r8v4, types: [org.mvel2.compiler.ExecutableStatement] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object getMethod(java.lang.Object r26, java.lang.String r27) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 2054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.optimizers.impl.asm.ASMAccessorOptimizer.getMethod(java.lang.Object, java.lang.String):java.lang.Object");
    }

    private Object getWithProperty(Object obj) {
        if (this.first) {
            this.mv.F(25, 1);
            this.first = $assertionsDisabled;
        }
        String trim = new String(this.expr, 0, this.cursor - 1).trim();
        int i = this.cursor;
        int i2 = i + 1;
        this.cursor = m.e(this.expr, i, this.end, '{', this.pCtx);
        this.returnType = obj != null ? obj.getClass() : null;
        char[] cArr = this.expr;
        int i3 = this.cursor;
        this.cursor = i3 + 1;
        for (WithNode.ParmValuePair parmValuePair : WithNode.compileWithExpressions(cArr, i2, i3 - i2, trim, this.ingressType, this.pCtx)) {
            this.mv.j(89);
            this.mv.F(58, this.compileDepth + 5);
            parmValuePair.eval(obj, this.variableFactory);
            if (parmValuePair.getSetExpression() == null) {
                addSubstatement(parmValuePair.getStatement());
            } else {
                this.compiledInputs.add((ExecutableStatement) parmValuePair.getSetExpression());
                this.mv.F(25, 0);
                this.mv.g(180, this.className, "p" + (this.compiledInputs.size() - 1), "L" + NAMESPACE + "compiler/ExecutableStatement;");
                this.mv.F(25, this.compileDepth + 5);
                this.mv.F(25, 2);
                this.mv.F(25, 3);
                addSubstatement(parmValuePair.getStatement());
                this.mv.v(185, NAMESPACE + "compiler/ExecutableStatement", "setValue", "(Ljava/lang/Object;Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;Ljava/lang/Object;)Ljava/lang/Object;");
                this.mv.j(87);
            }
        }
        return obj;
    }

    private Class getWrapperClass(Class cls) {
        return cls == Boolean.TYPE ? Boolean.class : cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Double.TYPE ? Double.class : cls == Short.TYPE ? Short.class : cls == Long.TYPE ? Long.class : cls == Byte.TYPE ? Byte.class : cls == Character.TYPE ? Character.class : cls;
    }

    private void intPush(int i) {
        if (i < 0 || i >= 6) {
            if (i > -127 && i < 128) {
                this.mv.l(16, i);
                return;
            } else if (i > 32767) {
                this.mv.p(Integer.valueOf(i));
                return;
            } else {
                this.mv.l(17, i);
                return;
            }
        }
        if (i == 0) {
            this.mv.j(3);
            return;
        }
        if (i == 1) {
            this.mv.j(4);
            return;
        }
        if (i == 2) {
            this.mv.j(5);
            return;
        }
        if (i == 3) {
            this.mv.j(6);
        } else if (i == 4) {
            this.mv.j(7);
        } else {
            if (i != 5) {
                return;
            }
            this.mv.j(8);
        }
    }

    private void ldcClassConstant(Class cls) {
        if (OPCODES_VERSION != 48) {
            this.mv.p(y.m(cls));
            return;
        }
        this.mv.p(cls.getName());
        this.mv.v(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        q qVar = new q();
        this.mv.n(167, qVar);
        this.mv.E(187, "java/lang/NoClassDefFoundError");
        this.mv.j(90);
        this.mv.j(95);
        this.mv.v(182, "java/lang/Throwable", "getMessage", "()Ljava/lang/String;");
        this.mv.v(183, "java/lang/NoClassDefFoundError", "<init>", "(Ljava/lang/String;)V");
        this.mv.j(191);
        this.mv.o(qVar);
    }

    private Class loadClass(String str, byte[] bArr) throws Exception {
        a contextClassLoader = getContextClassLoader();
        return contextClassLoader == null ? classLoader.a(str, bArr, 0, bArr.length) : contextClassLoader.a(str, bArr);
    }

    private void loadField(int i) {
        this.mv.F(25, 0);
        this.mv.g(180, this.className, "p" + i, "L" + NAMESPACE + "compiler/ExecutableStatement;");
    }

    private void loadVariableByIndex(int i) {
        this.mv.F(25, 3);
        intPush(i);
        this.mv.v(185, "" + NAMESPACE + "integration/VariableResolverFactory", "getIndexedVariableResolver", "(I)L" + NAMESPACE + "integration/VariableResolver;");
        this.mv.v(185, "" + NAMESPACE + "integration/VariableResolver", "getValue", "()Ljava/lang/Object;");
        this.returnType = Object.class;
    }

    private void loadVariableByName(String str) {
        this.mv.F(25, 3);
        this.mv.p(str);
        this.mv.v(185, "" + NAMESPACE + "integration/VariableResolverFactory", "getVariableResolver", "(Ljava/lang/String;)L" + NAMESPACE + "integration/VariableResolver;");
        this.mv.v(185, "" + NAMESPACE + "integration/VariableResolver", "getValue", "()Ljava/lang/Object;");
        this.returnType = Object.class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object optimizeFieldMethodProperty(Object obj, String str, Class<?> cls, Member member) throws IllegalAccessException {
        Object obj2 = ((Field) member).get(obj);
        if ((member.getModifiers() & 8) == 0) {
            this.mv.E(192, y.h(cls));
            r rVar = this.mv;
            String h = y.h(cls);
            Class<?> type = ((Field) member).getType();
            this.returnType = type;
            rVar.g(180, h, str, y.f(type));
        } else {
            if ((member.getModifiers() & 16) != 0 && ((obj2 instanceof String) || ((Field) member).getType().isPrimitive())) {
                Object obj3 = ((Field) member).get(null);
                this.mv.p(obj3);
                wrapPrimitive(obj3.getClass());
                if (yz.d.e()) {
                    writeOutNullHandler(member, 0);
                }
                return obj3;
            }
            r rVar2 = this.mv;
            String h2 = y.h(member.getDeclaringClass());
            String name = member.getName();
            Class<?> type2 = ((Field) member).getType();
            this.returnType = type2;
            rVar2.g(178, h2, name, y.f(type2));
        }
        this.returnType = ((Field) member).getType();
        if (yz.d.e()) {
            if (obj2 == null) {
                yz.d.b();
                member.getName();
                throw null;
            }
            writeOutNullHandler(member, 0);
        }
        this.currType = p.i(this.returnType);
        return obj2;
    }

    private Object propHandlerByteCode(String str, Object obj, Class cls) {
        yz.d.c(cls);
        new StringBuilder().append("unable to compileShared: custom accessor does not support producing bytecode: ");
        throw null;
    }

    private void propHandlerByteCodePut(String str, Object obj, Class cls, Object obj2) {
        yz.d.c(cls);
        new StringBuilder().append("unable to compileShared: custom accessor does not support producing bytecode: ");
        throw null;
    }

    public static void setMVELClassLoader(k kVar) {
        classLoader = kVar;
    }

    public static int toPrimitiveTypeOperand(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return 10;
        }
        if (cls == Long.TYPE) {
            return 11;
        }
        if (cls == Double.TYPE) {
            return 7;
        }
        if (cls == Float.TYPE) {
            return 6;
        }
        if (cls == Short.TYPE) {
            return 9;
        }
        if (cls == Byte.TYPE) {
            return 8;
        }
        if (cls == Character.TYPE) {
            return 5;
        }
        if (cls == Boolean.TYPE) {
            return 4;
        }
        throw new IllegalStateException("Non-primitive type passed to toPrimitiveTypeOperand: " + cls);
    }

    private void unwrapPrimitive(Class cls) {
        if (cls == Boolean.TYPE) {
            this.mv.E(192, "java/lang/Boolean");
            this.mv.v(182, "java/lang/Boolean", "booleanValue", "()Z");
            return;
        }
        if (cls == Integer.TYPE) {
            this.mv.E(192, "java/lang/Integer");
            this.mv.v(182, "java/lang/Integer", "intValue", "()I");
            return;
        }
        if (cls == Float.TYPE) {
            this.mv.E(192, "java/lang/Float");
            this.mv.v(182, "java/lang/Float", "floatValue", "()F");
            return;
        }
        if (cls == Double.TYPE) {
            this.mv.E(192, "java/lang/Double");
            this.mv.v(182, "java/lang/Double", "doubleValue", "()D");
            return;
        }
        if (cls == Short.TYPE) {
            this.mv.E(192, "java/lang/Short");
            this.mv.v(182, "java/lang/Short", "shortValue", "()S");
            return;
        }
        if (cls == Long.TYPE) {
            this.mv.E(192, "java/lang/Long");
            this.mv.v(182, "java/lang/Long", "longValue", "()J");
        } else if (cls == Byte.TYPE) {
            this.mv.E(192, "java/lang/Byte");
            this.mv.v(182, "java/lang/Byte", "byteValue", "()B");
        } else if (cls == Character.TYPE) {
            this.mv.E(192, "java/lang/Character");
            this.mv.v(182, "java/lang/Character", "charValue", "()C");
        }
    }

    private void visitConstantClass(Class<?> cls) {
        if (cls == null) {
            cls = Object.class;
        }
        if (cls.isPrimitive()) {
            this.mv.g(178, p.i(cls).getName().replace(".", "/"), "TYPE", "Ljava/lang/Class;");
        } else {
            this.mv.p(y.m(cls));
        }
    }

    private void wrapPrimitive(Class<? extends Object> cls) {
        if (OPCODES_VERSION != 48) {
            if (cls == Boolean.TYPE || cls == Boolean.class) {
                debug("INVOKESTATIC java/lang/Boolean.valueOf");
                this.mv.v(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                return;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                debug("INVOKESTATIC java/lang/Integer.valueOf");
                this.mv.v(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                return;
            }
            if (cls == Float.TYPE || cls == Float.class) {
                debug("INVOKESTATIC java/lang/Float.valueOf");
                this.mv.v(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                return;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                debug("INVOKESTATIC java/lang/Double.valueOf");
                this.mv.v(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                return;
            }
            if (cls == Short.TYPE || cls == Short.class) {
                debug("INVOKESTATIC java/lang/Short.valueOf");
                this.mv.v(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                return;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                debug("INVOKESTATIC java/lang/Long.valueOf");
                this.mv.v(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                return;
            } else if (cls == Byte.TYPE || cls == Byte.class) {
                debug("INVOKESTATIC java/lang/Byte.valueOf");
                this.mv.v(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                return;
            } else {
                if (cls == Character.TYPE || cls == Character.class) {
                    debug("INVOKESTATIC java/lang/Character.valueOf");
                    this.mv.v(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                    return;
                }
                return;
            }
        }
        debug("** Using 1.4 Bytecode **");
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            debug("NEW java/lang/Boolean");
            this.mv.E(187, "java/lang/Boolean");
            debug("DUP X1");
            this.mv.j(90);
            debug("SWAP");
            this.mv.j(95);
            debug("INVOKESPECIAL java/lang/Boolean.<init>::(Z)V");
            this.mv.v(183, "java/lang/Boolean", "<init>", "(Z)V");
            return;
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            debug("NEW java/lang/Integer");
            this.mv.E(187, "java/lang/Integer");
            debug("DUP X1");
            this.mv.j(90);
            debug("SWAP");
            this.mv.j(95);
            debug("INVOKESPECIAL java/lang/Integer.<init>::(I)V");
            this.mv.v(183, "java/lang/Integer", "<init>", "(I)V");
            return;
        }
        if (cls == Float.TYPE || cls == Float.class) {
            debug("NEW java/lang/Float");
            this.mv.E(187, "java/lang/Float");
            debug("DUP X1");
            this.mv.j(90);
            debug("SWAP");
            this.mv.j(95);
            debug("INVOKESPECIAL java/lang/Float.<init>::(F)V");
            this.mv.v(183, "java/lang/Float", "<init>", "(F)V");
            return;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            debug("NEW java/lang/Double");
            this.mv.E(187, "java/lang/Double");
            debug("DUP X2");
            this.mv.j(91);
            debug("DUP X2");
            this.mv.j(91);
            debug("POP");
            this.mv.j(87);
            debug("INVOKESPECIAL java/lang/Double.<init>::(D)V");
            this.mv.v(183, "java/lang/Double", "<init>", "(D)V");
            return;
        }
        if (cls == Short.TYPE || cls == Short.class) {
            debug("NEW java/lang/Short");
            this.mv.E(187, "java/lang/Short");
            debug("DUP X1");
            this.mv.j(90);
            debug("SWAP");
            this.mv.j(95);
            debug("INVOKESPECIAL java/lang/Short.<init>::(S)V");
            this.mv.v(183, "java/lang/Short", "<init>", "(S)V");
            return;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            debug("NEW java/lang/Long");
            this.mv.E(187, "java/lang/Long");
            debug("DUP X1");
            this.mv.j(90);
            debug("SWAP");
            this.mv.j(95);
            debug("INVOKESPECIAL java/lang/Long.<init>::(L)V");
            this.mv.v(183, "java/lang/Float", "<init>", "(L)V");
            return;
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            debug("NEW java/lang/Byte");
            this.mv.E(187, "java/lang/Byte");
            debug("DUP X1");
            this.mv.j(90);
            debug("SWAP");
            this.mv.j(95);
            debug("INVOKESPECIAL java/lang/Byte.<init>::(B)V");
            this.mv.v(183, "java/lang/Byte", "<init>", "(B)V");
            return;
        }
        if (cls == Character.TYPE || cls == Character.class) {
            debug("NEW java/lang/Character");
            this.mv.E(187, "java/lang/Character");
            debug("DUP X1");
            this.mv.j(90);
            debug("SWAP");
            this.mv.j(95);
            debug("INVOKESPECIAL java/lang/Character.<init>::(C)V");
            this.mv.v(183, "java/lang/Character", "<init>", "(C)V");
        }
    }

    private void writeFunctionPointerStub(Class cls, Method method) {
        ldcClassConstant(cls);
        this.mv.v(182, "java/lang/Class", "getMethods", "()[Ljava/lang/reflect/Method;");
        this.mv.F(58, 7);
        this.mv.j(3);
        this.mv.F(54, 5);
        this.mv.F(25, 7);
        this.mv.j(190);
        this.mv.F(54, 6);
        q qVar = new q();
        this.mv.n(167, qVar);
        q qVar2 = new q();
        this.mv.o(qVar2);
        this.mv.F(25, 7);
        this.mv.F(21, 5);
        this.mv.j(50);
        this.mv.F(58, 4);
        this.mv.o(new q());
        this.mv.p(method.getName());
        this.mv.F(25, 4);
        this.mv.v(182, "java/lang/reflect/Method", "getName", "()Ljava/lang/String;");
        this.mv.v(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z");
        q qVar3 = new q();
        this.mv.n(153, qVar3);
        this.mv.o(new q());
        this.mv.F(25, 4);
        this.mv.j(176);
        this.mv.o(qVar3);
        this.mv.i(5, 1);
        this.mv.o(qVar);
        this.mv.F(21, 5);
        this.mv.F(21, 6);
        this.mv.n(161, qVar2);
        this.mv.o(new q());
        this.mv.j(1);
        this.mv.j(176);
    }

    private Class writeLiteralOrSubexpression(Object obj) {
        return writeLiteralOrSubexpression(obj, null, null);
    }

    private Class writeLiteralOrSubexpression(Object obj, Class cls) {
        return writeLiteralOrSubexpression(obj, cls, null);
    }

    private Class writeLiteralOrSubexpression(Object obj, Class cls, Class cls2) {
        Class cls3;
        if (!(obj instanceof ExecutableLiteral)) {
            this.literal = $assertionsDisabled;
            ExecutableStatement executableStatement = (ExecutableStatement) obj;
            addSubstatement(executableStatement);
            if (cls2 == null) {
                cls2 = executableStatement.getKnownEgressType();
            }
            if (cls != null && cls2 != cls && cls.isPrimitive()) {
                if (cls2 == null) {
                    throw new OptimizationFailure("cannot optimize expression: " + new String(this.expr) + ": cannot determine ingress type for primitive output");
                }
                checkcast(cls2);
                unwrapPrimitive(cls);
            }
            return cls2;
        }
        ExecutableLiteral executableLiteral = (ExecutableLiteral) obj;
        Object literal = executableLiteral.getLiteral();
        if (literal == null) {
            this.mv.j(1);
            return null;
        }
        Class<?> cls4 = literal.getClass();
        if (cls4 == Integer.class && cls == (cls3 = Integer.TYPE)) {
            intPush(executableLiteral.getInteger32());
            return cls3;
        }
        if (cls == null || cls == cls4) {
            writeOutLiteralWrapped(literal);
            return cls4;
        }
        if (b.a(cls4, cls)) {
            writeOutLiteralWrapped(b.b(literal, cls));
            return cls4;
        }
        throw new CompileException("was expecting type: " + cls.getName() + "; but found type: " + cls4.getName(), this.expr, this.st);
    }

    private void writeOutLiteralWrapped(Object obj) {
        if (obj instanceof Integer) {
            intPush(((Integer) obj).intValue());
            wrapPrimitive(Integer.TYPE);
            return;
        }
        if (obj instanceof String) {
            this.mv.p(obj);
            return;
        }
        if (obj instanceof Long) {
            this.mv.p(obj);
            wrapPrimitive(Long.TYPE);
            return;
        }
        if (obj instanceof Float) {
            this.mv.p(obj);
            wrapPrimitive(Float.TYPE);
            return;
        }
        if (obj instanceof Double) {
            this.mv.p(obj);
            wrapPrimitive(Double.TYPE);
            return;
        }
        if (obj instanceof Short) {
            this.mv.p(obj);
            wrapPrimitive(Short.TYPE);
            return;
        }
        if (obj instanceof Character) {
            this.mv.p(obj);
            wrapPrimitive(Character.TYPE);
        } else if (obj instanceof Boolean) {
            this.mv.p(obj);
            wrapPrimitive(Boolean.TYPE);
        } else if (obj instanceof Byte) {
            this.mv.p(obj);
            wrapPrimitive(Byte.TYPE);
        }
    }

    private void writeOutNullHandler(Member member, int i) {
        this.mv.j(89);
        q qVar = new q();
        this.mv.n(199, qVar);
        this.mv.j(87);
        this.mv.F(25, 0);
        if (i == 0) {
            this.propNull = true;
            this.mv.g(180, this.className, "nullPropertyHandler", "L" + NAMESPACE + "integration/PropertyHandler;");
        } else {
            this.methNull = true;
            this.mv.g(180, this.className, "nullMethodHandler", "L" + NAMESPACE + "integration/PropertyHandler;");
        }
        this.mv.p(member.getName());
        this.mv.F(25, 1);
        this.mv.F(25, 3);
        this.mv.v(185, NAMESPACE + "integration/PropertyHandler", "getProperty", "(Ljava/lang/String;Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;)Ljava/lang/Object;");
        this.mv.o(qVar);
    }

    public void arrayStore(Class cls) {
        if (!cls.isPrimitive()) {
            this.mv.j(83);
            return;
        }
        if (cls == Integer.TYPE) {
            this.mv.j(79);
            return;
        }
        if (cls == Character.TYPE) {
            this.mv.j(85);
            return;
        }
        if (cls == Boolean.TYPE) {
            this.mv.j(84);
            return;
        }
        if (cls == Double.TYPE) {
            this.mv.j(82);
            return;
        }
        if (cls == Float.TYPE) {
            this.mv.j(81);
            return;
        }
        if (cls == Short.TYPE) {
            this.mv.j(86);
        } else if (cls == Long.TYPE) {
            this.mv.j(80);
        } else if (cls == Byte.TYPE) {
            this.mv.j(84);
        }
    }

    @Override // org.mvel2.optimizers.a
    public Class getEgressType() {
        return this.returnType;
    }

    public String getName() {
        return "ASM";
    }

    @Override // org.mvel2.optimizers.a
    public Object getResultOptPass() {
        return this.val;
    }

    @Override // org.mvel2.optimizers.a
    public void init() {
        try {
            classLoader = new i(Thread.currentThread().getContextClassLoader());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.mvel2.optimizers.a
    public boolean isLiteralOnly() {
        return this.literal;
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeAccessor(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z, Class cls) {
        this.time = System.currentTimeMillis();
        if (this.compiledInputs == null) {
            this.compiledInputs = new ArrayList<>();
        }
        this.cursor = i;
        this.start = i;
        int i3 = i2 + i;
        this.end = i3;
        this.length = i3 - i;
        this.first = true;
        this.val = null;
        this.pCtx = parserContext;
        this.expr = cArr;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.ingressType = cls;
        if (!this.noinit) {
            _initJIT();
        }
        return compileAccessor();
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeCollection(ParserContext parserContext, Object obj, Class cls, char[] cArr, int i, int i2, Object obj2, Object obj3, VariableResolverFactory variableResolverFactory) {
        int i3;
        this.expr = cArr;
        this.start = i;
        this.cursor = i;
        this.end = i + i2;
        this.length = i2;
        this.returnType = cls;
        this.compiledInputs = new ArrayList<>();
        this.ctx = obj2;
        this.thisRef = obj3;
        this.variableFactory = variableResolverFactory;
        this.pCtx = parserContext;
        _initJIT();
        this.literal = true;
        _getAccessor(obj, cls);
        _finishJIT();
        try {
            org.mvel2.compiler.a _initializeAccessor = _initializeAccessor();
            return (cArr == null || (i3 = this.length) <= i) ? _initializeAccessor : new org.mvel2.optimizers.impl.refl.nodes.a(parserContext, _initializeAccessor, cArr, i, i3);
        } catch (Exception e) {
            throw new OptimizationFailure("could not optimize collection", e);
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeObjectCreation(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        String str;
        String str2;
        Object[] objArr;
        _initJIT();
        this.compiledInputs = new ArrayList<>();
        this.cursor = i;
        this.start = i;
        int i3 = i + i2;
        this.end = i3;
        this.length = i3 - i;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.pCtx = parserContext;
        String[] g = m.g(cArr, i, i2);
        List w0 = m.w0(g[0].toCharArray());
        int i4 = 89;
        try {
            if (w0 == null) {
                Class D = m.D(variableResolverFactory, new String(cArr), parserContext);
                this.mv.E(187, y.h(D));
                this.mv.j(89);
                this.mv.v(183, y.h(D), "<init>", y.d(D.getConstructor(EMPTYCLS)));
                _finishJIT();
                org.mvel2.compiler.a _initializeAccessor = _initializeAccessor();
                return (g.length <= 1 || (str = g[1]) == null || str.trim().equals("")) ? _initializeAccessor : new org.mvel2.optimizers.impl.refl.nodes.a(parserContext, _initializeAccessor, g[1].toCharArray(), 0, g[1].length());
            }
            Iterator it = w0.iterator();
            while (it.hasNext()) {
                this.compiledInputs.add((ExecutableStatement) m.J0((char[]) it.next(), parserContext));
            }
            Class D2 = m.D(variableResolverFactory, new String(m.K0(cArr, 0, org.mvel2.util.b.a('(', i, this.length, cArr))), parserContext);
            this.mv.E(187, y.h(D2));
            this.mv.j(89);
            int size = w0.size();
            Object[] objArr2 = new Object[size];
            Iterator<ExecutableStatement> it2 = this.compiledInputs.iterator();
            int i6 = 0;
            while (it2.hasNext()) {
                objArr2[i6] = it2.next().getValue(obj, variableResolverFactory);
                i6++;
            }
            Constructor N = m.N(objArr2, D2, parserContext.isStrongTyping());
            if (N == null) {
                StringBuilder sb = new StringBuilder();
                int i7 = 0;
                while (i7 < size) {
                    sb.append(objArr2[i7].getClass().getName());
                    i7++;
                    if (i7 < size) {
                        sb.append(", ");
                    }
                }
                throw new CompileException("unable to find constructor: " + D2.getName() + "(" + sb.toString() + ")", this.expr, this.st);
            }
            this.returnType = N.getDeclaringClass();
            N.getParameterTypes();
            Class<?> cls = null;
            int i8 = -1;
            int i9 = 0;
            while (i9 < w0.size()) {
                if (i9 < N.getParameterTypes().length) {
                    cls = N.getParameterTypes()[i9];
                    if (N.isVarArgs() && i9 == N.getParameterTypes().length - 1) {
                        cls = m.I(cls);
                        createArray(cls, w0.size() - i9);
                        i8 = i9;
                    }
                } else if (i8 < 0 || cls == null) {
                    throw new IllegalStateException("Incorrect argument count " + i9);
                }
                if (i8 >= 0) {
                    this.mv.j(i4);
                    intPush(i9 - i8);
                }
                this.mv.F(25, 0);
                r rVar = this.mv;
                String str3 = this.className;
                StringBuilder sb2 = new StringBuilder();
                List list = w0;
                sb2.append("p");
                sb2.append(i9);
                rVar.g(180, str3, sb2.toString(), "L" + NAMESPACE + "compiler/ExecutableStatement;");
                this.mv.F(25, 2);
                this.mv.F(25, 3);
                this.mv.v(185, "" + NAMESPACE + "compiler/ExecutableStatement", "getValue", "(Ljava/lang/Object;L" + NAMESPACE + "integration/VariableResolverFactory;)Ljava/lang/Object;");
                Class<?> wrapperClass = cls.isPrimitive() ? getWrapperClass(cls) : cls;
                Object obj3 = objArr2[i9];
                if (obj3 == null || obj3.getClass().isAssignableFrom(cls)) {
                    objArr = objArr2;
                    this.mv.E(192, y.h(cls));
                } else {
                    ldcClassConstant(wrapperClass);
                    objArr = objArr2;
                    this.mv.v(184, "" + NAMESPACE + "DataConversion", "convert", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
                    if (cls.isPrimitive()) {
                        unwrapPrimitive(cls);
                    } else {
                        this.mv.E(192, y.h(wrapperClass));
                    }
                }
                if (i8 >= 0) {
                    arrayStore(cls);
                }
                i9++;
                w0 = list;
                objArr2 = objArr;
                i4 = 89;
            }
            this.mv.v(183, y.h(D2), "<init>", y.d(N));
            _finishJIT();
            org.mvel2.compiler.a _initializeAccessor2 = _initializeAccessor();
            return (g.length <= 1 || (str2 = g[1]) == null || str2.trim().equals("")) ? _initializeAccessor2 : new org.mvel2.optimizers.impl.refl.nodes.a(parserContext, _initializeAccessor2, g[1].toCharArray(), 0, g[1].length());
        } catch (ClassNotFoundException unused) {
            throw new CompileException("class or class reference not found: " + new String(cArr), cArr, this.st);
        } catch (Exception e) {
            throw new OptimizationFailure("could not optimize construtor: " + new String(cArr), e);
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeSetAccessor(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z, Object obj3, Class cls) {
        Object obj4;
        InvocationTargetException invocationTargetException;
        IllegalAccessException illegalAccessException;
        Object obj5 = obj3;
        this.expr = cArr;
        this.cursor = i;
        this.start = i;
        int i3 = i + i2;
        this.end = i3;
        this.length = i3;
        this.first = true;
        this.ingressType = cls;
        this.compiledInputs = new ArrayList<>();
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.pCtx = parserContext;
        PropertyVerifier propertyVerifier = new PropertyVerifier(cArr, parserContext);
        int findLastUnion = findLastUnion();
        q qVar = null;
        char[] K0 = findLastUnion != -1 ? m.K0(cArr, 0, findLastUnion) : null;
        _initJIT2();
        if (K0 != null) {
            int i4 = this.length;
            char[] cArr2 = this.expr;
            this.expr = K0;
            int length = K0.length;
            this.end = length;
            this.length = length;
            this.deferFinish = true;
            this.noinit = true;
            compileAccessor();
            obj4 = this.val;
            this.expr = cArr2;
            int length2 = K0.length + i + 1;
            this.cursor = length2;
            int length3 = (i4 - K0.length) - 1;
            this.length = length3;
            this.end = length2 + length3;
        } else {
            this.mv.F(25, 1);
            obj4 = obj;
        }
        try {
            skipWhitespace();
            try {
                if (!this.collection) {
                    char[] cArr3 = this.expr;
                    int i6 = this.cursor;
                    String str = new String(cArr3, i6, this.end - i6);
                    Member d = n.d(obj4.getClass(), str, obj5 == null ? null : cls);
                    if (yz.a.b()) {
                        try {
                            this.mv.F(25, 1);
                            this.mv.p(str);
                            this.mv.F(25, 3);
                            this.mv.F(25, 4);
                            this.mv.v(184, NAMESPACE + "integration/GlobalListenerFactory", "notifySetListeners", "(Ljava/lang/Object;Ljava/lang/String;L" + NAMESPACE + "integration/VariableResolverFactory;Ljava/lang/Object;)V");
                            yz.a.d(obj4, str, this.variableFactory, obj5);
                        } catch (IllegalAccessException e) {
                            e = e;
                            illegalAccessException = e;
                            throw new PropertyAccessException("could not access property", this.expr, i, illegalAccessException, parserContext);
                        } catch (InvocationTargetException e3) {
                            e = e3;
                            invocationTargetException = e;
                            throw new PropertyAccessException("could not access property", this.expr, i, invocationTargetException, parserContext);
                        }
                    }
                    if (d instanceof Field) {
                        checkcast(obj4.getClass());
                        Field field = (Field) d;
                        q qVar2 = new q();
                        if (field.getType().isPrimitive()) {
                            this.mv.F(58, 5);
                            this.mv.F(25, 4);
                            if (obj5 == null) {
                                obj5 = n.g(field.getType());
                            }
                            q qVar3 = new q();
                            this.mv.n(199, qVar3);
                            this.mv.F(25, 5);
                            this.mv.j(3);
                            this.mv.g(181, y.h(field.getDeclaringClass()), str, y.f(field.getType()));
                            this.mv.n(167, qVar2);
                            this.mv.o(qVar3);
                            this.mv.F(25, 5);
                            this.mv.F(25, 4);
                            unwrapPrimitive(field.getType());
                            qVar = qVar3;
                        } else {
                            this.mv.F(25, 4);
                            checkcast(field.getType());
                        }
                        if (qVar != null || obj5 == null || field.getType().isAssignableFrom(obj5.getClass())) {
                            field.set(obj4, obj5);
                        } else {
                            if (!b.a(field.getType(), obj5.getClass())) {
                                throw new CompileException("cannot convert type: " + obj5.getClass() + ": to " + field.getType(), this.expr, i);
                            }
                            dataConversion(field.getType());
                            field.set(obj4, b.b(obj5, field.getType()));
                        }
                        this.mv.g(181, y.h(field.getDeclaringClass()), str, y.f(field.getType()));
                        this.mv.o(qVar2);
                        this.mv.F(25, 4);
                    } else if (d != null) {
                        this.mv.E(192, y.h(obj4.getClass()));
                        Method method = (Method) d;
                        this.mv.F(25, 4);
                        Class<?> cls2 = method.getParameterTypes()[0];
                        q qVar4 = new q();
                        if (obj5 == null || cls2.isAssignableFrom(obj3.getClass())) {
                            if (cls2.isPrimitive()) {
                                if (obj5 == null) {
                                    obj5 = n.g(cls2);
                                }
                                q qVar5 = new q();
                                this.mv.n(199, qVar5);
                                this.mv.j(3);
                                this.mv.v(182, y.h(method.getDeclaringClass()), method.getName(), y.i(method));
                                this.mv.n(167, qVar4);
                                this.mv.o(qVar5);
                                this.mv.F(25, 4);
                                unwrapPrimitive(cls2);
                            } else {
                                checkcast(cls2);
                            }
                            try {
                                method.invoke(obj4, obj5);
                            } catch (IllegalAccessException e4) {
                                e = e4;
                                illegalAccessException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i, illegalAccessException, parserContext);
                            } catch (InvocationTargetException e5) {
                                e = e5;
                                invocationTargetException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i, invocationTargetException, parserContext);
                            }
                        } else {
                            if (!b.a(cls2, obj3.getClass())) {
                                throw new CompileException("cannot convert type: " + obj3.getClass() + ": to " + method.getParameterTypes()[0], this.expr, i);
                            }
                            dataConversion(getWrapperClass(cls2));
                            if (cls2.isPrimitive()) {
                                unwrapPrimitive(cls2);
                            } else {
                                checkcast(cls2);
                            }
                            try {
                                method.invoke(obj4, b.b(obj5, method.getParameterTypes()[0]));
                            } catch (IllegalAccessException e6) {
                                e = e6;
                                illegalAccessException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i, illegalAccessException, parserContext);
                            } catch (InvocationTargetException e7) {
                                e = e7;
                                invocationTargetException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i, invocationTargetException, parserContext);
                            }
                        }
                        this.mv.v(182, y.h(method.getDeclaringClass()), method.getName(), y.i(method));
                        this.mv.o(qVar4);
                        this.mv.F(25, 4);
                    } else {
                        if (!(obj4 instanceof Map)) {
                            try {
                                throw new PropertyAccessException("could not access property (" + str + ") in: " + cls.getName(), this.expr, i, parserContext);
                            } catch (IllegalAccessException e8) {
                                e = e8;
                                illegalAccessException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i, illegalAccessException, parserContext);
                            } catch (InvocationTargetException e9) {
                                e = e9;
                                invocationTargetException = e;
                                throw new PropertyAccessException("could not access property", this.expr, i, invocationTargetException, parserContext);
                            }
                        }
                        this.mv.E(192, y.h(obj4.getClass()));
                        this.mv.p(str);
                        this.mv.F(25, 4);
                        this.mv.v(185, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                        this.mv.F(25, 4);
                        ((Map) obj4).put(str, obj5);
                    }
                    try {
                        this.deferFinish = $assertionsDisabled;
                        this.noinit = $assertionsDisabled;
                        _finishJIT();
                        return _initializeAccessor();
                    } catch (Exception e10) {
                        throw new CompileException("could not generate accessor", this.expr, i, e10);
                    }
                }
                try {
                    int i7 = this.cursor;
                    whiteSpaceSkip();
                    if (i7 == this.end) {
                        throw new PropertyAccessException("unterminated '['", this.expr, i, parserContext);
                    }
                    try {
                        if (scanTo(']')) {
                            throw new PropertyAccessException("unterminated '['", this.expr, i, parserContext);
                        }
                        String trim = new String(this.expr, i7, this.cursor - i7).trim();
                        this.mv.E(192, y.h(obj4.getClass()));
                        if (obj4 instanceof Map) {
                            if (d.h && yz.d.f(Map.class)) {
                                propHandlerByteCodePut(trim, obj4, Map.class, obj5);
                            } else {
                                Map map = (Map) obj4;
                                Object l = d.l(trim, obj4, this.variableFactory);
                                Class analyze = propertyVerifier.analyze();
                                this.returnType = analyze;
                                map.put(l, b.b(obj5, analyze));
                                writeLiteralOrSubexpression(m.J0(trim.toCharArray(), parserContext));
                                this.mv.F(25, 4);
                                if (obj5 != null && this.returnType != obj3.getClass()) {
                                    dataConversion(this.returnType);
                                    checkcast(this.returnType);
                                }
                                this.mv.v(185, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                                this.mv.j(87);
                                this.mv.F(25, 4);
                            }
                        } else if (obj4 instanceof List) {
                            if (d.h && yz.d.f(List.class)) {
                                propHandlerByteCodePut(trim, obj4, List.class, obj5);
                            } else {
                                List list = (List) obj4;
                                int intValue = ((Integer) d.m(trim, obj4, this.variableFactory, Integer.class)).intValue();
                                Class analyze2 = propertyVerifier.analyze();
                                this.returnType = analyze2;
                                list.set(intValue, b.b(obj5, analyze2));
                                writeLiteralOrSubexpression(m.J0(trim.toCharArray(), parserContext));
                                unwrapPrimitive(Integer.TYPE);
                                this.mv.F(25, 4);
                                if (obj5 != null && !obj3.getClass().isAssignableFrom(this.returnType)) {
                                    dataConversion(this.returnType);
                                    checkcast(this.returnType);
                                }
                                this.mv.v(185, "java/util/List", "set", "(ILjava/lang/Object;)Ljava/lang/Object;");
                                this.mv.F(25, 4);
                            }
                        } else if (d.h && yz.d.f(obj4.getClass())) {
                            propHandlerByteCodePut(trim, obj4, obj4.getClass(), obj5);
                        } else {
                            if (!obj4.getClass().isArray()) {
                                throw new PropertyAccessException("cannot bind to collection property: " + new String(this.expr) + ": not a recognized collection type: " + obj4.getClass(), this.expr, i, parserContext);
                            }
                            if (d.h && yz.d.f(Array.class)) {
                                propHandlerByteCodePut(trim, obj4, Array.class, obj5);
                            } else {
                                Class I = m.I(obj4.getClass());
                                Object l2 = d.l(trim, obj4, this.variableFactory);
                                Serializable J0 = m.J0(trim.toCharArray(), parserContext);
                                Class cls3 = Integer.TYPE;
                                writeLiteralOrSubexpression(J0, cls3);
                                if (!(l2 instanceof Integer)) {
                                    dataConversion(Integer.class);
                                    l2 = b.b(l2, Integer.class);
                                    unwrapPrimitive(cls3);
                                }
                                this.mv.F(25, 4);
                                if (I.isPrimitive()) {
                                    unwrapPrimitive(I);
                                } else if (!I.equals(obj3.getClass())) {
                                    dataConversion(I);
                                }
                                arrayStore(I);
                                Array.set(obj4, ((Integer) l2).intValue(), b.b(obj5, I));
                                this.mv.F(25, 4);
                            }
                        }
                        this.deferFinish = $assertionsDisabled;
                        this.noinit = $assertionsDisabled;
                        _finishJIT();
                        try {
                            this.deferFinish = $assertionsDisabled;
                            return _initializeAccessor();
                        } catch (Exception e11) {
                            throw new CompileException("could not generate accessor", this.expr, i, e11);
                        }
                    } catch (IllegalAccessException e12) {
                        e = e12;
                        illegalAccessException = e;
                        throw new PropertyAccessException("could not access property", this.expr, i, illegalAccessException, parserContext);
                    } catch (InvocationTargetException e13) {
                        e = e13;
                        invocationTargetException = e;
                        throw new PropertyAccessException("could not access property", this.expr, i, invocationTargetException, parserContext);
                    }
                } catch (IllegalAccessException e14) {
                    e = e14;
                } catch (InvocationTargetException e15) {
                    e = e15;
                }
            } catch (IllegalAccessException e16) {
                e = e16;
            } catch (InvocationTargetException e17) {
                e = e17;
            }
        } catch (IllegalAccessException e18) {
            e = e18;
        } catch (InvocationTargetException e19) {
            e = e19;
        }
    }

    public void wrapRuntimeConverstion(Class cls) {
        ldcClassConstant(getWrapperClass(cls));
        this.mv.v(184, "" + NAMESPACE + "DataConversion", "convert", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
    }
}
