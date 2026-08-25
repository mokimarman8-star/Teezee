package xz;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.mvel2.ast.LineLabel;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b {
    private int b = 0;
    private Map a = new HashMap();

    public int a(LineLabel lineLabel, VariableResolverFactory variableResolverFactory, CompiledExpression compiledExpression) {
        if (this.b == 1 || b(lineLabel)) {
            throw new RuntimeException("no debugger registered to handle breakpoint");
        }
        return 0;
    }

    public boolean b(LineLabel lineLabel) {
        return this.a.containsKey(lineLabel.getSourceFile()) && ((Set) this.a.get(lineLabel.getSourceFile())).contains(Integer.valueOf(lineLabel.getLineNumber()));
    }
}
