package com.iab.omid.library.hisavana.internal;

import android.view.View;
import com.iab.omid.library.hisavana.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {
    private static final Pattern b = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final List a = new ArrayList();

    private void b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void d(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!b.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }

    private e e(View view) {
        for (e eVar : this.a) {
            if (eVar.c().get() == view) {
                return eVar;
            }
        }
        return null;
    }

    public List a() {
        return this.a;
    }

    public void c(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        b(view);
        d(str);
        if (e(view) == null) {
            this.a.add(new e(view, friendlyObstructionPurpose, str));
        }
    }

    public void f() {
        this.a.clear();
    }
}
