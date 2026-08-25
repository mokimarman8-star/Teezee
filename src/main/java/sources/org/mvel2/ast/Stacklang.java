package org.mvel2.ast;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.g;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class Stacklang extends BlockNode {
    static final Map<String, Integer> opcodes;
    List<b> instructionList;
    ParserContext pCtx;

    private static class b {
        int a;
        String b;
        Object c;

        private b() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        opcodes = hashMap;
        hashMap.put("push", 102);
        hashMap.put("pop", 103);
        hashMap.put("load", 104);
        hashMap.put("ldtype", 105);
        hashMap.put("invoke", 106);
        hashMap.put("store", 109);
        hashMap.put("getfield", 107);
        hashMap.put("storefield", 108);
        hashMap.put("dup", 110);
        hashMap.put("jump", 112);
        hashMap.put("jumpif", 113);
        hashMap.put("label", 111);
        hashMap.put("eq", 18);
        hashMap.put("ne", 19);
        hashMap.put("reduce", 114);
        hashMap.put("xswap", 116);
        hashMap.put("swap", 115);
    }

    public Stacklang(char[] cArr, int i, int i2, int i3, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.blockStart = i;
        this.blockOffset = i2;
        this.fields = i3 | ASTNode.STACKLANG;
        String[] split = new String(cArr, i, i2).split(";");
        this.instructionList = new ArrayList(split.length);
        for (String str : split) {
            this.instructionList.add(parseInstruction(str.trim()));
        }
        this.pCtx = parserContext;
    }

    private static b parseInstruction(String str) {
        int indexOf = str.indexOf(32);
        b bVar = new b();
        String substring = indexOf == -1 ? str : str.substring(0, indexOf);
        Map<String, Integer> map = opcodes;
        if (map.containsKey(substring)) {
            bVar.a = map.get(substring).intValue();
        }
        if (substring != str) {
            bVar.b = str.substring(indexOf + 1);
        }
        return bVar;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Field field;
        Method method;
        Constructor constructor;
        g gVar = (g) obj;
        int size = this.instructionList.size();
        int i = 0;
        while (i < size) {
            b bVar = this.instructionList.get(i);
            System.out.println(gVar.toString() + " >> " + bVar.a + ":" + bVar.b);
            int i2 = bVar.a;
            if (i2 == 18) {
                gVar.q(Boolean.valueOf(gVar.n().equals(gVar.n())));
            } else if (i2 != 19) {
                switch (i2) {
                    case 102:
                        if (bVar.c == null) {
                            bVar.c = org.mvel2.d.l(bVar.b, obj, variableResolverFactory);
                        }
                        gVar.q(bVar.c);
                        break;
                    case 103:
                        gVar.n();
                        break;
                    case 104:
                        if (bVar.c == null) {
                            bVar.c = variableResolverFactory.getVariableResolver(bVar.b);
                        }
                        gVar.q(((VariableResolver) bVar.c).getValue());
                        break;
                    case 105:
                        try {
                            if (bVar.c == null) {
                                bVar.c = m.v(bVar.b, this.pCtx);
                            }
                            gVar.q(bVar.c);
                            break;
                        } catch (ClassNotFoundException e) {
                            throw new CompileException("error", this.expr, this.blockStart, e);
                        }
                    case 106:
                        g gVar2 = new g();
                        while (!gVar.g() && !(gVar.k() instanceof Class)) {
                            gVar2.q(gVar.n());
                        }
                        if (gVar.g()) {
                            throw new CompileException("invoke without class", this.expr, this.blockStart);
                        }
                        Object[] objArr = new Object[gVar2.t()];
                        int i3 = 0;
                        while (!gVar2.g()) {
                            objArr[i3] = gVar2.n();
                            i3++;
                        }
                        if ("<init>".equals(bVar.b)) {
                            Object obj3 = bVar.c;
                            if (obj3 == null) {
                                constructor = m.N(objArr, (Class) gVar.n(), false);
                                bVar.c = constructor;
                            } else {
                                constructor = (Constructor) obj3;
                            }
                            try {
                                gVar.q(constructor.newInstance(objArr));
                                break;
                            } catch (Exception e3) {
                                throw new CompileException("instantiation error", this.expr, this.blockStart, e3);
                            }
                        } else {
                            if (bVar.c == null) {
                                Class cls = (Class) gVar.n();
                                method = m.L(objArr, bVar.b, cls, cls.getDeclaredMethods(), false);
                                bVar.c = method;
                            } else {
                                gVar.e();
                                method = (Method) bVar.c;
                            }
                            try {
                                gVar.q(method.invoke(gVar.g() ? null : gVar.n(), objArr));
                                break;
                            } catch (Exception e4) {
                                throw new CompileException("invokation error", this.expr, this.blockStart, e4);
                            }
                        }
                    case 107:
                        try {
                            if (!gVar.g() && (gVar.k() instanceof Class)) {
                                if (bVar.c == null) {
                                    field = ((Class) gVar.n()).getField(bVar.b);
                                    bVar.c = field;
                                } else {
                                    gVar.e();
                                    field = (Field) bVar.c;
                                }
                                gVar.q(field.get(gVar.n()));
                                break;
                            } else {
                                throw new CompileException("getfield without class", this.expr, this.blockStart);
                            }
                        } catch (Exception e5) {
                            throw new CompileException("field access error", this.expr, this.blockStart, e5);
                        }
                    case 108:
                        try {
                            if (!gVar.g() && (gVar.k() instanceof Class)) {
                                Class cls2 = (Class) gVar.n();
                                Object n = gVar.n();
                                cls2.getField(bVar.b).set(gVar.n(), n);
                                gVar.q(n);
                                break;
                            } else {
                                throw new CompileException("storefield without class", this.expr, this.blockStart);
                            }
                        } catch (Exception e6) {
                            throw new CompileException("field access error", this.expr, this.blockStart, e6);
                        }
                    case 109:
                        Object obj4 = bVar.c;
                        if (obj4 != null) {
                            ((VariableResolver) obj4).setValue(gVar.k());
                            break;
                        } else {
                            bVar.c = variableResolverFactory.createVariable(bVar.b, gVar.k());
                            break;
                        }
                    case 110:
                        gVar.f();
                        break;
                    default:
                        switch (i2) {
                            case 113:
                                if (!gVar.p().booleanValue()) {
                                    break;
                                }
                                break;
                            case 114:
                                gVar.i();
                                continue;
                            case 115:
                                Object n2 = gVar.n();
                                Object n3 = gVar.n();
                                gVar.q(n2);
                                gVar.q(n3);
                                continue;
                            case 116:
                                gVar.v();
                                continue;
                        }
                        Object obj5 = bVar.c;
                        if (obj5 == null) {
                            int i4 = 0;
                            while (true) {
                                if (i4 < this.instructionList.size()) {
                                    b bVar2 = this.instructionList.get(i4);
                                    if (bVar2.a == 111 && bVar.b.equals(bVar2.b)) {
                                        bVar.c = Integer.valueOf(i4);
                                        i = i4;
                                        break;
                                    } else {
                                        i4++;
                                    }
                                }
                            }
                        } else {
                            i = ((Integer) obj5).intValue();
                            break;
                        }
                        break;
                }
            } else {
                gVar.q(Boolean.valueOf(!gVar.n().equals(gVar.n())));
            }
            i++;
        }
        return gVar.n();
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        g gVar = new g();
        gVar.q(getReducedValue(gVar, obj2, variableResolverFactory));
        if (gVar.h()) {
            while (true) {
                gVar.i();
                if (!gVar.h()) {
                    break;
                }
                gVar.u();
            }
        }
        return gVar.k();
    }
}
