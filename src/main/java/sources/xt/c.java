package xt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final ConstraintLayout c;
    public final DecoratedBarcodeView d;

    private c(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, DecoratedBarcodeView decoratedBarcodeView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = constraintLayout2;
        this.d = decoratedBarcodeView;
    }

    public static c a(View view) {
        int i = R$id.ivClose;
        AppCompatImageView a = f4.b.a(view, i);
        if (a != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R$id.zxing_barcode_scanner;
            DecoratedBarcodeView a2 = f4.b.a(view, i2);
            if (a2 != null) {
                return new c(constraintLayout, a, constraintLayout, a2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_wifi_connect, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
