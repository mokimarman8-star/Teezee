package zz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.script.ScriptEngineFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b implements ScriptEngineFactory {
    private static final List a;
    private static final List b;
    private static final List c;
    private static final a d;

    static {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("mvel");
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        a = unmodifiableList;
        b = unmodifiableList;
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add("application/x-mvel");
        c = Collections.unmodifiableList(arrayList2);
        d = new a();
    }
}
