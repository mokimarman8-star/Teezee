package org.mvel2.util;

import com.transsion.baselib.report.recent_event.ActionEvent;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.OperatorNode;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a {
    private ASTNode a;
    private a b;
    private a c;

    public a(ASTNode aSTNode) {
        this.a = aSTNode;
    }

    public static a b(ASTIterator aSTIterator) {
        ASTLinkedList aSTLinkedList = new ASTLinkedList(aSTIterator.firstNode());
        a aVar = new a(aSTLinkedList.nextNode());
        while (aSTLinkedList.hasMoreNodes()) {
            ASTNode nextNode = aSTLinkedList.nextNode();
            if (!(nextNode instanceof EndOfStatement)) {
                aVar = aVar.a(nextNode);
            } else if (aSTLinkedList.hasMoreNodes()) {
                aVar = new a(aSTLinkedList.nextNode());
            }
        }
        return aVar;
    }

    private int c(ASTNode aSTNode, ASTNode aSTNode2) {
        boolean z = aSTNode instanceof OperatorNode;
        if (!z && !(aSTNode2 instanceof OperatorNode)) {
            return 0;
        }
        if (!z || !(aSTNode2 instanceof OperatorNode)) {
            return z ? -1 : 1;
        }
        int[] iArr = org.mvel2.f.a;
        return iArr[((OperatorNode) aSTNode).getOperator().intValue()] - iArr[((OperatorNode) aSTNode2).getOperator().intValue()];
    }

    public a a(ASTNode aSTNode) {
        if (c(this.a, aSTNode) >= 0) {
            a aVar = new a(aSTNode);
            aVar.b = this;
            return aVar;
        }
        if (this.b == null) {
            throw new RuntimeException("Missing left node");
        }
        a aVar2 = this.c;
        if (aVar2 == null) {
            this.c = new a(aSTNode);
        } else {
            this.c = aVar2.a(aSTNode);
        }
        return this;
    }

    public Class d(boolean z) {
        ASTNode aSTNode = this.a;
        if (!(aSTNode instanceof OperatorNode)) {
            return aSTNode.getEgressType();
        }
        a aVar = this.b;
        if (aVar == null || this.c == null) {
            throw new RuntimeException("Malformed expression");
        }
        Class d = aVar.d(z);
        Class d2 = this.c.d(z);
        int intValue = ((OperatorNode) this.a).getOperator().intValue();
        if (intValue != 0) {
            if (intValue != 1 && intValue != 2 && intValue != 3) {
                if (intValue == 4) {
                    if (!z || d.b(d, d2)) {
                        return Integer.class;
                    }
                    throw new RuntimeException("Associative operation requires compatible types. Found " + d + " and " + d2);
                }
                if (intValue == 21 || intValue == 22) {
                    if (z) {
                        if (d != Boolean.class && d != Boolean.TYPE) {
                            throw new RuntimeException("Left side of logical operation is not of type boolean. Found " + d);
                        }
                        if (d2 != Boolean.class && d2 != Boolean.TYPE) {
                            throw new RuntimeException("Right side of logical operation is not of type boolean. Found " + d2);
                        }
                    }
                    return Boolean.class;
                }
                switch (intValue) {
                    case ActionEvent.delete_comment /* 14 */:
                    case ActionEvent.pageview /* 15 */:
                    case 16:
                    case ActionEvent.want_to_see_cancel /* 17 */:
                        if (!z || d.a(d, d2)) {
                            return Boolean.class;
                        }
                        throw new RuntimeException("Comparison operation requires compatible types. Found " + d + " and " + d2);
                    case 18:
                    case ActionEvent.search_cover_expose /* 19 */:
                        if (!z || d.b(d, d2)) {
                            return Boolean.class;
                        }
                        throw new RuntimeException("Comparison operation requires compatible types. Found " + d + " and " + d2);
                    default:
                        switch (intValue) {
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                                return Boolean.class;
                            case 29:
                                if (!z || d == Boolean.class || d == Boolean.TYPE) {
                                    return d2;
                                }
                                throw new RuntimeException("Condition of ternary operator is not of type boolean. Found " + d);
                            case 30:
                                if (!z || d.b(d, d2)) {
                                    return d;
                                }
                                throw new RuntimeException("Associative operation requires compatible types. Found " + d + " and " + d2);
                            default:
                                return this.a.getEgressType();
                        }
                }
            }
        } else if (d.equals(String.class) || d2.equals(String.class)) {
            return String.class;
        }
        if (!z || d.b(d, d2)) {
            return Double.class;
        }
        throw new RuntimeException("Associative operation requires compatible types. Found " + d + " and " + d2);
    }
}
