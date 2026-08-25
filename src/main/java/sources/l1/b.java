package l1;

import android.text.Editable;
import androidx.emoji2.text.o;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f16380a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f16381b;

    /* renamed from: c, reason: collision with root package name */
    private static Class f16382c;

    private b() {
        try {
            f16382c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f16381b == null) {
            synchronized (f16380a) {
                try {
                    if (f16381b == null) {
                        f16381b = new b();
                    }
                } finally {
                }
            }
        }
        return f16381b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f16382c;
        return cls != null ? o.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
