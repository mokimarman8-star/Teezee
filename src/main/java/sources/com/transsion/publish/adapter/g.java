package com.transsion.publish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.GalleryActivity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends RecyclerView.Adapter {
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

    public g() {
        int i = this.c;
        this.b = new FrameLayout.LayoutParams(i, i);
    }

    private final void j(final c cVar, PhotoEntity photoEntity) {
        if (getItemCount() == 0) {
            TextView i = cVar.i();
            if (i != null) {
                i.setText("0/9");
            }
        } else {
            List list = this.a;
            boolean z = false;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((PhotoEntity) it.next()).getIsAdd()) {
                        z = true;
                    }
                }
            }
            if (z) {
                TextView i2 = cVar.i();
                if (i2 != null) {
                    i2.setText((getItemCount() - 1) + "/9");
                }
            } else {
                TextView i3 = cVar.i();
                if (i3 != null) {
                    i3.setText(getItemCount() + "/9");
                }
            }
        }
        View f = cVar.f();
        if (f != null) {
            f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.k(c.this, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(c cVar, g gVar, View view) {
        Context context;
        View f = cVar.f();
        if (f == null || (context = f.getContext()) == null) {
            return;
        }
        SelectImageActivity.INSTANCE.a(context, 0, 9 - gVar.l().size(), new ArrayList());
    }

    private final void o(final c cVar, final PhotoEntity photoEntity, final int i) {
        ImageView h = cVar.h();
        if (h != null) {
            Glide.with(((RecyclerView.a0) cVar).itemView.getContext()).load(photoEntity.getLocalPath()).placeholder(R$drawable.upload_error_cover).into(h);
        }
        ((RecyclerView.a0) cVar).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.p(g.this, cVar, i, view);
            }
        });
        View g = cVar.g();
        if (g != null) {
            g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.q(g.this, photoEntity, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(g gVar, c cVar, int i, View view) {
        List l = gVar.l();
        com.transsion.publish.n.b.a().f(l);
        GalleryActivity.Companion companion = GalleryActivity.INSTANCE;
        Context context = ((RecyclerView.a0) cVar).itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        companion.a(context, l, i, 2, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(g gVar, PhotoEntity photoEntity, View view) {
        if (gVar.d) {
            return;
        }
        gVar.d = false;
        gVar.t(photoEntity);
        gVar.d = false;
    }

    private final void t(PhotoEntity photoEntity) {
        this.a.remove(photoEntity);
        jo.b bVar = new jo.b();
        boolean z = false;
        bVar.o(0);
        bVar.n(2);
        if (this.a.size() == 0 || (this.a.size() == 1 && ((PhotoEntity) this.a.get(0)).getIsAdd())) {
            List list = this.a;
            if (list != null) {
                list.clear();
            }
            notifyDataSetChanged();
            FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = jo.b.class.getName();
            Intrinsics.g(name, "getName(...)");
            applicationScopeViewModel.postEvent(name, bVar, 0L);
            return;
        }
        if (this.a.size() == 8) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                if (((PhotoEntity) it.next()).getIsAdd()) {
                    z = true;
                }
            }
            if (!z) {
                PhotoEntity photoEntity2 = new PhotoEntity();
                photoEntity2.setAdd(true);
                this.a.add(photoEntity2);
            }
        }
        FlowEventBus applicationScopeViewModel2 = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = jo.b.class.getName();
        Intrinsics.g(name2, "getName(...)");
        applicationScopeViewModel2.postEvent(name2, bVar, 0L);
        notifyDataSetChanged();
    }

    public final void addData(List list) {
        Intrinsics.h(list, "data");
        int size = this.a.size();
        this.a.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    public int getItemCount() {
        return this.a.size();
    }

    public int getItemViewType(int i) {
        return ((PhotoEntity) this.a.get(i)).getIsAdd() ? 2 : 1;
    }

    public final List l() {
        ArrayList arrayList = new ArrayList();
        for (PhotoEntity photoEntity : this.a) {
            if (!photoEntity.getIsAdd()) {
                arrayList.add(photoEntity);
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
    public void onBindViewHolder(c cVar, int i) {
        Intrinsics.h(cVar, "holder");
        PhotoEntity photoEntity = (PhotoEntity) this.a.get(i);
        if (photoEntity.getIsAdd()) {
            j(cVar, photoEntity);
        } else {
            o(cVar, photoEntity, i);
        }
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        return i != 1 ? i != 2 ? new c(null) : new c(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_publish_add_image, (ViewGroup) null)) : new c(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_publish_image, (ViewGroup) null));
    }

    public final void setData(List list) {
        Intrinsics.h(list, "data");
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public final void u() {
        List list = this.a;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }
}
