package f00;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.TemplateError;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class a implements c {
    private Map a = new HashMap();

    @Override // f00.c
    public CompiledTemplate a(String str) {
        CompiledTemplate compiledTemplate = (CompiledTemplate) this.a.get(str);
        if (compiledTemplate != null) {
            return compiledTemplate;
        }
        throw new TemplateError("no named template exists '" + str + "'");
    }

    @Override // f00.c
    public void b(String str, CompiledTemplate compiledTemplate) {
        this.a.put(str, compiledTemplate);
    }
}
