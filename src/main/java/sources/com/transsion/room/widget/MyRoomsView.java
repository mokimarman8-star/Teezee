package com.transsion.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.R$layout;
import com.transsion.room.adapter.YourRoomsAdapter;
import fp.j0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/transsion/room/widget/MyRoomsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "item", "position", BuildConfig.FLAVOR, "n", "(Lcom/transsion/moviedetailapi/bean/RoomItem;I)V", "k", "m", "()V", BuildConfig.FLAVOR, "dataList", "setList", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "getDataList", "()Ljava/util/List;", "Lfp/j0;", "a", "Lfp/j0;", "viewBinding", "Lcom/transsion/room/adapter/YourRoomsAdapter;", "b", "Lcom/transsion/room/adapter/YourRoomsAdapter;", "mAdapter", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MyRoomsView extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final j0 viewBinding;

    /* renamed from: b, reason: from kotlin metadata */
    private YourRoomsAdapter mAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyRoomsView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyRoomsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MyRoomsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        YourRoomsAdapter yourRoomsAdapter = new YourRoomsAdapter();
        yourRoomsAdapter.w1(new r6.d() { // from class: com.transsion.room.widget.a
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                MyRoomsView.l(MyRoomsView.this, baseQuickAdapter, view, i2);
            }
        });
        this.mAdapter = yourRoomsAdapter;
        View.inflate(getContext(), R$layout.view_your_rooms, this);
        j0 a = j0.a(this);
        Intrinsics.g(a, "bind(...)");
        this.viewBinding = a;
        RecyclerView recyclerView = a.b;
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 4));
        recyclerView.addItemDecoration(new tf.a(lj.a.b(8), 0, 0, 0));
        recyclerView.setAdapter(this.mAdapter);
        a.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRoomsView.j(MyRoomsView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(MyRoomsView myRoomsView, View view) {
        myRoomsView.m();
    }

    private final void k(RoomItem item, int position) {
        if (item != null) {
            item.setNewPostCount(0L);
        }
        this.mAdapter.notifyItemChanged(position, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(MyRoomsView myRoomsView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "v");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        RoomItem roomItem = item instanceof RoomItem ? (RoomItem) item : null;
        if (roomItem == null) {
            return;
        }
        myRoomsView.n(roomItem, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        com.transsion.room.helper.l.a.a("room_home");
        Navigator.x(TheRouter.c("/room/list").F("index", 0), getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(RoomItem item, int position) {
        com.transsion.room.helper.l.a.b("room_home", item);
        Navigator.x(TheRouter.c("/room/detail").K("id", item.getGroupId()), getContext(), (mf.c) null, 2, (Object) null);
        k(item, position);
    }

    public final List<RoomItem> getDataList() {
        return this.mAdapter.getData();
    }

    public final void setList(List<RoomItem> dataList) {
        Intrinsics.h(dataList, "dataList");
        if (dataList.size() > 4) {
            AppCompatTextView appCompatTextView = this.viewBinding.c;
            Intrinsics.g(appCompatTextView, "tvMore");
            uf.c.k(appCompatTextView);
            dataList = dataList.subList(0, 4);
        } else {
            AppCompatTextView appCompatTextView2 = this.viewBinding.c;
            Intrinsics.g(appCompatTextView2, "tvMore");
            uf.c.g(appCompatTextView2);
        }
        this.mAdapter.n1(dataList);
    }
}
