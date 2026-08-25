package org.mvel2.ast;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;
import org.mvel2.util.p;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class TypeDescriptor implements Serializable {
    private ArraySize[] arraySize;
    private String className;
    private ExecutableStatement[] compiledArraySize;
    int endRange;
    private char[] expr;
    private int offset;
    private int start;

    public TypeDescriptor(char[] cArr, int i, int i2, int i3) {
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        updateClassName(cArr, i, i2, i3);
    }

    public static Class getClassReference(Class cls, TypeDescriptor typeDescriptor, VariableResolverFactory variableResolverFactory, ParserContext parserContext) throws ClassNotFoundException {
        return m.D(variableResolverFactory, m.A0('[', typeDescriptor.arraySize.length) + "L" + cls.getName() + ";", parserContext);
    }

    public static Class getClassReference(ParserContext parserContext, Class cls, TypeDescriptor typeDescriptor) throws ClassNotFoundException {
        Class D;
        if (!typeDescriptor.isArray()) {
            return cls;
        }
        if (cls.isPrimitive()) {
            D = p.j(cls);
        } else {
            D = m.D(null, m.A0('[', typeDescriptor.arraySize.length) + "L" + cls.getName() + ";", parserContext);
        }
        return D;
    }

    public static Class getClassReference(ParserContext parserContext, TypeDescriptor typeDescriptor) throws ClassNotFoundException {
        Class D;
        if (parserContext != null && parserContext.hasImport(typeDescriptor.className)) {
            Class cls = parserContext.getImport(typeDescriptor.className);
            if (!typeDescriptor.isArray()) {
                return cls;
            }
            if (cls.isPrimitive()) {
                D = p.j(cls);
            } else {
                D = m.D(null, m.A0('[', typeDescriptor.arraySize.length) + "L" + cls.getName() + ";", parserContext);
            }
        } else if (parserContext == null && hasContextFreeImport(typeDescriptor.className)) {
            Class contextFreeImport = getContextFreeImport(typeDescriptor.className);
            if (!typeDescriptor.isArray()) {
                return contextFreeImport;
            }
            if (contextFreeImport.isPrimitive()) {
                D = p.j(contextFreeImport);
            } else {
                D = m.D(null, m.A0('[', typeDescriptor.arraySize.length) + "L" + contextFreeImport.getName() + ";", parserContext);
            }
        } else {
            Class v = m.v(typeDescriptor.getClassName(), parserContext);
            if (!typeDescriptor.isArray()) {
                return v;
            }
            if (v.isPrimitive()) {
                D = p.j(v);
            } else {
                D = m.D(null, m.A0('[', typeDescriptor.arraySize.length) + "L" + v.getName() + ";", parserContext);
            }
        }
        return D;
    }

    public static Class getContextFreeImport(String str) {
        return (Class) AbstractParser.LITERALS.get(str);
    }

    public static boolean hasContextFreeImport(String str) {
        return AbstractParser.LITERALS.containsKey(str) && (AbstractParser.LITERALS.get(str) instanceof Class);
    }

    public int getArrayLength() {
        return this.arraySize.length;
    }

    public ArraySize[] getArraySize() {
        return this.arraySize;
    }

    public String getClassName() {
        return this.className;
    }

    public Class<?> getClassReference() throws ClassNotFoundException {
        return getClassReference(null, this);
    }

    public Class<?> getClassReference(ParserContext parserContext) throws ClassNotFoundException {
        return getClassReference(parserContext, this);
    }

    public ExecutableStatement[] getCompiledArraySize() {
        return this.compiledArraySize;
    }

    public int getEndRange() {
        return this.endRange;
    }

    public char[] getExpr() {
        return this.expr;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getStart() {
        return this.start;
    }

    public boolean isArray() {
        return this.arraySize != null;
    }

    public boolean isClass() {
        String str = this.className;
        return (str == null || str.length() == 0) ? false : true;
    }

    public boolean isUndimensionedArray() {
        ArraySize[] arraySizeArr = this.arraySize;
        if (arraySizeArr != null) {
            for (ArraySize arraySize : arraySizeArr) {
                if (arraySize.value.length == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setEndRange(int i) {
        this.endRange = i;
    }

    public void updateClassName(char[] cArr, int i, int i2, int i3) {
        ArraySize[] arraySizeArr;
        char c;
        this.expr = cArr;
        if (i2 == 0 || !m.c0(cArr[i]) || Character.isDigit(cArr[i])) {
            return;
        }
        int a = org.mvel2.util.b.a('(', i, i2, cArr);
        this.endRange = a;
        if (a != -1) {
            this.className = new String(cArr, i, a - i).trim();
            return;
        }
        int a2 = org.mvel2.util.b.a('[', i, i2, cArr);
        this.endRange = a2;
        if (a2 == -1) {
            this.className = new String(cArr, i, i2).trim();
            return;
        }
        this.className = new String(cArr, i, a2 - i).trim();
        LinkedList linkedList = new LinkedList();
        int i4 = i + i2;
        while (this.endRange < i4) {
            while (true) {
                int i6 = this.endRange;
                if (i6 >= i4 || !m.q0(cArr[i6])) {
                    break;
                } else {
                    this.endRange++;
                }
            }
            int i7 = this.endRange;
            if (i7 == i4 || (c = cArr[i7]) == '{') {
                break;
            }
            if (c != '[') {
                throw new CompileException("unexpected token in constructor", cArr, this.endRange);
            }
            int d = m.d(cArr, i7, i4, '[');
            int i8 = this.endRange + 1;
            this.endRange = i8;
            linkedList.add(m.K0(cArr, i8, d - i8));
            this.endRange = d + 1;
        }
        Iterator it = linkedList.iterator();
        this.arraySize = new ArraySize[linkedList.size()];
        int i9 = 0;
        int i10 = 0;
        while (true) {
            arraySizeArr = this.arraySize;
            if (i10 >= arraySizeArr.length) {
                break;
            }
            arraySizeArr[i10] = new ArraySize((char[]) it.next());
            i10++;
        }
        if ((i3 & 16) == 0) {
            return;
        }
        this.compiledArraySize = new ExecutableStatement[arraySizeArr.length];
        while (true) {
            ExecutableStatement[] executableStatementArr = this.compiledArraySize;
            if (i9 >= executableStatementArr.length) {
                return;
            }
            executableStatementArr[i9] = (ExecutableStatement) m.H0(this.arraySize[i9].value);
            i9++;
        }
    }
}
