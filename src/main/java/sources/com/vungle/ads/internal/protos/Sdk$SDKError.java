package com.vungle.ads.internal.protos;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.b1;
import com.google.protobuf.i;
import com.google.protobuf.o;
import com.google.protobuf.y;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class Sdk$SDKError extends GeneratedMessageLite implements d {
    public static final int ADSOURCE_FIELD_NUMBER = 16;
    public static final int APPSTATE_FIELD_NUMBER = 17;
    public static final int AT_FIELD_NUMBER = 1;
    public static final int CONNECTIONTYPEDETAILANDROID_FIELD_NUMBER = 101;
    public static final int CONNECTIONTYPEDETAIL_FIELD_NUMBER = 10;
    public static final int CONNECTIONTYPE_FIELD_NUMBER = 9;
    public static final int CREATIVEID_FIELD_NUMBER = 12;
    private static final Sdk$SDKError DEFAULT_INSTANCE;
    public static final int EVENTID_FIELD_NUMBER = 4;
    public static final int ISHBPLACEMENT_FIELD_NUMBER = 14;
    public static final int ISLOWDATAMODEENABLED_FIELD_NUMBER = 201;
    public static final int MAKE_FIELD_NUMBER = 5;
    public static final int MEDIATIONNAME_FIELD_NUMBER = 18;
    public static final int MESSAGE_FIELD_NUMBER = 3;
    public static final int MODEL_FIELD_NUMBER = 6;
    public static final int OSVERSION_FIELD_NUMBER = 8;
    public static final int OS_FIELD_NUMBER = 7;
    private static volatile b1 PARSER = null;
    public static final int PLACEMENTREFERENCEID_FIELD_NUMBER = 11;
    public static final int PLACEMENTTYPE_FIELD_NUMBER = 15;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int SESSIONID_FIELD_NUMBER = 13;
    public static final int VMVERSION_FIELD_NUMBER = 19;
    private long appState_;
    private long at_;
    private long isHbPlacement_;
    private boolean isLowDataModeEnabled_;
    private int reason_;
    private String message_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String eventId_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String make_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String model_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String os_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String osVersion_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String connectionType_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String connectionTypeDetail_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String placementReferenceId_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String creativeId_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String sessionId_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String placementType_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String adSource_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String mediationName_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String vmVersion_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String connectionTypeDetailAndroid_ = HttpUrl.FRAGMENT_ENCODE_SET;

    public enum Reason implements y.c {
        UNKNOWN_ERROR(0),
        INVALID_APP_ID(2),
        CURRENTLY_INITIALIZING(3),
        ALREADY_INITIALIZED(4),
        SDK_NOT_INITIALIZED(6),
        USER_AGENT_ERROR(7),
        API_REQUEST_ERROR(101),
        API_RESPONSE_DATA_ERROR(API_RESPONSE_DATA_ERROR_VALUE),
        API_RESPONSE_DECODE_ERROR(API_RESPONSE_DECODE_ERROR_VALUE),
        API_FAILED_STATUS_CODE(API_FAILED_STATUS_CODE_VALUE),
        INVALID_TEMPLATE_URL(INVALID_TEMPLATE_URL_VALUE),
        INVALID_REQUEST_BUILDER_ERROR(INVALID_REQUEST_BUILDER_ERROR_VALUE),
        TEMPLATE_UNZIP_ERROR(TEMPLATE_UNZIP_ERROR_VALUE),
        INVALID_CTA_URL(INVALID_CTA_URL_VALUE),
        INVALID_ASSET_URL(INVALID_ASSET_URL_VALUE),
        ASSET_REQUEST_ERROR(ASSET_REQUEST_ERROR_VALUE),
        ASSET_RESPONSE_DATA_ERROR(ASSET_RESPONSE_DATA_ERROR_VALUE),
        ASSET_WRITE_ERROR(ASSET_WRITE_ERROR_VALUE),
        INVALID_INDEX_URL(INVALID_INDEX_URL_VALUE),
        GZIP_ENCODE_ERROR(GZIP_ENCODE_ERROR_VALUE),
        ASSET_FAILED_STATUS_CODE(ASSET_FAILED_STATUS_CODE_VALUE),
        PROTOBUF_SERIALIZATION_ERROR(PROTOBUF_SERIALIZATION_ERROR_VALUE),
        JSON_ENCODE_ERROR(JSON_ENCODE_ERROR_VALUE),
        TPAT_ERROR(TPAT_ERROR_VALUE),
        INVALID_ADS_ENDPOINT(INVALID_ADS_ENDPOINT_VALUE),
        INVALID_RI_ENDPOINT(INVALID_RI_ENDPOINT_VALUE),
        INVALID_LOG_ERROR_ENDPOINT(INVALID_LOG_ERROR_ENDPOINT_VALUE),
        INVALID_METRICS_ENDPOINT(INVALID_METRICS_ENDPOINT_VALUE),
        ASSET_FAILED_INSUFFICIENT_SPACE(126),
        ASSET_FAILED_MAX_SPACE_EXCEEDED(127),
        INVALID_TPAT_KEY(128),
        EMPTY_TPAT_ERROR(EMPTY_TPAT_ERROR_VALUE),
        MRAID_DOWNLOAD_JS_ERROR(MRAID_DOWNLOAD_JS_ERROR_VALUE),
        MRAID_JS_WRITE_FAILED(MRAID_JS_WRITE_FAILED_VALUE),
        OMSDK_DOWNLOAD_JS_ERROR(OMSDK_DOWNLOAD_JS_ERROR_VALUE),
        OMSDK_JS_WRITE_FAILED(OMSDK_JS_WRITE_FAILED_VALUE),
        STORE_REGION_CODE_ERROR(STORE_REGION_CODE_ERROR_VALUE),
        INVALID_CONFIG_RESPONSE(INVALID_CONFIG_RESPONSE_VALUE),
        PRIVACY_URL_ERROR(PRIVACY_URL_ERROR_VALUE),
        TPAT_RETRY_FAILED(TPAT_RETRY_FAILED_VALUE),
        CONFIG_REFRESH_FAILED(CONFIG_REFRESH_FAILED_VALUE),
        INVALID_EVENT_ID_ERROR(INVALID_EVENT_ID_ERROR_VALUE),
        INVALID_PLACEMENT_ID(201),
        AD_CONSUMED(AD_CONSUMED_VALUE),
        AD_IS_LOADING(AD_IS_LOADING_VALUE),
        AD_ALREADY_LOADED(AD_ALREADY_LOADED_VALUE),
        AD_IS_PLAYING(AD_IS_PLAYING_VALUE),
        AD_ALREADY_FAILED(AD_ALREADY_FAILED_VALUE),
        PLACEMENT_AD_TYPE_MISMATCH(PLACEMENT_AD_TYPE_MISMATCH_VALUE),
        INVALID_BID_PAYLOAD(INVALID_BID_PAYLOAD_VALUE),
        INVALID_JSON_BID_PAYLOAD(INVALID_JSON_BID_PAYLOAD_VALUE),
        AD_NOT_LOADED(AD_NOT_LOADED_VALUE),
        PLACEMENT_SLEEP(PLACEMENT_SLEEP_VALUE),
        INVALID_ADUNIT_BID_PAYLOAD(INVALID_ADUNIT_BID_PAYLOAD_VALUE),
        INVALID_GZIP_BID_PAYLOAD(INVALID_GZIP_BID_PAYLOAD_VALUE),
        AD_RESPONSE_EMPTY(AD_RESPONSE_EMPTY_VALUE),
        AD_RESPONSE_INVALID_TEMPLATE_TYPE(AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE),
        AD_RESPONSE_TIMED_OUT(AD_RESPONSE_TIMED_OUT_VALUE),
        MRAID_JS_DOES_NOT_EXIST(MRAID_JS_DOES_NOT_EXIST_VALUE),
        MRAID_JS_COPY_FAILED(MRAID_JS_COPY_FAILED_VALUE),
        AD_RESPONSE_RETRY_AFTER(AD_RESPONSE_RETRY_AFTER_VALUE),
        AD_LOAD_FAIL_RETRY_AFTER(AD_LOAD_FAIL_RETRY_AFTER_VALUE),
        INVALID_WATERFALL_PLACEMENT_ID(INVALID_WATERFALL_PLACEMENT_ID_VALUE),
        STALE_CACHED_RESPONSE(STALE_CACHED_RESPONSE_VALUE),
        MRAID_ERROR(MRAID_ERROR_VALUE),
        INVALID_IFA_STATUS(INVALID_IFA_STATUS_VALUE),
        AD_EXPIRED(AD_EXPIRED_VALUE),
        MRAID_BRIDGE_ERROR(MRAID_BRIDGE_ERROR_VALUE),
        AD_EXPIRED_ON_PLAY(307),
        AD_WIN_NOTIFICATION_ERROR(308),
        ASSET_FAILED_TO_DELETE(ASSET_FAILED_TO_DELETE_VALUE),
        AD_HTML_FAILED_TO_LOAD(AD_HTML_FAILED_TO_LOAD_VALUE),
        MRAID_JS_CALL_EMPTY(MRAID_JS_CALL_EMPTY_VALUE),
        DEEPLINK_OPEN_FAILED(DEEPLINK_OPEN_FAILED_VALUE),
        EVALUATE_JAVASCRIPT_FAILED(EVALUATE_JAVASCRIPT_FAILED_VALUE),
        LINK_COMMAND_OPEN_FAILED(LINK_COMMAND_OPEN_FAILED_VALUE),
        JSON_PARAMS_ENCODE_ERROR(JSON_PARAMS_ENCODE_ERROR_VALUE),
        GENERATE_JSON_DATA_ERROR(GENERATE_JSON_DATA_ERROR_VALUE),
        AD_CLOSED_TEMPLATE_ERROR(AD_CLOSED_TEMPLATE_ERROR_VALUE),
        AD_CLOSED_MISSING_HEARTBEAT(AD_CLOSED_MISSING_HEARTBEAT_VALUE),
        SILENT_MODE_MONITOR_ERROR(SILENT_MODE_MONITOR_ERROR_VALUE),
        WEBVIEW_ERROR(WEBVIEW_ERROR_VALUE),
        CONCURRENT_PLAYBACK_UNSUPPORTED(CONCURRENT_PLAYBACK_UNSUPPORTED_VALUE),
        BANNER_VIEW_INVALID_SIZE(BANNER_VIEW_INVALID_SIZE_VALUE),
        NATIVE_ASSET_ERROR(NATIVE_ASSET_ERROR_VALUE),
        WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE(2000),
        WEB_VIEW_FAILED_NAVIGATION(2001),
        STORE_KIT_LOAD_ERROR(2002),
        OMSDK_COPY_ERROR(2003),
        STORE_OVERLAY_LOAD_ERROR(2004),
        REACHABILITY_INITIALIZATION_FAILED(2005),
        UNKNOWN_RADIO_ACCESS_TECHNOLOGY(2006),
        STORE_KIT_PRESENTATION_ERROR(2007),
        STORE_OVERLAY_PRESENTATION_ERROR(2008),
        INVALID_PLAY_PARAMETER(2009),
        OUT_OF_MEMORY(3001),
        VUNGLE_OIT_CREATION_ERROR(VUNGLE_OIT_CREATION_ERROR_VALUE),
        AD_NO_FILL(AD_NO_FILL_VALUE),
        AD_LOAD_TOO_FREQUENTLY(AD_LOAD_TOO_FREQUENTLY_VALUE),
        AD_SERVER_ERROR(AD_SERVER_ERROR_VALUE),
        AD_PUBLISHER_MISMATCH(AD_PUBLISHER_MISMATCH_VALUE),
        AD_INTERNAL_INTEGRATION_ERROR(AD_INTERNAL_INTEGRATION_ERROR_VALUE),
        CONFIG_NOT_FOUND_ERROR(CONFIG_NOT_FOUND_ERROR_VALUE),
        UNRECOGNIZED(-1);

        public static final int AD_ALREADY_FAILED_VALUE = 206;
        public static final int AD_ALREADY_LOADED_VALUE = 204;
        public static final int AD_CLOSED_MISSING_HEARTBEAT_VALUE = 318;
        public static final int AD_CLOSED_TEMPLATE_ERROR_VALUE = 317;
        public static final int AD_CONSUMED_VALUE = 202;
        public static final int AD_EXPIRED_ON_PLAY_VALUE = 307;
        public static final int AD_EXPIRED_VALUE = 304;
        public static final int AD_HTML_FAILED_TO_LOAD_VALUE = 310;
        public static final int AD_INTERNAL_INTEGRATION_ERROR_VALUE = 30002;
        public static final int AD_IS_LOADING_VALUE = 203;
        public static final int AD_IS_PLAYING_VALUE = 205;
        public static final int AD_LOAD_FAIL_RETRY_AFTER_VALUE = 221;
        public static final int AD_LOAD_TOO_FREQUENTLY_VALUE = 10002;
        public static final int AD_NOT_LOADED_VALUE = 210;
        public static final int AD_NO_FILL_VALUE = 10001;
        public static final int AD_PUBLISHER_MISMATCH_VALUE = 30001;
        public static final int AD_RESPONSE_EMPTY_VALUE = 215;
        public static final int AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE = 216;
        public static final int AD_RESPONSE_RETRY_AFTER_VALUE = 220;
        public static final int AD_RESPONSE_TIMED_OUT_VALUE = 217;
        public static final int AD_SERVER_ERROR_VALUE = 20001;

        @Deprecated
        public static final int AD_WIN_NOTIFICATION_ERROR_VALUE = 308;

        @Deprecated
        public static final int ALREADY_INITIALIZED_VALUE = 4;
        public static final int API_FAILED_STATUS_CODE_VALUE = 104;
        public static final int API_REQUEST_ERROR_VALUE = 101;
        public static final int API_RESPONSE_DATA_ERROR_VALUE = 102;
        public static final int API_RESPONSE_DECODE_ERROR_VALUE = 103;
        public static final int ASSET_FAILED_INSUFFICIENT_SPACE_VALUE = 126;

        @Deprecated
        public static final int ASSET_FAILED_MAX_SPACE_EXCEEDED_VALUE = 127;
        public static final int ASSET_FAILED_STATUS_CODE_VALUE = 117;
        public static final int ASSET_FAILED_TO_DELETE_VALUE = 309;
        public static final int ASSET_REQUEST_ERROR_VALUE = 112;
        public static final int ASSET_RESPONSE_DATA_ERROR_VALUE = 113;
        public static final int ASSET_WRITE_ERROR_VALUE = 114;
        public static final int BANNER_VIEW_INVALID_SIZE_VALUE = 500;
        public static final int CONCURRENT_PLAYBACK_UNSUPPORTED_VALUE = 400;
        public static final int CONFIG_NOT_FOUND_ERROR_VALUE = 30003;
        public static final int CONFIG_REFRESH_FAILED_VALUE = 138;

        @Deprecated
        public static final int CURRENTLY_INITIALIZING_VALUE = 3;
        public static final int DEEPLINK_OPEN_FAILED_VALUE = 312;
        public static final int EMPTY_TPAT_ERROR_VALUE = 129;
        public static final int EVALUATE_JAVASCRIPT_FAILED_VALUE = 313;
        public static final int GENERATE_JSON_DATA_ERROR_VALUE = 316;
        public static final int GZIP_ENCODE_ERROR_VALUE = 116;
        public static final int INVALID_ADS_ENDPOINT_VALUE = 122;
        public static final int INVALID_ADUNIT_BID_PAYLOAD_VALUE = 213;
        public static final int INVALID_APP_ID_VALUE = 2;
        public static final int INVALID_ASSET_URL_VALUE = 111;
        public static final int INVALID_BID_PAYLOAD_VALUE = 208;
        public static final int INVALID_CONFIG_RESPONSE_VALUE = 135;
        public static final int INVALID_CTA_URL_VALUE = 110;
        public static final int INVALID_EVENT_ID_ERROR_VALUE = 200;
        public static final int INVALID_GZIP_BID_PAYLOAD_VALUE = 214;
        public static final int INVALID_IFA_STATUS_VALUE = 302;
        public static final int INVALID_INDEX_URL_VALUE = 115;
        public static final int INVALID_JSON_BID_PAYLOAD_VALUE = 209;
        public static final int INVALID_LOG_ERROR_ENDPOINT_VALUE = 124;
        public static final int INVALID_METRICS_ENDPOINT_VALUE = 125;
        public static final int INVALID_PLACEMENT_ID_VALUE = 201;
        public static final int INVALID_PLAY_PARAMETER_VALUE = 2009;
        public static final int INVALID_REQUEST_BUILDER_ERROR_VALUE = 106;
        public static final int INVALID_RI_ENDPOINT_VALUE = 123;
        public static final int INVALID_TEMPLATE_URL_VALUE = 105;
        public static final int INVALID_TPAT_KEY_VALUE = 128;
        public static final int INVALID_WATERFALL_PLACEMENT_ID_VALUE = 222;
        public static final int JSON_ENCODE_ERROR_VALUE = 119;
        public static final int JSON_PARAMS_ENCODE_ERROR_VALUE = 315;
        public static final int LINK_COMMAND_OPEN_FAILED_VALUE = 314;
        public static final int MRAID_BRIDGE_ERROR_VALUE = 305;
        public static final int MRAID_DOWNLOAD_JS_ERROR_VALUE = 130;
        public static final int MRAID_ERROR_VALUE = 301;
        public static final int MRAID_JS_CALL_EMPTY_VALUE = 311;
        public static final int MRAID_JS_COPY_FAILED_VALUE = 219;
        public static final int MRAID_JS_DOES_NOT_EXIST_VALUE = 218;
        public static final int MRAID_JS_WRITE_FAILED_VALUE = 131;
        public static final int NATIVE_ASSET_ERROR_VALUE = 600;
        public static final int OMSDK_COPY_ERROR_VALUE = 2003;
        public static final int OMSDK_DOWNLOAD_JS_ERROR_VALUE = 132;
        public static final int OMSDK_JS_WRITE_FAILED_VALUE = 133;
        public static final int OUT_OF_MEMORY_VALUE = 3001;
        public static final int PLACEMENT_AD_TYPE_MISMATCH_VALUE = 207;
        public static final int PLACEMENT_SLEEP_VALUE = 212;
        public static final int PRIVACY_URL_ERROR_VALUE = 136;
        public static final int PROTOBUF_SERIALIZATION_ERROR_VALUE = 118;
        public static final int REACHABILITY_INITIALIZATION_FAILED_VALUE = 2005;
        public static final int SDK_NOT_INITIALIZED_VALUE = 6;
        public static final int SILENT_MODE_MONITOR_ERROR_VALUE = 319;
        public static final int STALE_CACHED_RESPONSE_VALUE = 223;
        public static final int STORE_KIT_LOAD_ERROR_VALUE = 2002;
        public static final int STORE_KIT_PRESENTATION_ERROR_VALUE = 2007;
        public static final int STORE_OVERLAY_LOAD_ERROR_VALUE = 2004;
        public static final int STORE_OVERLAY_PRESENTATION_ERROR_VALUE = 2008;
        public static final int STORE_REGION_CODE_ERROR_VALUE = 134;
        public static final int TEMPLATE_UNZIP_ERROR_VALUE = 109;
        public static final int TPAT_ERROR_VALUE = 121;
        public static final int TPAT_RETRY_FAILED_VALUE = 137;
        public static final int UNKNOWN_ERROR_VALUE = 0;
        public static final int UNKNOWN_RADIO_ACCESS_TECHNOLOGY_VALUE = 2006;
        public static final int USER_AGENT_ERROR_VALUE = 7;
        public static final int VUNGLE_OIT_CREATION_ERROR_VALUE = 4000;
        public static final int WEBVIEW_ERROR_VALUE = 320;
        public static final int WEB_VIEW_FAILED_NAVIGATION_VALUE = 2001;
        public static final int WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE_VALUE = 2000;
        private static final y.d internalValueMap = new a();
        private final int value;

        class a implements y.d {
            a() {
            }

            public Reason findValueByNumber(int i) {
                return Reason.forNumber(i);
            }
        }

        private static final class b implements y.e {
            static final y.e INSTANCE = new b();

            private b() {
            }

            public boolean isInRange(int i) {
                return Reason.forNumber(i) != null;
            }
        }

        Reason(int i) {
            this.value = i;
        }

        public static Reason forNumber(int i) {
            if (i != 0) {
                if (i == 2) {
                    return INVALID_APP_ID;
                }
                if (i == 3) {
                    return CURRENTLY_INITIALIZING;
                }
                if (i == 4) {
                    return ALREADY_INITIALIZED;
                }
                if (i == 6) {
                    return SDK_NOT_INITIALIZED;
                }
                if (i == 7) {
                    return USER_AGENT_ERROR;
                }
                if (i == 301) {
                    return MRAID_ERROR;
                }
                if (i == 302) {
                    return INVALID_IFA_STATUS;
                }
                if (i == 304) {
                    return AD_EXPIRED;
                }
                if (i == 305) {
                    return MRAID_BRIDGE_ERROR;
                }
                switch (i) {
                    case 0:
                        break;
                    case TPAT_ERROR_VALUE:
                        return TPAT_ERROR;
                    case INVALID_ADS_ENDPOINT_VALUE:
                        return INVALID_ADS_ENDPOINT;
                    case INVALID_RI_ENDPOINT_VALUE:
                        return INVALID_RI_ENDPOINT;
                    case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                        return INVALID_LOG_ERROR_ENDPOINT;
                    case INVALID_METRICS_ENDPOINT_VALUE:
                        return INVALID_METRICS_ENDPOINT;
                    case 126:
                        return ASSET_FAILED_INSUFFICIENT_SPACE;
                    case 127:
                        return ASSET_FAILED_MAX_SPACE_EXCEEDED;
                    case 128:
                        return INVALID_TPAT_KEY;
                    case EMPTY_TPAT_ERROR_VALUE:
                        return EMPTY_TPAT_ERROR;
                    case MRAID_DOWNLOAD_JS_ERROR_VALUE:
                        return MRAID_DOWNLOAD_JS_ERROR;
                    case MRAID_JS_WRITE_FAILED_VALUE:
                        return MRAID_JS_WRITE_FAILED;
                    case OMSDK_DOWNLOAD_JS_ERROR_VALUE:
                        return OMSDK_DOWNLOAD_JS_ERROR;
                    case OMSDK_JS_WRITE_FAILED_VALUE:
                        return OMSDK_JS_WRITE_FAILED;
                    case STORE_REGION_CODE_ERROR_VALUE:
                        return STORE_REGION_CODE_ERROR;
                    case INVALID_CONFIG_RESPONSE_VALUE:
                        return INVALID_CONFIG_RESPONSE;
                    case PRIVACY_URL_ERROR_VALUE:
                        return PRIVACY_URL_ERROR;
                    case TPAT_RETRY_FAILED_VALUE:
                        return TPAT_RETRY_FAILED;
                    case CONFIG_REFRESH_FAILED_VALUE:
                        return CONFIG_REFRESH_FAILED;
                    case CONCURRENT_PLAYBACK_UNSUPPORTED_VALUE:
                        return CONCURRENT_PLAYBACK_UNSUPPORTED;
                    case BANNER_VIEW_INVALID_SIZE_VALUE:
                        return BANNER_VIEW_INVALID_SIZE;
                    case NATIVE_ASSET_ERROR_VALUE:
                        return NATIVE_ASSET_ERROR;
                    case 2000:
                        return WEB_VIEW_WEB_CONTENT_PROCESS_DID_TERMINATE;
                    case 2001:
                        return WEB_VIEW_FAILED_NAVIGATION;
                    case 2002:
                        return STORE_KIT_LOAD_ERROR;
                    case 2003:
                        return OMSDK_COPY_ERROR;
                    case 2004:
                        return STORE_OVERLAY_LOAD_ERROR;
                    case 2005:
                        return REACHABILITY_INITIALIZATION_FAILED;
                    case 2006:
                        return UNKNOWN_RADIO_ACCESS_TECHNOLOGY;
                    case 2007:
                        return STORE_KIT_PRESENTATION_ERROR;
                    case 2008:
                        return STORE_OVERLAY_PRESENTATION_ERROR;
                    case 2009:
                        return INVALID_PLAY_PARAMETER;
                    case 3001:
                        return OUT_OF_MEMORY;
                    case VUNGLE_OIT_CREATION_ERROR_VALUE:
                        return VUNGLE_OIT_CREATION_ERROR;
                    case AD_NO_FILL_VALUE:
                        return AD_NO_FILL;
                    case AD_LOAD_TOO_FREQUENTLY_VALUE:
                        return AD_LOAD_TOO_FREQUENTLY;
                    case AD_SERVER_ERROR_VALUE:
                        return AD_SERVER_ERROR;
                    case AD_PUBLISHER_MISMATCH_VALUE:
                        return AD_PUBLISHER_MISMATCH;
                    case AD_INTERNAL_INTEGRATION_ERROR_VALUE:
                        return AD_INTERNAL_INTEGRATION_ERROR;
                    case CONFIG_NOT_FOUND_ERROR_VALUE:
                        return CONFIG_NOT_FOUND_ERROR;
                    default:
                        switch (i) {
                            case 101:
                                return API_REQUEST_ERROR;
                            case API_RESPONSE_DATA_ERROR_VALUE:
                                return API_RESPONSE_DATA_ERROR;
                            case API_RESPONSE_DECODE_ERROR_VALUE:
                                return API_RESPONSE_DECODE_ERROR;
                            case API_FAILED_STATUS_CODE_VALUE:
                                return API_FAILED_STATUS_CODE;
                            case INVALID_TEMPLATE_URL_VALUE:
                                return INVALID_TEMPLATE_URL;
                            case INVALID_REQUEST_BUILDER_ERROR_VALUE:
                                return INVALID_REQUEST_BUILDER_ERROR;
                            default:
                                switch (i) {
                                    case TEMPLATE_UNZIP_ERROR_VALUE:
                                        return TEMPLATE_UNZIP_ERROR;
                                    case INVALID_CTA_URL_VALUE:
                                        return INVALID_CTA_URL;
                                    case INVALID_ASSET_URL_VALUE:
                                        return INVALID_ASSET_URL;
                                    case ASSET_REQUEST_ERROR_VALUE:
                                        return ASSET_REQUEST_ERROR;
                                    case ASSET_RESPONSE_DATA_ERROR_VALUE:
                                        return ASSET_RESPONSE_DATA_ERROR;
                                    case ASSET_WRITE_ERROR_VALUE:
                                        return ASSET_WRITE_ERROR;
                                    case INVALID_INDEX_URL_VALUE:
                                        return INVALID_INDEX_URL;
                                    case GZIP_ENCODE_ERROR_VALUE:
                                        return GZIP_ENCODE_ERROR;
                                    case ASSET_FAILED_STATUS_CODE_VALUE:
                                        return ASSET_FAILED_STATUS_CODE;
                                    case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                                        return PROTOBUF_SERIALIZATION_ERROR;
                                    case JSON_ENCODE_ERROR_VALUE:
                                        return JSON_ENCODE_ERROR;
                                    default:
                                        switch (i) {
                                            case INVALID_EVENT_ID_ERROR_VALUE:
                                                return INVALID_EVENT_ID_ERROR;
                                            case 201:
                                                return INVALID_PLACEMENT_ID;
                                            case AD_CONSUMED_VALUE:
                                                return AD_CONSUMED;
                                            case AD_IS_LOADING_VALUE:
                                                return AD_IS_LOADING;
                                            case AD_ALREADY_LOADED_VALUE:
                                                return AD_ALREADY_LOADED;
                                            case AD_IS_PLAYING_VALUE:
                                                return AD_IS_PLAYING;
                                            case AD_ALREADY_FAILED_VALUE:
                                                return AD_ALREADY_FAILED;
                                            case PLACEMENT_AD_TYPE_MISMATCH_VALUE:
                                                return PLACEMENT_AD_TYPE_MISMATCH;
                                            case INVALID_BID_PAYLOAD_VALUE:
                                                return INVALID_BID_PAYLOAD;
                                            case INVALID_JSON_BID_PAYLOAD_VALUE:
                                                return INVALID_JSON_BID_PAYLOAD;
                                            case AD_NOT_LOADED_VALUE:
                                                return AD_NOT_LOADED;
                                            default:
                                                switch (i) {
                                                    case PLACEMENT_SLEEP_VALUE:
                                                        return PLACEMENT_SLEEP;
                                                    case INVALID_ADUNIT_BID_PAYLOAD_VALUE:
                                                        return INVALID_ADUNIT_BID_PAYLOAD;
                                                    case INVALID_GZIP_BID_PAYLOAD_VALUE:
                                                        return INVALID_GZIP_BID_PAYLOAD;
                                                    case AD_RESPONSE_EMPTY_VALUE:
                                                        return AD_RESPONSE_EMPTY;
                                                    case AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE:
                                                        return AD_RESPONSE_INVALID_TEMPLATE_TYPE;
                                                    case AD_RESPONSE_TIMED_OUT_VALUE:
                                                        return AD_RESPONSE_TIMED_OUT;
                                                    case MRAID_JS_DOES_NOT_EXIST_VALUE:
                                                        return MRAID_JS_DOES_NOT_EXIST;
                                                    case MRAID_JS_COPY_FAILED_VALUE:
                                                        return MRAID_JS_COPY_FAILED;
                                                    case AD_RESPONSE_RETRY_AFTER_VALUE:
                                                        return AD_RESPONSE_RETRY_AFTER;
                                                    case AD_LOAD_FAIL_RETRY_AFTER_VALUE:
                                                        return AD_LOAD_FAIL_RETRY_AFTER;
                                                    case INVALID_WATERFALL_PLACEMENT_ID_VALUE:
                                                        return INVALID_WATERFALL_PLACEMENT_ID;
                                                    case STALE_CACHED_RESPONSE_VALUE:
                                                        return STALE_CACHED_RESPONSE;
                                                    default:
                                                        switch (i) {
                                                            case 307:
                                                                return AD_EXPIRED_ON_PLAY;
                                                            case 308:
                                                                return AD_WIN_NOTIFICATION_ERROR;
                                                            case ASSET_FAILED_TO_DELETE_VALUE:
                                                                return ASSET_FAILED_TO_DELETE;
                                                            case AD_HTML_FAILED_TO_LOAD_VALUE:
                                                                return AD_HTML_FAILED_TO_LOAD;
                                                            case MRAID_JS_CALL_EMPTY_VALUE:
                                                                return MRAID_JS_CALL_EMPTY;
                                                            case DEEPLINK_OPEN_FAILED_VALUE:
                                                                return DEEPLINK_OPEN_FAILED;
                                                            case EVALUATE_JAVASCRIPT_FAILED_VALUE:
                                                                return EVALUATE_JAVASCRIPT_FAILED;
                                                            case LINK_COMMAND_OPEN_FAILED_VALUE:
                                                                return LINK_COMMAND_OPEN_FAILED;
                                                            case JSON_PARAMS_ENCODE_ERROR_VALUE:
                                                                return JSON_PARAMS_ENCODE_ERROR;
                                                            case GENERATE_JSON_DATA_ERROR_VALUE:
                                                                return GENERATE_JSON_DATA_ERROR;
                                                            case AD_CLOSED_TEMPLATE_ERROR_VALUE:
                                                                return AD_CLOSED_TEMPLATE_ERROR;
                                                            case AD_CLOSED_MISSING_HEARTBEAT_VALUE:
                                                                return AD_CLOSED_MISSING_HEARTBEAT;
                                                            case SILENT_MODE_MONITOR_ERROR_VALUE:
                                                                return SILENT_MODE_MONITOR_ERROR;
                                                            case WEBVIEW_ERROR_VALUE:
                                                                return WEBVIEW_ERROR;
                                                            default:
                                                                return null;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            }
            return UNKNOWN_ERROR;
        }

        public static y.d internalGetValueMap() {
            return internalValueMap;
        }

        public static y.e internalGetVerifier() {
            return b.INSTANCE;
        }

        @Deprecated
        public static Reason valueOf(int i) {
            return forNumber(i);
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class a extends GeneratedMessageLite.b implements d {
        private a() {
            super(Sdk$SDKError.DEFAULT_INSTANCE);
        }

        /* synthetic */ a(com.vungle.ads.internal.protos.a aVar) {
            this();
        }

        public a clearAdSource() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearAdSource();
            return this;
        }

        public a clearAppState() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearAppState();
            return this;
        }

        public a clearAt() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearAt();
            return this;
        }

        public a clearConnectionType() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearConnectionType();
            return this;
        }

        public a clearConnectionTypeDetail() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearConnectionTypeDetail();
            return this;
        }

        public a clearConnectionTypeDetailAndroid() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearConnectionTypeDetailAndroid();
            return this;
        }

        public a clearCreativeId() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearCreativeId();
            return this;
        }

        public a clearEventId() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearEventId();
            return this;
        }

        public a clearIsHbPlacement() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearIsHbPlacement();
            return this;
        }

        public a clearIsLowDataModeEnabled() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearIsLowDataModeEnabled();
            return this;
        }

        public a clearMake() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearMake();
            return this;
        }

        public a clearMediationName() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearMediationName();
            return this;
        }

        public a clearMessage() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearMessage();
            return this;
        }

        public a clearModel() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearModel();
            return this;
        }

        public a clearOs() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearOs();
            return this;
        }

        public a clearOsVersion() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearOsVersion();
            return this;
        }

        public a clearPlacementReferenceId() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearPlacementReferenceId();
            return this;
        }

        public a clearPlacementType() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearPlacementType();
            return this;
        }

        public a clearReason() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearReason();
            return this;
        }

        public a clearSessionId() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearSessionId();
            return this;
        }

        public a clearVmVersion() {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).clearVmVersion();
            return this;
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getAdSource() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getAdSource();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getAdSourceBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getAdSourceBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public long getAppState() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getAppState();
        }

        @Override // com.vungle.ads.internal.protos.d
        public long getAt() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getAt();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getConnectionType() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getConnectionType();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getConnectionTypeBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getConnectionTypeBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getConnectionTypeDetail() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getConnectionTypeDetail();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getConnectionTypeDetailAndroid() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getConnectionTypeDetailAndroid();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getConnectionTypeDetailAndroidBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getConnectionTypeDetailAndroidBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getConnectionTypeDetailBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getConnectionTypeDetailBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getCreativeId() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getCreativeId();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getCreativeIdBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getCreativeIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getEventId() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getEventId();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getEventIdBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getEventIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public long getIsHbPlacement() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getIsHbPlacement();
        }

        @Override // com.vungle.ads.internal.protos.d
        public boolean getIsLowDataModeEnabled() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getIsLowDataModeEnabled();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getMake() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getMake();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getMakeBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getMakeBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getMediationName() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getMediationName();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getMediationNameBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getMediationNameBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getMessage() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getMessage();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getMessageBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getMessageBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getModel() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getModel();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getModelBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getModelBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getOs() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getOs();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getOsBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getOsBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getOsVersion() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getOsVersion();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getOsVersionBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getOsVersionBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getPlacementReferenceId() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getPlacementReferenceId();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getPlacementReferenceIdBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getPlacementReferenceIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getPlacementType() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getPlacementType();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getPlacementTypeBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getPlacementTypeBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public Reason getReason() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getReason();
        }

        @Override // com.vungle.ads.internal.protos.d
        public int getReasonValue() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getReasonValue();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getSessionId() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getSessionId();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getSessionIdBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getSessionIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.d
        public String getVmVersion() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getVmVersion();
        }

        @Override // com.vungle.ads.internal.protos.d
        public ByteString getVmVersionBytes() {
            return ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).getVmVersionBytes();
        }

        public a setAdSource(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setAdSource(str);
            return this;
        }

        public a setAdSourceBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setAdSourceBytes(byteString);
            return this;
        }

        public a setAppState(long j) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setAppState(j);
            return this;
        }

        public a setAt(long j) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setAt(j);
            return this;
        }

        public a setConnectionType(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setConnectionType(str);
            return this;
        }

        public a setConnectionTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setConnectionTypeBytes(byteString);
            return this;
        }

        public a setConnectionTypeDetail(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setConnectionTypeDetail(str);
            return this;
        }

        public a setConnectionTypeDetailAndroid(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setConnectionTypeDetailAndroid(str);
            return this;
        }

        public a setConnectionTypeDetailAndroidBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setConnectionTypeDetailAndroidBytes(byteString);
            return this;
        }

        public a setConnectionTypeDetailBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setConnectionTypeDetailBytes(byteString);
            return this;
        }

        public a setCreativeId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setCreativeId(str);
            return this;
        }

        public a setCreativeIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setCreativeIdBytes(byteString);
            return this;
        }

        public a setEventId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setEventId(str);
            return this;
        }

        public a setEventIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setEventIdBytes(byteString);
            return this;
        }

        public a setIsHbPlacement(long j) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setIsHbPlacement(j);
            return this;
        }

        public a setIsLowDataModeEnabled(boolean z) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setIsLowDataModeEnabled(z);
            return this;
        }

        public a setMake(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setMake(str);
            return this;
        }

        public a setMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setMakeBytes(byteString);
            return this;
        }

        public a setMediationName(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setMediationName(str);
            return this;
        }

        public a setMediationNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setMediationNameBytes(byteString);
            return this;
        }

        public a setMessage(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setMessage(str);
            return this;
        }

        public a setMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setMessageBytes(byteString);
            return this;
        }

        public a setModel(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setModel(str);
            return this;
        }

        public a setModelBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setModelBytes(byteString);
            return this;
        }

        public a setOs(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setOs(str);
            return this;
        }

        public a setOsBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setOsBytes(byteString);
            return this;
        }

        public a setOsVersion(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setOsVersion(str);
            return this;
        }

        public a setOsVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setOsVersionBytes(byteString);
            return this;
        }

        public a setPlacementReferenceId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setPlacementReferenceId(str);
            return this;
        }

        public a setPlacementReferenceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setPlacementReferenceIdBytes(byteString);
            return this;
        }

        public a setPlacementType(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setPlacementType(str);
            return this;
        }

        public a setPlacementTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setPlacementTypeBytes(byteString);
            return this;
        }

        public a setReason(Reason reason) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setReason(reason);
            return this;
        }

        public a setReasonValue(int i) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setReasonValue(i);
            return this;
        }

        public a setSessionId(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setSessionId(str);
            return this;
        }

        public a setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setSessionIdBytes(byteString);
            return this;
        }

        public a setVmVersion(String str) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setVmVersion(str);
            return this;
        }

        public a setVmVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKError) ((GeneratedMessageLite.b) this).instance).setVmVersionBytes(byteString);
            return this;
        }
    }

    static {
        Sdk$SDKError sdk$SDKError = new Sdk$SDKError();
        DEFAULT_INSTANCE = sdk$SDKError;
        GeneratedMessageLite.registerDefaultInstance(Sdk$SDKError.class, sdk$SDKError);
    }

    private Sdk$SDKError() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdSource() {
        this.adSource_ = getDefaultInstance().getAdSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppState() {
        this.appState_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAt() {
        this.at_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionType() {
        this.connectionType_ = getDefaultInstance().getConnectionType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionTypeDetail() {
        this.connectionTypeDetail_ = getDefaultInstance().getConnectionTypeDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionTypeDetailAndroid() {
        this.connectionTypeDetailAndroid_ = getDefaultInstance().getConnectionTypeDetailAndroid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreativeId() {
        this.creativeId_ = getDefaultInstance().getCreativeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventId() {
        this.eventId_ = getDefaultInstance().getEventId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsHbPlacement() {
        this.isHbPlacement_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsLowDataModeEnabled() {
        this.isLowDataModeEnabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMake() {
        this.make_ = getDefaultInstance().getMake();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediationName() {
        this.mediationName_ = getDefaultInstance().getMediationName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModel() {
        this.model_ = getDefaultInstance().getModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOs() {
        this.os_ = getDefaultInstance().getOs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOsVersion() {
        this.osVersion_ = getDefaultInstance().getOsVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlacementReferenceId() {
        this.placementReferenceId_ = getDefaultInstance().getPlacementReferenceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlacementType() {
        this.placementType_ = getDefaultInstance().getPlacementType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVmVersion() {
        this.vmVersion_ = getDefaultInstance().getVmVersion();
    }

    public static Sdk$SDKError getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(Sdk$SDKError sdk$SDKError) {
        return (a) DEFAULT_INSTANCE.createBuilder(sdk$SDKError);
    }

    public static Sdk$SDKError parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKError parseDelimitedFrom(InputStream inputStream, o oVar) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, oVar);
    }

    public static Sdk$SDKError parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Sdk$SDKError parseFrom(ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, oVar);
    }

    public static Sdk$SDKError parseFrom(i iVar) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar);
    }

    public static Sdk$SDKError parseFrom(i iVar, o oVar) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar, oVar);
    }

    public static Sdk$SDKError parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKError parseFrom(InputStream inputStream, o oVar) throws IOException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, oVar);
    }

    public static Sdk$SDKError parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Sdk$SDKError parseFrom(ByteBuffer byteBuffer, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, oVar);
    }

    public static Sdk$SDKError parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$SDKError parseFrom(byte[] bArr, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$SDKError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, oVar);
    }

    public static b1 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdSource(String str) {
        str.getClass();
        this.adSource_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdSourceBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.adSource_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppState(long j) {
        this.appState_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAt(long j) {
        this.at_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionType(String str) {
        str.getClass();
        this.connectionType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.connectionType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeDetail(String str) {
        str.getClass();
        this.connectionTypeDetail_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeDetailAndroid(String str) {
        str.getClass();
        this.connectionTypeDetailAndroid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeDetailAndroidBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.connectionTypeDetailAndroid_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeDetailBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.connectionTypeDetail_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreativeId(String str) {
        str.getClass();
        this.creativeId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreativeIdBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.creativeId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventId(String str) {
        str.getClass();
        this.eventId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventIdBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.eventId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsHbPlacement(long j) {
        this.isHbPlacement_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsLowDataModeEnabled(boolean z) {
        this.isLowDataModeEnabled_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMake(String str) {
        str.getClass();
        this.make_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.make_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediationName(String str) {
        str.getClass();
        this.mediationName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediationNameBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.mediationName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.message_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModel(String str) {
        str.getClass();
        this.model_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModelBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.model_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOs(String str) {
        str.getClass();
        this.os_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOsBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.os_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOsVersion(String str) {
        str.getClass();
        this.osVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOsVersionBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.osVersion_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlacementReferenceId(String str) {
        str.getClass();
        this.placementReferenceId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlacementReferenceIdBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.placementReferenceId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlacementType(String str) {
        str.getClass();
        this.placementType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlacementTypeBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.placementType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(Reason reason) {
        this.reason_ = reason.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReasonValue(int i) {
        this.reason_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.sessionId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVmVersion(String str) {
        str.getClass();
        this.vmVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVmVersionBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.vmVersion_ = byteString.toStringUtf8();
    }

    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.vungle.ads.internal.protos.a aVar = null;
        switch (com.vungle.ads.internal.protos.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$SDKError();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0015\u0000\u0000\u0001É\u0015\u0000\u0000\u0000\u0001\u0002\u0002\f\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ\rȈ\u000e\u0002\u000fȈ\u0010Ȉ\u0011\u0002\u0012Ȉ\u0013ȈeȈÉ\u0007", new Object[]{"at_", "reason_", "message_", "eventId_", "make_", "model_", "os_", "osVersion_", "connectionType_", "connectionTypeDetail_", "placementReferenceId_", "creativeId_", "sessionId_", "isHbPlacement_", "placementType_", "adSource_", "appState_", "mediationName_", "vmVersion_", "connectionTypeDetailAndroid_", "isLowDataModeEnabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                GeneratedMessageLite.c cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sdk$SDKError.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getAdSource() {
        return this.adSource_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getAdSourceBytes() {
        return ByteString.copyFromUtf8(this.adSource_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public long getAppState() {
        return this.appState_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public long getAt() {
        return this.at_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getConnectionType() {
        return this.connectionType_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getConnectionTypeBytes() {
        return ByteString.copyFromUtf8(this.connectionType_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getConnectionTypeDetail() {
        return this.connectionTypeDetail_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getConnectionTypeDetailAndroid() {
        return this.connectionTypeDetailAndroid_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getConnectionTypeDetailAndroidBytes() {
        return ByteString.copyFromUtf8(this.connectionTypeDetailAndroid_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getConnectionTypeDetailBytes() {
        return ByteString.copyFromUtf8(this.connectionTypeDetail_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getCreativeId() {
        return this.creativeId_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getCreativeIdBytes() {
        return ByteString.copyFromUtf8(this.creativeId_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getEventId() {
        return this.eventId_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getEventIdBytes() {
        return ByteString.copyFromUtf8(this.eventId_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public long getIsHbPlacement() {
        return this.isHbPlacement_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public boolean getIsLowDataModeEnabled() {
        return this.isLowDataModeEnabled_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getMake() {
        return this.make_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getMakeBytes() {
        return ByteString.copyFromUtf8(this.make_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getMediationName() {
        return this.mediationName_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getMediationNameBytes() {
        return ByteString.copyFromUtf8(this.mediationName_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getMessage() {
        return this.message_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getModel() {
        return this.model_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getModelBytes() {
        return ByteString.copyFromUtf8(this.model_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getOs() {
        return this.os_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getOsBytes() {
        return ByteString.copyFromUtf8(this.os_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getOsVersion() {
        return this.osVersion_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getOsVersionBytes() {
        return ByteString.copyFromUtf8(this.osVersion_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getPlacementReferenceId() {
        return this.placementReferenceId_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getPlacementReferenceIdBytes() {
        return ByteString.copyFromUtf8(this.placementReferenceId_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getPlacementType() {
        return this.placementType_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getPlacementTypeBytes() {
        return ByteString.copyFromUtf8(this.placementType_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public Reason getReason() {
        Reason forNumber = Reason.forNumber(this.reason_);
        return forNumber == null ? Reason.UNRECOGNIZED : forNumber;
    }

    @Override // com.vungle.ads.internal.protos.d
    public int getReasonValue() {
        return this.reason_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.vungle.ads.internal.protos.d
    public String getVmVersion() {
        return this.vmVersion_;
    }

    @Override // com.vungle.ads.internal.protos.d
    public ByteString getVmVersionBytes() {
        return ByteString.copyFromUtf8(this.vmVersion_);
    }
}
