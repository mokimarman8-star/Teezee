package com.transsion.postdetail.layer;

import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseLayer {
    private final String a;
    private f b;
    private String c;
    private PostSubjectItem d;
    private final Lazy e;
    private ORPlayerView f;
    private ImageView g;
    private a h;
    private boolean i;

    public BaseLayer(final Fragment fragment) {
        Intrinsics.h(fragment, "fragment");
        this.a = getClass().getSimpleName();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.layer.BaseLayer$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m80invoke() {
                return fragment;
            }
        };
        this.e = FragmentViewModelLazyKt.a(fragment, Reflection.b(PostDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.layer.BaseLayer$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m81invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.layer.BaseLayer$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m82invoke() {
                Object invoke = function0.invoke();
                m mVar = invoke instanceof m ? (m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final void F(LayerFlag layerFlag, Object... objArr) {
        Intrinsics.h(layerFlag, "flag");
        Intrinsics.h(objArr, "params");
        a aVar = this.h;
        if (aVar != null) {
            aVar.h(layerFlag, Arrays.copyOf(objArr, objArr.length));
        }
    }

    protected final ImageView G() {
        return this.g;
    }

    protected final f H() {
        return this.b;
    }

    protected final ORPlayerView I() {
        return this.f;
    }

    protected final boolean J() {
        return this.i;
    }

    protected final void K(ImageView imageView) {
        this.g = imageView;
    }

    public final void L(a aVar) {
        this.h = aVar;
    }

    public void M(f fVar, ORPlayerView oRPlayerView) {
        Intrinsics.h(fVar, "orPlayer");
        Intrinsics.h(oRPlayerView, "orPlayerView");
        a.a aVar = wf.a.a;
        String str = this.a;
        Intrinsics.g(str, "TAG");
        a.a.f(aVar, str, "setPlayer----->", false, 4, (Object) null);
        this.b = fVar;
        this.f = oRPlayerView;
    }

    public final void N(String str, PostSubjectItem postSubjectItem) {
        Intrinsics.h(str, "postId");
        a.a aVar = wf.a.a;
        String str2 = this.a;
        Intrinsics.g(str2, "TAG");
        a.a.f(aVar, str2, "setPostData----->", false, 4, (Object) null);
        this.c = str;
        this.d = postSubjectItem;
    }

    protected final void O(String str) {
        this.c = str;
    }

    protected final void P(boolean z) {
        this.i = z;
    }
}
