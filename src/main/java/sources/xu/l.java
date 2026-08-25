package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final ConstraintLayout c;
    public final ImageView d;
    public final DecoratedBarcodeView e;

    private l(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, ImageView imageView, DecoratedBarcodeView decoratedBarcodeView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = constraintLayout2;
        this.d = imageView;
        this.e = decoratedBarcodeView;
    }

    public static l a(View view) {
        DecoratedBarcodeView a;
        int i = R$id.ivClose;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.v_status_space;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R$id.zxing_barcode_scanner))) != null) {
                return new l(constraintLayout, a2, constraintLayout, imageView, a);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_profile_qr_code, viewGroup, false);
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
