package org.mvel2.ast;

import java.util.ArrayList;
import java.util.Collection;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.DefaultLocalVariableResolverFactory;
import org.mvel2.integration.impl.ItemResolverFactory;
import org.mvel2.util.e;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class Fold extends ASTNode {
    private ExecutableStatement constraintEx;
    private ExecutableStatement dataEx;
    private ExecutableStatement subEx;

    public Fold(char[] cArr, int i, int i2, int i3, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        int i4 = i2 + i;
        int i6 = i;
        while (true) {
            if (i6 >= i4) {
                break;
            }
            if (m.q0(cArr[i6])) {
                while (i6 < i4 && m.q0(cArr[i6])) {
                    i6++;
                }
                if (cArr[i6] == 'i' && cArr[i6 + 1] == 'n' && m.d0(cArr[i6 + 2])) {
                    break;
                }
            }
            i6++;
        }
        this.subEx = (ExecutableStatement) m.I0(cArr, i, (i6 - i) - 1, parserContext);
        int i7 = i6 + 2;
        int i8 = i7;
        while (true) {
            if (i8 >= i4) {
                break;
            }
            if (m.q0(cArr[i8])) {
                while (i8 < i4 && m.q0(cArr[i8])) {
                    i8++;
                }
                if (cArr[i8] == 'i' && cArr[i8 + 1] == 'f') {
                    int i9 = i8 + 2;
                    if (m.d0(cArr[i9])) {
                        this.constraintEx = (ExecutableStatement) m.I0(cArr, i9, i4 - i9, parserContext);
                        break;
                    }
                }
            }
            i8++;
        }
        while (m.q0(cArr[i8])) {
            i8--;
        }
        ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, i7, i8 - i7, parserContext);
        this.dataEx = executableStatement;
        e.c(parserContext, executableStatement, Collection.class, (i3 & 16) != 0);
    }

    @Override // org.mvel2.ast.ASTNode
    public Class getEgressType() {
        return Collection.class;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        ArrayList arrayList;
        ItemResolverFactory.ItemResolver itemResolver = new ItemResolverFactory.ItemResolver("$");
        ItemResolverFactory itemResolverFactory = new ItemResolverFactory(itemResolver, new DefaultLocalVariableResolverFactory(variableResolverFactory));
        if (this.constraintEx != null) {
            Object value = this.dataEx.getValue(obj, obj2, variableResolverFactory);
            if (!(value instanceof Collection)) {
                StringBuilder sb = new StringBuilder();
                sb.append("was expecting type: Collection; but found type: ");
                sb.append(value != null ? value.getClass().getName() : "null");
                throw new CompileException(sb.toString(), this.expr, this.start);
            }
            Collection collection = (Collection) value;
            arrayList = new ArrayList(collection.size());
            for (Object obj3 : collection) {
                itemResolver.value = obj3;
                if (((Boolean) this.constraintEx.getValue(obj, obj2, itemResolverFactory)).booleanValue()) {
                    arrayList.add(this.subEx.getValue(obj3, obj2, itemResolverFactory));
                }
            }
        } else {
            Object value2 = this.dataEx.getValue(obj, obj2, variableResolverFactory);
            if (!(value2 instanceof Collection)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("was expecting type: Collection; but found type: ");
                sb2.append(value2 != null ? value2.getClass().getName() : "null");
                throw new CompileException(sb2.toString(), this.expr, this.start);
            }
            Collection collection2 = (Collection) value2;
            arrayList = new ArrayList(collection2.size());
            for (Object obj4 : collection2) {
                ExecutableStatement executableStatement = this.subEx;
                itemResolver.value = obj4;
                arrayList.add(executableStatement.getValue(obj4, obj2, itemResolverFactory));
            }
        }
        return arrayList;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        ArrayList arrayList;
        ItemResolverFactory.ItemResolver itemResolver = new ItemResolverFactory.ItemResolver("$");
        ItemResolverFactory itemResolverFactory = new ItemResolverFactory(itemResolver, new DefaultLocalVariableResolverFactory(variableResolverFactory));
        if (this.constraintEx != null) {
            Collection collection = (Collection) this.dataEx.getValue(obj, obj2, variableResolverFactory);
            arrayList = new ArrayList(collection.size());
            for (Object obj3 : collection) {
                itemResolver.value = obj3;
                if (((Boolean) this.constraintEx.getValue(obj, obj2, itemResolverFactory)).booleanValue()) {
                    arrayList.add(this.subEx.getValue(obj3, obj2, itemResolverFactory));
                }
            }
        } else {
            Collection collection2 = (Collection) this.dataEx.getValue(obj, obj2, variableResolverFactory);
            arrayList = new ArrayList(collection2.size());
            for (Object obj4 : collection2) {
                ExecutableStatement executableStatement = this.subEx;
                itemResolver.value = obj4;
                arrayList.add(executableStatement.getValue(obj4, obj2, itemResolverFactory));
            }
        }
        return arrayList;
    }
}
