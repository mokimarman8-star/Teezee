package com.noober.background;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.f;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class BackgroundLibrary$a implements LayoutInflater.Factory {
    final /* synthetic */ f a;

    BackgroundLibrary$a(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.a.l((View) null, str, context, attributeSet);
    }
}
