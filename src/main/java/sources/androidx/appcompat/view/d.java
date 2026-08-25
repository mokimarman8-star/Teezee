package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    private static Configuration f413f;

    /* renamed from: a, reason: collision with root package name */
    private int f414a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f415b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f416c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f417d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f418e;

    public d() {
        super(null);
    }

    public d(Context context, int i5) {
        super(context);
        this.f414a = i5;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f415b = theme;
    }

    private Resources b() {
        if (this.f418e == null) {
            Configuration configuration = this.f417d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f418e = super.getResources();
            } else {
                this.f418e = createConfigurationContext(this.f417d).getResources();
            }
        }
        return this.f418e;
    }

    private void d() {
        boolean z5 = this.f415b == null;
        if (z5) {
            this.f415b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f415b.setTo(theme);
            }
        }
        f(this.f415b, this.f414a, z5);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f413f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f413f = configuration2;
        }
        return configuration.equals(f413f);
    }

    public void a(Configuration configuration) {
        if (this.f418e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f417d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f417d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f414a;
    }

    protected void f(Resources.Theme theme, int i5, boolean z5) {
        theme.applyStyle(i5, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f416c == null) {
            this.f416c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f416c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f415b;
        if (theme != null) {
            return theme;
        }
        if (this.f414a == 0) {
            this.f414a = R.style.Theme_AppCompat_Light;
        }
        d();
        return this.f415b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i5) {
        if (this.f414a != i5) {
            this.f414a = i5;
            d();
        }
    }
}
