package androidx.fragment.app;

import androidx.lifecycle.ViewModelLazy;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class FragmentViewModelLazyKt {
    public static final Lazy a(Fragment fragment, KClass kClass, Function0 function0, Function0 function02) {
        Intrinsics.h(fragment, "<this>");
        Intrinsics.h(kClass, "viewModelClass");
        Intrinsics.h(function0, "storeProducer");
        if (function02 == null) {
            function02 = new createViewModelLazy.factoryPromise.1(fragment);
        }
        return new ViewModelLazy(kClass, function0, function02);
    }
}
