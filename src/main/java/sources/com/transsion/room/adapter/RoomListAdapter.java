package com.transsion.room.adapter;

import ah.c;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.RoomJoinStatus;
import com.tn.lib.widget.R;
import com.transsion.flow.bean.MediaType;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.room.R$layout;
import com.transsion.room.R$string;
import fp.y;
import ij.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;
import t6.h;
import t6.i;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00010B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b#\u0010\u000fJ-\u0010'\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00022\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0014¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/transsion/room/adapter/RoomListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "Lcom/transsion/room/adapter/RoomListAdapter$RoomListItemVH;", "Lt6/i;", "Lcom/transsion/room/adapter/RoomListFrom;", "roomListFrom", BuildConfig.FLAVOR, "isSelectRoom", "<init>", "(Lcom/transsion/room/adapter/RoomListFrom;Z)V", "holder", "item", BuildConfig.FLAVOR, "J1", "(Lcom/transsion/room/adapter/RoomListAdapter$RoomListItemVH;Lcom/transsion/moviedetailapi/bean/RoomItem;)V", "F1", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "latestPosts", "H1", "(Lcom/transsion/room/adapter/RoomListAdapter$RoomListItemVH;Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "I1", "hasJoin", "E1", "(Lcom/transsion/room/adapter/RoomListAdapter$RoomListItemVH;Z)V", BuildConfig.FLAVOR, "newCount", "G1", "(Lcom/transsion/room/adapter/RoomListAdapter$RoomListItemVH;J)V", "Landroid/view/ViewGroup;", "parent", BuildConfig.FLAVOR, "viewType", "D1", "(Landroid/view/ViewGroup;I)Lcom/transsion/room/adapter/RoomListAdapter$RoomListItemVH;", "B1", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "payloads", "C1", "(Lcom/transsion/room/adapter/RoomListAdapter$RoomListItemVH;Lcom/transsion/moviedetailapi/bean/RoomItem;Ljava/util/List;)V", "F", "Lcom/transsion/room/adapter/RoomListFrom;", "G", "Z", "H", "I", "coverSize", "RoomListItemVH", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RoomListAdapter extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private final RoomListFrom roomListFrom;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isSelectRoom;

    /* renamed from: H, reason: from kotlin metadata */
    private final int coverSize;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/room/adapter/RoomListAdapter$RoomListItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lfp/y;", "viewBinding", "<init>", "(Lfp/y;)V", "a", "Lfp/y;", "f", "()Lfp/y;", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RoomListItemVH extends BaseViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final y viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public RoomListItemVH(y yVar) {
            super(r0);
            Intrinsics.h(yVar, "viewBinding");
            ConstraintLayout root = yVar.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            this.viewBinding = yVar;
        }

        /* renamed from: f, reason: from getter */
        public final y getViewBinding() {
            return this.viewBinding;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoomListFrom.values().length];
            try {
                iArr[RoomListFrom.MY_ROOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomListFrom.ROOM_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomListAdapter(RoomListFrom roomListFrom, boolean z) {
        super(R$layout.item_room_list, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(roomListFrom, "roomListFrom");
        this.roomListFrom = roomListFrom;
        this.isSelectRoom = z;
        this.coverSize = a0.a(52.0f);
    }

    private final void E1(RoomListItemVH holder, boolean hasJoin) {
        holder.getViewBinding().l.setStatus(hasJoin ? RoomJoinStatus.JOINED : RoomJoinStatus.JOIN);
    }

    private final void F1(RoomListItemVH holder, RoomItem item) {
        List<PostSubjectItem> latestPosts = item.getLatestPosts();
        PostSubjectItem postSubjectItem = latestPosts != null ? (PostSubjectItem) CollectionsKt.k0(latestPosts) : null;
        if (postSubjectItem == null) {
            Group group = holder.getViewBinding().c;
            Intrinsics.g(group, "groupNewPost");
            uf.c.g(group);
            return;
        }
        Group group2 = holder.getViewBinding().c;
        Intrinsics.g(group2, "groupNewPost");
        uf.c.k(group2);
        String content = postSubjectItem.getContent();
        String title = (content == null || content.length() == 0) ? postSubjectItem.getTitle() : postSubjectItem.getContent();
        AppCompatTextView appCompatTextView = holder.getViewBinding().i;
        if (title == null || title.length() == 0) {
            title = Utils.a().getString(R$string.New_post);
        }
        appCompatTextView.setText(title);
        Media media = postSubjectItem.getMedia();
        String mediaType = media != null ? media.getMediaType() : null;
        if (Intrinsics.c(mediaType, MediaType.VIDEO.getValue())) {
            I1(holder, postSubjectItem);
            return;
        }
        if (Intrinsics.c(mediaType, MediaType.IMAGE.getValue())) {
            H1(holder, postSubjectItem);
            return;
        }
        FrameLayout root = holder.getViewBinding().f.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        uf.c.g(root);
        FrameLayout root2 = holder.getViewBinding().e.getRoot();
        Intrinsics.g(root2, "getRoot(...)");
        uf.c.g(root2);
    }

    private final void G1(RoomListItemVH holder, long newCount) {
        BLTextView bLTextView = holder.getViewBinding().h;
        Intrinsics.g(bLTextView, "tvNewCount");
        bLTextView.setVisibility((newCount > 0L ? 1 : (newCount == 0L ? 0 : -1)) > 0 ? 0 : 8);
        holder.getViewBinding().h.setText(Utils.a().getString(R$string.x_new, newCount > 99 ? "99+" : String.valueOf(newCount)));
    }

    private final void H1(RoomListItemVH holder, PostSubjectItem latestPosts) {
        List image;
        List image2;
        Media media = latestPosts.getMedia();
        int i = 0;
        List list = null;
        if (((media == null || (image2 = media.getImage()) == null) ? 0 : image2.size()) > 2) {
            Media media2 = latestPosts.getMedia();
            if (media2 != null && (image = media2.getImage()) != null) {
                list = image.subList(0, 2);
            }
        } else {
            Media media3 = latestPosts.getMedia();
            if (media3 != null) {
                list = media3.getImage();
            }
        }
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            FrameLayout root = holder.getViewBinding().e.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            uf.c.g(root);
            return;
        }
        FrameLayout root2 = holder.getViewBinding().e.getRoot();
        Intrinsics.g(root2, "getRoot(...)");
        uf.c.k(root2);
        ShapeableImageView shapeableImageView = holder.getViewBinding().e.c;
        Intrinsics.g(shapeableImageView, "ivPostCover2");
        shapeableImageView.setVisibility(list.size() > 1 ? 0 : 8);
        BLView bLView = holder.getViewBinding().e.d;
        Intrinsics.g(bLView, "vPostBg");
        bLView.setVisibility(list.size() > 1 ? 0 : 8);
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            Image image3 = (Image) obj;
            ShapeableImageView shapeableImageView2 = i == 0 ? holder.getViewBinding().e.b : holder.getViewBinding().e.c;
            Intrinsics.e(shapeableImageView2);
            String url = image3.getUrl();
            if (url != null) {
                f.a.m(getContext()).g(url).m(this.coverSize).c(this.coverSize).d(shapeableImageView2);
            }
            i = i2;
        }
    }

    private final void I1(RoomListItemVH holder, PostSubjectItem latestPosts) {
        String url;
        FirstFrame firstFrame;
        Cover cover;
        Media media = latestPosts.getMedia();
        if (media == null || (cover = media.getCover()) == null || (url = cover.getUrl()) == null) {
            Media media2 = latestPosts.getMedia();
            url = (media2 == null || (firstFrame = media2.getFirstFrame()) == null) ? null : firstFrame.getUrl();
        }
        if (url == null || url.length() == 0) {
            FrameLayout root = holder.getViewBinding().f.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            uf.c.g(root);
            return;
        }
        FrameLayout root2 = holder.getViewBinding().f.getRoot();
        Intrinsics.g(root2, "getRoot(...)");
        uf.c.k(root2);
        f.b c = f.a.m(getContext()).g(url).m(this.coverSize).c(this.coverSize);
        ShapeableImageView shapeableImageView = holder.getViewBinding().f.b;
        Intrinsics.g(shapeableImageView, "ivPostCover");
        c.d(shapeableImageView);
    }

    private final void J1(RoomListItemVH holder, RoomItem item) {
        E1(holder, Intrinsics.c(item.getHasJoin(), Boolean.TRUE));
        RoomJoinAnimationView roomJoinAnimationView = holder.getViewBinding().l;
        Intrinsics.g(roomJoinAnimationView, "vJoin");
        uf.c.k(roomJoinAnimationView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(RoomListItemVH holder, RoomItem item) {
        String str;
        List<String> tags;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        String avatar = item.getAvatar();
        if (avatar != null) {
            f.b c = f.a.m(getContext()).g(avatar).m(this.coverSize).c(this.coverSize);
            ShapeableImageView shapeableImageView = holder.getViewBinding().d;
            Intrinsics.g(shapeableImageView, "ivCover");
            c.d(shapeableImageView);
        }
        if (this.isSelectRoom) {
            holder.getViewBinding().k.setMaxLines(2);
            AppCompatTextView appCompatTextView = holder.getViewBinding().g;
            Intrinsics.g(appCompatTextView, "tvMember");
            uf.c.g(appCompatTextView);
            AppCompatTextView appCompatTextView2 = holder.getViewBinding().j;
            Intrinsics.g(appCompatTextView2, "tvTag");
            uf.c.g(appCompatTextView2);
            Group group = holder.getViewBinding().c;
            Intrinsics.g(group, "groupNewPost");
            uf.c.g(group);
            holder.getViewBinding().k.setText(item.getName());
            return;
        }
        Long newPostCount = item.getNewPostCount();
        G1(holder, newPostCount != null ? newPostCount.longValue() : 0L);
        holder.getViewBinding().k.setText(item.getName());
        if (item.getUserCount() != null) {
            Long userCount = item.getUserCount();
            Intrinsics.e(userCount);
            str = k.d(userCount.longValue());
        } else {
            str = "0";
        }
        AppCompatTextView appCompatTextView3 = holder.getViewBinding().g;
        Long userCount2 = item.getUserCount();
        appCompatTextView3.setText((userCount2 != null ? userCount2.longValue() : 0L) == 1 ? Utils.a().getString(R$string.one_members) : Utils.a().getString(R$string.x_members, str));
        c.a e = ah.c.e();
        List<String> tags2 = item.getTags();
        if ((tags2 != null ? tags2.size() : 0) > 3) {
            List<String> tags3 = item.getTags();
            tags = tags3 != null ? tags3.subList(0, 3) : null;
        } else {
            tags = item.getTags();
        }
        if (tags != null) {
            boolean z = true;
            for (String str2 : tags) {
                if (!z) {
                    e.e("丨").c(androidx.core.content.b.getColor(Utils.a(), R.color.white_20));
                }
                e.e(str2).c(androidx.core.content.b.getColor(Utils.a(), R.color.white_60));
                z = false;
            }
        }
        holder.getViewBinding().j.setText(e.b());
        int i = a.a[this.roomListFrom.ordinal()];
        if (i == 1) {
            RoomJoinAnimationView roomJoinAnimationView = holder.getViewBinding().l;
            Intrinsics.g(roomJoinAnimationView, "vJoin");
            uf.c.g(roomJoinAnimationView);
            F1(holder, item);
            return;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        Group group2 = holder.getViewBinding().c;
        Intrinsics.g(group2, "groupNewPost");
        uf.c.g(group2);
        J1(holder, item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void G(RoomListItemVH holder, RoomItem item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object v0 = CollectionsKt.v0(payloads);
        if (v0 instanceof Boolean) {
            E1(holder, ((Boolean) v0).booleanValue());
        } else if (v0 instanceof Long) {
            G1(holder, ((Number) v0).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public RoomListItemVH y0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        y c = y.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.g(c, "inflate(...)");
        return new RoomListItemVH(c);
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }
}
