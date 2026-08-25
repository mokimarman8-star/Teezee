package jt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.SecondariesSeekBar;
import com.tn.lib.view.SwitchButton;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import com.warkiz.widget.IndicatorSeekBar;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i implements f4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final AppCompatTextView E;
    public final BLTextView F;
    public final AppCompatTextView G;
    public final AppCompatTextView H;
    private final View a;
    public final Group b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final SecondariesSeekBar j;
    public final SecondariesSeekBar k;
    public final RadioButton l;
    public final RadioButton m;
    public final RadioButton n;
    public final RadioButton o;
    public final RadioButton p;
    public final RadioButton q;
    public final RadioButton r;
    public final RadioButton s;
    public final RadioGroup t;
    public final RadioGroup u;
    public final IndicatorSeekBar v;
    public final SecondariesSeekBar w;
    public final IndicatorSeekBar x;
    public final SwitchButton y;
    public final SwitchButton z;

    private i(View view, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, AppCompatImageView appCompatImageView7, SecondariesSeekBar secondariesSeekBar, SecondariesSeekBar secondariesSeekBar2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioGroup radioGroup, RadioGroup radioGroup2, IndicatorSeekBar indicatorSeekBar, SecondariesSeekBar secondariesSeekBar3, IndicatorSeekBar indicatorSeekBar2, SwitchButton switchButton, SwitchButton switchButton2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, BLTextView bLTextView, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7) {
        this.a = view;
        this.b = group;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = appCompatImageView3;
        this.f = appCompatImageView4;
        this.g = appCompatImageView5;
        this.h = appCompatImageView6;
        this.i = appCompatImageView7;
        this.j = secondariesSeekBar;
        this.k = secondariesSeekBar2;
        this.l = radioButton;
        this.m = radioButton2;
        this.n = radioButton3;
        this.o = radioButton4;
        this.p = radioButton5;
        this.q = radioButton6;
        this.r = radioButton7;
        this.s = radioButton8;
        this.t = radioGroup;
        this.u = radioGroup2;
        this.v = indicatorSeekBar;
        this.w = secondariesSeekBar3;
        this.x = indicatorSeekBar2;
        this.y = switchButton;
        this.z = switchButton2;
        this.A = appCompatTextView;
        this.B = appCompatTextView2;
        this.C = appCompatTextView3;
        this.D = appCompatTextView4;
        this.E = appCompatTextView5;
        this.F = bLTextView;
        this.G = appCompatTextView6;
        this.H = appCompatTextView7;
    }

    public static i a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        AppCompatImageView a7;
        SecondariesSeekBar a8;
        SecondariesSeekBar a9;
        SecondariesSeekBar a10;
        SwitchButton a11;
        SwitchButton a12;
        AppCompatTextView a13;
        AppCompatTextView a14;
        AppCompatTextView a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        BLTextView a18;
        AppCompatTextView a19;
        AppCompatTextView a20;
        int i = R$id.group_background;
        Group a21 = f4.b.a(view, i);
        if (a21 != null && (a = f4.b.a(view, (i = R$id.ivBack))) != null && (a2 = f4.b.a(view, (i = R$id.iv_background_add))) != null && (a3 = f4.b.a(view, (i = R$id.iv_background_minus))) != null && (a4 = f4.b.a(view, (i = R$id.iv_font_size_add))) != null && (a5 = f4.b.a(view, (i = R$id.iv_font_size_minus))) != null && (a6 = f4.b.a(view, (i = R$id.iv_position_down))) != null && (a7 = f4.b.a(view, (i = R$id.iv_position_up))) != null && (a8 = f4.b.a(view, (i = R$id.progress_bar_background))) != null && (a9 = f4.b.a(view, (i = R$id.progress_bar_font_size))) != null) {
            i = R$id.rb_background_black;
            RadioButton radioButton = (RadioButton) f4.b.a(view, i);
            if (radioButton != null) {
                i = R$id.rb_background_green;
                RadioButton radioButton2 = (RadioButton) f4.b.a(view, i);
                if (radioButton2 != null) {
                    i = R$id.rb_background_white;
                    RadioButton radioButton3 = (RadioButton) f4.b.a(view, i);
                    if (radioButton3 != null) {
                        i = R$id.rb_background_yellor;
                        RadioButton radioButton4 = (RadioButton) f4.b.a(view, i);
                        if (radioButton4 != null) {
                            i = R$id.rb_font_color_black;
                            RadioButton radioButton5 = (RadioButton) f4.b.a(view, i);
                            if (radioButton5 != null) {
                                i = R$id.rb_font_color_green;
                                RadioButton radioButton6 = (RadioButton) f4.b.a(view, i);
                                if (radioButton6 != null) {
                                    i = R$id.rb_font_color_white;
                                    RadioButton radioButton7 = (RadioButton) f4.b.a(view, i);
                                    if (radioButton7 != null) {
                                        i = R$id.rb_font_color_yellor;
                                        RadioButton radioButton8 = (RadioButton) f4.b.a(view, i);
                                        if (radioButton8 != null) {
                                            i = R$id.rg_background;
                                            RadioGroup radioGroup = (RadioGroup) f4.b.a(view, i);
                                            if (radioGroup != null) {
                                                i = R$id.rg_font_color;
                                                RadioGroup radioGroup2 = (RadioGroup) f4.b.a(view, i);
                                                if (radioGroup2 != null) {
                                                    i = R$id.seek_bar_font_size;
                                                    IndicatorSeekBar indicatorSeekBar = (IndicatorSeekBar) f4.b.a(view, i);
                                                    if (indicatorSeekBar != null && (a10 = f4.b.a(view, (i = R$id.seek_bar_position))) != null) {
                                                        i = R$id.seek_bart_background;
                                                        IndicatorSeekBar indicatorSeekBar2 = (IndicatorSeekBar) f4.b.a(view, i);
                                                        if (indicatorSeekBar2 != null && (a11 = f4.b.a(view, (i = R$id.switch_background))) != null && (a12 = f4.b.a(view, (i = R$id.switch_shadow))) != null && (a13 = f4.b.a(view, (i = R$id.tv_background_opacity_title))) != null && (a14 = f4.b.a(view, (i = R$id.tv_background_title))) != null && (a15 = f4.b.a(view, (i = R$id.tvFontColorTitle))) != null && (a16 = f4.b.a(view, (i = R$id.tv_font_size_title))) != null && (a17 = f4.b.a(view, (i = R$id.tv_position_title))) != null && (a18 = f4.b.a(view, (i = R$id.tv_reset))) != null && (a19 = f4.b.a(view, (i = R$id.tv_shadow_title))) != null && (a20 = f4.b.a(view, (i = R$id.tvStyle))) != null) {
                                                            return new i(view, a21, a, a2, a3, a4, a5, a6, a7, a8, a9, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioGroup, radioGroup2, indicatorSeekBar, a10, indicatorSeekBar2, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.layout_subtitle_options, viewGroup);
        return a(viewGroup);
    }

    public View getRoot() {
        return this.a;
    }
}
