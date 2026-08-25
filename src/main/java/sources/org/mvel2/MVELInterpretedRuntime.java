package org.mvel2;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.Substatement;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.BlankLiteral;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ImmutableDefaultFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class MVELInterpretedRuntime extends AbstractParser {
    private static final Logger LOG = Logger.getLogger(MVELInterpretedRuntime.class.getName());
    private Object holdOverRegister;

    MVELInterpretedRuntime(String str) {
        setExpression(str);
        this.variableFactory = new ImmutableDefaultFactory();
    }

    MVELInterpretedRuntime(String str, Object obj) {
        setExpression(str);
        this.ctx = obj;
        this.variableFactory = new ImmutableDefaultFactory();
    }

    public MVELInterpretedRuntime(String str, Object obj, VariableResolverFactory variableResolverFactory) {
        setExpression(str);
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    public MVELInterpretedRuntime(String str, Object obj, VariableResolverFactory variableResolverFactory, ParserContext parserContext) {
        super(parserContext);
        setExpression(str);
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    MVELInterpretedRuntime(String str, VariableResolverFactory variableResolverFactory) {
        setExpression(str);
        this.variableFactory = variableResolverFactory;
        this.pCtx.initializeTables();
    }

    MVELInterpretedRuntime(char[] cArr) {
        this.expr = cArr;
        int length = cArr.length;
        this.end = length;
        this.length = length;
    }

    public MVELInterpretedRuntime(char[] cArr, int i, int i2, Object obj, VariableResolverFactory variableResolverFactory) {
        this.expr = cArr;
        this.start = i;
        int i3 = i2 + i;
        this.end = i3;
        this.length = i3 - i;
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    public MVELInterpretedRuntime(char[] cArr, int i, int i2, Object obj, VariableResolverFactory variableResolverFactory, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.start = i;
        int i3 = i2 + i;
        this.end = i3;
        this.length = i3 - i;
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    MVELInterpretedRuntime(char[] cArr, Object obj) {
        this.expr = cArr;
        this.length = cArr.length;
        this.ctx = obj;
        this.variableFactory = new ImmutableDefaultFactory();
    }

    MVELInterpretedRuntime(char[] cArr, Object obj, Map<String, Object> map) {
        this.expr = cArr;
        this.length = cArr.length;
        this.ctx = obj;
        this.variableFactory = new MapVariableResolverFactory(map);
    }

    public MVELInterpretedRuntime(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory) {
        this.expr = cArr;
        int length = cArr.length;
        this.end = length;
        this.length = length;
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    private boolean hasMore() {
        return this.cursor <= this.end;
    }

    private Object parseAndExecuteInterpreted() {
        this.lastWasIdentifier = false;
        ASTNode aSTNode = null;
        while (true) {
            try {
                aSTNode = nextToken();
                if (aSTNode == null) {
                    Object obj = this.holdOverRegister;
                    return obj != null ? obj : this.stk.k();
                }
                this.holdOverRegister = null;
                if (this.lastWasIdentifier && this.lastNode.isDiscard()) {
                    this.stk.e();
                }
                if (this.stk.g()) {
                    if ((aSTNode.fields & ASTNode.STACKLANG) != 0) {
                        org.mvel2.util.g gVar = this.stk;
                        gVar.q(aSTNode.getReducedValue(gVar, this.ctx, this.variableFactory));
                        Object k = this.stk.k();
                        if (k instanceof Integer) {
                            arithmeticFunctionReduction(((Integer) k).intValue());
                        }
                    } else {
                        org.mvel2.util.g gVar2 = this.stk;
                        Object obj2 = this.ctx;
                        gVar2.q(aSTNode.getReducedValue(obj2, obj2, this.variableFactory));
                    }
                    if ((aSTNode instanceof Substatement) && (aSTNode = nextToken()) != null) {
                        Integer operator = aSTNode.getOperator();
                        int intValue = operator.intValue();
                        if (AbstractParser.isArithmeticOperator(intValue)) {
                            org.mvel2.util.g gVar3 = this.stk;
                            ASTNode nextToken = nextToken();
                            Object obj3 = this.ctx;
                            gVar3.r(nextToken.getReducedValue(obj3, obj3, this.variableFactory), operator);
                            if (procBooleanOperator(arithmeticFunctionReduction(intValue)) == -1) {
                                return this.stk.k();
                            }
                        }
                    }
                }
                if (this.variableFactory.tiltFlag()) {
                    return this.stk.n();
                }
                Integer operator2 = aSTNode.getOperator();
                int intValue2 = operator2.intValue();
                int procBooleanOperator = procBooleanOperator(intValue2);
                if (procBooleanOperator != -2) {
                    if (procBooleanOperator == -1) {
                        return this.stk.k();
                    }
                    if (procBooleanOperator == 0) {
                        continue;
                    } else {
                        if (procBooleanOperator == 99) {
                            this.variableFactory.setTiltFlag(true);
                            return this.stk.n();
                        }
                        org.mvel2.util.g gVar4 = this.stk;
                        ASTNode nextToken2 = nextToken();
                        Object obj4 = this.ctx;
                        gVar4.r(nextToken2.getReducedValue(obj4, obj4, this.variableFactory), operator2);
                        int arithmeticFunctionReduction = arithmeticFunctionReduction(intValue2);
                        if (arithmeticFunctionReduction == -1) {
                            return this.stk.k();
                        }
                        if (arithmeticFunctionReduction != 0 && procBooleanOperator(arithmeticFunctionReduction) == -1) {
                            return this.stk.k();
                        }
                    }
                } else if (aSTNode.isOperator()) {
                    continue;
                } else {
                    if (!(this.stk.k() instanceof Class)) {
                        throw new CompileException("unexpected token or unknown identifier:" + aSTNode.getName(), this.expr, this.st);
                    }
                    this.variableFactory.createVariable(aSTNode.getName(), null, (Class) this.stk.k());
                }
            } catch (NullPointerException e) {
                if (aSTNode == null || !aSTNode.isOperator()) {
                    throw e;
                }
                CompileException compileException = new CompileException("incomplete statement: " + aSTNode.getName() + " (possible use of reserved keyword as identifier: " + aSTNode.getName() + ")", this.expr, this.st, e);
                compileException.setExpr(this.expr);
                compileException.setLineNumber(this.line);
                compileException.setCursor(this.cursor);
                throw compileException;
            } catch (CompileException e3) {
                throw org.mvel2.util.f.a(e3, this.expr, this.start);
            }
        }
    }

    private int procBooleanOperator(int i) {
        ASTNode nextToken;
        if (i == -1) {
            return -2;
        }
        if (i == 37) {
            if (hasMore()) {
                this.holdOverRegister = this.stk.n();
                this.stk.b();
            }
            return 0;
        }
        if (i == 99) {
            return 99;
        }
        if (i == 29) {
            if (!this.stk.p().booleanValue()) {
                this.stk.b();
                do {
                    nextToken = nextToken();
                    if (nextToken == null) {
                        break;
                    }
                } while (!nextToken.isOperator(30));
            }
            return 0;
        }
        if (i == 30) {
            captureToEOS();
            return 0;
        }
        switch (i) {
            case 21:
                reduceRight();
                if (!this.stk.m().booleanValue()) {
                    if (!unwindStatement(i)) {
                        this.stk.b();
                        break;
                    }
                } else {
                    this.stk.e();
                    break;
                }
                break;
            case 22:
                reduceRight();
                if (!this.stk.m().booleanValue()) {
                    this.stk.e();
                    break;
                } else if (!unwindStatement(i)) {
                    this.stk.b();
                    break;
                }
                break;
            case 23:
                if (!BlankLiteral.INSTANCE.equals(this.stk.k())) {
                }
                break;
        }
        return -1;
    }

    private void reduceRight() {
        if (this.dStack.g()) {
            return;
        }
        this.stk.s(this.dStack.n(), this.stk.n(), this.dStack.n());
        reduce();
    }

    private boolean unwindStatement(int i) {
        ASTNode nextToken;
        if (i == 21) {
            do {
                nextToken = nextToken();
                if (nextToken == null || nextToken.isOperator(37)) {
                    break;
                }
            } while (!nextToken.isOperator(22));
        } else {
            do {
                nextToken = nextToken();
                if (nextToken == null) {
                    break;
                }
            } while (!nextToken.isOperator(37));
        }
        return nextToken == null;
    }

    public Object parse() {
        try {
            this.stk = new org.mvel2.util.g();
            this.dStack = new org.mvel2.util.g();
            this.variableFactory.setTiltFlag(false);
            this.cursor = this.start;
            return parseAndExecuteInterpreted();
        } catch (ArrayIndexOutOfBoundsException e) {
            LOG.log(Level.WARNING, "", (Throwable) e);
            throw new CompileException("unexpected end of statement", this.expr, this.length);
        } catch (NullPointerException e3) {
            LOG.log(Level.WARNING, "", (Throwable) e3);
            if (this.cursor >= this.length) {
                throw new CompileException("unexpected end of statement", this.expr, this.length);
            }
            throw e3;
        } catch (CompileException e4) {
            throw org.mvel2.util.f.a(e4, this.expr, this.cursor);
        }
    }
}
