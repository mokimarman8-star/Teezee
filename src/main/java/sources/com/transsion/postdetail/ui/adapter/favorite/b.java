package com.transsion.postdetail.ui.adapter.favorite;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.tn.lib.widget.R;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.baseui.util.j;
import com.transsion.baseui.util.q;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.adapter.favorite.b;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ni.f;
import t6.h;
import t6.i;
import yg.l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\"#B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/transsion/postdetail/ui/adapter/favorite/b;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "Lt6/i;", BuildConfig.FLAVOR, "data", "Lbj/b;", "exposureHelper", BuildConfig.FLAVOR, "showNumberTh", "<init>", "(Ljava/util/List;Lbj/b;Z)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Lcom/transsion/postdetail/ui/adapter/favorite/a;", "itemClickListener", BuildConfig.FLAVOR, "Q1", "(Lcom/transsion/postdetail/ui/adapter/favorite/a;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "G", "Lbj/b;", "H", "Z", "I", "Lcom/transsion/postdetail/ui/adapter/favorite/a;", "clickListener", "J", "a", "b", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseProviderMultiAdapter<UGCVideo> implements i {
    private static final String K = "UgcFavoriteFeedAdapter";
    public static final int L = 1;

    /* renamed from: G, reason: from kotlin metadata */
    private final bj.b exposureHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean showNumberTh;

    /* renamed from: I, reason: from kotlin metadata */
    private a clickListener;

    /* renamed from: com.transsion.postdetail.ui.adapter.favorite.b$b, reason: collision with other inner class name */
    public static final class C0052b extends BaseItemProvider {
        private final bj.b e;
        private final boolean f;
        private a g;
        private final String h = "/ugc/favorite";

        public C0052b(bj.b bVar, boolean z) {
            this.e = bVar;
            this.f = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void A(C0052b c0052b, UGCVideo uGCVideo, Ref.IntRef intRef, View view) {
            if (!l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            a aVar = c0052b.g;
            if (aVar != null) {
                aVar.a(uGCVideo);
            }
            c0052b.B("item", uGCVideo, intRef.element);
        }

        private final void B(String str, UGCVideo uGCVideo, int i) {
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", str);
            hashMap.put("ops", String.valueOf(uGCVideo.getOps()));
            hashMap.put("content_id", String.valueOf(uGCVideo.getUgcVideoId()));
            UGCVideoBelongToCollection belongToCollection = uGCVideo.getBelongToCollection();
            hashMap.put("belong_to_collection_id", String.valueOf(belongToCollection != null ? belongToCollection.getCollectionId() : null));
            hashMap.put("position", String.valueOf(i));
            hashMap.put("refer_subject_id", String.valueOf(uGCVideo.getSubjectId()));
            hashMap.put("content_type", "ugc_video");
            com.transsion.baselib.helper.a.a.b(this.h, hashMap);
        }

        public final void C(a aVar) {
            this.g = aVar;
        }

        public int l() {
            return 1;
        }

        public int m() {
            return R$layout.fragment_favorite_item_waterfall_feed;
        }

        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder baseViewHolder, final UGCVideo uGCVideo) {
            String str;
            Intrinsics.h(baseViewHolder, "holder");
            Intrinsics.h(uGCVideo, "feedItem");
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = baseViewHolder.getBindingAdapterPosition();
            ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R$id.coverImage);
            if (viewOrNull != null) {
                f.a aVar = f.a;
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
                viewOrNull.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.adapter.favorite.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.C0052b.A(b.C0052b.this, uGCVideo, intRef, view);
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
            ImageView imageView = (ImageView) baseViewHolder.getViewOrNull(R$id.trending_grid_type_icon);
            if (imageView != null) {
                UGCVideoTypeKt.i(imageView, uGCVideo, (Integer) null, 4, (Object) null);
            }
            int i = R$id.trending_grid_time_text;
            Long duration = uGCVideo.getDuration();
            baseViewHolder.setText(i, TimeUtilKt.a(duration != null ? Integer.valueOf((int) duration.longValue()) : null));
            baseViewHolder.setText(R$id.videoTitle, uGCVideo.getTitle());
            baseViewHolder.setText(R$id.videoInfo, q.e(uGCVideo.isVerticalImmStyle() ? CollectionsKt.q(new String[]{"special_#shorts_icon", Utils.a().getString(com.transsion.baseui.R.string.ugc_video_shorts), j.c(uGCVideo.getWatchNum(), k())}) : CollectionsKt.q(new String[]{j.c(uGCVideo.getWatchNum(), k()), TimeUtilKt.m(String.valueOf(uGCVideo.getPublishTime()))}), k()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<UGCVideo> list, bj.b bVar, boolean z) {
        super(list);
        Intrinsics.h(list, "data");
        this.exposureHelper = bVar;
        this.showNumberTh = z;
    }

    public /* synthetic */ b(List list, bj.b bVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, bVar, (i & 4) != 0 ? false : z);
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        StringBuilder sb = new StringBuilder();
        sb.append("曝光的位置position11: ");
        sb.append(bindingAdapterPosition);
        bj.b bVar = this.exposureHelper;
        if (bVar != null) {
            StaggeredGridLayoutManager layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
            bj.b.j(bVar, layoutManager, bindingAdapterPosition, true, false, 8, null);
        }
    }

    protected int N1(List<? extends UGCVideo> data, int position) {
        Intrinsics.h(data, "data");
        return 1;
    }

    public final void Q1(a itemClickListener) {
        this.clickListener = itemClickListener;
        C0052b c0052b = new C0052b(this.exposureHelper, this.showNumberTh);
        c0052b.C(this.clickListener);
        F1(c0052b);
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
