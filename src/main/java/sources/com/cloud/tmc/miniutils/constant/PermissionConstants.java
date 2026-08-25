package com.cloud.tmc.miniutils.constant;

import android.annotation.SuppressLint;
import android.os.Build;
import com.cloud.tmc.kernel.bridge.extension.BridgeResponse;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"InlinedApi"})
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PermissionConstants {
    public static final String ACTIVITY_RECOGNITION = "ACTIVITY_RECOGNITION";
    public static final String CALENDAR = "CALENDAR";
    public static final String CAMERA = "CAMERA";
    public static final String CONTACTS = "CONTACTS";
    public static final String LOCATION = "LOCATION";
    public static final String MEDIA = "MEDIA";
    public static final String MEDIA_AUDIO = "MEDIA_AUDIO";
    public static final String MEDIA_IMAGES = "MEDIA_IMAGES";
    public static final String MEDIA_IMAGES_VIDEO = "MEDIA_IMAGES_VIDEO";
    public static final String MEDIA_VIDEO = "MEDIA_VIDEO";
    public static final String MICROPHONE = "MICROPHONE";
    public static final String PHONE = "PHONE";
    public static final String SENSORS = "SENSORS";
    public static final String SMS = "SMS";
    public static final String STORAGE = "STORAGE";
    public static final String STORAGE_READ = "STORAGE_READ";
    public static final String STORAGE_WRITE = "STORAGE_WRITE";
    private static final String[] GROUP_CALENDAR = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    private static final String[] GROUP_CAMERA = {"android.permission.CAMERA"};
    private static final String[] GROUP_CONTACTS = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
    private static final String[] GROUP_LOCATION = {"android.permission.ACCESS_COARSE_LOCATION"};
    private static final String[] GROUP_MICROPHONE = {"android.permission.RECORD_AUDIO"};
    private static final String[] GROUP_PHONE = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
    private static final String[] GROUP_PHONE_BELOW_O = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
    private static final String[] GROUP_SENSORS = {"android.permission.BODY_SENSORS"};
    private static final String[] GROUP_SMS = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
    private static final String[] GROUP_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final String[] GROUP_STORAGE_READ = {"android.permission.READ_EXTERNAL_STORAGE"};
    private static final String[] GROUP_STORAGE_WRITE = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final String[] GROUP_SELECT_MEDIA = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
    private static final String[] GROUP_MEDIA = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"};
    private static final String[] GROUP_SELECT_MEDIA_IMAGES = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
    private static final String[] GROUP_MEDIA_IMAGES = {"android.permission.READ_MEDIA_IMAGES"};
    private static final String[] GROUP_SELECT_MEDIA_VIDEO = {"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
    private static final String[] GROUP_MEDIA_VIDEO = {"android.permission.READ_MEDIA_VIDEO"};
    private static final String[] GROUP_MEDIA_AUDIO = {"android.permission.READ_MEDIA_AUDIO"};
    private static final String[] GROUP_SELECT_MEDIA_IMAGES_VIDEO = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
    private static final String[] GROUP_MEDIA_IMAGES_VIDEO = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"};
    private static final String[] GROUP_ACTIVITY_RECOGNITION = {"android.permission.ACTIVITY_RECOGNITION"};

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionGroup {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00e2, code lost:
    
        if (r5.equals(com.cloud.tmc.miniutils.constant.PermissionConstants.LOCATION) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] getPermissions(String str) {
        char c = 0;
        if (str == null) {
            return new String[0];
        }
        switch (str.hashCode()) {
            case -1611296843:
                break;
            case -1596608551:
                if (str.equals(SENSORS)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1236952197:
                if (str.equals(MEDIA_AUDIO)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1217915872:
                if (str.equals(MEDIA_VIDEO)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1166291365:
                if (str.equals(STORAGE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1050739462:
                if (str.equals(STORAGE_READ)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 82233:
                if (str.equals(SMS)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 73234372:
                if (str.equals(MEDIA)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 76105038:
                if (str.equals(PHONE)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 140654183:
                if (str.equals(ACTIVITY_RECOGNITION)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 215175251:
                if (str.equals(CONTACTS)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 530741075:
                if (str.equals(MEDIA_IMAGES)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 604302142:
                if (str.equals(CALENDAR)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 827124847:
                if (str.equals(MEDIA_IMAGES_VIDEO)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 1791828187:
                if (str.equals(STORAGE_WRITE)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1856013610:
                if (str.equals(MICROPHONE)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1980544805:
                if (str.equals(CAMERA)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return GROUP_LOCATION;
            case 1:
                return GROUP_SENSORS;
            case 2:
                return Build.VERSION.SDK_INT >= 33 ? GROUP_MEDIA_AUDIO : GROUP_STORAGE;
            case 3:
                int i = Build.VERSION.SDK_INT;
                return i >= 34 ? GROUP_SELECT_MEDIA_VIDEO : i >= 33 ? GROUP_MEDIA_VIDEO : GROUP_STORAGE;
            case 4:
            case 7:
                int i2 = Build.VERSION.SDK_INT;
                return i2 >= 34 ? GROUP_SELECT_MEDIA : i2 >= 33 ? GROUP_MEDIA : GROUP_STORAGE;
            case 5:
                return Build.VERSION.SDK_INT >= 33 ? GROUP_MEDIA : GROUP_STORAGE_READ;
            case 6:
                return GROUP_SMS;
            case '\b':
                return Build.VERSION.SDK_INT < 26 ? GROUP_PHONE_BELOW_O : GROUP_PHONE;
            case '\t':
                return GROUP_ACTIVITY_RECOGNITION;
            case BridgeResponse.ERROR_CODE_UNAUTHORIZED_USERINFO /* 10 */:
                return GROUP_CONTACTS;
            case 11:
                int i3 = Build.VERSION.SDK_INT;
                return i3 >= 34 ? GROUP_SELECT_MEDIA_IMAGES : i3 >= 33 ? GROUP_MEDIA_IMAGES : GROUP_STORAGE;
            case '\f':
                return GROUP_CALENDAR;
            case '\r':
                int i4 = Build.VERSION.SDK_INT;
                return i4 >= 34 ? GROUP_SELECT_MEDIA_IMAGES_VIDEO : i4 >= 33 ? GROUP_MEDIA_IMAGES_VIDEO : GROUP_STORAGE;
            case 14:
                return Build.VERSION.SDK_INT >= 33 ? GROUP_MEDIA : GROUP_STORAGE_WRITE;
            case 15:
                return GROUP_MICROPHONE;
            case 16:
                return GROUP_CAMERA;
            default:
                return new String[]{str};
        }
    }
}
