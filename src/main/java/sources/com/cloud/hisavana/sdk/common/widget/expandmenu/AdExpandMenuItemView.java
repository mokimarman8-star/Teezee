package com.cloud.hisavana.sdk.common.widget.expandmenu;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$string;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AdExpandMenuItemView extends LinearLayout {
    private ImageView a;
    private TextView b;
    private ImageView c;

    public enum Type {
        PERSONALISE_CLOSE,
        ADVERTISER_INFO,
        COPY_LINK
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Type.values().length];
            a = iArr;
            try {
                iArr[Type.PERSONALISE_CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Type.ADVERTISER_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Type.COPY_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AdExpandMenuItemView(Context context) {
        this(context, null, 0);
    }

    public AdExpandMenuItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdExpandMenuItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.ad_expand_menu_item_layout, this);
        a();
    }

    private void a() {
        this.a = (ImageView) findViewById(R$id.left_image_view);
        this.b = (TextView) findViewById(R$id.message_text_view);
        this.c = (ImageView) findViewById(R$id.right_image_view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setBackgroundColor(Color.parseColor("#F7F7F8"));
        } else if (action == 1 || action == 3) {
            setBackgroundColor(-1);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setData(Type type) {
        if (this.a == null || this.b == null || this.c == null) {
            return;
        }
        int i = a.a[type.ordinal()];
        if (i == 1) {
            this.a.setImageResource(R$drawable.hs_ad_heart);
            this.b.setText(R$string.interstitial_close);
            this.c.setVisibility(0);
        } else if (i == 2) {
            this.a.setImageResource(R$drawable.hs_ad_info);
            this.b.setText(R$string.about_the_advertiser);
            this.c.setVisibility(0);
        } else {
            if (i != 3) {
                return;
            }
            this.a.setImageResource(R$drawable.hs_ad_link);
            this.b.setText(R$string.copy_link);
            this.c.setVisibility(8);
        }
    }
}
