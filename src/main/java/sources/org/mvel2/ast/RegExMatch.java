package org.mvel2.ast;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableLiteral;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class RegExMatch extends ASTNode {
    private Pattern p;
    private int patternOffset;
    private int patternStart;
    private ExecutableStatement patternStmt;
    private ExecutableStatement stmt;

    public RegExMatch(char[] cArr, int i, int i2, int i3, int i4, int i6, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        this.patternStart = i4;
        this.patternOffset = i6;
        if ((i3 & 16) != 0) {
            this.stmt = (ExecutableStatement) m.I0(cArr, i, i2, parserContext);
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, i4, i6, parserContext);
            this.patternStmt = executableStatement;
            if (executableStatement instanceof ExecutableLiteral) {
                try {
                    this.p = Pattern.compile(String.valueOf(executableStatement.getValue(null, null)));
                } catch (PatternSyntaxException e) {
                    throw new CompileException("bad regular expression", cArr, i4, e);
                }
            }
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Class getEgressType() {
        return Boolean.class;
    }

    public Pattern getPattern() {
        return this.p;
    }

    public ExecutableStatement getPatternStatement() {
        return this.patternStmt;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            return Boolean.valueOf(Pattern.compile(String.valueOf(org.mvel2.d.o(this.expr, this.patternStart, this.patternOffset, obj, variableResolverFactory))).matcher(String.valueOf(org.mvel2.d.o(this.expr, this.start, this.offset, obj, variableResolverFactory))).matches());
        } catch (PatternSyntaxException e) {
            throw new CompileException("bad regular expression", this.expr, this.patternStart, e);
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Pattern pattern = this.p;
        return pattern == null ? Boolean.valueOf(Pattern.compile(String.valueOf(this.patternStmt.getValue(obj, obj2, variableResolverFactory))).matcher(String.valueOf(this.stmt.getValue(obj, obj2, variableResolverFactory))).matches()) : Boolean.valueOf(pattern.matcher(String.valueOf(this.stmt.getValue(obj, obj2, variableResolverFactory))).matches());
    }

    public ExecutableStatement getStatement() {
        return this.stmt;
    }
}
