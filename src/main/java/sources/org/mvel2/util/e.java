package org.mvel2.util;

import com.transsion.baselib.report.recent_event.ActionEvent;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.BinaryOperation;
import org.mvel2.ast.BooleanNode;
import org.mvel2.ast.Contains;
import org.mvel2.ast.Convertable;
import org.mvel2.ast.Instance;
import org.mvel2.ast.IntAdd;
import org.mvel2.ast.IntDiv;
import org.mvel2.ast.IntMult;
import org.mvel2.ast.IntSub;
import org.mvel2.ast.RegExMatchNode;
import org.mvel2.ast.Soundslike;
import org.mvel2.ast.Strsim;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ClassImportResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class e {
    private static BinaryOperation a(int i, ASTNode aSTNode, ASTNode aSTNode2, ParserContext parserContext) {
        return (aSTNode.getEgressType() == Integer.class && aSTNode2.getEgressType() == Integer.class) ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? new BinaryOperation(i, aSTNode, aSTNode2, parserContext) : new IntDiv(aSTNode, aSTNode2, parserContext) : new IntMult(aSTNode, aSTNode2, parserContext) : new IntSub(aSTNode, aSTNode2, parserContext) : new IntAdd(aSTNode, aSTNode2, parserContext) : new BinaryOperation(i, aSTNode, aSTNode2, parserContext);
    }

    public static void b(ParserContext parserContext, ASTNode aSTNode, Class cls, boolean z) {
        Class<?> f = m.f(aSTNode.getEgressType());
        if (!z) {
            if (f == null || !(Object.class.equals(f) || m.f(cls).isAssignableFrom(f))) {
                StringBuilder sb = new StringBuilder();
                sb.append("was expecting type: ");
                sb.append(cls.getName());
                sb.append("; but found type: ");
                sb.append(f != null ? f.getName() : "<Unknown>");
                throw new CompileException(sb.toString(), new char[0], 0);
            }
            return;
        }
        if ((f == null || !m.f(cls).isAssignableFrom(f)) && !Object.class.equals(f) && parserContext.isStrictTypeEnforcement()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("was expecting type: ");
            sb2.append(cls.getName());
            sb2.append("; but found type: ");
            sb2.append(f != null ? f.getName() : "<Unknown>");
            throw new CompileException(sb2.toString(), new char[0], 0);
        }
    }

    public static void c(ParserContext parserContext, org.mvel2.compiler.a aVar, Class cls, boolean z) {
        Class knownEgressType = aVar.getKnownEgressType();
        if (!z) {
            if (knownEgressType == null || !(Object.class.equals(knownEgressType) || m.f(cls).isAssignableFrom(m.f(knownEgressType)))) {
                StringBuilder sb = new StringBuilder();
                sb.append("was expecting type: ");
                sb.append(cls.getName());
                sb.append("; but found type: ");
                sb.append(knownEgressType != null ? knownEgressType.getName() : "<Unknown>");
                throw new CompileException(sb.toString(), new char[0], 0);
            }
            return;
        }
        if (knownEgressType == null || !m.f(cls).isAssignableFrom(m.f(knownEgressType))) {
            if (!Object.class.equals(knownEgressType) || parserContext.isStrictTypeEnforcement()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("was expecting type: ");
                sb2.append(cls.getName());
                sb2.append("; but found type: ");
                sb2.append(knownEgressType != null ? knownEgressType.getName() : "<Unknown>");
                throw new CompileException(sb2.toString(), new char[0], 0);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x01ed, code lost:
    
        if (r2 == r5) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01ef, code lost:
    
        j(r2.getOperator().intValue(), r1, r2, r17, r9, r19);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.mvel2.util.ASTLinkedList d(org.mvel2.util.ASTLinkedList r17, boolean r18, org.mvel2.ParserContext r19) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.e.d(org.mvel2.util.ASTLinkedList, boolean, org.mvel2.ParserContext):org.mvel2.util.ASTLinkedList");
    }

    public static Map e(VariableResolverFactory variableResolverFactory) {
        if (variableResolverFactory == null) {
            return null;
        }
        while (!(variableResolverFactory instanceof ClassImportResolverFactory)) {
            variableResolverFactory = variableResolverFactory.getNextFactory();
            if (variableResolverFactory == null) {
                return null;
            }
        }
        return ((ClassImportResolverFactory) variableResolverFactory).getImportedClasses();
    }

    public static Class f(ASTIterator aSTIterator, boolean z) {
        ASTNode firstNode = aSTIterator.firstNode();
        return firstNode == null ? Object.class : aSTIterator.size() == 1 ? firstNode.getEgressType() : a.b(aSTIterator).d(z);
    }

    public static Class g(int i, Class cls, Class cls2) {
        if (i == 26 || i == 36) {
            return Boolean.class;
        }
        switch (i) {
            case 0:
                if (cls == String.class) {
                    return String.class;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return Integer.class;
            case ActionEvent.delete_comment /* 14 */:
            case ActionEvent.pageview /* 15 */:
            case 16:
            case ActionEvent.want_to_see_cancel /* 17 */:
            case 18:
            case ActionEvent.search_cover_expose /* 19 */:
            case 21:
            case 22:
                return Boolean.class;
            case ActionEvent.search_cover_click /* 20 */:
                return String.class;
            default:
                return null;
        }
        return (cls == Object.class || cls2 == Object.class) ? Object.class : m.a(m.f(cls)) < m.a(m.f(cls2)) ? cls2 : cls;
    }

    private static boolean h(BooleanNode booleanNode, ASTNode aSTNode) {
        return (booleanNode instanceof org.mvel2.ast.c) && aSTNode.getEgressType() != Integer.class;
    }

    private static boolean i(ASTNode aSTNode, ASTNode aSTNode2) {
        ASTNode aSTNode3;
        ASTNode aSTNode4;
        if (aSTNode2 != null && aSTNode2.isLiteral() && (aSTNode3 = aSTNode2.nextASTNode) != null && k(aSTNode3.getOperator().intValue())) {
            int[] iArr = org.mvel2.f.a;
            if (iArr[aSTNode.getOperator().intValue()] <= iArr[aSTNode3.getOperator().intValue()] && (aSTNode4 = aSTNode3.nextASTNode) != null && aSTNode4.isLiteral() && (aSTNode4.getLiteralValue() instanceof Number)) {
                return true;
            }
        }
        return false;
    }

    private static void j(int i, ASTNode aSTNode, ASTNode aSTNode2, ASTLinkedList aSTLinkedList, ASTLinkedList aSTLinkedList2, ParserContext parserContext) {
        if (i == 36) {
            aSTLinkedList2.addTokenNode(new Convertable(aSTNode, aSTLinkedList.nextNode(), parserContext));
            return;
        }
        switch (i) {
            case 24:
                aSTLinkedList2.addTokenNode(new RegExMatchNode(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case 25:
                aSTLinkedList2.addTokenNode(new Instance(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case 26:
                aSTLinkedList2.addTokenNode(new Contains(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case 27:
                aSTLinkedList2.addTokenNode(new Soundslike(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case 28:
                aSTLinkedList2.addTokenNode(new Strsim(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case 29:
                if (parserContext.isStrongTyping() && aSTNode.getEgressType() != Boolean.class && aSTNode.getEgressType() != Boolean.TYPE) {
                    throw new RuntimeException("Condition of ternary operator is not of type boolean. Found " + aSTNode.getEgressType());
                }
                break;
        }
        aSTLinkedList2.addTokenNode(aSTNode, aSTNode2);
    }

    private static boolean k(int i) {
        return i == 0 || i == 1;
    }

    public static Number l(Object obj) {
        if (obj instanceof Integer) {
            return Integer.valueOf(-((Integer) obj).intValue());
        }
        if (obj instanceof Double) {
            return Double.valueOf(-((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return Float.valueOf(-((Float) obj).floatValue());
        }
        if (obj instanceof Short) {
            return Integer.valueOf(-((Short) obj).shortValue());
        }
        throw new CompileException("expected a numeric type but found: " + obj.getClass().getName(), new char[0], 0);
    }
}
