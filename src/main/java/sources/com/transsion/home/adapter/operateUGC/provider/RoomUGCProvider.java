package com.transsion.home.adapter.operateUGC.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.flow.bean.MediaType;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.operateUGC.provider.RoomUGCProvider;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.viewmodel.TrendingUGCViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.push.bean.MsgStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomUGCProvider extends BaseItemProvider {
    public static final a h = new a(null);
    public static final int i = 8;
    private final int e;
    private final BaseHomeSubFragment f;
    private final TrendingUGCViewModel g;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/provider/RoomUGCProvider$PostAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", BuildConfig.FLAVOR, "tabId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "<init>", "(ILcom/transsion/home/bean/OperateItem;)V", BuildConfig.FLAVOR, "data", "position", "N1", "(Ljava/util/List;I)I", "G", "I", "PostItemProvider", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PostAdapter extends BaseProviderMultiAdapter<PostSubjectItem> {
        public static final int H = 8;

        /* renamed from: G, reason: from kotlin metadata */
        private final int tabId;

        public static final class PostItemProvider extends BaseItemProvider {
            private final int e;
            private final OperateItem f;
            private final int g;
            private final int h;

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/provider/RoomUGCProvider$PostAdapter$PostItemProvider$PostItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lqk/f0;", "viewBinding", "<init>", "(Lqk/f0;)V", "a", "Lqk/f0;", "f", "()Lqk/f0;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class PostItemVH extends BaseViewHolder {

                /* renamed from: a, reason: from kotlin metadata */
                private final qk.f0 viewBinding;

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public PostItemVH(qk.f0 f0Var) {
                    super(r0);
                    Intrinsics.h(f0Var, "viewBinding");
                    BLConstraintLayout root = f0Var.getRoot();
                    Intrinsics.g(root, "getRoot(...)");
                    this.viewBinding = f0Var;
                }

                /* renamed from: f, reason: from getter */
                public final qk.f0 getViewBinding() {
                    return this.viewBinding;
                }
            }

            public PostItemProvider(int i, OperateItem operateItem) {
                this.e = i;
                this.f = operateItem;
                int e = (com.blankj.utilcode.util.y.e() - lj.a.b(40)) / 3;
                this.g = e;
                this.h = (e * 150) / 107;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void A(PostItemProvider postItemProvider, PostSubjectItem postSubjectItem, PostItemVH postItemVH, View view) {
                postItemProvider.C(postSubjectItem, postItemVH.getAdapterPosition());
            }

            private final void C(PostSubjectItem postSubjectItem, int i) {
                D(i, this.f, postSubjectItem);
                ep.k.k(ep.k.a, postSubjectItem, postSubjectItem.getOps(), "UgcTrending", false, 8, null);
            }

            private final void D(int i, OperateItem operateItem, PostSubjectItem postSubjectItem) {
                String str;
                String str2;
                String str3;
                String str4;
                String value;
                String ops;
                Integer subjectType;
                String postId = postSubjectItem.getPostId();
                String str5 = BuildConfig.FLAVOR;
                if (postId == null) {
                    postId = BuildConfig.FLAVOR;
                }
                Pair a = TuplesKt.a("post_id", postId);
                Pair a2 = TuplesKt.a("position", String.valueOf(i));
                Pair a3 = TuplesKt.a("module_name", "item");
                Pair a4 = TuplesKt.a("is_cache_post", String.valueOf(postSubjectItem.isRoomCache()));
                User user = postSubjectItem.getUser();
                if (user == null || (str = user.getUserId()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                Pair a5 = TuplesKt.a("user_id", str);
                Group group = postSubjectItem.getGroup();
                if (group == null || (str2 = group.getGroupId()) == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                Pair a6 = TuplesKt.a("group_id", str2);
                Subject subject = postSubjectItem.getSubject();
                if (subject == null || (str3 = subject.getSubjectId()) == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                Pair a7 = TuplesKt.a("subject_id", str3);
                Subject subject2 = postSubjectItem.getSubject();
                if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str4 = subjectType.toString()) == null) {
                    str4 = BuildConfig.FLAVOR;
                }
                Pair a8 = TuplesKt.a("subject_type", str4);
                Pair a9 = TuplesKt.a("builtin", postSubjectItem.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
                Media media = postSubjectItem.getMedia();
                if (media == null || (value = media.getMediaType()) == null) {
                    value = MediaType.TEXT.getValue();
                }
                Pair a10 = TuplesKt.a("post_media_type", value);
                Pair a11 = TuplesKt.a("tabId", String.valueOf(this.e));
                if (operateItem == null || (ops = operateItem.getOps()) == null) {
                    String ops2 = postSubjectItem.getOps();
                    if (ops2 != null) {
                        str5 = ops2;
                    }
                } else {
                    str5 = ops;
                }
                Map m = MapsKt.m(new Pair[]{a, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, TuplesKt.a("ops", str5)});
                if (operateItem != null) {
                    sk.b.a(operateItem, m);
                }
                qi.h.a.o("UgcTrending", m);
            }

            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public PostItemVH r(ViewGroup viewGroup, int i) {
                Intrinsics.h(viewGroup, "parent");
                qk.f0 c = qk.f0.c(LayoutInflater.from(k()), viewGroup, false);
                Intrinsics.g(c, "inflate(...)");
                ShapeableImageView shapeableImageView = c.b;
                Intrinsics.g(shapeableImageView, "ivCover");
                ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams.height = this.h;
                shapeableImageView.setLayoutParams(layoutParams);
                return new PostItemVH(c);
            }

            public int l() {
                return 1;
            }

            public int m() {
                return R.layout.item_ugc_vertical_content;
            }

            /* JADX WARN: Removed duplicated region for block: B:38:0x0119  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x014b  */
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void b(BaseViewHolder baseViewHolder, final PostSubjectItem postSubjectItem) {
                String title;
                String pair;
                FirstFrame firstFrame;
                String str;
                Cover cover;
                Cover cover2;
                String url;
                List video;
                Video video2;
                Integer duration;
                String str2;
                List image;
                Image image2;
                List image3;
                Image image4;
                Intrinsics.h(baseViewHolder, "helper");
                Intrinsics.h(postSubjectItem, "item");
                final PostItemVH postItemVH = (PostItemVH) baseViewHolder;
                ((RecyclerView.a0) postItemVH).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.b0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomUGCProvider.PostAdapter.PostItemProvider.A(RoomUGCProvider.PostAdapter.PostItemProvider.this, postSubjectItem, postItemVH, view);
                    }
                });
                String content = postSubjectItem.getContent();
                String str3 = BuildConfig.FLAVOR;
                if (content == null || content.length() == 0) {
                    title = postSubjectItem.getTitle();
                    if (title == null) {
                        title = BuildConfig.FLAVOR;
                    }
                } else {
                    title = postSubjectItem.getContent();
                }
                postItemVH.getViewBinding().e.setText(title);
                Media media = postSubjectItem.getMedia();
                String str4 = null;
                String mediaType = media != null ? media.getMediaType() : null;
                if (!Intrinsics.c(mediaType, MediaType.IMAGE.getValue())) {
                    if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
                        Media media2 = postSubjectItem.getMedia();
                        if (media2 == null || (cover2 = media2.getCover()) == null || (url = cover2.getUrl()) == null) {
                            Media media3 = postSubjectItem.getMedia();
                            if (media3 != null && (firstFrame = media3.getFirstFrame()) != null) {
                                str4 = firstFrame.getUrl();
                            }
                        } else {
                            str4 = url;
                        }
                        Media media4 = postSubjectItem.getMedia();
                        if (media4 == null || (cover = media4.getCover()) == null || (str = cover.getThumbnail()) == null) {
                            str = BuildConfig.FLAVOR;
                        }
                        pair = new Pair(str4, str);
                    }
                    f.b m = ni.f.a.m(k());
                    if (str4 != null || (r3 = (String) str4.getFirst()) == null) {
                        String str5 = BuildConfig.FLAVOR;
                    }
                    f.b m2 = m.g(str5).m(this.g);
                    if (str4 != null && (str2 = (String) str4.getSecond()) != null) {
                        str3 = str2;
                    }
                    f.b l = m2.l(str3);
                    ShapeableImageView shapeableImageView = postItemVH.getViewBinding().b;
                    Intrinsics.g(shapeableImageView, "ivCover");
                    l.d(shapeableImageView);
                    if (postSubjectItem.isVideo()) {
                        postItemVH.getViewBinding().d.setText(Utils.a().getString(R.string.pic));
                        return;
                    } else {
                        Media media5 = postSubjectItem.getMedia();
                        postItemVH.getViewBinding().d.setText(TimeUtilKt.a(Integer.valueOf((media5 == null || (video = media5.getVideo()) == null || (video2 = (Video) CollectionsKt.k0(video)) == null || (duration = video2.getDuration()) == null) ? 0 : duration.intValue())));
                        return;
                    }
                }
                Media media6 = postSubjectItem.getMedia();
                String url2 = (media6 == null || (image3 = media6.getImage()) == null || (image4 = (Image) CollectionsKt.k0(image3)) == null) ? null : image4.getUrl();
                Media media7 = postSubjectItem.getMedia();
                if (media7 != null && (image = media7.getImage()) != null && (image2 = (Image) CollectionsKt.k0(image)) != null) {
                    str4 = image2.getThumbnail();
                }
                pair = new Pair(url2, str4);
                str4 = pair;
                f.b m3 = ni.f.a.m(k());
                if (str4 != null) {
                }
                String str52 = BuildConfig.FLAVOR;
                f.b m22 = m3.g(str52).m(this.g);
                if (str4 != null) {
                    str3 = str2;
                }
                f.b l2 = m22.l(str3);
                ShapeableImageView shapeableImageView2 = postItemVH.getViewBinding().b;
                Intrinsics.g(shapeableImageView2, "ivCover");
                l2.d(shapeableImageView2);
                if (postSubjectItem.isVideo()) {
                }
            }
        }

        public PostAdapter(int i, OperateItem operateItem) {
            super((List) null, 1, (DefaultConstructorMarker) null);
            this.tabId = i;
            F1(new PostItemProvider(i, operateItem));
        }

        protected int N1(List<PostSubjectItem> data, int position) {
            Intrinsics.h(data, "data");
            return data.get(position).isMore() ? 2 : 1;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
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

    public RoomUGCProvider(int i2, BaseHomeSubFragment baseHomeSubFragment, TrendingUGCViewModel trendingUGCViewModel) {
        Intrinsics.h(baseHomeSubFragment, "fragment");
        this.e = i2;
        this.f = baseHomeSubFragment;
        this.g = trendingUGCViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(RoomUGCProvider roomUGCProvider, OperateItem operateItem) {
        roomUGCProvider.I(operateItem);
        ep.k.i(ep.k.a, null, null, "UgcTrending", false, 11, null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(OperateItem operateItem, BaseViewHolder baseViewHolder, PostAdapter postAdapter, RoomUGCProvider roomUGCProvider, RoomEntranceResponse roomEntranceResponse) {
        operateItem.setTitle(roomEntranceResponse.getTitle());
        baseViewHolder.setText(R.id.tvProviderVerticalTitle, roomEntranceResponse.getTitle());
        List<PostSubjectItem> posts = roomEntranceResponse.getPosts();
        if (posts == null || posts.isEmpty()) {
            View view = ((RecyclerView.a0) baseViewHolder).itemView;
            Intrinsics.g(view, "itemView");
            uf.c.g(view);
        } else {
            View view2 = ((RecyclerView.a0) baseViewHolder).itemView;
            Intrinsics.g(view2, "itemView");
            uf.c.k(view2);
            ArrayList arrayList = new ArrayList();
            List<PostSubjectItem> posts2 = roomEntranceResponse.getPosts();
            Intrinsics.e(posts2);
            arrayList.addAll(posts2);
            postAdapter.n1(arrayList);
            int i2 = 0;
            for (Object obj : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                roomUGCProvider.J(i2, operateItem, (PostSubjectItem) obj);
                i2 = i3;
            }
        }
        return Unit.a;
    }

    private final void H(OperateItem operateItem) {
        List data;
        Pair a2 = TuplesKt.a("module_name", "all");
        BaseProviderMultiAdapter g = g();
        Pair a3 = TuplesKt.a("position", String.valueOf((g == null || (data = g.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        Pair a4 = TuplesKt.a("tabId", String.valueOf(this.e));
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        Map m = MapsKt.m(new Pair[]{a2, a3, a4, TuplesKt.a("title", title)});
        sk.b.a(operateItem, m);
        qi.h.a.z("UgcTrending", m);
    }

    private final void I(OperateItem operateItem) {
        List data;
        Pair a2 = TuplesKt.a("module_name", "all");
        BaseProviderMultiAdapter g = g();
        Pair a3 = TuplesKt.a("position", String.valueOf((g == null || (data = g.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        Pair a4 = TuplesKt.a("tabId", String.valueOf(this.e));
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        Map m = MapsKt.m(new Pair[]{a2, a3, a4, TuplesKt.a("title", title)});
        sk.b.a(operateItem, m);
        qi.h.a.o("UgcTrending", m);
    }

    private final void J(int i2, OperateItem operateItem, PostSubjectItem postSubjectItem) {
        String str;
        String str2;
        String str3;
        String str4;
        String value;
        String ops;
        Integer subjectType;
        String postId = postSubjectItem.getPostId();
        String str5 = BuildConfig.FLAVOR;
        if (postId == null) {
            postId = BuildConfig.FLAVOR;
        }
        Pair a2 = TuplesKt.a("post_id", postId);
        Pair a3 = TuplesKt.a("position", String.valueOf(i2));
        Pair a4 = TuplesKt.a("module_name", "item");
        Pair a5 = TuplesKt.a("is_cache_post", String.valueOf(postSubjectItem.isRoomCache()));
        User user = postSubjectItem.getUser();
        if (user == null || (str = user.getUserId()) == null) {
            str = BuildConfig.FLAVOR;
        }
        Pair a6 = TuplesKt.a("user_id", str);
        Group group = postSubjectItem.getGroup();
        if (group == null || (str2 = group.getGroupId()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        Pair a7 = TuplesKt.a("group_id", str2);
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str3 = subject.getSubjectId()) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        Pair a8 = TuplesKt.a("subject_id", str3);
        Subject subject2 = postSubjectItem.getSubject();
        if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str4 = subjectType.toString()) == null) {
            str4 = BuildConfig.FLAVOR;
        }
        Pair a9 = TuplesKt.a("subject_type", str4);
        Pair a10 = TuplesKt.a("builtin", postSubjectItem.getBuiltIn() ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        Pair a11 = TuplesKt.a("post_media_type", value);
        Pair a12 = TuplesKt.a("tabId", String.valueOf(this.e));
        if (operateItem == null || (ops = operateItem.getOps()) == null) {
            String ops2 = postSubjectItem.getOps();
            if (ops2 != null) {
                str5 = ops2;
            }
        } else {
            str5 = ops;
        }
        Map m = MapsKt.m(new Pair[]{a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, TuplesKt.a("ops", str5)});
        if (operateItem != null) {
            sk.b.a(operateItem, m);
        }
        qi.h.a.z("UgcTrending", m);
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        androidx.lifecycle.b0 B;
        androidx.lifecycle.b0 B2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        final Function0 function0 = new Function0() { // from class: com.transsion.home.adapter.operateUGC.provider.x
            public final Object invoke() {
                Unit D;
                D = RoomUGCProvider.D(RoomUGCProvider.this, operateItem);
                return D;
            }
        };
        ((TextView) baseViewHolder.getView(R.id.tvProviderVerticalTitle)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomUGCProvider.E(function0, view);
            }
        });
        ((TextView) baseViewHolder.getView(R.id.tvProviderVerticalMore)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomUGCProvider.F(function0, view);
            }
        });
        H(operateItem);
        String title = operateItem.getTitle();
        if (title != null && title.length() != 0) {
            ((TextView) baseViewHolder.getView(R.id.tvProviderVerticalTitle)).setText(operateItem.getTitle());
        }
        final PostAdapter postAdapter = new PostAdapter(this.e, operateItem);
        RecyclerView view = baseViewHolder.getView(R.id.rvProviderVerticalPost);
        view.setLayoutManager(new NpaGridLayoutManager(view.getContext(), 3));
        if (view.getItemDecorationCount() == 0) {
            view.addItemDecoration(new tf.a(lj.a.b(8), 0, 0, 0));
        }
        view.setAdapter(postAdapter);
        TrendingUGCViewModel trendingUGCViewModel = this.g;
        if (trendingUGCViewModel != null && (B2 = trendingUGCViewModel.B()) != null) {
            B2.p(this.f);
        }
        TrendingUGCViewModel trendingUGCViewModel2 = this.g;
        if (trendingUGCViewModel2 == null || (B = trendingUGCViewModel2.B()) == null) {
            return;
        }
        B.j(this.f, new b(new Function1() { // from class: com.transsion.home.adapter.operateUGC.provider.a0
            public final Object invoke(Object obj) {
                Unit G;
                G = RoomUGCProvider.G(OperateItem.this, baseViewHolder, postAdapter, this, (RoomEntranceResponse) obj);
                return G;
            }
        }));
    }

    public int l() {
        return PostItemType.ROOM.ordinal();
    }

    public int m() {
        return R.layout.provider_ugc_vertical_content;
    }
}
