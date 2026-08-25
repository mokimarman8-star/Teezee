package lf;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d implements mf.a {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        r7 = lf.e.d(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object b(Object obj, String str) {
        boolean e;
        Object g;
        Class d;
        Class d2;
        if (obj == null || str == null) {
            return null;
        }
        String name = obj.getClass().getName();
        Intrinsics.g(name, "getName(...)");
        e = e.e(name, str);
        if (e) {
            return obj;
        }
        if (Intrinsics.c(obj.getClass().getName(), "java.lang.String") || Intrinsics.c(obj.getClass().getName(), "kotlin.String")) {
            try {
                g = e.g(str, obj.toString());
                return g;
            } catch (NumberFormatException unused) {
            }
        }
        if ((obj instanceof Serializable) || (obj instanceof Parcelable)) {
            return obj;
        }
        String name2 = obj.getClass().getName();
        Intrinsics.g(name2, "getName(...)");
        if (StringsKt.b0(name2, '$', false, 2, (Object) null)) {
            d = e.d(str);
            if (Intrinsics.c(d != null ? d.getName() : null, obj.getClass().getName()) || (d2 != null && d2.isAssignableFrom(obj.getClass()))) {
                return obj;
            }
        }
        return null;
    }

    @Override // mf.a
    public Object a(String str, Object obj, com.therouter.router.b bVar) {
        Bundle extras;
        if (bVar != null && bVar.a() == 0) {
            if (obj instanceof Activity) {
                Intent intent = ((Activity) obj).getIntent();
                if (intent != null && (extras = intent.getExtras()) != null) {
                    r0 = extras.get(bVar.b());
                }
                return b(r0, str);
            }
            if (obj instanceof Fragment) {
                Bundle arguments = ((Fragment) obj).getArguments();
                return b(arguments != null ? arguments.get(bVar.b()) : null, str);
            }
            if (obj instanceof androidx.fragment.app.Fragment) {
                Bundle arguments2 = ((androidx.fragment.app.Fragment) obj).getArguments();
                return b(arguments2 != null ? arguments2.get(bVar.b()) : null, str);
            }
        }
        return null;
    }
}
