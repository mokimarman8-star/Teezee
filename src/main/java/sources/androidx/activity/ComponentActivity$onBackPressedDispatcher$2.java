package androidx.activity;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/activity/OnBackPressedDispatcher;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class ComponentActivity$onBackPressedDispatcher$2 extends Lambda implements Function0<OnBackPressedDispatcher> {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComponentActivity$onBackPressedDispatcher$2(ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ComponentActivity componentActivity) {
        try {
            ComponentActivity.access$onBackPressed$s1027565324(componentActivity);
        } catch (IllegalStateException e5) {
            if (!Intrinsics.c(e5.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e5;
            }
        } catch (NullPointerException e6) {
            if (!Intrinsics.c(e6.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        ComponentActivity.access$addObserverForBackInvoker(componentActivity, onBackPressedDispatcher);
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final OnBackPressedDispatcher m9invoke() {
        final ComponentActivity componentActivity = this.this$0;
        final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.m
            @Override // java.lang.Runnable
            public final void run() {
                ComponentActivity$onBackPressedDispatcher$2.c(componentActivity);
            }
        });
        final ComponentActivity componentActivity2 = this.this$0;
        if (Build.VERSION.SDK_INT >= 33) {
            if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
                ComponentActivity.access$addObserverForBackInvoker(componentActivity2, onBackPressedDispatcher);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity$onBackPressedDispatcher$2.d(componentActivity2, onBackPressedDispatcher);
                    }
                });
            }
        }
        return onBackPressedDispatcher;
    }
}
