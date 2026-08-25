package jt;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.subtitle.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final Space f;
    public final Space g;
    public final View h;

    private a(ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, Space space, Space space2, View view) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = frameLayout3;
        this.e = frameLayout4;
        this.f = space;
        this.g = space2;
        this.h = view;
    }

    public static a a(View view) {
        View a;
        int i = R$id.flSearchContainer;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R$id.flStyleContainer;
            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
            if (frameLayout2 != null) {
                i = R$id.fl_subtitle_container;
                FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout3 != null) {
                    i = R$id.flSyncAdjustContainer;
                    FrameLayout frameLayout4 = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout4 != null) {
                        i = R$id.guideline_bottom_controller;
                        Space space = (Space) f4.b.a(view, i);
                        if (space != null) {
                            i = R$id.guideline_player;
                            Space space2 = (Space) f4.b.a(view, i);
                            if (space2 != null && (a = f4.b.a(view, (i = R$id.v_bg_start))) != null) {
                                return new a((ConstraintLayout) view, frameLayout, frameLayout2, frameLayout3, frameLayout4, space, space2, a);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
