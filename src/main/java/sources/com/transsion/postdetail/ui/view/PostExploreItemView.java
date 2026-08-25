package com.transsion.postdetail.ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$style;
import com.transsion.postdetail.util.PostSaveHelper;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import ni.f;

@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005*\u0001-\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u0010J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u0010J\u000f\u0010\u001e\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u001f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001f\u0010\u0012R\u0018\u0010\"\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/transsion/postdetail/ui/view/PostExploreItemView;", "Lcom/transsion/postdetail/ui/view/PostBaseItemView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "item", BuildConfig.FLAVOR, "k0", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "r0", "()V", "Landroid/view/View;", "view", "l0", "(Landroid/view/View;)V", "postItem", "m0", "n0", "p0", "q0", "setHeaderData", "setSubjectAndRoomContent", "onAttachedToWindow", "onDetachedFromWindow", "m", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "mItem", "Landroid/animation/ObjectAnimator;", "n", "Landroid/animation/ObjectAnimator;", "rotateAnimator", "Lcom/transsnet/downloader/manager/g;", "o", "Lkotlin/Lazy;", "getDownloadManager", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "com/transsion/postdetail/ui/view/PostExploreItemView$a", "p", "Lcom/transsion/postdetail/ui/view/PostExploreItemView$a;", "downloadListener", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostExploreItemView extends PostBaseItemView {

    /* renamed from: m, reason: from kotlin metadata */
    private PostSubjectItem mItem;

    /* renamed from: n, reason: from kotlin metadata */
    private ObjectAnimator rotateAnimator;

    /* renamed from: o, reason: from kotlin metadata */
    private final Lazy downloadManager;

    /* renamed from: p, reason: from kotlin metadata */
    private final a downloadListener;

    public static final class a implements ui.m0 {
        a() {
        }

        @Override // ui.m0
        public void a(DownloadBean downloadBean, DownloadException downloadException) {
            Intrinsics.h(downloadBean, "bean");
            PostExploreItemView.this.r0();
        }

        @Override // ui.m0
        public void b(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            PostExploreItemView.this.r0();
        }

        @Override // ui.m0
        public void c(DownloadBean downloadBean, long j, long j2) {
            Intrinsics.h(downloadBean, "bean");
            PostExploreItemView.this.r0();
        }

        @Override // ui.m0
        public void d(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            PostExploreItemView.this.r0();
        }

        @Override // ui.m0
        public void e(DownloadBean downloadBean, String str) {
            Intrinsics.h(downloadBean, "bean");
            PostExploreItemView.this.r0();
        }

        @Override // ui.m0
        public void f(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            PostExploreItemView.this.r0();
        }

        @Override // ui.m0
        public void g(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            PostExploreItemView.this.r0();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostExploreItemView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostExploreItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostExploreItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.downloadManager = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.view.l1
            public final Object invoke() {
                com.transsnet.downloader.manager.g j0;
                j0 = PostExploreItemView.j0();
                return j0;
            }
        });
        this.downloadListener = new a();
    }

    private final com.transsnet.downloader.manager.g getDownloadManager() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g j0() {
        return com.transsnet.downloader.manager.p.a.a(Utils.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k0(PostSubjectItem item) {
        String str;
        String nickname;
        ShapeableImageView shapeableImageView = getViewBinding().k;
        Intrinsics.g(shapeableImageView, "ivRoomCover");
        uf.c.g(shapeableImageView);
        ShapeableImageView shapeableImageView2 = getViewBinding().l;
        Intrinsics.g(shapeableImageView2, "ivUserAvatar");
        uf.c.g(shapeableImageView2);
        AppCompatTextView appCompatTextView = getViewBinding().z;
        Intrinsics.g(appCompatTextView, "tvUserNameOrLocation");
        uf.c.g(appCompatTextView);
        BLView bLView = getViewBinding().H;
        if (bLView != null) {
            uf.c.g(bLView);
        }
        ShapeableImageView shapeableImageView3 = getViewBinding().m;
        Intrinsics.g(shapeableImageView3, "ivUserAvatar2");
        uf.c.k(shapeableImageView3);
        BLView bLView2 = getViewBinding().I;
        if (bLView2 != null) {
            uf.c.k(bLView2);
        }
        boolean builtIn = item.getBuiltIn();
        String str2 = BuildConfig.FLAVOR;
        if (builtIn) {
            kotlinx.coroutines.i.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PostExploreItemView$hideGroup$1(item, this, null), 3, (Object) null);
        } else {
            f.a aVar = ni.f.a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            User user = item.getUser();
            if (user == null || (str = user.getAvatar()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b c = m.g(str).m(getDp16()).c(getDp16());
            ShapeableImageView shapeableImageView4 = getViewBinding().m;
            Intrinsics.g(shapeableImageView4, "ivUserAvatar2");
            c.d(shapeableImageView4);
        }
        AppCompatTextView appCompatTextView2 = getViewBinding().y;
        User user2 = item.getUser();
        if (user2 != null && (nickname = user2.getNickname()) != null) {
            str2 = nickname;
        }
        appCompatTextView2.setText(str2);
        if (Build.VERSION.SDK_INT >= 28) {
            getViewBinding().y.setTextAppearance(R$style.newRoomPostTitleTextStyle);
            getViewBinding().u.setTextAppearance(R$style.newRoomPostContentTextStyle);
        } else {
            getViewBinding().y.setTypeface(getViewBinding().y.getTypeface(), 0);
            getViewBinding().y.setTextSize(lj.a.b(12));
            getViewBinding().u.setTypeface(getViewBinding().y.getTypeface(), 1);
        }
        ViewGroup.LayoutParams layoutParams = getViewBinding().u.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = lj.a.b(4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l0(View view) {
        PostSubjectItem postSubjectItem;
        if ((view == null || !com.transsion.baseui.util.c.a.a(view.getId(), 500L)) && (postSubjectItem = this.mItem) != null) {
            String value = MediaType.VIDEO.getValue();
            Media media = postSubjectItem.getMedia();
            if (!TextUtils.equals(value, media != null ? media.getMediaType() : null)) {
                m0(postSubjectItem);
                return;
            }
            DownloadBean G = DownloadUtil.a.G(postSubjectItem);
            if (G == null) {
                return;
            }
            DownloadEsHelper a2 = DownloadEsHelper.m.a();
            String resourceId = G.getResourceId();
            if (resourceId == null) {
                resourceId = BuildConfig.FLAVOR;
            }
            DownloadBean q = a2.q(resourceId);
            if (q != null && q.getStatus() == 5) {
                Navigator.x(TheRouter.c("/download/panel_activity").F("extra_page_index", 0).K("extra_target_resource_id", postSubjectItem.getPostId()), getContext(), (mf.c) null, 2, (Object) null);
                return;
            }
            com.transsion.baseui.util.m.c(R.string.shorts_click_download);
            getDownloadManager().p(G);
            r0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m0(PostSubjectItem postItem) {
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.a;
        String pageName = getPageName();
        if (pageName == null) {
            pageName = BuildConfig.FLAVOR;
        }
        aVar.i(postItem, pageName, getPageFrom());
        if (Build.VERSION.SDK_INT >= 29) {
            PostSaveHelper.a.b(postItem);
            return;
        }
        Context context = getContext();
        if (context == null) {
            context = Utils.a();
        }
        if (androidx.core.content.b.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            Context context2 = getContext();
            if (context2 == null) {
                context2 = Utils.a();
            }
            if (androidx.core.content.b.checkSelfPermission(context2, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                PostSaveHelper.a.b(postItem);
                return;
            }
        }
        n0();
    }

    private final void n0() {
        FragmentActivity B = B();
        if (B != null) {
            ActivityCompat.g(B, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, FileHelper.a.l());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(PostExploreItemView postExploreItemView) {
        postExploreItemView.l0(postExploreItemView.getViewBinding().E);
        return Unit.a;
    }

    private final void p0(View view) {
        ObjectAnimator objectAnimator = this.rotateAnimator;
        if (objectAnimator != null) {
            Intrinsics.e(objectAnimator);
            if (objectAnimator.isRunning()) {
                return;
            }
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
        ofFloat.setDuration(800L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
        this.rotateAnimator = ofFloat;
    }

    private final void q0(View view) {
        ObjectAnimator objectAnimator = this.rotateAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.rotateAnimator = null;
        view.setRotation(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        String postId;
        AppCompatImageView appCompatImageView;
        PostSubjectItem postSubjectItem = this.mItem;
        if (postSubjectItem == null) {
            return;
        }
        String value = MediaType.VIDEO.getValue();
        Media media = postSubjectItem.getMedia();
        if (!TextUtils.equals(value, media != null ? media.getMediaType() : null) || (postId = postSubjectItem.getPostId()) == null || (appCompatImageView = getViewBinding().j) == null) {
            return;
        }
        DownloadBean q = DownloadEsHelper.m.a().q(postId);
        if (q == null) {
            q0(appCompatImageView);
            appCompatImageView.setImageResource(com.tn.lib.widget.R.drawable.ic_post_download_new);
            appCompatImageView.setEnabled(true);
            return;
        }
        int status = q.getStatus();
        if (status == 1 || status == 2 || status == 3) {
            appCompatImageView.setImageResource(com.tn.lib.widget.R.drawable.ic_post_downloading);
            appCompatImageView.setEnabled(false);
            p0(appCompatImageView);
        } else if (status != 5) {
            q0(appCompatImageView);
            appCompatImageView.setImageResource(com.tn.lib.widget.R.drawable.ic_post_download_new);
            appCompatImageView.setEnabled(true);
        } else {
            q0(appCompatImageView);
            appCompatImageView.setImageResource(com.tn.lib.widget.R.drawable.ic_post_downloaded);
            appCompatImageView.setEnabled(true);
        }
    }

    @Override // com.transsion.postdetail.ui.view.PostBaseItemView
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getDownloadManager().g(this.downloadListener);
        r0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        getDownloadManager().k(this.downloadListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.postdetail.ui.view.PostBaseItemView
    public void setHeaderData(PostSubjectItem item) {
        Intrinsics.h(item, "item");
        if (item.isRoomCache()) {
            getViewBinding().getRoot().setBackgroundColor(androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.room_cache_item_bg_color));
        } else {
            getViewBinding().getRoot().setBackground(null);
        }
        k0(item);
    }

    @Override // com.transsion.postdetail.ui.view.PostBaseItemView
    public void setSubjectAndRoomContent(PostSubjectItem item) {
        Intrinsics.h(item, "item");
        this.mItem = item;
        r0();
        T(new Function0() { // from class: com.transsion.postdetail.ui.view.m1
            public final Object invoke() {
                Unit o0;
                o0 = PostExploreItemView.o0(PostExploreItemView.this);
                return o0;
            }
        }, item);
        if (item.getSubject() == null) {
            setBottomSubjectAndRoomVisibility(false, false);
        } else {
            setBottomSubjectAndRoomVisibility(true, false);
            setBottomSubjectModuleData(item);
        }
    }
}
