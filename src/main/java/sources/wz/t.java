package wz;

import org.mvel2.compiler.BlankLiteral;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class t implements org.mvel2.a {
    @Override // org.mvel2.a
    public boolean a(Class cls) {
        return cls != BlankLiteral.class;
    }

    @Override // org.mvel2.a
    public Object b(Object obj) {
        return String.valueOf(obj);
    }
}
