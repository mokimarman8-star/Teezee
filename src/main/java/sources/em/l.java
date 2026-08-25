package em;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.c0;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.MemberFragment;
import com.transsion.member.MemberViewModel;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.member.bean.request.MemberInviteUserShareInfo;
import com.transsion.member.constants.TaskType;
import com.transsion.member.view.InviteUserView;
import com.transsion.memberapi.MemberTaskInviteRewards;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemInvite;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.web.share.WebShareDialog;
import fh.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l extends BaseItemProvider {
    private final MemberFragment e;
    private final MemberViewModel f;
    private boolean g;
    private final qx.a h;
    private boolean i;
    private Integer j;
    private final androidx.activity.result.b k;

    public static final class a implements InviteUserView.c {
        final /* synthetic */ InviteUserView b;

        a(InviteUserView inviteUserView) {
            this.b = inviteUserView;
        }

        @Override // com.transsion.member.view.InviteUserView.c
        public void a() {
            MemberViewModel S = l.this.S();
            Integer num = l.this.j;
            S.K(num != null ? num.intValue() : 0, 15);
        }

        @Override // com.transsion.member.view.InviteUserView.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(InviteUserView.e eVar, int i, MemberTaskItemInvite memberTaskItemInvite) {
            TextView textView;
            Intrinsics.h(eVar, "holder");
            Intrinsics.h(memberTaskItemInvite, "data");
            ImageView imageView = (ImageView) ((RecyclerView.a0) eVar).itemView.findViewById(R$id.tag_iv);
            TextView textView2 = (TextView) ((RecyclerView.a0) eVar).itemView.findViewById(R$id.member_reward);
            l lVar = l.this;
            RecyclerView recyclerView = this.b;
            textView2.setText("+" + memberTaskItemInvite.getRewardAmount() + (memberTaskItemInvite.getRewardType() == 1 ? "days" : "points"));
            if (memberTaskItemInvite.getStatus() == 1 && lVar.g) {
                View findViewById = ((RecyclerView.a0) eVar).itemView.findViewById(R$id.member_invite_user_tv);
                if (findViewById != null) {
                    uf.c.g(findViewById);
                }
                View findViewById2 = ((RecyclerView.a0) eVar).itemView.findViewById(R$id.member_invite_user_pb);
                if (findViewById2 != null) {
                    uf.c.k(findViewById2);
                }
            } else {
                View findViewById3 = ((RecyclerView.a0) eVar).itemView.findViewById(R$id.member_invite_user_tv);
                if (findViewById3 != null) {
                    uf.c.k(findViewById3);
                }
                View findViewById4 = ((RecyclerView.a0) eVar).itemView.findViewById(R$id.member_invite_user_pb);
                if (findViewById4 != null) {
                    uf.c.g(findViewById4);
                }
            }
            if (memberTaskItemInvite.getStatus() == 0 && (textView = (TextView) ((RecyclerView.a0) eVar).itemView.findViewById(R$id.member_invite_user_tv)) != null) {
                textView.setText(recyclerView.getContext().getString(R$string.member_reward_friend_tips, Integer.valueOf(memberTaskItemInvite.getFriendSeq())));
            }
            imageView.setImageResource(memberTaskItemInvite.getRewardType() == 1 ? R$mipmap.ic_member_small : R$mipmap.ic_member_points);
        }

        @Override // com.transsion.member.view.InviteUserView.c
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int b(int i, MemberTaskItemInvite memberTaskItemInvite) {
            Intrinsics.h(memberTaskItemInvite, "data");
            int status = memberTaskItemInvite.getStatus();
            if (status != 0) {
                return status != 1 ? 1 : 2;
            }
            return 3;
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

    public l(MemberFragment memberFragment, MemberViewModel memberViewModel) {
        Intrinsics.h(memberFragment, "fragment");
        Intrinsics.h(memberViewModel, "viewModel");
        this.e = memberFragment;
        this.f = memberViewModel;
        this.h = (qx.a) TheRouter.d(qx.a.class, new Object[0]);
        androidx.activity.result.b registerForActivityResult = memberFragment.registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: em.d
            public final void a(Object obj) {
                l.V(l.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.k = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(TextView textView, l lVar, MemberTaskItem memberTaskItem, View view) {
        if (com.transsion.baseui.util.c.a.a(textView.getId(), 2000L)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "task_invite_user_share_dialog");
        qx.a aVar = lVar.h;
        boolean z = false;
        if (aVar != null && aVar.a()) {
            z = true;
        }
        linkedHashMap.put("is_login", String.valueOf(z));
        Unit unit = Unit.a;
        lVar.U(memberTaskItem, linkedHashMap);
        qx.a aVar2 = lVar.h;
        if (aVar2 != null && aVar2.a()) {
            lVar.i = true;
            lVar.f.L();
            return;
        }
        qx.a aVar3 = lVar.h;
        if (aVar3 != null) {
            Context context = textView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar3.k(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit K(l lVar, MemberTaskItem memberTaskItem, InviteUserView inviteUserView, TextView textView, im.e eVar) {
        boolean z;
        boolean z2;
        Object obj;
        String description;
        Object obj2;
        if (!lVar.g) {
            return Unit.a;
        }
        lVar.g = false;
        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
        if (inviteList == null || inviteList.isEmpty()) {
            return Unit.a;
        }
        int a2 = eVar.a();
        String d = eVar.d();
        int c = eVar.c();
        int e = eVar.e();
        MemberTaskRewardInfo b2 = eVar.b();
        int abs = Math.abs(a2);
        if (!Intrinsics.c(d, "0")) {
            if (a2 < 0 || b2 == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("event_detail", "task_invite_user_claim_item_fail");
                linkedHashMap.put("index", String.valueOf(a2));
                linkedHashMap.put("rewardId", d.toString());
                Unit unit = Unit.a;
                lVar.U(memberTaskItem, linkedHashMap);
                String string = lVar.k().getString(R$string.member_reward_receive_fault_tips);
                Intrinsics.g(string, "getString(...)");
                lVar.W(string);
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("event_detail", "task_invite_user_claim_item_success");
                linkedHashMap2.put("index", String.valueOf(a2));
                linkedHashMap2.put("rewardId", d.toString());
                linkedHashMap2.put("rewardRes", b2.toString());
                Unit unit2 = Unit.a;
                lVar.U(memberTaskItem, linkedHashMap2);
                List<MemberTaskItemInvite> inviteList2 = memberTaskItem.getInviteList();
                if (inviteList2 != null) {
                    Iterator<T> it = inviteList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        if (Intrinsics.c(((MemberTaskItemInvite) obj2).getRewardId(), d)) {
                            break;
                        }
                    }
                    MemberTaskItemInvite memberTaskItemInvite = (MemberTaskItemInvite) obj2;
                    if (memberTaskItemInvite != null) {
                        memberTaskItemInvite.setStatus(2);
                        List<MemberTaskItemInvite> inviteList3 = memberTaskItem.getInviteList();
                        abs = inviteList3 != null ? inviteList3.indexOf(memberTaskItemInvite) : 0;
                    }
                }
                String string2 = lVar.k().getString(e == 1 ? R$string.member_claimed_succeed_days : R$string.member_reward_points_receive_tips, Integer.valueOf(c));
                Intrinsics.g(string2, "getString(...)");
                lVar.W(string2);
            }
            inviteUserView.notifyItemInviteUserStateChange(abs);
        } else if (b2 == null) {
            String string3 = lVar.k().getString(R$string.member_reward_receive_fault_tips);
            Intrinsics.g(string3, "getString(...)");
            lVar.W(string3);
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("event_detail", "task_invite_user_claim_all_fail");
            linkedHashMap3.put("index", String.valueOf(a2));
            linkedHashMap3.put("rewardId", d.toString());
            Unit unit3 = Unit.a;
            lVar.U(memberTaskItem, linkedHashMap3);
        } else {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            linkedHashMap4.put("event_detail", "task_invite_user_claim_all_success");
            linkedHashMap4.put("index", String.valueOf(a2));
            linkedHashMap4.put("rewardId", d.toString());
            linkedHashMap4.put("rewardRes", b2.toString());
            Unit unit4 = Unit.a;
            lVar.U(memberTaskItem, linkedHashMap4);
            List<MemberTaskItemInvite> inviteList4 = memberTaskItem.getInviteList();
            if (inviteList4 != null) {
                for (MemberTaskItemInvite memberTaskItemInvite2 : inviteList4) {
                    if (memberTaskItemInvite2.getStatus() == 1) {
                        memberTaskItemInvite2.setStatus(2);
                    }
                }
            }
            String string4 = lVar.k().getString(R$string.member_claimed_succeed_days, Integer.valueOf(c));
            Intrinsics.g(string4, "getString(...)");
            lVar.W(string4);
            inviteUserView.notifyAllItemInviteUserStateChange();
        }
        if (b2 != null) {
            memberTaskItem.setRewardInfo(b2);
            if (b2.getDuration() == 0) {
                description = lVar.k().getString(R$string.member_claim_all);
                z = true;
                z2 = false;
            } else {
                try {
                    Result.Companion companion = Result.Companion;
                    Context k = lVar.k();
                    int i = R$string.task_invite_user_view_get_premium_text;
                    z = true;
                    try {
                        Object[] objArr = new Object[1];
                        z2 = false;
                        try {
                            objArr[0] = Integer.valueOf(b2.getDuration());
                            obj = Result.constructor-impl(k.getString(i, objArr));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.a(th));
                            String str = (String) (Result.isFailure-impl(obj) ? null : obj);
                            if (str == null) {
                            }
                            textView.setText(description);
                            textView.setEnabled(b2.getDuration() > 0 ? z : z2);
                            return Unit.a;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z2 = false;
                        Result.Companion companion22 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.a(th));
                        String str2 = (String) (Result.isFailure-impl(obj) ? null : obj);
                        if (str2 == null) {
                        }
                        textView.setText(description);
                        textView.setEnabled(b2.getDuration() > 0 ? z : z2);
                        return Unit.a;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = true;
                }
                String str22 = (String) (Result.isFailure-impl(obj) ? null : obj);
                description = str22 == null ? b2.getDescription() : str22;
            }
            textView.setText(description);
            textView.setEnabled(b2.getDuration() > 0 ? z : z2);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(InviteUserView inviteUserView, l lVar, MemberTaskItem memberTaskItem, MemberTaskInviteRewards memberTaskInviteRewards) {
        List<MemberTaskItemInvite> list;
        if (!inviteUserView.getIsLoadMoreLoading()) {
            return Unit.a;
        }
        if (memberTaskInviteRewards == null || (list = memberTaskInviteRewards.getList()) == null || list.isEmpty()) {
            inviteUserView.onLoadMoreCompleted(new ArrayList());
            inviteUserView.setLoadMoreEnable(false);
        } else {
            lVar.j = Integer.valueOf(memberTaskInviteRewards.getLastId());
            List<MemberTaskItemInvite> list2 = memberTaskInviteRewards.getList();
            if (list2 == null || list2.isEmpty()) {
                inviteUserView.onLoadMoreCompleted(new ArrayList());
            } else {
                List<MemberTaskItemInvite> list3 = memberTaskInviteRewards.getList();
                if (list3 != null) {
                    List<MemberTaskItemInvite> list4 = list3;
                    if (list4.isEmpty()) {
                        inviteUserView.onLoadMoreCompleted(new ArrayList());
                    } else {
                        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
                        if (inviteList != null) {
                            inviteList.addAll(list4);
                        }
                        inviteUserView.onLoadMoreCompleted(list3);
                    }
                }
            }
            if (memberTaskInviteRewards.getLastId() == 0) {
                inviteUserView.setLoadMoreEnable(false);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(final l lVar, Map map) {
        String str;
        MemberInviteUserShareInfo memberInviteUserShareInfo;
        if (lVar.i) {
            if (map.isEmpty()) {
                String string = lVar.k().getString(R.string.load_failed);
                Intrinsics.g(string, "getString(...)");
                lVar.W(string);
                return Unit.a;
            }
            JSONObject jSONObject = new JSONObject();
            Intrinsics.e(map);
            loop0: while (true) {
                str = BuildConfig.FLAVOR;
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getKey();
                    MemberInviteUserShareInfo memberInviteUserShareInfo2 = (MemberInviteUserShareInfo) entry.getValue();
                    String desc = memberInviteUserShareInfo2 != null ? memberInviteUserShareInfo2.getDesc() : null;
                    MemberInviteUserShareInfo memberInviteUserShareInfo3 = (MemberInviteUserShareInfo) entry.getValue();
                    jSONObject.put(str2, desc + ", " + (memberInviteUserShareInfo3 != null ? memberInviteUserShareInfo3.getUrl() : null));
                    if (str.length() != 0 || ((memberInviteUserShareInfo = (MemberInviteUserShareInfo) entry.getValue()) != null && (str = memberInviteUserShareInfo.getTitle()) != null)) {
                    }
                }
                break loop0;
            }
            jSONObject.put("H5Source", "fissionNative");
            if (str.length() == 0) {
                str = lVar.k().getString(R$string.member_invite_user_share_title);
                Intrinsics.g(str, "getString(...)");
            }
            jSONObject.put("title", str);
            WebShareDialog.a aVar = WebShareDialog.g;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.g(jSONObject2, "toString(...)");
            final WebShareDialog a2 = aVar.a(jSONObject2);
            a2.r0(new Function3() { // from class: em.k
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit N;
                    N = l.N(a2, lVar, (String) obj, (String) obj2, (String) obj3);
                    return N;
                }
            });
            a2.k0(lVar.k(), "WebShareDialog");
            lVar.i = !lVar.i;
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(WebShareDialog webShareDialog, l lVar, String str, String str2, String str3) {
        Object obj;
        Intrinsics.h(str, "packageName");
        Intrinsics.h(str3, "txt");
        if (str.length() == 0) {
            ClipData newPlainText = ClipData.newPlainText("MovieBox", str3);
            Context context = webShareDialog.getContext();
            ClipboardManager clipboardManager = (ClipboardManager) (context != null ? context.getSystemService("clipboard") : null);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
            com.tn.lib.widget.toast.core.h.a.k(com.transsion.web.R.string.web_copied);
        } else {
            Intent Q = lVar.Q(webShareDialog.getContext(), str3, str, str2);
            if (Q == null) {
                com.tn.lib.widget.toast.core.h.a.k(com.transsion.web.R.string.web_app_not_exist);
            } else {
                try {
                    Result.Companion companion = Result.Companion;
                    lVar.k.a(Q);
                    obj = Result.constructor-impl(Unit.a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.a(th2));
                }
                Result.box-impl(obj);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit O(InviteUserView inviteUserView, MemberTaskItem memberTaskItem, l lVar, int i, int i2) {
        if (i2 == 2) {
            if (com.transsion.baseui.util.c.a.a(inviteUserView.getId(), 2000L)) {
                return Unit.a;
            }
            try {
                Result.Companion companion = Result.Companion;
                List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
                List<MemberTaskItemInvite> list = inviteList;
                if (list != null && !list.isEmpty()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("event_detail", "task_invite_user_claim_item");
                    linkedHashMap.put("index", String.valueOf(i));
                    Unit unit = Unit.a;
                    lVar.U(memberTaskItem, linkedHashMap);
                    MemberTaskItemInvite memberTaskItemInvite = inviteList.get(i);
                    if (memberTaskItemInvite.getStatus() == 1) {
                        lVar.g = true;
                        inviteUserView.notifyItemInviteUserStateChange(i);
                        lVar.f.N(i, memberTaskItemInvite.getRewardId(), memberTaskItemInvite.getRewardAmount(), memberTaskItemInvite.getRewardType());
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
    public static final void P(TextView textView, l lVar, MemberTaskItem memberTaskItem, View view) {
        if (com.transsion.baseui.util.c.a.a(textView.getId(), 2000L)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "task_invite_user_claim_all");
        linkedHashMap.put("index", "-1");
        Unit unit = Unit.a;
        lVar.U(memberTaskItem, linkedHashMap);
        lVar.g = true;
        MemberViewModel memberViewModel = lVar.f;
        MemberTaskRewardInfo rewardInfo = memberTaskItem.getRewardInfo();
        memberViewModel.N(-1, "0", rewardInfo != null ? rewardInfo.getDuration() : 0, 1);
    }

    private final Intent Q(Context context, String str, String str2, String str3) {
        String R = R(str2, str3);
        if (R == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setPackage(R);
        return intent;
    }

    private final String R(String str, String str2) {
        if (str != null && com.transsion.baseui.util.a.a.c(k(), str)) {
            return str;
        }
        if (str2 == null || !com.transsion.baseui.util.a.a.c(k(), str2)) {
            return null;
        }
        return str2;
    }

    private final void T(MemberTaskItem memberTaskItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_browse");
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
        Object obj = null;
        if (inviteList != null) {
            Iterator<T> it = inviteList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MemberTaskItemInvite) next).getStatus() == 1) {
                    obj = next;
                    break;
                }
            }
            obj = (MemberTaskItemInvite) obj;
        }
        hashMap.put("showClaim", String.valueOf(obj == null));
        com.transsion.baselib.helper.a.a.a("memberdetail", hashMap);
    }

    private final void U(MemberTaskItem memberTaskItem, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_click");
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
        Object obj = null;
        if (inviteList != null) {
            Iterator<T> it = inviteList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MemberTaskItemInvite) next).getStatus() == 1) {
                    obj = next;
                    break;
                }
            }
            obj = (MemberTaskItemInvite) obj;
        }
        hashMap.put("showClaim", String.valueOf(obj == null));
        hashMap.putAll(map);
        com.transsion.baselib.helper.a.a.b("memberdetail", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(l lVar, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "activityResult");
        try {
            int resultCode = activityResult.getResultCode();
            if (resultCode == -1) {
                com.tn.lib.widget.toast.core.h.a.l(lVar.k().getString(R$string.share_success_tips));
            } else if (resultCode != 0) {
                com.tn.lib.widget.toast.core.h.a.l(lVar.k().getString(R$string.share_failed_tips));
            } else {
                com.tn.lib.widget.toast.core.h.a.l(lVar.k().getString(R$string.share_canceled_tips));
            }
        } catch (Exception unused) {
        }
    }

    private final void W(String str) {
        b.a.h(fh.b.a, R$layout.claim_succeed_layout, str, 80, 0, a0.a(66.0f), 8, (Object) null);
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final MemberTaskItem memberTaskItem) {
        Object obj;
        String str;
        List arrayList;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(memberTaskItem, "item");
        T(memberTaskItem);
        final InviteUserView inviteUserView = (InviteUserView) baseViewHolder.getView(R$id.task_invite_user_view);
        List data = inviteUserView.getData();
        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
        if (data.containsAll(inviteList != null ? inviteList : new ArrayList<>())) {
            Integer num = this.j;
            inviteUserView.setLoadMoreEnable(num == null || num.intValue() != 0);
        } else {
            List<MemberTaskItemInvite> inviteList2 = memberTaskItem.getInviteList();
            if (inviteList2 == null || (arrayList = CollectionsKt.R0(inviteList2)) == null) {
                arrayList = new ArrayList();
            }
            inviteUserView.setData(arrayList);
            this.j = null;
            inviteUserView.setLoadMoreEnable(true);
        }
        inviteUserView.setDataViewBinder(new a(inviteUserView));
        inviteUserView.setItemClicker(new Function2() { // from class: em.e
            public final Object invoke(Object obj2, Object obj3) {
                Unit O;
                O = l.O(InviteUserView.this, memberTaskItem, this, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                return O;
            }
        });
        final TextView textView = (TextView) baseViewHolder.getView(R$id.claim_all_bt);
        MemberTaskRewardInfo rewardInfo = memberTaskItem.getRewardInfo();
        if ((rewardInfo != null ? rewardInfo.getDuration() : 0) == 0) {
            str = textView.getContext().getString(R$string.member_claim_all);
        } else {
            try {
                Result.Companion companion = Result.Companion;
                Context context = textView.getContext();
                int i = R$string.task_invite_user_view_get_premium_text;
                MemberTaskRewardInfo rewardInfo2 = memberTaskItem.getRewardInfo();
                obj = Result.constructor-impl(context.getString(i, rewardInfo2 != null ? Integer.valueOf(rewardInfo2.getDuration()) : null));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            String str2 = (String) obj;
            if (str2 == null) {
                MemberTaskRewardInfo rewardInfo3 = memberTaskItem.getRewardInfo();
                str = rewardInfo3 != null ? rewardInfo3.getDescription() : null;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
            } else {
                str = str2;
            }
        }
        textView.setText(str);
        MemberTaskRewardInfo rewardInfo4 = memberTaskItem.getRewardInfo();
        textView.setEnabled((rewardInfo4 != null ? rewardInfo4.getDuration() : 0) > 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: em.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.P(textView, this, memberTaskItem, view);
            }
        });
        final TextView textView2 = (TextView) baseViewHolder.getView(R$id.invite_tips_bt);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: em.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.J(textView2, this, memberTaskItem, view);
            }
        });
        this.f.C().j(this.e.getViewLifecycleOwner(), new b(new Function1() { // from class: em.h
            public final Object invoke(Object obj2) {
                Unit K;
                K = l.K(l.this, memberTaskItem, inviteUserView, textView, (im.e) obj2);
                return K;
            }
        }));
        this.f.t().j(this.e.getViewLifecycleOwner(), new b(new Function1() { // from class: em.i
            public final Object invoke(Object obj2) {
                Unit L;
                L = l.L(InviteUserView.this, this, memberTaskItem, (MemberTaskInviteRewards) obj2);
                return L;
            }
        }));
        this.f.y().j(this.e.getViewLifecycleOwner(), new b(new Function1() { // from class: em.j
            public final Object invoke(Object obj2) {
                Unit M;
                M = l.M(l.this, (Map) obj2);
                return M;
            }
        }));
    }

    public final MemberViewModel S() {
        return this.f;
    }

    public int l() {
        return TaskType.INVITE_USER.getValue();
    }

    public int m() {
        return R$layout.item_task_invite_user_container;
    }
}
