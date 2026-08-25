package com.transsion.moviedetail.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.c0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.flow.bean.MediaType;
import com.transsion.flow.bean.RoomEntranceResponse;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.adapter.i;
import com.transsion.moviedetail.fragment.ForYouFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class i extends BaseItemProvider {
    private final ForYouFragment e;
    private final String f;
    private final MovieDetailViewModel g;
    private final MovieDetailViewModel h;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/transsion/moviedetail/adapter/i$a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "pageName", "<init>", "(Ljava/lang/String;)V", "item", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "G1", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;I)V", "holder", "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "F", "Ljava/lang/String;", "G", "I", "coverSize", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension
    public static final class a extends BaseQuickAdapter {

        /* renamed from: F, reason: from kotlin metadata */
        private final String pageName;

        /* renamed from: G, reason: from kotlin metadata */
        private final int coverSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(R$layout.movie_detail_item_for_you_post_item, (List) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.h(str, "pageName");
            this.pageName = str;
            this.coverSize = lj.a.b(112);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void E1(PostSubjectItem postSubjectItem, BaseViewHolder baseViewHolder, a aVar, View view) {
            String str;
            String str2;
            String str3;
            String str4;
            String groupId;
            Integer subjectType;
            Group group = postSubjectItem.getGroup();
            Navigator.x(TheRouter.c("/room/detail").K("id", group != null ? group.getGroupId() : null).z("need_start_room_home", false), ((RecyclerView.a0) baseViewHolder).itemView.getContext(), (mf.c) null, 2, (Object) null);
            Pair a = TuplesKt.a("source", "for_you");
            Pair a2 = TuplesKt.a("module_name", "group");
            User user = postSubjectItem.getUser();
            String str5 = BuildConfig.FLAVOR;
            if (user == null || (str = user.getUserId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            Pair a3 = TuplesKt.a("user_id", str);
            String postId = postSubjectItem.getPostId();
            if (postId == null) {
                postId = BuildConfig.FLAVOR;
            }
            Pair a4 = TuplesKt.a("post_id", postId);
            Media media = postSubjectItem.getMedia();
            if (media == null || (str2 = media.getMediaType()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            Pair a5 = TuplesKt.a("post_media_type", str2);
            Subject subject = postSubjectItem.getSubject();
            if (subject == null || (str3 = subject.getSubjectId()) == null) {
                str3 = BuildConfig.FLAVOR;
            }
            Pair a6 = TuplesKt.a("subject_id", str3);
            Subject subject2 = postSubjectItem.getSubject();
            if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str4 = subjectType.toString()) == null) {
                str4 = BuildConfig.FLAVOR;
            }
            Pair a7 = TuplesKt.a("subject_type", str4);
            Pair a8 = TuplesKt.a("is_cache_post", String.valueOf(postSubjectItem.isRoomCache()));
            Group group2 = postSubjectItem.getGroup();
            if (group2 != null && (groupId = group2.getGroupId()) != null) {
                str5 = groupId;
            }
            qi.h.a.o(aVar.pageName, MapsKt.m(new Pair[]{a, a2, a3, a4, a5, a6, a7, a8, TuplesKt.a("group_id", str5), TuplesKt.a("ops", postSubjectItem.getOps())}));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void F1(a aVar, PostSubjectItem postSubjectItem, BaseViewHolder baseViewHolder, View view) {
            aVar.G1(postSubjectItem, baseViewHolder.getBindingAdapterPosition());
        }

        private final void G1(PostSubjectItem item, int position) {
            String str;
            String str2;
            String str3;
            String value;
            Integer subjectType;
            String num;
            String postId = item.getPostId();
            if (postId == null) {
                return;
            }
            String postId2 = item.getPostId();
            String str4 = BuildConfig.FLAVOR;
            if (postId2 == null) {
                postId2 = BuildConfig.FLAVOR;
            }
            Pair a = TuplesKt.a("post_id", postId2);
            Pair a2 = TuplesKt.a("position", String.valueOf(position));
            Pair a3 = TuplesKt.a("source", "for_you");
            Pair a4 = TuplesKt.a("module_name", "item");
            Pair a5 = TuplesKt.a("is_cache_post", String.valueOf(item.isRoomCache()));
            User user = item.getUser();
            if (user == null || (str = user.getUserId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            Pair a6 = TuplesKt.a("user_id", str);
            Group group = item.getGroup();
            if (group == null || (str2 = group.getGroupId()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            Pair a7 = TuplesKt.a("group_id", str2);
            Subject subject = item.getSubject();
            if (subject == null || (str3 = subject.getSubjectId()) == null) {
                str3 = BuildConfig.FLAVOR;
            }
            Pair a8 = TuplesKt.a("subject_id", str3);
            Subject subject2 = item.getSubject();
            if (subject2 != null && (subjectType = subject2.getSubjectType()) != null && (num = subjectType.toString()) != null) {
                str4 = num;
            }
            Pair a9 = TuplesKt.a("subject_type", str4);
            Media media = item.getMedia();
            if (media == null || (value = media.getMediaType()) == null) {
                value = MediaType.TEXT.getValue();
            }
            qi.h.a.o(this.pageName, MapsKt.m(new Pair[]{a, a2, a3, a4, a5, a6, a7, a8, a9, TuplesKt.a("post_media_type", value), TuplesKt.a("ops", item.getOps())}));
            ep.k.a.h(postId, item.getOps(), this.pageName, true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: D1, reason: merged with bridge method [inline-methods] */
        public void F(final BaseViewHolder holder, final PostSubjectItem item) {
            Pair pair;
            String url;
            FirstFrame firstFrame;
            String str;
            Cover cover;
            Cover cover2;
            String avatar;
            List image;
            Image image2;
            List image3;
            Image image4;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            Media media = item.getMedia();
            String mediaType = media != null ? media.getMediaType() : null;
            boolean c = Intrinsics.c(mediaType, MediaType.IMAGE.getValue());
            String str2 = BuildConfig.FLAVOR;
            if (c) {
                Media media2 = item.getMedia();
                String url2 = (media2 == null || (image3 = media2.getImage()) == null || (image4 = (Image) CollectionsKt.k0(image3)) == null) ? null : image4.getUrl();
                Media media3 = item.getMedia();
                pair = new Pair(url2, (media3 == null || (image = media3.getImage()) == null || (image2 = (Image) CollectionsKt.k0(image)) == null) ? null : image2.getThumbnail());
            } else if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
                Media media4 = item.getMedia();
                if (media4 == null || (cover2 = media4.getCover()) == null || (url = cover2.getUrl()) == null) {
                    Media media5 = item.getMedia();
                    url = (media5 == null || (firstFrame = media5.getFirstFrame()) == null) ? null : firstFrame.getUrl();
                }
                Media media6 = item.getMedia();
                if (media6 == null || (cover = media6.getCover()) == null || (str = cover.getThumbnail()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                pair = new Pair(url, str);
            } else {
                pair = null;
            }
            if (pair != null) {
                f.b m = ni.f.a.m(getContext());
                String str3 = (String) pair.getFirst();
                if (str3 == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                f.b c2 = m.g(str3).m(this.coverSize).c(this.coverSize);
                String str4 = (String) pair.getSecond();
                if (str4 == null) {
                    str4 = BuildConfig.FLAVOR;
                }
                c2.l(str4).d((ImageView) holder.getView(R$id.ivCover));
            }
            View view = holder.getView(R$id.ivVideoPlay);
            Media media7 = item.getMedia();
            view.setVisibility(Intrinsics.c(media7 != null ? media7.getMediaType() : null, MediaType.VIDEO.getValue()) ? 0 : 8);
            TextView textView = (TextView) holder.getView(R$id.tvRoomTitle);
            Group group = item.getGroup();
            textView.setText(group != null ? group.getName() : null);
            f.b m2 = ni.f.a.m(getContext());
            Group group2 = item.getGroup();
            if (group2 != null && (avatar = group2.getAvatar()) != null) {
                str2 = avatar;
            }
            m2.g(str2).m(lj.a.b(24)).c(lj.a.b(24)).d((ImageView) holder.getView(R$id.ivRoomCover));
            holder.getView(R$id.vRoomInfo).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.adapter.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i.a.E1(item, holder, this, view2);
                }
            });
            ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.adapter.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    i.a.F1(i.a.this, item, holder, view2);
                }
            });
        }
    }

    static final class b implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
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

    public i(ForYouFragment forYouFragment, String str, MovieDetailViewModel movieDetailViewModel) {
        Intrinsics.h(forYouFragment, "fragment");
        Intrinsics.h(str, "pageName");
        Intrinsics.h(movieDetailViewModel, "movieDetailViewModel");
        this.e = forYouFragment;
        this.f = str;
        this.g = movieDetailViewModel;
        this.h = movieDetailViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(BaseViewHolder baseViewHolder, a aVar, i iVar, RoomEntranceResponse roomEntranceResponse) {
        List<PostSubjectItem> posts;
        a.a.f(wf.a.a, "MovieDetailViewModel", "ForYouFragment 推荐帖子-开始渲染", false, 4, (Object) null);
        baseViewHolder.setText(R$id.tvTitle, roomEntranceResponse != null ? roomEntranceResponse.getTitle() : null);
        List<PostSubjectItem> posts2 = roomEntranceResponse != null ? roomEntranceResponse.getPosts() : null;
        if (posts2 != null && !posts2.isEmpty()) {
            aVar.n1(roomEntranceResponse != null ? roomEntranceResponse.getPosts() : null);
            if (roomEntranceResponse != null && (posts = roomEntranceResponse.getPosts()) != null) {
                int i = 0;
                for (Object obj : posts) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.u();
                    }
                    PostSubjectItem postSubjectItem = (PostSubjectItem) obj;
                    Pair a2 = TuplesKt.a("source", "for_you");
                    String postId = postSubjectItem.getPostId();
                    if (postId == null) {
                        postId = BuildConfig.FLAVOR;
                    }
                    qi.h.a.z(iVar.f, MapsKt.m(new Pair[]{a2, TuplesKt.a("post_id", postId), TuplesKt.a("position", String.valueOf(i)), TuplesKt.a("module_name", "item"), TuplesKt.a("ops", postSubjectItem.getOps())}));
                    i = i2;
                }
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(i iVar, View view) {
        qi.h.a.o(iVar.f, MapsKt.m(new Pair[]{TuplesKt.a("source", "for_you"), TuplesKt.a("module_name", "explore")}));
        ep.k.i(ep.k.a, null, null, iVar.f, true, 3, null);
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder baseViewHolder, Subject subject) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(subject, "item");
        a.a.f(wf.a.a, "MovieDetailViewModel", "ForYouFragment 推荐帖子 item convert ", false, 4, (Object) null);
        StaggeredGridLayoutManager.b layoutParams = ((RecyclerView.a0) baseViewHolder).itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.b) {
            layoutParams.c(true);
        }
        final a aVar = new a(this.f);
        RecyclerView view = baseViewHolder.getView(R$id.recyclerView);
        view.addItemDecoration(new tf.a(lj.a.b(6), 0, 0, 0));
        view.setLayoutManager(new NpaGridLayoutManager(view.getContext(), 3));
        view.setAdapter(aVar);
        this.h.I().j(this.e, new b(new Function1() { // from class: com.transsion.moviedetail.adapter.e
            public final Object invoke(Object obj) {
                Unit B;
                B = i.B(baseViewHolder, aVar, this, (RoomEntranceResponse) obj);
                return B;
            }
        }));
        ((TextView) baseViewHolder.getView(R$id.tvMore)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.C(i.this, view2);
            }
        });
    }

    public int l() {
        return c.I;
    }

    public int m() {
        return R$layout.movie_detail_item_for_you_recommend_posts;
    }
}
