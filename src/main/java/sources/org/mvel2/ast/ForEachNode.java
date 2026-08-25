package org.mvel2.ast;

import java.lang.reflect.Array;
import java.util.Iterator;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.DefaultLocalVariableResolverFactory;
import org.mvel2.integration.impl.ItemResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class ForEachNode extends BlockNode {
    private static final int ARRAY = 1;
    private static final int CHARSEQUENCE = 2;
    private static final int INTEGER = 3;
    private static final int ITERABLE = 0;
    protected ExecutableStatement condition;
    protected String item;
    protected Class itemType;
    private int type;

    public ForEachNode(char[] cArr, int i, int i2, int i3, int i4, int i6, ParserContext parserContext) {
        super(parserContext);
        this.type = -1;
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        this.fields = i6;
        handleCond(cArr, i, i2, i6, parserContext);
        this.blockStart = i3;
        this.blockOffset = i4;
        if ((i6 & 16) != 0) {
            if (parserContext.isStrictTypeEnforcement() && this.itemType != null) {
                parserContext = parserContext.createSubcontext();
                parserContext.addInput(this.item, this.itemType);
            }
            parserContext.pushVariableScope();
            parserContext.makeVisible(this.item);
            this.compiledBlock = (ExecutableStatement) m.I0(cArr, i3, i4, parserContext);
            parserContext.popVariableScope();
        }
    }

    private void determineIterType(Class cls) {
        if (Iterable.class.isAssignableFrom(cls)) {
            this.type = 0;
            return;
        }
        if (cls.isArray()) {
            this.type = 1;
            return;
        }
        if (CharSequence.class.isAssignableFrom(cls)) {
            this.type = 2;
        } else {
            if (Integer.class.isAssignableFrom(cls)) {
                this.type = 3;
                return;
            }
            throw new CompileException("non-iterable type: " + cls.getName(), this.expr, this.start);
        }
    }

    private void enforceTypeSafety(Class cls, Class cls2) {
        if (cls.isAssignableFrom(cls2) || org.mvel2.b.a(cls2, cls)) {
            return;
        }
        throw new CompileException("type mismatch in foreach: expected: " + cls.getName() + "; but found: " + m.I(cls2), this.expr, this.start);
    }

    private void handleCond(char[] cArr, int i, int i2, int i3, ParserContext parserContext) {
        int i4 = i + i2;
        int i6 = i;
        while (i6 < i4 && cArr[i6] != ':') {
            i6++;
        }
        if (i6 == i4 || cArr[i6] != ':') {
            throw new CompileException("expected : in foreach", cArr, i6);
        }
        int i7 = i6 - i;
        String x = m.x(cArr, i, i7);
        this.item = x;
        int indexOf = x.indexOf(32);
        if (indexOf != -1) {
            String trim = new String(cArr, i, indexOf).trim();
            try {
                this.itemType = m.D(null, trim, parserContext);
                this.item = new String(cArr, i + indexOf, i7 - indexOf).trim();
            } catch (ClassNotFoundException unused) {
                throw new CompileException("cannot resolve identifier: " + trim, cArr, i);
            }
        }
        int i8 = i6 + 1;
        this.start = i8;
        int i9 = (i2 - i7) - 1;
        this.offset = i9;
        if ((i3 & 16) != 0) {
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(this.expr, i8, i9, parserContext);
            this.condition = executableStatement;
            Class knownEgressType = executableStatement.getKnownEgressType();
            if (this.itemType != null && knownEgressType.isArray()) {
                enforceTypeSafety(this.itemType, m.I(this.condition.getKnownEgressType()));
            } else if (parserContext.isStrongTyping()) {
                determineIterType(knownEgressType);
            }
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        ItemResolverFactory.ItemResolver itemResolver = new ItemResolverFactory.ItemResolver(this.item);
        ItemResolverFactory itemResolverFactory = new ItemResolverFactory(itemResolver, new DefaultLocalVariableResolverFactory(variableResolverFactory));
        Object o = org.mvel2.d.o(this.expr, this.start, this.offset, obj2, variableResolverFactory);
        Class cls = this.itemType;
        if (cls != null && cls.isArray()) {
            enforceTypeSafety(this.itemType, m.I(o.getClass()));
        }
        this.compiledBlock = (ExecutableStatement) m.I0(this.expr, this.blockStart, this.blockOffset, this.pCtx);
        if (o instanceof Iterable) {
            Iterator it = ((Iterable) o).iterator();
            while (it.hasNext()) {
                itemResolver.setValue(it.next());
                Object value = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value;
                }
            }
            return null;
        }
        int i = 0;
        if (o != null && o.getClass().isArray()) {
            int length = Array.getLength(o);
            while (i < length) {
                itemResolver.setValue(Array.get(o, i));
                Object value2 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value2;
                }
                i++;
            }
            return null;
        }
        if (o instanceof CharSequence) {
            char[] charArray = o.toString().toCharArray();
            int length2 = charArray.length;
            while (i < length2) {
                itemResolver.setValue(Character.valueOf(charArray[i]));
                Object value3 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value3;
                }
                i++;
            }
            return null;
        }
        if (!(o instanceof Integer)) {
            StringBuilder sb = new StringBuilder();
            sb.append("non-iterable type: ");
            sb.append(o != null ? o.getClass().getName() : "null");
            throw new CompileException(sb.toString(), this.expr, this.start);
        }
        int intValue = ((Integer) o).intValue() + 1;
        for (int i2 = 1; i2 != intValue; i2++) {
            itemResolver.setValue(Integer.valueOf(i2));
            Object value4 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
            if (itemResolverFactory.tiltFlag()) {
                return value4;
            }
        }
        return null;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        ItemResolverFactory.ItemResolver itemResolver = new ItemResolverFactory.ItemResolver(this.item);
        ItemResolverFactory itemResolverFactory = new ItemResolverFactory(itemResolver, new DefaultLocalVariableResolverFactory(variableResolverFactory));
        Object value = this.condition.getValue(obj, obj2, variableResolverFactory);
        if (this.type == -1) {
            determineIterType(value.getClass());
        }
        int i = this.type;
        if (i == 0) {
            Iterator it = ((Iterable) value).iterator();
            while (it.hasNext()) {
                itemResolver.setValue(it.next());
                Object value2 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value2;
                }
            }
            return null;
        }
        int i2 = 0;
        if (i == 1) {
            int length = Array.getLength(value);
            while (i2 < length) {
                itemResolver.setValue(Array.get(value, i2));
                Object value3 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value3;
                }
                i2++;
            }
            return null;
        }
        if (i == 2) {
            char[] charArray = value.toString().toCharArray();
            int length2 = charArray.length;
            while (i2 < length2) {
                itemResolver.setValue(Character.valueOf(charArray[i2]));
                Object value4 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
                if (itemResolverFactory.tiltFlag()) {
                    return value4;
                }
                i2++;
            }
            return null;
        }
        if (i != 3) {
            return null;
        }
        int intValue = ((Integer) value).intValue() + 1;
        for (int i3 = 1; i3 != intValue; i3++) {
            itemResolver.setValue(Integer.valueOf(i3));
            Object value5 = this.compiledBlock.getValue(obj, obj2, itemResolverFactory);
            if (itemResolverFactory.tiltFlag()) {
                return value5;
            }
        }
        return null;
    }
}
