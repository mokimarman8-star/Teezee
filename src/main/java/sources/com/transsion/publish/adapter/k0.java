package com.transsion.publish.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.ui.VideoPreviewActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k0 extends RecyclerView.Adapter {
    private final Function1 a;
    private List b;
    private FrameLayout.LayoutParams c;
    private List d;
    private int e;
    private int f;
    private int g;
    private int h;

    public k0(Function1 function1) {
        Intrinsics.h(function1, "selectItem");
        this.a = function1;
        this.b = new ArrayList();
        this.d = new ArrayList();
        this.e = 1;
        this.f = 52428800;
        this.g = 1200000;
        this.h = 3000;
        int b = (com.blankj.utilcode.util.y.b() - (com.blankj.utilcode.util.a0.a(3.0f) * 5)) / 4;
        this.c = new FrameLayout.LayoutParams(b, b);
    }

    private final void k(m0 m0Var, Function0 function0) {
        if (!n() || m0Var.g().getVisibility() != 0) {
            function0.invoke();
            return;
        }
        String string = Utils.a().getString(R$string.add_video_max_tips);
        Intrinsics.g(string, "getString(...)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.e)}, 1));
        Intrinsics.g(format, "format(...)");
        com.tn.lib.widget.toast.core.h.a.l(format);
    }

    private final String l(VsMediaInfo vsMediaInfo) {
        int i = 0;
        for (Object obj : this.d) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            if (Intrinsics.c(vsMediaInfo.getVideoPath(), ((VsMediaInfo) obj).getVideoPath())) {
                return String.valueOf(i2);
            }
            i = i2;
        }
        return "-1";
    }

    private final boolean n() {
        return this.d.size() >= this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(boolean z, boolean z2, boolean z3, k0 k0Var, final m0 m0Var, final VsMediaInfo vsMediaInfo, View view) {
        Intrinsics.h(view, "it");
        if (z) {
            fh.b.a.e("Exceeded video length, 20 mins Max");
            return Unit.a;
        }
        if (z2) {
            fh.b.a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
            return Unit.a;
        }
        if (z3) {
            fh.b.a.e("video requires at least 3s");
            return Unit.a;
        }
        k0Var.k(m0Var, new Function0() { // from class: com.transsion.publish.adapter.j0
            public final Object invoke() {
                Unit r;
                r = k0.r(m0.this, vsMediaInfo);
                return r;
            }
        });
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(m0 m0Var, VsMediaInfo vsMediaInfo) {
        VideoPreviewActivity.Companion companion = VideoPreviewActivity.INSTANCE;
        Context context = ((RecyclerView.a0) m0Var).itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        companion.a(context, vsMediaInfo, 2);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(boolean z, boolean z2, boolean z3, final k0 k0Var, m0 m0Var, final VsMediaInfo vsMediaInfo, View view) {
        Intrinsics.h(view, "it");
        if (z) {
            fh.b.a.e("Exceeded video length, 20 mins Max");
            return Unit.a;
        }
        if (z2) {
            fh.b.a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
            return Unit.a;
        }
        if (z3) {
            fh.b.a.e("video requires at least 3s");
            return Unit.a;
        }
        k0Var.k(m0Var, new Function0() { // from class: com.transsion.publish.adapter.i0
            public final Object invoke() {
                Unit t;
                t = k0.t(VsMediaInfo.this, k0Var);
                return t;
            }
        });
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(VsMediaInfo vsMediaInfo, k0 k0Var) {
        if (vsMediaInfo.getEnableSelect()) {
            k0Var.z(vsMediaInfo);
        } else {
            k0Var.y(vsMediaInfo);
        }
        return Unit.a;
    }

    private final void v(TextView textView, long j) {
        if (j == 0) {
            return;
        }
        if (2001 <= j && j < 3000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{0, 2}, 2));
            Intrinsics.g(format, "format(...)");
            String format2 = String.format(format, Arrays.copyOf(new Object[0], 0));
            Intrinsics.g(format2, "format(...)");
            textView.setText(format2);
            return;
        }
        if (4001 <= j && j < 5000) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
            String format3 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{0, 4}, 2));
            Intrinsics.g(format3, "format(...)");
            String format4 = String.format(format3, Arrays.copyOf(new Object[0], 0));
            Intrinsics.g(format4, "format(...)");
            textView.setText(format4);
            return;
        }
        int d = MathKt.d(j / 1000);
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.a;
        String format5 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(d / 60), Integer.valueOf(d % 60)}, 2));
        Intrinsics.g(format5, "format(...)");
        String format6 = String.format(format5, Arrays.copyOf(new Object[0], 0));
        Intrinsics.g(format6, "format(...)");
        textView.setText(format6);
    }

    private final void w(VsMediaInfo vsMediaInfo) {
        VsMediaInfo vsMediaInfo2 = null;
        for (VsMediaInfo vsMediaInfo3 : this.d) {
            if (TextUtils.equals(vsMediaInfo3.getVideoPath(), vsMediaInfo.getVideoPath())) {
                vsMediaInfo2 = vsMediaInfo3;
            }
        }
        if (this.d.contains(vsMediaInfo)) {
            this.d.remove(vsMediaInfo);
        }
        if (vsMediaInfo2 != null) {
            this.d.remove(vsMediaInfo2);
        }
    }

    private final void y(VsMediaInfo vsMediaInfo) {
        w(vsMediaInfo);
        this.d.add(vsMediaInfo);
        this.a.invoke(Integer.valueOf(this.d.size()));
        vsMediaInfo.setEnableSelect(true);
        int indexOf = this.b.indexOf(vsMediaInfo);
        if (indexOf >= 0) {
            notifyItemChanged(indexOf, Boolean.TRUE);
        }
        if (n()) {
            notifyDataSetChanged();
        }
    }

    private final void z(VsMediaInfo vsMediaInfo) {
        boolean n = n();
        w(vsMediaInfo);
        this.a.invoke(Integer.valueOf(this.d.size()));
        vsMediaInfo.setEnableSelect(false);
        int indexOf = this.b.indexOf(vsMediaInfo);
        if (indexOf >= 0) {
            notifyItemChanged(indexOf, Boolean.FALSE);
        }
        if (n) {
            notifyDataSetChanged();
        }
    }

    public final void addData(List list) {
        Intrinsics.h(list, "data");
        int size = this.b.size();
        this.b.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    public int getItemCount() {
        return this.b.size();
    }

    public final List m() {
        return this.d;
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final m0 m0Var, int i) {
        Intrinsics.h(m0Var, "holder");
        final VsMediaInfo vsMediaInfo = (VsMediaInfo) this.b.get(i);
        ((RecyclerView.a0) m0Var).itemView.setLayoutParams(this.c);
        v(m0Var.i(), vsMediaInfo.getVideoDuration());
        if (TextUtils.isEmpty(vsMediaInfo.getImagePath())) {
            String videoPath = vsMediaInfo.getVideoPath();
            File file = videoPath != null ? new File(videoPath) : null;
            if (file != null) {
                f.a aVar = ni.f.a;
                Context context = m0Var.f().getContext();
                Intrinsics.g(context, "getContext(...)");
                aVar.m(context).g(Uri.fromFile(file).toString()).i(R.mipmap.home_ic_default_res).d(m0Var.f());
            }
        } else {
            f.a aVar2 = ni.f.a;
            Context context2 = m0Var.f().getContext();
            Intrinsics.g(context2, "getContext(...)");
            aVar2.m(context2).g(vsMediaInfo.getImagePath()).i(R.mipmap.home_ic_default_res).d(m0Var.f());
        }
        boolean z = vsMediaInfo.getVideoSize() >= ((long) this.f);
        boolean z2 = vsMediaInfo.getVideoDuration() >= ((long) this.g);
        boolean z3 = vsMediaInfo.getVideoDuration() < ((long) this.h);
        if (!n()) {
            m0Var.g().setVisibility(8);
            if (vsMediaInfo.getEnableSelect()) {
                m0Var.j().setText(l(vsMediaInfo));
                m0Var.j().setBackgroundResource(R$drawable.bg_linear_r16);
            } else {
                m0Var.j().setText(BuildConfig.FLAVOR);
                m0Var.j().setBackgroundResource(R$drawable.ic_select_number_bro);
            }
        } else if (vsMediaInfo.getEnableSelect()) {
            m0Var.g().setVisibility(8);
            m0Var.j().setText(l(vsMediaInfo));
            m0Var.j().setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            m0Var.g().setVisibility(0);
            m0Var.j().setText(BuildConfig.FLAVOR);
            m0Var.j().setBackgroundResource(R$drawable.ic_select_number_bro);
        }
        if (z || z2 || z3) {
            m0Var.g().setVisibility(0);
        }
        View view = ((RecyclerView.a0) m0Var).itemView;
        Intrinsics.g(view, "itemView");
        final boolean z4 = z2;
        final boolean z5 = z;
        final boolean z6 = z3;
        uf.c.c(view, 0L, new Function1() { // from class: com.transsion.publish.adapter.g0
            public final Object invoke(Object obj) {
                Unit q;
                q = k0.q(z4, z5, z6, this, m0Var, vsMediaInfo, (View) obj);
                return q;
            }
        }, 1, (Object) null);
        uf.c.c(m0Var.h(), 0L, new Function1() { // from class: com.transsion.publish.adapter.h0
            public final Object invoke(Object obj) {
                Unit s;
                s = k0.s(z4, z5, z6, this, m0Var, vsMediaInfo, (View) obj);
                return s;
            }
        }, 1, (Object) null);
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(m0 m0Var, int i, List list) {
        Intrinsics.h(m0Var, "holder");
        Intrinsics.h(list, "payloads");
        if (!(CollectionsKt.k0(list) instanceof Boolean)) {
            super.onBindViewHolder(m0Var, i, list);
            return;
        }
        VsMediaInfo vsMediaInfo = (VsMediaInfo) this.b.get(i);
        if (vsMediaInfo.getEnableSelect()) {
            m0Var.j().setText(l(vsMediaInfo));
            m0Var.j().setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            m0Var.j().setText(BuildConfig.FLAVOR);
            m0Var.j().setBackgroundResource(R$drawable.ic_select_number_bro);
        }
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public m0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.upload_select_video_item, (ViewGroup) null);
        Intrinsics.e(inflate);
        return new m0(inflate);
    }

    public final void x(VsMediaInfo vsMediaInfo) {
        Intrinsics.h(vsMediaInfo, "data");
        VsMediaInfo vsMediaInfo2 = vsMediaInfo;
        for (VsMediaInfo vsMediaInfo3 : this.b) {
            if (TextUtils.equals(vsMediaInfo3.getVideoPath(), vsMediaInfo.getVideoPath())) {
                vsMediaInfo3.setEnableSelect(vsMediaInfo.getEnableSelect());
                vsMediaInfo2 = vsMediaInfo3;
            }
        }
        if (vsMediaInfo.getEnableSelect()) {
            y(vsMediaInfo2);
        } else {
            z(vsMediaInfo2);
        }
        notifyItemRangeChanged(0, this.b.size(), Boolean.TRUE);
    }
}
