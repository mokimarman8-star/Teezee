package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.publish.R$color;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.view.operation.OperationBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i extends RecyclerView.Adapter {
    private List a = new ArrayList();
    private b b;
    private Map c;

    public i() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.c = linkedHashMap;
        linkedHashMap.put(String.valueOf(R$drawable.ic_film_photos), Integer.valueOf(R$string.photo));
        this.c.put(String.valueOf(R$drawable.ic_film_videos), Integer.valueOf(R$string.video));
        this.c.put(String.valueOf(R$drawable.ic_film_audio), Integer.valueOf(R$string.audio));
        this.c.put(String.valueOf(R$drawable.ic_film_work), Integer.valueOf(R$string.mention_a_specific_movie_audio));
        this.c.put(String.valueOf(R$drawable.ic_film_link), Integer.valueOf(R$string.add_a_link));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(i iVar, OperationBean operationBean, int i, View view) {
        b bVar = iVar.b;
        if (bVar != null) {
            bVar.a(operationBean, i);
        }
    }

    public int getItemCount() {
        return this.a.size();
    }

    public final List h() {
        return this.a;
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(g gVar, final int i) {
        Intrinsics.h(gVar, "holder");
        final OperationBean operationBean = (OperationBean) this.a.get(i);
        if (operationBean.getStatus()) {
            gVar.g().setImageResource(operationBean.getEnable());
            gVar.f().setTextColor(com.blankj.utilcode.util.h.a(R$color.color_ff333333));
        } else {
            gVar.g().setImageResource(operationBean.getDisable());
            gVar.f().setTextColor(com.blankj.utilcode.util.h.a(R$color.color_ff999999));
        }
        TnTextView f = gVar.f();
        Integer num = (Integer) this.c.get(String.valueOf(operationBean.getEnable()));
        f.setTextById(num != null ? num.intValue() : 0);
        gVar.h().setOnClickListener(new View.OnClickListener() { // from class: so.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.j(i.this, operationBean, i, view);
            }
        });
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public g onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_operation_vertical_layout, viewGroup, false);
        Intrinsics.e(inflate);
        return new g(inflate);
    }

    public final void l(b bVar) {
        Intrinsics.h(bVar, "itemClick");
        this.b = bVar;
    }

    public final void setData(List list) {
        Intrinsics.h(list, "data");
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }
}
