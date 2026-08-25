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
public class IfNode extends BlockNode {
    protected ExecutableStatement condition;
    protected ExecutableStatement elseBlock;
    protected IfNode elseIf;
    protected boolean idxAlloc;
    protected ExecutableStatement nestedStatement;

    public IfNode(char[] cArr, int i, int i2, int i3, int i4, int i6, ParserContext parserContext) {
        super(parserContext);
        boolean z = false;
        this.idxAlloc = false;
        this.expr = cArr;
        if (cArr == null || i2 == 0) {
            throw new CompileException("statement expected", cArr, i);
        }
        this.start = i;
        this.offset = i2;
        this.blockStart = i3;
        this.blockOffset = i4;
        if (parserContext != null && parserContext.isIndexAllocation()) {
            z = true;
        }
        this.idxAlloc = z;
        if ((i6 & 16) != 0) {
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, i, i2, parserContext);
            this.condition = executableStatement;
            e.c(parserContext, executableStatement, Boolean.class, true);
            if (parserContext != null) {
                parserContext.pushVariableScope();
            }
            this.nestedStatement = (ExecutableStatement) m.I0(cArr, i3, i4, parserContext);
            if (parserContext != null) {
                parserContext.popVariableScope();
            }
        }
    }

    public ExecutableStatement getElseBlock() {
        return this.elseBlock;
    }

    public ExecutableStatement getNestedStatement() {
        return this.nestedStatement;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (((Boolean) org.mvel2.d.o(this.expr, this.start, this.offset, obj, variableResolverFactory)).booleanValue()) {
            return org.mvel2.d.o(this.expr, this.blockStart, this.blockOffset, obj, new MapVariableResolverFactory(new HashMap(0), variableResolverFactory));
        }
        IfNode ifNode = this.elseIf;
        if (ifNode != null) {
            return ifNode.getReducedValue(obj, obj2, new MapVariableResolverFactory(new HashMap(0), variableResolverFactory));
        }
        ExecutableStatement executableStatement = this.elseBlock;
        if (executableStatement != null) {
            return executableStatement.getValue(obj, obj2, new MapVariableResolverFactory(new HashMap(0), variableResolverFactory));
        }
        return null;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (((Boolean) this.condition.getValue(obj, obj2, variableResolverFactory)).booleanValue()) {
            ExecutableStatement executableStatement = this.nestedStatement;
            if (!this.idxAlloc) {
                variableResolverFactory = new MapVariableResolverFactory(new HashMap(0), variableResolverFactory);
            }
            return executableStatement.getValue(obj, obj2, variableResolverFactory);
        }
        IfNode ifNode = this.elseIf;
        if (ifNode != null) {
            if (!this.idxAlloc) {
                variableResolverFactory = new MapVariableResolverFactory(new HashMap(0), variableResolverFactory);
            }
            return ifNode.getReducedValueAccelerated(obj, obj2, variableResolverFactory);
        }
        ExecutableStatement executableStatement2 = this.elseBlock;
        if (executableStatement2 == null) {
            return null;
        }
        if (!this.idxAlloc) {
            variableResolverFactory = new MapVariableResolverFactory(new HashMap(0), variableResolverFactory);
        }
        return executableStatement2.getValue(obj, obj2, variableResolverFactory);
    }

    public IfNode setElseBlock(char[] cArr, int i, int i2, ParserContext parserContext) {
        this.elseBlock = (ExecutableStatement) m.I0(cArr, i, i2, parserContext);
        return this;
    }

    public IfNode setElseIf(IfNode ifNode) {
        this.elseIf = ifNode;
        return ifNode;
    }

    @Override // org.mvel2.ast.ASTNode
    public String toString() {
        return new String(this.expr, this.start, this.offset);
    }
}
