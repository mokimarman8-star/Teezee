package com.cloud.tmc.miniapp.ui;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cloud.tmc.integration.R;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.PageContext;
import com.cloud.tmc.integration.ui.fragment.IFragmentManager;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.miniutils.util.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TmcFragmentManager implements IFragmentManager {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_EXIT_PAGE = "exitPage";
    private static final int STACK_MAX_SIZE = 10;
    private static final String TAG = "TmcFragmentManager";
    private final WeakReference<FragmentActivity> activity;
    private TmcFragment currentFragment;
    private TmcFragment firstRemoveFragment;
    private LinkedHashMap<String, TmcFragment> fragmentMap;
    private final int layoutId;
    private final ArrayMap<String, TmcFragment> tabCacheFragmentManager;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TmcFragmentManager(FragmentActivity fragmentActivity, int i) {
        Intrinsics.h(fragmentActivity, "activity");
        this.layoutId = i;
        this.activity = new WeakReference<>(fragmentActivity);
        this.fragmentMap = new LinkedHashMap<>();
        this.tabCacheFragmentManager = new ArrayMap<>(5);
    }

    private final boolean exitPage(String str, boolean z, boolean z2) {
        TmcFragment tmcFragment;
        View view;
        androidx.fragment.app.w p;
        androidx.fragment.app.w y;
        Page page;
        boolean z3 = false;
        if (str != null && this.fragmentMap.containsKey(str)) {
            ListIterator listIterator = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
            Intrinsics.g(listIterator, "ArrayList<Map.Entry<Stri…terator(fragmentMap.size)");
            Object obj = "";
            boolean z4 = false;
            TmcFragment tmcFragment2 = null;
            while (listIterator.hasPrevious() && !z4) {
                Object previous = listIterator.previous();
                Intrinsics.g(previous, "iterator.previous()");
                Map.Entry entry = (Map.Entry) previous;
                TmcFragment remove = this.fragmentMap.remove(entry.getKey());
                if (Intrinsics.c(entry.getKey(), str)) {
                    obj = entry.getKey();
                    tmcFragment2 = remove;
                    z4 = true;
                } else {
                    tmcFragment2 = remove;
                }
            }
            if (this.fragmentMap.size() > 0) {
                ListIterator listIterator2 = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
                Intrinsics.g(listIterator2, "ArrayList<Map.Entry<Stri…entMap.size\n            )");
                TmcFragment tmcFragment3 = this.currentFragment;
                if (tmcFragment3 != null) {
                    Page page2 = tmcFragment3.getPage();
                    if (page2 != null) {
                        page2.hide();
                    }
                    tmcFragment3.onPause();
                    tmcFragment3.onStop();
                }
                this.currentFragment = (TmcFragment) ((Map.Entry) listIterator2.previous()).getValue();
                if (!((tmcFragment2 == null || (page = tmcFragment2.getPage()) == null) ? false : page.getBooleanValue("exitPage")) && (tmcFragment = this.currentFragment) != null) {
                    try {
                        FragmentManager innerManager = getInnerManager();
                        if (innerManager != null && (p = innerManager.p()) != null && (y = p.y(tmcFragment)) != null) {
                            y.l();
                        }
                        if (tmcFragment.isAdded() && !tmcFragment.isHidden() && !tmcFragment.isVisible() && (view = tmcFragment.getView()) != null) {
                            Intrinsics.g(view, "view");
                            ViewExtKt.toVisible(view);
                        }
                        Page page3 = tmcFragment.getPage();
                        if (page3 != null) {
                            page3.show();
                        }
                        tmcFragment.onStart();
                        tmcFragment.onResume();
                    } catch (Throwable th) {
                        TmcLogger.e(TAG, "last page resume failed!", th);
                    }
                }
                try {
                    removeFragment(tmcFragment2, z);
                    FragmentManager innerManager2 = getInnerManager();
                    if (innerManager2 != null) {
                        if (innerManager2.T0()) {
                            try {
                                TraceLog.e(TmcConstants.INTEGRATION_TAG, "isStateSaved is true , cant popBackStack");
                            } catch (Throwable th2) {
                                th = th2;
                                TmcLogger.e(TAG, "remove fragment failed!", th);
                                hideAddHomeTips();
                                return z3;
                            }
                        } else {
                            innerManager2.i1((String) obj, 1);
                            innerManager2.g0();
                        }
                    }
                    z3 = z4;
                } catch (Throwable th3) {
                    th = th3;
                    z3 = z4;
                }
            } else {
                if (this.fragmentMap.size() == 0 && z2) {
                    Iterator<Map.Entry<String, TmcFragment>> it = this.tabCacheFragmentManager.entrySet().iterator();
                    while (it.hasNext()) {
                        TmcFragment value = it.next().getValue();
                        try {
                            FragmentManager innerManager3 = getInnerManager();
                            if (innerManager3 != null && !innerManager3.L0()) {
                                if (innerManager3.T0()) {
                                    TraceLog.e(TmcConstants.INTEGRATION_TAG, "isStateSaved is true , cant popBackStack");
                                    z4 = false;
                                } else {
                                    Page page4 = value.getPage();
                                    innerManager3.i1(page4 != null ? page4.getPageId() : null, 1);
                                    innerManager3.g0();
                                }
                            }
                            it.remove();
                        } catch (Throwable th4) {
                            TmcLogger.e(TAG, "fragment manager error", th4);
                        }
                    }
                    release();
                } else {
                    this.currentFragment = null;
                    Iterator<Map.Entry<String, TmcFragment>> it2 = this.tabCacheFragmentManager.entrySet().iterator();
                    while (it2.hasNext()) {
                        TmcFragment value2 = it2.next().getValue();
                        try {
                            FragmentManager innerManager4 = getInnerManager();
                            if (innerManager4 != null) {
                                if (innerManager4.T0()) {
                                    TraceLog.e(TmcConstants.INTEGRATION_TAG, "isStateSaved is true , cant popBackStack");
                                    z4 = false;
                                } else {
                                    Page page5 = value2.getPage();
                                    innerManager4.i1(page5 != null ? page5.getPageId() : null, 1);
                                    innerManager4.g0();
                                }
                            }
                            it2.remove();
                        } catch (Throwable th5) {
                            TmcLogger.e(TAG, "remove tab fragment failed!", th5);
                        }
                    }
                    try {
                        FragmentManager innerManager5 = getInnerManager();
                        if ((innerManager5 == null || innerManager5.T0()) ? false : true) {
                            FragmentManager innerManager6 = getInnerManager();
                            if (innerManager6 != null) {
                                innerManager6.i1((String) obj, 1);
                            }
                        } else {
                            TraceLog.e(TmcConstants.INTEGRATION_TAG, "isStateSaved is true , cant popBackStack");
                        }
                    } catch (Throwable th6) {
                        TmcLogger.e(TAG, "remove fragment popBackStack failed!", th6);
                    }
                }
                z3 = z4;
            }
            hideAddHomeTips();
        }
        return z3;
    }

    public static /* synthetic */ boolean exitPage$default(TmcFragmentManager tmcFragmentManager, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        return tmcFragmentManager.exitPage(str, z, z2);
    }

    private final TmcFragment findFragmentForPage(String str) {
        if (str == null || !this.fragmentMap.containsKey(str)) {
            return null;
        }
        return this.fragmentMap.get(str);
    }

    private final void hideAddHomeTips() {
        Page page;
        App app;
        AppContext appContext;
        try {
            TmcFragment tmcFragment = this.currentFragment;
            Object context = (tmcFragment == null || (page = tmcFragment.getPage()) == null || (app = page.getApp()) == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
            MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (miniAppActivity != null) {
                miniAppActivity.hideAddHomeTips();
            }
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
    }

    private final void noticeTmcFragmentUpdate(App app) {
        androidx.fragment.app.w p;
        androidx.fragment.app.w y;
        try {
            Page activePage = app.getActivePage();
            if (activePage == null) {
                ListIterator listIterator = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
                Intrinsics.g(listIterator, "ArrayList<Map.Entry<Stri…ize\n                    )");
                if (listIterator.hasPrevious()) {
                    Object previous = listIterator.previous();
                    Intrinsics.g(previous, "iterator.previous()");
                    activePage = ((TmcFragment) ((Map.Entry) previous).getValue()).getPage();
                } else {
                    activePage = null;
                }
            }
            if (activePage != null) {
                TmcFragment pageContext = activePage.getPageContext();
                if (pageContext instanceof TmcFragment) {
                    TmcFragment tmcFragment = pageContext;
                    this.currentFragment = tmcFragment;
                    if (tmcFragment != null) {
                        try {
                            FragmentManager innerManager = getInnerManager();
                            if (innerManager != null && (p = innerManager.p()) != null && (y = p.y(tmcFragment)) != null) {
                                y.l();
                            }
                            Page page = tmcFragment.getPage();
                            if (page != null) {
                                page.show();
                            }
                            tmcFragment.onStart();
                            tmcFragment.onResume();
                        } catch (Throwable th) {
                            TmcLogger.e(TAG, "notice fragment update failed!", th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "noticeTmcFragmentUpdate is failed!", th2);
        }
    }

    private final void pushPage(String str, TmcFragment tmcFragment, int i, boolean z, boolean z2) {
        App app;
        androidx.fragment.app.w p;
        Page page;
        if (str == null || tmcFragment == null) {
            return;
        }
        FragmentManager innerManager = getInnerManager();
        if (innerManager != null && (p = innerManager.p()) != null) {
            if (z && this.currentFragment != null) {
                p.u(R.anim.in_from_right, R.anim.out_from_left, R.anim.in_from_left, R.anim.out_from_right);
            }
            TmcFragment tmcFragment2 = this.currentFragment;
            if (tmcFragment2 != null && (!z2 || ((page = tmcFragment2.getPage()) != null && page.isTabPage()))) {
                p.p(tmcFragment2);
                tmcFragment2.onPause();
                tmcFragment2.onStop();
            }
            try {
                p.c(i, tmcFragment, str);
                p.g(str);
                p.j();
            } catch (Throwable th) {
                TmcLogger.e(TAG, "push fragment failed!", th);
            }
        }
        this.fragmentMap.put(str, tmcFragment);
        this.currentFragment = tmcFragment;
        if (this.fragmentMap.size() > 10) {
            int size = this.fragmentMap.size() - 10;
            Iterator<Map.Entry<String, TmcFragment>> it = this.fragmentMap.entrySet().iterator();
            TmcFragment tmcFragment3 = null;
            while (it.hasNext() && size != 0) {
                Map.Entry<String, TmcFragment> next = it.next();
                Page page2 = next.getValue().getPage();
                if (page2 == null || !page2.isHomePage()) {
                    if (page2 == null || !page2.isTabPage()) {
                        if (this.firstRemoveFragment == null) {
                            this.firstRemoveFragment = next.getValue();
                        }
                        tmcFragment3 = next.getValue();
                        it.remove();
                        size--;
                    }
                }
            }
            Page page3 = tmcFragment3 != null ? tmcFragment3.getPage() : null;
            if (page3 != null && (app = page3.getApp()) != null) {
                int childCount = app.getChildCount() - 1;
                while (true) {
                    if (-1 >= childCount) {
                        break;
                    }
                    App app2 = page3.getApp();
                    Page pageByIndex = app2 != null ? app2.getPageByIndex(childCount) : null;
                    if (!Intrinsics.c(pageByIndex != null ? pageByIndex.getStringValue(TmcConstants.KEY_PAGE_PRE_ID) : null, page3.getPageId())) {
                        childCount--;
                    } else if (pageByIndex != null) {
                        pageByIndex.putBooleanValue("exitPage", true);
                    }
                }
            }
        }
        hideAddHomeTips();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeFragment$lambda$14(FragmentManager fragmentManager, TmcFragment tmcFragment) {
        Intrinsics.h(fragmentManager, "$fm");
        try {
            if (fragmentManager.L0()) {
                return;
            }
            TmcLogger.d(TAG, "remove fragment after animation");
            fragmentManager.p().r(tmcFragment).j();
        } catch (Throwable th) {
            TmcLogger.e(TAG, "remove fragment after animation failed", th);
        }
    }

    public boolean attachFragment(TmcFragment tmcFragment, boolean z) {
        androidx.fragment.app.w p;
        if (tmcFragment != null) {
            try {
                FragmentManager innerManager = getInnerManager();
                if (innerManager != null && (p = innerManager.p()) != null) {
                    if (z) {
                        p.u(R.anim.in_from_right, R.anim.out_from_left, R.anim.in_from_left, R.anim.out_from_right);
                    }
                    p.h(tmcFragment);
                    p.j();
                    return true;
                }
            } catch (Throwable th) {
                TmcLogger.e(TAG, "attach fragment error", th);
            }
        }
        return false;
    }

    public synchronized void checkInvalidPage() {
        Page page;
        FragmentManager innerManager;
        boolean z;
        TmcFragment tmcFragment = this.firstRemoveFragment;
        if (tmcFragment != null && (page = tmcFragment.getPage()) != null) {
            if (page.getPageId() == null) {
                return;
            }
            TmcLogger.d(TAG, "clear invalid page and remove fragment from fragment manager");
            try {
                innerManager = getInnerManager();
            } catch (Throwable th) {
                TmcLogger.e(TAG, "checkInvalidPage is failed!", th);
            }
            if (innerManager == null || innerManager.T0()) {
                TraceLog.e(TmcConstants.INTEGRATION_TAG, "isStateSaved is true , cant popBackStack");
                return;
            }
            FragmentManager innerManager2 = getInnerManager();
            if (innerManager2 != null) {
                innerManager2.i1(page.getPageId(), 1);
            }
            FragmentManager innerManager3 = getInnerManager();
            if (innerManager3 != null ? innerManager3.g0() : false) {
                this.firstRemoveFragment = null;
                App app = page.getApp();
                if (app == null) {
                    return;
                }
                int childCount = app.getChildCount() - 1;
                int i = childCount;
                while (true) {
                    if (-1 >= i) {
                        z = false;
                        break;
                    }
                    Page pageByIndex = app.getPageByIndex(i);
                    if (TextUtils.equals(page.getPageId(), pageByIndex != null ? pageByIndex.getPageId() : null)) {
                        z = true;
                        break;
                    }
                    i--;
                }
                if (!z) {
                    noticeTmcFragmentUpdate(app);
                    return;
                }
                ArrayList<Page> arrayList = new ArrayList();
                while (-1 < childCount) {
                    Page pageByIndex2 = app.getPageByIndex(childCount);
                    Page.AnimStore animStore = pageByIndex2 != null ? (Page.AnimStore) pageByIndex2.getData(Page.AnimStore.class, true) : null;
                    if (animStore != null) {
                        animStore.disableExit = true;
                    }
                    if (pageByIndex2 != null) {
                        arrayList.add(pageByIndex2);
                    }
                    if (TextUtils.equals(page.getPageId(), pageByIndex2 != null ? pageByIndex2.getPageId() : null)) {
                        break;
                    } else {
                        childCount--;
                    }
                }
                for (Page page2 : arrayList) {
                    page2.exit(false);
                    PageContext pageContext = page2.getPageContext();
                    TmcFragment tmcFragment2 = pageContext instanceof TmcFragment ? (TmcFragment) pageContext : null;
                    App app2 = page2.getApp();
                    removeFragment(tmcFragment2, ((app2 != null && app2.isExited()) || ((Page.AnimStore) page2.getData(Page.AnimStore.class, true)).disableExit) ? false : true);
                }
                noticeTmcFragmentUpdate(app);
            }
        }
    }

    public TmcFragment createFragment(Page page) {
        App app;
        App app2;
        return AppPrepareUtils.INSTANCE.isShellType((page == null || (app2 = page.getApp()) == null) ? null : app2.getAppModel()) ? new MiniShellFragment() : (page == null || (app = page.getApp()) == null || app.getPageType(page.getPagePath()) != 1) ? new MiniH5Fragment() : new MiniFragment();
    }

    public boolean detachFragment(TmcFragment tmcFragment, boolean z) {
        androidx.fragment.app.w p;
        if (tmcFragment != null) {
            try {
                FragmentManager innerManager = getInnerManager();
                if (innerManager != null && (p = innerManager.p()) != null) {
                    if (z) {
                        p.u(R.anim.in_from_right, R.anim.out_from_left, R.anim.in_from_left, R.anim.out_from_right);
                    }
                    p.m(tmcFragment);
                    p.j();
                    return true;
                }
            } catch (Throwable th) {
                TmcLogger.e(TAG, "detach fragment error", th);
            }
        }
        return false;
    }

    public boolean exitPage(Page page, boolean z, boolean z2) {
        return exitPage(page != null ? page.getPageId() : null, z, z2);
    }

    public boolean exitTabCachePage(Page page, boolean z) {
        TmcFragment remove;
        boolean z2;
        boolean removeFragment;
        String pagePath = page != null ? page.getPagePath() : null;
        if (pagePath == null || pagePath.length() == 0 || !this.tabCacheFragmentManager.containsKey(pagePath) || (remove = this.tabCacheFragmentManager.remove(pagePath)) == null) {
            return false;
        }
        Page page2 = remove.getPage();
        String pageId = page2 != null ? page2.getPageId() : null;
        try {
            removeFragment = removeFragment(remove, z);
        } catch (Throwable th) {
            th = th;
            z2 = true;
        }
        try {
            FragmentManager innerManager = getInnerManager();
            if (innerManager != null && !innerManager.L0()) {
                if (innerManager.T0()) {
                    TraceLog.e(TmcConstants.INTEGRATION_TAG, "isStateSaved is true , cant popBackStack");
                    return false;
                }
                innerManager.i1(pageId, 1);
                innerManager.g0();
            }
            return removeFragment;
        } catch (Throwable th2) {
            th = th2;
            z2 = removeFragment;
            TmcLogger.e(TAG, "fragment manager error", th);
            return z2;
        }
    }

    public TmcFragment findFragmentForPage(Page page) {
        return findFragmentForPage(page != null ? page.getPageId() : null);
    }

    public TmcFragment findFragmentPreForPage(Page page) {
        Iterator<Map.Entry<String, TmcFragment>> it = this.fragmentMap.entrySet().iterator();
        String str = "";
        while (true) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<String, TmcFragment> next = it.next();
            if (Intrinsics.c(next.getKey(), page != null ? page.getPageId() : null)) {
                return this.fragmentMap.get(str);
            }
            str = next.getKey();
        }
    }

    public TmcFragment findHeaderFragment() {
        Iterator<Map.Entry<String, TmcFragment>> it = this.fragmentMap.entrySet().iterator();
        if (it.hasNext()) {
            return it.next().getValue();
        }
        return null;
    }

    public TmcFragment findTabFragmentByPath(String str) {
        if (str == null || !this.tabCacheFragmentManager.containsKey(str)) {
            return null;
        }
        return this.tabCacheFragmentManager.get(str);
    }

    public final WeakReference<FragmentActivity> getActivity() {
        return this.activity;
    }

    public int getFragmentSize() {
        return this.fragmentMap.size();
    }

    public Set<TmcFragment> getFragments() {
        Collection<TmcFragment> values = this.fragmentMap.values();
        Intrinsics.g(values, "fragmentMap.values");
        return CollectionsKt.W0(values);
    }

    public FragmentManager getInnerManager() {
        FragmentActivity fragmentActivity = this.activity.get();
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        return null;
    }

    public TmcFragment getReadyFragment() {
        return this.currentFragment;
    }

    public boolean isRootFragment(Page page) {
        return findFragmentForPage(page) != null && getFragmentSize() == 1;
    }

    public void moveTabPageToCache(List<Page> list) {
        Intrinsics.h(list, "tabPages");
        Iterator<Map.Entry<String, TmcFragment>> it = this.fragmentMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TmcFragment> next = it.next();
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((Page) it2.next()).getPageId(), next.getKey())) {
                        ArrayMap<String, TmcFragment> arrayMap = this.tabCacheFragmentManager;
                        Page page = next.getValue().getPage();
                        arrayMap.put(page != null ? page.getPagePath() : null, next.getValue());
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean onBackPressed() {
        FragmentManager innerManager;
        FragmentActivity fragmentActivity = this.activity.get();
        if (fragmentActivity == null || this.fragmentMap.size() == 0 || fragmentActivity.getSupportFragmentManager().r0() == 0) {
            return false;
        }
        ListIterator listIterator = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
        Intrinsics.g(listIterator, "ArrayList<Map.Entry<Stri…ap.size\n                )");
        if (listIterator.hasPrevious()) {
            this.fragmentMap.remove(((Map.Entry) listIterator.previous()).getKey());
        }
        if (this.fragmentMap.size() == 0 || (innerManager = getInnerManager()) == null || innerManager.T0()) {
            return false;
        }
        try {
            fragmentActivity.getSupportFragmentManager().g1();
        } catch (Throwable th) {
            TmcLogger.e(TAG, th);
        }
        return true;
    }

    public void pushPage(Page page, TmcFragment tmcFragment, int i, boolean z, boolean z2) {
        Intrinsics.h(page, "page");
        if (tmcFragment != null) {
            tmcFragment.setPage(page);
        }
        pushPage(page.getPageId(), tmcFragment, i, z, z2);
    }

    public void pushPage(Page page, TmcFragment tmcFragment, boolean z, boolean z2) {
        Intrinsics.h(page, "page");
        pushPage(page, tmcFragment, this.layoutId, z, z2);
    }

    public void release() {
        this.activity.clear();
        this.fragmentMap.clear();
        this.tabCacheFragmentManager.clear();
        this.currentFragment = null;
    }

    public boolean removeFragment(final TmcFragment tmcFragment, boolean z) {
        final FragmentManager innerManager;
        if (tmcFragment == null || (innerManager = getInnerManager()) == null) {
            return false;
        }
        View view = tmcFragment.getView();
        if (!z || view == null) {
            innerManager.p().r(tmcFragment).j();
            return true;
        }
        try {
            view.animate().translationX(ViewUtils.isLayoutRtl() ? -view.getWidth() : view.getWidth()).setDuration(300L).withEndAction(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.q1
                @Override // java.lang.Runnable
                public final void run() {
                    TmcFragmentManager.removeFragment$lambda$14(innerManager, tmcFragment);
                }
            }).start();
            return true;
        } catch (Throwable th) {
            TmcLogger.e(TAG, "remove fragment with animation error", th);
            return false;
        }
    }

    public void resetFragmentToTop(TmcFragment tmcFragment) {
        if (tmcFragment == null) {
            TraceLog.w(TmcConstants.INTEGRATION_TAG, "resetFragment can not null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
        Intrinsics.g(listIterator, "ArrayList<Map.Entry<Stri…terator(fragmentMap.size)");
        boolean z = false;
        while (listIterator.hasPrevious() && !z) {
            Object previous = listIterator.previous();
            Intrinsics.g(previous, "iterator.previous()");
            Map.Entry entry = (Map.Entry) previous;
            if (Intrinsics.c(entry.getValue(), tmcFragment)) {
                FragmentManager innerManager = getInnerManager();
                if (innerManager == null || innerManager.T0()) {
                    TraceLog.e(TmcConstants.INTEGRATION_TAG, "isStateSaved is true , cant popBackStack");
                    return;
                }
                FragmentManager innerManager2 = getInnerManager();
                if (innerManager2 != null) {
                    innerManager2.i1((String) entry.getKey(), 0);
                }
                this.currentFragment = tmcFragment;
                z = true;
            } else {
                arrayList.add(entry.getKey());
            }
        }
        if (!z) {
            TraceLog.w(TmcConstants.INTEGRATION_TAG, "reset fragment is not exist");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.fragmentMap.remove((String) it.next());
        }
    }

    public void switchTab(Page page, TmcFragment tmcFragment) {
        androidx.fragment.app.w p;
        Intrinsics.h(page, "page");
        if (this.tabCacheFragmentManager.containsKey(page.getPagePath())) {
            this.tabCacheFragmentManager.remove(page.getPagePath());
            String pageId = page.getPageId();
            if (pageId == null || tmcFragment == null) {
                return;
            }
            this.fragmentMap.put(pageId, tmcFragment);
            try {
                FragmentManager innerManager = getInnerManager();
                if (innerManager != null && (p = innerManager.p()) != null) {
                    TmcFragment tmcFragment2 = this.currentFragment;
                    if (tmcFragment2 != null) {
                        p.p(tmcFragment2);
                    }
                    p.y(tmcFragment);
                    p.l();
                }
            } catch (Throwable th) {
                TmcLogger.e(TAG, "switch tab fragment failed!", th);
            }
            TmcFragment tmcFragment3 = this.currentFragment;
            if (tmcFragment3 != null) {
                tmcFragment3.onPause();
                tmcFragment3.onStop();
            }
            this.currentFragment = tmcFragment;
            tmcFragment.onStart();
            tmcFragment.onResume();
        }
        hideAddHomeTips();
    }
}
