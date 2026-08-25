package com.transsnet.login.interest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.R$mipmap;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f extends RecyclerView.Adapter {
    private final List a;
    private final Function1 b;
    private final ArrayList c;
    private final ArrayList d;

    public static final class a extends RecyclerView.a0 {
        private final AppCompatTextView a;
        private final AppCompatImageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.h(view, "view");
            AppCompatTextView findViewById = view.findViewById(R$id.tv_interest);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.a = findViewById;
            AppCompatImageView findViewById2 = view.findViewById(R$id.iv_interest);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.b = findViewById2;
        }

        public final AppCompatImageView f() {
            return this.b;
        }

        public final AppCompatTextView g() {
            return this.a;
        }
    }

    public f(List dataList, Function1 listener) {
        Intrinsics.h(dataList, "dataList");
        Intrinsics.h(listener, "listener");
        this.a = dataList;
        this.b = listener;
        this.c = new ArrayList();
        this.d = CollectionsKt.h(new Integer[]{Integer.valueOf(R$mipmap.login_interest_animal_plant), Integer.valueOf(R$mipmap.login_interest_sport), Integer.valueOf(R$mipmap.login_interest_food), Integer.valueOf(R$mipmap.login_interest_game), Integer.valueOf(R$mipmap.login_interest_transportation), Integer.valueOf(R$mipmap.login_interest_fitness), Integer.valueOf(R$mipmap.login_interest_music), Integer.valueOf(R$mipmap.login_interest_animation), Integer.valueOf(R$mipmap.login_interest_art), Integer.valueOf(R$mipmap.login_interest_travel), Integer.valueOf(R$mipmap.login_interest_comedy), Integer.valueOf(R$mipmap.login_interest_fashion)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(f fVar, int i, View view) {
        boolean isSelected = view.isSelected();
        boolean z = !isSelected;
        if (isSelected) {
            fVar.c.remove(Integer.valueOf(i));
        } else {
            fVar.c.add(Integer.valueOf(i));
        }
        view.setSelected(z);
        fVar.b.invoke(fVar.c);
    }

    public int getItemCount() {
        return this.a.size();
    }

    public final List h() {
        return this.c;
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, final int i) {
        Intrinsics.h(holder, "holder");
        holder.g().setText((String) this.a.get(i));
        AppCompatImageView f = holder.f();
        Object obj = this.d.get(i);
        Intrinsics.g(obj, "get(...)");
        f.setImageResource(((Number) obj).intValue());
        ((RecyclerView.a0) holder).itemView.setSelected(this.c.contains(Integer.valueOf(i)));
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.interest.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.j(f.this, i, view);
            }
        });
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.login_item_interest, parent, false);
        Intrinsics.g(inflate, "inflate(...)");
        return new a(inflate);
    }
}
