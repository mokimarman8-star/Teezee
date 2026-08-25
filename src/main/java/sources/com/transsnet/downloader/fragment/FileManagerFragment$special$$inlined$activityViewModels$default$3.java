package com.transsnet.downloader.fragment;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/t0;", "VM", "Landroidx/lifecycle/x0;", "<anonymous>", "()Landroidx/lifecycle/x0;", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$1"}, k = 3, mv = {2, 1, 0})
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class FileManagerFragment$special$$inlined$activityViewModels$default$3 extends Lambda implements Function0<androidx.lifecycle.x0> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileManagerFragment$special$$inlined$activityViewModels$default$3(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final androidx.lifecycle.x0 invoke() {
        androidx.lifecycle.x0 viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
        Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
