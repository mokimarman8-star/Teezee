package org.mvel2.ast;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ClassImportResolverFactory;
import org.mvel2.integration.impl.ImmutableDefaultFactory;
import org.mvel2.integration.impl.StackResetResolverFactory;
import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class ImportNode extends ASTNode {
    private static final char[] WC_TEST = {'.', '*'};
    private int _offset;
    private Class importClass;
    private boolean packageImport;

    public ImportNode(char[] cArr, int i, int i2, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.start = i;
        this.offset = i2;
        this.pCtx = parserContext;
        if (m.A(cArr, i, i2, WC_TEST)) {
            this.packageImport = true;
            short G = (short) m.G(cArr, i, i2, '.');
            this._offset = G;
            if (G == -1) {
                this._offset = 0;
                return;
            }
            return;
        }
        String str = new String(cArr, i, i2);
        ClassLoader classLoader = getClassLoader();
        try {
            this.importClass = Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            int lastIndexOf = str.lastIndexOf(46);
            sb.append(str.substring(0, lastIndexOf));
            sb.append("$");
            sb.append(str.substring(lastIndexOf + 1));
            try {
                this.importClass = Class.forName(sb.toString().trim(), true, classLoader);
            } catch (ClassNotFoundException unused2) {
                throw new CompileException("class not found: " + new String(cArr), cArr, i);
            }
        }
    }

    public Class getImportClass() {
        return this.importClass;
    }

    public String getPackageImport() {
        char[] cArr = this.expr;
        int i = this.start;
        return new String(cArr, i, this._offset - i);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return getReducedValueAccelerated(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.packageImport) {
            if (!org.mvel2.d.k) {
                return m.E(variableResolverFactory, this.pCtx).addClass(this.importClass);
            }
            variableResolverFactory.createVariable(this.importClass.getSimpleName(), this.importClass);
            return this.importClass;
        }
        if (variableResolverFactory instanceof ImmutableDefaultFactory) {
            return null;
        }
        if ((variableResolverFactory instanceof StackResetResolverFactory) && (((StackResetResolverFactory) variableResolverFactory).getDelegate() instanceof ImmutableDefaultFactory)) {
            return null;
        }
        ClassImportResolverFactory E = m.E(variableResolverFactory, this.pCtx);
        char[] cArr = this.expr;
        int i = this.start;
        E.addPackageImport(new String(cArr, i, this._offset - i));
        return null;
    }

    public boolean isPackageImport() {
        return this.packageImport;
    }

    public void setPackageImport(boolean z) {
        this.packageImport = z;
    }
}
