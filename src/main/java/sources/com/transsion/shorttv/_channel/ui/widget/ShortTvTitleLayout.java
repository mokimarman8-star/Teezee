package com.transsion.shorttv._channel.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import com.blankj.utilcode.util.a0;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.ui.widget.ShortTvTitleLayout;
import com.transsion.shorttv.base.widget.TnTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u000fJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u000fJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u000fJ\u001d\u0010\"\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\n¢\u0006\u0004\b%\u0010\u000fJ%\u0010\"\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\n2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010'J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010\u0019J\u0017\u0010)\u001a\u00020\u00002\b\b\u0001\u0010(\u001a\u00020\n¢\u0006\u0004\b)\u0010\u000fJ\u0015\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\b¢\u0006\u0004\b+\u0010,J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010-J\u001d\u0010\"\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\n2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010/J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\n¢\u0006\u0004\b\"\u0010\u000fJ\u0015\u00100\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b0\u0010\u0015J\u0015\u00102\u001a\u00020\u00002\u0006\u00101\u001a\u00020 ¢\u0006\u0004\b2\u0010-J\u0015\u00103\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b3\u0010\u0015J\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u0004\u0018\u00010:¢\u0006\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010AR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010N¨\u0006R"}, d2 = {"Lcom/transsion/shorttv/_channel/ui/widget/ShortTvTitleLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "dp", BuildConfig.FLAVOR, "i", "(Landroid/content/Context;F)I", "resId", "setBackIcon", "(I)Lcom/transsion/shorttv/_channel/ui/widget/ShortTvTitleLayout;", "titleBackgroundColor", "setTitleBackgroundColor", BuildConfig.FLAVOR, "isVisible", "setBackVisible", "(Z)Lcom/transsion/shorttv/_channel/ui/widget/ShortTvTitleLayout;", BuildConfig.FLAVOR, "titleText", "setTitleText", "(Ljava/lang/String;)Lcom/transsion/shorttv/_channel/ui/widget/ShortTvTitleLayout;", "titleTextId", "titleTextColor", "setTitleTextColor", "titleTextSize", "setTitleTextSize", "text", "Landroid/view/View$OnClickListener;", "onClickListener", "setRightView", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)Lcom/transsion/shorttv/_channel/ui/widget/ShortTvTitleLayout;", "rightViewBackground", "setRightViewBackground", "textColor", "(Ljava/lang/String;ILandroid/view/View$OnClickListener;)Lcom/transsion/shorttv/_channel/ui/widget/ShortTvTitleLayout;", "color", "setRightViewColor", "size", "setRightTextSize", "(F)Lcom/transsion/shorttv/_channel/ui/widget/ShortTvTitleLayout;", "(Landroid/view/View$OnClickListener;)Lcom/transsion/shorttv/_channel/ui/widget/ShortTvTitleLayout;", "imageRes", "(ILandroid/view/View$OnClickListener;)Lcom/transsion/shorttv/_channel/ui/widget/ShortTvTitleLayout;", "setRedViewVisible", "l", "setLeftOnclick", "setViewLineVisible", BuildConfig.FLAVOR, "goneRightViewLayout", "()V", "Landroid/widget/ImageView;", "getRightImageView", "()Landroid/widget/ImageView;", "Lcom/transsion/shorttv/base/widget/TnTextView;", "getTitleView", "()Lcom/transsion/shorttv/base/widget/TnTextView;", "a", "Landroidx/constraintlayout/widget/ConstraintLayout;", "clTitleBar", "b", "Landroid/widget/ImageView;", "ivBack", "c", "Lcom/transsion/shorttv/base/widget/TnTextView;", "tvTitleText", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvMenu", "e", "ivMenu", "Landroid/view/View;", "f", "Landroid/view/View;", "viewRed", "g", "viewLine", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvTitleLayout extends ConstraintLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private ConstraintLayout clTitleBar;

    /* renamed from: b, reason: from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: c, reason: from kotlin metadata */
    private TnTextView tvTitleText;

    /* renamed from: d, reason: from kotlin metadata */
    private TextView tvMenu;

    /* renamed from: e, reason: from kotlin metadata */
    private ImageView ivMenu;

    /* renamed from: f, reason: from kotlin metadata */
    private View viewRed;

    /* renamed from: g, reason: from kotlin metadata */
    private View viewLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.transsion.shorttv.base.widget.TnTextView] */
    public ShortTvTitleLayout(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        Intrinsics.h(context, "context");
        Intrinsics.h(attributeSet, "attrs");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShortTvTitleLayout);
        Intrinsics.g(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int color = obtainStyledAttributes.getColor(R.styleable.ShortTvTitleLayout_titleBackgroundColor, b.getColor(context, R.color.short_tv_white));
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ShortTvTitleLayout_backIconRes, R.mipmap.short_tv_libui_ic_back_black);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.ShortTvTitleLayout_isShowBack, true);
        int color2 = obtainStyledAttributes.getColor(R.styleable.ShortTvTitleLayout_titleTextColor, b.getColor(context, R.color.short_tv_white));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShortTvTitleLayout_titleTextSize, a0.d(16.0f));
        obtainStyledAttributes.getString(R.styleable.ShortTvTitleLayout_titleText);
        obtainStyledAttributes.getIndex(R.styleable.ShortTvTitleLayout_titleText);
        int attributeCount = attributeSet.getAttributeCount();
        int i2 = 0;
        while (true) {
            if (i2 >= attributeCount) {
                i = 0;
                break;
            } else {
                if (Intrinsics.c(attributeSet.getAttributeName(i2), "titleText")) {
                    i = attributeSet.getAttributeResourceValue(i2, 0);
                    break;
                }
                i2++;
            }
        }
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.ShortTvTitleLayout_showLine, true);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ShortTvTitleLayout_menuRes, android.R.drawable.ic_menu_add);
        int integer = obtainStyledAttributes.getInteger(R.styleable.ShortTvTitleLayout_ShortTvTitleGravity, 0);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R.layout.short_tv_libui_layout_title, (ViewGroup) this, true);
        this.clTitleBar = findViewById(R.id.cl_titleBar);
        this.ivBack = (ImageView) findViewById(R.id.iv_back);
        this.tvTitleText = (TnTextView) findViewById(R.id.tv_titleText);
        this.tvMenu = (TextView) findViewById(R.id.tv_menu);
        this.ivMenu = (ImageView) findViewById(R.id.iv_menu);
        this.viewRed = findViewById(R.id.view_red);
        View findViewById = findViewById(R.id.view_line);
        this.viewLine = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(z2 ? 0 : 8);
        }
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            imageView.setImageResource(resourceId2);
        }
        ConstraintLayout constraintLayout = this.clTitleBar;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(color);
        }
        ImageView imageView2 = this.ivBack;
        if (imageView2 != null) {
            imageView2.setVisibility(z ? 0 : 8);
            imageView2.setImageResource(resourceId);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: wq.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTvTitleLayout.j(context, view);
                }
            });
        }
        ?? r0 = this.tvTitleText;
        if (r0 != 0) {
            r0.setTextColor(color2);
            r0.setTextSize(0, dimensionPixelSize);
            r0.setTextById(i);
            r0.setSelected(true);
            if (integer == 0) {
                ConstraintLayout.b layoutParams = r0.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar = layoutParams;
                bVar.v = 0;
                bVar.setMarginStart(0);
                r0.setLayoutParams(bVar);
                return;
            }
            if (integer != 1) {
                return;
            }
            ConstraintLayout.b layoutParams2 = r0.getLayoutParams();
            Intrinsics.f(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar2 = layoutParams2;
            bVar2.u = -1;
            bVar2.setMarginStart(i(context, 48.0f));
            r0.setLayoutParams(bVar2);
        }
    }

    private final int i(Context context, float dp2) {
        return (int) ((dp2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Context context, View view) {
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).onBackPressed();
    }

    /* renamed from: getRightImageView, reason: from getter */
    public final ImageView getIvMenu() {
        return this.ivMenu;
    }

    /* renamed from: getTitleView, reason: from getter */
    public final TnTextView getTvTitleText() {
        return this.tvTitleText;
    }

    public final void goneRightViewLayout() {
        TextView textView = this.tvMenu;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final ShortTvTitleLayout setBackIcon(int resId) {
        ImageView imageView = this.ivBack;
        if (imageView != null) {
            imageView.setImageResource(resId);
        }
        return this;
    }

    public final ShortTvTitleLayout setBackVisible(boolean isVisible) {
        ImageView imageView = this.ivBack;
        if (imageView != null) {
            imageView.setVisibility(isVisible ? 0 : 8);
        }
        return this;
    }

    public final ShortTvTitleLayout setLeftOnclick(View.OnClickListener l) {
        Intrinsics.h(l, "l");
        ImageView imageView = this.ivBack;
        if (imageView != null) {
            imageView.setOnClickListener(l);
        }
        return this;
    }

    public final ShortTvTitleLayout setRedViewVisible(boolean isVisible) {
        View view = this.viewRed;
        if (view != null) {
            view.setVisibility(isVisible ? 0 : 8);
        }
        return this;
    }

    public final ShortTvTitleLayout setRightTextSize(float size) {
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.tvMenu;
        if (textView != null) {
            textView.setTextSize(size);
        }
        return this;
    }

    public final ShortTvTitleLayout setRightView(int imageRes) {
        TextView textView = this.tvMenu;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(imageRes);
        }
        return this;
    }

    public final ShortTvTitleLayout setRightView(int imageRes, View.OnClickListener onClickListener) {
        Intrinsics.h(onClickListener, "onClickListener");
        TextView textView = this.tvMenu;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(imageRes);
            imageView.setOnClickListener(onClickListener);
        }
        return this;
    }

    public final ShortTvTitleLayout setRightView(View.OnClickListener onClickListener) {
        Intrinsics.h(onClickListener, "onClickListener");
        TextView textView = this.tvMenu;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
        return this;
    }

    public final ShortTvTitleLayout setRightView(String text) {
        Intrinsics.h(text, "text");
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            TextView textView = this.tvMenu;
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(text);
            }
            imageView.setVisibility(8);
        }
        return this;
    }

    public final ShortTvTitleLayout setRightView(String text, int textColor, View.OnClickListener onClickListener) {
        Intrinsics.h(text, "text");
        Intrinsics.h(onClickListener, "onClickListener");
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            TextView textView = this.tvMenu;
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(text);
                textView.setTextColor(textColor);
                textView.setOnClickListener(onClickListener);
            }
            imageView.setVisibility(8);
        }
        return this;
    }

    public final ShortTvTitleLayout setRightView(String text, View.OnClickListener onClickListener) {
        Intrinsics.h(text, "text");
        Intrinsics.h(onClickListener, "onClickListener");
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.tvMenu;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(text);
            textView.setOnClickListener(onClickListener);
        }
        return this;
    }

    public final ShortTvTitleLayout setRightViewBackground(int rightViewBackground) {
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.tvMenu;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setBackgroundColor(rightViewBackground);
        }
        return this;
    }

    public final ShortTvTitleLayout setRightViewColor(int color) {
        ImageView imageView = this.ivMenu;
        if (imageView != null) {
            TextView textView = this.tvMenu;
            if (textView != null) {
                textView.setTextColor(color);
            }
            imageView.setVisibility(8);
        }
        return this;
    }

    public final ShortTvTitleLayout setTitleBackgroundColor(int titleBackgroundColor) {
        ConstraintLayout constraintLayout = this.clTitleBar;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(titleBackgroundColor);
        }
        return this;
    }

    public final ShortTvTitleLayout setTitleText(int titleTextId) {
        TnTextView tnTextView = this.tvTitleText;
        if (tnTextView != null) {
            tnTextView.setTextById(titleTextId);
        }
        return this;
    }

    public final ShortTvTitleLayout setTitleText(String titleText) {
        Intrinsics.h(titleText, "titleText");
        TnTextView tnTextView = this.tvTitleText;
        if (tnTextView != null) {
            tnTextView.setTextWithString(titleText);
        }
        return this;
    }

    public final ShortTvTitleLayout setTitleTextColor(int titleTextColor) {
        AppCompatTextView appCompatTextView = this.tvTitleText;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(titleTextColor);
        }
        return this;
    }

    public final ShortTvTitleLayout setTitleTextSize(int titleTextSize) {
        TnTextView tnTextView = this.tvTitleText;
        if (tnTextView != null) {
            tnTextView.setTextSize(0, titleTextSize);
        }
        return this;
    }

    public final ShortTvTitleLayout setViewLineVisible(boolean isVisible) {
        View view = this.viewLine;
        if (view != null) {
            view.setVisibility(isVisible ? 0 : 8);
        }
        return this;
    }
}
