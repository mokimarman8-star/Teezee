package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g0 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f1035c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList f1036d;

    /* renamed from: a, reason: collision with root package name */
    private final Resources f1037a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources.Theme f1038b;

    private g0(Context context) {
        super(context);
        if (!t0.c()) {
            this.f1037a = new i0(this, context.getResources());
            this.f1038b = null;
            return;
        }
        t0 t0Var = new t0(this, context.getResources());
        this.f1037a = t0Var;
        Resources.Theme newTheme = t0Var.newTheme();
        this.f1038b = newTheme;
        newTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof g0) || (context.getResources() instanceof i0) || (context.getResources() instanceof t0)) {
            return false;
        }
        return t0.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1035c) {
            try {
                ArrayList arrayList = f1036d;
                if (arrayList == null) {
                    f1036d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f1036d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f1036d.remove(size);
                        }
                    }
                    for (int size2 = f1036d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f1036d.get(size2);
                        g0 g0Var = weakReference2 != null ? (g0) weakReference2.get() : null;
                        if (g0Var != null && g0Var.getBaseContext() == context) {
                            return g0Var;
                        }
                    }
                }
                g0 g0Var2 = new g0(context);
                f1036d.add(new WeakReference(g0Var2));
                return g0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1037a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1037a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1038b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i5) {
        Resources.Theme theme = this.f1038b;
        if (theme == null) {
            super.setTheme(i5);
        } else {
            theme.applyStyle(i5, true);
        }
    }
}
