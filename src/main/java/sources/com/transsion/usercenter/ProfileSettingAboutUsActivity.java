package com.transsion.usercenter;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.R;
import com.transsion.baseui.activity.BaseActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/transsion/usercenter/ProfileSettingAboutUsActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lxu/i;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "c0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "b0", "()Lxu/i;", HttpUrl.FRAGMENT_ENCODE_SET, "isTranslucent", "()Z", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileSettingAboutUsActivity extends BaseActivity<xu.i> {

    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            com.tn.lib.widget.toast.core.h.a.a("H5 Privacy Policy");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(androidx.core.content.b.getColor(Utils.a(), R.color.base_color_395CFF));
            ds2.setUnderlineText(false);
        }
    }

    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            com.tn.lib.widget.toast.core.h.a.a(" H5 User Agreement");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(androidx.core.content.b.getColor(Utils.a(), R.color.base_color_395CFF));
            ds2.setUnderlineText(false);
        }
    }

    private final void c0() {
        String obj = ((xu.i) getMViewBinding()).d.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) obj);
        int o0 = StringsKt.o0(obj, "Privacy Policy", 0, false, 6, null);
        spannableStringBuilder.setSpan(new a(), o0, o0 + 14, 0);
        int v0 = StringsKt.v0(obj, "User Agreement", 0, false, 6, null);
        spannableStringBuilder.setSpan(new b(), v0, v0 + 14, 0);
        ((xu.i) getMViewBinding()).d.setMovementMethod(LinkMovementMethod.getInstance());
        ((xu.i) getMViewBinding()).d.setHighlightColor(0);
        ((xu.i) getMViewBinding()).d.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public xu.i getViewBinding() {
        xu.i c = xu.i.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public boolean isTranslucent() {
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout root = ((xu.i) getMViewBinding()).getRoot();
        Intrinsics.g(root, "getRoot(...)");
        uf.c.e(root);
        ((xu.i) getMViewBinding()).c.goneRightViewLayout();
        c0();
        ((xu.i) getMViewBinding()).f.setText("V 1.0  todo 这里通过工具类获取");
        ((xu.i) getMViewBinding()).e.setText("Oneroom   todo 这里通过工具类获取");
    }
}
