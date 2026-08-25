package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.database.DataSetObserver;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class CommonNavigator$a extends DataSetObserver {
    final /* synthetic */ CommonNavigator a;

    CommonNavigator$a(CommonNavigator commonNavigator) {
        this.a = commonNavigator;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        CommonNavigator.b(this.a).m(CommonNavigator.a(this.a).a());
        CommonNavigator.c(this.a);
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
    }
}
