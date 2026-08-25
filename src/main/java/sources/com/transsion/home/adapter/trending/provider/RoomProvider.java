package com.transsion.home.adapter.trending.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.TnTextView;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.exposure.ExposureType;
import com.transsion.flow.bean.CommentBean;
import com.transsion.flow.bean.MediaType;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.trending.provider.RoomProvider;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.viewmodel.TrendingViewModel;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ni.f;
import qx.b;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomProvider extends BaseItemProvider {
    public static final a p = new a(null);
    public static final int q = 8;
    private static final String r = "TrendingRoom";
    private static final String s = "Trending";
    private static final String t = "room_home_recommend";
    private static final ConfigBean u = cm.f.c.a().c("room_entrance_enable", true);
    private final BaseHomeSubFragment e;
    private final TrendingViewModel f;
    private final Lazy g;
    private bj.b h;
    private bj.b i;
    private final String j;
    private final Lazy k;
    private final e l;
    private final d m;
    private final Lazy n;
    private final Lazy o;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/transsion/home/adapter/trending/provider/RoomProvider$PostAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", BuildConfig.FLAVOR, "pageFrom", "Lep/l;", "trendingRoomsViewModel", "<init>", "(Ljava/lang/String;Lep/l;)V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "PostItemProvider", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PostAdapter extends BaseProviderMultiAdapter<PostSubjectItem> {
        public static final int G = 8;

        public static final class PostItemProvider extends BaseItemProvider {
            private final String e;
            private final ep.l f;
            private final int g;

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/home/adapter/trending/provider/RoomProvider$PostAdapter$PostItemProvider$PostItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lqk/d0;", "viewBinding", "<init>", "(Lqk/d0;)V", "a", "Lqk/d0;", "f", "()Lqk/d0;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class PostItemVH extends BaseViewHolder {

                /* renamed from: a, reason: from kotlin metadata */
                private final qk.d0 viewBinding;

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public PostItemVH(qk.d0 d0Var) {
                    super(r0);
                    Intrinsics.h(d0Var, "viewBinding");
                    BLConstraintLayout root = d0Var.getRoot();
                    Intrinsics.g(root, "getRoot(...)");
                    this.viewBinding = d0Var;
                }

                /* renamed from: f, reason: from getter */
                public final qk.d0 getViewBinding() {
                    return this.viewBinding;
                }
            }

            public PostItemProvider(String str, ep.l lVar) {
                Intrinsics.h(lVar, "trendingRoomsViewModel");
                this.e = str;
                this.f = lVar;
                this.g = lj.a.b(112);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void B(PostItemProvider postItemProvider, PostSubjectItem postSubjectItem, PostItemVH postItemVH, View view) {
                postItemProvider.E(postSubjectItem, postItemVH.getAdapterPosition());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void C(PostSubjectItem postSubjectItem, View view) {
                Group group = postSubjectItem.getGroup();
                Navigator.x(TheRouter.c("/room/detail").K("id", group != null ? group.getGroupId() : null).z("need_start_room_home", false), view.getContext(), (mf.c) null, 2, (Object) null);
                com.transsion.room.helper.l.a.c(RoomProvider.s, RoomProvider.t, postSubjectItem);
            }

            private final void E(PostSubjectItem postSubjectItem, int i) {
                com.transsion.postdetail.helper.a.a.x(this.e, RoomProvider.s, BuildConfig.FLAVOR, i, "item", postSubjectItem, (r17 & 64) != 0 ? null : null);
                ep.k.k(ep.k.a, postSubjectItem, postSubjectItem.getOps(), RoomProvider.s, false, 8, null);
            }

            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public void b(BaseViewHolder baseViewHolder, final PostSubjectItem postSubjectItem) {
                String title;
                Pair pair;
                String url;
                FirstFrame firstFrame;
                String str;
                Cover cover;
                Cover cover2;
                String avatar;
                CharSequence charSequence;
                List image;
                Image image2;
                List image3;
                Image image4;
                Intrinsics.h(baseViewHolder, "helper");
                Intrinsics.h(postSubjectItem, "item");
                final PostItemVH postItemVH = (PostItemVH) baseViewHolder;
                ((RecyclerView.a0) postItemVH).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomProvider.PostAdapter.PostItemProvider.B(RoomProvider.PostAdapter.PostItemProvider.this, postSubjectItem, postItemVH, view);
                    }
                });
                String content = postSubjectItem.getContent();
                String str2 = BuildConfig.FLAVOR;
                if (content == null || content.length() == 0) {
                    title = postSubjectItem.getTitle();
                    if (title == null) {
                        title = BuildConfig.FLAVOR;
                    }
                } else {
                    title = postSubjectItem.getContent();
                }
                TnTextView tnTextView = postItemVH.getViewBinding().g;
                Intrinsics.g(tnTextView, "tvTitle");
                tnTextView.setVisibility(title != null && title.length() > 0 ? 0 : 8);
                postItemVH.getViewBinding().g.setText(title);
                AppCompatImageView appCompatImageView = postItemVH.getViewBinding().e;
                Intrinsics.g(appCompatImageView, "ivVideoPlay");
                Media media = postSubjectItem.getMedia();
                String mediaType = media != null ? media.getMediaType() : null;
                MediaType mediaType2 = MediaType.VIDEO;
                appCompatImageView.setVisibility(Intrinsics.c(mediaType, mediaType2.getValue()) ? 0 : 8);
                Media media2 = postSubjectItem.getMedia();
                String mediaType3 = media2 != null ? media2.getMediaType() : null;
                if (Intrinsics.c(mediaType3, MediaType.IMAGE.getValue())) {
                    Media media3 = postSubjectItem.getMedia();
                    String url2 = (media3 == null || (image3 = media3.getImage()) == null || (image4 = (Image) CollectionsKt.k0(image3)) == null) ? null : image4.getUrl();
                    Media media4 = postSubjectItem.getMedia();
                    pair = new Pair(url2, (media4 == null || (image = media4.getImage()) == null || (image2 = (Image) CollectionsKt.k0(image)) == null) ? null : image2.getThumbnail());
                } else if (Intrinsics.c(mediaType3, mediaType2.getValue())) {
                    Media media5 = postSubjectItem.getMedia();
                    if (media5 == null || (cover2 = media5.getCover()) == null || (url = cover2.getUrl()) == null) {
                        Media media6 = postSubjectItem.getMedia();
                        url = (media6 == null || (firstFrame = media6.getFirstFrame()) == null) ? null : firstFrame.getUrl();
                    }
                    Media media7 = postSubjectItem.getMedia();
                    if (media7 == null || (cover = media7.getCover()) == null || (str = cover.getThumbnail()) == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    pair = new Pair(url, str);
                } else {
                    pair = null;
                }
                if (pair == null || (charSequence = (CharSequence) pair.getFirst()) == null || charSequence.length() == 0) {
                    ShapeableImageView shapeableImageView = postItemVH.getViewBinding().c;
                    Intrinsics.g(shapeableImageView, "ivCover");
                    uf.c.g(shapeableImageView);
                } else {
                    ShapeableImageView shapeableImageView2 = postItemVH.getViewBinding().c;
                    Intrinsics.g(shapeableImageView2, "ivCover");
                    uf.c.k(shapeableImageView2);
                    f.b m = ni.f.a.m(k());
                    Object first = pair.getFirst();
                    Intrinsics.e(first);
                    f.b g = m.g((String) first);
                    String str3 = (String) pair.getSecond();
                    if (str3 == null) {
                        str3 = BuildConfig.FLAVOR;
                    }
                    f.b l = g.l(str3);
                    ShapeableImageView shapeableImageView3 = postItemVH.getViewBinding().c;
                    Intrinsics.g(shapeableImageView3, "ivCover");
                    l.d(shapeableImageView3);
                }
                a aVar = RoomProvider.p;
                if (!aVar.a()) {
                    TnTextView tnTextView2 = postItemVH.getViewBinding().f;
                    Group group = postSubjectItem.getGroup();
                    tnTextView2.setText(group != null ? group.getName() : null);
                    f.b m2 = ni.f.a.m(k());
                    Group group2 = postSubjectItem.getGroup();
                    if (group2 != null && (avatar = group2.getAvatar()) != null) {
                        str2 = avatar;
                    }
                    f.b c = m2.g(str2).m(lj.a.b(24)).c(lj.a.b(24));
                    ShapeableImageView shapeableImageView4 = postItemVH.getViewBinding().d;
                    Intrinsics.g(shapeableImageView4, "ivRoomCover");
                    c.d(shapeableImageView4);
                    postItemVH.getViewBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.v
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RoomProvider.PostAdapter.PostItemProvider.C(postSubjectItem, view);
                        }
                    });
                }
                postItemVH.getViewBinding().b.setVisibility(aVar.a() ? 8 : 0);
                postItemVH.getViewBinding().getRoot().getLayoutParams().height = lj.a.b(aVar.a() ? 182 : 220);
            }

            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public PostItemVH r(ViewGroup viewGroup, int i) {
                Intrinsics.h(viewGroup, "parent");
                qk.d0 c = qk.d0.c(LayoutInflater.from(k()), viewGroup, false);
                Intrinsics.g(c, "inflate(...)");
                return new PostItemVH(c);
            }

            public int l() {
                return 1;
            }

            public int m() {
                return R.layout.item_adapter_room_entrance_post;
            }
        }

        public static final class a extends BaseItemProvider {
            private final String e;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a() {
                this(r0, 1, r0);
                String str = null;
            }

            public a(String str) {
                this.e = str;
            }

            public /* synthetic */ a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void A(a aVar, BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem, View view) {
                com.transsion.postdetail.helper.a.a.x(aVar.e, RoomProvider.s, BuildConfig.FLAVOR, baseViewHolder.getBindingAdapterPosition(), "item", postSubjectItem, (r17 & 64) != 0 ? null : null);
                qi.h.a.o(RoomProvider.s, MapsKt.m(new Pair[]{TuplesKt.a("page_from", aVar.e), TuplesKt.a("module_name", "item_post_more")}));
                ep.k.i(ep.k.a, null, null, RoomProvider.s, false, 11, null);
            }

            public int l() {
                return 2;
            }

            public int m() {
                return R.layout.item_adapter_room_entrance_post_more;
            }

            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public void b(final BaseViewHolder baseViewHolder, final PostSubjectItem postSubjectItem) {
                Intrinsics.h(baseViewHolder, "helper");
                Intrinsics.h(postSubjectItem, "item");
                ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomProvider.PostAdapter.a.A(RoomProvider.PostAdapter.a.this, baseViewHolder, postSubjectItem, view);
                    }
                });
                baseViewHolder.getView(R.id.root_view).getLayoutParams().height = lj.a.b(RoomProvider.p.a() ? 182 : 220);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostAdapter(String str, ep.l lVar) {
            super((List) null, 1, (DefaultConstructorMarker) null);
            Intrinsics.h(lVar, "trendingRoomsViewModel");
            F1(new PostItemProvider(str, lVar));
            F1(new a(str));
        }

        public /* synthetic */ PostAdapter(String str, ep.l lVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, lVar);
        }

        protected int N1(List<PostSubjectItem> data, int position) {
            Intrinsics.h(data, "data");
            return data.get(position).isMore() ? 2 : 1;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter$RoomItemVH;", "<init>", "()V", "Landroid/view/View;", "view", "item", BuildConfig.FLAVOR, "F1", "(Landroid/view/View;Lcom/transsion/moviedetailapi/bean/RoomItem;)V", "Landroid/view/ViewGroup;", "parent", BuildConfig.FLAVOR, "viewType", "E1", "(Landroid/view/ViewGroup;I)Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter$RoomItemVH;", "holder", "C1", "(Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter$RoomItemVH;Lcom/transsion/moviedetailapi/bean/RoomItem;)V", "F", "I", "coverSize", "RoomItemVH", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RoomAdapter extends BaseQuickAdapter {
        public static final int G = 8;

        /* renamed from: F, reason: from kotlin metadata */
        private final int coverSize;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter$RoomItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lqk/c0;", "viewBinding", "<init>", "(Lqk/c0;)V", "a", "Lqk/c0;", "f", "()Lqk/c0;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class RoomItemVH extends BaseViewHolder {

            /* renamed from: a, reason: from kotlin metadata */
            private final qk.c0 viewBinding;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public RoomItemVH(qk.c0 c0Var) {
                super(r0);
                Intrinsics.h(c0Var, "viewBinding");
                ConstraintLayout root = c0Var.getRoot();
                Intrinsics.g(root, "getRoot(...)");
                this.viewBinding = c0Var;
            }

            /* renamed from: f, reason: from getter */
            public final qk.c0 getViewBinding() {
                return this.viewBinding;
            }
        }

        public RoomAdapter() {
            super(R.layout.item_adapter_room_entrance_group, (List) null, 2, (DefaultConstructorMarker) null);
            this.coverSize = lj.a.b(52);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D1(RoomAdapter roomAdapter, RoomItem roomItem, View view) {
            Intrinsics.e(view);
            roomAdapter.F1(view, roomItem);
        }

        private final void F1(View view, RoomItem item) {
            item.setNewPostCount(0L);
            com.transsion.room.helper.l.a.g(RoomProvider.s, RoomProvider.t, item);
            Navigator.x(TheRouter.c("/room/detail").K("id", item.getGroupId()).z("need_start_room_home", false), view.getContext(), (mf.c) null, 2, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: C1, reason: merged with bridge method [inline-methods] */
        public void F(RoomItemVH holder, final RoomItem item) {
            String str;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomProvider.RoomAdapter.D1(RoomProvider.RoomAdapter.this, item, view);
                }
            });
            holder.getViewBinding().e.setText(item.getName());
            if (item.getUserCount() != null) {
                Long userCount = item.getUserCount();
                Intrinsics.e(userCount);
                str = ij.k.d(userCount.longValue());
            } else {
                str = "0";
            }
            holder.getViewBinding().d.setText(str);
            String avatar = item.getAvatar();
            if (avatar != null) {
                f.b c = ni.f.a.m(getContext()).g(avatar).m(this.coverSize).c(this.coverSize);
                ShapeableImageView shapeableImageView = holder.getViewBinding().c;
                Intrinsics.g(shapeableImageView, "ivCover");
                c.d(shapeableImageView);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: E1, reason: merged with bridge method [inline-methods] */
        public RoomItemVH y0(ViewGroup parent, int viewType) {
            Intrinsics.h(parent, "parent");
            qk.c0 c = qk.c0.c(LayoutInflater.from(getContext()), parent, false);
            Intrinsics.g(c, "inflate(...)");
            return new RoomItemVH(c);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            ConfigBean b = b();
            return Intrinsics.c(b != null ? b.getValue() : null, "true");
        }

        public final ConfigBean b() {
            return RoomProvider.u;
        }
    }

    public static final class b implements bj.a {
        final /* synthetic */ RoomAdapter a;
        final /* synthetic */ RoomProvider b;

        b(RoomAdapter roomAdapter, RoomProvider roomProvider) {
            this.a = roomAdapter;
            this.b = roomProvider;
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            RoomAdapter roomAdapter = this.a;
            RoomProvider roomProvider = this.b;
            try {
                Result.Companion companion = Result.Companion;
                a.a.r(wf.a.a, RoomProvider.r, new String[]{"1----------room report, position:" + i + ", duration:" + j}, false, 4, (Object) null);
                RoomItem roomItem = (RoomItem) roomAdapter.f0(i);
                if (roomItem != null) {
                    com.transsion.room.helper.l.a.i(roomProvider.j, RoomProvider.s, i, j, roomItem);
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    public static final class c implements bj.a {
        final /* synthetic */ PostAdapter a;
        final /* synthetic */ RoomProvider b;

        c(PostAdapter postAdapter, RoomProvider roomProvider) {
            this.a = postAdapter;
            this.b = roomProvider;
        }

        @Override // bj.a
        public void a(int i, long j, View view) {
            PostAdapter postAdapter = this.a;
            RoomProvider roomProvider = this.b;
            try {
                Result.Companion companion = Result.Companion;
                a.a.f(wf.a.a, RoomProvider.r, "2-------post report, position:" + i + ", duration:" + j, false, 4, (Object) null);
                PostSubjectItem postSubjectItem = (PostSubjectItem) postAdapter.f0(i);
                if (postSubjectItem != null && !CollectionsKt.b0(roomProvider.N(), postSubjectItem.getPostId())) {
                    String postId = postSubjectItem.getPostId();
                    if (postId != null) {
                        roomProvider.N().add(postId);
                    }
                    com.transsion.postdetail.helper.a.a.v(roomProvider.j, RoomProvider.s, BuildConfig.FLAVOR, i, j, postSubjectItem, (r19 & 64) != 0 ? null : null);
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
    }

    public static final class d implements qx.b {
        d() {
        }

        public void onLogin(UserInfo userInfo) {
            Intrinsics.h(userInfo, "user");
            TrendingViewModel trendingViewModel = RoomProvider.this.f;
            if (trendingViewModel != null) {
                trendingViewModel.T(false);
            }
        }

        public void onLogout() {
            TrendingViewModel trendingViewModel = RoomProvider.this.f;
            if (trendingViewModel != null) {
                trendingViewModel.T(false);
            }
        }

        public void onUpdateUserInfo(UserInfo userInfo) {
            b.a.c(this, userInfo);
        }
    }

    public static final class e extends RecyclerView.r {
        e() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i, i2);
        }
    }

    public static final class f extends RecyclerView.s {
        f() {
            m(0, 10);
        }
    }

    public static final class g extends RecyclerView.s {
        g() {
            m(0, 10);
        }
    }

    static final class h implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        h(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public RoomProvider(final BaseHomeSubFragment baseHomeSubFragment, TrendingViewModel trendingViewModel) {
        Intrinsics.h(baseHomeSubFragment, "fragment");
        this.e = baseHomeSubFragment;
        this.f = trendingViewModel;
        this.g = FragmentViewModelLazyKt.a(baseHomeSubFragment, Reflection.b(ep.l.class), new Function0<x0>() { // from class: com.transsion.home.adapter.trending.provider.RoomProvider$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m9invoke() {
                x0 viewModelStore = baseHomeSubFragment.requireActivity().getViewModelStore();
                Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.home.adapter.trending.provider.RoomProvider$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m10invoke() {
                v0.c defaultViewModelProviderFactory = baseHomeSubFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.j = qi.h.a.h();
        this.k = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.trending.provider.o
            public final Object invoke() {
                HashSet S;
                S = RoomProvider.S();
                return S;
            }
        });
        this.l = new e();
        this.m = new d();
        this.n = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.trending.provider.p
            public final Object invoke() {
                RoomProvider.g U;
                U = RoomProvider.U();
                return U;
            }
        });
        this.o = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.trending.provider.q
            public final Object invoke() {
                RoomProvider.f T;
                T = RoomProvider.T();
                return T;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(BaseViewHolder baseViewHolder, RecyclerView recyclerView, RoomAdapter roomAdapter, RecyclerView recyclerView2, PostAdapter postAdapter, RoomEntranceResponse roomEntranceResponse) {
        baseViewHolder.setText(R.id.main_operation_room_title, roomEntranceResponse.getTitle());
        List<RoomItem> groups = roomEntranceResponse.getGroups();
        if (groups == null || groups.isEmpty() || !p.a()) {
            recyclerView.setVisibility(8);
        } else {
            recyclerView.setVisibility(0);
            roomAdapter.n1(roomEntranceResponse.getGroups());
        }
        List<PostSubjectItem> posts = roomEntranceResponse.getPosts();
        if (posts == null || posts.isEmpty()) {
            recyclerView2.setVisibility(8);
        } else {
            recyclerView2.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            List<PostSubjectItem> posts2 = roomEntranceResponse.getPosts();
            Intrinsics.e(posts2);
            arrayList.addAll(posts2);
            PostSubjectItem postSubjectItem = new PostSubjectItem((String) null, (String) null, (Group) null, (Boolean) null, (Boolean) null, (Link) null, (Media) null, (String) null, (Stat) null, (Integer) null, (Subject) null, (Integer) null, (String) null, (String) null, (User) null, (String) null, (String) null, (Integer) null, (String) null, false, (Float) null, (Float) null, (String) null, (String) null, false, (List) null, false, (BiddingNativeManager) null, false, false, false, false, (CommentBean) null, -1, 1, (DefaultConstructorMarker) null);
            postSubjectItem.setMore(true);
            arrayList.add(postSubjectItem);
            postAdapter.n1(arrayList);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(View view) {
        com.transsion.room.helper.l lVar = com.transsion.room.helper.l.a;
        String str = s;
        lVar.f(str, t);
        ep.k.i(ep.k.a, null, null, str, false, 11, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet N() {
        return (HashSet) this.k.getValue();
    }

    private final f O() {
        return (f) this.o.getValue();
    }

    private final g P() {
        return (g) this.n.getValue();
    }

    private final ep.l Q() {
        return (ep.l) this.g.getValue();
    }

    private final void R(RecyclerView recyclerView, RecyclerView recyclerView2, RoomAdapter roomAdapter, PostAdapter postAdapter) {
        recyclerView.clearOnScrollListeners();
        recyclerView2.clearOnScrollListeners();
        bj.b bVar = new bj.b(0.6f, new b(roomAdapter, this), false, 4, null);
        bVar.n(1);
        ExposureType exposureType = ExposureType.NEST_HORIZONTAL;
        bVar.o(exposureType);
        recyclerView.addOnScrollListener(bVar);
        this.h = bVar;
        bj.b bVar2 = new bj.b(0.6f, new c(postAdapter, this), false, 4, null);
        bVar2.n(1);
        bVar2.o(exposureType);
        recyclerView2.addOnScrollListener(bVar2);
        this.i = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashSet S() {
        return new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f T() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g U() {
        return new g();
    }

    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder baseViewHolder, OperateItem operateItem) {
        androidx.lifecycle.b0 W;
        androidx.lifecycle.b0 W2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        final RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.main_operation_room_group_recycler);
        final RecyclerView recyclerView2 = (RecyclerView) baseViewHolder.getView(R.id.main_operation_room_post_recycler);
        ((TextView) baseViewHolder.getView(R.id.main_operation_room_more_text)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomProvider.M(view);
            }
        });
        String title = operateItem.getTitle();
        if (title != null && title.length() != 0) {
            ((TextView) baseViewHolder.getView(R.id.main_operation_room_title)).setText(operateItem.getTitle());
        }
        if (!Intrinsics.c(recyclerView.getRecycledViewPool(), P())) {
            recyclerView.setRecycledViewPool(P());
        }
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.e.getContext(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        final RoomAdapter roomAdapter = new RoomAdapter();
        recyclerView.setAdapter(roomAdapter);
        if (!Intrinsics.c(recyclerView2.getRecycledViewPool(), O())) {
            recyclerView2.setRecycledViewPool(O());
        }
        if (recyclerView2.getItemDecorationCount() == 0) {
            recyclerView2.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.e.getContext(), 0, false);
        linearLayoutManager2.setItemPrefetchEnabled(true);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        final PostAdapter postAdapter = new PostAdapter(this.j, Q());
        recyclerView2.setAdapter(postAdapter);
        R(recyclerView, recyclerView2, roomAdapter, postAdapter);
        TrendingViewModel trendingViewModel = this.f;
        if (trendingViewModel != null && (W2 = trendingViewModel.W()) != null) {
            W2.p(this.e);
        }
        TrendingViewModel trendingViewModel2 = this.f;
        if (trendingViewModel2 == null || (W = trendingViewModel2.W()) == null) {
            return;
        }
        W.j(this.e, new h(new Function1() { // from class: com.transsion.home.adapter.trending.provider.s
            public final Object invoke(Object obj) {
                Unit L;
                L = RoomProvider.L(baseViewHolder, recyclerView, roomAdapter, recyclerView2, postAdapter, (RoomEntranceResponse) obj);
                return L;
            }
        }));
    }

    public int l() {
        return PostItemType.ROOM.ordinal();
    }

    public int m() {
        return R.layout.post_list_item_room;
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        return super.r(viewGroup, i);
    }

    public void t(BaseViewHolder baseViewHolder) {
        Unit unit;
        RecyclerView recyclerView;
        Intrinsics.h(baseViewHolder, "holder");
        super.t(baseViewHolder);
        try {
            Result.Companion companion = Result.Companion;
            BaseProviderMultiAdapter g2 = g();
            if (g2 == null || (recyclerView = g2.getRecyclerView()) == null) {
                unit = null;
            } else {
                recyclerView.addOnScrollListener(this.l);
                unit = Unit.a;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public void u(BaseViewHolder baseViewHolder) {
        Unit unit;
        RecyclerView recyclerView;
        Intrinsics.h(baseViewHolder, "holder");
        super.u(baseViewHolder);
        a.a.v(wf.a.a, r, "room onViewDetachedFromWindow", false, 4, (Object) null);
        bj.b bVar = this.h;
        if (bVar != null) {
            bVar.f();
        }
        bj.b bVar2 = this.i;
        if (bVar2 != null) {
            bVar2.f();
        }
        try {
            Result.Companion companion = Result.Companion;
            BaseProviderMultiAdapter g2 = g();
            if (g2 == null || (recyclerView = g2.getRecyclerView()) == null) {
                unit = null;
            } else {
                recyclerView.removeOnScrollListener(this.l);
                unit = Unit.a;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }
}
