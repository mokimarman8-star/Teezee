package com.transsion.ninegridview.preview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.y;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.R$drawable;
import com.transsion.photoview.PhotoView;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/transsion/ninegridview/preview/GifImagePreviewFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lum/c;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "d0", "(Landroid/view/LayoutInflater;)Lum/c;", "Landroid/view/View;", "view", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "Lcom/transsion/moviedetailapi/bean/Image;", "a", "Lcom/transsion/moviedetailapi/bean/Image;", "image", BuildConfig.FLAVOR, "b", "I", "index", BuildConfig.FLAVOR, "c", "Ljava/lang/Boolean;", "isBuiltIn", "d", "NineGridView_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class GifImagePreviewFragment extends BaseFragment<um.c> {

    /* renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private Image image;

    /* renamed from: b, reason: from kotlin metadata */
    private int index;

    /* renamed from: c, reason: from kotlin metadata */
    private Boolean isBuiltIn = Boolean.FALSE;

    /* renamed from: com.transsion.ninegridview.preview.GifImagePreviewFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GifImagePreviewFragment a(Boolean bool, Image image, int i) {
            GifImagePreviewFragment gifImagePreviewFragment = new GifImagePreviewFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(GifImagePreviewActivity.IMAGE_LIST, image);
            bundle.putInt("CURRENT_ITEM", i);
            if (bool != null) {
                bundle.putBoolean(GifImagePreviewActivity.IS_BUILTIN, bool.booleanValue());
            }
            gifImagePreviewFragment.setArguments(bundle);
            return gifImagePreviewFragment;
        }
    }

    public static final class b implements com.transsion.photoview.i {
        b() {
        }

        @Override // com.transsion.photoview.i
        public void a() {
            if (GifImagePreviewFragment.this.getContext() instanceof GifImagePreviewActivity) {
                Object context = GifImagePreviewFragment.this.getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type com.transsion.ninegridview.preview.GifImagePreviewActivity");
                ((GifImagePreviewActivity) context).finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(GifImagePreviewFragment gifImagePreviewFragment, View view) {
        if (gifImagePreviewFragment.getContext() instanceof GifImagePreviewActivity) {
            Object context = gifImagePreviewFragment.getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type com.transsion.ninegridview.preview.GifImagePreviewActivity");
            ((GifImagePreviewActivity) context).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(GifImagePreviewFragment gifImagePreviewFragment, View view) {
        if (gifImagePreviewFragment.getContext() instanceof GifImagePreviewActivity) {
            Object context = gifImagePreviewFragment.getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type com.transsion.ninegridview.preview.GifImagePreviewActivity");
            ((GifImagePreviewActivity) context).finishActivityAnim();
        }
    }

    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public um.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        um.c c = um.c.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13, types: [android.widget.ImageView, com.transsion.photoview.PhotoView] */
    public void initView(View view, Bundle savedInstanceState) {
        ?? r10;
        String url;
        GifBean gifBean;
        String videoUrl;
        GifBean gifBean2;
        PhotoView photoView;
        PhotoView photoView2;
        Integer height;
        Integer width;
        FrameLayout frameLayout;
        Intrinsics.h(view, "view");
        um.c cVar = (um.c) getMViewBinding();
        if (cVar != null && (frameLayout = cVar.b) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GifImagePreviewFragment.e0(GifImagePreviewFragment.this, view2);
                }
            });
        }
        Image image = this.image;
        float e = (image == null || (width = image.getWidth()) == null) ? y.e() : width.intValue();
        Image image2 = this.image;
        float c = (image2 == null || (height = image2.getHeight()) == null) ? y.c() : height.intValue();
        float e2 = y.e();
        float f = (c / e) * e2;
        um.c cVar2 = (um.c) getMViewBinding();
        if (cVar2 != null && (photoView2 = cVar2.e) != null) {
            photoView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GifImagePreviewFragment.f0(GifImagePreviewFragment.this, view2);
                }
            });
        }
        um.c cVar3 = (um.c) getMViewBinding();
        if (cVar3 != null && (photoView = cVar3.e) != null) {
            photoView.setSlideUpAndDownListener(new b());
        }
        um.c cVar4 = (um.c) getMViewBinding();
        if (cVar4 == null || (r10 = cVar4.e) == 0) {
            return;
        }
        Image image3 = this.image;
        if (image3 == null || (gifBean = image3.getGifBean()) == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
            Image image4 = this.image;
            if (image4 != null) {
                url = image4.getUrl();
            }
            url = null;
        } else {
            Image image5 = this.image;
            if (image5 != null && (gifBean2 = image5.getGifBean()) != null) {
                url = gifBean2.getFirstFrameUrl();
            }
            url = null;
        }
        if (Intrinsics.c(this.isBuiltIn, Boolean.TRUE)) {
            Image image6 = this.image;
            if (image6 != null) {
                image6.getUrl();
            }
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new GifImagePreviewFragment$initView$5(this, r10, null), 3, (Object) null);
            return;
        }
        Image image7 = this.image;
        if (image7 != null) {
            image7.getUrl();
        }
        f.a aVar = ni.f.a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        f.b m = aVar.m(requireContext);
        if (url == null) {
            url = BuildConfig.FLAVOR;
        }
        m.g(url).i(R$drawable.ic_default_color).m((int) e2).c((int) f).j(0).f(true).e(true).k(false).h(false).d(r10);
    }

    public void lazyLoadData() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Image serializable = arguments.getSerializable(GifImagePreviewActivity.IMAGE_LIST);
            this.image = serializable instanceof Image ? serializable : null;
            this.index = arguments.getInt("CURRENT_ITEM");
            this.isBuiltIn = Boolean.valueOf(arguments.getBoolean(GifImagePreviewActivity.IS_BUILTIN, false));
        }
    }
}
