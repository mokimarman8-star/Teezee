package com.transsion.publish.ui;

import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.therouter.TheRouter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$string;
import com.transsion.publish.adapter.SelectLocationAdapter;
import com.transsion.publish.viewmodel.LocationPlaceViewModel;
import com.transsion.room.api.bean.LocationPlace;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import wf.a;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u0011\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010<\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001d\u0010O\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/transsion/publish/ui/SelectLocationFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Llo/i;", "<init>", "()V", BuildConfig.FLAVOR, "checkGPS", "t0", "requestCurrentLocation", "A0", "r0", "D0", "F0", BuildConfig.FLAVOR, "type", "z0", "(I)V", BuildConfig.FLAVOR, "Lcom/transsion/room/api/bean/LocationPlace;", "list", "G0", "(Ljava/util/List;)V", "item", "B0", "(Lcom/transsion/room/api/bean/LocationPlace;)V", "Landroid/view/LayoutInflater;", "inflater", "s0", "(Landroid/view/LayoutInflater;)Llo/i;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "getPageStateLayoutTitle", "()Ljava/lang/String;", "getEmptyDescText", "initViewData", "initViewModel", "initListener", "retryLoadData", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "Lcom/transsion/publish/adapter/SelectLocationAdapter;", "a", "Lcom/transsion/publish/adapter/SelectLocationAdapter;", "mAdapter", "Lcom/transsion/publish/viewmodel/LocationPlaceViewModel;", "b", "Lcom/transsion/publish/viewmodel/LocationPlaceViewModel;", "mViewModel", BuildConfig.FLAVOR, "c", "Ljava/lang/Double;", "lat", "d", "lon", "e", "Ljava/lang/String;", "countryCode", "f", "Lcom/transsion/room/api/bean/LocationPlace;", "curLocationPlace", "g", "Landroid/view/View;", "mLoadingView", "h", "I", "placeType", "Lep/c;", "i", "Lep/c;", "mGpsServiceHelper", "Lep/f;", "j", "Lkotlin/Lazy;", "getMRoomApi", "()Lep/f;", "mRoomApi", "k", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SelectLocationFragment extends PageStatusFragment<lo.i> {

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private SelectLocationAdapter mAdapter;

    /* renamed from: b, reason: from kotlin metadata */
    private LocationPlaceViewModel mViewModel;

    /* renamed from: c, reason: from kotlin metadata */
    private Double lat;

    /* renamed from: d, reason: from kotlin metadata */
    private Double lon;

    /* renamed from: e, reason: from kotlin metadata */
    private String countryCode;

    /* renamed from: f, reason: from kotlin metadata */
    private LocationPlace curLocationPlace;

    /* renamed from: g, reason: from kotlin metadata */
    private View mLoadingView;

    /* renamed from: h, reason: from kotlin metadata */
    private int placeType;

    /* renamed from: i, reason: from kotlin metadata */
    private ep.c mGpsServiceHelper;

    /* renamed from: j, reason: from kotlin metadata */
    private final Lazy mRoomApi = LazyKt.b(new Function0() { // from class: com.transsion.publish.ui.r0
        public final Object invoke() {
            ep.f mRoomApi_delegate$lambda$0;
            mRoomApi_delegate$lambda$0 = SelectLocationFragment.mRoomApi_delegate$lambda$0();
            return mRoomApi_delegate$lambda$0;
        }
    });

    /* renamed from: com.transsion.publish.ui.SelectLocationFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SelectLocationFragment a(LocationPlace locationPlace) {
            SelectLocationFragment selectLocationFragment = new SelectLocationFragment();
            selectLocationFragment.setArguments(androidx.core.os.d.b(new Pair[]{TuplesKt.a("location_data", locationPlace)}));
            return selectLocationFragment;
        }
    }

    static final class b implements androidx.lifecycle.c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    private final void A0() {
        SelectLocationAdapter selectLocationAdapter = this.mAdapter;
        if (selectLocationAdapter != null) {
            selectLocationAdapter.D1(this.lat, this.lon);
        }
        a.a.f(wf.a.a, "LocationS", "Select--- get location success, placeType:" + this.placeType + ", do next", false, 4, (Object) null);
        int i = this.placeType;
        if (i == 0) {
            r0();
        } else if (i == 1) {
            F0();
        } else if (i == 2) {
            z0(2);
        }
        if (this.lat == null || this.lon == null) {
            return;
        }
        com.transsion.baselib.report.launch.b.a.b().putString("key_lo_last_lat_lon", this.lat + "," + this.lon);
    }

    private final void B0(LocationPlace item) {
        jo.b bVar = new jo.b();
        bVar.o(8);
        bVar.n(1);
        bVar.q(item);
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = jo.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.postEvent(name, bVar, 0L);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(SelectLocationFragment selectLocationFragment, LocationPlace locationPlace) {
        if (locationPlace == null) {
            a.a.f(wf.a.a, "LocationS", "Select--- get location fail", false, 4, (Object) null);
            selectLocationFragment.showContentView();
            SelectLocationAdapter selectLocationAdapter = selectLocationFragment.mAdapter;
            if (selectLocationAdapter != null) {
                selectLocationAdapter.Y0(selectLocationFragment.getErrorView(false));
            }
            return Unit.a;
        }
        selectLocationFragment.lat = locationPlace.getLat();
        selectLocationFragment.lon = locationPlace.getLon();
        Address locationAddress = locationPlace.getLocationAddress();
        selectLocationFragment.countryCode = locationAddress != null ? locationAddress.getCountryCode() : null;
        selectLocationFragment.curLocationPlace = locationPlace;
        selectLocationFragment.A0();
        return Unit.a;
    }

    private final void D0() {
        Double d = this.lat;
        if (d != null) {
            double doubleValue = d.doubleValue();
            Double d2 = this.lon;
            if (d2 != null) {
                double doubleValue2 = d2.doubleValue();
                ep.f mRoomApi = getMRoomApi();
                if (mRoomApi != null) {
                    mRoomApi.e(doubleValue, doubleValue2, new Function1() { // from class: com.transsion.publish.ui.y0
                        public final Object invoke(Object obj) {
                            Unit E0;
                            E0 = SelectLocationFragment.E0(SelectLocationFragment.this, (List) obj);
                            return E0;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(SelectLocationFragment selectLocationFragment, List list) {
        String name;
        String distance;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            selectLocationFragment.z0(0);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((LocationPlace) it.next()).setCountryCode(selectLocationFragment.countryCode);
            }
            LocationPlaceViewModel locationPlaceViewModel = selectLocationFragment.mViewModel;
            if (locationPlaceViewModel != null) {
                locationPlaceViewModel.o(list);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list2);
            LocationPlace locationPlace = selectLocationFragment.curLocationPlace;
            if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
                arrayList.add(locationPlace);
            }
            selectLocationFragment.G0(arrayList);
        }
        return Unit.a;
    }

    private final void F0() {
        LocationPlaceViewModel locationPlaceViewModel = this.mViewModel;
        if (locationPlaceViewModel != null) {
            Double d = this.lat;
            Double valueOf = Double.valueOf(d != null ? d.doubleValue() : 0.0d);
            Double d2 = this.lon;
            locationPlaceViewModel.k(valueOf, Double.valueOf(d2 != null ? d2.doubleValue() : 0.0d));
        }
    }

    private final void G0(List list) {
        showContentView();
        if (list.isEmpty()) {
            showEmptyView(false);
            return;
        }
        SelectLocationAdapter selectLocationAdapter = this.mAdapter;
        if (selectLocationAdapter != null) {
            selectLocationAdapter.n1(CollectionsKt.U0(list));
        }
    }

    private final void checkGPS() {
        LinearLayout linearLayout;
        ep.c cVar = this.mGpsServiceHelper;
        if (cVar == null || !cVar.b()) {
            lo.i iVar = (lo.i) getMViewBinding();
            if (iVar == null || (linearLayout = iVar.b) == null) {
                return;
            }
            uf.c.k(linearLayout);
            return;
        }
        if (this.lon == null || this.lat == null) {
            a.a.r(wf.a.a, "LocationS", new String[]{"Select---GPS is open, location null, get location----"}, false, 4, (Object) null);
            requestCurrentLocation();
        } else {
            a.a.r(wf.a.a, "LocationS", new String[]{"Select---GPS is open, location not null"}, false, 4, (Object) null);
            A0();
        }
    }

    private final ep.f getMRoomApi() {
        return (ep.f) this.mRoomApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ep.f mRoomApi_delegate$lambda$0() {
        return (ep.f) TheRouter.d(ep.f.class, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
    
        if (r6.b(r7, r4.doubleValue(), r3.doubleValue(), r1.doubleValue()) > 30000.0f) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void r0() {
        boolean z;
        Object obj;
        a.a.f(wf.a.a, "LocationS", "Select--- client, getCache", false, 4, (Object) null);
        String string = com.transsion.baselib.report.launch.b.a.b().getString("key_lo_last_lat_lon", (String) null);
        if (string != null) {
            try {
                Result.Companion companion = Result.Companion;
                List S0 = StringsKt.S0(string, new String[]{","}, false, 0, 6, (Object) null);
                if (!S0.isEmpty()) {
                    z = false;
                    Double s = StringsKt.s((String) S0.get(0));
                    Double s2 = StringsKt.s((String) S0.get(1));
                    Double d = this.lat;
                    if (d != null && this.lon != null && s != null && s2 != null) {
                        ij.s sVar = ij.s.a;
                        Intrinsics.e(d);
                        double doubleValue = d.doubleValue();
                        Double d2 = this.lon;
                        Intrinsics.e(d2);
                    }
                }
                z = true;
                try {
                    obj = Result.constructor-impl(Unit.a);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.a(th));
                    Result.box-impl(obj);
                    if (!z) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
            Result.box-impl(obj);
        } else {
            z = true;
        }
        if (!z) {
            LocationPlaceViewModel locationPlaceViewModel = this.mViewModel;
            if (locationPlaceViewModel != null) {
                locationPlaceViewModel.i();
                return;
            }
            return;
        }
        wf.a.a.c("LocationS", "Select--- client 已超距离，清除缓存，使用 getNearbyPlaces", true);
        LocationPlaceViewModel locationPlaceViewModel2 = this.mViewModel;
        if (locationPlaceViewModel2 != null) {
            locationPlaceViewModel2.h();
        }
        D0();
    }

    private final void requestCurrentLocation() {
        ep.f mRoomApi;
        showLoadingView();
        FragmentActivity activity = getActivity();
        if (activity == null || (mRoomApi = getMRoomApi()) == null) {
            return;
        }
        mRoomApi.b(activity, new Function1() { // from class: com.transsion.publish.ui.w0
            public final Object invoke(Object obj) {
                Unit C0;
                C0 = SelectLocationFragment.C0(SelectLocationFragment.this, (LocationPlace) obj);
                return C0;
            }
        });
    }

    private final void t0() {
        Integer v;
        ConfigBean c = cm.f.c.a().c("sa_use_server_place", true);
        String value = c != null ? c.getValue() : null;
        int i = 0;
        if (value != null && value.length() != 0 && (v = StringsKt.v(value)) != null) {
            i = v.intValue();
        }
        this.placeType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(final SelectLocationFragment selectLocationFragment, View view) {
        ep.c cVar;
        a.a.f(wf.a.a, "LocationS", "Select--- openGPS click", false, 4, (Object) null);
        if (selectLocationFragment.getActivity() == null || (cVar = selectLocationFragment.mGpsServiceHelper) == null) {
            return;
        }
        cVar.a(new Function1() { // from class: com.transsion.publish.ui.x0
            public final Object invoke(Object obj) {
                Unit v0;
                v0 = SelectLocationFragment.v0(SelectLocationFragment.this, ((Boolean) obj).booleanValue());
                return v0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(SelectLocationFragment selectLocationFragment, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        if (z) {
            lo.i iVar = (lo.i) selectLocationFragment.getMViewBinding();
            if (iVar != null && (linearLayout2 = iVar.b) != null) {
                uf.c.g(linearLayout2);
            }
            selectLocationFragment.requestCurrentLocation();
        } else {
            lo.i iVar2 = (lo.i) selectLocationFragment.getMViewBinding();
            if (iVar2 != null && (linearLayout = iVar2.b) != null) {
                uf.c.k(linearLayout);
            }
        }
        a.a.f(wf.a.a, "LocationS", "Select--- openGPS result:" + z, false, 4, (Object) null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(SelectLocationFragment selectLocationFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.a.a(view.getId(), 500L)) {
            return;
        }
        Object item = baseQuickAdapter.getItem(i);
        LocationPlace locationPlace = item instanceof LocationPlace ? (LocationPlace) item : null;
        if (locationPlace == null) {
            return;
        }
        selectLocationFragment.B0(locationPlace);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(SelectLocationFragment selectLocationFragment, List list) {
        String name;
        String distance;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            wf.a.a.c("LocationS", "Select--- server, 无数据", true);
            selectLocationFragment.z0(1);
        } else {
            List U0 = CollectionsKt.U0(list2);
            wf.a.a.c("LocationS", "Select--- server,有数据展示，count:" + list.size(), true);
            LocationPlace locationPlace = selectLocationFragment.curLocationPlace;
            if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
                U0.add(0, locationPlace);
            }
            selectLocationFragment.G0(U0);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(SelectLocationFragment selectLocationFragment, List list) {
        String name;
        String distance;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            wf.a.a.c("LocationS", "Select--- client 无缓存 getNearbyPlaces", true);
            selectLocationFragment.D0();
        } else {
            List U0 = CollectionsKt.U0(list2);
            wf.a.a.c("LocationS", "Select--- client, 有缓存，使用缓存数据，count:" + list.size(), true);
            LocationPlace locationPlace = selectLocationFragment.curLocationPlace;
            if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
                U0.add(0, locationPlace);
            }
            selectLocationFragment.G0(U0);
        }
        return Unit.a;
    }

    private final void z0(int type) {
        String name;
        String distance;
        ArrayList arrayList = new ArrayList();
        LocationPlace locationPlace = this.curLocationPlace;
        if (locationPlace != null && (name = locationPlace.getName()) != null && name.length() != 0 && (distance = locationPlace.getDistance()) != null && distance.length() != 0) {
            arrayList.add(locationPlace);
        }
        G0(arrayList);
    }

    public String getEmptyDescText() {
        String string = Utils.a().getString(R$string.location_fail_tips);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    public View getLoadingView() {
        if (this.mLoadingView == null) {
            this.mLoadingView = LayoutInflater.from(requireContext()).inflate(R$layout.layout_select_location_loading, (ViewGroup) getFlStateView(), false);
        }
        return this.mLoadingView;
    }

    public String getPageStateLayoutTitle() {
        return BuildConfig.FLAVOR;
    }

    public void initListener() {
        AppCompatTextView appCompatTextView;
        lo.i iVar = (lo.i) getMViewBinding();
        if (iVar == null || (appCompatTextView = iVar.d) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectLocationFragment.u0(SelectLocationFragment.this, view);
            }
        });
    }

    public void initViewData() {
        RecyclerView recyclerView;
        t0();
        SelectLocationAdapter selectLocationAdapter = new SelectLocationAdapter();
        selectLocationAdapter.w1(new r6.d() { // from class: com.transsion.publish.ui.s0
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectLocationFragment.w0(SelectLocationFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.mAdapter = selectLocationAdapter;
        lo.i iVar = (lo.i) getMViewBinding();
        if (iVar == null || (recyclerView = iVar.c) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.mAdapter);
    }

    public void initViewModel() {
        LocationPlaceViewModel locationPlaceViewModel = (LocationPlaceViewModel) new androidx.lifecycle.v0(this).a(LocationPlaceViewModel.class);
        locationPlaceViewModel.l().j(this, new b(new Function1() { // from class: com.transsion.publish.ui.u0
            public final Object invoke(Object obj) {
                Unit x0;
                x0 = SelectLocationFragment.x0(SelectLocationFragment.this, (List) obj);
                return x0;
            }
        }));
        locationPlaceViewModel.j().j(this, new b(new Function1() { // from class: com.transsion.publish.ui.v0
            public final Object invoke(Object obj) {
                Unit y0;
                y0 = SelectLocationFragment.y0(SelectLocationFragment.this, (List) obj);
                return y0;
            }
        }));
        this.mViewModel = locationPlaceViewModel;
        checkGPS();
    }

    public void onCreate(Bundle savedInstanceState) {
        LocationPlace locationPlace;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("location_data") : null;
        LocationPlace locationPlace2 = serializable instanceof LocationPlace ? (LocationPlace) serializable : null;
        this.curLocationPlace = locationPlace2;
        a.a aVar = wf.a.a;
        Double lat = locationPlace2 != null ? locationPlace2.getLat() : null;
        LocationPlace locationPlace3 = this.curLocationPlace;
        Double lon = locationPlace3 != null ? locationPlace3.getLon() : null;
        LocationPlace locationPlace4 = this.curLocationPlace;
        String name = locationPlace4 != null ? locationPlace4.getName() : null;
        LocationPlace locationPlace5 = this.curLocationPlace;
        a.a.v(aVar, "LocationS", "Select--- onCreate, lat:" + lat + ", lon：" + lon + " name:" + name + ",distance:" + (locationPlace5 != null ? locationPlace5.getDistance() : null), false, 4, (Object) null);
        LocationPlace locationPlace6 = this.curLocationPlace;
        if (locationPlace6 != null) {
            String distance = locationPlace6 != null ? locationPlace6.getDistance() : null;
            if ((distance == null || distance.length() == 0) && (locationPlace = this.curLocationPlace) != null) {
                locationPlace.setDistance("<1m");
            }
            LocationPlace locationPlace7 = this.curLocationPlace;
            this.lat = locationPlace7 != null ? locationPlace7.getLat() : null;
            LocationPlace locationPlace8 = this.curLocationPlace;
            this.lon = locationPlace8 != null ? locationPlace8.getLon() : null;
            LocationPlace locationPlace9 = this.curLocationPlace;
            this.countryCode = locationPlace9 != null ? locationPlace9.getCountryCode() : null;
        }
        ep.f mRoomApi = getMRoomApi();
        this.mGpsServiceHelper = mRoomApi != null ? mRoomApi.f(this) : null;
    }

    public void retryLoadData() {
        requestCurrentLocation();
    }

    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public lo.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        lo.i c = lo.i.c(inflater);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }
}
