package com.transsnet.login;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class t {
    public static final t a = new t();

    public static final class a extends ClickableSpan {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K(WebConstants.FIELD_URL, "https://h5-static.aoneroom.com/spa/html/moviebox-privacy-policy.html"), widget.getContext(), (mf.c) null, 2, (Object) null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(androidx.core.content.b.getColor(this.a, R$color.login_color_policy_link));
            ds2.setUnderlineText(true);
            ds2.clearShadowLayer();
        }
    }

    public static final class b extends ClickableSpan {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K(WebConstants.FIELD_URL, "https://h5-static.aoneroom.com/spa/html/moviebox-terms-of-use.html"), widget.getContext(), (mf.c) null, 2, (Object) null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(androidx.core.content.b.getColor(this.a, R$color.login_color_policy_link));
            ds2.setUnderlineText(true);
            ds2.clearShadowLayer();
        }
    }

    private t() {
    }

    public final void a(Context context, AppCompatTextView tvPrivacy) {
        Intrinsics.h(context, "context");
        Intrinsics.h(tvPrivacy, "tvPrivacy");
        String string = context.getString(R$string.login_sign_up_privacy);
        Intrinsics.g(string, "getString(...)");
        String string2 = context.getString(R$string.login_privacy);
        Intrinsics.g(string2, "getString(...)");
        String string3 = context.getString(R$string.login_user_agreement);
        Intrinsics.g(string3, "getString(...)");
        SpannableString spannableString = new SpannableString(string);
        a aVar = new a(context);
        b bVar = new b(context);
        int k0 = StringsKt.k0(string, string2, 0, true);
        int k02 = StringsKt.k0(string, string3, 0, true);
        if (k0 < 0) {
            k0 = 0;
        }
        int i = k02 >= 0 ? k02 : 0;
        spannableString.setSpan(aVar, k0, string2.length() + k0, 33);
        spannableString.setSpan(bVar, i, string3.length() + i, 33);
        tvPrivacy.setText(spannableString);
        tvPrivacy.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
