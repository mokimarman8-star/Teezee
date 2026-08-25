package com.transsion.member.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.R;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.member.view.CheckInView;
import com.transsion.memberapi.MemberTaskCheckInInfo;
import com.transsion.memberapi.MemberTaskItemCheckInInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0015\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R3\u0010<\u001a\u001f\u0012\u0013\u0012\u00110*¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010ARH\u0010H\u001a4\u0012\u0013\u0012\u00110*¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110*¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/transsion/member/dialog/MemberTaskCheckInDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "initView", BuildConfig.FLAVOR, "index", "u0", "(I)V", BuildConfig.FLAVOR, "msg", "D0", "(Ljava/lang/String;)V", "Lcom/transsion/memberapi/MemberTaskCheckInInfo;", "item", "B0", "(Lcom/transsion/memberapi/MemberTaskCheckInInfo;)V", "Lcom/transsion/memberapi/MemberTaskItemCheckInInfo;", BuildConfig.FLAVOR, "extMap", "C0", "(Lcom/transsion/memberapi/MemberTaskItemCheckInInfo;Ljava/util/Map;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lgm/f;", "c", "Lgm/f;", "bind", "d", "Ljava/lang/String;", "dialogIgnoreTime", BuildConfig.FLAVOR, "e", "Z", "dialogIgnoreSwitcher", "f", "checkInSubmitting", "g", "I", "routeTabId", "h", "Lcom/transsion/memberapi/MemberTaskCheckInInfo;", "checkInInfo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "checkInDone", "i", "Lkotlin/jvm/functions/Function1;", "onCheckInDoneListener", "Lcom/transsion/member/c;", "j", "Lkotlin/Lazy;", "v0", "()Lcom/transsion/member/c;", "checkInViewModel", "Lkotlin/Function2;", "isBlock", "isShow", "k", "Lkotlin/jvm/functions/Function2;", "mCallback", "l", "a", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberTaskCheckInDialog extends BaseDialog {

    /* renamed from: l, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m = 8;

    /* renamed from: c, reason: from kotlin metadata */
    private gm.f bind;

    /* renamed from: d, reason: from kotlin metadata */
    private final String dialogIgnoreTime;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean dialogIgnoreSwitcher;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean checkInSubmitting;

    /* renamed from: g, reason: from kotlin metadata */
    private int routeTabId;

    /* renamed from: h, reason: from kotlin metadata */
    private MemberTaskCheckInInfo checkInInfo;

    /* renamed from: i, reason: from kotlin metadata */
    private Function1 onCheckInDoneListener;

    /* renamed from: j, reason: from kotlin metadata */
    private final Lazy checkInViewModel;

    /* renamed from: k, reason: from kotlin metadata */
    private Function2 mCallback;

    /* renamed from: com.transsion.member.dialog.MemberTaskCheckInDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b() {
            String format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(Calendar.getInstance().getTimeInMillis() - 14400000));
            Intrinsics.g(format, "format(...)");
            return format;
        }
    }

    public static final class b implements CheckInView.d {
        final /* synthetic */ CheckInView b;

        b(CheckInView checkInView) {
            this.b = checkInView;
        }

        @Override // com.transsion.member.view.CheckInView.d
        public void a(CheckInView.b bVar, int i) {
            List<MemberTaskItemCheckInInfo> checkInList;
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
            Intrinsics.h(bVar, "holder");
            ImageView imageView = (ImageView) ((RecyclerView.a0) bVar).itemView.findViewById(R$id.tag_iv);
            TextView textView = (TextView) ((RecyclerView.a0) bVar).itemView.findViewById(R$id.member_point);
            MemberTaskCheckInInfo memberTaskCheckInInfo = MemberTaskCheckInDialog.this.checkInInfo;
            if (memberTaskCheckInInfo == null || (checkInList = memberTaskCheckInInfo.getCheckInList()) == null || (memberTaskItemCheckInInfo = checkInList.get(i)) == null) {
                return;
            }
            if (textView != null) {
                textView.setText("+" + memberTaskItemCheckInInfo.getRewardAmount());
            }
            if (bVar.f() == 2 || bVar.f() == 5) {
                if (memberTaskItemCheckInInfo.isToday() && MemberTaskCheckInDialog.this.checkInSubmitting) {
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
                textView2.setText(this.b.getContext().getString(R$string.member_task_day_tip, Integer.valueOf(i + 1)));
            }
        }

        @Override // com.transsion.member.view.CheckInView.d
        public int b(int i) {
            List<MemberTaskItemCheckInInfo> checkInList;
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
            List<MemberTaskItemCheckInInfo> checkInList2;
            MemberTaskCheckInInfo memberTaskCheckInInfo = MemberTaskCheckInDialog.this.checkInInfo;
            if (memberTaskCheckInInfo == null || (checkInList = memberTaskCheckInInfo.getCheckInList()) == null || (memberTaskItemCheckInInfo = checkInList.get(i)) == null) {
                return 5;
            }
            MemberTaskCheckInInfo memberTaskCheckInInfo2 = MemberTaskCheckInDialog.this.checkInInfo;
            boolean z = i == ((memberTaskCheckInInfo2 == null || (checkInList2 = memberTaskCheckInInfo2.getCheckInList()) == null) ? 0 : checkInList2.size()) - 1;
            return !memberTaskItemCheckInInfo.getHasCheckIn() ? memberTaskItemCheckInInfo.isToday() ? z ? 5 : 2 : z ? 6 : 3 : z ? 4 : 1;
        }
    }

    public MemberTaskCheckInDialog() {
        super(R$layout.dialog_member_check_in_layout);
        this.dialogIgnoreTime = INSTANCE.b();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.member.dialog.MemberTaskCheckInDialog$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m29invoke() {
                return this;
            }
        };
        this.checkInViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.member.c.class), new Function0<x0>() { // from class: com.transsion.member.dialog.MemberTaskCheckInDialog$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m30invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.member.dialog.MemberTaskCheckInDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m31invoke() {
                Object invoke = function0.invoke();
                androidx.lifecycle.m mVar = invoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(MemberTaskCheckInDialog memberTaskCheckInDialog, View view) {
        memberTaskCheckInDialog.dismissAllowingStateLoss();
    }

    private final void B0(MemberTaskCheckInInfo item) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_browse");
        hashMap.put("taskSubType", "8");
        hashMap.put("showClaim", "true");
        com.transsion.baselib.helper.a.a.a("member_check_in_dialog", hashMap);
    }

    private final void C0(MemberTaskItemCheckInInfo item, Map extMap) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_click");
        hashMap.put("taskSubType", "8");
        hashMap.put("rewardType", String.valueOf(item != null ? Integer.valueOf(item.getRewardType()) : null));
        hashMap.put("rewardAmount", String.valueOf(item != null ? Integer.valueOf(item.getRewardAmount()) : null));
        hashMap.putAll(extMap);
        com.transsion.baselib.helper.a.a.b("member_check_in_dialog", hashMap);
    }

    private final void D0(String msg) {
        com.tn.lib.widget.toast.core.h.a.l(msg);
    }

    private final void initView() {
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        CheckBox checkBox;
        final CheckInView checkInView;
        B0(this.checkInInfo);
        gm.f fVar = this.bind;
        if (fVar != null && (checkInView = fVar.f) != null) {
            checkInView.setDataViewBinder(new b(checkInView));
            checkInView.setItemClicker(new Function2() { // from class: com.transsion.member.dialog.o
                public final Object invoke(Object obj, Object obj2) {
                    Unit x0;
                    x0 = MemberTaskCheckInDialog.x0(CheckInView.this, this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    return x0;
                }
            });
        }
        gm.f fVar2 = this.bind;
        if (fVar2 != null && (checkBox = fVar2.b) != null) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.transsion.member.dialog.p
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    MemberTaskCheckInDialog.y0(MemberTaskCheckInDialog.this, compoundButton, z);
                }
            });
        }
        gm.f fVar3 = this.bind;
        if (fVar3 != null && (appCompatTextView = fVar3.c) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberTaskCheckInDialog.z0(MemberTaskCheckInDialog.this, view);
                }
            });
        }
        gm.f fVar4 = this.bind;
        if (fVar4 != null && (appCompatImageView = fVar4.e) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberTaskCheckInDialog.A0(MemberTaskCheckInDialog.this, view);
                }
            });
        }
        Bundle arguments = getArguments();
        this.routeTabId = arguments != null ? arguments.getInt("key_routetabid") : 0;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("key_check_in_info") : null;
        Intrinsics.f(serializable, "null cannot be cast to non-null type com.transsion.memberapi.MemberTaskCheckInInfo");
        this.checkInInfo = (MemberTaskCheckInInfo) serializable;
        v0().f().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.member.dialog.s
            public final Object invoke(Object obj) {
                Unit w0;
                w0 = MemberTaskCheckInDialog.w0(MemberTaskCheckInDialog.this, (MemberTaskSubmitCheckInRes) obj);
                return w0;
            }
        }));
    }

    private final void u0(int index) {
        CheckInView checkInView;
        this.checkInSubmitting = true;
        gm.f fVar = this.bind;
        if (fVar != null && (checkInView = fVar.f) != null) {
            checkInView.notifyItemCheckInStateChange(index);
        }
        v0().e();
    }

    private final com.transsion.member.c v0() {
        return (com.transsion.member.c) this.checkInViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(MemberTaskCheckInDialog memberTaskCheckInDialog, MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes) {
        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
        CheckInView checkInView;
        List<MemberTaskItemCheckInInfo> checkInList;
        Object obj;
        String date;
        CheckInView checkInView2;
        String date2;
        List<MemberTaskItemCheckInInfo> checkInList2;
        Object obj2;
        memberTaskCheckInDialog.checkInSubmitting = false;
        MemberTaskCheckInInfo memberTaskCheckInInfo = memberTaskCheckInDialog.checkInInfo;
        if (memberTaskCheckInInfo == null || (checkInList2 = memberTaskCheckInInfo.getCheckInList()) == null) {
            memberTaskItemCheckInInfo = null;
        } else {
            Iterator<T> it = checkInList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (((MemberTaskItemCheckInInfo) obj2).isToday()) {
                    break;
                }
            }
            memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) obj2;
        }
        String str = BuildConfig.FLAVOR;
        if (memberTaskSubmitCheckInRes == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("event_detail", "task_check_in_item_fail");
            if (memberTaskItemCheckInInfo != null && (date2 = memberTaskItemCheckInInfo.getDate()) != null) {
                str = date2;
            }
            linkedHashMap.put("date", str);
            Unit unit = Unit.a;
            memberTaskCheckInDialog.C0(memberTaskItemCheckInInfo, linkedHashMap);
            try {
                Result.Companion companion = Result.Companion;
                gm.f fVar = memberTaskCheckInDialog.bind;
                if (fVar != null && (checkInView2 = fVar.f) != null) {
                    checkInView2.notifyAllChange();
                }
                String string = memberTaskCheckInDialog.getString(R$string.member_reward_receive_fault_tips);
                Intrinsics.g(string, "getString(...)");
                memberTaskCheckInDialog.D0(string);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("event_detail", "task_check_in_item_success");
            if (memberTaskItemCheckInInfo != null && (date = memberTaskItemCheckInInfo.getDate()) != null) {
                str = date;
            }
            linkedHashMap2.put("date", str);
            Unit unit2 = Unit.a;
            memberTaskCheckInDialog.C0(memberTaskItemCheckInInfo, linkedHashMap2);
            try {
                Result.Companion companion3 = Result.Companion;
                MemberTaskCheckInInfo memberTaskCheckInInfo2 = memberTaskCheckInDialog.checkInInfo;
                if (memberTaskCheckInInfo2 != null && (checkInList = memberTaskCheckInInfo2.getCheckInList()) != null) {
                    Iterator<T> it2 = checkInList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        if (((MemberTaskItemCheckInInfo) obj).isToday()) {
                            break;
                        }
                    }
                    MemberTaskItemCheckInInfo memberTaskItemCheckInInfo2 = (MemberTaskItemCheckInInfo) obj;
                    if (memberTaskItemCheckInInfo2 != null) {
                        memberTaskItemCheckInInfo2.setHasCheckIn(true);
                    }
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String string2 = memberTaskCheckInDialog.getString((memberTaskItemCheckInInfo == null || memberTaskItemCheckInInfo.getRewardType() != 1) ? R$string.member_reward_points_receive_tips : R$string.member_claimed_succeed_days);
                Intrinsics.g(string2, "getString(...)");
                String format = String.format(string2, Arrays.copyOf(new Object[]{memberTaskItemCheckInInfo != null ? Integer.valueOf(memberTaskItemCheckInInfo.getRewardAmount()) : null}, 1));
                Intrinsics.g(format, "format(...)");
                memberTaskCheckInDialog.D0(format);
                Function1 function1 = memberTaskCheckInDialog.onCheckInDoneListener;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                }
                memberTaskCheckInDialog.checkInSubmitting = false;
                gm.f fVar2 = memberTaskCheckInDialog.bind;
                if (fVar2 != null && (checkInView = fVar2.f) != null) {
                    checkInView.notifyAllChange();
                }
                memberTaskCheckInDialog.dismissAllowingStateLoss();
                Result.constructor-impl(Unit.a);
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th3));
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit x0(CheckInView checkInView, MemberTaskCheckInDialog memberTaskCheckInDialog, int i, int i2) {
        List<MemberTaskItemCheckInInfo> checkInList;
        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
        List<MemberTaskItemCheckInInfo> checkInList2;
        if (i2 == 2 || i2 == 5) {
            if (com.transsion.baseui.util.c.a.a(checkInView.getId(), 2000L)) {
                return Unit.a;
            }
            MemberTaskCheckInInfo memberTaskCheckInInfo = memberTaskCheckInDialog.checkInInfo;
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo2 = null;
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo3 = (memberTaskCheckInInfo == null || (checkInList2 = memberTaskCheckInInfo.getCheckInList()) == null) ? null : checkInList2.get(i);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("event_detail", "task_check_in_item");
            linkedHashMap.put("index", String.valueOf(i));
            Unit unit = Unit.a;
            memberTaskCheckInDialog.C0(memberTaskItemCheckInInfo3, linkedHashMap);
            try {
                Result.Companion companion = Result.Companion;
                MemberTaskCheckInInfo memberTaskCheckInInfo2 = memberTaskCheckInDialog.checkInInfo;
                if (memberTaskCheckInInfo2 != null && (checkInList = memberTaskCheckInInfo2.getCheckInList()) != null && (memberTaskItemCheckInInfo = checkInList.get(i)) != null) {
                    if (!memberTaskItemCheckInInfo.getHasCheckIn() && memberTaskItemCheckInInfo.isToday()) {
                        memberTaskCheckInDialog.u0(i);
                    }
                    memberTaskItemCheckInInfo2 = memberTaskItemCheckInInfo;
                }
                Result.constructor-impl(memberTaskItemCheckInInfo2);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(MemberTaskCheckInDialog memberTaskCheckInDialog, CompoundButton compoundButton, boolean z) {
        memberTaskCheckInDialog.dialogIgnoreSwitcher = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(MemberTaskCheckInDialog memberTaskCheckInDialog, View view) {
        Context context;
        if (com.transsion.baseui.util.c.a.a(view.getId(), 2000L) || (context = memberTaskCheckInDialog.getContext()) == null) {
            return;
        }
        hj.b.a.c(context, "oneroom://com.community.oneroom?type=/main/tab&tabIndex=" + memberTaskCheckInDialog.routeTabId, null);
        memberTaskCheckInDialog.dismissAllowingStateLoss();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.center_DialogStyle);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.dialogIgnoreSwitcher) {
            com.transsion.baselib.report.launch.b.a.b().putString("key_member_task_check_in_show_time", this.dialogIgnoreTime);
        }
        Function2 function2 = this.mCallback;
        if (function2 != null) {
            Boolean bool = Boolean.FALSE;
            function2.invoke(bool, bool);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Window window2;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCancelable(true);
        }
        Dialog dialog4 = getDialog();
        if (dialog4 != null) {
            dialog4.setCanceledOnTouchOutside(false);
        }
        this.bind = gm.f.a(view);
        initView();
        Function2 function2 = this.mCallback;
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, Boolean.TRUE);
        }
    }
}
