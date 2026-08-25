package com.transsion.room.sub.adapter.subscription;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
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
import com.transsion.room.sub.adapter.subscription.k;
import com.transsion.room.sub.bean.subscription.ItemTrending;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002+,B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/transsion/room/sub/adapter/subscription/k;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/room/sub/bean/subscription/ItemTrending;", "Lt6/i;", BuildConfig.FLAVOR, "data", "Lbj/b;", "listExposureHelper", BuildConfig.FLAVOR, "showNumberTh", "<init>", "(Ljava/util/List;Lbj/b;Z)V", "Lcom/transsion/room/sub/adapter/subscription/a;", "itemClickListener", BuildConfig.FLAVOR, "Q1", "(Lcom/transsion/room/sub/adapter/subscription/a;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "z0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "G", "Lbj/b;", "H", "Z", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mLikeImg", "J", "Lcom/transsion/room/sub/adapter/subscription/a;", "clickListener", "K", "a", "b", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k extends BaseProviderMultiAdapter<ItemTrending> implements t6.i {
    private static final String L = "SubscriptionFeedAdapter";
    public static final int M = 1;

    /* renamed from: G, reason: from kotlin metadata */
    private final bj.b listExposureHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean showNumberTh;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mLikeImg;

    /* renamed from: J, reason: from kotlin metadata */
    private a clickListener;

    public static final class b extends BaseItemProvider {
        private final bj.b e;
        private final boolean f;
        private final String g = "/subscription/subscription";
        private a h;

        public b(bj.b bVar, boolean z) {
            this.e = bVar;
            this.f = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G(b bVar, ItemTrending itemTrending, Ref.IntRef intRef, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            a aVar = bVar.h;
            if (aVar != null) {
                aVar.E(itemTrending.getContent().getVideo());
            }
            bVar.N("item", itemTrending, intRef.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(Ref.BooleanRef booleanRef, Ref.ObjectRef objectRef, BaseViewHolder baseViewHolder, b bVar, Ref.ObjectRef objectRef2, ItemTrending itemTrending, Ref.IntRef intRef, View view) {
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
            a.a.f(wf.a.a, k.L, "like 点击后状态 " + booleanRef.element, false, 4, (Object) null);
            a aVar = bVar.h;
            if (aVar != null) {
                boolean z2 = booleanRef.element;
                UGCVideo video = itemTrending.getContent().getVideo();
                aVar.w(z2, String.valueOf(video != null ? video.getUgcVideoId() : null));
            }
            bVar.N("like", itemTrending, intRef.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void I(b bVar, ItemTrending itemTrending, Ref.IntRef intRef, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            a aVar = bVar.h;
            if (aVar != null) {
                aVar.t(itemTrending.getContent().getVideo());
            }
            bVar.N("comment", itemTrending, intRef.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void J(b bVar, ItemTrending itemTrending, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            a aVar = bVar.h;
            if (aVar != null) {
                UGCVideo video = itemTrending.getContent().getVideo();
                String ugcVideoId = video != null ? video.getUgcVideoId() : null;
                UGCVideo video2 = itemTrending.getContent().getVideo();
                aVar.I(ugcVideoId, video2 != null ? video2.getTitle() : null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void K(b bVar, ItemTrending itemTrending, View view) {
            UGCVideoCreator creator;
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            a aVar = bVar.h;
            if (aVar != null) {
                UGCVideo video = itemTrending.getContent().getVideo();
                aVar.b((video == null || (creator = video.getCreator()) == null) ? null : creator.getUid());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L(b bVar, ItemTrending itemTrending, Ref.IntRef intRef, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            a aVar = bVar.h;
            if (aVar != null) {
                aVar.E(itemTrending.getContent().getVideo());
            }
            bVar.N("item", itemTrending, intRef.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void M(b bVar, ItemTrending itemTrending, Ref.IntRef intRef, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            a aVar = bVar.h;
            if (aVar != null) {
                aVar.E(itemTrending.getContent().getVideo());
            }
            bVar.N("item", itemTrending, intRef.element);
        }

        private final void N(String str, ItemTrending itemTrending, int i) {
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", str);
            UGCVideo video = itemTrending.getContent().getVideo();
            hashMap.put("ops", String.valueOf(video != null ? video.getOps() : null));
            UGCVideo video2 = itemTrending.getContent().getVideo();
            hashMap.put("content_id", String.valueOf(video2 != null ? video2.getUgcVideoId() : null));
            hashMap.put("position", String.valueOf(i));
            UGCVideo video3 = itemTrending.getContent().getVideo();
            hashMap.put("refer_subject_id", String.valueOf(video3 != null ? video3.getSubjectId() : null));
            hashMap.put("content_type", "ugc_video");
            com.transsion.baselib.helper.a.a.b(this.g, hashMap);
        }

        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public void b(final BaseViewHolder baseViewHolder, final ItemTrending itemTrending) {
            List q;
            UGCVideoInteractiveInfo interactiveInfo;
            UGCVideoInteractiveInfo interactiveInfo2;
            UGCVideoInteractiveInfo interactiveInfo3;
            Long duration;
            UGCVideoCreator creator;
            String str;
            Cover cover;
            Cover cover2;
            Intrinsics.h(baseViewHolder, "holder");
            Intrinsics.h(itemTrending, "feedItem");
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = baseViewHolder.getBindingAdapterPosition();
            ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R$id.cover_image);
            String str2 = null;
            if (viewOrNull != null) {
                f.a aVar = ni.f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                UGCVideo video = itemTrending.getContent().getVideo();
                f.b g = m.g((video == null || (cover2 = video.getCover()) == null) ? null : cover2.getUrl());
                UGCVideo video2 = itemTrending.getContent().getVideo();
                if (video2 == null || (cover = video2.getCover()) == null || (str = cover.getThumbnail()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                g.l(str).d(viewOrNull);
                viewOrNull.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        k.b.G(k.b.this, itemTrending, intRef, view);
                    }
                });
            }
            UGCVideo video3 = itemTrending.getContent().getVideo();
            String corner = video3 != null ? video3.getCorner() : null;
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
                UGCVideo video4 = itemTrending.getContent().getVideo();
                m2.g((video4 == null || (creator = video4.getCreator()) == null) ? null : creator.getAvatar()).i(com.transsion.wrapperad.R.color.white_20).d(viewOrNull3);
                viewOrNull3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        k.b.K(k.b.this, itemTrending, view);
                    }
                });
            }
            UGCVideo video5 = itemTrending.getContent().getVideo();
            ImageView imageView = (ImageView) baseViewHolder.getViewOrNull(R$id.trending_grid_type_icon);
            if (imageView != null && video5 != null) {
                UGCVideoTypeKt.i(imageView, video5, (Integer) null, 4, (Object) null);
            }
            int i = R$id.trending_grid_time_text;
            UGCVideo video6 = itemTrending.getContent().getVideo();
            baseViewHolder.setText(i, TimeUtilKt.a((video6 == null || (duration = video6.getDuration()) == null) ? null : Integer.valueOf((int) duration.longValue())));
            int i2 = R$id.videoTitle;
            UGCVideo video7 = itemTrending.getContent().getVideo();
            baseViewHolder.setText(i2, video7 != null ? video7.getTitle() : null);
            TextView textView = (TextView) baseViewHolder.getViewOrNull(R$id.videoTitle);
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        k.b.L(k.b.this, itemTrending, intRef, view);
                    }
                });
            }
            TextView textView2 = (TextView) baseViewHolder.getViewOrNull(R$id.videoInfo);
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        k.b.M(k.b.this, itemTrending, intRef, view);
                    }
                });
            }
            UGCVideo video8 = itemTrending.getContent().getVideo();
            if (video8 != null ? video8.isVerticalImmStyle() : false) {
                String string = Utils.a().getString(com.transsion.baseui.R.string.ugc_video_shorts);
                UGCVideo video9 = itemTrending.getContent().getVideo();
                q = CollectionsKt.q(new String[]{"special_#shorts_icon", string, com.transsion.baseui.util.j.c(video9 != null ? video9.getWatchNum() : null, k())});
            } else {
                UGCVideo video10 = itemTrending.getContent().getVideo();
                String c = com.transsion.baseui.util.j.c(video10 != null ? video10.getWatchNum() : null, k());
                UGCVideo video11 = itemTrending.getContent().getVideo();
                Long publishTime = video11 != null ? video11.getPublishTime() : null;
                Intrinsics.e(publishTime);
                q = CollectionsKt.q(new String[]{c, TimeUtilKt.l(publishTime.longValue())});
            }
            baseViewHolder.setText(R$id.videoInfo, com.transsion.baseui.util.q.e(q, k()));
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = baseViewHolder.getView(R$id.likeText);
            UGCVideo video12 = itemTrending.getContent().getVideo();
            String likeNum = (video12 == null || (interactiveInfo3 = video12.getInteractiveInfo()) == null) ? null : interactiveInfo3.getLikeNum();
            a.a aVar3 = wf.a.a;
            a.a.f(aVar3, k.L, "likeNumber的数量: " + likeNum, false, 4, (Object) null);
            UGCVideo video13 = itemTrending.getContent().getVideo();
            boolean c2 = (video13 == null || (interactiveInfo2 = video13.getInteractiveInfo()) == null) ? false : Intrinsics.c(interactiveInfo2.getHasLike(), Boolean.TRUE);
            P(c2, (AppCompatTextView) objectRef.element);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = c2;
            a.a.f(aVar3, k.L, "like 初始状态 " + c2, false, 4, (Object) null);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Integer valueOf = likeNum != null ? Integer.valueOf(Integer.parseInt(likeNum)) : null;
            objectRef2.element = valueOf;
            if (valueOf != null && valueOf.intValue() < 0) {
                objectRef2.element = 0;
            }
            baseViewHolder.setText(R$id.likeText, String.valueOf(objectRef2.element));
            ((AppCompatTextView) objectRef.element).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k.b.H(booleanRef, objectRef2, baseViewHolder, this, objectRef, itemTrending, intRef, view);
                }
            });
            int i3 = R$id.commentImg;
            UGCVideo video14 = itemTrending.getContent().getVideo();
            if (video14 != null && (interactiveInfo = video14.getInteractiveInfo()) != null) {
                str2 = interactiveInfo.getCommentNum();
            }
            baseViewHolder.setText(i3, str2);
            baseViewHolder.getView(R$id.commentImg).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k.b.I(k.b.this, itemTrending, intRef, view);
                }
            });
            baseViewHolder.getView(R$id.shareImg).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k.b.J(k.b.this, itemTrending, view);
                }
            });
        }

        public final void O(a aVar) {
            this.h = aVar;
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
    public k(List<ItemTrending> list, bj.b bVar, boolean z) {
        super(list);
        Intrinsics.h(list, "data");
        this.listExposureHelper = bVar;
        this.showNumberTh = z;
    }

    public /* synthetic */ k(List list, bj.b bVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    protected int N1(List<ItemTrending> data, int position) {
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
