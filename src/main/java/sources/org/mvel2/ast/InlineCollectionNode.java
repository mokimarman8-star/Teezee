package org.mvel2.ast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class InlineCollectionNode extends ASTNode {
    private Object collectionGraph;
    int trailingOffset;
    int trailingStart;

    public InlineCollectionNode(char[] cArr, int i, int i2, int i3, Class cls, ParserContext parserContext) {
        super(cArr, i, i2, i3 | 1024, parserContext);
        this.egressType = cls;
        if ((i3 & 16) != 0) {
            try {
                parseGraph(true, cls, parserContext);
                org.mvel2.optimizers.a d = org.mvel2.optimizers.b.d();
                this.accessor = d.optimizeCollection(parserContext, this.collectionGraph, this.egressType, cArr, this.trailingStart, this.trailingOffset, null, null, null);
                this.egressType = d.getEgressType();
            } finally {
                org.mvel2.optimizers.b.a();
            }
        }
    }

    public InlineCollectionNode(char[] cArr, int i, int i2, int i3, ParserContext parserContext) {
        super(cArr, i, i2, i3 | 1024, parserContext);
        if ((i3 & 16) != 0) {
            parseGraph(true, null, parserContext);
            try {
                org.mvel2.optimizers.a d = org.mvel2.optimizers.b.d();
                this.accessor = d.optimizeCollection(parserContext, this.collectionGraph, this.egressType, cArr, this.trailingStart, this.trailingOffset, null, null, null);
                this.egressType = d.getEgressType();
            } finally {
                org.mvel2.optimizers.b.a();
            }
        }
    }

    private Object execGraph(Object obj, Class cls, Object obj2, VariableResolverFactory variableResolverFactory) {
        int i;
        Class D;
        if (obj instanceof List) {
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(execGraph(it.next(), cls, obj2, variableResolverFactory));
            }
            return arrayList;
        }
        if (obj instanceof Map) {
            HashMap hashMap = new HashMap();
            Map map = (Map) obj;
            for (Object obj3 : map.keySet()) {
                hashMap.put(execGraph(obj3, cls, obj2, variableResolverFactory), execGraph(map.get(obj3), cls, obj2, variableResolverFactory));
            }
            return hashMap;
        }
        if (!(obj instanceof Object[])) {
            return cls.isArray() ? org.mvel2.d.m((String) obj, obj2, variableResolverFactory, m.I(cls)) : org.mvel2.d.l((String) obj, obj2, variableResolverFactory);
        }
        int i2 = 0;
        if (cls != null) {
            i = 0;
            while (cls.getName().charAt(i) == '[') {
                i++;
            }
        } else {
            cls = Object[].class;
            i = 1;
        }
        Object newInstance = Array.newInstance((Class<?>) m.T(cls), ((Object[]) obj).length);
        if (i > 1) {
            try {
                D = m.D(null, m.A0('[', i - 1) + "L" + m.I(cls).getName() + ";", this.pCtx);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("this error should never throw:" + m.I(cls).getName(), e);
            } catch (IllegalArgumentException e3) {
                throw new CompileException("type mismatch in array", this.expr, this.start, e3);
            }
        } else {
            D = cls;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            Array.set(newInstance, i3, execGraph(objArr[i2], D, obj2, variableResolverFactory));
            i2++;
            i3 = i4;
        }
        return newInstance;
    }

    private void parseGraph(boolean z, Class cls, ParserContext parserContext) {
        org.mvel2.util.c cVar = new org.mvel2.util.c();
        if (cls == null) {
            this.collectionGraph = ((List) cVar.e(this.expr, this.start, this.offset, z, parserContext)).get(0);
        } else {
            this.collectionGraph = ((List) cVar.d(this.expr, this.start, this.offset, z, cls, parserContext)).get(0);
        }
        int a = cVar.a() + 2;
        this.trailingStart = a;
        this.trailingOffset = this.offset - (a - this.start);
        if (this.egressType == null) {
            this.egressType = this.collectionGraph.getClass();
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        parseGraph(false, this.egressType, this.pCtx);
        return execGraph(this.collectionGraph, this.egressType, obj, variableResolverFactory);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (this.accessor != null) {
            return this.accessor.getValue(obj, obj2, variableResolverFactory);
        }
        try {
            org.mvel2.optimizers.a d = org.mvel2.optimizers.b.d();
            if (this.collectionGraph == null) {
                parseGraph(true, null, null);
            }
            this.accessor = d.optimizeCollection(this.pCtx, this.collectionGraph, this.egressType, this.expr, this.trailingStart, this.trailingOffset, obj, obj2, variableResolverFactory);
            this.egressType = d.getEgressType();
            Object value = this.accessor.getValue(obj, obj2, variableResolverFactory);
            org.mvel2.optimizers.b.a();
            return value;
        } catch (Throwable th) {
            org.mvel2.optimizers.b.a();
            throw th;
        }
    }
}
