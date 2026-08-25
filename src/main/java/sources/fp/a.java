package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.TitleLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final NestedScrollView a;
    public final AppCompatEditText b;
    public final AppCompatEditText c;
    public final ShapeableImageView d;
    public final TitleLayout e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;

    private a(NestedScrollView nestedScrollView, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, ShapeableImageView shapeableImageView, TitleLayout titleLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = nestedScrollView;
        this.b = appCompatEditText;
        this.c = appCompatEditText2;
        this.d = shapeableImageView;
        this.e = titleLayout;
        this.f = appCompatTextView;
        this.g = appCompatTextView2;
        this.h = appCompatTextView3;
    }

    public static a a(View view) {
        AppCompatEditText a;
        ShapeableImageView a2;
        TitleLayout a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        int i = R$id.et_community_desc;
        AppCompatEditText a7 = f4.b.a(view, i);
        if (a7 == null || (a = f4.b.a(view, (i = R$id.et_community_name))) == null || (a2 = f4.b.a(view, (i = R$id.iv_avatar))) == null || (a3 = f4.b.a(view, (i = R$id.tool_bar))) == null || (a4 = f4.b.a(view, (i = R$id.tv_comfirm))) == null || (a5 = f4.b.a(view, (i = R$id.tv_desc))) == null || (a6 = f4.b.a(view, (i = R$id.tv_name))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a((NestedScrollView) view, a7, a, a2, a3, a4, a5, a6);
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_create_room, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.a;
    }
}
