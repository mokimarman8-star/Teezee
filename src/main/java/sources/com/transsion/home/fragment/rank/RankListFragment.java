package com.transsion.home.fragment.rank;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.RankAllData;
import com.transsion.home.fragment.rank.RankListFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.home.viewmodel.RankAllViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.widget.DownloadView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import ni.f;
import qk.t;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0004R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/transsion/home/fragment/rank/RankListFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lqk/t;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "e0", "(Landroid/view/LayoutInflater;)Lqk/t;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "Lcom/transsion/home/bean/RankAllData;", "data", "k0", "(Lcom/transsion/home/bean/RankAllData;)V", "errorView", "j0", "(Landroid/view/View;)V", "startLoading", "hideLoading", "Lcom/transsion/home/viewmodel/RankAllViewModel;", "a", "Lcom/transsion/home/viewmodel/RankAllViewModel;", "viewModel", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "b", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "mMainAdapter", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "headerView", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RankListFragment extends BaseFragment<t> {

    /* renamed from: a, reason: from kotlin metadata */
    private RankAllViewModel viewModel;

    /* renamed from: b, reason: from kotlin metadata */
    private BaseQuickAdapter mMainAdapter;

    /* renamed from: c, reason: from kotlin metadata */
    private TextView headerView;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/transsion/home/fragment/rank/RankListFragment$a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", "<init>", "()V", BuildConfig.FLAVOR, "seconds", BuildConfig.FLAVOR, "E1", "(I)Ljava/lang/String;", "item", "pos", BuildConfig.FLAVOR, "I1", "(Lcom/transsion/moviedetailapi/bean/Subject;I)V", "position", "H1", "G1", "F1", "(I)I", "holder", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends BaseQuickAdapter implements t6.i {
        public static final int F = 8;

        public a() {
            super(R.layout.item_movie_rank_education_subject, (List) null, 2, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D1(a aVar, Subject subject, int i, View view) {
            aVar.I1(subject, i);
        }

        private final String E1(int seconds) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(seconds / 3600), Integer.valueOf((seconds % 3600) / 60), Integer.valueOf(seconds % 60)}, 3));
            Intrinsics.g(format, "format(...)");
            return format;
        }

        private final int F1(int pos) {
            return pos != 0 ? pos != 1 ? pos != 2 ? R.mipmap.ic_rank_defalut : R.mipmap.ic_rank_03 : R.mipmap.ic_rank_02 : R.mipmap.ic_rank_01;
        }

        private final void G1(Subject item, int position) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            sk.b.d(item, linkedHashMap);
            linkedHashMap.put("event_type", "rank_item_browse");
            linkedHashMap.put("position", String.valueOf(position));
            qi.h.a.z("rank_all_page", linkedHashMap);
        }

        private final void H1(Subject item, int position) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            sk.b.d(item, linkedHashMap);
            linkedHashMap.put("position", String.valueOf(position));
            linkedHashMap.put("event_type", "rank_item_click");
            linkedHashMap.put("click_type", "poster_click");
            qi.h.a.o("rank_all_page", linkedHashMap);
        }

        private final void I1(Subject item, int pos) {
            zk.h.f(item, "rank_all");
            H1(item, pos);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: C1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, final Subject item) {
            String str;
            String str2;
            String valueOf;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            ImageView imageView = (ImageView) holder.getView(R.id.rank_item_image);
            f.a aVar = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            Cover cover = item.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            Cover cover2 = item.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            g.l(str2).d(imageView);
            final int e = ij.k.e(getData(), item);
            AppCompatImageView viewOrNull = holder.getViewOrNull(R.id.rank_item_rank_tag);
            if (viewOrNull != null) {
                viewOrNull.setImageResource(F1(e));
            }
            if (e > 2) {
                if (e < 9) {
                    valueOf = "0" + (e + 1);
                } else {
                    valueOf = String.valueOf(e + 1);
                }
                holder.setText(R.id.rank_item_tag_rank, valueOf);
            } else {
                holder.setText(R.id.rank_item_tag_rank, BuildConfig.FLAVOR);
            }
            TextView textView = (TextView) holder.getView(R.id.rank_item_rank_duration);
            Integer durationSeconds = item.getDurationSeconds();
            textView.setText(E1(durationSeconds != null ? durationSeconds.intValue() : 0));
            TextView textView2 = (TextView) holder.getView(R.id.rank_item_title);
            textView2.setText(item.getTitle());
            textView2.setGravity(sk.a.d());
            ((TextView) holder.getView(R.id.rank_item_des)).setText(item.getViewers() + " students");
            ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.rank.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankListFragment.a.D1(RankListFragment.a.this, item, e, view);
                }
            });
            G1(item, e);
        }

        public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
            return t6.h.a(this, baseQuickAdapter);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ'\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/transsion/home/fragment/rank/RankListFragment$b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", "<init>", "()V", "item", BuildConfig.FLAVOR, "pos", BuildConfig.FLAVOR, "M1", "(Lcom/transsion/moviedetailapi/bean/Subject;I)V", "N1", "position", BuildConfig.FLAVOR, "type", "K1", "(Lcom/transsion/moviedetailapi/bean/Subject;ILjava/lang/String;)V", "J1", "I1", "(I)I", "subject", "Lcom/transsnet/downloader/widget/DownloadView;", "downloadView", "L1", "(Lcom/transsion/moviedetailapi/bean/Subject;Lcom/transsnet/downloader/widget/DownloadView;)V", "holder", "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends BaseQuickAdapter implements t6.i {
        public static final int F = 8;

        public b() {
            super(R.layout.item_movie_rank_subject, (List) null, 2, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void F1(TextView textView, TextView textView2, Subject subject) {
            textView.setMaxLines(textView2.getLineCount() > 1 ? 2 : 3);
            textView.setText(subject.getDescription());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G1(b bVar, Subject subject, int i, View view) {
            bVar.N1(subject, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H1(b bVar, Subject subject, int i, View view) {
            bVar.M1(subject, i);
        }

        private final int I1(int pos) {
            return pos != 0 ? pos != 1 ? pos != 2 ? R.mipmap.ic_rank_defalut : R.mipmap.ic_rank_03 : R.mipmap.ic_rank_02 : R.mipmap.ic_rank_01;
        }

        private final void J1(Subject item, int position) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            sk.b.d(item, linkedHashMap);
            linkedHashMap.put("event_type", "rank_item_browse");
            linkedHashMap.put("position", String.valueOf(position));
            qi.h.a.z("rank_all_page", linkedHashMap);
        }

        private final void K1(Subject item, int position, String type) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            sk.b.d(item, linkedHashMap);
            linkedHashMap.put("position", String.valueOf(position));
            linkedHashMap.put("event_type", "rank_item_click");
            linkedHashMap.put("click_type", type);
            qi.h.a.o("rank_all_page", linkedHashMap);
        }

        private final void L1(Subject subject, DownloadView downloadView) {
            if (!(subject != null ? Intrinsics.c(subject.getHasResource(), Boolean.TRUE) : false)) {
                uf.c.h(downloadView);
                return;
            }
            uf.c.k(downloadView);
            if (ij.t.a.b()) {
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType == null || subjectType.intValue() != value) {
                    downloadView.setShowPlayType();
                    return;
                }
            }
            DownloadView.setShowType$default(downloadView, subject.getSubjectId(), (String) null, (Boolean) null, false, com.transsion.baseui.R.string.download_movie, 14, (Object) null);
        }

        private final void M1(Subject item, int pos) {
            K1(item, pos, zk.h.g(item, "rank_all_page", getContext(), "rank_all"));
        }

        private final void N1(Subject item, int pos) {
            zk.h.f(item, "rank_all");
            K1(item, pos, "poster_click");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: E1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, final Subject item) {
            String str;
            String str2;
            String valueOf;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            ImageView imageView = (ImageView) holder.getView(R.id.rank_item_image);
            f.a aVar = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            Cover cover = item.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            Cover cover2 = item.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            g.l(str2).d(imageView);
            final int e = ij.k.e(getData(), item);
            AppCompatImageView viewOrNull = holder.getViewOrNull(R.id.rank_item_rank_tag);
            if (viewOrNull != null) {
                viewOrNull.setImageResource(I1(e));
            }
            holder.setText(R.id.rank_item_corner, item.getCorner());
            if (e > 2) {
                if (e < 9) {
                    valueOf = "0" + (e + 1);
                } else {
                    valueOf = String.valueOf(e + 1);
                }
                holder.setText(R.id.rank_item_tag_rank, valueOf);
            } else {
                holder.setText(R.id.rank_item_tag_rank, BuildConfig.FLAVOR);
            }
            final TextView textView = (TextView) holder.getView(R.id.rank_item_title);
            final TextView textView2 = (TextView) holder.getView(R.id.rank_item_des);
            textView.setText(item.getTitle());
            textView.setGravity(sk.a.d());
            textView.post(new Runnable() { // from class: com.transsion.home.fragment.rank.o
                @Override // java.lang.Runnable
                public final void run() {
                    RankListFragment.b.F1(textView2, textView, item);
                }
            });
            L1(item, (DownloadView) holder.getView(R.id.rank_item_download));
            holder.setText(R.id.rank_item_imdb, item.getImdbRate());
            ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.rank.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankListFragment.b.G1(RankListFragment.b.this, item, e, view);
                }
            });
            holder.getView(R.id.rank_item_download).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.rank.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankListFragment.b.H1(RankListFragment.b.this, item, e, view);
                }
            });
            J1(item, e);
        }

        public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
            return t6.h.a(this, baseQuickAdapter);
        }
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(final RankListFragment rankListFragment) {
        RecyclerView recyclerView;
        if (yg.l.a.e()) {
            RankAllViewModel rankAllViewModel = rankListFragment.viewModel;
            if (rankAllViewModel != null) {
                rankAllViewModel.l();
                return;
            }
            return;
        }
        fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
        t tVar = (t) rankListFragment.getMViewBinding();
        if (tVar == null || (recyclerView = tVar.b) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.rank.m
            @Override // java.lang.Runnable
            public final void run() {
                RankListFragment.g0(RankListFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(RankListFragment rankListFragment) {
        t6.f h0;
        BaseQuickAdapter baseQuickAdapter = rankListFragment.mMainAdapter;
        if (baseQuickAdapter == null || (h0 = baseQuickAdapter.h0()) == null) {
            return;
        }
        h0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(final RankListFragment rankListFragment, final RankAllData rankAllData) {
        ConstraintLayout root;
        t6.f h0;
        if (rankAllData == null) {
            BaseQuickAdapter baseQuickAdapter = rankListFragment.mMainAdapter;
            if (baseQuickAdapter != null && (h0 = baseQuickAdapter.h0()) != null) {
                h0.v();
            }
        } else {
            BaseQuickAdapter baseQuickAdapter2 = rankListFragment.mMainAdapter;
            if (baseQuickAdapter2 != null) {
                List<Subject> subjects = rankAllData.getSubjects();
                baseQuickAdapter2.q(subjects != null ? subjects : new ArrayList());
            }
            t tVar = (t) rankListFragment.getMViewBinding();
            if (tVar != null && (root = tVar.getRoot()) != null) {
                root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.rank.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        RankListFragment.i0(RankListFragment.this, rankAllData);
                    }
                }, 300L);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(RankListFragment rankListFragment, RankAllData rankAllData) {
        BaseQuickAdapter baseQuickAdapter;
        t6.f h0;
        t6.f h02;
        BaseQuickAdapter baseQuickAdapter2;
        t6.f h03;
        BaseQuickAdapter baseQuickAdapter3 = rankListFragment.mMainAdapter;
        if (baseQuickAdapter3 != null && (h02 = baseQuickAdapter3.h0()) != null && h02.r() && (baseQuickAdapter2 = rankListFragment.mMainAdapter) != null && (h03 = baseQuickAdapter2.h0()) != null) {
            h03.s();
        }
        Pager pager = rankAllData.getPager();
        if ((pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false) || (baseQuickAdapter = rankListFragment.mMainAdapter) == null || (h0 = baseQuickAdapter.h0()) == null) {
            return;
        }
        t6.f.u(h0, false, 1, (Object) null);
    }

    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public t getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.viewModel = (RankAllViewModel) new v0(activity).a(RankAllViewModel.class);
        }
        t c2 = t.c(inflater);
        Intrinsics.g(c2, "inflate(...)");
        return c2;
    }

    public void hideLoading() {
        ConstraintLayout constraintLayout;
        t tVar = (t) getMViewBinding();
        if (tVar == null || (constraintLayout = tVar.c) == null) {
            return;
        }
        uf.c.h(constraintLayout);
    }

    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        Bundle arguments;
        Intrinsics.h(view, "view");
        Fragment parentFragment = getParentFragment();
        this.mMainAdapter = HomeTabId.INSTANCE.h((parentFragment == null || (arguments = parentFragment.getArguments()) == null) ? null : Integer.valueOf(arguments.getInt("tabId")), true) ? new a() : new b();
        t tVar = (t) getMViewBinding();
        if (tVar == null || (recyclerView = tVar.b) == null) {
            return;
        }
        recyclerView.setAdapter(this.mMainAdapter);
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setItemAnimator((RecyclerView.j) null);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new tf.f(0.0f, 16.0f, 0.0f, 5, (DefaultConstructorMarker) null));
        }
    }

    public final void j0(View errorView) {
        Intrinsics.h(errorView, "errorView");
        BaseQuickAdapter baseQuickAdapter = this.mMainAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.n1((Collection) null);
        }
        BaseQuickAdapter baseQuickAdapter2 = this.mMainAdapter;
        if (baseQuickAdapter2 != null) {
            baseQuickAdapter2.Y0(errorView);
        }
    }

    public final void k0(RankAllData data) {
        t6.f h0;
        RecyclerView recyclerView;
        t6.f h02;
        t6.f h03;
        Pager pager;
        BaseQuickAdapter baseQuickAdapter = this.mMainAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.n1(data != null ? data.getSubjects() : null);
        }
        TextView textView = this.headerView;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            textView2.setText(data != null ? data.getTitle() : null);
            textView2.setPadding(a0.a(12.0f), a0.a(16.0f), a0.a(12.0f), 0);
            textView2.setTextSize(2, 16.0f);
            textView2.setTextColor(androidx.core.content.b.getColor(textView2.getContext(), com.transsion.usercenter.R.color.pair_text_191F2B));
            textView2.setMaxLines(2);
            textView2.setGravity(sk.a.d());
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTypeface(Typeface.create("ans-serif", 1));
            BaseQuickAdapter baseQuickAdapter2 = this.mMainAdapter;
            if (baseQuickAdapter2 != null) {
                BaseQuickAdapter.y(baseQuickAdapter2, textView2, 0, 0, 6, (Object) null);
            }
            this.headerView = textView2;
        } else if (textView != null) {
            textView.setText(data != null ? data.getTitle() : null);
        }
        if ((data == null || (pager = data.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.TRUE)) {
            BaseQuickAdapter baseQuickAdapter3 = this.mMainAdapter;
            if (baseQuickAdapter3 != null && (h03 = baseQuickAdapter3.h0()) != null) {
                h03.z(true);
            }
            BaseQuickAdapter baseQuickAdapter4 = this.mMainAdapter;
            if (baseQuickAdapter4 != null && (h02 = baseQuickAdapter4.h0()) != null) {
                h02.y(true);
            }
        } else {
            BaseQuickAdapter baseQuickAdapter5 = this.mMainAdapter;
            if (baseQuickAdapter5 != null && (h0 = baseQuickAdapter5.h0()) != null) {
                t6.f.u(h0, false, 1, (Object) null);
            }
        }
        t tVar = (t) getMViewBinding();
        if (tVar == null || (recyclerView = tVar.b) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    public void lazyLoadData() {
        b0 i;
        t6.f h0;
        BaseQuickAdapter baseQuickAdapter = this.mMainAdapter;
        if (baseQuickAdapter != null && (h0 = baseQuickAdapter.h0()) != null) {
            h0.D(new r6.f() { // from class: com.transsion.home.fragment.rank.j
                public final void a() {
                    RankListFragment.f0(RankListFragment.this);
                }
            });
        }
        RankAllViewModel rankAllViewModel = this.viewModel;
        if (rankAllViewModel == null || (i = rankAllViewModel.i()) == null) {
            return;
        }
        i.j(this, new c(new Function1() { // from class: com.transsion.home.fragment.rank.k
            public final Object invoke(Object obj) {
                Unit h02;
                h02 = RankListFragment.h0(RankListFragment.this, (RankAllData) obj);
                return h02;
            }
        }));
    }

    public void startLoading() {
        ConstraintLayout constraintLayout;
        t tVar = (t) getMViewBinding();
        if (tVar == null || (constraintLayout = tVar.c) == null) {
            return;
        }
        uf.c.k(constraintLayout);
    }
}
