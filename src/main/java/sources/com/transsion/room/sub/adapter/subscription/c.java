package com.transsion.room.sub.adapter.subscription;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.tn.lib.widget.R;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.R$string;
import com.transsion.room.sub.adapter.subscription.c;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCreator;
import com.transsion.ugcvideodetail.api.bean.UGCVideoInteractiveInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002'(B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/transsion/room/sub/adapter/subscription/c;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "Lt6/i;", BuildConfig.FLAVOR, "data", "Lbj/b;", "listExposureHelper", BuildConfig.FLAVOR, "showNumberTh", "<init>", "(Ljava/util/List;Lbj/b;Z)V", "Lcom/transsion/room/sub/adapter/subscription/a;", "itemClickListener", BuildConfig.FLAVOR, "Q1", "(Lcom/transsion/room/sub/adapter/subscription/a;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "z0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "G", "Lbj/b;", "H", "Z", "I", "Lcom/transsion/room/sub/adapter/subscription/a;", "clickListener", "J", "a", "b", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseProviderMultiAdapter<UGCVideo> implements t6.i {
    private static final String K = "SubscriptionFeedAdapter";
    public static final int L = 1;

    /* renamed from: G, reason: from kotlin metadata */
    private final bj.b listExposureHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean showNumberTh;

    /* renamed from: I, reason: from kotlin metadata */
    private a clickListener;

    public static final class b extends BaseItemProvider {
        private final bj.b e;
        private final boolean f;
        private a g;

        public b(bj.b bVar, boolean z) {
            this.e = bVar;
            this.f = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G(b bVar, UGCVideo uGCVideo, Ref.IntRef intRef, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R$string.base_net_err);
                return;
            }
            a aVar = bVar.g;
            if (aVar != null) {
                aVar.a(uGCVideo);
            }
            bVar.N("item", uGCVideo, intRef.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, BaseViewHolder baseViewHolder, b bVar, Ref.ObjectRef objectRef2, UGCVideo uGCVideo, Ref.IntRef intRef, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            boolean z = !booleanRef.element;
            booleanRef.element = z;
            if (z) {
                Integer num = (Integer) objectRef.element;
                objectRef.element = num != null ? Integer.valueOf(num.intValue() + 1) : null;
            } else {
                Integer num2 = (Integer) objectRef.element;
                objectRef.element = num2 != null ? Integer.valueOf(num2.intValue() - 1) : null;
            }
            Integer num3 = (Integer) objectRef.element;
            if (num3 != null && num3.intValue() < 0) {
                objectRef.element = 0;
            }
            baseViewHolder.setText(R$id.likeText, String.valueOf(objectRef.element));
            bVar.P(booleanRef.element, (AppCompatTextView) objectRef2.element);
            a.a.f(wf.a.a, c.K, "like 点击后状态 " + booleanRef.element, false, 4, (Object) null);
            a aVar = bVar.g;
            if (aVar != null) {
                aVar.w(booleanRef.element, String.valueOf(uGCVideo.getUgcVideoId()));
            }
            bVar.N("like", uGCVideo, intRef.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void I(b bVar, UGCVideo uGCVideo, Ref.IntRef intRef, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            a aVar = bVar.g;
            if (aVar != null) {
                aVar.t(uGCVideo);
            }
            bVar.N("comment", uGCVideo, intRef.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void J(b bVar, UGCVideo uGCVideo, View view) {
            a aVar;
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
            } else {
                if (com.transsion.baseui.util.c.a.a(view.getId(), 500L) || (aVar = bVar.g) == null) {
                    return;
                }
                aVar.I(uGCVideo.getUgcVideoId(), uGCVideo.getTitle());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void K(b bVar, UGCVideo uGCVideo, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R$string.base_net_err);
                return;
            }
            a aVar = bVar.g;
            if (aVar != null) {
                UGCVideoCreator creator = uGCVideo.getCreator();
                aVar.b(creator != null ? creator.getUid() : null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L(b bVar, UGCVideo uGCVideo, Ref.IntRef intRef, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R$string.base_net_err);
                return;
            }
            a aVar = bVar.g;
            if (aVar != null) {
                aVar.a(uGCVideo);
            }
            bVar.N("item", uGCVideo, intRef.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void M(b bVar, UGCVideo uGCVideo, Ref.IntRef intRef, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R$string.base_net_err);
                return;
            }
            a aVar = bVar.g;
            if (aVar != null) {
                aVar.a(uGCVideo);
            }
            bVar.N("item", uGCVideo, intRef.element);
        }

        private final void N(String str, UGCVideo uGCVideo, int i) {
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", str);
            hashMap.put("ops", String.valueOf(uGCVideo.getOps()));
            hashMap.put("content_id", String.valueOf(uGCVideo.getUgcVideoId()));
            hashMap.put("position", String.valueOf(i));
            hashMap.put("refer_subject_id", String.valueOf(uGCVideo.getSubjectId()));
            hashMap.put("content_type", "ugc_video");
            com.transsion.baselib.helper.a.a.b("/subscription/subscription", hashMap);
        }

        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public void b(final BaseViewHolder baseViewHolder, final UGCVideo uGCVideo) {
            List q;
            String thumbnail;
            String str;
            Intrinsics.h(baseViewHolder, "holder");
            Intrinsics.h(uGCVideo, "feedItem");
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = baseViewHolder.getBindingAdapterPosition();
            ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R$id.cover_image);
            String str2 = BuildConfig.FLAVOR;
            if (viewOrNull != null) {
                f.a aVar = ni.f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = uGCVideo.getCover();
                f.b g = m.g(cover != null ? cover.getUrl() : null);
                Cover cover2 = uGCVideo.getCover();
                if (cover2 == null || (str = cover2.getThumbnail()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                g.l(str).d(viewOrNull);
                viewOrNull.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.b.G(c.b.this, uGCVideo, intRef, view);
                    }
                });
            }
            String corner = uGCVideo.getCorner();
            if (corner == null) {
                CornerTextView viewOrNull2 = baseViewHolder.getViewOrNull(R$id.languageTag);
                if (viewOrNull2 != null) {
                    viewOrNull2.setVisibility(4);
                }
            } else {
                baseViewHolder.setText(R$id.languageTag, corner);
            }
            ShapeableImageView viewOrNull3 = baseViewHolder.getViewOrNull(R$id.publisherAvatar);
            if (viewOrNull3 != null) {
                f.a aVar2 = ni.f.a;
                Context context2 = viewOrNull3.getContext();
                Intrinsics.g(context2, "getContext(...)");
                f.b m2 = aVar2.m(context2);
                UGCVideoCreator creator = uGCVideo.getCreator();
                f.b g2 = m2.g(creator != null ? creator.getAvatar() : null);
                Cover cover3 = uGCVideo.getCover();
                if (cover3 != null && (thumbnail = cover3.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                g2.l(str2).d(viewOrNull3);
                viewOrNull3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.b.K(c.b.this, uGCVideo, view);
                    }
                });
            }
            ImageView imageView = (ImageView) baseViewHolder.getViewOrNull(R$id.trending_grid_type_icon);
            if (imageView != null) {
                UGCVideoTypeKt.i(imageView, uGCVideo, (Integer) null, 4, (Object) null);
            }
            int i = R$id.trending_grid_time_text;
            Long duration = uGCVideo.getDuration();
            baseViewHolder.setText(i, TimeUtilKt.a(duration != null ? Integer.valueOf((int) duration.longValue()) : null));
            baseViewHolder.setText(R$id.videoTitle, uGCVideo.getTitle());
            TextView textView = (TextView) baseViewHolder.getViewOrNull(R$id.videoTitle);
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.b.L(c.b.this, uGCVideo, intRef, view);
                    }
                });
            }
            TextView textView2 = (TextView) baseViewHolder.getViewOrNull(R$id.videoInfo);
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.b.M(c.b.this, uGCVideo, intRef, view);
                    }
                });
            }
            if (uGCVideo.isVerticalImmStyle()) {
                q = CollectionsKt.q(new String[]{"special_#shorts_icon", Utils.a().getString(com.transsion.baseui.R.string.ugc_video_shorts), com.transsion.baseui.util.j.c(uGCVideo.getWatchNum(), k())});
            } else {
                String c = com.transsion.baseui.util.j.c(uGCVideo.getWatchNum(), k());
                Long publishTime = uGCVideo.getPublishTime();
                Intrinsics.e(publishTime);
                q = CollectionsKt.q(new String[]{c, TimeUtilKt.l(publishTime.longValue())});
            }
            baseViewHolder.setText(R$id.videoInfo, com.transsion.baseui.util.q.e(q, k()));
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = baseViewHolder.getView(R$id.likeText);
            LinearLayoutCompat view = baseViewHolder.getView(R$id.likeLayout);
            UGCVideoInteractiveInfo interactiveInfo = uGCVideo.getInteractiveInfo();
            String likeNum = interactiveInfo != null ? interactiveInfo.getLikeNum() : null;
            a.a aVar3 = wf.a.a;
            a.a.f(aVar3, c.K, "likeNumber的数量: " + likeNum, false, 4, (Object) null);
            UGCVideoInteractiveInfo interactiveInfo2 = uGCVideo.getInteractiveInfo();
            boolean c2 = interactiveInfo2 != null ? Intrinsics.c(interactiveInfo2.getHasLike(), Boolean.TRUE) : false;
            P(c2, (AppCompatTextView) objectRef.element);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = c2;
            a.a.f(aVar3, c.K, "like 初始状态 " + c2, false, 4, (Object) null);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Integer valueOf = likeNum != null ? Integer.valueOf(Integer.parseInt(likeNum)) : null;
            objectRef2.element = valueOf;
            if (valueOf != null && valueOf.intValue() < 0) {
                objectRef2.element = 0;
            }
            baseViewHolder.setText(R$id.likeText, String.valueOf(objectRef2.element));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.b.H(booleanRef, objectRef2, baseViewHolder, this, objectRef, uGCVideo, intRef, view2);
                }
            });
            int i2 = R$id.commentImg;
            UGCVideoInteractiveInfo interactiveInfo3 = uGCVideo.getInteractiveInfo();
            baseViewHolder.setText(i2, interactiveInfo3 != null ? interactiveInfo3.getCommentNum() : null);
            baseViewHolder.getView(R$id.commentLayout).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.b.I(c.b.this, uGCVideo, intRef, view2);
                }
            });
            baseViewHolder.getView(R$id.shareLayout).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.b.J(c.b.this, uGCVideo, view2);
                }
            });
        }

        public final void O(a aVar) {
            this.g = aVar;
        }

        public final void P(boolean z, AppCompatTextView appCompatTextView) {
            Intrinsics.h(appCompatTextView, "imageLikes");
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(androidx.core.content.b.getDrawable(k(), z ? com.transsion.baseui.R.drawable.base_ic_ugc_post_like_selected : com.transsion.baseui.R.drawable.base_ic_ugc_post_like), (Drawable) null, (Drawable) null, (Drawable) null);
        }

        public int l() {
            return 1;
        }

        public int m() {
            return R$layout.item_feed;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<UGCVideo> list, bj.b bVar, boolean z) {
        super(list);
        Intrinsics.h(list, "data");
        this.listExposureHelper = bVar;
        this.showNumberTh = z;
    }

    public /* synthetic */ c(List list, bj.b bVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, bVar, (i & 4) != 0 ? false : z);
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        bj.b bVar = this.listExposureHelper;
        if (bVar != null) {
            LinearLayoutManager layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            bj.b.j(bVar, layoutManager, bindingAdapterPosition, true, false, 8, null);
        }
    }

    protected int N1(List<? extends UGCVideo> data, int position) {
        Intrinsics.h(data, "data");
        return 1;
    }

    public final void Q1(a itemClickListener) {
        this.clickListener = itemClickListener;
        b bVar = new b(this.listExposureHelper, this.showNumberTh);
        bVar.O(this.clickListener);
        F1(bVar);
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }

    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        return super/*com.chad.library.adapter.base.BaseQuickAdapter*/.z0(parent, viewType);
    }
}
