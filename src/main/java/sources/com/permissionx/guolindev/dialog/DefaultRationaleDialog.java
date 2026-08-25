package com.permissionx.guolindev.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.bottomsheet.c;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLView;
import com.permissionx.guolindev.R$layout;
import com.transsion.baseui.R;
import ff.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J4\u0010\u001c\u001a\u00020\t2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\t0\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ4\u0010\u001f\u001a\u00020\t2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\t0\u0017H\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b'\u0010(R5\u0010+\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\t\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R5\u0010-\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\t\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/permissionx/guolindev/dialog/DefaultRationaleDialog;", "Lcom/permissionx/guolindev/dialog/RationaleDialog;", "<init>", "()V", TtmlNode.ANONYMOUS_REGION_ID, TtmlNode.ANONYMOUS_REGION_ID, "permissions", "Lff/a;", "dialogInfo", TtmlNode.ANONYMOUS_REGION_ID, "r0", "(Ljava/util/List;Lff/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", RewardPlus.NAME, "positiveButton", "callback", "p0", "(Lkotlin/jvm/functions/Function1;)V", "negativeButton", "o0", "n0", "()Ljava/util/List;", "Landroid/content/Context;", "context", TtmlNode.ANONYMOUS_REGION_ID, "dpValue", TtmlNode.ANONYMOUS_REGION_ID, "q0", "(Landroid/content/Context;F)I", "c", "Lkotlin/jvm/functions/Function1;", "positiveButtonCallback", "d", "negativeButtonCallback", "e", "Ljava/util/List;", "f", "Lff/a;", "PermissionX_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class DefaultRationaleDialog extends RationaleDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private Function1 positiveButtonCallback;

    /* renamed from: d, reason: from kotlin metadata */
    private Function1 negativeButtonCallback;

    /* renamed from: e, reason: from kotlin metadata */
    private List permissions;

    /* renamed from: f, reason: from kotlin metadata */
    private a dialogInfo;

    public DefaultRationaleDialog() {
        super(R$layout.permissionx_dialog_def);
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public List n0() {
        List list = this.permissions;
        return list == null ? new ArrayList() : list;
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public void o0(Function1 callback) {
        Intrinsics.h(callback, "callback");
        this.negativeButtonCallback = callback;
    }

    public void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(savedInstanceState);
        setStyle(0, R.style.BottomDialogTheme);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        c cVar = new c(requireContext, getTheme());
        Window window = cVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.BaseBottomDialogAnimation);
        }
        Window window2 = cVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = com.transsion.baseui.util.a.a.b(requireContext);
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return cVar;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Integer c;
        Context context;
        Intrinsics.h(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        ef.a a = ef.a.a(view);
        Intrinsics.g(a, "bind(...)");
        a aVar = this.dialogInfo;
        if ((aVar != null ? aVar.b() : null) != null && (context = getContext()) != null) {
            BLView bLView = a.g;
            DrawableCreator.Builder cornersRadius = new DrawableCreator.Builder().setCornersRadius(q0(context, 36.0f));
            Resources resources = context.getResources();
            a aVar2 = this.dialogInfo;
            Intrinsics.e(aVar2);
            Integer b = aVar2.b();
            Intrinsics.e(b);
            bLView.setBackground(cornersRadius.setSolidColor(resources.getColor(b.intValue())).build());
        }
        a aVar3 = this.dialogInfo;
        if (aVar3 != null && (c = aVar3.c()) != null) {
            a.c.setImageResource(c.intValue());
        }
        AppCompatTextView appCompatTextView = a.f;
        Intrinsics.g(appCompatTextView, "tvTitle");
        a aVar4 = this.dialogInfo;
        String e = aVar4 != null ? aVar4.e() : null;
        boolean z = true;
        appCompatTextView.setVisibility(!(e == null || e.length() == 0) ? 0 : 8);
        AppCompatTextView appCompatTextView2 = a.f;
        a aVar5 = this.dialogInfo;
        appCompatTextView2.setText(aVar5 != null ? aVar5.e() : null);
        AppCompatTextView appCompatTextView3 = a.e;
        Intrinsics.g(appCompatTextView3, "tvSubtitle");
        a aVar6 = this.dialogInfo;
        String d = aVar6 != null ? aVar6.d() : null;
        if (d != null && d.length() != 0) {
            z = false;
        }
        appCompatTextView3.setVisibility(z ? 8 : 0);
        AppCompatTextView appCompatTextView4 = a.e;
        a aVar7 = this.dialogInfo;
        appCompatTextView4.setText(aVar7 != null ? aVar7.d() : null);
        AppCompatTextView appCompatTextView5 = a.d;
        a aVar8 = this.dialogInfo;
        appCompatTextView5.setText(aVar8 != null ? aVar8.a() : null);
        Function1 function1 = this.positiveButtonCallback;
        if (function1 != null) {
            function1.invoke(a.d);
        }
        Function1 function12 = this.negativeButtonCallback;
        if (function12 != null) {
            function12.invoke(a.b);
        }
    }

    @Override // com.permissionx.guolindev.dialog.RationaleDialog
    public void p0(Function1 callback) {
        Intrinsics.h(callback, "callback");
        this.positiveButtonCallback = callback;
    }

    public final int q0(Context context, float dpValue) {
        Intrinsics.h(context, "context");
        return (int) TypedValue.applyDimension(1, dpValue, context.getResources().getDisplayMetrics());
    }

    public final void r0(List permissions, a dialogInfo) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(dialogInfo, "dialogInfo");
        this.permissions = permissions;
        this.dialogInfo = dialogInfo;
    }
}
