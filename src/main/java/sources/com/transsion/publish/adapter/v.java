package com.transsion.publish.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.ui.SelectVideoActivity;
import com.transsion.publish.ui.VideoPreviewActivity;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class v extends RecyclerView.Adapter {
    public static final a e = new a(null);
    private FrameLayout.LayoutParams b;
    private boolean d;
    private List a = new ArrayList();
    private int c = (com.blankj.utilcode.util.y.b() - (com.blankj.utilcode.util.a0.a(3.0f) * 5)) / 4;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public v() {
        int i = this.c;
        this.b = new FrameLayout.LayoutParams(i, i);
    }

    private final void j(final l0 l0Var, VsMediaInfo vsMediaInfo) {
        TextView i = l0Var.i();
        if (i != null) {
            i.setVisibility(4);
        }
        View f = l0Var.f();
        if (f != null) {
            f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.k(l0.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(l0 l0Var, View view) {
        Intent intent = new Intent(((RecyclerView.a0) l0Var).itemView.getContext(), (Class<?>) SelectVideoActivity.class);
        intent.setFlags(268435456);
        ((RecyclerView.a0) l0Var).itemView.getContext().startActivity(intent);
    }

    private final void o(final l0 l0Var, final VsMediaInfo vsMediaInfo, int i) {
        ((RecyclerView.a0) l0Var).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.p(l0.this, vsMediaInfo, view);
            }
        });
        View g = l0Var.g();
        if (g != null) {
            g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.q(v.this, view);
                }
            });
        }
        if (!TextUtils.isEmpty(vsMediaInfo.getImagePath())) {
            ImageView h = l0Var.h();
            if (h != null) {
                f.a aVar = ni.f.a;
                Context context = ((RecyclerView.a0) l0Var).itemView.getContext();
                Intrinsics.g(context, "getContext(...)");
                aVar.m(context).g(vsMediaInfo.getImagePath()).i(R$drawable.upload_error_cover).j(4).d(h);
                return;
            }
            return;
        }
        File file = new File(vsMediaInfo.getVideoPath());
        ImageView h2 = l0Var.h();
        if (h2 != null) {
            f.a aVar2 = ni.f.a;
            Context context2 = ((RecyclerView.a0) l0Var).itemView.getContext();
            Intrinsics.g(context2, "getContext(...)");
            aVar2.m(context2).g(Uri.fromFile(file).toString()).i(R$drawable.upload_error_cover).j(4).d(h2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(l0 l0Var, VsMediaInfo vsMediaInfo, View view) {
        VideoPreviewActivity.Companion companion = VideoPreviewActivity.INSTANCE;
        Context context = ((RecyclerView.a0) l0Var).itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        companion.a(context, vsMediaInfo, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(v vVar, View view) {
        if (vVar.d) {
            return;
        }
        vVar.d = false;
        jo.b bVar = new jo.b();
        bVar.o(1);
        bVar.n(2);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
        vVar.notifyDataSetChanged();
        vVar.d = false;
    }

    public int getItemCount() {
        return this.a.size();
    }

    public int getItemViewType(int i) {
        return ((VsMediaInfo) this.a.get(i)).getIsAdd() ? 2 : 1;
    }

    public final List l() {
        ArrayList arrayList = new ArrayList();
        List<VsMediaInfo> list = this.a;
        if (list != null) {
            for (VsMediaInfo vsMediaInfo : list) {
                if (!vsMediaInfo.getIsAdd()) {
                    arrayList.add(vsMediaInfo);
                }
            }
        }
        return arrayList;
    }

    public final List m() {
        return this.a;
    }

    public final boolean n() {
        List list = this.a;
        return list != null && list.isEmpty();
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(l0 l0Var, int i) {
        Intrinsics.h(l0Var, "holder");
        VsMediaInfo vsMediaInfo = (VsMediaInfo) this.a.get(i);
        if (vsMediaInfo.getIsAdd()) {
            j(l0Var, vsMediaInfo);
        } else {
            o(l0Var, vsMediaInfo, i);
        }
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public l0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        return i != 1 ? i != 2 ? new l0(null) : new l0(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_publish_add_video, (ViewGroup) null)) : new l0(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_publish_video, (ViewGroup) null));
    }

    public final void setData(List list) {
        Intrinsics.h(list, "data");
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public final void t() {
        List list = this.a;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }
}
