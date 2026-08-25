package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.b;
import androidx.collection.x;
import androidx.core.util.i;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    FragmentEventDispatcher mFragmentEventDispatcher;
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final x mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final x mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final x mSavedStates;

    private static abstract class DataSetChangeObserver extends RecyclerView.g {
        private DataSetChangeObserver() {
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onChanged();
        }

        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }
    }

    class FragmentMaxLifecycleEnforcer {
        private RecyclerView.g mDataObserver;
        private r mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private ViewPager2 mViewPager;

        FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        private ViewPager2 inferViewPager(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void register(@NonNull RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mPageChangeCallback = onPageChangeCallback;
            this.mViewPager.registerOnPageChangeCallback(onPageChangeCallback);
            DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
                @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
                }
            };
            this.mDataObserver = dataSetChangeObserver;
            FragmentStateAdapter.this.registerAdapterDataObserver(dataSetChangeObserver);
            t tVar = new r() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                public void onStateChanged(@NonNull u uVar, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mLifecycleObserver = tVar;
            FragmentStateAdapter.this.mLifecycle.a(tVar);
        }

        void unregister(@NonNull RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            FragmentStateAdapter.this.mLifecycle.d(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        void updateFragmentMaxLifecycle(boolean z) {
            int currentItem;
            Fragment fragment;
            if (FragmentStateAdapter.this.shouldDelayFragmentTransactions() || this.mViewPager.getScrollState() != 0 || FragmentStateAdapter.this.mFragments.i() || FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.mViewPager.getCurrentItem()) >= FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.mPrimaryItemId || z) && (fragment = (Fragment) FragmentStateAdapter.this.mFragments.e(itemId)) != null && fragment.isAdded()) {
                this.mPrimaryItemId = itemId;
                w p = FragmentStateAdapter.this.mFragmentManager.p();
                ArrayList arrayList = new ArrayList();
                Fragment fragment2 = null;
                for (int i = 0; i < FragmentStateAdapter.this.mFragments.n(); i++) {
                    long j = FragmentStateAdapter.this.mFragments.j(i);
                    Fragment fragment3 = (Fragment) FragmentStateAdapter.this.mFragments.o(i);
                    if (fragment3.isAdded()) {
                        if (j != this.mPrimaryItemId) {
                            Lifecycle.State state = Lifecycle.State.STARTED;
                            p.v(fragment3, state);
                            arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchMaxLifecyclePreUpdated(fragment3, state));
                        } else {
                            fragment2 = fragment3;
                        }
                        fragment3.setMenuVisibility(j == this.mPrimaryItemId);
                    }
                }
                if (fragment2 != null) {
                    Lifecycle.State state2 = Lifecycle.State.RESUMED;
                    p.v(fragment2, state2);
                    arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchMaxLifecyclePreUpdated(fragment2, state2));
                }
                if (p.q()) {
                    return;
                }
                p.k();
                Collections.reverse(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchPostEvents((List) it.next());
                }
            }
        }
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.mFragments = new x();
        this.mSavedStates = new x();
        this.mItemIdToViewHolder = new x();
        this.mFragmentEventDispatcher = new FragmentEventDispatcher();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }

    @NonNull
    private static String createKey(@NonNull String str, long j) {
        return str + j;
    }

    private void ensureFragment(int i) {
        long itemId = getItemId(i);
        if (this.mFragments.d(itemId)) {
            return;
        }
        Fragment createFragment = createFragment(i);
        createFragment.setInitialSavedState((Fragment.SavedState) this.mSavedStates.e(itemId));
        this.mFragments.k(itemId, createFragment);
    }

    private boolean isFragmentViewBound(long j) {
        View view;
        if (this.mItemIdToViewHolder.d(j)) {
            return true;
        }
        Fragment fragment = (Fragment) this.mFragments.e(j);
        return (fragment == null || (view = fragment.getView()) == null || view.getParent() == null) ? false : true;
    }

    private static boolean isValidKey(@NonNull String str, @NonNull String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long itemForViewHolder(int i) {
        Long l = null;
        for (int i2 = 0; i2 < this.mItemIdToViewHolder.n(); i2++) {
            if (((Integer) this.mItemIdToViewHolder.o(i2)).intValue() == i) {
                if (l != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                l = Long.valueOf(this.mItemIdToViewHolder.j(i2));
            }
        }
        return l;
    }

    private static long parseIdFromKey(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j) {
        ViewParent parent;
        Fragment fragment = (Fragment) this.mFragments.e(j);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j)) {
            this.mSavedStates.l(j);
        }
        if (!fragment.isAdded()) {
            this.mFragments.l(j);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }
        if (fragment.isAdded() && containsItem(j)) {
            List dispatchPreSavedInstanceState = this.mFragmentEventDispatcher.dispatchPreSavedInstanceState(fragment);
            Fragment.SavedState B1 = this.mFragmentManager.B1(fragment);
            this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPreSavedInstanceState);
            this.mSavedStates.k(j, B1);
        }
        List dispatchPreRemoved = this.mFragmentEventDispatcher.dispatchPreRemoved(fragment);
        try {
            this.mFragmentManager.p().r(fragment).k();
            this.mFragments.l(j);
        } finally {
            this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPreRemoved);
        }
    }

    private void scheduleGracePeriodEnd() {
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.mIsInGracePeriod = false;
                fragmentStateAdapter.gcFragments();
            }
        };
        this.mLifecycle.a(new 4(this, handler, runnable));
        handler.postDelayed(runnable, GRACE_WINDOW_TIME_MS);
    }

    private void scheduleViewAttach(Fragment fragment, @NonNull FrameLayout frameLayout) {
        this.mFragmentManager.p1(new 2(this, fragment, frameLayout), false);
    }

    void addViewToContainer(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public boolean containsItem(long j) {
        return j >= 0 && j < ((long) getItemCount());
    }

    @NonNull
    public abstract Fragment createFragment(int i);

    void gcFragments() {
        if (!this.mHasStaleFragments || shouldDelayFragmentTransactions()) {
            return;
        }
        b bVar = new b();
        for (int i = 0; i < this.mFragments.n(); i++) {
            long j = this.mFragments.j(i);
            if (!containsItem(j)) {
                bVar.add(Long.valueOf(j));
                this.mItemIdToViewHolder.l(j);
            }
        }
        if (!this.mIsInGracePeriod) {
            this.mHasStaleFragments = false;
            for (int i2 = 0; i2 < this.mFragments.n(); i2++) {
                long j2 = this.mFragments.j(i2);
                if (!isFragmentViewBound(j2)) {
                    bVar.add(Long.valueOf(j2));
                }
            }
        }
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            removeFragment(((Long) it.next()).longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        i.a(this.mFragmentMaxLifecycleEnforcer == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull FragmentViewHolder fragmentViewHolder, int i) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.getContainer().getId();
        Long itemForViewHolder = itemForViewHolder(id);
        if (itemForViewHolder != null && itemForViewHolder.longValue() != itemId) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.l(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.k(itemId, Integer.valueOf(id));
        ensureFragment(i);
        if (ViewCompat.isAttachedToWindow(fragmentViewHolder.getContainer())) {
            placeFragmentInViewHolder(fragmentViewHolder);
        }
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return FragmentViewHolder.create(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.l(itemForViewHolder.longValue());
        }
    }

    void placeFragmentInViewHolder(@NonNull FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = (Fragment) this.mFragments.e(fragmentViewHolder.getItemId());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout container = fragmentViewHolder.getContainer();
        View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.isAdded() && view == null) {
            scheduleViewAttach(fragment, container);
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != container) {
                addViewToContainer(view, container);
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            addViewToContainer(view, container);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            if (this.mFragmentManager.L0()) {
                return;
            }
            this.mLifecycle.a(new 1(this, fragmentViewHolder));
            return;
        }
        scheduleViewAttach(fragment, container);
        List dispatchPreAdded = this.mFragmentEventDispatcher.dispatchPreAdded(fragment);
        try {
            fragment.setMenuVisibility(false);
            this.mFragmentManager.p().e(fragment, "f" + fragmentViewHolder.getItemId()).v(fragment, Lifecycle.State.STARTED).k();
            this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
        } finally {
            this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPreAdded);
        }
    }

    public void registerFragmentTransactionCallback(@NonNull FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.registerCallback(fragmentTransactionCallback);
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(@NonNull Parcelable parcelable) {
        if (!this.mSavedStates.i() || !this.mFragments.i()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                this.mFragments.k(parseIdFromKey(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.u0(bundle, str));
            } else {
                if (!isValidKey(str, KEY_PREFIX_STATE)) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long parseIdFromKey = parseIdFromKey(str, KEY_PREFIX_STATE);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (containsItem(parseIdFromKey)) {
                    this.mSavedStates.k(parseIdFromKey, savedState);
                }
            }
        }
        if (this.mFragments.i()) {
            return;
        }
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mFragments.n() + this.mSavedStates.n());
        for (int i = 0; i < this.mFragments.n(); i++) {
            long j = this.mFragments.j(i);
            Fragment fragment = (Fragment) this.mFragments.e(j);
            if (fragment != null && fragment.isAdded()) {
                this.mFragmentManager.o1(bundle, createKey(KEY_PREFIX_FRAGMENT, j), fragment);
            }
        }
        for (int i2 = 0; i2 < this.mSavedStates.n(); i2++) {
            long j2 = this.mSavedStates.j(i2);
            if (containsItem(j2)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, j2), (Parcelable) this.mSavedStates.e(j2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.T0();
    }

    public void unregisterFragmentTransactionCallback(@NonNull FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.unregisterCallback(fragmentTransactionCallback);
    }
}
