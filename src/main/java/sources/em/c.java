package em;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.c0;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.MemberViewModel;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.member.constants.TaskType;
import com.transsion.member.view.CheckInView;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemCheckInInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import fh.b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider {
    private final u e;
    private final MemberViewModel f;
    private boolean g;

    public static final class a implements CheckInView.d {
        final /* synthetic */ MemberTaskItem a;
        final /* synthetic */ c b;
        final /* synthetic */ CheckInView c;

        a(MemberTaskItem memberTaskItem, c cVar, CheckInView checkInView) {
            this.a = memberTaskItem;
            this.b = cVar;
            this.c = checkInView;
        }

        @Override // com.transsion.member.view.CheckInView.d
        public void a(CheckInView.b bVar, int i) {
            Intrinsics.h(bVar, "holder");
            List<MemberTaskItemCheckInInfo> checkInList = this.a.getCheckInList();
            List<MemberTaskItemCheckInInfo> list = checkInList;
            if (list == null || list.isEmpty()) {
                return;
            }
            ImageView imageView = (ImageView) ((RecyclerView.a0) bVar).itemView.findViewById(R$id.tag_iv);
            TextView textView = (TextView) ((RecyclerView.a0) bVar).itemView.findViewById(R$id.member_point);
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList.get(i);
            if (textView != null) {
                textView.setText("+" + memberTaskItemCheckInInfo.getRewardAmount() + (memberTaskItemCheckInInfo.getRewardType() == 1 ? "days" : BuildConfig.FLAVOR));
            }
            if (bVar.f() == 2 || bVar.f() == 5) {
                if (memberTaskItemCheckInInfo.isToday() && this.b.g) {
                    View findViewById = ((RecyclerView.a0) bVar).itemView.findViewById(R$id.member_check_in_tv);
                    if (findViewById != null) {
                        uf.c.g(findViewById);
                    }
                    View findViewById2 = ((RecyclerView.a0) bVar).itemView.findViewById(R$id.member_check_in_pb);
                    if (findViewById2 != null) {
                        uf.c.k(findViewById2);
                    }
                } else {
                    View findViewById3 = ((RecyclerView.a0) bVar).itemView.findViewById(R$id.member_check_in_tv);
                    if (findViewById3 != null) {
                        uf.c.k(findViewById3);
                    }
                    View findViewById4 = ((RecyclerView.a0) bVar).itemView.findViewById(R$id.member_check_in_pb);
                    if (findViewById4 != null) {
                        uf.c.g(findViewById4);
                    }
                }
            }
            if (imageView != null) {
                imageView.setImageResource(memberTaskItemCheckInInfo.getRewardType() == 1 ? R$mipmap.ic_member_small : R$mipmap.ic_member_points);
            }
            TextView textView2 = (TextView) ((RecyclerView.a0) bVar).itemView.findViewById(R$id.member_check_in);
            if (textView2 != null) {
                textView2.setText((bVar.f() == 5 || bVar.f() == 2) ? this.c.getContext().getString(R$string.member_claim) : this.c.getContext().getString(R$string.member_task_day_tip, Integer.valueOf(i + 1)));
            }
        }

        @Override // com.transsion.member.view.CheckInView.d
        public int b(int i) {
            List<MemberTaskItemCheckInInfo> checkInList = this.a.getCheckInList();
            List<MemberTaskItemCheckInInfo> list = checkInList;
            if (list == null || list.isEmpty()) {
                return 2;
            }
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList.get(i);
            boolean z = i == checkInList.size() - 1;
            return !memberTaskItemCheckInInfo.getHasCheckIn() ? memberTaskItemCheckInInfo.isToday() ? z ? 5 : 2 : z ? 6 : 3 : z ? 4 : 1;
        }
    }

    static final class b implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public c(u uVar, MemberViewModel memberViewModel) {
        Intrinsics.h(uVar, "owner");
        Intrinsics.h(memberViewModel, "viewModel");
        this.e = uVar;
        this.f = memberViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit C(CheckInView checkInView, MemberTaskItem memberTaskItem, c cVar, int i, int i2) {
        if (i2 == 2 || i2 == 5) {
            if (com.transsion.baseui.util.c.a.a(checkInView.getId(), 2000L)) {
                return Unit.a;
            }
            try {
                Result.Companion companion = Result.Companion;
                List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
                List<MemberTaskItemCheckInInfo> list = checkInList;
                if (list != null && !list.isEmpty()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("event_detail", "task_check_in_item");
                    linkedHashMap.put("index", String.valueOf(i));
                    Unit unit = Unit.a;
                    cVar.F(memberTaskItem, linkedHashMap);
                    MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList.get(i);
                    if (memberTaskItemCheckInInfo.getHasCheckIn() || !memberTaskItemCheckInInfo.isToday()) {
                        checkInView.notifyItemCheckInStateChange(i);
                    } else {
                        cVar.g = true;
                        checkInView.notifyItemCheckInStateChange(i);
                        cVar.f.M(i);
                    }
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit D(c cVar, MemberTaskItem memberTaskItem, CheckInView checkInView, Pair pair) {
        Object obj;
        if (!cVar.g) {
            return Unit.a;
        }
        cVar.g = false;
        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
        if (checkInList == null || checkInList.isEmpty()) {
            return Unit.a;
        }
        int intValue = ((Number) pair.getFirst()).intValue();
        MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes = (MemberTaskSubmitCheckInRes) pair.getSecond();
        if (memberTaskSubmitCheckInRes != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("event_detail", "task_check_in_item_success");
            linkedHashMap.put("index", String.valueOf(intValue));
            Unit unit = Unit.a;
            cVar.F(memberTaskItem, linkedHashMap);
            List<MemberTaskItemCheckInInfo> checkInList2 = memberTaskItem.getCheckInList();
            if (checkInList2 != null) {
                Iterator<T> it = checkInList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((MemberTaskItemCheckInInfo) obj).isToday()) {
                        break;
                    }
                }
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) obj;
                if (memberTaskItemCheckInInfo != null) {
                    memberTaskItemCheckInInfo.setHasCheckIn(true);
                }
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = checkInView.getContext().getString(memberTaskSubmitCheckInRes.getRewardType() == 1 ? R$string.member_claimed_succeed_days : R$string.member_reward_points_receive_tips);
            Intrinsics.g(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(memberTaskSubmitCheckInRes.getRewardAmount())}, 1));
            Intrinsics.g(format, "format(...)");
            cVar.G(format);
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("event_detail", "task_check_in_item_fail");
            linkedHashMap2.put("index", String.valueOf(intValue));
            Unit unit2 = Unit.a;
            cVar.F(memberTaskItem, linkedHashMap2);
            String string2 = checkInView.getContext().getString(R$string.member_reward_receive_fault_tips);
            Intrinsics.g(string2, "getString(...)");
            cVar.G(string2);
        }
        checkInView.notifyItemCheckInStateChange(intValue);
        return Unit.a;
    }

    private final void E(MemberTaskItem memberTaskItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_browse");
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
        Object obj = null;
        if (checkInList != null) {
            Iterator<T> it = checkInList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) next;
                if (memberTaskItemCheckInInfo.isToday() && !memberTaskItemCheckInInfo.getHasCheckIn()) {
                    obj = next;
                    break;
                }
            }
            obj = (MemberTaskItemCheckInInfo) obj;
        }
        hashMap.put("showClaim", String.valueOf(obj == null));
        com.transsion.baselib.helper.a.a.a("memberdetail", hashMap);
    }

    private final void F(MemberTaskItem memberTaskItem, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_click");
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
        Object obj = null;
        if (checkInList != null) {
            Iterator<T> it = checkInList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) next;
                if (memberTaskItemCheckInInfo.isToday() && !memberTaskItemCheckInInfo.getHasCheckIn()) {
                    obj = next;
                    break;
                }
            }
            obj = (MemberTaskItemCheckInInfo) obj;
        }
        hashMap.put("showClaim", String.valueOf(obj == null));
        hashMap.putAll(map);
        com.transsion.baselib.helper.a.a.b("memberdetail", hashMap);
    }

    private final void G(String str) {
        b.a.h(fh.b.a, R$layout.claim_succeed_layout, str, 80, 0, a0.a(66.0f), 8, (Object) null);
    }

    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final MemberTaskItem memberTaskItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(memberTaskItem, "item");
        E(memberTaskItem);
        final CheckInView checkInView = (CheckInView) baseViewHolder.getView(R$id.member_check_in_view);
        checkInView.setDataViewBinder(new a(memberTaskItem, this, checkInView));
        checkInView.setItemClicker(new Function2() { // from class: em.a
            public final Object invoke(Object obj, Object obj2) {
                Unit C;
                C = c.C(CheckInView.this, memberTaskItem, this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return C;
            }
        });
        checkInView.notifyAllChange();
        this.f.B().j(this.e, new b(new Function1() { // from class: em.b
            public final Object invoke(Object obj) {
                Unit D;
                D = c.D(c.this, memberTaskItem, checkInView, (Pair) obj);
                return D;
            }
        }));
    }

    public int l() {
        return TaskType.CHECK_IN.getValue();
    }

    public int m() {
        return R$layout.item_task_check_in_container;
    }
}
