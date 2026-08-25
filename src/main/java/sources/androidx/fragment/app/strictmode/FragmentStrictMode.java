package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m1.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class FragmentStrictMode {
    public static final FragmentStrictMode a = new FragmentStrictMode();
    private static b b = b.d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    private FragmentStrictMode() {
    }

    private final b b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                Intrinsics.g(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.F0() != null) {
                    b F0 = parentFragmentManager.F0();
                    Intrinsics.e(F0);
                    return F0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return b;
    }

    private final void c(b bVar, Violation violation) {
        Fragment fragment = violation.getFragment();
        String name = fragment.getClass().getName();
        if (bVar.a().contains(Flag.PENALTY_LOG)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Policy violation in ");
            sb.append(name);
        }
        bVar.b();
        if (bVar.a().contains(Flag.PENALTY_DEATH)) {
            o(fragment, new a(name, violation));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, Violation violation) {
        Intrinsics.h(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    private final void e(Violation violation) {
        if (FragmentManager.M0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("StrictMode violation in ");
            sb.append(violation.getFragment().getClass().getName());
        }
    }

    public static final void f(Fragment fragment, String str) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str, "previousFragmentId");
        Violation fragmentReuseViolation = new FragmentReuseViolation(fragment, str);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(fragmentReuseViolation);
        b b2 = fragmentStrictMode.b(fragment);
        if (b2.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.p(b2, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.c(b2, fragmentReuseViolation);
        }
    }

    public static final void g(Fragment fragment, ViewGroup viewGroup) {
        Intrinsics.h(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(fragmentTagUsageViolation);
        b b2 = fragmentStrictMode.b(fragment);
        if (b2.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.p(b2, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.c(b2, fragmentTagUsageViolation);
        }
    }

    public static final void h(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        Violation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(getRetainInstanceUsageViolation);
        b b2 = fragmentStrictMode.b(fragment);
        if (b2.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(b2, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(b2, getRetainInstanceUsageViolation);
        }
    }

    public static final void i(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        Violation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(getTargetFragmentRequestCodeUsageViolation);
        b b2 = fragmentStrictMode.b(fragment);
        if (b2.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(b2, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.c(b2, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    public static final void j(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        Violation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(getTargetFragmentUsageViolation);
        b b2 = fragmentStrictMode.b(fragment);
        if (b2.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(b2, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(b2, getTargetFragmentUsageViolation);
        }
    }

    public static final void k(Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        Violation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(setRetainInstanceUsageViolation);
        b b2 = fragmentStrictMode.b(fragment);
        if (b2.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(b2, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(b2, setRetainInstanceUsageViolation);
        }
    }

    public static final void l(Fragment fragment, Fragment fragment2, int i) {
        Intrinsics.h(fragment, "violatingFragment");
        Intrinsics.h(fragment2, "targetFragment");
        Violation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(fragment, fragment2, i);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(setTargetFragmentUsageViolation);
        b b2 = fragmentStrictMode.b(fragment);
        if (b2.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(b2, fragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(b2, setTargetFragmentUsageViolation);
        }
    }

    public static final void m(Fragment fragment, boolean z) {
        Intrinsics.h(fragment, "fragment");
        Violation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(setUserVisibleHintViolation);
        b b2 = fragmentStrictMode.b(fragment);
        if (b2.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.p(b2, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.c(b2, setUserVisibleHintViolation);
        }
    }

    public static final void n(Fragment fragment, ViewGroup viewGroup) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(viewGroup, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = a;
        fragmentStrictMode.e(wrongFragmentContainerViolation);
        b b2 = fragmentStrictMode.b(fragment);
        if (b2.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.p(b2, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.c(b2, wrongFragmentContainerViolation);
        }
    }

    private final void o(Fragment fragment, Runnable runnable) {
        if (!fragment.isAdded()) {
            runnable.run();
            return;
        }
        Handler g = fragment.getParentFragmentManager().z0().g();
        Intrinsics.g(g, "fragment.parentFragmentManager.host.handler");
        if (Intrinsics.c(g.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            g.post(runnable);
        }
    }

    private final boolean p(b bVar, Class cls, Class cls2) {
        Set set = (Set) bVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (Intrinsics.c(cls2.getSuperclass(), Violation.class) || !CollectionsKt.b0(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
