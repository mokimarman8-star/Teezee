package org.mvel2;

import org.mvel2.ast.ASTNode;
import org.mvel2.ast.LineLabel;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.n;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class e {
    private static ThreadLocal a;

    public static Object a(boolean z, CompiledExpression compiledExpression, Object obj, VariableResolverFactory variableResolverFactory) {
        org.mvel2.util.g gVar = new org.mvel2.util.g();
        ASTNode firstNode = compiledExpression.getFirstNode();
        if (firstNode == null) {
            return null;
        }
        do {
            try {
                try {
                    if (firstNode.fields != -1) {
                        if (gVar.g()) {
                            gVar.q(firstNode.getReducedValueAccelerated(obj, obj, variableResolverFactory));
                        }
                        if (variableResolverFactory.tiltFlag()) {
                            return gVar.n();
                        }
                        Integer operator = firstNode.getOperator();
                        int intValue = operator.intValue();
                        if (intValue != -1) {
                            if (intValue != 37) {
                                if (intValue == 99) {
                                    variableResolverFactory.setTiltFlag(true);
                                    return gVar.n();
                                }
                                if (intValue == 29) {
                                    if (!gVar.p().booleanValue()) {
                                        while (true) {
                                            ASTNode aSTNode = firstNode.nextASTNode;
                                            if (aSTNode == null) {
                                                break;
                                            }
                                            try {
                                                if (aSTNode.isOperator(30)) {
                                                    firstNode = aSTNode;
                                                    break;
                                                }
                                                firstNode = aSTNode;
                                            } catch (NullPointerException e) {
                                                e = e;
                                                firstNode = aSTNode;
                                                if (firstNode == null || !firstNode.isOperator() || firstNode.nextASTNode == null) {
                                                    throw e;
                                                }
                                                throw new CompileException("incomplete statement: " + firstNode.getName() + " (possible use of reserved keyword as identifier: " + firstNode.getName() + ")", firstNode.getExpr(), firstNode.getStart());
                                            }
                                        }
                                    }
                                    gVar.b();
                                } else {
                                    if (intValue == 30) {
                                        return gVar.n();
                                    }
                                    gVar.r(firstNode.nextASTNode.getReducedValueAccelerated(obj, obj, variableResolverFactory), operator);
                                    while (gVar.h()) {
                                        try {
                                            if (((Integer) gVar.k()).intValue() == 23) {
                                                gVar.n();
                                                Object n = gVar.n();
                                                Object n2 = gVar.n();
                                                if (n.k(n2) && n.k(n)) {
                                                    gVar.q(null);
                                                }
                                                gVar.b();
                                                if (!n.k(n2)) {
                                                    n = n2;
                                                }
                                                gVar.q(n);
                                            } else {
                                                gVar.i();
                                            }
                                        } catch (ClassCastException e3) {
                                            throw new CompileException("syntax error or incomptable types", new char[0], 0, e3);
                                        } catch (CompileException e4) {
                                            throw e4;
                                        } catch (Exception e5) {
                                            throw new CompileException("failed to compileShared sub expression", new char[0], 0, e5);
                                        }
                                    }
                                }
                            } else if (firstNode.nextASTNode != null) {
                                gVar.b();
                            }
                        }
                    } else if (z || (z = b())) {
                        try {
                            ((xz.b) a.get()).a((LineLabel) firstNode, variableResolverFactory, compiledExpression);
                        } catch (NullPointerException unused) {
                        }
                    }
                    firstNode = firstNode.nextASTNode;
                } catch (NullPointerException e6) {
                    e = e6;
                }
            } finally {
                org.mvel2.optimizers.b.a();
            }
        } while (firstNode != null);
        return gVar.k();
    }

    public static boolean b() {
        ThreadLocal threadLocal = a;
        return (threadLocal == null || threadLocal.get() == null) ? false : true;
    }
}
