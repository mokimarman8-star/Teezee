package com.hisavana.common.constant;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.baselib.report.recent_event.ActionEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ComConstants {
    public static final String AD_FLOW = "ad_flow";
    public static final int AD_TIMEOUT_MILLIS = 30000;
    public static final String AHA_CHANNEL = "aha";
    public static final String APPLOVIN_TAG = "applovin_log";
    public static final String APP_ACTIVE_TIME = "app_active_time";
    public static final String BIDDING_TIME_OUT = "bidding_time_out";
    public static final int CUSTOM_PARAMS_MAX_SIZE = 10;
    public static final String FIRST_START_FOR_ONE_DAY = "first_start_for_one_day";
    public static final String HOST_VERSION = "host_version";
    public static final String HS_APPID = "hs_appid";
    public static final String HS_VER = "hs_ver";
    public static final String IRON_SOURCE_TAG = "iron_source_log";
    public static final long IS_READY_INTERVAL_TIME = 1000;
    public static final String KEY_WORDS = "sensitive_keywords";
    public static final String PLATFORM_ADMOB = "admob";
    public static final String PLATFORM_FACEBOOK = "fan";
    public static final String PLATFORM_SSP = "ssp";
    public static final long REQ_CLOUD_CONFIG_INTERVAL_IF_NEED = 86400000;
    public static final String SDK_INIT = "sdk_init";
    public static final String SK_KEY_SPLASH_JUMP = "config_splash_jump";
    public static final String VIDEO_TAG = "video";
    public static final int defScheduleTime = 60000;
    public static final int sdkVersionCode = 359100;
    public static Boolean AUTOMATIC_TEST_STATUS = Boolean.FALSE;
    public static boolean LITE = false;
    public static int splashJumpSwitch = -1;
    public static volatile String fbBidToken = "";
    public static boolean isFbAppExist = false;
    public static int BID_PRICE_CACHE_TIME = 1800000;

    public static String getAdType(int i) {
        if (i == 10) {
            return "Native";
        }
        switch (i) {
            case 1:
                return "Native";
            case 2:
                return "Banner";
            case 3:
                return "Interstitia";
            case 4:
                return "Splash";
            case 5:
                return "Video";
            case 6:
                return "Icon";
            default:
                return "UNKNOW";
        }
    }

    public static String getSourceName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "Unknow" : "Fan" : "Admob" : "SSP";
    }

    public static TAdErrorCode transferCloudErrorCode(int i) {
        TAdErrorCode tAdErrorCode = TAdErrorCode.ERROR_AD_UNIT_CONFIG_EMPTY;
        switch (i) {
            case 3003000:
            case 3003001:
            case 3003006:
                return TAdErrorCode.ERROR_REQUEST_CLOUD_PARMER_EXCEPTION;
            case 3003002:
                return TAdErrorCode.ERROR_APPLICATION_IS_NOT_EXIST;
            case 3003003:
                return TAdErrorCode.ERROR_APPLICATION_IS_CLOSED;
            case 3003004:
            case 3003005:
            case 3003007:
            default:
                return tAdErrorCode;
            case 3003008:
                return TAdErrorCode.ERROR_PACKAGE_NAME_IS_INCONSISTENT;
            case 3003009:
                return TAdErrorCode.ERROR_OPERATING_SYSTEM_INCONSISTENCY;
        }
    }

    public static String transferSourceToStr(int i) {
        switch (i) {
            case 0:
                return PLATFORM_SSP;
            case 1:
                return PLATFORM_ADMOB;
            case 2:
                return PLATFORM_FACEBOOK;
            case 3:
                return "applovin";
            case 4:
                return "unity";
            case 5:
                return "IronSource";
            case 6:
                return "pangle";
            case 7:
            case 10:
            case 13:
            default:
                return "";
            case 8:
                return "inmobi";
            case 9:
                return "mintegral";
            case 11:
                return "adcolony";
            case 12:
                return "vungle";
            case ActionEvent.delete_comment /* 14 */:
                return "max";
            case ActionEvent.pageview /* 15 */:
                return "yandex";
            case 16:
                return "bigo";
            case ActionEvent.want_to_see_cancel /* 17 */:
                return "TopOn";
        }
    }
}
