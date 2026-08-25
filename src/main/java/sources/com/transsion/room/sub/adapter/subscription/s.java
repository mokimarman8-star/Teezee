package com.transsion.room.sub.adapter.subscription;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.sub.adapter.subscription.s;
import com.transsion.room.sub.bean.subscription.UserInfoFollowings;
import com.transsion.room.sub.bean.subscription.UserItemFollowings;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import wf.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u001e\u001fB)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/transsion/room/sub/adapter/subscription/s;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/room/sub/bean/subscription/UserInfoFollowings;", "Lt6/i;", BuildConfig.FLAVOR, "data", "Lbj/b;", "exposureHelper", BuildConfig.FLAVOR, "showNumberTh", "<init>", "(Ljava/util/List;Lbj/b;Z)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "position", "N1", "(Ljava/util/List;I)I", "Lcom/transsion/room/sub/adapter/subscription/b;", "itemClickListener", BuildConfig.FLAVOR, "Q1", "(Lcom/transsion/room/sub/adapter/subscription/b;)V", "G", "Lbj/b;", "H", "Z", "I", "Lcom/transsion/room/sub/adapter/subscription/b;", "clickListener", "J", "a", "b", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s extends BaseProviderMultiAdapter<UserInfoFollowings> implements t6.i {
    private static final String K = "FollowingsFeedAdapter";
    public static final int L = 1;

    /* renamed from: G, reason: from kotlin metadata */
    private final bj.b exposureHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean showNumberTh;

    /* renamed from: I, reason: from kotlin metadata */
    private com.transsion.room.sub.adapter.subscription.b clickListener;

    public static final class b extends BaseItemProvider {
        private final bj.b e;
        private final boolean f;
        private com.transsion.room.sub.adapter.subscription.b g;

        public b(bj.b bVar, boolean z) {
            this.e = bVar;
            this.f = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void B(b bVar, UserInfoFollowings userInfoFollowings, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            com.transsion.room.sub.adapter.subscription.b bVar2 = bVar.g;
            if (bVar2 != null) {
                UserItemFollowings userInfo = userInfoFollowings.getUserInfo();
                bVar2.b(userInfo != null ? userInfo.getUserId() : null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void C(b bVar, UserInfoFollowings userInfoFollowings, View view) {
            if (!yg.l.a.e()) {
                fh.b.a.d(R.string.no_network_toast);
                return;
            }
            com.transsion.room.sub.adapter.subscription.b bVar2 = bVar.g;
            if (bVar2 != null) {
                UserItemFollowings userInfo = userInfoFollowings.getUserInfo();
                bVar2.b(userInfo != null ? userInfo.getUserId() : null);
            }
        }

        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public void b(BaseViewHolder baseViewHolder, final UserInfoFollowings userInfoFollowings) {
            Intrinsics.h(baseViewHolder, "holder");
            Intrinsics.h(userInfoFollowings, "userItem");
            ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R$id.iv_avatar);
            if (viewOrNull != null) {
                f.a aVar = ni.f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                UserItemFollowings userInfo = userInfoFollowings.getUserInfo();
                m.g(userInfo != null ? userInfo.getAvatar() : null).d(viewOrNull);
                viewOrNull.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        s.b.B(s.b.this, userInfoFollowings, view);
                    }
                });
            }
            a.a.f(wf.a.a, s.K, "tv_name " + userInfoFollowings, false, 4, (Object) null);
            LinearLayout linearLayout = (LinearLayout) baseViewHolder.getViewOrNull(R$id.container);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.sub.adapter.subscription.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        s.b.C(s.b.this, userInfoFollowings, view);
                    }
                });
            }
            int i = R$id.tv_name;
            UserItemFollowings userInfo2 = userInfoFollowings.getUserInfo();
            baseViewHolder.setText(i, userInfo2 != null ? userInfo2.getNickname() : null);
            TextView textView = (TextView) baseViewHolder.getViewOrNull(R$id.tv_name);
            if (textView != null) {
                textView.setVisibility(0);
            }
            TnTextView tnTextView = (GradientTextView) baseViewHolder.getViewOrNull(R$id.tv_new_video);
            if (tnTextView != null) {
                if (userInfoFollowings.getHasUnread()) {
                    tnTextView.setVisibility(0);
                } else {
                    tnTextView.setVisibility(8);
                }
            }
        }

        public final void D(com.transsion.room.sub.adapter.subscription.b bVar) {
            this.g = bVar;
        }

        public int l() {
            return 1;
        }

        public int m() {
            return R$layout.item_subscription_list;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(List<UserInfoFollowings> list, bj.b bVar, boolean z) {
        super(list);
        Intrinsics.h(list, "data");
        this.exposureHelper = bVar;
        this.showNumberTh = z;
    }

    public /* synthetic */ s(List list, bj.b bVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, bVar, (i & 4) != 0 ? false : z);
    }

    protected int N1(List<UserInfoFollowings> data, int position) {
        Intrinsics.h(data, "data");
        return 1;
    }

    public final void Q1(com.transsion.room.sub.adapter.subscription.b itemClickListener) {
        this.clickListener = itemClickListener;
        b bVar = new b(this.exposureHelper, this.showNumberTh);
        bVar.D(this.clickListener);
        F1(bVar);
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
