package ff;

import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class b {
    private static final Set a = SetsKt.j(new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission.SYSTEM_ALERT_WINDOW", "android.permission.WRITE_SETTINGS", "android.permission.MANAGE_EXTERNAL_STORAGE", "android.permission.REQUEST_INSTALL_PACKAGES", "android.permission.POST_NOTIFICATIONS", "android.permission.PICTURE_IN_PICTURE", "android.permission.BODY_SENSORS_BACKGROUND"});
    private static final Map b;
    private static final Map c;
    private static final Map d;
    private static final Map e;

    static {
        Map l = MapsKt.l(new Pair[]{TuplesKt.a("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR"), TuplesKt.a("android.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR"), TuplesKt.a("android.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG"), TuplesKt.a("android.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG"), TuplesKt.a("android.permission.PROCESS_OUTGOING_CALLS", "android.permission-group.CALL_LOG"), TuplesKt.a("android.permission.CAMERA", "android.permission-group.CAMERA"), TuplesKt.a("android.permission.READ_CONTACTS", "android.permission-group.CONTACTS"), TuplesKt.a("android.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS"), TuplesKt.a("android.permission.GET_ACCOUNTS", "android.permission-group.CONTACTS"), TuplesKt.a("android.permission.ACCESS_FINE_LOCATION", "android.permission-group.LOCATION"), TuplesKt.a("android.permission.ACCESS_COARSE_LOCATION", "android.permission-group.LOCATION"), TuplesKt.a("android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission-group.LOCATION"), TuplesKt.a("android.permission.RECORD_AUDIO", "android.permission-group.MICROPHONE"), TuplesKt.a("android.permission.READ_PHONE_STATE", "android.permission-group.PHONE"), TuplesKt.a("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE"), TuplesKt.a("android.permission.CALL_PHONE", "android.permission-group.PHONE"), TuplesKt.a("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE"), TuplesKt.a("com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission-group.PHONE"), TuplesKt.a("android.permission.USE_SIP", "android.permission-group.PHONE"), TuplesKt.a("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE"), TuplesKt.a("android.permission.BODY_SENSORS", "android.permission-group.SENSORS"), TuplesKt.a("android.permission.ACTIVITY_RECOGNITION", "android.permission-group.ACTIVITY_RECOGNITION"), TuplesKt.a("android.permission.SEND_SMS", "android.permission-group.SMS"), TuplesKt.a("android.permission.RECEIVE_SMS", "android.permission-group.SMS"), TuplesKt.a("android.permission.READ_SMS", "android.permission-group.SMS"), TuplesKt.a("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS"), TuplesKt.a("android.permission.RECEIVE_MMS", "android.permission-group.SMS"), TuplesKt.a("android.permission.READ_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), TuplesKt.a("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission-group.STORAGE"), TuplesKt.a("android.permission.ACCESS_MEDIA_LOCATION", "android.permission-group.STORAGE")});
        b = l;
        Map w = MapsKt.w(MapsKt.f(TuplesKt.a("android.permission.MANAGE_EXTERNAL_STORAGE", "android.permission-group.STORAGE")));
        w.putAll(l);
        Map u = MapsKt.u(w);
        c = u;
        Map w2 = MapsKt.w(MapsKt.l(new Pair[]{TuplesKt.a("android.permission.BLUETOOTH_SCAN", "android.permission-group.NEARBY_DEVICES"), TuplesKt.a("android.permission.BLUETOOTH_ADVERTISE", "android.permission-group.NEARBY_DEVICES"), TuplesKt.a("android.permission.BLUETOOTH_CONNECT", "android.permission-group.NEARBY_DEVICES")}));
        w2.putAll(u);
        Map u2 = MapsKt.u(w2);
        d = u2;
        Map w3 = MapsKt.w(MapsKt.l(new Pair[]{TuplesKt.a("android.permission.READ_MEDIA_IMAGES", "android.permission-group.READ_MEDIA_VISUAL"), TuplesKt.a("android.permission.READ_MEDIA_VIDEO", "android.permission-group.READ_MEDIA_VISUAL"), TuplesKt.a("android.permission.READ_MEDIA_AUDIO", "android.permission-group.READ_MEDIA_AURAL"), TuplesKt.a("android.permission.POST_NOTIFICATIONS", "android.permission-group.NOTIFICATIONS"), TuplesKt.a("android.permission.NEARBY_WIFI_DEVICES", "android.permission-group.NEARBY_DEVICES"), TuplesKt.a("android.permission.BODY_SENSORS_BACKGROUND", "android.permission-group.SENSORS")}));
        w3.putAll(u2);
        e = MapsKt.u(w3);
    }

    public static final Set a() {
        return a;
    }
}
