package com.transsion.player.longvideo.ui.dialog;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.a0;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.view.SwitchButton;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.R;
import cw.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/transsion/player/longvideo/ui/dialog/PlayerSettingDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", BuildConfig.FLAVOR, "isChecked", BuildConfig.FLAVOR, "p0", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PlayerSettingDialog extends BaseDialog {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(PlayerSettingDialog playerSettingDialog, SwitchButton switchButton, boolean z) {
        com.transsion.baselib.report.launch.b.a.b().putBoolean("k_pip_enable", z);
        playerSettingDialog.p0(z);
    }

    private final void p0(boolean isChecked) {
        FragmentActivity context = getContext();
        if (context instanceof FragmentActivity) {
            e.a aVar = cw.e.a;
            if (!aVar.b().i() || Build.VERSION.SDK_INT < 31) {
                return;
            }
            e.b.c(aVar.b(), context, false, isChecked, (ViewGroup) null, 8, (Object) null);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.DownloadBottomDialogTheme);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        return inflater.inflate(R$layout.dialog_player_setting_layout, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setWindowAnimations(uf.c.f() ? com.tn.lib.widget.R.style.ActionSheetDialogLeft : com.tn.lib.widget.R.style.ActionSheetDialogRight);
            window.setGravity(uf.c.f() ? 8388611 : 8388613);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(null);
            window.setLayout(a0.a(260.0f), -1);
            ImmersionBar with = ImmersionBar.with(this);
            with.hideBar(BarHide.FLAG_HIDE_BAR);
            with.init();
        }
        SwitchButton findViewById = view.findViewById(R$id.switchBtn);
        findViewById.setChecked(com.transsion.baselib.report.launch.b.a.b().getBoolean("k_pip_enable", true));
        findViewById.setOnCheckedChangeListener(new SwitchButton.d() { // from class: com.transsion.player.longvideo.ui.dialog.t
            public final void a(SwitchButton switchButton, boolean z) {
                PlayerSettingDialog.o0(PlayerSettingDialog.this, switchButton, z);
            }
        });
    }
}
