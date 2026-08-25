package com.transsnet.downloader.fragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.v0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/t0;", "VM", "Landroidx/lifecycle/v0$c;", "<anonymous>", "()Landroidx/lifecycle/v0$c;", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$2"}, k = 3, mv = {2, 1, 0})
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class FileManagerFragment$special$$inlined$activityViewModels$default$4 extends Lambda implements Function0<v0.c> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileManagerFragment$special$$inlined$activityViewModels$default$4(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final v0.c invoke() {
        v0.c defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
        Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
