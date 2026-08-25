package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.operation.OperationBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends RecyclerView.Adapter {
    private List a = new ArrayList();
    private a b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e eVar, OperationBean operationBean, int i, View view) {
        a aVar = eVar.b;
        if (aVar != null) {
            aVar.a(operationBean, i);
        }
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

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(f fVar, final int i) {
        Intrinsics.h(fVar, "holder");
        final OperationBean operationBean = (OperationBean) this.a.get(i);
        if (operationBean.getStatus()) {
            fVar.f().setImageResource(operationBean.getEnable());
        } else {
            fVar.f().setImageResource(operationBean.getDisable());
        }
        fVar.g().setOnClickListener(new View.OnClickListener() { // from class: so.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.j(e.this, operationBean, i, view);
            }
        });
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_operation_layout, viewGroup, false);
        Intrinsics.e(inflate);
        return new f(inflate);
    }

    public final void l(a aVar) {
        Intrinsics.h(aVar, "itemClick");
        this.b = aVar;
    }
}
