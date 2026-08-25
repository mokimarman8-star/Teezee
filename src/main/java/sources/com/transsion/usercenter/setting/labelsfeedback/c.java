package com.transsion.usercenter.setting.labelsfeedback;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.baseui.R;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsion.usercenter.setting.labelsfeedback.model.FbOption;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import xu.d0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c extends RecyclerView.Adapter {
    private final FbDataModel a;
    private d b;
    private nv.a c;

    public final class a extends RecyclerView.a0 {
        private final ConstraintLayout a;
        private final AppCompatTextView b;
        private final AppCompatCheckBox c;
        private final View d;
        private final View e;
        final /* synthetic */ c f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, d0 binding) {
            super(binding.getRoot());
            Intrinsics.h(binding, "binding");
            this.f = cVar;
            ConstraintLayout root = binding.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            this.a = root;
            AppCompatTextView textView = binding.e;
            Intrinsics.g(textView, "textView");
            this.b = textView;
            AppCompatCheckBox radioButton = binding.d;
            Intrinsics.g(radioButton, "radioButton");
            this.c = radioButton;
            View bgView = binding.b;
            Intrinsics.g(bgView, "bgView");
            this.d = bgView;
            View divider = binding.c;
            Intrinsics.g(divider, "divider");
            this.e = divider;
        }

        public final View f() {
            return this.d;
        }

        public final View g() {
            return this.e;
        }

        public final AppCompatCheckBox h() {
            return this.c;
        }

        public final AppCompatTextView i() {
            return this.b;
        }
    }

    public c(FbDataModel model) {
        Intrinsics.h(model, "model");
        this.a = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i, c cVar, View view) {
        Set h = SetsKt.h(Integer.valueOf(i));
        Integer selectedIndex = cVar.a.getSelectedIndex();
        if (selectedIndex != null) {
            h.add(Integer.valueOf(selectedIndex.intValue()));
        }
        FbDataModel fbDataModel = cVar.a;
        Integer selectedIndex2 = fbDataModel.getSelectedIndex();
        fbDataModel.setSelectedIndex((selectedIndex2 != null && selectedIndex2.intValue() == i) ? null : Integer.valueOf(i));
        Iterator it = h.iterator();
        while (it.hasNext()) {
            cVar.notifyItemChanged(((Number) it.next()).intValue());
        }
        cVar.a.setSelectedId(null);
        Integer selectedIndex3 = cVar.a.getSelectedIndex();
        if (selectedIndex3 != null) {
            int intValue = selectedIndex3.intValue();
            FbDataModel fbDataModel2 = cVar.a;
            fbDataModel2.setSelectedId(Integer.valueOf(fbDataModel2.getOptions().get(intValue).getId()));
        }
        d dVar = cVar.b;
        if (dVar != null) {
            dVar.k(cVar);
        }
    }

    public int getItemCount() {
        return this.a.getOptions().size();
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, final int i) {
        int i2;
        Intrinsics.h(holder, "holder");
        FbOption fbOption = this.a.getOptions().get(i);
        Integer selectedIndex = this.a.getSelectedIndex();
        boolean z = selectedIndex != null && selectedIndex.intValue() == i;
        holder.i().setText(fbOption.getName());
        holder.h().setChecked(z);
        View f = holder.f();
        if (i == 0) {
            uf.c.g(holder.g());
            i2 = R.drawable.bg_radius_top_6_color_white_6p;
        } else {
            i2 = i == this.a.getOptions().size() - 1 ? R.drawable.bg_radius_bottom_6_color_white_6p : com.tn.lib.widget.R.color.white_6;
        }
        f.setBackgroundResource(i2);
        holder.i().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.i(i, this, view);
            }
        });
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.h(parent, "parent");
        d0 c = d0.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.g(c, "inflate(...)");
        return new a(this, c);
    }

    public final void k(nv.a aVar) {
        this.c = aVar;
    }

    public final void l(d dVar) {
        this.b = dVar;
    }
}
