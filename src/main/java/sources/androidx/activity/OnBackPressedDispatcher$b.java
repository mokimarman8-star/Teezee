package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class OnBackPressedDispatcher$b {

    /* renamed from: a, reason: collision with root package name */
    public static final OnBackPressedDispatcher$b f86a = new OnBackPressedDispatcher$b();

    public static final class a implements OnBackAnimationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f87a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f88b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0 f89c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0 f90d;

        a(Function1 function1, Function1 function12, Function0 function0, Function0 function02) {
            this.f87a = function1;
            this.f88b = function12;
            this.f89c = function0;
            this.f90d = function02;
        }

        @Override // android.window.OnBackAnimationCallback
        public void onBackCancelled() {
            this.f90d.invoke();
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            this.f89c.invoke();
        }

        @Override // android.window.OnBackAnimationCallback
        public void onBackProgressed(BackEvent backEvent) {
            Intrinsics.h(backEvent, "backEvent");
            this.f88b.invoke(new b(backEvent));
        }

        @Override // android.window.OnBackAnimationCallback
        public void onBackStarted(BackEvent backEvent) {
            Intrinsics.h(backEvent, "backEvent");
            this.f87a.invoke(new b(backEvent));
        }
    }

    private OnBackPressedDispatcher$b() {
    }

    public final OnBackInvokedCallback a(Function1 function1, Function1 function12, Function0 function0, Function0 function02) {
        Intrinsics.h(function1, "onBackStarted");
        Intrinsics.h(function12, "onBackProgressed");
        Intrinsics.h(function0, "onBackInvoked");
        Intrinsics.h(function02, "onBackCancelled");
        return new a(function1, function12, function0, function02);
    }
}
