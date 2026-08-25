package org.mvel2.util;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.mvel2.CompileException;
import org.mvel2.OptimizationFailure;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.BlankLiteral;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.compiler.ExecutableAccessor;
import org.mvel2.compiler.ExecutableAccessorSafe;
import org.mvel2.compiler.ExecutableLiteral;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ClassImportResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class m {
    public static final Object[] a = new Object[0];
    public static final Class[] b = new Class[0];
    private static final Map c = Collections.synchronizedMap(new WeakHashMap(10));
    private static final Map d = Collections.synchronizedMap(new WeakHashMap(1, 1.0f));
    private static final Map e = Collections.synchronizedMap(new WeakHashMap(10));
    private static final HashMap f;
    private static final Map g;

    static {
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put(BigDecimal.class, 110);
        hashMap.put(BigInteger.class, 111);
        hashMap.put(String.class, 1);
        Class cls = Integer.TYPE;
        hashMap.put(cls, 101);
        hashMap.put(Integer.class, 106);
        Class cls2 = Short.TYPE;
        hashMap.put(cls2, 100);
        hashMap.put(Short.class, 105);
        Class cls3 = Float.TYPE;
        hashMap.put(cls3, 104);
        hashMap.put(Float.class, 108);
        Class cls4 = Double.TYPE;
        hashMap.put(cls4, 103);
        hashMap.put(Double.class, 109);
        Class cls5 = Long.TYPE;
        hashMap.put(cls5, 102);
        hashMap.put(Long.class, 107);
        Class cls6 = Boolean.TYPE;
        hashMap.put(cls6, 7);
        hashMap.put(Boolean.class, 15);
        Class cls7 = Byte.TYPE;
        hashMap.put(cls7, 9);
        hashMap.put(Byte.class, 113);
        Class cls8 = Character.TYPE;
        hashMap.put(cls8, 8);
        hashMap.put(Character.class, 112);
        hashMap.put(BlankLiteral.class, 200);
        HashMap hashMap2 = new HashMap(30, 0.5f);
        g = hashMap2;
        hashMap2.put(Integer.class, 106);
        hashMap2.put(Double.class, 109);
        hashMap2.put(Boolean.class, 15);
        hashMap2.put(String.class, 1);
        hashMap2.put(Long.class, 107);
        hashMap2.put(Short.class, 105);
        hashMap2.put(Float.class, 108);
        hashMap2.put(Byte.class, 113);
        hashMap2.put(Character.class, 112);
        hashMap2.put(BigDecimal.class, 110);
        hashMap2.put(BigInteger.class, 111);
        hashMap2.put(InternalNumber.class, 110);
        hashMap2.put(cls, 101);
        hashMap2.put(cls4, 103);
        hashMap2.put(cls6, 7);
        hashMap2.put(cls5, 102);
        hashMap2.put(cls2, 100);
        hashMap2.put(cls3, 104);
        hashMap2.put(cls7, 9);
        hashMap2.put(cls8, 8);
        hashMap2.put(BlankLiteral.class, 200);
    }

    public static boolean A(char[] cArr, int i, int i2, char[] cArr2) {
        if (cArr2.length > cArr.length) {
            return false;
        }
        int length = cArr2.length - 1;
        int i3 = (i + i2) - 1;
        while (length >= 0) {
            int i4 = i3 - 1;
            int i6 = length - 1;
            if (cArr[i3] != cArr2[length]) {
                return false;
            }
            i3 = i4;
            length = i6;
        }
        return true;
    }

    public static String A0(char c2, int i) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = c2;
        }
        return new String(cArr);
    }

    public static int B(char[] cArr, int i, int i2, char c2) {
        int i3 = i2 + i;
        while (i < i3) {
            if (cArr[i] == c2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int B0(Object obj) {
        if (obj == null) {
            return 0;
        }
        return a(obj.getClass());
    }

    public static int C(char[] cArr) {
        int i = 0;
        for (int length = cArr.length - 1; length >= 0; length--) {
            char c2 = cArr[length];
            if (c2 == ']') {
                i++;
            }
            if (c2 == '[') {
                i--;
            }
            if ((i == 0 && c2 == '.') || c2 == '[') {
                return length;
            }
        }
        return -1;
    }

    public static int C0(Class cls, Class cls2) {
        Class<?>[] interfaces;
        if (cls.isInterface() && (interfaces = cls2.getInterfaces()) != null) {
            for (Class<?> cls3 : interfaces) {
                if (cls3 == cls) {
                    return 1;
                }
                if (cls.isAssignableFrom(cls3)) {
                    return C0(cls, cls2.getSuperclass());
                }
            }
        }
        return 0;
    }

    public static Class D(VariableResolverFactory variableResolverFactory, String str, ParserContext parserContext) {
        try {
            return AbstractParser.LITERALS.containsKey(str) ? (Class) AbstractParser.LITERALS.get(str) : (variableResolverFactory == null || !variableResolverFactory.isResolveable(str)) ? (parserContext == null || !parserContext.hasImport(str)) ? v(str, parserContext) : parserContext.getImport(str) : (Class) variableResolverFactory.getVariableResolver(str).getValue();
        } catch (ClassNotFoundException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException("class not found: " + str, e4);
        }
    }

    public static float D0(String str, String str2) {
        float length;
        float f2 = 0.0f;
        if (str == null || str2 == null) {
            return (str == null && str2 == null) ? 1.0f : 0.0f;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        if (charArray.length > charArray2.length) {
            length = charArray.length;
        } else {
            length = charArray2.length;
            charArray2 = charArray;
            charArray = charArray2;
        }
        for (int i = 0; i < charArray.length && i < charArray2.length; i++) {
            if (charArray[i] == charArray2[i]) {
                f2 += 1.0f;
            }
        }
        return f2 / length;
    }

    public static ClassImportResolverFactory E(VariableResolverFactory variableResolverFactory, ParserContext parserContext) {
        if (variableResolverFactory == null) {
            throw new OptimizationFailure("unable to import classes.  no variable resolver factory available.");
        }
        for (VariableResolverFactory variableResolverFactory2 = variableResolverFactory; variableResolverFactory2 != null; variableResolverFactory2 = variableResolverFactory2.getNextFactory()) {
            if (variableResolverFactory2 instanceof ClassImportResolverFactory) {
                return (ClassImportResolverFactory) variableResolverFactory2;
            }
        }
        return (ClassImportResolverFactory) yz.e.a(variableResolverFactory, new ClassImportResolverFactory(null, null, false));
    }

    public static int E0(char[] cArr, int i) {
        int i2;
        while (i != cArr.length) {
            char c2 = cArr[i];
            if (c2 != '\n' && c2 != '\r') {
                if (c2 != '/' || (i2 = i + 1) == cArr.length) {
                    if (!q0(c2)) {
                        break;
                    }
                } else {
                    char c3 = cArr[i2];
                    if (c3 == '*') {
                        int length = cArr.length - 1;
                        cArr[i] = ' ';
                        i = i2;
                        while (i != length && (cArr[i] != '*' || cArr[i + 1] != '/')) {
                            cArr[i] = ' ';
                            i++;
                        }
                        if (i != length) {
                            cArr[i + 1] = ' ';
                            cArr[i] = ' ';
                            i += 2;
                        }
                    } else {
                        if (c3 != '/') {
                            break;
                        }
                        cArr[i] = ' ';
                        i = i2;
                        while (i != cArr.length && cArr[i] != '\n') {
                            cArr[i] = ' ';
                            i++;
                        }
                        if (i != cArr.length) {
                            cArr[i] = ' ';
                            i++;
                        }
                    }
                }
            }
            i++;
        }
        return i;
    }

    public static Class F(String str, ClassLoader classLoader, ClassNotFoundException classNotFoundException) {
        while (true) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf <= 0) {
                throw classNotFoundException;
            }
            str = str.substring(0, lastIndexOf) + "$" + str.substring(lastIndexOf + 1);
            try {
                return classLoader.loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static char[] F0(char[] cArr, int i, int i2) {
        if (i >= i2) {
            return new char[0];
        }
        int i3 = i2 - i;
        char[] cArr2 = new char[i3];
        for (int i4 = 0; i4 != i3; i4++) {
            cArr2[i4] = cArr[i4 + i];
        }
        return cArr2;
    }

    public static int G(char[] cArr, int i, int i2, char c2) {
        for (int i3 = i2 + i; i3 >= i; i3--) {
            if (cArr[i3] == c2) {
                return i3;
            }
        }
        return -1;
    }

    public static Serializable G0(String str, ParserContext parserContext) {
        return b(new ExpressionCompiler(str, parserContext)._compile());
    }

    public static Class H(String str, ClassLoader classLoader) {
        try {
            return classLoader.loadClass(str);
        } catch (ClassNotFoundException e3) {
            return F(str, classLoader, e3);
        }
    }

    public static Serializable H0(char[] cArr) {
        return b(new ExpressionCompiler(cArr)._compile());
    }

    public static Class I(Class cls) {
        while (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return cls;
    }

    public static Serializable I0(char[] cArr, int i, int i2, ParserContext parserContext) {
        return b(new ExpressionCompiler(cArr, i, i2, parserContext)._compile());
    }

    public static Method J(Class[] clsArr, String str, Class cls, Method[] methodArr, boolean z) {
        return K(clsArr, str, cls, methodArr, z, false);
    }

    public static Serializable J0(char[] cArr, ParserContext parserContext) {
        return b(new ExpressionCompiler(cArr, parserContext)._compile());
    }

    public static Method K(Class[] clsArr, String str, Class cls, Method[] methodArr, boolean z, boolean z2) {
        int S;
        Method method = null;
        if (methodArr.length == 0) {
            return null;
        }
        int i = -1;
        boolean z3 = false;
        while (true) {
            for (Method method2 : methodArr) {
                if ((!z2 || Modifier.isStatic(method2.getModifiers())) && str.equals(method2.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    if (parameterTypes.length == 0 && clsArr.length == 0) {
                        if (method != null && !e0(method2, method)) {
                        }
                        method = method2;
                    } else {
                        boolean isVarArgs = method2.isVarArgs();
                        if (!Z(clsArr, parameterTypes, isVarArgs) && (S = S(clsArr, z, parameterTypes, isVarArgs)) != 0) {
                            if (S > i) {
                                method = method2;
                                i = S;
                            } else if (S == i) {
                                if (e0(method2, method)) {
                                    if (isVarArgs) {
                                    }
                                    method = method2;
                                }
                            }
                        }
                    }
                }
            }
            if (method == null && !z3 && cls.isInterface()) {
                Method[] methods = Object.class.getMethods();
                Method[] methodArr2 = new Method[methodArr.length + methods.length];
                for (int i2 = 0; i2 < methodArr.length; i2++) {
                    methodArr2[i2] = methodArr[i2];
                }
                for (int i3 = 0; i3 < methods.length; i3++) {
                    methodArr2[methodArr.length + i3] = methods[i3];
                }
                z3 = true;
                methodArr = methodArr2;
            }
        }
        return method;
    }

    public static char[] K0(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr2[i3] = cArr[i3 + i];
        }
        return cArr2;
    }

    public static Method L(Object[] objArr, String str, Class cls, Method[] methodArr, boolean z) {
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj != null ? obj.getClass() : null;
        }
        return J(clsArr, str, cls, methodArr, z);
    }

    public static char[] L0(char[] cArr, int i, int i2) {
        if (i2 <= 0) {
            return new char[0];
        }
        int i3 = i2 + i;
        while (i3 > 0 && q0(cArr[i3 - 1])) {
            i3--;
        }
        while (q0(cArr[i]) && i < i3) {
            i++;
        }
        int i4 = i3 - i;
        return i4 == 0 ? new char[0] : K0(cArr, i, i4);
    }

    public static Constructor M(Class[] clsArr, Class cls, boolean z) {
        Constructor constructor = null;
        int i = 0;
        for (Constructor constructor2 : P(cls)) {
            boolean isVarArgs = constructor2.isVarArgs();
            Class[] O = O(constructor2);
            if (!Z(clsArr, O, isVarArgs)) {
                if (clsArr.length == 0 && O.length == 0) {
                    return constructor2;
                }
                int S = S(clsArr, z, O, isVarArgs);
                if (S != 0 && S > i) {
                    constructor = constructor2;
                    i = S;
                }
            }
        }
        return constructor;
    }

    public static int M0(char[] cArr, int i, int i2) {
        if (i2 > cArr.length) {
            i2 = cArr.length;
        }
        while (i2 != 0 && i2 >= i && q0(cArr[i2 - 1])) {
            i2--;
        }
        return i2;
    }

    public static Constructor N(Object[] objArr, Class cls, boolean z) {
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null) {
                clsArr[i] = obj.getClass();
            }
        }
        return M(clsArr, cls, z);
    }

    public static int N0(char[] cArr, int i) {
        while (i != cArr.length && q0(cArr[i])) {
            i++;
        }
        return i;
    }

    private static Class[] O(Constructor constructor) {
        Class[] clsArr;
        Map map = c;
        WeakReference weakReference = (WeakReference) map.get(constructor);
        if (weakReference != null && (clsArr = (Class[]) weakReference.get()) != null) {
            return clsArr;
        }
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        map.put(constructor, new WeakReference(parameterTypes));
        return parameterTypes;
    }

    public static Class O0(Class cls) {
        return (cls == Integer.class || cls == Integer.TYPE) ? Integer.TYPE : (cls == Integer[].class || cls == int[].class) ? int[].class : (cls == Long.class || cls == Long.TYPE) ? Long.TYPE : (cls == Long[].class || cls == long[].class) ? long[].class : (cls == Character.class || cls == Character.TYPE) ? Character.TYPE : (cls == Character[].class || cls == char[].class) ? char[].class : (cls == Short.class || cls == Short.TYPE) ? Short.TYPE : (cls == Short[].class || cls == short[].class) ? short[].class : (cls == Double.class || cls == Double.TYPE) ? Double.TYPE : (cls == Double[].class || cls == double[].class) ? double[].class : (cls == Float.class || cls == Float.TYPE) ? Float.TYPE : (cls == Float[].class || cls == float[].class) ? float[].class : (cls == Boolean.class || cls == Boolean.TYPE) ? Boolean.TYPE : (cls == Boolean[].class || cls == boolean[].class) ? boolean[].class : (cls == Byte.class || cls == Byte.TYPE) ? Byte.TYPE : (cls == Byte[].class || cls == byte[].class) ? byte[].class : cls;
    }

    public static Constructor[] P(Class cls) {
        Constructor[] constructorArr;
        Map map = e;
        WeakReference weakReference = (WeakReference) map.get(cls);
        if (weakReference != null && (constructorArr = (Constructor[]) weakReference.get()) != null) {
            return constructorArr;
        }
        Constructor<?>[] constructors = cls.getConstructors();
        map.put(cls, new WeakReference(constructors));
        return constructors;
    }

    public static FileWriter Q() {
        return new FileWriter(new File(org.mvel2.d.u()), true);
    }

    public static Method R(String str, Class[] clsArr, Class cls, Class cls2) {
        for (Method method : cls2.getMethods()) {
            if (str.equals(method.getName()) && cls == method.getReturnType()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (parameterTypes[i] != clsArr[i]) {
                            break;
                        }
                    }
                    return method;
                }
                continue;
            }
        }
        return null;
    }

    private static int S(Class[] clsArr, boolean z, Class[] clsArr2, boolean z2) {
        Class cls;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 == clsArr.length) {
                i = i3;
                break;
            }
            Class componentType = (!z2 || i2 < clsArr2.length + (-1)) ? clsArr2[i2] : clsArr2[clsArr2.length - 1].getComponentType();
            Class cls2 = clsArr[i2];
            if (cls2 == null) {
                if (componentType.isPrimitive()) {
                    break;
                }
                i3 += 7;
            } else if (componentType == cls2) {
                i3 += 8;
            } else {
                if ((!componentType.isPrimitive() || f(componentType) != clsArr[i2]) && (!clsArr[i2].isPrimitive() || O0(clsArr[i2]) != componentType)) {
                    if (componentType.isAssignableFrom(clsArr[i2])) {
                        i3 += 6;
                    } else if (l0(clsArr[i2], componentType)) {
                        i3 += 5;
                    } else if (k0(clsArr[i2], componentType)) {
                        i3 += 4;
                    } else if (!f(componentType).isAssignableFrom(f(clsArr[i2])) || Object.class == (cls = clsArr[i2])) {
                        if (z || !org.mvel2.b.a(componentType, clsArr[i2])) {
                            if (componentType != Object.class && clsArr[i2] != l.class) {
                                break;
                            }
                        } else if ((componentType.isArray() && clsArr[i2].isArray()) || (componentType == Character.TYPE && clsArr[i2] == String.class)) {
                            i3++;
                        }
                        i3++;
                    } else {
                        i3 += C0(componentType, cls) + 3;
                    }
                }
                i3 += 7;
            }
            i2++;
        }
        return (i == 0 && z2 && clsArr2.length + (-1) == clsArr.length) ? i + 3 : i;
    }

    public static Class T(Class cls) {
        return cls.isArray() ? cls.getComponentType() : cls;
    }

    public static Method U(Class cls, Method method) {
        if (Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        Method method2 = method;
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Class<?> cls3 : cls2.getInterfaces()) {
                Method R = R(name, parameterTypes, returnType, cls3);
                if (R != null) {
                    method2 = R;
                }
            }
        }
        if (method2 != method) {
            return method2;
        }
        while (cls != null) {
            Method R2 = R(name, parameterTypes, returnType, cls);
            if (R2 != null) {
                method2 = R2;
            }
            cls = cls.getSuperclass();
        }
        return method2;
    }

    public static Method V(Method method) {
        return U(method.getDeclaringClass(), method);
    }

    public static int W(char[] cArr, int i) {
        char c2;
        int i2;
        int i3 = i - 1;
        cArr[i3] = 0;
        char c3 = cArr[i];
        if (c3 == '\"') {
            cArr[i] = '\"';
            return 1;
        }
        if (c3 == '\'') {
            cArr[i] = '\'';
            return 1;
        }
        if (c3 == '\\') {
            cArr[i] = '\\';
            return 1;
        }
        if (c3 == 'b') {
            cArr[i] = '\b';
            return 1;
        }
        if (c3 == 'f') {
            cArr[i] = '\f';
            return 1;
        }
        if (c3 == 'n') {
            cArr[i] = '\n';
            return 1;
        }
        if (c3 == 'r') {
            cArr[i] = '\r';
            return 1;
        }
        if (c3 == 't') {
            cArr[i] = '\t';
            return 1;
        }
        if (c3 == 'u') {
            int i4 = i + 4;
            if (i4 > cArr.length) {
                throw new CompileException("illegal unicode escape sequence", cArr, i);
            }
            int i6 = i;
            while (true) {
                i6++;
                if (i6 - i == 5) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("0x");
                    int i7 = i + 1;
                    sb.append(new String(cArr, i7, 4));
                    cArr[i3] = (char) Integer.decode(sb.toString()).intValue();
                    cArr[i] = 0;
                    cArr[i7] = 0;
                    cArr[i + 2] = 0;
                    cArr[i + 3] = 0;
                    cArr[i4] = 0;
                    return 5;
                }
                char c4 = cArr[i6];
                if (c4 <= '/' || c4 >= ':') {
                    if (c4 <= '@' || c4 >= 'G') {
                        break;
                    }
                }
            }
            throw new CompileException("illegal unicode escape sequence", cArr, i6);
        }
        int i8 = i;
        do {
            c2 = cArr[i8];
            if (c2 < '0' || c2 >= '8') {
                throw new CompileException("illegal escape sequence: " + cArr[i8], cArr, i8);
            }
            if (i8 != i && cArr[i] > '3') {
                cArr[i3] = (char) Integer.decode("0" + new String(cArr, i, (i8 - i) + 1)).intValue();
                cArr[i] = 0;
                cArr[i + 1] = 0;
                return 2;
            }
            i2 = i8 - i;
            if (i2 != 2) {
                i8++;
                if (i8 == cArr.length || c2 < '0') {
                    break;
                }
            } else {
                cArr[i3] = (char) Integer.decode("0" + new String(cArr, i, i2 + 1)).intValue();
                cArr[i] = 0;
                cArr[i + 1] = 0;
                cArr[i + 2] = 0;
                return 3;
            }
        } while (c2 <= '7');
        cArr[i3] = (char) Integer.decode("0" + new String(cArr, i, i2 + 1)).intValue();
        cArr[i] = 0;
        return 1;
    }

    public static Object X(char[] cArr, int i, int i2) {
        if (i2 != 1 && cArr[i] == '0' && cArr[i + 1] != '.') {
            int i3 = (i + i2) - 1;
            if (!b0(cArr[i3])) {
                char c2 = cArr[i3];
                if (c2 == 'B') {
                    return new BigDecimal(new String(cArr, i, i2 - 1));
                }
                if (c2 == 'I') {
                    return new BigInteger(new String(cArr, i, i2 - 1));
                }
                if (c2 == 'L' || c2 == 'l') {
                    return Long.decode(new String(cArr, i, i2 - 1));
                }
            }
            return Integer.decode(new String(cArr, i, i2));
        }
        int i4 = (i + i2) - 1;
        if (b0(cArr[i4])) {
            int t0 = t0(cArr, i, i2);
            if (t0 == 110) {
                return new BigDecimal(cArr, MathContext.DECIMAL128);
            }
            switch (t0) {
                case 101:
                    return Integer.valueOf(Integer.parseInt(new String(cArr, i, i2)));
                case 102:
                    return Long.valueOf(Long.parseLong(new String(cArr, i, i2)));
                case 103:
                    return Double.valueOf(Double.parseDouble(new String(cArr, i, i2)));
                case 104:
                    return Float.valueOf(Float.parseFloat(new String(cArr, i, i2)));
                default:
                    return new String(cArr, i, i2);
            }
        }
        char c3 = cArr[i4];
        if (c3 != '.') {
            if (c3 == 'B') {
                return new BigDecimal(new String(cArr, i, i2 - 1));
            }
            if (c3 != 'D') {
                if (c3 != 'F') {
                    if (c3 == 'I') {
                        return new BigInteger(new String(cArr, i, i2 - 1));
                    }
                    if (c3 != 'L') {
                        if (c3 != 'd') {
                            if (c3 != 'f') {
                                if (c3 != 'l') {
                                    throw new CompileException("unrecognized numeric literal", cArr, i);
                                }
                            }
                        }
                    }
                    return Long.valueOf(Long.parseLong(new String(cArr, i, i2 - 1)));
                }
                return Float.valueOf(Float.parseFloat(new String(cArr, i, i2 - 1)));
            }
        }
        return Double.valueOf(Double.parseDouble(new String(cArr, i, i2 - 1)));
    }

    public static String Y(char[] cArr) {
        int i = 0;
        int i2 = 0;
        while (i < cArr.length) {
            if (cArr[i] == '\\') {
                i++;
                i2 += W(cArr, i);
            }
            i++;
        }
        if (i2 == 0) {
            return new String(cArr);
        }
        char[] cArr2 = new char[cArr.length - i2];
        int i3 = 0;
        for (char c2 : cArr) {
            if (c2 != 0) {
                cArr2[i3] = c2;
                i3++;
            }
        }
        return new String(cArr2);
    }

    private static boolean Z(Class[] clsArr, Class[] clsArr2, boolean z) {
        if (!z || clsArr2.length - 1 <= clsArr.length) {
            return (z || clsArr2.length == clsArr.length) ? false : true;
        }
        return true;
    }

    public static int a(Class cls) {
        Integer num = (Integer) g.get(cls);
        return num == null ? (cls == null || !Collection.class.isAssignableFrom(cls)) ? 0 : 50 : num.intValue();
    }

    public static boolean a0(char[] cArr, int i, int i2) {
        if (i2 > i + 2) {
            int i3 = i2 - 2;
            if (n0(cArr, i, i3) && cArr[i3] == '[' && cArr[i2 - 1] == ']') {
                return true;
            }
        }
        return false;
    }

    private static Serializable b(CompiledExpression compiledExpression) {
        if (!compiledExpression.isSingleNode()) {
            return compiledExpression;
        }
        ASTNode firstNode = compiledExpression.getFirstNode();
        return (!firstNode.isLiteral() || firstNode.isThisVal()) ? firstNode.canSerializeAccessor() ? new ExecutableAccessorSafe(firstNode, compiledExpression.getKnownEgressType()) : new ExecutableAccessor(firstNode, compiledExpression.getKnownEgressType()) : new ExecutableLiteral(firstNode.getLiteralValue());
    }

    public static boolean b0(int i) {
        return i > 47 && i < 58;
    }

    public static int c(char[] cArr, int i, char c2) {
        return d(cArr, i, cArr.length, c2);
    }

    public static boolean c0(int i) {
        return (i > 96 && i < 123) || (i > 64 && i < 91) || ((i > 47 && i < 58) || i == 95 || i == 36 || Character.isJavaIdentifierPart(i));
    }

    public static int d(char[] cArr, int i, int i2, char c2) {
        int i3;
        int i4;
        char c3 = c2 != '(' ? c2 != '[' ? c2 != '{' ? c2 : '}' : ']' : ')';
        if (c2 == c3) {
            i3 = i + 1;
            while (i3 < i2) {
                if (cArr[i3] == c2) {
                    return i3;
                }
                i3++;
            }
        } else {
            i3 = i + 1;
            int i6 = 1;
            while (i3 < i2) {
                if (i3 < i2 && cArr[i3] == '/') {
                    int i7 = i3 + 1;
                    if (i7 == i2) {
                        return i3;
                    }
                    char c4 = cArr[i7];
                    if (c4 == '/') {
                        i3 = i7;
                        while (i3 < i2 && cArr[i3] != '\n') {
                            i3++;
                        }
                    } else if (c4 == '*') {
                        i3 += 2;
                        while (i3 < i2 && (cArr[i3] != '*' || (i4 = i3 + 1) >= i2 || cArr[i4] != '/')) {
                            i3++;
                        }
                    }
                }
                if (i3 == i2) {
                    return i3;
                }
                char c5 = cArr[i3];
                if (c5 == '\'' || c5 == '\"') {
                    i3 = h(c5, cArr, i3, i2);
                } else if (c5 == c2) {
                    i6++;
                } else if (c5 == c3 && i6 - 1 == 0) {
                    return i3;
                }
                i3++;
            }
        }
        if (c2 == '(') {
            throw new CompileException("unbalanced braces ( ... )", cArr, i3);
        }
        if (c2 == '[') {
            throw new CompileException("unbalanced braces [ ... ]", cArr, i3);
        }
        if (c2 != '{') {
            throw new CompileException("unterminated string literal", cArr, i3);
        }
        throw new CompileException("unbalanced braces { ... }", cArr, i3);
    }

    public static boolean d0(char c2) {
        if (c2 == '(' || c2 == '[') {
            return true;
        }
        return q0(c2);
    }

    public static int e(char[] cArr, int i, int i2, char c2, ParserContext parserContext) {
        char c3 = c2 != '(' ? c2 != '[' ? c2 != '{' ? c2 : '}' : ']' : ')';
        if (c2 == c3) {
            for (int i3 = i + 1; i3 != i2; i3++) {
                if (cArr[i3] == c2) {
                    return i3;
                }
            }
        } else {
            int i4 = i + 1;
            int i6 = 0;
            int i7 = 1;
            while (i4 < i2) {
                if (q0(cArr[i4])) {
                    char c4 = cArr[i4];
                    if (c4 == '\n') {
                        if (parserContext != null) {
                            parserContext.setLineOffset((short) i4);
                        }
                        i6++;
                    } else if (c4 == '\r') {
                        continue;
                        i4++;
                    }
                } else if (i4 < i2 && cArr[i4] == '/') {
                    int i8 = i4 + 1;
                    if (i8 == i2) {
                        return i4;
                    }
                    char c5 = cArr[i8];
                    if (c5 == '/') {
                        i4 = i8;
                        while (i4 < i2 && cArr[i4] != '\n') {
                            i4++;
                        }
                    } else if (c5 == '*') {
                        i4 += 2;
                        while (i4 != i2) {
                            char c6 = cArr[i4];
                            if (c6 != '\n' && c6 != '\r') {
                                if (c6 == '*') {
                                    int i9 = i4 + 1;
                                    if (i9 < i2 && cArr[i9] == '/') {
                                        break;
                                    }
                                } else {
                                    continue;
                                    i4++;
                                }
                            }
                            if (parserContext != null) {
                                parserContext.setLineOffset((short) i4);
                            }
                            i6++;
                            i4++;
                        }
                    }
                }
                if (i4 == i2) {
                    return i4;
                }
                char c8 = cArr[i4];
                if (c8 == '\'' || c8 == '\"') {
                    i4 = h(c8, cArr, i4, i2);
                } else if (c8 == c2) {
                    i7++;
                } else if (c8 == c3 && i7 - 1 == 0) {
                    if (parserContext != null) {
                        parserContext.incrementLineCount(i6);
                    }
                    return i4;
                }
                i4++;
            }
        }
        if (c2 == '(') {
            throw new CompileException("unbalanced braces ( ... )", cArr, i);
        }
        if (c2 == '[') {
            throw new CompileException("unbalanced braces [ ... ]", cArr, i);
        }
        if (c2 != '{') {
            throw new CompileException("unterminated string literal", cArr, i);
        }
        throw new CompileException("unbalanced braces { ... }", cArr, i);
    }

    private static boolean e0(Method method, Method method2) {
        return method2.getReturnType().isAssignableFrom(method.getReturnType()) && method2.getDeclaringClass().isAssignableFrom(method.getDeclaringClass());
    }

    public static Class f(Class cls) {
        Class cls2 = Integer.class;
        if (cls != Integer.TYPE && cls != cls2) {
            cls2 = Integer[].class;
            if (cls != int[].class && cls != cls2) {
                cls2 = Character.class;
                if (cls != Character.TYPE && cls != cls2) {
                    cls2 = Character[].class;
                    if (cls != char[].class && cls != cls2) {
                        cls2 = Long.class;
                        if (cls != Long.TYPE && cls != cls2) {
                            cls2 = Long[].class;
                            if (cls != long[].class && cls != cls2) {
                                cls2 = Short.class;
                                if (cls != Short.TYPE && cls != cls2) {
                                    cls2 = Short[].class;
                                    if (cls != short[].class && cls != cls2) {
                                        cls2 = Double.class;
                                        if (cls != Double.TYPE && cls != cls2) {
                                            cls2 = Double[].class;
                                            if (cls != double[].class && cls != cls2) {
                                                cls2 = Float.class;
                                                if (cls != Float.TYPE && cls != cls2) {
                                                    cls2 = Float[].class;
                                                    if (cls != float[].class && cls != cls2) {
                                                        cls2 = Boolean.class;
                                                        if (cls != Boolean.TYPE && cls != cls2) {
                                                            cls2 = Boolean[].class;
                                                            if (cls != boolean[].class && cls != cls2) {
                                                                cls2 = Byte.class;
                                                                if (cls != Byte.TYPE && cls != cls2) {
                                                                    cls2 = Byte[].class;
                                                                    if (cls != byte[].class && cls != cls2) {
                                                                        return cls;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return cls2;
    }

    public static boolean f0(String str) {
        for (char c2 : str.toCharArray()) {
            if (c2 == '.' || !c0(c2)) {
                return true;
            }
        }
        return false;
    }

    public static String[] g(char[] cArr, int i, int i2) {
        int i3 = i + i2;
        boolean z = false;
        int i4 = 0;
        for (int i6 = i; i6 < i3; i6++) {
            char c2 = cArr[i6];
            if (c2 == '\"') {
                z = !z;
            } else if (c2 == '(') {
                i4++;
            } else if (c2 == ')' && !z) {
                int i7 = i4 - 1;
                if (1 == i4) {
                    int i8 = i6 + 1;
                    return new String[]{x(cArr, i, i8 - i), x(cArr, i8, i3 - i8)};
                }
                i4 = i7;
            }
        }
        return new String[]{new String(cArr, i, i2)};
    }

    public static boolean g0(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof String ? h0((String) obj) : obj instanceof char[] ? h0(new String((char[]) obj)) : (obj instanceof Integer) || (obj instanceof BigDecimal) || (obj instanceof BigInteger) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Character);
    }

    public static int h(char c2, char[] cArr, int i, int i2) {
        int i3;
        char c3;
        while (true) {
            i3 = i + 1;
            if (i3 >= i2 || (c3 = cArr[i3]) == c2) {
                break;
            }
            i = c3 == '\\' ? i + 2 : i3;
        }
        if (i3 >= i2 || cArr[i3] != c2) {
            throw new CompileException("unterminated string literal", cArr, i3);
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean h0(java.lang.String r7) {
        /*
            int r0 = r7.length()
            r1 = 1
            r2 = 0
            if (r0 <= r1) goto L24
            char r3 = r7.charAt(r2)
            r4 = 45
            if (r3 != r4) goto L13
        L10:
            r3 = r1
            r4 = r3
            goto L26
        L13:
            char r3 = r7.charAt(r2)
            r5 = 126(0x7e, float:1.77E-43)
            if (r3 != r5) goto L24
            char r3 = r7.charAt(r1)
            if (r3 != r4) goto L10
            r3 = 2
            r4 = r1
            goto L26
        L24:
            r4 = r1
            r3 = r2
        L26:
            if (r3 >= r0) goto L3e
            char r5 = r7.charAt(r3)
            boolean r6 = b0(r5)
            if (r6 != 0) goto L3b
            r6 = 46
            if (r5 != r6) goto L3a
            if (r4 == 0) goto L3a
            r4 = r2
            goto L3b
        L3a:
            return r2
        L3b:
            int r3 = r3 + 1
            goto L26
        L3e:
            if (r0 <= 0) goto L41
            goto L42
        L41:
            r1 = r2
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.m.h0(java.lang.String):boolean");
    }

    public static int i(char[] cArr, int i, int i2, ParserContext parserContext) {
        while (i != cArr.length) {
            char c2 = cArr[i];
            if (c2 != '\"') {
                if (c2 != ',' && c2 != ';') {
                    if (c2 != '[' && c2 != '{') {
                        if (c2 != '}') {
                            if (c2 != '\'') {
                                if (c2 != '(') {
                                    continue;
                                    i++;
                                }
                            }
                        }
                    }
                    i = e(cArr, i, i2, c2, parserContext);
                    if (i < cArr.length) {
                        i++;
                    }
                }
                return i;
            }
            i = h(c2, cArr, i, cArr.length);
            i++;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x001a, code lost:
    
        if (r16[r6] == '-') goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r6 != '~') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00e0, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i0(char[] r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.m.i0(char[], int, int):boolean");
    }

    public static int j(char[] cArr, int i, int i2, ParserContext parserContext) {
        char c2;
        while (i != cArr.length && (c2 = cArr[i]) != '(') {
            if (c2 == '[') {
                i = e(cArr, i, i2, '[', parserContext);
            } else if (c2 == '{' || q0(c2)) {
                return i;
            }
            i++;
        }
        return i;
    }

    public static boolean j0(Object obj) {
        if (obj == null) {
            return false;
        }
        Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
        return cls == Integer.TYPE || cls == Long.TYPE || cls == Short.TYPE || cls == Double.TYPE || cls == Float.TYPE || Number.class.isAssignableFrom(cls);
    }

    public static void k(String str) {
        if (o0(str)) {
            throw new RuntimeException("illegal use of reserved word: " + str);
        }
        if (b0(str.charAt(0))) {
            throw new RuntimeException("not an identifier: " + str);
        }
    }

    public static boolean k0(Class cls, Class cls2) {
        if ((cls.isPrimitive() ? f(cls) : cls) == null || !Number.class.isAssignableFrom(cls)) {
            return false;
        }
        if (cls2.isPrimitive()) {
            cls2 = f(cls2);
        }
        if (cls2 != null) {
            return Number.class.isAssignableFrom(cls2);
        }
        return false;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            return ((String) obj).contains(String.valueOf(obj2));
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).contains(obj2);
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(obj2);
        }
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().isPrimitive()) {
                return t(obj, obj2);
            }
            for (Object obj3 : (Object[]) obj) {
                if ((obj2 == null && obj3 == null) || ((Boolean) a00.a.g(obj3, 18, obj2)).booleanValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean l0(Class cls, Class cls2) {
        Class cls3;
        if (!cls2.isPrimitive()) {
            return false;
        }
        Class O0 = O0(cls);
        if (O0.isPrimitive()) {
            return (cls2 == Double.TYPE && O0 == Float.TYPE) || (cls2 == Float.TYPE && O0 == Long.TYPE) || ((cls2 == Long.TYPE && O0 == Integer.TYPE) || ((cls2 == (cls3 = Integer.TYPE) && O0 == Character.TYPE) || ((cls2 == cls3 && O0 == Short.TYPE) || (cls2 == Short.TYPE && O0 == Byte.TYPE))));
        }
        return false;
    }

    private static boolean m(boolean[] zArr, Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        for (boolean z : zArr) {
            if (z == booleanValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean m0(Class cls) {
        return cls == Integer.class || cls == Boolean.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Character.class || cls == Short.class || cls == Byte.class;
    }

    private static boolean n(byte[] bArr, Byte b2) {
        byte byteValue = b2.byteValue();
        for (byte b3 : bArr) {
            if (b3 == byteValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean n0(char[] cArr, int i, int i2) {
        while (i < i2) {
            if (!c0(cArr[i])) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean o(char[] cArr, Character ch) {
        char charValue = ch.charValue();
        for (char c2 : cArr) {
            if (c2 == charValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean o0(String str) {
        return AbstractParser.LITERALS.containsKey(str) || AbstractParser.OPERATORS.containsKey(str);
    }

    private static boolean p(double[] dArr, Double d2) {
        double doubleValue = d2.doubleValue();
        for (double d3 : dArr) {
            if (d3 == doubleValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean p0(char[] cArr, int i) {
        if (i >= cArr.length) {
            return false;
        }
        while (i != cArr.length && q0(cArr[i])) {
            i++;
        }
        return i == cArr.length || cArr[i] != ';';
    }

    private static boolean q(float[] fArr, Float f2) {
        float floatValue = f2.floatValue();
        for (float f3 : fArr) {
            if (f3 == floatValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean q0(char c2) {
        return c2 < '!';
    }

    private static boolean r(int[] iArr, Integer num) {
        int intValue = num.intValue();
        for (int i : iArr) {
            if (i == intValue) {
                return true;
            }
        }
        return false;
    }

    public static Object r0(BigDecimal bigDecimal, int i) {
        return (i == 109 || bigDecimal.scale() > 0) ? Double.valueOf(bigDecimal.doubleValue()) : (i == 107 || bigDecimal.longValue() > 2147483647L) ? Long.valueOf(bigDecimal.longValue()) : Integer.valueOf(bigDecimal.intValue());
    }

    private static boolean s(long[] jArr, Long l) {
        long longValue = l.longValue();
        for (long j : jArr) {
            if (j == longValue) {
                return true;
            }
        }
        return false;
    }

    public static int s0(char[] cArr, int i) {
        if (i + 1 >= cArr.length) {
            throw new CompileException("unexpected end of statement", cArr, i);
        }
        while (i != cArr.length && q0(cArr[i])) {
            i++;
        }
        return i;
    }

    private static boolean t(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        if (componentType == Boolean.TYPE) {
            return (obj2 instanceof Boolean) && m((boolean[]) obj, (Boolean) obj2);
        }
        if (componentType == Integer.TYPE) {
            return (obj2 instanceof Integer) && r((int[]) obj, (Integer) obj2);
        }
        if (componentType == Long.TYPE) {
            return (obj2 instanceof Long) && s((long[]) obj, (Long) obj2);
        }
        if (componentType == Double.TYPE) {
            return (obj2 instanceof Double) && p((double[]) obj, (Double) obj2);
        }
        if (componentType == Float.TYPE) {
            return (obj2 instanceof Float) && q((float[]) obj, (Float) obj2);
        }
        if (componentType == Character.TYPE) {
            return (obj2 instanceof Character) && o((char[]) obj, (Character) obj2);
        }
        if (componentType == Short.TYPE) {
            return (obj2 instanceof Short) && u((short[]) obj, (Short) obj2);
        }
        if (componentType == Byte.TYPE) {
            return (obj2 instanceof Byte) && n((byte[]) obj, (Byte) obj2);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int t0(char[] r8, int r9, int r10) {
        /*
            r0 = 45
            r1 = 1
            if (r10 <= r1) goto L19
            char r2 = r8[r9]
            if (r2 != r0) goto Lc
            int r2 = r9 + 1
            goto L1a
        Lc:
            r3 = 126(0x7e, float:1.77E-43)
            if (r2 != r3) goto L19
            int r2 = r9 + 1
            char r3 = r8[r2]
            if (r3 != r0) goto L1a
            int r2 = r9 + 2
            goto L1a
        L19:
            r2 = r9
        L1a:
            int r9 = r9 + r10
            r3 = 0
        L1c:
            r4 = -1
            r5 = 101(0x65, float:1.42E-43)
            if (r2 >= r9) goto L44
            char r6 = r8[r2]
            boolean r7 = b0(r6)
            if (r7 != 0) goto L42
            r3 = 46
            if (r6 == r3) goto L3e
            r3 = 69
            if (r6 == r3) goto L34
            if (r6 == r5) goto L34
            return r4
        L34:
            int r3 = r2 + 1
            if (r2 >= r9) goto L40
            char r4 = r8[r3]
            if (r4 != r0) goto L40
            int r2 = r2 + 2
        L3e:
            r3 = r1
            goto L42
        L40:
            r2 = r3
            goto L3e
        L42:
            int r2 = r2 + r1
            goto L1c
        L44:
            if (r10 == 0) goto L53
            if (r3 == 0) goto L4b
            r8 = 103(0x67, float:1.44E-43)
            return r8
        L4b:
            r8 = 9
            if (r10 <= r8) goto L52
            r8 = 102(0x66, float:1.43E-43)
            return r8
        L52:
            return r5
        L53:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.m.t0(char[], int, int):int");
    }

    private static boolean u(short[] sArr, Short sh) {
        short shortValue = sh.shortValue();
        for (short s : sArr) {
            if (s == shortValue) {
                return true;
            }
        }
        return false;
    }

    public static int u0(char c2) {
        if (c2 == '%') {
            return 4;
        }
        if (c2 == '&') {
            return 6;
        }
        if (c2 == '*') {
            return 2;
        }
        if (c2 == '+') {
            return 0;
        }
        if (c2 == '/') {
            return 3;
        }
        if (c2 == '^') {
            return 8;
        }
        if (c2 == '|') {
            return 7;
        }
        if (c2 == 187) {
            return 9;
        }
        if (c2 != 171) {
            return c2 != 172 ? -1 : 11;
        }
        return 10;
    }

    public static Class v(String str, ParserContext parserContext) {
        Class<?> cls;
        Class cls2;
        ClassLoader classLoader = parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader();
        Map map = d;
        Map map2 = (Map) map.get(classLoader);
        if (map2 == null) {
            map2 = Collections.synchronizedMap(new WeakHashMap(10));
            map.put(classLoader, map2);
        }
        WeakReference weakReference = (WeakReference) map2.get(str);
        if (weakReference != null && (cls2 = (Class) weakReference.get()) != null) {
            return cls2;
        }
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException e3) {
            if (classLoader == Thread.currentThread().getContextClassLoader()) {
                throw e3;
            }
            cls = Class.forName(str, true, Thread.currentThread().getContextClassLoader());
        }
        map2.put(str, new WeakReference(cls));
        return cls;
    }

    public static Serializable v0(CompiledExpression compiledExpression) {
        return (!compiledExpression.isImportInjectionRequired() && compiledExpression.getParserConfiguration().isAllowBootstrapBypass() && compiledExpression.isSingleNode()) ? b(compiledExpression) : compiledExpression;
    }

    public static char[] w(String str, char[] cArr, int i, int i2, int i3) {
        char c2;
        if (i3 == -1) {
            return cArr;
        }
        if (i3 == 0) {
            c2 = '+';
        } else if (i3 == 1) {
            c2 = '-';
        } else if (i3 == 2) {
            c2 = '*';
        } else if (i3 == 3) {
            c2 = '/';
        } else if (i3 == 4) {
            c2 = '%';
        } else if (i3 == 6) {
            c2 = '&';
        } else if (i3 == 7) {
            c2 = '|';
        } else if (i3 != 20) {
            switch (i3) {
                case 9:
                    c2 = 187;
                    break;
                case 10:
                    c2 = 171;
                    break;
                case 11:
                    c2 = 172;
                    break;
                default:
                    c2 = 0;
                    break;
            }
        } else {
            c2 = '#';
        }
        char[] charArray = str.toCharArray();
        char[] cArr2 = new char[str.length() + i2 + 1];
        System.arraycopy(charArray, 0, cArr2, 0, str.length());
        cArr2[str.length()] = c2;
        System.arraycopy(cArr, i, cArr2, str.length() + 1, i2);
        return cArr2;
    }

    public static List w0(char[] cArr) {
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= cArr.length) {
                i = -1;
                break;
            }
            if (cArr[i2] == '(') {
                i = i2 + 1;
                break;
            }
            i2++;
        }
        if (i == -1) {
            return Collections.emptyList();
        }
        int i3 = i - 1;
        return y0(cArr, i, (c(cArr, i3, '(') - i3) - 1);
    }

    public static String x(char[] cArr, int i, int i2) {
        int i3 = i2 + i;
        if (i3 > cArr.length) {
            return new String(cArr);
        }
        while (i != i3 && cArr[i] < '!') {
            i++;
        }
        while (i3 != i && cArr[i3 - 1] < '!') {
            i3--;
        }
        return new String(cArr, i, i3 - i);
    }

    public static String[] x0(char[] cArr, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        if (i2 == -1) {
            i2 = cArr.length;
        }
        int i3 = i + i2;
        int i4 = i;
        while (i < i3) {
            char c2 = cArr[i];
            if (c2 == '\"') {
                i = h('\"', cArr, i, cArr.length);
            } else if (c2 != ',') {
                if (c2 != '[' && c2 != '{') {
                    if (c2 == '\'') {
                        i = h('\'', cArr, i, cArr.length);
                    } else if (c2 != '(') {
                        if (!q0(c2) && !c0(cArr[i])) {
                            throw new CompileException("expected parameter", cArr, i4);
                        }
                    }
                }
                i = c(cArr, i, c2);
            } else {
                if (i > i4) {
                    while (q0(cArr[i4])) {
                        i4++;
                    }
                    String str = new String(cArr, i4, i - i4);
                    k(str);
                    linkedList.add(str);
                }
                while (q0(cArr[i])) {
                    i++;
                }
                i4 = i + 1;
            }
            i++;
        }
        if (i4 < i3 && i > i4) {
            String x = x(cArr, i4, i - i4);
            if (x.length() > 0) {
                k(x);
                linkedList.add(x);
            }
        } else if (linkedList.size() == 0) {
            String x2 = x(cArr, i4, i2);
            if (x2.length() > 0) {
                k(x2);
                linkedList.add(x2);
            }
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    private static Method y(Class cls, Method method) {
        String name = method.getName();
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getParameterTypes().length == 0 && name.equals(method2.getName())) {
                    return method2;
                }
            }
        }
        if (cls.getSuperclass() != null) {
            return y(cls.getSuperclass(), method);
        }
        return null;
    }

    public static List y0(char[] cArr, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (i2 == -1) {
            i2 = cArr.length;
        }
        int i3 = i + i2;
        int i4 = i;
        while (i < i3) {
            char c2 = cArr[i];
            if (c2 == '\"') {
                i = h('\"', cArr, i, cArr.length);
            } else if (c2 != ',') {
                if (c2 != '[' && c2 != '{') {
                    if (c2 == '\'') {
                        i = h('\'', cArr, i, cArr.length);
                    } else if (c2 != '(') {
                    }
                }
                i = c(cArr, i, c2);
            } else {
                if (i > i4) {
                    while (q0(cArr[i4])) {
                        i4++;
                    }
                    arrayList.add(L0(cArr, i4, i - i4));
                }
                while (q0(cArr[i])) {
                    i++;
                }
                i4 = i + 1;
            }
            i++;
        }
        if (i4 < i3 && i > i4) {
            char[] L0 = L0(cArr, i4, i - i4);
            if (L0.length > 0) {
                arrayList.add(L0);
            }
        } else if (arrayList.size() == 0) {
            char[] L02 = L0(cArr, i4, i2);
            if (L02.length > 0) {
                arrayList.add(L02);
            }
        }
        return arrayList;
    }

    public static Method z(Method method) {
        return y(method.getDeclaringClass(), method);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x014c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void z0(java.lang.String r17, char[] r18, int r19, int r20, java.lang.Object r21, org.mvel2.integration.VariableResolverFactory r22) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.m.z0(java.lang.String, char[], int, int, java.lang.Object, org.mvel2.integration.VariableResolverFactory):void");
    }
}
