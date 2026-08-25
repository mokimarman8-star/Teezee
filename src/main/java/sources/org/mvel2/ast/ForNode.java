package org.mvel2.ast;

import java.util.HashMap;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.util.e;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class ForNode extends BlockNode {
    protected ExecutableStatement after;
    protected ExecutableStatement condition;
    protected boolean indexAlloc;
    protected ExecutableStatement initializer;
    protected String item;

    public ForNode(char[] cArr, int i, int i2, int i3, int i4, int i6, ParserContext parserContext) {
        super(parserContext);
        boolean z = false;
        this.indexAlloc = false;
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        this.blockStart = i3;
        this.blockOffset = i4;
        boolean buildForEach = buildForEach(cArr, i, i2, i3, i4, i6, parserContext);
        if (parserContext != null && parserContext.isIndexAllocation()) {
            z = true;
        }
        this.indexAlloc = z;
        if ((i6 & 16) != 0 && this.compiledBlock.isEmptyStatement() && !buildForEach) {
            throw new RedundantCodeException();
        }
        if (parserContext != null) {
            parserContext.popVariableScope();
        }
    }

    private boolean buildForEach(char[] cArr, int i, int i2, int i3, int i4, int i6, ParserContext parserContext) {
        ParserContext createColoringSubcontext;
        int i7 = i2 + i;
        boolean z = false;
        int nextCondPart = nextCondPart(cArr, i, i7, false);
        try {
            createColoringSubcontext = parserContext != null ? parserContext.createSubcontext().createColoringSubcontext() : new ParserContext();
            this.initializer = (ExecutableStatement) m.I0(cArr, i, (nextCondPart - i) - 1, createColoringSubcontext);
            if (parserContext != null) {
                parserContext.pushVariableScope();
            }
        } catch (NegativeArraySizeException unused) {
        }
        try {
            try {
                i = nextCondPart(cArr, nextCondPart, i7, false);
                ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, nextCondPart, (i - nextCondPart) - 1, createColoringSubcontext);
                this.condition = executableStatement;
                int i8 = i6 & 16;
                e.c(parserContext, executableStatement, Boolean.class, i8 != 0);
                this.after = (ExecutableStatement) m.I0(cArr, i, nextCondPart(cArr, i, i7, true) - i, createColoringSubcontext);
                if (createColoringSubcontext != null && i8 != 0 && createColoringSubcontext.isVariablesEscape()) {
                    if (parserContext != createColoringSubcontext) {
                        parserContext.addVariables(createColoringSubcontext.getVariables());
                    }
                    z = true;
                } else if (createColoringSubcontext != null && parserContext != null) {
                    parserContext.addVariables(createColoringSubcontext.getVariables());
                }
                this.compiledBlock = (ExecutableStatement) m.I0(this.expr, i3, i4, createColoringSubcontext);
                if (parserContext != null) {
                    parserContext.setInputs(createColoringSubcontext.getInputs());
                }
                return z;
            } catch (CompileException e) {
                if (e.getExpr().length == 0) {
                    e.setExpr(this.expr);
                    int i9 = nextCondPart;
                    while (true) {
                        char[] cArr2 = this.expr;
                        if (i9 >= cArr2.length || !m.q0(cArr2[i9])) {
                            break;
                        }
                        i9++;
                    }
                    e.setCursor(i9);
                }
                throw e;
            }
        } catch (NegativeArraySizeException unused2) {
            i = nextCondPart;
            throw new CompileException("wrong syntax; did you mean to use 'foreach'?", this.expr, i);
        }
    }

    private static int nextCondPart(char[] cArr, int i, int i2, boolean z) {
        while (i < i2) {
            if (cArr[i] == ';') {
                return i + 1;
            }
            i++;
        }
        if (z) {
            return i;
        }
        throw new CompileException("expected ;", cArr, i);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        ExecutableStatement executableStatement = this.initializer;
        MapVariableResolverFactory mapVariableResolverFactory = new MapVariableResolverFactory(new HashMap(1), variableResolverFactory);
        executableStatement.getValue(obj, obj2, mapVariableResolverFactory);
        while (((Boolean) this.condition.getValue(obj, obj2, mapVariableResolverFactory)).booleanValue()) {
            Object value = this.compiledBlock.getValue(obj, obj2, mapVariableResolverFactory);
            if (mapVariableResolverFactory.tiltFlag()) {
                return value;
            }
            this.after.getValue(obj, obj2, mapVariableResolverFactory);
        }
        return null;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.indexAlloc) {
            variableResolverFactory = new MapVariableResolverFactory(new HashMap(1), variableResolverFactory);
        }
        ExecutableStatement executableStatement = this.initializer;
        while (true) {
            executableStatement.getValue(obj, obj2, variableResolverFactory);
            if (!((Boolean) this.condition.getValue(obj, obj2, variableResolverFactory)).booleanValue()) {
                return null;
            }
            Object value = this.compiledBlock.getValue(obj, obj2, variableResolverFactory);
            if (variableResolverFactory.tiltFlag()) {
                return value;
            }
            executableStatement = this.after;
        }
    }
}
