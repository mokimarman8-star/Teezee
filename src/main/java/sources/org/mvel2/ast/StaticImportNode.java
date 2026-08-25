package org.mvel2.ast;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class StaticImportNode extends ASTNode {
    private Class declaringClass;
    private transient Method method;
    private String methodName;

    public StaticImportNode(char[] cArr, int i, int i2, ParserContext parserContext) {
        super(parserContext);
        try {
            this.expr = cArr;
            this.start = i;
            this.offset = i2;
            ClassLoader classLoader = getClassLoader();
            this.expr = cArr;
            int b = org.mvel2.util.b.b('.', i, i2, cArr);
            this.declaringClass = Class.forName(new String(cArr, i, b - i), true, classLoader);
            int i3 = b + 1;
            this.methodName = new String(cArr, i3, i2 - (i3 - i));
            if (resolveMethod() != null) {
                return;
            }
            throw new CompileException("can not find method for static import: " + this.declaringClass.getName() + "." + this.methodName, cArr, i);
        } catch (Exception e) {
            throw new CompileException("unable to import class", cArr, i, e);
        }
    }

    private Method resolveMethod() {
        for (Method method : this.declaringClass.getMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && this.methodName.equals(method.getName())) {
                this.method = method;
                return method;
            }
        }
        return null;
    }

    public Method getMethod() {
        return this.method;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return getReducedValueAccelerated(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        String str = this.methodName;
        Method method = this.method;
        if (method == null) {
            method = resolveMethod();
            this.method = method;
        }
        variableResolverFactory.createVariable(str, method);
        return null;
    }
}
