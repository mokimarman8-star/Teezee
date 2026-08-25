package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ImmLeaksCleaner;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ImmLeaksCleaner implements androidx.view.r {

    /* renamed from: b, reason: collision with root package name */
    public static final b f78b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f79c = LazyKt.b(new Function0<a>() { // from class: androidx.activity.ImmLeaksCleaner$Companion$cleaner$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ImmLeaksCleaner.a m10invoke() {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                declaredField3.setAccessible(true);
                Intrinsics.g(declaredField3, "hField");
                Intrinsics.g(declaredField, "servedViewField");
                Intrinsics.g(declaredField2, "nextServedViewField");
                return new ImmLeaksCleaner.d(declaredField3, declaredField, declaredField2);
            } catch (NoSuchFieldException unused) {
                return ImmLeaksCleaner.c.f81a;
            }
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final Activity f80a;

    public static abstract class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract boolean a(InputMethodManager inputMethodManager);

        public abstract Object b(InputMethodManager inputMethodManager);

        public abstract View c(InputMethodManager inputMethodManager);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return (a) ImmLeaksCleaner.f79c.getValue();
        }
    }

    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f81a = new c();

        private c() {
            super(null);
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public boolean a(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            return false;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public Object b(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            return null;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public View c(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            return null;
        }
    }

    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name */
        private final Field f82a;

        /* renamed from: b, reason: collision with root package name */
        private final Field f83b;

        /* renamed from: c, reason: collision with root package name */
        private final Field f84c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Field field, Field field2, Field field3) {
            super(null);
            Intrinsics.h(field, "hField");
            Intrinsics.h(field2, "servedViewField");
            Intrinsics.h(field3, "nextServedViewField");
            this.f82a = field;
            this.f83b = field2;
            this.f84c = field3;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public boolean a(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            try {
                this.f84c.set(inputMethodManager, null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public Object b(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            try {
                return this.f82a.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public View c(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            try {
                return (View) this.f83b.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    public ImmLeaksCleaner(Activity activity) {
        Intrinsics.h(activity, "activity");
        this.f80a = activity;
    }

    @Override // androidx.view.r
    public void onStateChanged(androidx.view.u uVar, Lifecycle.Event event) {
        Intrinsics.h(uVar, "source");
        Intrinsics.h(event, NotificationCompat.CATEGORY_EVENT);
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        Object systemService = this.f80a.getSystemService("input_method");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        a a5 = f78b.a();
        Object b5 = a5.b(inputMethodManager);
        if (b5 == null) {
            return;
        }
        synchronized (b5) {
            View c5 = a5.c(inputMethodManager);
            if (c5 == null) {
                return;
            }
            if (c5.isAttachedToWindow()) {
                return;
            }
            boolean a6 = a5.a(inputMethodManager);
            if (a6) {
                inputMethodManager.isActive();
            }
        }
    }
}
