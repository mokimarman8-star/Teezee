package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.R;
import com.transsion.postdetail.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/transsion/postdetail/ui/view/AdCountDownView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "time", BuildConfig.FLAVOR, "refreshCountDown", "(I)V", "Lwn/l0;", "a", "Lwn/l0;", "getBind", "()Lwn/l0;", "setBind", "(Lwn/l0;)V", "bind", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdCountDownView extends LinearLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private wn.l0 bind;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdCountDownView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.h(context, "context");
        this.bind = wn.l0.a(LayoutInflater.from(getContext()).inflate(R$layout.view_ad_count_down_layout, this));
    }

    public final wn.l0 getBind() {
        return this.bind;
    }

    public final void refreshCountDown(int time) {
        ImageView imageView;
        TextView textView;
        View view;
        TextView textView2;
        TextView textView3;
        View view2;
        LinearLayout linearLayout;
        TextView textView4;
        TextView textView5;
        View view3;
        if (time < 0) {
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            if (bVar != null ? bVar.z() : false) {
                wn.l0 l0Var = this.bind;
                if (l0Var != null && (view3 = l0Var.f) != null) {
                    view3.setVisibility(8);
                }
                wn.l0 l0Var2 = this.bind;
                if (l0Var2 != null && (textView5 = l0Var2.e) != null) {
                    textView5.setText(getContext().getString(R.string.post_count_down_get_ad_free));
                }
            } else {
                wn.l0 l0Var3 = this.bind;
                if (l0Var3 != null && (linearLayout = l0Var3.c) != null) {
                    linearLayout.setVisibility(8);
                }
            }
            wn.l0 l0Var4 = this.bind;
            if (l0Var4 == null || (textView4 = l0Var4.d) == null) {
                return;
            }
            textView4.setText(BuildConfig.FLAVOR);
            return;
        }
        im.b bVar2 = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar2 != null ? bVar2.z() : false) {
            wn.l0 l0Var5 = this.bind;
            if (l0Var5 != null && (view2 = l0Var5.f) != null) {
                view2.setVisibility(0);
            }
            wn.l0 l0Var6 = this.bind;
            if (l0Var6 != null && (textView3 = l0Var6.e) != null) {
                textView3.setText(getContext().getString(R.string.post_count_down_get_ad_free));
            }
        } else {
            wn.l0 l0Var7 = this.bind;
            if (l0Var7 != null && (view = l0Var7.f) != null) {
                view.setVisibility(8);
            }
            wn.l0 l0Var8 = this.bind;
            if (l0Var8 != null && (textView = l0Var8.e) != null) {
                textView.setVisibility(8);
            }
            wn.l0 l0Var9 = this.bind;
            if (l0Var9 != null && (imageView = l0Var9.b) != null) {
                imageView.setVisibility(8);
            }
        }
        wn.l0 l0Var10 = this.bind;
        if (l0Var10 == null || (textView2 = l0Var10.d) == null) {
            return;
        }
        textView2.setText(time + "s");
    }

    public final void setBind(wn.l0 l0Var) {
        this.bind = l0Var;
    }
}
