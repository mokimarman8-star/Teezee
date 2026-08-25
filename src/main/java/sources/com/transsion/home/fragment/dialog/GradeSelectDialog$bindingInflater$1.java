package com.transsion.home.fragment.dialog;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
/* synthetic */ class GradeSelectDialog$bindingInflater$1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, qk.f> {
    public static final GradeSelectDialog$bindingInflater$1 INSTANCE = new GradeSelectDialog$bindingInflater$1();

    GradeSelectDialog$bindingInflater$1() {
        super(3, qk.f.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/home/databinding/DialogGradeSelectBinding;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
    }

    public final qk.f invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.h(layoutInflater, "p0");
        return qk.f.c(layoutInflater, viewGroup, z);
    }
}
