package androidx.coroutines.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.coroutines.AbstractC0216j;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static final String f14116a = AbstractC0216j.i("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z5) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z5 ? 1 : 2, 1);
            AbstractC0216j e5 = AbstractC0216j.e();
            String str = f14116a;
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z5 ? "enabled" : "disabled");
            e5.a(str, sb.toString());
        } catch (Exception e6) {
            AbstractC0216j e7 = AbstractC0216j.e();
            String str2 = f14116a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            sb2.append(z5 ? "enabled" : "disabled");
            e7.b(str2, sb2.toString(), e6);
        }
    }
}
