package com.transsion.publish.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.api.AudioEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b0 extends RecyclerView.Adapter {
    private FrameLayout.LayoutParams b;
    private x c;
    private AudioEntity e;
    private List a = new ArrayList();
    private int d = (com.blankj.utilcode.util.y.b() - (com.blankj.utilcode.util.a0.a(3.0f) * 5)) / 4;

    public b0() {
        int i = this.d;
        this.b = new FrameLayout.LayoutParams(i, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(b0 b0Var, AudioEntity audioEntity, View view) {
        if (b0Var.k(audioEntity.getSize())) {
            fh.b.a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
            return;
        }
        if (audioEntity.getEnableSelect()) {
            Iterator it = b0Var.a.iterator();
            while (it.hasNext()) {
                ((AudioEntity) it.next()).setEnableSelect(false);
            }
            audioEntity.setPlay(false);
            b0Var.e = null;
            b0Var.notifyDataSetChanged();
            return;
        }
        Iterator it2 = b0Var.a.iterator();
        while (it2.hasNext()) {
            ((AudioEntity) it2.next()).setEnableSelect(false);
        }
        audioEntity.setPlay(true);
        audioEntity.setEnableSelect(true);
        b0Var.e = audioEntity;
        x xVar = b0Var.c;
        if (xVar != null) {
            xVar.a(audioEntity);
        }
        b0Var.notifyDataSetChanged();
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

    public final List h() {
        return this.a;
    }

    public final AudioEntity i() {
        return this.e;
    }

    public final String j(long j) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(j));
        BigDecimal bigDecimal2 = new BigDecimal("1024");
        double doubleValue = bigDecimal.divide(bigDecimal2, 1, 1).doubleValue();
        if (doubleValue < 1024.0d) {
            return doubleValue + "KB";
        }
        String bigDecimal3 = new BigDecimal(doubleValue).divide(bigDecimal2, 1, 1).toString();
        Intrinsics.g(bigDecimal3, "toString(...)");
        return bigDecimal3 + AppInstalledBean.APP_INSTALLED_BEAN_SOURCE_MB;
    }

    public final boolean k(long j) {
        long j2 = 1024;
        long j3 = j / j2;
        return j3 >= 1024 && j3 / j2 >= 50;
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c0 c0Var, int i) {
        Intrinsics.h(c0Var, "holder");
        final AudioEntity audioEntity = (AudioEntity) this.a.get(i);
        c0Var.i().setText(audioEntity.getImageTitle());
        TextView g = c0Var.g();
        String j = j(audioEntity.getSize());
        Long duration = audioEntity.getDuration();
        g.setText(j + " " + TimeUtilKt.p((duration != null ? duration.longValue() : 0L) / 1000));
        ((RecyclerView.a0) c0Var).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b0.m(b0.this, audioEntity, view);
            }
        });
        if (audioEntity.getEnableSelect()) {
            c0Var.h().setVisibility(0);
        } else {
            c0Var.h().setVisibility(8);
        }
        if (audioEntity.getPlay()) {
            c0Var.f().setImageResource(R$drawable.ic_audio_pause);
        } else {
            c0Var.f().setImageResource(R$drawable.ic_audio_play);
        }
        if (!k(audioEntity.getSize())) {
            c0Var.j().setVisibility(8);
        } else {
            c0Var.j().getBackground().mutate().setAlpha(178);
            c0Var.j().setVisibility(0);
        }
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public c0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_select_music, viewGroup, false);
        Intrinsics.e(inflate);
        return new c0(inflate);
    }

    public final void o() {
        List<AudioEntity> list = this.a;
        if (list != null) {
            for (AudioEntity audioEntity : list) {
                if (audioEntity.getPlay()) {
                    audioEntity.setPlay(false);
                }
            }
        }
        notifyDataSetChanged();
    }

    public final void p(x xVar) {
        Intrinsics.h(xVar, "selectItemClickListener");
        this.c = xVar;
    }
}
