package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.bumptech.glide.Glide;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.preview.ImagePreviewActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/transsion/moviedetail/fragment/StillsFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Llm/o;", "<init>", "()V", "Lcom/transsion/moviedetailapi/bean/Cover;", "cover", BuildConfig.FLAVOR, "d0", "(Lcom/transsion/moviedetailapi/bean/Cover;)V", "Landroid/view/LayoutInflater;", "inflater", "c0", "(Landroid/view/LayoutInflater;)Llm/o;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "a", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class StillsFragment extends BaseFragment<lm.o> {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.transsion.moviedetail.fragment.StillsFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StillsFragment a(Cover cover) {
            Intrinsics.h(cover, "cover");
            StillsFragment stillsFragment = new StillsFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("cover", cover);
            stillsFragment.setArguments(bundle);
            return stillsFragment;
        }
    }

    private final void d0(final Cover cover) {
        final lm.o oVar = (lm.o) getMViewBinding();
        if (oVar != null) {
            int f = com.transsion.core.utils.e.f();
            f.a aVar = ni.f.a;
            String url = cover.getUrl();
            if (url == null) {
                url = BuildConfig.FLAVOR;
            }
            String e = f.a.e(aVar, url, f, false, false, 12, null);
            String thumbnail = cover.getThumbnail();
            com.transsion.base.image.blurhash.e.d(com.transsion.base.image.blurhash.e.a, thumbnail == null ? BuildConfig.FLAVOR : thumbnail, 0, 0, new Function1() { // from class: com.transsion.moviedetail.fragment.j1
                public final Object invoke(Object obj) {
                    Unit e0;
                    e0 = StillsFragment.e0(lm.o.this, (BitmapDrawable) obj);
                    return e0;
                }
            }, 6, null);
            Glide.with(requireContext()).load(e).into(oVar.c);
            oVar.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.k1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StillsFragment.f0(cover, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(lm.o oVar, BitmapDrawable bitmapDrawable) {
        Intrinsics.h(bitmapDrawable, "it");
        oVar.b.setImageDrawable(bitmapDrawable);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Cover cover, StillsFragment stillsFragment, View view) {
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.bigImageUrl = cover.getUrl();
        imageInfo.thumbnailUrl = cover.getThumbnail();
        imageInfo.imageViewHeight = cover.getHeight() != null ? r1.intValue() : 0.0f;
        imageInfo.imageViewWidth = cover.getWidth() != null ? r3.intValue() : 0.0f;
        List q = CollectionsKt.q(new ImageInfo[]{imageInfo});
        ImagePreviewActivity.Companion companion = ImagePreviewActivity.INSTANCE;
        Context requireContext = stillsFragment.requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        companion.a(requireContext, 0, q);
    }

    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public lm.o getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lm.o c = lm.o.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
    }

    public void lazyLoadData() {
        Bundle arguments = getArguments();
        Cover cover = (Cover) (arguments != null ? arguments.getSerializable("cover") : null);
        if (cover != null) {
            d0(cover);
        }
    }
}
