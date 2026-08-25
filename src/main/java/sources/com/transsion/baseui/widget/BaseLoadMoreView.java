package com.transsion.baseui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import com.transsion.baseui.R$string;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s6.a;
import uf.c;
import yg.l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0017\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B\u0007¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u001f\u0010!\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0015H\u0016¢\u0006\u0004\b#\u0010$R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010%¨\u0006("}, d2 = {"Lcom/transsion/baseui/widget/BaseLoadMoreView;", "Ls6/a;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/os/Parcelable;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "Landroid/view/View;", "getLoadComplete", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)Landroid/view/View;", "getLoadEndView", "getLoadFailView", "getLoadingView", "Landroid/view/ViewGroup;", "parent", "getRootView", "(Landroid/view/ViewGroup;)Landroid/view/View;", "", "position", "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "loadMoreStatus", "", "convert", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ILcom/chad/library/adapter/base/loadmore/LoadMoreStatus;)V", "p0", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "CREATOR", "a", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class BaseLoadMoreView extends a implements View.OnAttachStateChangeListener, Parcelable {
    private LoadMoreStatus loadMoreStatus;
    public static final a CREATOR = new a((DefaultConstructorMarker) null);
    public static final int $stable = 8;

    public BaseLoadMoreView() {
        this.loadMoreStatus = LoadMoreStatus.Complete;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseLoadMoreView(Parcel parcel) {
        this();
        Intrinsics.h(parcel, "parcel");
    }

    public void convert(BaseViewHolder holder, int position, LoadMoreStatus loadMoreStatus) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(loadMoreStatus, "loadMoreStatus");
        this.loadMoreStatus = loadMoreStatus;
        super.convert(holder, position, loadMoreStatus);
        if (b.a[loadMoreStatus.ordinal()] == 1) {
            c.k(getLoadingView(holder));
        } else {
            c.g(getLoadingView(holder));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public View getLoadComplete(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        View findViewById = ((RecyclerView.a0) holder).itemView.findViewById(R$id.tv_complete);
        Intrinsics.g(findViewById, "findViewById(...)");
        return findViewById;
    }

    public View getLoadEndView(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        View findViewById = ((RecyclerView.a0) holder).itemView.findViewById(R$id.tv_no_more);
        Intrinsics.g(findViewById, "findViewById(...)");
        return findViewById;
    }

    public View getLoadFailView(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        View findViewById = ((RecyclerView.a0) holder).itemView.findViewById(R$id.tv_err);
        AppCompatTextView appCompatTextView = (AppCompatTextView) findViewById;
        appCompatTextView.setText(l.a.e() ? appCompatTextView.getContext().getString(R$string.base_load_err) : appCompatTextView.getContext().getString(com.tn.lib.widget.R$string.no_network_tips));
        Intrinsics.g(findViewById, "apply(...)");
        return findViewById;
    }

    public View getLoadingView(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
        View findViewById = ((RecyclerView.a0) holder).itemView.findViewById(R$id.load_view);
        Intrinsics.g(findViewById, "findViewById(...)");
        return findViewById;
    }

    public View getRootView(ViewGroup parent) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.base_item_load_more, parent, false);
        inflate.addOnAttachStateChangeListener(this);
        Intrinsics.e(inflate);
        return inflate;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View p0) {
        ProgressBar progressBar;
        Intrinsics.h(p0, "p0");
        if (this.loadMoreStatus != LoadMoreStatus.Loading || (progressBar = (ProgressBar) p0.findViewById(R$id.load_view)) == null) {
            return;
        }
        c.k(progressBar);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View p0) {
        Intrinsics.h(p0, "p0");
        ProgressBar progressBar = (ProgressBar) p0.findViewById(R$id.load_view);
        if (progressBar != null) {
            c.g(progressBar);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.h(parcel, "parcel");
    }
}
