package androidx.activity;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class w {

    public static final class a extends u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f154a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z5, Function1 function1) {
            super(z5);
            this.f154a = function1;
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            this.f154a.invoke(this);
        }
    }

    public static final u a(OnBackPressedDispatcher onBackPressedDispatcher, androidx.view.u uVar, boolean z5, Function1 function1) {
        Intrinsics.h(onBackPressedDispatcher, "<this>");
        Intrinsics.h(function1, "onBackPressed");
        a aVar = new a(z5, function1);
        if (uVar != null) {
            onBackPressedDispatcher.i(uVar, aVar);
        } else {
            onBackPressedDispatcher.h(aVar);
        }
        return aVar;
    }

    public static /* synthetic */ u b(OnBackPressedDispatcher onBackPressedDispatcher, androidx.view.u uVar, boolean z5, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            uVar = null;
        }
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        return a(onBackPressedDispatcher, uVar, z5, function1);
    }
}
