package oq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.transsion.share.R$id;
import com.transsion.share.R$layout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends RecyclerView.Adapter {
    private List a;
    private oq.a b;

    public static final class a extends RecyclerView.a0 {
        private TextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.h(view, "view");
            View findViewById = ((RecyclerView.a0) this).itemView.findViewById(R$id.tv_share);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.a = (TextView) findViewById;
        }

        public final TextView f() {
            return this.a;
        }
    }

    public c(List list) {
        Intrinsics.h(list, "mDatas");
        this.a = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(c cVar, nq.a aVar, View view) {
        oq.a aVar2;
        if (o.e(o.a, view.hashCode(), 0L, 2, null) || (aVar2 = cVar.b) == null) {
            return;
        }
        aVar2.a(aVar);
    }

    public int getItemCount() {
        return this.a.size();
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        Intrinsics.h(aVar, "holder");
        RecyclerView.n layoutParams = ((RecyclerView.a0) aVar).itemView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.n nVar = layoutParams;
        int e = (y.e() - a0.a(286.0f)) / 4;
        if (i == 0) {
            nVar.setMarginStart(a0.a(16.0f));
            nVar.setMarginEnd(e);
        } else if (i == getItemCount() - 1) {
            nVar.setMarginStart(0);
            nVar.setMarginEnd(a0.a(16.0f));
        } else {
            nVar.setMarginStart(0);
            nVar.setMarginEnd(e);
        }
        final nq.a aVar2 = (nq.a) this.a.get(i);
        aVar.f().setText(aVar2.b());
        aVar.f().setCompoundDrawablesRelativeWithIntrinsicBounds(0, aVar2.a(), 0, 0);
        ((RecyclerView.a0) aVar).itemView.setOnClickListener(new View.OnClickListener() { // from class: oq.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.i(c.this, aVar2, view);
            }
        });
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.adapter_share, viewGroup, false);
        Intrinsics.e(inflate);
        return new a(inflate);
    }

    public final void k(oq.a aVar) {
        Intrinsics.h(aVar, "onItemClickListener");
        this.b = aVar;
    }
}
