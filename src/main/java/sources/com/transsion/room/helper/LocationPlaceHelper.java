package com.transsion.room.helper;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.permissionx.guolindev.callback.PermissionDialogClickType;
import com.tn.lib.widget.R;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.room.api.bean.LocationPlace;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocationPlaceHelper {
    public static final LocationPlaceHelper a = new LocationPlaceHelper();
    private static PlacesClient b;
    private static LocationCallback c;
    private static int d;

    private LocationPlaceHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(final FusedLocationProviderClient fusedLocationProviderClient) {
        int i = d;
        if (i >= 3) {
            wf.a.a.u("LocationP", "Location--update---- removeLocationUpdates, 超过上限3次，不再移除", true);
            return;
        }
        d = i + 1;
        LocationCallback locationCallback = c;
        if (locationCallback != null) {
            wf.a.a.u("LocationP", "Location--update---- removeLocationUpdates", true);
            fusedLocationProviderClient.removeLocationUpdates(locationCallback).addOnCompleteListener(new OnCompleteListener() { // from class: com.transsion.room.helper.k
                public final void onComplete(Task task) {
                    LocationPlaceHelper.B(fusedLocationProviderClient, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(FusedLocationProviderClient fusedLocationProviderClient, Task task) {
        Intrinsics.h(task, "task");
        if (task.isSuccessful()) {
            c = null;
            a.a.x(wf.a.a, "LocationP", "Location--update----成功移除监听", false, 4, (Object) null);
        } else {
            a.a.l(wf.a.a, "LocationP", "Location--update----移除监听失败", false, 4, (Object) null);
            a.A(fusedLocationProviderClient);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LocationPlace l(double d2, double d3, Address address) {
        boolean z;
        Integer num;
        String str;
        String addressLine = (address != null ? address.getMaxAddressLineIndex() : 0) >= 0 ? address != null ? address.getAddressLine(0) : null : BuildConfig.FLAVOR;
        if (addressLine == null || addressLine.length() == 0) {
            if (addressLine != null) {
                if (address == null || (str = address.getCountryName()) == null) {
                    str = "-";
                }
                num = Integer.valueOf(StringsKt.o0(addressLine, str, 0, false, 6, (Object) null));
            } else {
                num = null;
            }
            if ((num != null ? num.intValue() : 0) < 5) {
                z = true;
                ArrayList arrayList = new ArrayList();
                if ((address == null ? address.getLocality() : null) != null) {
                    String locality = address.getLocality();
                    Intrinsics.g(locality, "getLocality(...)");
                    if (locality.length() > 0) {
                        String locality2 = address.getLocality();
                        Intrinsics.g(locality2, "getLocality(...)");
                        arrayList.add(locality2);
                    }
                }
                if ((address == null ? address.getSubLocality() : null) != null) {
                    String subLocality = address.getSubLocality();
                    Intrinsics.g(subLocality, "getSubLocality(...)");
                    if (subLocality.length() > 0) {
                        String subLocality2 = address.getSubLocality();
                        Intrinsics.g(subLocality2, "getSubLocality(...)");
                        arrayList.add(subLocality2);
                    }
                }
                if ((address == null ? address.getThoroughfare() : null) != null) {
                    String thoroughfare = address.getThoroughfare();
                    Intrinsics.g(thoroughfare, "getThoroughfare(...)");
                    if (thoroughfare.length() > 0) {
                        String thoroughfare2 = address.getThoroughfare();
                        Intrinsics.g(thoroughfare2, "getThoroughfare(...)");
                        arrayList.add(thoroughfare2);
                    }
                }
                if ((address == null ? address.getFeatureName() : null) != null) {
                    String featureName = address.getFeatureName();
                    Intrinsics.g(featureName, "getFeatureName(...)");
                    if (featureName.length() > 0) {
                        String featureName2 = address.getFeatureName();
                        Intrinsics.g(featureName2, "getFeatureName(...)");
                        arrayList.add(featureName2);
                    }
                }
                String s0 = !z ? CollectionsKt.s0(arrayList, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : CollectionsKt.s0(CollectionsKt.U(arrayList), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                LocationPlace locationPlace = new LocationPlace(null, null, null, null, 15, null);
                locationPlace.setName(s0);
                locationPlace.setDistance("<1m");
                locationPlace.setAddress(addressLine);
                locationPlace.setLocationAddress(address);
                locationPlace.setCountryCode(address != null ? address.getCountryCode() : null);
                locationPlace.setLat(Double.valueOf(d2));
                locationPlace.setLon(Double.valueOf(d3));
                return locationPlace;
            }
        }
        z = false;
        ArrayList arrayList2 = new ArrayList();
        if ((address == null ? address.getLocality() : null) != null) {
        }
        if ((address == null ? address.getSubLocality() : null) != null) {
        }
        if ((address == null ? address.getThoroughfare() : null) != null) {
        }
        if ((address == null ? address.getFeatureName() : null) != null) {
        }
        if (!z) {
        }
        LocationPlace locationPlace2 = new LocationPlace(null, null, null, null, 15, null);
        locationPlace2.setName(s0);
        locationPlace2.setDistance("<1m");
        locationPlace2.setAddress(addressLine);
        locationPlace2.setLocationAddress(address);
        locationPlace2.setCountryCode(address != null ? address.getCountryCode() : null);
        locationPlace2.setLat(Double.valueOf(d2));
        locationPlace2.setLon(Double.valueOf(d3));
        return locationPlace2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Address m(double d2, double d3) {
        try {
            List<Address> fromLocation = new Geocoder(Utils.a(), Locale.getDefault()).getFromLocation(d2, d3, 1);
            List<Address> list = fromLocation;
            if (list != null && !list.isEmpty()) {
                return fromLocation.get(0);
            }
            return null;
        } catch (Throwable th2) {
            a.a.l(wf.a.a, "LocationP", "Location-------------- ll2address error:" + th2, false, 4, (Object) null);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FusedLocationProviderClient fusedLocationProviderClient, Function1 function1, Task task) {
        Intrinsics.h(task, "task");
        if (!task.isSuccessful()) {
            wf.a.a.i("LocationP", "Location-------------- fail: " + task.getException() + ", do update", true);
            a.y(fusedLocationProviderClient, function1);
            return;
        }
        Location location = (Location) task.getResult();
        if (location == null) {
            wf.a.a.i("LocationP", "Location-------------- fail: location null---do update", true);
            a.y(fusedLocationProviderClient, function1);
            return;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        wf.a.a.c("LocationP", "Location--------------1 success " + longitude + ", :" + latitude, true);
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new LocationPlaceHelper$getCurrentLocation$2$1(latitude, longitude, function1, null), 3, (Object) null);
    }

    private final void q(double d2, double d3, Function1 function1) {
        String r = r();
        if (r == null || r.length() == 0) {
            a.a.f(wf.a.a, "LocationP", "getNearbyPlaces apiKey isNullOrEmpty", false, 4, (Object) null);
            function1.invoke((Object) null);
            return;
        }
        if (!Places.isInitialized()) {
            a.a.r(wf.a.a, "LocationP", new String[]{"getNearbyPlaces initialize place"}, false, 4, (Object) null);
            Places.initialize(Utils.a(), r);
        }
        if (b == null) {
            b = Places.createClient(Utils.a());
        }
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new LocationPlaceHelper$getNearbyPlacesWithDetailApi$1(function1, FindCurrentPlaceRequest.newInstance(CollectionsKt.o(new Place.Field[]{Place.Field.NAME, Place.Field.ADDRESS, Place.Field.LAT_LNG})), new LatLng(d2, d3), null), 3, (Object) null);
    }

    private final String r() {
        String str;
        ConfigBean c2 = cm.f.c.a().c("sa_lo_place_key", true);
        String value = c2 != null ? c2.getValue() : null;
        if (value == null || value.length() == 0 || (str = value.toString()) == null) {
            return null;
        }
        return str;
    }

    private final int s() {
        Integer v;
        ConfigBean c2 = cm.f.c.a().c("sa_lo_place_api", true);
        String value = c2 != null ? c2.getValue() : null;
        if (value == null || value.length() == 0 || (v = StringsKt.v(value)) == null) {
            return 1;
        }
        return v.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(boolean z, gf.f fVar, List list, boolean z2, boolean z3) {
        Intrinsics.h(fVar, "scope");
        Intrinsics.h(list, "deniedList");
        if (!z2) {
            a.a.f(wf.a.a, "LocationP", "location 请求权限之后，", false, 4, (Object) null);
            return;
        }
        if (!z3) {
            a.a.f(wf.a.a, "LocationP", "直接请求权限", false, 4, (Object) null);
            fVar.b(list);
        } else if (!z) {
            fVar.a(list);
        } else {
            a.a.f(wf.a.a, "LocationP", "请求权限，需要跳到设置页，先展示提示弹窗", false, 4, (Object) null);
            fVar.c(list, new ff.a((String) null, Utils.a().getString(R.string.location_permission_dialog_tips), Utils.a().getString(R.string.Enable), Integer.valueOf(R.drawable.ic_location_permission_tips), Integer.valueOf(R.color.white_20), 1, (DefaultConstructorMarker) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(FragmentActivity fragmentActivity, Function1 function1, boolean z, List list, List list2) {
        Intrinsics.h(list, "grantedList");
        Intrinsics.h(list2, "deniedList");
        if (z && list.size() == 1 && !ActivityCompat.j(fragmentActivity, (String) list.get(0))) {
            cf.c.a.d().putBoolean((String) list.get(0), false);
        }
        a.a.f(wf.a.a, "LocationP", "location 请求权限结果:" + z, false, 4, (Object) null);
        function1.invoke(Boolean.valueOf(z));
    }

    private final void x(Double d2, Double d3, Function1 function1) {
        if (d2 == null || d3 == null) {
            function1.invoke((Object) null);
            return;
        }
        String r = r();
        if (r == null || r.length() == 0) {
            function1.invoke((Object) null);
            return;
        }
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new LocationPlaceHelper$searchNearbyPlaces$1(d2 + "," + d3, 20000, r, d2, d3, function1, null), 3, (Object) null);
    }

    private final void y(final FusedLocationProviderClient fusedLocationProviderClient, final Function1 function1) {
        LocationRequest build = new LocationRequest.Builder(100, 10000L).setWaitForAccurateLocation(true).setMinUpdateIntervalMillis(5000L).build();
        Intrinsics.g(build, "build(...)");
        LocationCallback locationCallback = new LocationCallback() { // from class: com.transsion.room.helper.LocationPlaceHelper$startRealTimeUpdates$1
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                Intrinsics.h(locationAvailability, "availability");
                if (locationAvailability.isLocationAvailable()) {
                    return;
                }
                wf.a.a.w("LocationP", "Location services unavailable", true);
            }

            public void onLocationResult(LocationResult locationResult) {
                Intrinsics.h(locationResult, "result");
                Location lastLocation = locationResult.getLastLocation();
                if (lastLocation != null) {
                    FusedLocationProviderClient fusedLocationProviderClient2 = fusedLocationProviderClient;
                    Function1 function12 = function1;
                    LocationPlaceHelper.d = 0;
                    LocationPlaceHelper.a.A(fusedLocationProviderClient2);
                    double latitude = lastLocation.getLatitude();
                    double longitude = lastLocation.getLongitude();
                    wf.a.a.c("LocationP", "Location--update--------------1 success " + latitude + ", :" + longitude, true);
                    if (kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$1$1(latitude, longitude, function12, null), 3, (Object) null) != null) {
                        return;
                    }
                }
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new LocationPlaceHelper$startRealTimeUpdates$1$onLocationResult$2$1(function1, null), 3, (Object) null);
            }
        };
        c = locationCallback;
        Intrinsics.f(locationCallback, "null cannot be cast to non-null type com.google.android.gms.location.LocationCallback");
        fusedLocationProviderClient.requestLocationUpdates(build, locationCallback, Looper.getMainLooper()).addOnFailureListener(new OnFailureListener() { // from class: com.transsion.room.helper.j
            public final void onFailure(Exception exc) {
                LocationPlaceHelper.z(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Exception exc) {
        Intrinsics.h(exc, "e");
        a.a.l(wf.a.a, "LocationP", "Updates request failed: " + exc.getMessage(), false, 4, (Object) null);
    }

    public final void n(FragmentActivity fragmentActivity, final Function1 function1) {
        Double s;
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(function1, "callback");
        a.a aVar = wf.a.a;
        a.a.f(aVar, "LocationP", "Location-------------- start getCurrentLocation", false, 4, (Object) null);
        String string = com.transsion.baselib.report.launch.b.a.b().getString("key_lo_mock_test_lab_lat", BuildConfig.FLAVOR);
        if (string != null && string.length() != 0 && StringsKt.c0(string, "|", false, 2, (Object) null)) {
            try {
                Result.Companion companion = Result.Companion;
                List S0 = StringsKt.S0(string, new String[]{"|"}, false, 0, 6, (Object) null);
                Double s2 = StringsKt.s((String) S0.get(0));
                if (s2 != null && (s = StringsKt.s((String) S0.get(1))) != null) {
                    String str = (String) S0.get(2);
                    String str2 = (String) S0.get(3);
                    LocationPlace locationPlace = new LocationPlace(null, null, null, null, 15, null);
                    locationPlace.setName(str);
                    locationPlace.setDistance("<1m");
                    locationPlace.setAddress(str2);
                    locationPlace.setLat(s2);
                    locationPlace.setLon(s);
                    aVar.c("LocationP", "Location-------------- mock 的定位数据 name:" + str + ",address:" + str2 + ".不使用实际定位,需要真实定位请求清楚mock数据", true);
                    function1.invoke(locationPlace);
                    return;
                }
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
        final FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(fragmentActivity);
        Intrinsics.g(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(fragmentActivity, new OnCompleteListener() { // from class: com.transsion.room.helper.f
            public final void onComplete(Task task) {
                LocationPlaceHelper.o(fusedLocationProviderClient, function1, task);
            }
        });
    }

    public final void p(double d2, double d3, Function1 function1) {
        Intrinsics.h(function1, "callback");
        int s = s();
        if (s == 0) {
            wf.a.a.c("LocationP", "place api use detail", true);
            q(d2, d3, function1);
        } else {
            if (s == 1) {
                wf.a.a.c("LocationP", "place api use search", true);
                x(Double.valueOf(d2), Double.valueOf(d3), function1);
                return;
            }
            wf.a.a.c("LocationP", "place api ,null " + s, true);
            function1.invoke((Object) null);
        }
    }

    public final void t(final FragmentActivity fragmentActivity, final boolean z, final Function1 function1) {
        Intrinsics.h(fragmentActivity, "activity");
        Intrinsics.h(function1, "callback");
        cf.c.a.e(fragmentActivity).b(new String[]{"android.permission.ACCESS_FINE_LOCATION"}).b().a(new df.b() { // from class: com.transsion.room.helper.g
            public final void a(gf.f fVar, List list, boolean z2, boolean z3) {
                LocationPlaceHelper.u(z, fVar, list, z2, z3);
            }
        }).c(new df.a() { // from class: com.transsion.room.helper.h
            public final void a(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
                LocationPlaceHelper.v(baseDialog, bool, permissionDialogClickType);
            }
        }).d(new df.c() { // from class: com.transsion.room.helper.i
            public final void a(boolean z2, List list, List list2) {
                LocationPlaceHelper.w(fragmentActivity, function1, z2, list, list2);
            }
        });
    }
}
