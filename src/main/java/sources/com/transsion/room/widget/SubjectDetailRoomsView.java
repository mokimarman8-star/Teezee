package com.transsion.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$layout;
import com.transsion.room.api.RoomsViewType;
import fp.h0;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/transsion/room/widget/SubjectDetailRoomsView;", "Lcom/transsion/room/widget/RoomsBaseView;", "Lfp/h0;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BuildConfig.FLAVOR, "initRecyclerView", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/appcompat/widget/AppCompatTextView;", "getTitleView", "()Landroidx/appcompat/widget/AppCompatTextView;", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubjectDetailRoomsView extends RoomsBaseView<h0> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubjectDetailRoomsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubjectDetailRoomsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SubjectDetailRoomsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppCompatTextView appCompatTextView;
        Intrinsics.h(context, "context");
        View.inflate(context, R$layout.view_subject_detail_rooms, this);
        setMViewBinding(h0.a(this));
        setPadding(0, lj.a.b(12), 0, 0);
        initRecyclerView();
        getMAdapter().G1(RoomsViewType.TYPE_SUBJECT_DETAIL);
        h0 h0Var = (h0) getMViewBinding();
        if (h0Var == null || (appCompatTextView = h0Var.c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.widget.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectDetailRoomsView.E(SubjectDetailRoomsView.this, view);
            }
        });
    }

    public /* synthetic */ SubjectDetailRoomsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(SubjectDetailRoomsView subjectDetailRoomsView, View view) {
        subjectDetailRoomsView.B();
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public RecyclerView getRecyclerView() {
        h0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.b;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public AppCompatTextView getTitleView() {
        h0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            return mViewBinding.d;
        }
        return null;
    }

    @Override // com.transsion.room.widget.RoomsBaseView
    public void initRecyclerView() {
        RecyclerView recyclerView;
        h0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.addItemDecoration(new tf.a(lj.a.b(8), lj.a.b(8), 0, 0));
        recyclerView.setAdapter(getMAdapter());
    }
}
