package org.mvel2.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.CompileException;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class f {
    private static final Logger a = Logger.getLogger(f.class.getName());

    public static CompileException a(CompileException compileException, char[] cArr, int i) {
        if (cArr != compileException.getExpr()) {
            if (compileException.getExpr().length <= compileException.getCursor()) {
                compileException.setCursor(compileException.getExpr().length - 1);
            }
            try {
                String substring = new String(compileException.getExpr()).substring(compileException.getCursor());
                compileException.setExpr(cArr);
                String str = new String(cArr);
                compileException.setCursor(str.substring(str.indexOf(new String(compileException.getExpr()))).indexOf(substring));
            } catch (Throwable th) {
                a.log(Level.WARNING, "", th);
            }
        }
        return compileException;
    }

    public static org.mvel2.c b(org.mvel2.c cVar, char[] cArr, int i) {
        if (cArr != cVar.d()) {
            String substring = new String(cVar.d()).substring(cVar.c());
            cVar.j(cArr);
            cVar.i(i + new String(cArr).substring(i).indexOf(substring));
        }
        return cVar;
    }
}
