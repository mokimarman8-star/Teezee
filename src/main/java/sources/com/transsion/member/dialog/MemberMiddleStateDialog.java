package com.transsion.member.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.MemberActivity;
import com.transsion.memberapi.MemberSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010,\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010(0(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/transsion/member/dialog/MemberMiddleStateDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", BuildConfig.FLAVOR, "o0", "()Z", "Lcom/transsion/memberapi/MemberSource;", "memberSource", "q0", "(Lcom/transsion/memberapi/MemberSource;)V", BuildConfig.FLAVOR, "sceneId", "r0", "(Ljava/lang/String;)V", "Lim/c;", "callback", "p0", "(Lim/c;)V", "c", "Z", "isPayMemberSuccess", "d", "Lcom/transsion/memberapi/MemberSource;", "source", "e", "Ljava/lang/String;", "f", "Lim/c;", "mCallback", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "g", "Landroidx/activity/result/b;", "startActivity", "h", "a", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberMiddleStateDialog extends BaseDialog {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int i = 8;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean isPayMemberSuccess;

    /* renamed from: d, reason: from kotlin metadata */
    private MemberSource source;

    /* renamed from: e, reason: from kotlin metadata */
    private String sceneId = BuildConfig.FLAVOR;

    /* renamed from: f, reason: from kotlin metadata */
    private im.c mCallback;

    /* renamed from: g, reason: from kotlin metadata */
    private final androidx.activity.result.b startActivity;

    /* renamed from: com.transsion.member.dialog.MemberMiddleStateDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberMiddleStateDialog a(boolean z) {
            MemberMiddleStateDialog memberMiddleStateDialog = new MemberMiddleStateDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_scrolltotask", z);
            memberMiddleStateDialog.setArguments(bundle);
            return memberMiddleStateDialog;
        }
    }

    public MemberMiddleStateDialog() {
        androidx.activity.result.b registerForActivityResult = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.member.dialog.i
            public final void a(Object obj) {
                MemberMiddleStateDialog.s0(MemberMiddleStateDialog.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.startActivity = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(MemberMiddleStateDialog memberMiddleStateDialog, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "it");
        memberMiddleStateDialog.isPayMemberSuccess = activityResult.getResultCode() == -1;
        com.transsion.member.a.a.a(memberMiddleStateDialog.getClassTag() + " --> startActivity --> registerForActivityResult() --> isPayMemberSuccess = " + memberMiddleStateDialog.isPayMemberSuccess);
        if (memberMiddleStateDialog.isAdded()) {
            memberMiddleStateDialog.dismissAllowingStateLoss();
        }
    }

    public final boolean o0() {
        return false;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.center_DialogStyle);
        if (o0()) {
            Navigator c = TheRouter.c("/rewards/center");
            MemberSource memberSource = this.source;
            Navigator.x(c.K("source", memberSource != null ? memberSource.getValue() : null).K("scene_id", this.sceneId), (Context) null, (mf.c) null, 3, (Object) null);
            return;
        }
        Intent intent = new Intent(requireContext(), (Class<?>) MemberActivity.class);
        MemberSource memberSource2 = this.source;
        intent.putExtra("source", memberSource2 != null ? memberSource2.getValue() : null);
        intent.putExtra("scene_id", this.sceneId);
        Bundle arguments = getArguments();
        intent.putExtra("extra_member_scroll_bottom", arguments != null ? Boolean.valueOf(arguments.getBoolean("key_scrolltotask")) : null);
        this.startActivity.a(intent);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.isPayMemberSuccess) {
            im.c cVar = this.mCallback;
            if (cVar != null) {
                cVar.onSuccess();
                return;
            }
            return;
        }
        im.c cVar2 = this.mCallback;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    public final void p0(im.c callback) {
        this.mCallback = callback;
    }

    public final void q0(MemberSource memberSource) {
        this.source = memberSource;
    }

    public final void r0(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        this.sceneId = sceneId;
    }
}
