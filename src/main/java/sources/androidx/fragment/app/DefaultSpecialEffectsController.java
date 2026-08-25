package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.a;
import androidx.core.app.a0;
import androidx.core.util.i;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {
    DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List list, List list2, boolean z, Map map) {
        int i;
        boolean z2;
        Context context;
        View view;
        int i2;
        SpecialEffectsController.Operation operation;
        ViewGroup m = m();
        Context context2 = m.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z3 = false;
        while (true) {
            i = 2;
            if (!it.hasNext()) {
                break;
            }
            e eVar = (e) it.next();
            if (eVar.d()) {
                eVar.a();
            } else {
                FragmentAnim.a e = eVar.e(context2);
                if (e == null) {
                    eVar.a();
                } else {
                    Animator animator = e.b;
                    if (animator == null) {
                        arrayList.add(eVar);
                    } else {
                        SpecialEffectsController.Operation b = eVar.b();
                        Fragment f = b.f();
                        if (Boolean.TRUE.equals(map.get(b))) {
                            if (FragmentManager.M0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + f + " as this Fragment was involved in a Transition.");
                            }
                            eVar.a();
                        } else {
                            boolean z4 = b.e() == SpecialEffectsController.Operation.State.GONE;
                            if (z4) {
                                list2.remove(b);
                            }
                            View view2 = f.mView;
                            m.startViewTransition(view2);
                            animator.addListener(new b(this, m, view2, z4, b, eVar));
                            animator.setTarget(view2);
                            animator.start();
                            if (FragmentManager.M0(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Animator from operation ");
                                operation = b;
                                sb.append(operation);
                                sb.append(" has started.");
                                Log.v("FragmentManager", sb.toString());
                            } else {
                                operation = b;
                            }
                            eVar.c().b(new c(this, animator, operation));
                            z3 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            e eVar2 = (e) it2.next();
            SpecialEffectsController.Operation b2 = eVar2.b();
            Fragment f2 = b2.f();
            if (z) {
                if (FragmentManager.M0(i)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f2 + " as Animations cannot run alongside Transitions.");
                }
                eVar2.a();
            } else if (z3) {
                if (FragmentManager.M0(i)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f2 + " as Animations cannot run alongside Animators.");
                }
                eVar2.a();
            } else {
                View view3 = f2.mView;
                Animation animation = (Animation) i.g(((FragmentAnim.a) i.g(eVar2.e(context2))).a);
                if (b2.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation);
                    eVar2.a();
                    z2 = z3;
                    context = context2;
                    i2 = i;
                    view = view3;
                } else {
                    m.startViewTransition(view3);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation, m, view3);
                    z2 = z3;
                    context = context2;
                    view = view3;
                    endViewTransitionAnimation.setAnimationListener(new 4(this, b2, m, view3, eVar2));
                    view.startAnimation(endViewTransitionAnimation);
                    i2 = 2;
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + b2 + " has started.");
                    }
                }
                eVar2.c().b(new d(this, view, m, eVar2, b2));
                i = i2;
                z3 = z2;
                context2 = context;
            }
        }
    }

    private Map x(List list, List list2, boolean z, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation operation4;
        View view2;
        a aVar;
        SpecialEffectsController.Operation operation5;
        HashMap hashMap;
        ArrayList arrayList3;
        View view3;
        FragmentTransitionImpl fragmentTransitionImpl;
        ArrayList arrayList4;
        SpecialEffectsController.Operation operation6;
        Rect rect;
        a0 enterTransitionCallback;
        a0 exitTransitionCallback;
        ArrayList<String> arrayList5;
        int i;
        View view4;
        String b;
        ArrayList<String> arrayList6;
        boolean z2 = z;
        SpecialEffectsController.Operation operation7 = operation;
        SpecialEffectsController.Operation operation8 = operation2;
        HashMap hashMap2 = new HashMap();
        Iterator it = list.iterator();
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (!gVar.d()) {
                FragmentTransitionImpl e = gVar.e();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = e;
                } else if (e != null && fragmentTransitionImpl2 != e) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + gVar.b().f() + " returned Transition " + gVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                g gVar2 = (g) it2.next();
                hashMap2.put(gVar2.b(), Boolean.FALSE);
                gVar2.a();
            }
            return hashMap2;
        }
        View view5 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        a aVar2 = new a();
        Iterator it3 = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z3 = false;
        while (true) {
            str = "FragmentManager";
            if (!it3.hasNext()) {
                break;
            }
            g gVar3 = (g) it3.next();
            if (!gVar3.i() || operation7 == null || operation8 == null) {
                aVar = aVar2;
                operation5 = operation7;
                hashMap = hashMap2;
                arrayList3 = arrayList7;
                view3 = view5;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                arrayList4 = arrayList8;
                operation6 = operation8;
                rect = rect2;
                view6 = view6;
            } else {
                Object u = fragmentTransitionImpl2.u(fragmentTransitionImpl2.f(gVar3.g()));
                ArrayList<String> sharedElementSourceNames = operation2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.f().getSharedElementTargetNames();
                View view7 = view6;
                HashMap hashMap3 = hashMap2;
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList<String> arrayList9 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList9;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.f().getSharedElementTargetNames();
                if (z2) {
                    enterTransitionCallback = operation.f().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.f().getExitTransitionCallback();
                } else {
                    enterTransitionCallback = operation.f().getExitTransitionCallback();
                    exitTransitionCallback = operation2.f().getEnterTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                View view8 = view5;
                int i3 = 0;
                while (i3 < size) {
                    aVar2.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                    i3++;
                    size = size;
                    rect2 = rect2;
                }
                Rect rect3 = rect2;
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator<String> it4 = sharedElementTargetNames2.iterator(); it4.hasNext(); it4 = it4) {
                        Log.v("FragmentManager", "Name: " + it4.next());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator<String> it5 = sharedElementSourceNames.iterator(); it5.hasNext(); it5 = it5) {
                        Log.v("FragmentManager", "Name: " + it5.next());
                    }
                }
                a aVar3 = new a();
                u(aVar3, operation.f().mView);
                aVar3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "Executing exit callback for operation " + operation7);
                    }
                    enterTransitionCallback.d(sharedElementSourceNames, aVar3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str4 = sharedElementSourceNames.get(size2);
                        View view9 = (View) aVar3.get(str4);
                        if (view9 == null) {
                            aVar2.remove(str4);
                            arrayList6 = sharedElementSourceNames;
                        } else {
                            arrayList6 = sharedElementSourceNames;
                            if (!str4.equals(ViewCompat.getTransitionName(view9))) {
                                aVar2.put(ViewCompat.getTransitionName(view9), (String) aVar2.remove(str4));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList6;
                    }
                    arrayList5 = sharedElementSourceNames;
                } else {
                    arrayList5 = sharedElementSourceNames;
                    aVar2.retainAll(aVar3.keySet());
                }
                a aVar4 = new a();
                u(aVar4, operation2.f().mView);
                aVar4.retainAll(sharedElementTargetNames2);
                aVar4.retainAll(aVar2.values());
                if (exitTransitionCallback != null) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "Executing enter callback for operation " + operation8);
                    }
                    exitTransitionCallback.d(sharedElementTargetNames2, aVar4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str5 = sharedElementTargetNames2.get(size3);
                        View view10 = (View) aVar4.get(str5);
                        if (view10 == null) {
                            String b2 = x.b(aVar2, str5);
                            if (b2 != null) {
                                aVar2.remove(b2);
                            }
                        } else if (!str5.equals(ViewCompat.getTransitionName(view10)) && (b = x.b(aVar2, str5)) != null) {
                            aVar2.put(b, ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    x.d(aVar2, aVar4);
                }
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    aVar = aVar2;
                    arrayList4 = arrayList8;
                    operation5 = operation7;
                    arrayList3 = arrayList7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    view6 = view7;
                    view3 = view8;
                    hashMap = hashMap3;
                    rect = rect3;
                    obj3 = null;
                    operation6 = operation8;
                } else {
                    x.a(operation2.f(), operation.f(), z2, aVar3, true);
                    aVar = aVar2;
                    ArrayList arrayList10 = arrayList8;
                    OneShotPreDrawListener.add(m(), new 6(this, operation2, operation, z, aVar4));
                    arrayList7.addAll(aVar3.values());
                    if (arrayList5.isEmpty()) {
                        i = 0;
                        view6 = view7;
                    } else {
                        i = 0;
                        view6 = (View) aVar3.get(arrayList5.get(0));
                        fragmentTransitionImpl2.p(u, view6);
                    }
                    arrayList10.addAll(aVar4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view4 = (View) aVar4.get(sharedElementTargetNames2.get(i))) == null) {
                        rect = rect3;
                        view3 = view8;
                    } else {
                        rect = rect3;
                        OneShotPreDrawListener.add(m(), new 7(this, fragmentTransitionImpl2, view4, rect));
                        view3 = view8;
                        z3 = true;
                    }
                    fragmentTransitionImpl2.s(u, view3, arrayList7);
                    arrayList3 = arrayList7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.n(u, (Object) null, (ArrayList) null, (Object) null, (ArrayList) null, u, arrayList10);
                    Boolean bool = Boolean.TRUE;
                    operation5 = operation;
                    arrayList4 = arrayList10;
                    hashMap = hashMap3;
                    hashMap.put(operation5, bool);
                    operation6 = operation2;
                    hashMap.put(operation6, bool);
                    obj3 = u;
                }
            }
            view5 = view3;
            rect2 = rect;
            arrayList7 = arrayList3;
            arrayList8 = arrayList4;
            operation8 = operation6;
            z2 = z;
            hashMap2 = hashMap;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
            operation7 = operation5;
            aVar2 = aVar;
        }
        View view11 = view6;
        a aVar5 = aVar2;
        SpecialEffectsController.Operation operation9 = operation7;
        HashMap hashMap4 = hashMap2;
        ArrayList arrayList11 = arrayList7;
        View view12 = view5;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        ArrayList arrayList12 = arrayList8;
        SpecialEffectsController.Operation operation10 = operation8;
        Rect rect4 = rect2;
        ArrayList arrayList13 = new ArrayList();
        Iterator it6 = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it6.hasNext()) {
            g gVar4 = (g) it6.next();
            if (gVar4.d()) {
                hashMap4.put(gVar4.b(), Boolean.FALSE);
                gVar4.a();
                it6 = it6;
            } else {
                Iterator it7 = it6;
                Object f = fragmentTransitionImpl3.f(gVar4.h());
                SpecialEffectsController.Operation b3 = gVar4.b();
                boolean z4 = obj3 != null && (b3 == operation9 || b3 == operation10);
                if (f == null) {
                    if (!z4) {
                        hashMap4.put(b3, Boolean.FALSE);
                        gVar4.a();
                    }
                    view = view12;
                    str3 = str;
                    arrayList = arrayList11;
                    arrayList2 = arrayList12;
                    obj = obj4;
                    obj2 = obj5;
                    operation3 = operation10;
                    view2 = view11;
                } else {
                    str3 = str;
                    ArrayList arrayList14 = new ArrayList();
                    Object obj6 = obj4;
                    t(arrayList14, b3.f().mView);
                    if (z4) {
                        if (b3 == operation9) {
                            arrayList14.removeAll(arrayList11);
                        } else {
                            arrayList14.removeAll(arrayList12);
                        }
                    }
                    if (arrayList14.isEmpty()) {
                        fragmentTransitionImpl3.a(f, view12);
                        view = view12;
                        arrayList = arrayList11;
                        arrayList2 = arrayList12;
                        obj2 = obj5;
                        operation4 = b3;
                        operation3 = operation10;
                        obj = obj6;
                    } else {
                        fragmentTransitionImpl3.b(f, arrayList14);
                        view = view12;
                        obj = obj6;
                        arrayList = arrayList11;
                        obj2 = obj5;
                        arrayList2 = arrayList12;
                        operation3 = operation10;
                        fragmentTransitionImpl3.n(f, f, arrayList14, (Object) null, (ArrayList) null, (Object) null, (ArrayList) null);
                        if (b3.e() == SpecialEffectsController.Operation.State.GONE) {
                            operation4 = b3;
                            list2.remove(operation4);
                            ArrayList arrayList15 = new ArrayList(arrayList14);
                            arrayList15.remove(operation4.f().mView);
                            fragmentTransitionImpl3.m(f, operation4.f().mView, arrayList15);
                            OneShotPreDrawListener.add(m(), new 8(this, arrayList14));
                        } else {
                            operation4 = b3;
                        }
                    }
                    if (operation4.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList13.addAll(arrayList14);
                        if (z3) {
                            fragmentTransitionImpl3.o(f, rect4);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        fragmentTransitionImpl3.p(f, view2);
                    }
                    hashMap4.put(operation4, Boolean.TRUE);
                    if (gVar4.j()) {
                        obj2 = fragmentTransitionImpl3.k(obj2, f, (Object) null);
                    } else {
                        obj = fragmentTransitionImpl3.k(obj, f, (Object) null);
                    }
                }
                it6 = it7;
                obj4 = obj;
                view11 = view2;
                obj5 = obj2;
                operation10 = operation3;
                str = str3;
                view12 = view;
                arrayList11 = arrayList;
                arrayList12 = arrayList2;
            }
        }
        String str6 = str;
        ArrayList arrayList16 = arrayList11;
        ArrayList arrayList17 = arrayList12;
        SpecialEffectsController.Operation operation11 = operation10;
        Object j = fragmentTransitionImpl3.j(obj5, obj4, obj3);
        if (j == null) {
            return hashMap4;
        }
        Iterator it8 = list.iterator();
        while (it8.hasNext()) {
            g gVar5 = (g) it8.next();
            if (!gVar5.d()) {
                Object h = gVar5.h();
                SpecialEffectsController.Operation b4 = gVar5.b();
                boolean z5 = obj3 != null && (b4 == operation9 || b4 == operation11);
                if (h == null && !z5) {
                    str2 = str6;
                } else if (ViewCompat.isLaidOut(m())) {
                    str2 = str6;
                    fragmentTransitionImpl3.q(gVar5.b().f(), j, gVar5.c(), new 9(this, gVar5, b4));
                } else {
                    if (FragmentManager.M0(2)) {
                        str2 = str6;
                        Log.v(str2, "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + b4);
                    } else {
                        str2 = str6;
                    }
                    gVar5.a();
                }
                str6 = str2;
            }
        }
        String str7 = str6;
        if (!ViewCompat.isLaidOut(m())) {
            return hashMap4;
        }
        x.e(arrayList13, 4);
        ArrayList l = fragmentTransitionImpl3.l(arrayList17);
        if (FragmentManager.M0(2)) {
            Log.v(str7, ">>>>> Beginning transition <<<<<");
            Log.v(str7, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator it9 = arrayList16.iterator();
            while (it9.hasNext()) {
                View view13 = (View) it9.next();
                Log.v(str7, "View: " + view13 + " Name: " + ViewCompat.getTransitionName(view13));
            }
            Log.v(str7, ">>>>> SharedElementLastInViews <<<<<");
            Iterator it10 = arrayList17.iterator();
            while (it10.hasNext()) {
                View view14 = (View) it10.next();
                Log.v(str7, "View: " + view14 + " Name: " + ViewCompat.getTransitionName(view14));
            }
        }
        fragmentTransitionImpl3.c(m(), j);
        fragmentTransitionImpl3.r(m(), arrayList16, arrayList17, l, aVar5);
        x.e(arrayList13, 0);
        fragmentTransitionImpl3.t(obj3, arrayList16, arrayList17);
        return hashMap4;
    }

    private void y(List list) {
        Fragment f = ((SpecialEffectsController.Operation) list.get(list.size() - 1)).f();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) it.next();
            operation.f().mAnimationInfo.c = f.mAnimationInfo.c;
            operation.f().mAnimationInfo.d = f.mAnimationInfo.d;
            operation.f().mAnimationInfo.e = f.mAnimationInfo.e;
            operation.f().mAnimationInfo.f = f.mAnimationInfo.f;
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void f(List list, boolean z) {
        Iterator it = list.iterator();
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) it.next();
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.f().mView);
            int i = a.a[operation3.e().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        y(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) it2.next();
            androidx.core.os.e eVar = new androidx.core.os.e();
            operation4.j(eVar);
            arrayList.add(new e(operation4, eVar, z));
            androidx.core.os.e eVar2 = new androidx.core.os.e();
            operation4.j(eVar2);
            boolean z2 = false;
            if (z) {
                if (operation4 != operation) {
                    arrayList2.add(new g(operation4, eVar2, z, z2));
                    operation4.a(new 1(this, arrayList3, operation4));
                }
                z2 = true;
                arrayList2.add(new g(operation4, eVar2, z, z2));
                operation4.a(new 1(this, arrayList3, operation4));
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new g(operation4, eVar2, z, z2));
                    operation4.a(new 1(this, arrayList3, operation4));
                }
                z2 = true;
                arrayList2.add(new g(operation4, eVar2, z, z2));
                operation4.a(new 1(this, arrayList3, operation4));
            }
        }
        Map x = x(arrayList2, arrayList3, z, operation, operation2);
        w(arrayList, arrayList3, x.containsValue(Boolean.TRUE), x);
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            s((SpecialEffectsController.Operation) it3.next());
        }
        arrayList3.clear();
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    void s(SpecialEffectsController.Operation operation) {
        operation.e().applyState(operation.f().mView);
    }

    void t(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(a aVar, Collection collection) {
        Iterator it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }
}
