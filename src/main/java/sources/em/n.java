package em;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.MemberTaskItem;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n extends BaseItemProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(MemberTaskItem memberTaskItem, View view) {
        String groupUrl = memberTaskItem.getGroupUrl();
        if (groupUrl != null) {
            com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.a;
            HashMap hashMap = new HashMap();
            hashMap.put("event_detail", "task_title_right");
            hashMap.put("group_name", String.valueOf(memberTaskItem.getGroupName()));
            hashMap.put("group_title", String.valueOf(memberTaskItem.getTitle()));
            Unit unit = Unit.a;
            aVar.b("memberdetail", hashMap);
            if (StringsKt.W(groupUrl, "http://", false, 2, (Object) null) || StringsKt.W(groupUrl, "https://", false, 2, (Object) null)) {
                ij.k.p(TheRouter.c("/web/web").K("url", groupUrl));
            } else {
                ij.k.h(groupUrl, null, 1, null);
            }
        }
    }

    private final int B() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? 8388613 : 8388611;
    }

    public int l() {
        return TaskType.TITLE.getValue();
    }

    public int m() {
        return R$layout.item_task_title;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final MemberTaskItem memberTaskItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(memberTaskItem, "item");
        TextView textView = (TextView) baseViewHolder.getView(R$id.member_item_task_title);
        textView.setText(memberTaskItem.getTitle());
        textView.setGravity(B());
        String groupUrl = memberTaskItem.getGroupUrl();
        if (groupUrl == null || groupUrl.length() == 0) {
            baseViewHolder.setGone(R$id.member_item_task_title_right, true);
        } else {
            baseViewHolder.setGone(R$id.member_item_task_title_right, false);
            baseViewHolder.getView(R$id.member_item_task_title_right).setOnClickListener(new View.OnClickListener() { // from class: em.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.A(MemberTaskItem.this, view);
                }
            });
        }
    }
}
