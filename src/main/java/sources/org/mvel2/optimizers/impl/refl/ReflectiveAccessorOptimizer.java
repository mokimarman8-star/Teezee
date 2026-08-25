package org.mvel2.optimizers.impl.refl;

import c00.b;
import c00.c;
import c00.d;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.CompileException;
import org.mvel2.OptimizationFailure;
import org.mvel2.ParserContext;
import org.mvel2.PropertyAccessException;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.compiler.PropertyVerifier;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.AbstractOptimizer;
import org.mvel2.optimizers.a;
import org.mvel2.optimizers.impl.refl.nodes.ArrayAccessor;
import org.mvel2.optimizers.impl.refl.nodes.ArrayAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.ArrayLength;
import org.mvel2.optimizers.impl.refl.nodes.ConstructorAccessor;
import org.mvel2.optimizers.impl.refl.nodes.DynamicFieldAccessor;
import org.mvel2.optimizers.impl.refl.nodes.DynamicFunctionAccessor;
import org.mvel2.optimizers.impl.refl.nodes.FieldAccessor;
import org.mvel2.optimizers.impl.refl.nodes.FieldAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.FunctionAccessor;
import org.mvel2.optimizers.impl.refl.nodes.GetterAccessor;
import org.mvel2.optimizers.impl.refl.nodes.GetterAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.IndexedCharSeqAccessor;
import org.mvel2.optimizers.impl.refl.nodes.IndexedCharSeqAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.IndexedVariableAccessor;
import org.mvel2.optimizers.impl.refl.nodes.ListAccessor;
import org.mvel2.optimizers.impl.refl.nodes.ListAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.MapAccessor;
import org.mvel2.optimizers.impl.refl.nodes.MapAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.MethodAccessor;
import org.mvel2.optimizers.impl.refl.nodes.MethodAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.Notify;
import org.mvel2.optimizers.impl.refl.nodes.NullSafe;
import org.mvel2.optimizers.impl.refl.nodes.PropertyHandlerAccessor;
import org.mvel2.optimizers.impl.refl.nodes.SetterAccessor;
import org.mvel2.optimizers.impl.refl.nodes.StaticReferenceAccessor;
import org.mvel2.optimizers.impl.refl.nodes.StaticVarAccessor;
import org.mvel2.optimizers.impl.refl.nodes.StaticVarAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.ThisValueAccessor;
import org.mvel2.optimizers.impl.refl.nodes.VariableAccessor;
import org.mvel2.optimizers.impl.refl.nodes.WithAccessor;
import org.mvel2.util.MethodStub;
import org.mvel2.util.e;
import org.mvel2.util.f;
import org.mvel2.util.m;
import org.mvel2.util.n;
import org.mvel2.util.p;
import org.mvel2.util.s;
import org.mvel2.util.t;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class ReflectiveAccessorOptimizer extends AbstractOptimizer implements a {
    private static final int DONE = -1;
    private Object ctx;
    private AccessorNode currNode;
    private boolean first;
    private Class ingressType;
    private Class returnType;
    private AccessorNode rootNode;
    private Object thisRef;
    private Object val;
    private VariableResolverFactory variableFactory;
    private static final Logger LOG = Logger.getLogger(ReflectiveAccessorOptimizer.class.getName());
    private static final Object[] EMPTYARG = new Object[0];
    private static final Class[] EMPTYCLS = new Class[0];

    public ReflectiveAccessorOptimizer() {
        this.first = true;
    }

    private ReflectiveAccessorOptimizer(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        super(parserContext);
        this.first = true;
        this.expr = cArr;
        this.start = i;
        i2 = cArr == null ? i : i2;
        this.length = i2;
        this.end = i + i2;
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
        this.thisRef = obj2;
    }

    private org.mvel2.compiler.a _getAccessor(Object obj, Class cls) {
        int i;
        int i2 = 0;
        if (obj instanceof List) {
            List list = (List) obj;
            org.mvel2.compiler.a[] aVarArr = new org.mvel2.compiler.a[list.size()];
            Iterator it = list.iterator();
            while (it.hasNext()) {
                aVarArr[i2] = _getAccessor(it.next(), cls);
                i2++;
            }
            this.returnType = List.class;
            return new c(aVarArr);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            int size = map.size();
            org.mvel2.compiler.a[] aVarArr2 = new org.mvel2.compiler.a[size];
            org.mvel2.compiler.a[] aVarArr3 = new org.mvel2.compiler.a[size];
            for (Object obj2 : map.keySet()) {
                aVarArr2[i2] = _getAccessor(obj2, cls);
                aVarArr3[i2] = _getAccessor(map.get(obj2), cls);
                i2++;
            }
            this.returnType = Map.class;
            return new d(aVarArr2, aVarArr3);
        }
        if (!(obj instanceof Object[])) {
            if (this.returnType == null) {
                this.returnType = Object.class;
            }
            return cls.isArray() ? new b((String) obj, cls, this.ctx, this.variableFactory, this.pCtx) : new b((String) obj, Object.class, this.ctx, this.variableFactory, this.pCtx);
        }
        org.mvel2.compiler.a[] aVarArr4 = new org.mvel2.compiler.a[((Object[]) obj).length];
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
            Class I = m.I(cls);
            Class D = i > 1 ? m.D(null, m.A0('[', i - 1) + "L" + I.getName() + ";", this.pCtx) : cls;
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            int i3 = 0;
            while (i2 < length) {
                Object obj3 = objArr[i2];
                ParserContext parserContext = this.pCtx;
                org.mvel2.compiler.a _getAccessor = _getAccessor(obj3, D);
                aVarArr4[i3] = _getAccessor;
                e.c(parserContext, _getAccessor, I, true);
                i2++;
                i3++;
            }
            return new c00.a(aVarArr4, m.T(cls));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("this error should never throw:" + m.I(cls).getName(), e);
        }
    }

    private void addAccessorNode(AccessorNode accessorNode) {
        if (this.rootNode != null) {
            this.currNode = this.currNode.setNextNode(accessorNode);
        } else {
            this.currNode = accessorNode;
            this.rootNode = accessorNode;
        }
    }

    private AccessorNode compileConstructor(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory) throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        String[] g = m.g(cArr, this.start, this.length);
        int i = 0;
        List w0 = m.w0(g[0].toCharArray());
        if (w0 == null) {
            ParserContext parserContext = this.pCtx;
            Constructor<?> constructor = Class.forName(new String(cArr), true, parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader()).getConstructor(EMPTYCLS);
            ConstructorAccessor constructorAccessor = new ConstructorAccessor(constructor, null);
            if (g.length <= 1) {
                return constructorAccessor;
            }
            ReflectiveAccessorOptimizer reflectiveAccessorOptimizer = new ReflectiveAccessorOptimizer(this.pCtx, g[1].toCharArray(), 0, g[1].length(), constructor.newInstance(null), obj, variableResolverFactory);
            reflectiveAccessorOptimizer.setRootNode(constructorAccessor);
            reflectiveAccessorOptimizer.compileGetChain();
            AccessorNode rootNode = reflectiveAccessorOptimizer.getRootNode();
            this.val = reflectiveAccessorOptimizer.getResultOptPass();
            return rootNode;
        }
        Class D = m.D(variableResolverFactory, new String(m.K0(cArr, 0, org.mvel2.util.b.a('(', this.start, this.length, cArr))), this.pCtx);
        ExecutableStatement[] executableStatementArr = new ExecutableStatement[w0.size()];
        for (int i2 = 0; i2 < w0.size(); i2++) {
            executableStatementArr[i2] = (ExecutableStatement) m.J0((char[]) w0.get(i2), this.pCtx);
        }
        int size = w0.size();
        Object[] objArr = new Object[size];
        for (int i3 = 0; i3 < w0.size(); i3++) {
            objArr[i3] = executableStatementArr[i3].getValue(obj, variableResolverFactory);
        }
        Constructor N = m.N(objArr, D, this.pCtx.isStrongTyping());
        if (N == null) {
            StringBuilder sb = new StringBuilder();
            while (i < size) {
                sb.append(objArr[i].getClass().getName());
                i++;
                if (i < size) {
                    sb.append(", ");
                }
            }
            throw new CompileException("unable to find constructor: " + D.getName() + "(" + sb.toString() + ")", this.expr, this.start);
        }
        while (i < size) {
            objArr[i] = org.mvel2.b.b(objArr[i], t.b(N.getParameterTypes(), i, N.isVarArgs()));
            i++;
        }
        Object[] a = t.a(N.getParameterTypes(), objArr, N.isVarArgs());
        ConstructorAccessor constructorAccessor2 = new ConstructorAccessor(N, executableStatementArr);
        if (g.length <= 1) {
            return constructorAccessor2;
        }
        ReflectiveAccessorOptimizer reflectiveAccessorOptimizer2 = new ReflectiveAccessorOptimizer(this.pCtx, g[1].toCharArray(), 0, g[1].length(), N.newInstance(a), obj, variableResolverFactory);
        reflectiveAccessorOptimizer2.ingressType = N.getDeclaringClass();
        reflectiveAccessorOptimizer2.setRootNode(constructorAccessor2);
        reflectiveAccessorOptimizer2.compileGetChain();
        AccessorNode rootNode2 = reflectiveAccessorOptimizer2.getRootNode();
        this.val = reflectiveAccessorOptimizer2.getResultOptPass();
        return rootNode2;
    }

    private org.mvel2.compiler.a compileGetChain() {
        Object obj = this.ctx;
        this.cursor = this.start;
        try {
            if (org.mvel2.d.h) {
                while (this.cursor < this.end) {
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
                    this.first = false;
                    if (obj != null) {
                        this.returnType = obj.getClass();
                    }
                    int i = this.cursor;
                    if (i < this.end) {
                        if (this.nullSafe) {
                            char[] cArr = this.expr;
                            int i2 = cArr[i] == '.' ? 1 : 0;
                            addAccessorNode(new NullSafe(cArr, i + i2, (this.length - i) - i2, this.pCtx));
                            if (obj == null) {
                                break;
                            }
                        }
                        if (obj == null) {
                            throw new NullPointerException();
                        }
                    }
                    this.staticAccess = false;
                }
            } else {
                while (this.cursor < this.end) {
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
                    this.first = false;
                    if (obj != null) {
                        this.returnType = obj.getClass();
                    }
                    int i3 = this.cursor;
                    int i4 = this.end;
                    if (i3 < i4) {
                        if (this.nullSafe) {
                            char[] cArr2 = this.expr;
                            int i6 = cArr2[i3] == '.' ? 1 : 0;
                            addAccessorNode(new NullSafe(cArr2, i3 + i6, (i4 - i3) - i6, this.pCtx));
                            if (obj == null) {
                                break;
                            }
                        }
                        if (obj == null) {
                            throw new NullPointerException();
                        }
                    }
                    this.staticAccess = false;
                }
            }
            this.val = obj;
            return this.rootNode;
        } catch (IllegalAccessException e) {
            throw new PropertyAccessException(new String(this.expr, this.start, this.length) + ": " + e.getMessage(), this.expr, this.st, e, this.pCtx);
        } catch (IndexOutOfBoundsException e3) {
            throw new PropertyAccessException(new String(this.expr, this.start, this.length) + ": array index out of bounds.", this.expr, this.st, e3, this.pCtx);
        } catch (NullPointerException e4) {
            throw new PropertyAccessException("null pointer: " + new String(this.expr, this.start, this.length), this.expr, this.st, e4, this.pCtx);
        } catch (InvocationTargetException e5) {
            if (org.mvel2.d.f) {
                if (e5.getTargetException() instanceof RuntimeException) {
                    throw ((RuntimeException) e5.getTargetException());
                }
                throw new RuntimeException(e5);
            }
            throw new PropertyAccessException(new String(this.expr, this.start, this.length) + ": " + e5.getTargetException().getMessage(), this.expr, this.st, e5, this.pCtx);
        } catch (CompileException e6) {
            throw e6;
        } catch (Exception e7) {
            LOG.log(Level.WARNING, "", (Throwable) e7);
            throw new CompileException(e7.getMessage(), this.expr, this.st, e7);
        }
    }

    private Object getBeanProperty(Object obj, String str) throws Exception {
        Class<?> cls;
        boolean z;
        Object obj2;
        Object obj3;
        ParserContext parserContext = this.pCtx;
        if ((parserContext == null ? this.currType : parserContext.getVarOrInputTypeOrNull(str)) == Object.class && !this.pCtx.isStrongTyping()) {
            this.currType = null;
        }
        if (this.first) {
            if ("this".equals(str)) {
                addAccessorNode(new ThisValueAccessor());
                return this.thisRef;
            }
            VariableResolverFactory variableResolverFactory = this.variableFactory;
            if (variableResolverFactory != null && variableResolverFactory.isResolveable(str)) {
                if (!this.variableFactory.isIndexedFactory() || !this.variableFactory.isTarget(str)) {
                    addAccessorNode(new VariableAccessor(str));
                    return this.variableFactory.getVariableResolver(str).getValue();
                }
                int variableIndexOf = this.variableFactory.variableIndexOf(str);
                addAccessorNode(new IndexedVariableAccessor(variableIndexOf));
                if (this.variableFactory.getIndexedVariableResolver(variableIndexOf) == null) {
                    VariableResolverFactory variableResolverFactory2 = this.variableFactory;
                    variableResolverFactory2.setIndexedVariableResolver(variableIndexOf, variableResolverFactory2.getVariableResolver(str));
                }
                return this.variableFactory.getIndexedVariableResolver(variableIndexOf).getValue();
            }
        }
        boolean z2 = obj instanceof Class;
        if (!z2) {
            cls = obj != null ? obj.getClass() : this.currType;
            z = false;
        } else {
            if (org.mvel2.d.j && "class".equals(str)) {
                return obj;
            }
            cls = (Class) obj;
            z = true;
        }
        if (yz.d.f(cls)) {
            yz.d.c(cls);
            PropertyHandlerAccessor propertyHandlerAccessor = new PropertyHandlerAccessor(str, cls, null);
            addAccessorNode(propertyHandlerAccessor);
            return propertyHandlerAccessor.getValue(obj, this.thisRef, this.variableFactory);
        }
        Member b = cls != null ? n.b(cls, str) : null;
        if (b != null && z && (b.getModifiers() & 8) == 0) {
            b = null;
        }
        if (b instanceof Method) {
            if (obj != null) {
                try {
                    obj3 = ((Method) b).invoke(obj, EMPTYARG);
                } catch (IllegalAccessException unused) {
                    Method method = (Method) b;
                    Method z3 = m.z(method);
                    if (z3 == null) {
                        throw new PropertyAccessException("could not access field: " + cls.getName() + "." + str, this.expr, this.start, this.pCtx);
                    }
                    Object invoke = z3.invoke(obj, EMPTYARG);
                    if (yz.d.e()) {
                        yz.d.a();
                        addAccessorNode(new GetterAccessorNH(method, null));
                        if (invoke == null) {
                            yz.d.a();
                            b.getName();
                            throw null;
                        }
                    } else {
                        addAccessorNode(new GetterAccessor(z3));
                    }
                    obj3 = invoke;
                } catch (IllegalArgumentException e) {
                    if (b.getDeclaringClass().equals(obj)) {
                        try {
                            throw new CompileException("name collision between innerclass: " + Class.forName(b.getDeclaringClass().getName() + "$" + str).getCanonicalName() + "; and bean accessor: " + str + " (" + b.toString() + ")", this.expr, this.tkStart);
                        } catch (ClassNotFoundException unused2) {
                            throw e;
                        }
                    }
                    throw e;
                }
            } else {
                obj3 = null;
            }
            if (yz.d.e()) {
                yz.d.b();
                addAccessorNode(new GetterAccessorNH((Method) b, null));
                if (obj3 == null) {
                    yz.d.b();
                    b.getName();
                    throw null;
                }
            } else {
                addAccessorNode(new GetterAccessor((Method) b));
            }
            this.currType = p.i(((Method) b).getReturnType());
            return obj3;
        }
        if (b != null) {
            Field field = (Field) b;
            if ((field.getModifiers() & 8) != 0) {
                obj2 = field.get(null);
                if (yz.d.e()) {
                    yz.d.a();
                    addAccessorNode(new StaticVarAccessorNH(field, null));
                    if (obj2 == null) {
                        yz.d.a();
                        b.getName();
                        throw null;
                    }
                } else {
                    addAccessorNode(new StaticVarAccessor(field));
                }
            } else {
                obj2 = obj != null ? field.get(obj) : null;
                if (yz.d.e()) {
                    yz.d.a();
                    addAccessorNode(new FieldAccessorNH(field, null));
                    if (obj2 == null) {
                        yz.d.a();
                        b.getName();
                        throw null;
                    }
                } else {
                    addAccessorNode(new FieldAccessor(field));
                }
            }
            this.currType = p.i(field.getType());
            return obj2;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str) || this.nullSafe) {
                addAccessorNode(new MapAccessor(str));
                return map.get(str);
            }
        }
        if (obj != null && "length".equals(str) && obj.getClass().isArray()) {
            addAccessorNode(new ArrayLength());
            return Integer.valueOf(Array.getLength(obj));
        }
        if (AbstractParser.LITERALS.containsKey(str)) {
            Object obj4 = AbstractParser.LITERALS.get(str);
            addAccessorNode(new StaticReferenceAccessor(obj4));
            return obj4;
        }
        Object tryStaticAccess = tryStaticAccess();
        this.staticAccess = true;
        if (tryStaticAccess != null) {
            if (tryStaticAccess instanceof Class) {
                addAccessorNode(new StaticReferenceAccessor(tryStaticAccess));
                return tryStaticAccess;
            }
            if (!(tryStaticAccess instanceof Field)) {
                addAccessorNode(new StaticReferenceAccessor(tryStaticAccess));
                return tryStaticAccess;
            }
            Field field2 = (Field) tryStaticAccess;
            addAccessorNode(new StaticVarAccessor(field2));
            return field2.get(null);
        }
        if (z2) {
            Class cls2 = (Class) obj;
            for (Method method2 : cls2.getMethods()) {
                if (str.equals(method2.getName())) {
                    ParserContext parserContext2 = this.pCtx;
                    if (parserContext2 == null || parserContext2.getParserConfiguration() == null ? !org.mvel2.d.g : !this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                        addAccessorNode(new StaticReferenceAccessor(method2));
                        return method2;
                    }
                    Object invoke2 = method2.invoke(null, m.a);
                    if (yz.d.d()) {
                        yz.d.a();
                        addAccessorNode(new MethodAccessorNH(method2, new ExecutableStatement[0], null));
                        if (invoke2 == null) {
                            yz.d.a();
                            method2.getName();
                            throw null;
                        }
                    } else {
                        addAccessorNode(new MethodAccessor(method2, new ExecutableStatement[0]));
                    }
                    return invoke2;
                }
            }
            try {
                Class D = m.D(this.variableFactory, cls2.getName() + "$" + str, this.pCtx);
                addAccessorNode(new StaticReferenceAccessor(D));
                return D;
            } catch (ClassNotFoundException unused3) {
            }
        } else {
            ParserContext parserContext3 = this.pCtx;
            if (parserContext3 == null || parserContext3.getParserConfiguration() == null ? org.mvel2.d.g : this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                return getMethod(obj, str);
            }
        }
        if (obj == null) {
            throw new PropertyAccessException("unresolvable property or identifier: " + str, this.expr, this.start, this.pCtx);
        }
        throw new PropertyAccessException("could not access: " + str + "; in class: " + obj.getClass().getName(), this.expr, this.start, this.pCtx);
    }

    private Object getBeanPropertyAO(Object obj, String str) throws Exception {
        if (yz.a.a()) {
            yz.a.c(obj, str, this.variableFactory);
            addAccessorNode(new Notify(str));
        }
        return (obj == null || !yz.d.f(obj.getClass())) ? getBeanProperty(obj, str) : propHandler(str, obj, obj.getClass());
    }

    private Object getCollectionProperty(Object obj, String str) throws Exception {
        Integer num;
        boolean z;
        ExecutableStatement executableStatement;
        Object value;
        if (str.length() > 0) {
            obj = getBeanProperty(obj, str);
        }
        this.currType = null;
        if (obj == null) {
            return null;
        }
        int i = this.cursor + 1;
        this.cursor = i;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        String str2 = new String(this.expr, i, this.cursor - i);
        try {
            num = Integer.valueOf(Integer.parseInt(str2));
            z = false;
        } catch (Exception unused) {
            num = null;
            z = true;
        }
        if (z) {
            try {
                executableStatement = (ExecutableStatement) m.J0(str2.toCharArray(), this.pCtx);
                Object obj2 = this.thisRef;
                value = executableStatement.getValue(obj2, obj2, this.variableFactory);
            } catch (CompileException e) {
                e.setExpr(this.expr);
                e.setCursor(i);
                throw e;
            }
        } else {
            value = num;
            executableStatement = null;
        }
        this.cursor++;
        if (obj instanceof Map) {
            if (z) {
                addAccessorNode(new MapAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new MapAccessor(Integer.valueOf(Integer.parseInt(str2))));
            }
            return ((Map) obj).get(value);
        }
        if (obj instanceof List) {
            if (z) {
                addAccessorNode(new ListAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new ListAccessor(Integer.parseInt(str2)));
            }
            return ((List) obj).get(((Integer) value).intValue());
        }
        if (obj.getClass().isArray()) {
            if (z) {
                addAccessorNode(new ArrayAccessorNest(executableStatement));
            } else {
                addAccessorNode(new ArrayAccessor(Integer.parseInt(str2)));
            }
            return Array.get(obj, ((Integer) value).intValue());
        }
        if (obj instanceof CharSequence) {
            if (z) {
                addAccessorNode(new IndexedCharSeqAccessorNest(executableStatement));
            } else {
                addAccessorNode(new IndexedCharSeqAccessor(Integer.parseInt(str2)));
            }
            return Character.valueOf(((CharSequence) obj).charAt(((Integer) value).intValue()));
        }
        if (obj instanceof Class) {
            TypeDescriptor typeDescriptor = new TypeDescriptor(this.expr, this.start, this.length, 0);
            if (typeDescriptor.isArray()) {
                Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
                this.rootNode = new StaticReferenceAccessor(classReference);
                return classReference;
            }
        }
        throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.start);
    }

    private Object getCollectionPropertyAO(Object obj, String str) throws Exception {
        Integer num;
        boolean z;
        Object obj2;
        ExecutableStatement executableStatement;
        if (str.length() > 0) {
            obj = getBeanPropertyAO(obj, str);
        }
        this.currType = null;
        if (obj == null) {
            return null;
        }
        int i = this.cursor + 1;
        this.cursor = i;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        String str2 = new String(this.expr, i, this.cursor - i);
        try {
            num = Integer.valueOf(Integer.parseInt(str2));
            z = false;
        } catch (Exception unused) {
            num = null;
            z = true;
        }
        if (z) {
            executableStatement = (ExecutableStatement) m.J0(str2.toCharArray(), this.pCtx);
            Object obj3 = this.thisRef;
            obj2 = executableStatement.getValue(obj3, obj3, this.variableFactory);
        } else {
            obj2 = num;
            executableStatement = null;
        }
        this.cursor++;
        if (obj instanceof Map) {
            if (yz.d.f(Map.class)) {
                return propHandler(str2, obj, Map.class);
            }
            if (z) {
                addAccessorNode(new MapAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new MapAccessor(Integer.valueOf(Integer.parseInt(str2))));
            }
            return ((Map) obj).get(obj2);
        }
        if (obj instanceof List) {
            if (yz.d.f(List.class)) {
                return propHandler(str2, obj, List.class);
            }
            if (z) {
                addAccessorNode(new ListAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new ListAccessor(Integer.parseInt(str2)));
            }
            return ((List) obj).get(((Integer) obj2).intValue());
        }
        if (obj.getClass().isArray()) {
            if (yz.d.f(Array.class)) {
                return propHandler(str2, obj, Array.class);
            }
            if (z) {
                addAccessorNode(new ArrayAccessorNest(executableStatement));
            } else {
                addAccessorNode(new ArrayAccessor(Integer.parseInt(str2)));
            }
            return Array.get(obj, ((Integer) obj2).intValue());
        }
        if (obj instanceof CharSequence) {
            if (yz.d.f(CharSequence.class)) {
                return propHandler(str2, obj, CharSequence.class);
            }
            if (z) {
                addAccessorNode(new IndexedCharSeqAccessorNest(executableStatement));
            } else {
                addAccessorNode(new IndexedCharSeqAccessor(Integer.parseInt(str2)));
            }
            return Character.valueOf(((CharSequence) obj).charAt(((Integer) obj2).intValue()));
        }
        char[] cArr = this.expr;
        int i2 = this.start;
        TypeDescriptor typeDescriptor = new TypeDescriptor(cArr, i2, this.end - i2, 0);
        if (typeDescriptor.isArray()) {
            Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
            this.rootNode = new StaticReferenceAccessor(classReference);
            return classReference;
        }
        throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.st);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object getMethod(java.lang.Object r14, java.lang.String r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.optimizers.impl.refl.ReflectiveAccessorOptimizer.getMethod(java.lang.Object, java.lang.String):java.lang.Object");
    }

    private Object getMethod(Object obj, String str, Object[] objArr, Class[] clsArr, ExecutableStatement[] executableStatementArr) throws Exception {
        boolean z;
        VariableResolverFactory variableResolverFactory;
        Class<?> cls = obj;
        String str2 = str;
        int i = 0;
        if (this.first && (variableResolverFactory = this.variableFactory) != null && variableResolverFactory.isResolveable(str2)) {
            Object value = this.variableFactory.getVariableResolver(str2).getValue();
            if (value instanceof Method) {
                Method method = (Method) value;
                cls = method.getDeclaringClass();
                str2 = method.getName();
            } else {
                if (!(value instanceof MethodStub)) {
                    if (value instanceof org.mvel2.ast.b) {
                        org.mvel2.ast.b bVar = (org.mvel2.ast.b) value;
                        if (str2.equals(bVar.b().getName())) {
                            addAccessorNode(new FunctionAccessor(bVar, executableStatementArr));
                        } else {
                            getBeanProperty(obj, str);
                            addAccessorNode(new DynamicFunctionAccessor(executableStatementArr));
                        }
                        return bVar.a(cls, this.thisRef, this.variableFactory, objArr);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("attempt to optimize a method call for a reference that does not point to a method: ");
                    sb.append(str2);
                    sb.append(" (reference is type: ");
                    sb.append(cls != null ? obj.getClass().getName() : null);
                    sb.append(")");
                    throw new OptimizationFailure(sb.toString());
                }
                MethodStub methodStub = (MethodStub) value;
                cls = methodStub.getClassReference();
                str2 = methodStub.getMethodName();
            }
            this.first = false;
        }
        if (cls == null && this.currType == null) {
            throw new PropertyAccessException("null pointer or function not found: " + str2, this.expr, this.start, this.pCtx);
        }
        Class<?> cls2 = this.currType;
        if (cls2 != null) {
            z = false;
        } else {
            boolean z2 = cls instanceof Class;
            z = z2;
            cls2 = z2 ? cls : cls.getClass();
        }
        this.currType = null;
        Method K = m.K(clsArr, str2, cls2, cls2.getMethods(), false, z);
        Class<?>[] parameterTypes = K != null ? K.getParameterTypes() : null;
        if (K == null && z) {
            K = m.J(clsArr, str2, cls2, Class.class.getMethods(), false);
            if (K != null) {
                parameterTypes = K.getParameterTypes();
            }
        }
        Class<?>[] clsArr2 = parameterTypes;
        if (K == null && cls != null && cls2 != cls.getClass() && !(cls instanceof Class)) {
            cls2 = cls.getClass();
            K = m.K(clsArr, str2, cls2, cls2.getMethods(), false, z);
            if (K != null) {
                clsArr2 = K.getParameterTypes();
            }
        }
        if (K == null) {
            s sVar = new s();
            if ("size".equals(str2) && objArr.length == 0 && cls2.isArray()) {
                addAccessorNode(new ArrayLength());
                return Integer.valueOf(Array.getLength(cls));
            }
            while (i < objArr.length) {
                Object obj2 = objArr[i];
                sVar.d(obj2 != null ? obj2.getClass().getName() : null);
                if (i < objArr.length - 1) {
                    sVar.d(", ");
                }
                i++;
            }
            throw new PropertyAccessException("unable to resolve method: " + cls2.getName() + "." + str2 + "(" + sVar.toString() + ") [arglength=" + objArr.length + "]", this.expr, this.st, this.pCtx);
        }
        if (executableStatementArr != null) {
            while (i < executableStatementArr.length) {
                ExecutableStatement executableStatement = executableStatementArr[i];
                if (executableStatement.getKnownIngressType() == null) {
                    executableStatement.setKnownIngressType(t.b(clsArr2, i, K.isVarArgs()));
                    executableStatement.computeTypeConversionRule();
                }
                if (!executableStatement.isConvertableIngressEgress()) {
                    objArr[i] = org.mvel2.b.b(objArr[i], t.b(clsArr2, i, K.isVarArgs()));
                }
                i++;
            }
        } else {
            while (i < objArr.length) {
                objArr[i] = org.mvel2.b.b(objArr[i], t.b(clsArr2, i, K.isVarArgs()));
                i++;
            }
        }
        Method U = m.U(cls2, K);
        Object invoke = cls != null ? U.invoke(cls, t.a(clsArr2, objArr, K.isVarArgs())) : null;
        if (yz.d.d()) {
            yz.d.a();
            addAccessorNode(new MethodAccessorNH(U, executableStatementArr, null));
            if (invoke == null) {
                yz.d.a();
                K.getName();
                throw null;
            }
        } else {
            addAccessorNode(new MethodAccessor(U, executableStatementArr));
        }
        this.currType = p.i(U.getReturnType());
        return invoke;
    }

    private AccessorNode getRootNode() {
        return this.rootNode;
    }

    private Object getWithProperty(Object obj) {
        this.currType = null;
        int i = this.start;
        int i2 = this.cursor;
        String trim = i != i2 ? new String(this.expr, i, i2 - 1).trim() : null;
        int i3 = this.cursor;
        int i4 = i3 + 1;
        int e = m.e(this.expr, i3, this.end, '{', this.pCtx);
        ParserContext parserContext = this.pCtx;
        char[] cArr = this.expr;
        this.cursor = e + 1;
        WithAccessor withAccessor = new WithAccessor(parserContext, trim, cArr, i4, e - i4, this.ingressType);
        addAccessorNode(withAccessor);
        return withAccessor.getValue(obj, this.thisRef, this.variableFactory);
    }

    private Object propHandler(String str, Object obj, Class cls) {
        yz.d.c(cls);
        addAccessorNode(new PropertyHandlerAccessor(str, cls, null));
        throw null;
    }

    private void setRootNode(AccessorNode accessorNode) {
        this.currNode = accessorNode;
        this.rootNode = accessorNode;
    }

    @Override // org.mvel2.optimizers.a
    public Class getEgressType() {
        return this.returnType;
    }

    @Override // org.mvel2.optimizers.a
    public Object getResultOptPass() {
        return this.val;
    }

    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) throws Exception {
        return this.rootNode.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.optimizers.a
    public void init() {
    }

    @Override // org.mvel2.optimizers.a
    public boolean isLiteralOnly() {
        return false;
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeAccessor(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z, Class cls) {
        this.currNode = null;
        this.rootNode = null;
        this.expr = cArr;
        this.start = i;
        int i3 = i2 + i;
        this.end = i3;
        this.length = i3 - i;
        this.first = true;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.ingressType = cls;
        this.pCtx = parserContext;
        return compileGetChain();
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeCollection(ParserContext parserContext, Object obj, Class cls, char[] cArr, int i, int i2, Object obj2, Object obj3, VariableResolverFactory variableResolverFactory) {
        this.cursor = i;
        this.start = i;
        this.length = i + i2;
        this.returnType = cls;
        this.ctx = obj2;
        this.variableFactory = variableResolverFactory;
        this.pCtx = parserContext;
        org.mvel2.compiler.a _getAccessor = _getAccessor(obj, cls);
        return (cArr == null || this.length <= i) ? _getAccessor : new org.mvel2.optimizers.impl.refl.nodes.a(parserContext, _getAccessor, cArr, this.cursor, i2);
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeObjectCreation(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        this.length = i2 + i;
        this.start = i;
        this.cursor = i;
        this.pCtx = parserContext;
        try {
            return compileConstructor(cArr, obj, variableResolverFactory);
        } catch (ClassNotFoundException e) {
            throw new CompileException("could not resolve class: " + e.getMessage(), cArr, this.start, e);
        } catch (CompileException e3) {
            throw f.a(e3, cArr, this.start);
        } catch (Exception e4) {
            throw new CompileException("could not create constructor: " + e4.getMessage(), cArr, this.start, e4);
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeSetAccessor(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z, Object obj3, Class cls) {
        char[] cArr2;
        Class cls2 = null;
        this.currNode = null;
        this.rootNode = null;
        this.expr = cArr;
        this.start = i;
        this.first = true;
        this.length = i + i2;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.ingressType = cls;
        int findLastUnion = findLastUnion();
        this.pCtx = parserContext;
        PropertyVerifier propertyVerifier = new PropertyVerifier(cArr, parserContext);
        if (findLastUnion != -1) {
            int i3 = findLastUnion + 1;
            cArr2 = m.K0(cArr, 0, findLastUnion);
            cArr = m.K0(cArr, i3, cArr.length - i3);
        } else {
            cArr2 = null;
        }
        if (cArr2 != null) {
            this.expr = cArr2;
            int length = cArr2.length;
            this.end = length;
            this.length = length;
            compileGetChain();
            obj = this.val;
        }
        if (obj == null) {
            throw new PropertyAccessException("could not access property: " + new String(cArr, this.start, Math.min(this.length, cArr.length)) + "; parent is null: " + new String(this.expr), this.expr, this.start, parserContext);
        }
        try {
            this.expr = cArr;
            int length2 = cArr.length;
            this.end = length2;
            this.length = length2;
            this.cursor = 0;
            skipWhitespace();
            if (this.collection) {
                int i4 = this.cursor;
                if (i4 == this.end) {
                    throw new PropertyAccessException("unterminated '['", this.expr, this.start, parserContext);
                }
                if (scanTo(']')) {
                    throw new PropertyAccessException("unterminated '['", this.expr, this.start, parserContext);
                }
                String str = new String(cArr, i4, this.cursor - i4);
                if (obj instanceof Map) {
                    if (org.mvel2.d.h && yz.d.f(Map.class)) {
                        propHandlerSet(str, obj, Map.class, obj3);
                    } else {
                        Map map = (Map) obj;
                        Object l = org.mvel2.d.l(str, obj, this.variableFactory);
                        Class analyze = propertyVerifier.analyze();
                        this.returnType = analyze;
                        map.put(l, org.mvel2.b.b(obj3, analyze));
                        addAccessorNode(new MapAccessorNest(str, this.returnType));
                    }
                    return this.rootNode;
                }
                if (obj instanceof List) {
                    if (org.mvel2.d.h && yz.d.f(List.class)) {
                        propHandlerSet(str, obj, List.class, obj3);
                    } else {
                        List list = (List) obj;
                        int intValue = ((Integer) org.mvel2.d.m(str, obj, this.variableFactory, Integer.class)).intValue();
                        Class analyze2 = propertyVerifier.analyze();
                        this.returnType = analyze2;
                        list.set(intValue, org.mvel2.b.b(obj3, analyze2));
                        addAccessorNode(new ListAccessorNest(str, this.returnType));
                    }
                    return this.rootNode;
                }
                if (org.mvel2.d.h && yz.d.f(obj.getClass())) {
                    propHandlerSet(str, obj, obj.getClass(), obj3);
                    return this.rootNode;
                }
                if (obj.getClass().isArray()) {
                    if (org.mvel2.d.h && yz.d.f(Array.class)) {
                        propHandlerSet(str, obj, Array.class, obj3);
                    } else {
                        Array.set(obj, ((Integer) org.mvel2.d.m(str, obj, this.variableFactory, Integer.class)).intValue(), org.mvel2.b.b(obj3, m.I(obj.getClass())));
                        addAccessorNode(new ArrayAccessorNest(str));
                    }
                    return this.rootNode;
                }
                throw new PropertyAccessException("cannot bind to collection property: " + new String(cArr) + ": not a recognized collection type: " + obj.getClass(), this.expr, this.st, parserContext);
            }
            if (org.mvel2.d.h && yz.d.f(obj.getClass())) {
                propHandlerSet(new String(cArr), obj, obj.getClass(), obj3);
                return this.rootNode;
            }
            String trim = new String(cArr, 0, this.length).trim();
            if (yz.a.b()) {
                yz.a.d(obj, trim, this.variableFactory, obj3);
                addAccessorNode(new Notify(trim));
            }
            Class<?> cls3 = obj.getClass();
            if (obj3 != null) {
                cls2 = cls;
            }
            Member d = n.d(cls3, trim, cls2);
            if (d instanceof Field) {
                Field field = (Field) d;
                if (obj3 == null || field.getType().isAssignableFrom(obj3.getClass())) {
                    if (obj3 == null && field.getType().isPrimitive()) {
                        field.set(obj, n.g(field.getType()));
                        addAccessorNode(new FieldAccessor(field));
                    } else {
                        field.set(obj, obj3);
                        addAccessorNode(new FieldAccessor(field));
                    }
                } else {
                    if (!org.mvel2.b.a(field.getType(), obj3.getClass())) {
                        throw new CompileException("cannot convert type: " + obj3.getClass() + ": to " + field.getType(), this.expr, this.start);
                    }
                    field.set(obj, org.mvel2.b.b(obj3, field.getType()));
                    addAccessorNode(new DynamicFieldAccessor(field));
                }
            } else if (d != null) {
                Method method = (Method) d;
                if (obj3 == null || method.getParameterTypes()[0].isAssignableFrom(obj3.getClass())) {
                    if (obj3 == null && method.getParameterTypes()[0].isPrimitive()) {
                        method.invoke(obj, n.g(method.getParameterTypes()[0]));
                    } else {
                        method.invoke(obj, obj3);
                    }
                } else {
                    if (!org.mvel2.b.a(method.getParameterTypes()[0], obj3.getClass())) {
                        throw new CompileException("cannot convert type: " + obj3.getClass() + ": to " + method.getParameterTypes()[0], this.expr, this.start);
                    }
                    method.invoke(obj, org.mvel2.b.b(obj3, method.getParameterTypes()[0]));
                }
                addAccessorNode(new SetterAccessor(method));
            } else {
                if (!(obj instanceof Map)) {
                    throw new PropertyAccessException("could not access property (" + trim + ") in: " + cls.getName(), this.expr, this.start, parserContext);
                }
                ((Map) obj).put(trim, obj3);
                addAccessorNode(new MapAccessor(trim));
            }
            return this.rootNode;
        } catch (IllegalAccessException e) {
            throw new PropertyAccessException("could not access property: " + new String(cArr), this.expr, this.st, e, parserContext);
        } catch (IllegalArgumentException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("error binding property: ");
            sb.append(new String(cArr));
            sb.append(" (value <<");
            sb.append(obj3);
            sb.append(">>::");
            sb.append(obj3 == null ? "null" : obj3.getClass().getCanonicalName());
            sb.append(")");
            throw new PropertyAccessException(sb.toString(), this.expr, this.st, e3, parserContext);
        } catch (InvocationTargetException e4) {
            throw new PropertyAccessException("could not access property: " + new String(cArr), this.expr, this.st, e4, parserContext);
        }
    }

    public void propHandlerSet(String str, Object obj, Class cls, Object obj2) {
        yz.d.c(cls);
        addAccessorNode(new PropertyHandlerAccessor(str, cls, null));
        throw null;
    }
}
