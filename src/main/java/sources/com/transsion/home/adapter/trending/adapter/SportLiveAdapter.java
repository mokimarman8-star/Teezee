package com.transsion.home.adapter.trending.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.TeamInfo;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.usercenter.R;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.t1;
import ni.f;
import sk.b;
import uf.c;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002*+B)\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010!R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010!¨\u0006,"}, d2 = {"Lcom/transsion/home/adapter/trending/adapter/SportLiveAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/LiveListItem;", "Lcom/transsion/home/adapter/trending/adapter/SportLiveAdapter$SportLiveViewHolder;", BuildConfig.FLAVOR, "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "tabId", BuildConfig.FLAVOR, "isTablet", "<init>", "(ILcom/transsion/home/bean/OperateItem;IZ)V", "item", "position", BuildConfig.FLAVOR, "G1", "(Lcom/transsion/home/bean/LiveListItem;Lcom/transsion/home/bean/OperateItem;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "C1", "(Landroid/view/ViewGroup;I)Lcom/transsion/home/adapter/trending/adapter/SportLiveAdapter$SportLiveViewHolder;", "holder", "B1", "(Lcom/transsion/home/adapter/trending/adapter/SportLiveAdapter$SportLiveViewHolder;Lcom/transsion/home/bean/LiveListItem;)V", "F1", "(Lcom/transsion/home/adapter/trending/adapter/SportLiveAdapter$SportLiveViewHolder;)V", "E1", "D1", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "H", "Z", "itemWidth", "J", "itemHeight", "K", "teamImageSize", "L", "a", "SportLiveViewHolder", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SportLiveAdapter extends BaseQuickAdapter {
    public static final int M = 8;
    public static final String N = "MatchNotStart";
    public static final String O = "MatchIng";
    public static final String P = "MatchEnded";

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean isTablet;

    /* renamed from: I, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: J, reason: from kotlin metadata */
    private final int itemHeight;

    /* renamed from: K, reason: from kotlin metadata */
    private final int teamImageSize;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/transsion/home/adapter/trending/adapter/SportLiveAdapter$SportLiveViewHolder;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", BuildConfig.FLAVOR, "timestamp", BuildConfig.FLAVOR, "g", "(J)Ljava/lang/String;", "Lcom/transsion/home/bean/LiveListItem;", "item", BuildConfig.FLAVOR, "j", "(Lcom/transsion/home/bean/LiveListItem;)V", "i", "()V", "h", "a", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "Lkotlinx/coroutines/t1;", "b", "Lkotlinx/coroutines/t1;", "job", "c", "Lcom/transsion/home/bean/LiveListItem;", "info", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SportLiveViewHolder extends BaseViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        private final View rootView;

        /* renamed from: b, reason: from kotlin metadata */
        private t1 job;

        /* renamed from: c, reason: from kotlin metadata */
        private LiveListItem info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SportLiveViewHolder(View view) {
            super(view);
            Intrinsics.h(view, "rootView");
            this.rootView = view;
        }

        private final String g(long timestamp) {
            int q = TimeUtilKt.q(timestamp);
            if (q == 0) {
                long currentTimeMillis = timestamp - System.currentTimeMillis();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" · HH:mm:ss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
                i();
                String format = simpleDateFormat.format(Long.valueOf(currentTimeMillis));
                Intrinsics.g(format, "format(...)");
                return format;
            }
            if (q < 0) {
                return BuildConfig.FLAVOR;
            }
            return " · " + this.rootView.getContext().getResources().getString(q == 1 ? R.string.user_day_left : R.string.user_days_left, Integer.valueOf(q));
        }

        public final void h() {
            t1 t1Var = this.job;
            if (t1Var != null) {
                t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
            }
            this.job = null;
        }

        public final void i() {
            LiveListItem liveListItem = this.info;
            if (liveListItem != null) {
                if (Intrinsics.c(liveListItem != null ? liveListItem.getStatus() : null, SportLiveAdapter.O)) {
                    return;
                }
                t1 t1Var = this.job;
                if (t1Var != null) {
                    t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
                }
                u context = ((RecyclerView.a0) this).itemView.getContext();
                u uVar = context instanceof u ? context : null;
                if (uVar == null) {
                    return;
                }
                this.job = i.d(v.a(uVar), (CoroutineContext) null, (CoroutineStart) null, new SportLiveAdapter$SportLiveViewHolder$startCutDown$1(uVar, this, null), 3, (Object) null);
            }
        }

        public final void j(LiveListItem item) {
            if (item == null) {
                return;
            }
            this.info = item;
            Long startTime = item.getStartTime();
            long longValue = startTime != null ? startTime.longValue() : 0L;
            TextView textView = (TextView) getView(com.transsion.home.R.id.main_op_sport_live_status_text);
            c.k(textView);
            long currentTimeMillis = longValue - System.currentTimeMillis();
            if (item.getStartTime() == null || currentTimeMillis > 0) {
                item.setStatus(SportLiveAdapter.N);
            } else {
                item.setStatus(SportLiveAdapter.O);
            }
            String status = item.getStatus();
            if (!Intrinsics.c(status, SportLiveAdapter.N)) {
                if (!Intrinsics.c(status, SportLiveAdapter.O)) {
                    c.h(textView);
                    return;
                } else {
                    textView.setText(BuildConfig.FLAVOR);
                    textView.setBackgroundResource(com.transsion.home.R.mipmap.ic_op_sport_live_status);
                    return;
                }
            }
            textView.setText(this.rootView.getContext().getString(com.transsion.home.R.string.sport_live_upcoming) + g(longValue));
            textView.setBackgroundResource(com.tn.lib.widget.R.drawable.bg_corner_tips_rectangle_2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportLiveAdapter(int i, OperateItem operateItem, int i2, boolean z) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(operateItem, "operateItem");
        this.operateItem = operateItem;
        this.tabId = i2;
        this.isTablet = z;
        this.teamImageSize = a0.a(30.0f);
        int a = a0.a(((((a0.b(RangesKt.h(y.e(), y.c())) - 12) - (r1 * 8)) - 8) * 1.0f) / (z ? 3 : 2));
        this.itemWidth = a;
        this.itemHeight = (int) (a * 0.56d);
    }

    public /* synthetic */ SportLiveAdapter(int i, OperateItem operateItem, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? com.transsion.home.R.layout.item_main_operation_sport_live : i, operateItem, i2, z);
    }

    private final void G1(LiveListItem item, OperateItem operateItem, int position) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_sport_live_item");
        hashMap.put("sequence", String.valueOf(position));
        hashMap.put("tabId", String.valueOf(this.tabId));
        b.a(operateItem, hashMap);
        String matchId = item.getMatchId();
        String str = BuildConfig.FLAVOR;
        if (matchId == null) {
            matchId = BuildConfig.FLAVOR;
        }
        hashMap.put("match_id", matchId);
        String status = item.getStatus();
        if (status == null) {
            status = BuildConfig.FLAVOR;
        }
        hashMap.put("match_status", status);
        String ops = item.getOps();
        if (ops != null) {
            str = ops;
        }
        hashMap.put("ops", str);
        com.transsion.baselib.helper.a.a.a(SubTabFragment.INSTANCE.a(this.tabId), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(SportLiveViewHolder holder, LiveListItem item) {
        String str;
        String avatar;
        String str2;
        String str3;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        z(holder, getItemViewType(holder.getBindingAdapterPosition()));
        ShapeableImageView viewOrNull = holder.getViewOrNull(com.transsion.home.R.id.main_op_sport_live_image);
        String str4 = BuildConfig.FLAVOR;
        if (viewOrNull != null) {
            f.a aVar = f.a;
            Context context = viewOrNull.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            Image image = item.getImage();
            if (image == null || (str2 = image.getUrl()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            f.b c = m.g(str2).m(this.itemWidth).c(this.itemHeight);
            Image image2 = item.getImage();
            if (image2 == null || (str3 = image2.getThumbnail()) == null) {
                str3 = BuildConfig.FLAVOR;
            }
            c.l(str3).d(viewOrNull);
        }
        holder.j(item);
        f.a aVar2 = f.a;
        f.b m2 = aVar2.m(getContext());
        TeamInfo team1 = item.getTeam1();
        if (team1 == null || (str = team1.getAvatar()) == null) {
            str = BuildConfig.FLAVOR;
        }
        m2.g(str).i(com.transsion.home.R.mipmap.ic_op_live_default).m(this.teamImageSize).c(this.teamImageSize).d((ImageView) holder.getView(com.transsion.home.R.id.main_op_sport_live_team1_image));
        f.b m3 = aVar2.m(getContext());
        TeamInfo team2 = item.getTeam2();
        if (team2 != null && (avatar = team2.getAvatar()) != null) {
            str4 = avatar;
        }
        m3.g(str4).i(com.transsion.home.R.mipmap.ic_op_live_default).m(this.teamImageSize).c(this.teamImageSize).d((ImageView) holder.getView(com.transsion.home.R.id.main_op_sport_live_team2_image));
        int i = com.transsion.home.R.id.main_op_sport_live_team1;
        TeamInfo team12 = item.getTeam1();
        holder.setText(i, team12 != null ? team12.getName() : null);
        int i2 = com.transsion.home.R.id.main_op_sport_live_team2;
        TeamInfo team22 = item.getTeam2();
        holder.setText(i2, team22 != null ? team22.getName() : null);
        G1(item, this.operateItem, holder.getBindingAdapterPosition());
    }

    /* renamed from: C1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public SportLiveViewHolder z0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(com.transsion.home.R.layout.item_main_operation_sport_live, parent, false);
        Intrinsics.g(inflate, "inflate(...)");
        SportLiveViewHolder sportLiveViewHolder = new SportLiveViewHolder(inflate);
        ShapeableImageView viewOrNull = sportLiveViewHolder.getViewOrNull(com.transsion.home.R.id.main_op_sport_live_image);
        if (viewOrNull != null) {
            viewOrNull.getLayoutParams().width = this.itemWidth;
            viewOrNull.getLayoutParams().height = this.itemHeight;
        }
        return sportLiveViewHolder;
    }

    /* renamed from: D1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(SportLiveViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super.B0(holder);
        holder.i();
    }

    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(SportLiveViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewDetachedFromWindow(holder);
        holder.h();
    }

    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(SportLiveViewHolder holder) {
        Intrinsics.h(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        holder.h();
    }
}
