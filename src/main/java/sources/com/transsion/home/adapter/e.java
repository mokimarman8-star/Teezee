package com.transsion.home.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.baseui.util.j;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCreator;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import ij.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;
import t6.h;
import t6.i;
import wf.a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003*+,B3\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R*\u0010\n\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/transsion/home/adapter/e;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/ugcvideodetail/api/bean/UGCContent;", "Lt6/i;", BuildConfig.FLAVOR, "data", "Lrk/b;", "exposureHelper", BuildConfig.FLAVOR, "showNumberTh", "isEducationList", "<init>", "(Ljava/util/List;Lrk/b;ZZ)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", BuildConfig.FLAVOR, "B0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "G", "Lrk/b;", "H", "Z", "Lcom/transsion/home/adapter/e$c;", "I", "Lcom/transsion/home/adapter/e$c;", "filmItemProvider", "Lcom/transsion/home/adapter/e$b;", "J", "Lcom/transsion/home/adapter/e$b;", "eduFilmItemProvider", "value", "K", "Q1", "()Z", "R1", "(Z)V", "L", "a", "c", "b", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends BaseProviderMultiAdapter<UGCContent> implements i {
    public static final int M = 8;
    private static final String N = "FilmListAdapter";
    public static final int O = 1;
    public static final int P = 2;

    /* renamed from: G, reason: from kotlin metadata */
    private final rk.b exposureHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean showNumberTh;

    /* renamed from: I, reason: from kotlin metadata */
    private c filmItemProvider;

    /* renamed from: J, reason: from kotlin metadata */
    private b eduFilmItemProvider;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isEducationList;

    public static final class b extends BaseItemProvider {
        private final rk.b e;
        private final boolean f;
        private boolean g;

        public b(rk.b bVar, boolean z, boolean z2) {
            this.e = bVar;
            this.f = z;
            this.g = z2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:62:0x0100, code lost:
        
            if (r0 != null) goto L46;
         */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0114  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void A(BaseViewHolder baseViewHolder, UGCVideo uGCVideo) {
            String str;
            String str2;
            String title;
            String str3;
            String str4;
            ShapeableImageView view = baseViewHolder.getView(R.id.iv_cover);
            f.a aVar = ni.f.a;
            f.b m = aVar.m(k());
            Cover cover = uGCVideo.getCover();
            String str5 = BuildConfig.FLAVOR;
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b i = m.g(str).i(com.tn.lib.widget.R.color.cl37);
            Cover cover2 = uGCVideo.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            i.l(str2).d(view);
            int i2 = R.id.tv_title;
            String title2 = uGCVideo.getTitle();
            if (title2 == null) {
                title2 = BuildConfig.FLAVOR;
            }
            baseViewHolder.setText(i2, title2);
            baseViewHolder.setText(R.id.tv_views, j.c(uGCVideo.getWatchNum(), k()));
            boolean z = true;
            if (!this.g || o.a.i()) {
                baseViewHolder.setVisible(R.id.iv_res_post_type, true);
                baseViewHolder.setGone(R.id.iv_upload_user_icon, true);
                ((ImageView) baseViewHolder.getView(R.id.iv_res_post_type)).setImageResource(UGCVideoTypeKt.e(uGCVideo.getCategory()));
                if (o.a.i()) {
                    Long publishTime = uGCVideo.getPublishTime();
                    long longValue = publishTime != null ? publishTime.longValue() : 0L;
                    if (longValue > 0) {
                        title = TimeUtilKt.j(longValue);
                        if (title.length() == 0) {
                            baseViewHolder.setVisible(R.id.separator, false);
                            baseViewHolder.setText(R.id.tv_type, BuildConfig.FLAVOR);
                        } else {
                            baseViewHolder.setVisible(R.id.separator, true);
                            baseViewHolder.setText(R.id.tv_type, title);
                        }
                    }
                    title = BuildConfig.FLAVOR;
                    if (title.length() == 0) {
                    }
                } else {
                    List hashTags = uGCVideo.getHashTags();
                    if (hashTags != null) {
                        UGCVideoHashTag uGCVideoHashTag = (UGCVideoHashTag) CollectionsKt.l0(hashTags, 0);
                        if (uGCVideoHashTag != null) {
                            title = uGCVideoHashTag.getTitle();
                        }
                    }
                    title = BuildConfig.FLAVOR;
                    if (title.length() == 0) {
                    }
                }
            } else {
                baseViewHolder.setGone(R.id.iv_res_post_type, true);
                baseViewHolder.setVisible(R.id.iv_upload_user_icon, true);
                f.b m2 = aVar.m(k());
                UGCVideoCreator creator = uGCVideo.getCreator();
                if (creator == null || (str3 = creator.getAvatar()) == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                m2.g(str3).i(R$drawable.icon_ugc_user_upload).d((ImageView) baseViewHolder.getView(R.id.iv_upload_user_icon));
                int i3 = R.id.tv_type;
                UGCVideoCreator creator2 = uGCVideo.getCreator();
                if (creator2 == null || (str4 = creator2.getNickname()) == null) {
                    str4 = BuildConfig.FLAVOR;
                }
                baseViewHolder.setText(i3, str4);
            }
            if (o.a.i()) {
                z(baseViewHolder, uGCVideo);
            }
            baseViewHolder.setText(R.id.tv_duration, uGCVideo.getTimeOrCount(k()));
            String corner = uGCVideo.getCorner();
            View view2 = baseViewHolder.getView(R.id.tag_audio);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_audio_tag);
            if (corner != null && !StringsKt.q0(corner)) {
                z = false;
            }
            view2.setVisibility(z ? 8 : 0);
            String corner2 = uGCVideo.getCorner();
            if (corner2 != null) {
                str5 = corner2;
            }
            textView.setText(str5);
        }

        private final void y(BaseViewHolder baseViewHolder) {
            int layoutPosition = baseViewHolder.getLayoutPosition();
            View view = baseViewHolder.getView(R.id.tag_ranking);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_ranking);
            if (!this.f) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int i = layoutPosition + 1;
            textView.setText(String.valueOf(i));
            view.setBackgroundResource(i != 1 ? i != 2 ? i != 3 ? R$drawable.bg_ranking_normal : R$drawable.bg_ranking_no3 : R$drawable.bg_ranking_no2 : R$drawable.bg_ranking_no1);
        }

        private final void z(BaseViewHolder baseViewHolder, UGCVideo uGCVideo) {
            RecyclerView viewOrNull = baseViewHolder.getViewOrNull(R.id.recyclerTag);
            if (viewOrNull == null) {
                return;
            }
            List filteredHashTags = uGCVideo.getFilteredHashTags();
            List list = filteredHashTags;
            if (list == null || list.isEmpty()) {
                viewOrNull.setAdapter((RecyclerView.Adapter) null);
                viewOrNull.setVisibility(8);
                return;
            }
            viewOrNull.setVisibility(0);
            if (viewOrNull.getLayoutManager() == null) {
                viewOrNull.setLayoutManager(new LinearLayoutManager(k(), 0, false));
                viewOrNull.setNestedScrollingEnabled(false);
            }
            Intrinsics.e(filteredHashTags);
            viewOrNull.setAdapter(new com.transsion.home.adapter.operateUGC.adapter.f(filteredHashTags));
        }

        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder baseViewHolder, UGCContent uGCContent) {
            Intrinsics.h(baseViewHolder, "holder");
            Intrinsics.h(uGCContent, "data");
            String topicType = uGCContent.getTopicType();
            a.a aVar = wf.a.a;
            a.a.f(aVar, e.N, "convert: position=" + baseViewHolder.getLayoutPosition() + ", topicType=" + topicType, false, 4, (Object) null);
            if (Intrinsics.c(topicType, "UGC_VIDEO")) {
                UGCVideo video = uGCContent.getVideo();
                if (video != null) {
                    A(baseViewHolder, video);
                } else {
                    a.a.x(aVar, e.N, "convert: UGC_VIDEO but video is null at position=" + baseViewHolder.getLayoutPosition(), false, 4, (Object) null);
                }
            } else {
                a.a.x(aVar, e.N, "convert: unsupported topicType=" + topicType + " at position=" + baseViewHolder.getLayoutPosition(), false, 4, (Object) null);
            }
            y(baseViewHolder);
        }

        public final void C(boolean z) {
            this.g = z;
        }

        public int l() {
            return 2;
        }

        public int m() {
            return R.layout.ugc_item_edu_film_list;
        }
    }

    public static final class c extends BaseItemProvider {
        private final rk.b e;
        private final boolean f;
        private boolean g;

        public c(rk.b bVar, boolean z, boolean z2) {
            this.e = bVar;
            this.f = z;
            this.g = z2;
        }

        private final void y(BaseViewHolder baseViewHolder) {
            int layoutPosition = baseViewHolder.getLayoutPosition();
            View view = baseViewHolder.getView(R.id.tag_ranking);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_ranking);
            if (!this.f) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            int i = layoutPosition + 1;
            textView.setText(String.valueOf(i));
            view.setBackgroundResource(i != 1 ? i != 2 ? i != 3 ? R$drawable.bg_ranking_normal : R$drawable.bg_ranking_no3 : R$drawable.bg_ranking_no2 : R$drawable.bg_ranking_no1);
        }

        private final void z(BaseViewHolder baseViewHolder, UGCVideo uGCVideo) {
            String str;
            String str2;
            String str3;
            UGCVideoHashTag uGCVideoHashTag;
            String str4;
            String str5;
            ShapeableImageView view = baseViewHolder.getView(R.id.iv_cover);
            f.a aVar = ni.f.a;
            f.b m = aVar.m(k());
            Cover cover = uGCVideo.getCover();
            String str6 = BuildConfig.FLAVOR;
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b i = m.g(str).i(com.tn.lib.widget.R.color.cl37);
            Cover cover2 = uGCVideo.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            i.l(str2).d(view);
            int i2 = R.id.tv_title;
            String title = uGCVideo.getTitle();
            if (title == null) {
                title = BuildConfig.FLAVOR;
            }
            baseViewHolder.setText(i2, title);
            baseViewHolder.setText(R.id.tv_views, j.c(uGCVideo.getWatchNum(), k()));
            boolean z = true;
            if (this.g) {
                baseViewHolder.setGone(R.id.iv_res_post_type, true);
                baseViewHolder.setVisible(R.id.iv_upload_user_icon, true);
                f.b m2 = aVar.m(k());
                UGCVideoCreator creator = uGCVideo.getCreator();
                if (creator == null || (str4 = creator.getAvatar()) == null) {
                    str4 = BuildConfig.FLAVOR;
                }
                m2.g(str4).i(R$drawable.icon_ugc_user_upload).d((ImageView) baseViewHolder.getView(R.id.iv_upload_user_icon));
                int i3 = R.id.tv_type;
                UGCVideoCreator creator2 = uGCVideo.getCreator();
                if (creator2 == null || (str5 = creator2.getNickname()) == null) {
                    str5 = BuildConfig.FLAVOR;
                }
                baseViewHolder.setText(i3, str5);
            } else {
                baseViewHolder.setVisible(R.id.iv_res_post_type, true);
                baseViewHolder.setGone(R.id.iv_upload_user_icon, true);
                UGCVideoTypeKt.i((ImageView) baseViewHolder.getView(R.id.iv_res_post_type), uGCVideo, (Integer) null, 4, (Object) null);
                List hashTags = uGCVideo.getHashTags();
                if (hashTags == null || (uGCVideoHashTag = (UGCVideoHashTag) CollectionsKt.l0(hashTags, 0)) == null || (str3 = uGCVideoHashTag.getTitle()) == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                if (str3.length() == 0) {
                    baseViewHolder.setVisible(R.id.separator, false);
                    baseViewHolder.setText(R.id.tv_type, BuildConfig.FLAVOR);
                } else {
                    baseViewHolder.setVisible(R.id.separator, true);
                    baseViewHolder.setText(R.id.tv_type, str3);
                }
            }
            baseViewHolder.setText(R.id.tv_duration, uGCVideo.getTimeOrCount(k()));
            String corner = uGCVideo.getCorner();
            View view2 = baseViewHolder.getView(R.id.tag_audio);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_audio_tag);
            if (corner != null && !StringsKt.q0(corner)) {
                z = false;
            }
            view2.setVisibility(z ? 8 : 0);
            String corner2 = uGCVideo.getCorner();
            if (corner2 != null) {
                str6 = corner2;
            }
            textView.setText(str6);
        }

        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder baseViewHolder, UGCContent uGCContent) {
            Intrinsics.h(baseViewHolder, "holder");
            Intrinsics.h(uGCContent, "data");
            String topicType = uGCContent.getTopicType();
            a.a aVar = wf.a.a;
            a.a.f(aVar, e.N, "convert: position=" + baseViewHolder.getLayoutPosition() + ", topicType=" + topicType, false, 4, (Object) null);
            if (Intrinsics.c(topicType, "UGC_VIDEO")) {
                UGCVideo video = uGCContent.getVideo();
                if (video != null) {
                    z(baseViewHolder, video);
                } else {
                    a.a.x(aVar, e.N, "convert: UGC_VIDEO but video is null at position=" + baseViewHolder.getLayoutPosition(), false, 4, (Object) null);
                }
            } else {
                a.a.x(aVar, e.N, "convert: unsupported topicType=" + topicType + " at position=" + baseViewHolder.getLayoutPosition(), false, 4, (Object) null);
            }
            y(baseViewHolder);
        }

        public final void B(boolean z) {
            this.g = z;
        }

        public int l() {
            return 1;
        }

        public int m() {
            return R.layout.ugc_item_film_list;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(List<UGCContent> list, rk.b bVar, boolean z, boolean z2) {
        super(list);
        Intrinsics.h(list, "data");
        this.exposureHelper = bVar;
        this.showNumberTh = z;
        this.isEducationList = z2;
        c cVar = new c(bVar, z, z2);
        this.filmItemProvider = cVar;
        b bVar2 = new b(bVar, z, z2);
        this.eduFilmItemProvider = bVar2;
        F1(cVar);
        F1(bVar2);
    }

    public /* synthetic */ e(List list, rk.b bVar, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, bVar, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        rk.b bVar = this.exposureHelper;
        if (bVar != null) {
            RecyclerView.m layoutManager = getRecyclerView().getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            bVar.h((LinearLayoutManager) layoutManager, bindingAdapterPosition, true);
        }
    }

    protected int N1(List<UGCContent> data, int position) {
        Intrinsics.h(data, "data");
        return o.a.i() ? 2 : 1;
    }

    /* renamed from: Q1, reason: from getter */
    public final boolean getIsEducationList() {
        return this.isEducationList;
    }

    public final void R1(boolean z) {
        this.isEducationList = z;
        c cVar = this.filmItemProvider;
        if (cVar != null) {
            cVar.B(z);
        }
        b bVar = this.eduFilmItemProvider;
        if (bVar != null) {
            bVar.C(z);
        }
        notifyItemRangeChanged(0, getData().size());
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
