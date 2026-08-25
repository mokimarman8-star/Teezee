package androidx.viewpager2.adapter;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter$FragmentTransactionCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class FragmentStateAdapter$FragmentEventDispatcher {
    private List<FragmentStateAdapter$FragmentTransactionCallback> mCallbacks = new CopyOnWriteArrayList();

    FragmentStateAdapter$FragmentEventDispatcher() {
    }

    public List<FragmentStateAdapter$FragmentTransactionCallback.OnPostEventListener> dispatchMaxLifecyclePreUpdated(Fragment fragment, Lifecycle.State state) {
        ArrayList arrayList = new ArrayList();
        Iterator<FragmentStateAdapter$FragmentTransactionCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().onFragmentMaxLifecyclePreUpdated(fragment, state));
        }
        return arrayList;
    }

    public void dispatchPostEvents(List<FragmentStateAdapter$FragmentTransactionCallback.OnPostEventListener> list) {
        Iterator<FragmentStateAdapter$FragmentTransactionCallback.OnPostEventListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onPost();
        }
    }

    public List<FragmentStateAdapter$FragmentTransactionCallback.OnPostEventListener> dispatchPreAdded(Fragment fragment) {
        ArrayList arrayList = new ArrayList();
        Iterator<FragmentStateAdapter$FragmentTransactionCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().onFragmentPreAdded(fragment));
        }
        return arrayList;
    }

    public List<FragmentStateAdapter$FragmentTransactionCallback.OnPostEventListener> dispatchPreRemoved(Fragment fragment) {
        ArrayList arrayList = new ArrayList();
        Iterator<FragmentStateAdapter$FragmentTransactionCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().onFragmentPreRemoved(fragment));
        }
        return arrayList;
    }

    public List<FragmentStateAdapter$FragmentTransactionCallback.OnPostEventListener> dispatchPreSavedInstanceState(Fragment fragment) {
        ArrayList arrayList = new ArrayList();
        Iterator<FragmentStateAdapter$FragmentTransactionCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().onFragmentPreSavedInstanceState(fragment));
        }
        return arrayList;
    }

    public void registerCallback(FragmentStateAdapter$FragmentTransactionCallback fragmentStateAdapter$FragmentTransactionCallback) {
        this.mCallbacks.add(fragmentStateAdapter$FragmentTransactionCallback);
    }

    public void unregisterCallback(FragmentStateAdapter$FragmentTransactionCallback fragmentStateAdapter$FragmentTransactionCallback) {
        this.mCallbacks.remove(fragmentStateAdapter$FragmentTransactionCallback);
    }
}
