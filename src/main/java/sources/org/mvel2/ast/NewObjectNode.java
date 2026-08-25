package org.mvel2.ast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.compiler.PropertyVerifier;
import org.mvel2.g;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.e;
import org.mvel2.util.f;
import org.mvel2.util.m;
import org.mvel2.util.p;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class NewObjectNode extends ASTNode {
    private char[] name;
    private transient org.mvel2.compiler.a newObjectOptimizer;
    private TypeDescriptor typeDescr;
    private static final Logger LOG = Logger.getLogger(NewObjectNode.class.getName());
    private static final Class[] EMPTYCLS = new Class[0];

    public static class NewObjectArray implements org.mvel2.compiler.a, Serializable {
        private Class arrayType;
        private ExecutableStatement[] sizes;

        public NewObjectArray(Class cls, ExecutableStatement[] executableStatementArr) {
            this.arrayType = cls;
            this.sizes = executableStatementArr;
        }

        @Override // org.mvel2.compiler.a
        public Class getKnownEgressType() {
            try {
                return Class.forName("[L" + this.arrayType.getName() + ";");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        @Override // org.mvel2.compiler.a
        public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
            int length = this.sizes.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = ((Integer) org.mvel2.b.b(this.sizes[i].getValue(obj, obj2, variableResolverFactory), Integer.class)).intValue();
            }
            return Array.newInstance((Class<?>) this.arrayType, iArr);
        }

        @Override // org.mvel2.compiler.a
        public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
            return null;
        }
    }

    public NewObjectNode(TypeDescriptor typeDescriptor, int i, ParserContext parserContext) {
        super(parserContext);
        this.typeDescr = typeDescriptor;
        this.fields = i;
        this.expr = typeDescriptor.getExpr();
        this.start = typeDescriptor.getStart();
        int offset = typeDescriptor.getOffset();
        this.offset = offset;
        char[] cArr = this.expr;
        if (offset < cArr.length) {
            int i2 = this.start;
            this.name = m.F0(cArr, i2, offset + i2);
        } else {
            this.name = cArr;
        }
        if ((i & 16) != 0) {
            if (parserContext == null || !parserContext.hasImport(typeDescriptor.getClassName())) {
                try {
                    this.egressType = Class.forName(typeDescriptor.getClassName(), true, getClassLoader());
                } catch (ClassNotFoundException unused) {
                    if (parserContext.isStrongTyping()) {
                        parserContext.addError(new org.mvel2.c(this.expr, this.start, true, "could not resolve class: " + typeDescriptor.getClassName()));
                        return;
                    }
                    return;
                }
            } else {
                parserContext.setAllowBootstrapBypass(false);
                this.egressType = parserContext.getImport(typeDescriptor.getClassName());
            }
            if (this.egressType != null) {
                rewriteClassReferenceToFQCN(i);
                if (typeDescriptor.isArray()) {
                    try {
                        this.egressType = this.egressType.isPrimitive() ? p.j(this.egressType) : m.D(null, m.A0('[', typeDescriptor.getArrayLength()) + "L" + this.egressType.getName() + ";", parserContext);
                    } catch (Exception e) {
                        LOG.log(Level.WARNING, "", (Throwable) e);
                    }
                }
            }
            if (parserContext != null) {
                if (this.egressType == null) {
                    parserContext.addError(new org.mvel2.c(this.expr, this.start, true, "could not resolve class: " + typeDescriptor.getClassName()));
                    return;
                }
                if (typeDescriptor.isArray()) {
                    return;
                }
                String[] g = m.g(this.expr, this.start, this.offset);
                List w0 = m.w0(g[0].toCharArray());
                int size = w0.size();
                Class[] clsArr = new Class[size];
                for (int i3 = 0; i3 < size; i3++) {
                    clsArr[i3] = org.mvel2.d.c((char[]) w0.get(i3), parserContext);
                }
                if (m.M(clsArr, this.egressType, true) == null && parserContext.isStrongTyping()) {
                    parserContext.addError(new org.mvel2.c(this.expr, this.start, parserContext.isStrongTyping(), "could not resolve constructor " + typeDescriptor.getClassName() + Arrays.toString(clsArr)));
                }
                if (g.length == 2) {
                    String trim = g[1].trim();
                    if (trim.length() == 0) {
                        return;
                    }
                    this.egressType = new PropertyVerifier(trim, parserContext, this.egressType).analyze();
                }
            }
        }
    }

    private Object createPrototypalObject(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return this.pCtx.getFunction(this.typeDescr.getClassName()).getReducedValueAccelerated(obj, obj2, variableResolverFactory);
    }

    private boolean isPrototypeFunction() {
        return this.pCtx.getFunctions().containsKey(this.typeDescr.getClassName());
    }

    private void rewriteClassReferenceToFQCN(int i) {
        String name = this.egressType.getName();
        if (this.typeDescr.getClassName().indexOf(46) == -1) {
            char[] cArr = this.name;
            int a = org.mvel2.util.b.a('(', 0, cArr.length, cArr);
            char[] charArray = name.toCharArray();
            if (a == -1) {
                int length = charArray.length;
                this.name = new char[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.name[i2] = charArray[i2];
                }
            } else {
                char[] cArr2 = new char[charArray.length + (this.name.length - a)];
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    cArr2[i3] = charArray[i3];
                }
                int length2 = this.name.length - a;
                int length3 = charArray.length;
                for (int i4 = 0; i4 < length2; i4++) {
                    cArr2[i4 + length3] = this.name[i4 + a];
                }
                this.name = cArr2;
            }
            TypeDescriptor typeDescriptor = this.typeDescr;
            char[] cArr3 = this.name;
            typeDescriptor.updateClassName(cArr3, 0, cArr3.length, i);
        }
    }

    public org.mvel2.compiler.a getNewObjectOptimizer() {
        return this.newObjectOptimizer;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            int i = 0;
            if (this.typeDescr.isArray()) {
                Class D = m.D(variableResolverFactory, this.typeDescr.getClassName(), this.pCtx);
                int arrayLength = this.typeDescr.getArrayLength();
                int[] iArr = new int[arrayLength];
                ArraySize[] arraySize = this.typeDescr.getArraySize();
                while (i < arrayLength) {
                    iArr[i] = ((Integer) org.mvel2.b.b(org.mvel2.d.q(arraySize[i].value, obj, variableResolverFactory), Integer.class)).intValue();
                    i++;
                }
                return Array.newInstance((Class<?>) D, iArr);
            }
            char[] cArr = this.name;
            String[] g = m.g(cArr, 0, cArr.length);
            List w0 = m.w0(g[0].toCharArray());
            if (w0 == null) {
                Constructor<?> constructor = Class.forName(this.typeDescr.getClassName(), true, this.pCtx.getParserConfiguration().getClassLoader()).getConstructor(EMPTYCLS);
                return g.length > 1 ? g.l(g[1], constructor.newInstance(null), variableResolverFactory, obj2, this.pCtx) : constructor.newInstance(null);
            }
            char[] cArr2 = this.name;
            Class D2 = m.D(variableResolverFactory, new String(m.K0(cArr2, 0, org.mvel2.util.b.a('(', 0, cArr2.length, cArr2))).trim(), this.pCtx);
            int size = w0.size();
            Object[] objArr = new Object[size];
            for (int i2 = 0; i2 < w0.size(); i2++) {
                objArr[i2] = org.mvel2.d.q((char[]) w0.get(i2), obj, variableResolverFactory);
            }
            Constructor N = m.N(objArr, D2, false);
            if (N != null) {
                while (i < size) {
                    objArr[i] = org.mvel2.b.b(objArr[i], N.getParameterTypes()[i]);
                    i++;
                }
                return g.length > 1 ? g.l(g[1], N.newInstance(objArr), variableResolverFactory, obj2, this.pCtx) : N.newInstance(objArr);
            }
            throw new CompileException("unable to find constructor for: " + D2.getName(), this.expr, this.start);
        } catch (ClassNotFoundException e) {
            throw new CompileException("unable to resolve class: " + e.getMessage(), this.expr, this.start, e);
        } catch (NoSuchMethodException e3) {
            throw new CompileException("cannot resolve constructor: " + e3.getMessage(), this.expr, this.start, e3);
        } catch (CompileException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new CompileException("could not instantiate class: " + e5.getMessage(), this.expr, this.start, e5);
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (this.newObjectOptimizer == null) {
            if (this.egressType == null && variableResolverFactory != null && variableResolverFactory.isResolveable(this.typeDescr.getClassName())) {
                try {
                    this.egressType = (Class) variableResolverFactory.getVariableResolver(this.typeDescr.getClassName()).getValue();
                    rewriteClassReferenceToFQCN(16);
                    if (this.typeDescr.isArray()) {
                        try {
                            this.egressType = m.D(variableResolverFactory, m.A0('[', this.typeDescr.getArrayLength()) + "L" + this.egressType.getName() + ";", this.pCtx);
                        } catch (Exception unused) {
                        }
                    }
                } catch (ClassCastException e) {
                    throw new CompileException("cannot construct object: " + this.typeDescr.getClassName() + " is not a class reference", this.expr, this.start, e);
                }
            }
            if (this.typeDescr.isArray()) {
                NewObjectArray newObjectArray = new NewObjectArray(m.I(this.egressType.getComponentType()), this.typeDescr.getCompiledArraySize());
                this.newObjectOptimizer = newObjectArray;
                return newObjectArray.getValue(obj, obj2, variableResolverFactory);
            }
            try {
                try {
                    org.mvel2.optimizers.a d = org.mvel2.optimizers.b.d();
                    ParserContext parserContext = this.pCtx;
                    if (parserContext == null) {
                        parserContext = new ParserContext();
                        parserContext.getParserConfiguration().setAllImports(e.e(variableResolverFactory));
                    }
                    ParserContext parserContext2 = parserContext;
                    char[] cArr = this.name;
                    this.newObjectOptimizer = d.optimizeObjectCreation(parserContext2, cArr, 0, cArr.length, obj, obj2, variableResolverFactory);
                    if (d.getResultOptPass() != null) {
                        this.egressType = d.getEgressType();
                        Object resultOptPass = d.getResultOptPass();
                        org.mvel2.optimizers.b.a();
                        return resultOptPass;
                    }
                    org.mvel2.optimizers.b.a();
                } catch (CompileException e3) {
                    throw f.a(e3, this.expr, this.start);
                }
            } catch (Throwable th) {
                org.mvel2.optimizers.b.a();
                throw th;
            }
        }
        return this.newObjectOptimizer.getValue(obj, obj2, variableResolverFactory);
    }

    public TypeDescriptor getTypeDescr() {
        return this.typeDescr;
    }
}
