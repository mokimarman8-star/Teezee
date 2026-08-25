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
public final class Sdk$SDKMetric extends GeneratedMessageLite implements e {
    public static final int ADSOURCE_FIELD_NUMBER = 16;
    public static final int APPSTATE_FIELD_NUMBER = 18;
    public static final int CONNECTIONTYPEDETAIL_FIELD_NUMBER = 9;
    public static final int CONNECTIONTYPE_FIELD_NUMBER = 8;
    public static final int CREATIVEID_FIELD_NUMBER = 11;
    private static final Sdk$SDKMetric DEFAULT_INSTANCE;
    public static final int EVENTID_FIELD_NUMBER = 12;
    public static final int ISHBPLACEMENT_FIELD_NUMBER = 14;
    public static final int ISLOWDATAMODEENABLED_FIELD_NUMBER = 201;
    public static final int MAKE_FIELD_NUMBER = 4;
    public static final int MEDIATIONNAME_FIELD_NUMBER = 17;
    public static final int META_FIELD_NUMBER = 3;
    public static final int MODEL_FIELD_NUMBER = 5;
    public static final int OSVERSION_FIELD_NUMBER = 7;
    public static final int OS_FIELD_NUMBER = 6;
    private static volatile b1 PARSER = null;
    public static final int PLACEMENTREFERENCEID_FIELD_NUMBER = 10;
    public static final int PLACEMENTTYPE_FIELD_NUMBER = 15;
    public static final int SESSIONID_FIELD_NUMBER = 13;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    public static final int VMVERSION_FIELD_NUMBER = 19;
    private long appState_;
    private long isHbPlacement_;
    private boolean isLowDataModeEnabled_;
    private int type_;
    private long value_;
    private String meta_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String make_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String model_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String os_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String osVersion_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String connectionType_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String connectionTypeDetail_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String placementReferenceId_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String creativeId_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String eventId_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String sessionId_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String placementType_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String adSource_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String mediationName_ = HttpUrl.FRAGMENT_ENCODE_SET;
    private String vmVersion_ = HttpUrl.FRAGMENT_ENCODE_SET;

    public enum SDKMetricType implements y.c {
        UNKNOWN_METRIC_TYPE(0),
        AD_REQUEST_TO_RESPONSE_DURATION_MS(1),
        AD_RESPONSE_TO_SHOW_DURATION_MS(2),
        AD_SHOW_TO_DISPLAY_DURATION_MS(3),
        AD_DISPLAY_TO_CLICK_DURATION_MS(4),
        IOS_STORE_KIT_LOAD_TIME_MS(5),
        INIT_REQUEST_TO_RESPONSE_DURATION_MS(6),
        ASSET_DOWNLOAD_DURATION_MS(7),
        LOCAL_ASSETS_USED(8),
        REMOTE_ASSETS_USED(9),
        TEMPLATE_DOWNLOAD_DURATION_MS(10),
        AD_REQUEST_TO_CALLBACK_DURATION_MS(11),
        AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS(12),
        ASSET_FILE_SIZE(13),
        USER_AGENT_LOAD_DURATION_MS(14),
        TEMPLATE_ZIP_SIZE(15),
        CACHED_ASSETS_USED(16),
        LOAD_AD_API(17),
        TPAT_FIRED(18),
        TPAT_SUCCESS(19),
        WIN_NOTIF_FIRED(20),
        WIN_NOTIF_SUCCESS(21),
        AD_EXPIRED_BEFORE_PLAY(22),
        PLAY_AD_API(23),
        AD_LOAD_FAIL(24),
        VIEW_NOT_VISIBLE_ON_PLAY(25),
        MRAID_DOWNLOAD_JS_RETRY_SUCCESS(26),
        OMSDK_DOWNLOAD_JS_RETRY_SUCCESS(27),
        PRIVACY_URL_OPENED(28),
        NOTIFICATION_REDIRECT(29),
        AD_PLAY_RESET_ON_DEINIT(30),
        TEMPLATE_HTML_SIZE(31),
        CONFIG_LOADED_FROM_INIT(32),
        CONFIG_LOADED_FROM_AD_LOAD(33),
        CONFIG_LOADED_FROM_ADM_LOAD(34),
        AD_SHOW_TO_PRESENT_DURATION_MS(35),
        AD_SHOW_TO_FAIL_DURATION_MS(36),
        AD_PRESENT_TO_DISPLAY_DURATION_MS(37),
        BID_TOKEN_REQUESTED(38),
        BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS(39),
        BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS(40),
        AD_LOAD_TO_FAIL_CALLBACK_DURATION_MS(41),
        AD_SHOW_TO_CLOSE_DURATION_MS(42),
        AD_LOAD_TO_CALLBACK_DURATION_MS(43),
        AD_LOAD_TO_CALLBACK_ADO_DURATION_MS(44),
        SDK_INIT_API(45),
        AD_START_EVENT(46),
        AD_CLICK_EVENT(47),
        AD_SHOW_TO_VALIDATION_DURATION_MS(48),
        AD_VALIDATION_TO_PRESENT_DURATION_MS(49),
        AD_LEAVE_APPLICATION(50),
        AD_REWARD_USER(51),
        AD_REQUIRED_DOWNLOAD_DURATION_MS(52),
        AD_OPTIONAL_DOWNLOAD_DURATION_MS(53),
        AD_BACKGROUND_BEFORE_IMPRESSION(54),
        AD_CLOSED_BEFORE_IMPRESSION(55),
        AD_VISIBILITY(56),
        INIT_TO_SUCCESS_CALLBACK_DURATION_MS(57),
        INIT_TO_FAIL_CALLBACK_DURATION_MS(58),
        SKOVERLAY_PRESENTED_FOR_AD(2000),
        SAFARI_PRESENTED_FOR_AD(2001),
        STORE_KIT_PRESENTED_FOR_AD(2002),
        STORE_KIT_NOT_READY(2003),
        LAUNCH_STORE_KIT_REQUEST(2004),
        LAUNCH_SKOVERLAY_REQUEST(2005),
        LAUNCH_SAFARI_REQUEST(2006),
        IDFV_RESTRICTED(2007),
        NOTIFICATION_WAIT_FOR_CONNECTIVITY(2008),
        IDFV_VALUE_CHANGED(2009),
        AD_WILL_CLOSE(AD_WILL_CLOSE_VALUE),
        APP_TERM_DURING_AD_BEFORE_IMPRESSION(APP_TERM_DURING_AD_BEFORE_IMPRESSION_VALUE),
        HARDWARE_ACCELERATE_DISABLED(3001),
        BANNER_AUTO_REDIRECT(BANNER_AUTO_REDIRECT_VALUE),
        UNRECOGNIZED(-1);

        public static final int AD_BACKGROUND_BEFORE_IMPRESSION_VALUE = 54;
        public static final int AD_CLICK_EVENT_VALUE = 47;
        public static final int AD_CLOSED_BEFORE_IMPRESSION_VALUE = 55;
        public static final int AD_DISPLAY_TO_CLICK_DURATION_MS_VALUE = 4;

        @Deprecated
        public static final int AD_EXPIRED_BEFORE_PLAY_VALUE = 22;
        public static final int AD_LEAVE_APPLICATION_VALUE = 50;
        public static final int AD_LOAD_FAIL_VALUE = 24;
        public static final int AD_LOAD_TO_CALLBACK_ADO_DURATION_MS_VALUE = 44;
        public static final int AD_LOAD_TO_CALLBACK_DURATION_MS_VALUE = 43;
        public static final int AD_LOAD_TO_FAIL_CALLBACK_DURATION_MS_VALUE = 41;
        public static final int AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE = 53;
        public static final int AD_PLAY_RESET_ON_DEINIT_VALUE = 30;
        public static final int AD_PRESENT_TO_DISPLAY_DURATION_MS_VALUE = 37;
        public static final int AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS_VALUE = 12;
        public static final int AD_REQUEST_TO_CALLBACK_DURATION_MS_VALUE = 11;
        public static final int AD_REQUEST_TO_RESPONSE_DURATION_MS_VALUE = 1;
        public static final int AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE = 52;
        public static final int AD_RESPONSE_TO_SHOW_DURATION_MS_VALUE = 2;
        public static final int AD_REWARD_USER_VALUE = 51;
        public static final int AD_SHOW_TO_CLOSE_DURATION_MS_VALUE = 42;
        public static final int AD_SHOW_TO_DISPLAY_DURATION_MS_VALUE = 3;
        public static final int AD_SHOW_TO_FAIL_DURATION_MS_VALUE = 36;

        @Deprecated
        public static final int AD_SHOW_TO_PRESENT_DURATION_MS_VALUE = 35;
        public static final int AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE = 48;
        public static final int AD_START_EVENT_VALUE = 46;
        public static final int AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE = 49;
        public static final int AD_VISIBILITY_VALUE = 56;
        public static final int AD_WILL_CLOSE_VALUE = 2010;
        public static final int APP_TERM_DURING_AD_BEFORE_IMPRESSION_VALUE = 2011;
        public static final int ASSET_DOWNLOAD_DURATION_MS_VALUE = 7;
        public static final int ASSET_FILE_SIZE_VALUE = 13;
        public static final int BANNER_AUTO_REDIRECT_VALUE = 3002;
        public static final int BID_TOKEN_REQUESTED_VALUE = 38;
        public static final int BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS_VALUE = 40;
        public static final int BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS_VALUE = 39;
        public static final int CACHED_ASSETS_USED_VALUE = 16;
        public static final int CONFIG_LOADED_FROM_ADM_LOAD_VALUE = 34;
        public static final int CONFIG_LOADED_FROM_AD_LOAD_VALUE = 33;
        public static final int CONFIG_LOADED_FROM_INIT_VALUE = 32;
        public static final int HARDWARE_ACCELERATE_DISABLED_VALUE = 3001;
        public static final int IDFV_RESTRICTED_VALUE = 2007;
        public static final int IDFV_VALUE_CHANGED_VALUE = 2009;
        public static final int INIT_REQUEST_TO_RESPONSE_DURATION_MS_VALUE = 6;
        public static final int INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE = 58;
        public static final int INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE = 57;
        public static final int IOS_STORE_KIT_LOAD_TIME_MS_VALUE = 5;
        public static final int LAUNCH_SAFARI_REQUEST_VALUE = 2006;
        public static final int LAUNCH_SKOVERLAY_REQUEST_VALUE = 2005;
        public static final int LAUNCH_STORE_KIT_REQUEST_VALUE = 2004;
        public static final int LOAD_AD_API_VALUE = 17;
        public static final int LOCAL_ASSETS_USED_VALUE = 8;
        public static final int MRAID_DOWNLOAD_JS_RETRY_SUCCESS_VALUE = 26;
        public static final int NOTIFICATION_REDIRECT_VALUE = 29;
        public static final int NOTIFICATION_WAIT_FOR_CONNECTIVITY_VALUE = 2008;
        public static final int OMSDK_DOWNLOAD_JS_RETRY_SUCCESS_VALUE = 27;
        public static final int PLAY_AD_API_VALUE = 23;
        public static final int PRIVACY_URL_OPENED_VALUE = 28;
        public static final int REMOTE_ASSETS_USED_VALUE = 9;
        public static final int SAFARI_PRESENTED_FOR_AD_VALUE = 2001;
        public static final int SDK_INIT_API_VALUE = 45;
        public static final int SKOVERLAY_PRESENTED_FOR_AD_VALUE = 2000;
        public static final int STORE_KIT_NOT_READY_VALUE = 2003;
        public static final int STORE_KIT_PRESENTED_FOR_AD_VALUE = 2002;
        public static final int TEMPLATE_DOWNLOAD_DURATION_MS_VALUE = 10;
        public static final int TEMPLATE_HTML_SIZE_VALUE = 31;
        public static final int TEMPLATE_ZIP_SIZE_VALUE = 15;
        public static final int TPAT_FIRED_VALUE = 18;
        public static final int TPAT_SUCCESS_VALUE = 19;
        public static final int UNKNOWN_METRIC_TYPE_VALUE = 0;
        public static final int USER_AGENT_LOAD_DURATION_MS_VALUE = 14;

        @Deprecated
        public static final int VIEW_NOT_VISIBLE_ON_PLAY_VALUE = 25;
        public static final int WIN_NOTIF_FIRED_VALUE = 20;
        public static final int WIN_NOTIF_SUCCESS_VALUE = 21;
        private static final y.d internalValueMap = new a();
        private final int value;

        class a implements y.d {
            a() {
            }

            public SDKMetricType findValueByNumber(int i) {
                return SDKMetricType.forNumber(i);
            }
        }

        private static final class b implements y.e {
            static final y.e INSTANCE = new b();

            private b() {
            }

            public boolean isInRange(int i) {
                return SDKMetricType.forNumber(i) != null;
            }
        }

        SDKMetricType(int i) {
            this.value = i;
        }

        public static SDKMetricType forNumber(int i) {
            if (i == 3001) {
                return HARDWARE_ACCELERATE_DISABLED;
            }
            if (i == 3002) {
                return BANNER_AUTO_REDIRECT;
            }
            switch (i) {
                case 0:
                    return UNKNOWN_METRIC_TYPE;
                case 1:
                    return AD_REQUEST_TO_RESPONSE_DURATION_MS;
                case 2:
                    return AD_RESPONSE_TO_SHOW_DURATION_MS;
                case 3:
                    return AD_SHOW_TO_DISPLAY_DURATION_MS;
                case 4:
                    return AD_DISPLAY_TO_CLICK_DURATION_MS;
                case 5:
                    return IOS_STORE_KIT_LOAD_TIME_MS;
                case 6:
                    return INIT_REQUEST_TO_RESPONSE_DURATION_MS;
                case 7:
                    return ASSET_DOWNLOAD_DURATION_MS;
                case 8:
                    return LOCAL_ASSETS_USED;
                case 9:
                    return REMOTE_ASSETS_USED;
                case 10:
                    return TEMPLATE_DOWNLOAD_DURATION_MS;
                case 11:
                    return AD_REQUEST_TO_CALLBACK_DURATION_MS;
                case 12:
                    return AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS;
                case 13:
                    return ASSET_FILE_SIZE;
                case 14:
                    return USER_AGENT_LOAD_DURATION_MS;
                case 15:
                    return TEMPLATE_ZIP_SIZE;
                case 16:
                    return CACHED_ASSETS_USED;
                case 17:
                    return LOAD_AD_API;
                case 18:
                    return TPAT_FIRED;
                case 19:
                    return TPAT_SUCCESS;
                case WIN_NOTIF_FIRED_VALUE:
                    return WIN_NOTIF_FIRED;
                case WIN_NOTIF_SUCCESS_VALUE:
                    return WIN_NOTIF_SUCCESS;
                case AD_EXPIRED_BEFORE_PLAY_VALUE:
                    return AD_EXPIRED_BEFORE_PLAY;
                case PLAY_AD_API_VALUE:
                    return PLAY_AD_API;
                case AD_LOAD_FAIL_VALUE:
                    return AD_LOAD_FAIL;
                case VIEW_NOT_VISIBLE_ON_PLAY_VALUE:
                    return VIEW_NOT_VISIBLE_ON_PLAY;
                case MRAID_DOWNLOAD_JS_RETRY_SUCCESS_VALUE:
                    return MRAID_DOWNLOAD_JS_RETRY_SUCCESS;
                case OMSDK_DOWNLOAD_JS_RETRY_SUCCESS_VALUE:
                    return OMSDK_DOWNLOAD_JS_RETRY_SUCCESS;
                case PRIVACY_URL_OPENED_VALUE:
                    return PRIVACY_URL_OPENED;
                case NOTIFICATION_REDIRECT_VALUE:
                    return NOTIFICATION_REDIRECT;
                case 30:
                    return AD_PLAY_RESET_ON_DEINIT;
                case TEMPLATE_HTML_SIZE_VALUE:
                    return TEMPLATE_HTML_SIZE;
                case 32:
                    return CONFIG_LOADED_FROM_INIT;
                case CONFIG_LOADED_FROM_AD_LOAD_VALUE:
                    return CONFIG_LOADED_FROM_AD_LOAD;
                case CONFIG_LOADED_FROM_ADM_LOAD_VALUE:
                    return CONFIG_LOADED_FROM_ADM_LOAD;
                case AD_SHOW_TO_PRESENT_DURATION_MS_VALUE:
                    return AD_SHOW_TO_PRESENT_DURATION_MS;
                case AD_SHOW_TO_FAIL_DURATION_MS_VALUE:
                    return AD_SHOW_TO_FAIL_DURATION_MS;
                case AD_PRESENT_TO_DISPLAY_DURATION_MS_VALUE:
                    return AD_PRESENT_TO_DISPLAY_DURATION_MS;
                case BID_TOKEN_REQUESTED_VALUE:
                    return BID_TOKEN_REQUESTED;
                case BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS_VALUE:
                    return BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS;
                case BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS_VALUE:
                    return BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS;
                case AD_LOAD_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    return AD_LOAD_TO_FAIL_CALLBACK_DURATION_MS;
                case AD_SHOW_TO_CLOSE_DURATION_MS_VALUE:
                    return AD_SHOW_TO_CLOSE_DURATION_MS;
                case AD_LOAD_TO_CALLBACK_DURATION_MS_VALUE:
                    return AD_LOAD_TO_CALLBACK_DURATION_MS;
                case AD_LOAD_TO_CALLBACK_ADO_DURATION_MS_VALUE:
                    return AD_LOAD_TO_CALLBACK_ADO_DURATION_MS;
                case SDK_INIT_API_VALUE:
                    return SDK_INIT_API;
                case AD_START_EVENT_VALUE:
                    return AD_START_EVENT;
                case AD_CLICK_EVENT_VALUE:
                    return AD_CLICK_EVENT;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    return AD_SHOW_TO_VALIDATION_DURATION_MS;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    return AD_VALIDATION_TO_PRESENT_DURATION_MS;
                case AD_LEAVE_APPLICATION_VALUE:
                    return AD_LEAVE_APPLICATION;
                case AD_REWARD_USER_VALUE:
                    return AD_REWARD_USER;
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    return AD_REQUIRED_DOWNLOAD_DURATION_MS;
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    return AD_OPTIONAL_DOWNLOAD_DURATION_MS;
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    return AD_BACKGROUND_BEFORE_IMPRESSION;
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    return AD_CLOSED_BEFORE_IMPRESSION;
                case AD_VISIBILITY_VALUE:
                    return AD_VISIBILITY;
                case INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE:
                    return INIT_TO_SUCCESS_CALLBACK_DURATION_MS;
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    return INIT_TO_FAIL_CALLBACK_DURATION_MS;
                default:
                    switch (i) {
                        case 2000:
                            return SKOVERLAY_PRESENTED_FOR_AD;
                        case 2001:
                            return SAFARI_PRESENTED_FOR_AD;
                        case 2002:
                            return STORE_KIT_PRESENTED_FOR_AD;
                        case 2003:
                            return STORE_KIT_NOT_READY;
                        case 2004:
                            return LAUNCH_STORE_KIT_REQUEST;
                        case 2005:
                            return LAUNCH_SKOVERLAY_REQUEST;
                        case 2006:
                            return LAUNCH_SAFARI_REQUEST;
                        case 2007:
                            return IDFV_RESTRICTED;
                        case 2008:
                            return NOTIFICATION_WAIT_FOR_CONNECTIVITY;
                        case 2009:
                            return IDFV_VALUE_CHANGED;
                        case AD_WILL_CLOSE_VALUE:
                            return AD_WILL_CLOSE;
                        case APP_TERM_DURING_AD_BEFORE_IMPRESSION_VALUE:
                            return APP_TERM_DURING_AD_BEFORE_IMPRESSION;
                        default:
                            return null;
                    }
            }
        }

        public static y.d internalGetValueMap() {
            return internalValueMap;
        }

        public static y.e internalGetVerifier() {
            return b.INSTANCE;
        }

        @Deprecated
        public static SDKMetricType valueOf(int i) {
            return forNumber(i);
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class a extends GeneratedMessageLite.b implements e {
        private a() {
            super(Sdk$SDKMetric.DEFAULT_INSTANCE);
        }

        /* synthetic */ a(com.vungle.ads.internal.protos.a aVar) {
            this();
        }

        public a clearAdSource() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearAdSource();
            return this;
        }

        public a clearAppState() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearAppState();
            return this;
        }

        public a clearConnectionType() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearConnectionType();
            return this;
        }

        public a clearConnectionTypeDetail() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearConnectionTypeDetail();
            return this;
        }

        public a clearCreativeId() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearCreativeId();
            return this;
        }

        public a clearEventId() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearEventId();
            return this;
        }

        public a clearIsHbPlacement() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearIsHbPlacement();
            return this;
        }

        public a clearIsLowDataModeEnabled() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearIsLowDataModeEnabled();
            return this;
        }

        public a clearMake() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearMake();
            return this;
        }

        public a clearMediationName() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearMediationName();
            return this;
        }

        public a clearMeta() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearMeta();
            return this;
        }

        public a clearModel() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearModel();
            return this;
        }

        public a clearOs() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearOs();
            return this;
        }

        public a clearOsVersion() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearOsVersion();
            return this;
        }

        public a clearPlacementReferenceId() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearPlacementReferenceId();
            return this;
        }

        public a clearPlacementType() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearPlacementType();
            return this;
        }

        public a clearSessionId() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearSessionId();
            return this;
        }

        public a clearType() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearType();
            return this;
        }

        public a clearValue() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearValue();
            return this;
        }

        public a clearVmVersion() {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).clearVmVersion();
            return this;
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getAdSource() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getAdSource();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getAdSourceBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getAdSourceBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public long getAppState() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getAppState();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getConnectionType() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getConnectionType();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getConnectionTypeBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getConnectionTypeBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getConnectionTypeDetail() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getConnectionTypeDetail();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getConnectionTypeDetailBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getConnectionTypeDetailBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getCreativeId() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getCreativeId();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getCreativeIdBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getCreativeIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getEventId() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getEventId();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getEventIdBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getEventIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public long getIsHbPlacement() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getIsHbPlacement();
        }

        @Override // com.vungle.ads.internal.protos.e
        public boolean getIsLowDataModeEnabled() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getIsLowDataModeEnabled();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getMake() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getMake();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getMakeBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getMakeBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getMediationName() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getMediationName();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getMediationNameBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getMediationNameBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getMeta() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getMeta();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getMetaBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getMetaBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getModel() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getModel();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getModelBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getModelBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getOs() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getOs();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getOsBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getOsBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getOsVersion() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getOsVersion();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getOsVersionBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getOsVersionBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getPlacementReferenceId() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getPlacementReferenceId();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getPlacementReferenceIdBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getPlacementReferenceIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getPlacementType() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getPlacementType();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getPlacementTypeBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getPlacementTypeBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getSessionId() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getSessionId();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getSessionIdBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getSessionIdBytes();
        }

        @Override // com.vungle.ads.internal.protos.e
        public SDKMetricType getType() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getType();
        }

        @Override // com.vungle.ads.internal.protos.e
        public int getTypeValue() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getTypeValue();
        }

        @Override // com.vungle.ads.internal.protos.e
        public long getValue() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getValue();
        }

        @Override // com.vungle.ads.internal.protos.e
        public String getVmVersion() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getVmVersion();
        }

        @Override // com.vungle.ads.internal.protos.e
        public ByteString getVmVersionBytes() {
            return ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).getVmVersionBytes();
        }

        public a setAdSource(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setAdSource(str);
            return this;
        }

        public a setAdSourceBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setAdSourceBytes(byteString);
            return this;
        }

        public a setAppState(long j) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setAppState(j);
            return this;
        }

        public a setConnectionType(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setConnectionType(str);
            return this;
        }

        public a setConnectionTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setConnectionTypeBytes(byteString);
            return this;
        }

        public a setConnectionTypeDetail(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setConnectionTypeDetail(str);
            return this;
        }

        public a setConnectionTypeDetailBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setConnectionTypeDetailBytes(byteString);
            return this;
        }

        public a setCreativeId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setCreativeId(str);
            return this;
        }

        public a setCreativeIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setCreativeIdBytes(byteString);
            return this;
        }

        public a setEventId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setEventId(str);
            return this;
        }

        public a setEventIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setEventIdBytes(byteString);
            return this;
        }

        public a setIsHbPlacement(long j) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setIsHbPlacement(j);
            return this;
        }

        public a setIsLowDataModeEnabled(boolean z) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setIsLowDataModeEnabled(z);
            return this;
        }

        public a setMake(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setMake(str);
            return this;
        }

        public a setMakeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setMakeBytes(byteString);
            return this;
        }

        public a setMediationName(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setMediationName(str);
            return this;
        }

        public a setMediationNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setMediationNameBytes(byteString);
            return this;
        }

        public a setMeta(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setMeta(str);
            return this;
        }

        public a setMetaBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setMetaBytes(byteString);
            return this;
        }

        public a setModel(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setModel(str);
            return this;
        }

        public a setModelBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setModelBytes(byteString);
            return this;
        }

        public a setOs(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setOs(str);
            return this;
        }

        public a setOsBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setOsBytes(byteString);
            return this;
        }

        public a setOsVersion(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setOsVersion(str);
            return this;
        }

        public a setOsVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setOsVersionBytes(byteString);
            return this;
        }

        public a setPlacementReferenceId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setPlacementReferenceId(str);
            return this;
        }

        public a setPlacementReferenceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setPlacementReferenceIdBytes(byteString);
            return this;
        }

        public a setPlacementType(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setPlacementType(str);
            return this;
        }

        public a setPlacementTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setPlacementTypeBytes(byteString);
            return this;
        }

        public a setSessionId(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setSessionId(str);
            return this;
        }

        public a setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setSessionIdBytes(byteString);
            return this;
        }

        public a setType(SDKMetricType sDKMetricType) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setType(sDKMetricType);
            return this;
        }

        public a setTypeValue(int i) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setTypeValue(i);
            return this;
        }

        public a setValue(long j) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setValue(j);
            return this;
        }

        public a setVmVersion(String str) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setVmVersion(str);
            return this;
        }

        public a setVmVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((Sdk$SDKMetric) ((GeneratedMessageLite.b) this).instance).setVmVersionBytes(byteString);
            return this;
        }
    }

    static {
        Sdk$SDKMetric sdk$SDKMetric = new Sdk$SDKMetric();
        DEFAULT_INSTANCE = sdk$SDKMetric;
        GeneratedMessageLite.registerDefaultInstance(Sdk$SDKMetric.class, sdk$SDKMetric);
    }

    private Sdk$SDKMetric() {
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
    public void clearConnectionType() {
        this.connectionType_ = getDefaultInstance().getConnectionType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionTypeDetail() {
        this.connectionTypeDetail_ = getDefaultInstance().getConnectionTypeDetail();
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
    public void clearMeta() {
        this.meta_ = getDefaultInstance().getMeta();
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
    public void clearSessionId() {
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVmVersion() {
        this.vmVersion_ = getDefaultInstance().getVmVersion();
    }

    public static Sdk$SDKMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(Sdk$SDKMetric sdk$SDKMetric) {
        return (a) DEFAULT_INSTANCE.createBuilder(sdk$SDKMetric);
    }

    public static Sdk$SDKMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKMetric parseDelimitedFrom(InputStream inputStream, o oVar) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, oVar);
    }

    public static Sdk$SDKMetric parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Sdk$SDKMetric parseFrom(ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, oVar);
    }

    public static Sdk$SDKMetric parseFrom(i iVar) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar);
    }

    public static Sdk$SDKMetric parseFrom(i iVar, o oVar) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar, oVar);
    }

    public static Sdk$SDKMetric parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKMetric parseFrom(InputStream inputStream, o oVar) throws IOException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, oVar);
    }

    public static Sdk$SDKMetric parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Sdk$SDKMetric parseFrom(ByteBuffer byteBuffer, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, oVar);
    }

    public static Sdk$SDKMetric parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$SDKMetric parseFrom(byte[] bArr, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$SDKMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, oVar);
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
    public void setMeta(String str) {
        str.getClass();
        this.meta_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetaBytes(ByteString byteString) {
        com.google.protobuf.a.checkByteStringIsUtf8(byteString);
        this.meta_ = byteString.toStringUtf8();
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
    public void setType(SDKMetricType sDKMetricType) {
        this.type_ = sDKMetricType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeValue(int i) {
        this.type_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(long j) {
        this.value_ = j;
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
                return new Sdk$SDKMetric();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0014\u0000\u0000\u0001É\u0014\u0000\u0000\u0000\u0001\f\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ\rȈ\u000e\u0002\u000fȈ\u0010Ȉ\u0011Ȉ\u0012\u0002\u0013ȈÉ\u0007", new Object[]{"type_", "value_", "meta_", "make_", "model_", "os_", "osVersion_", "connectionType_", "connectionTypeDetail_", "placementReferenceId_", "creativeId_", "eventId_", "sessionId_", "isHbPlacement_", "placementType_", "adSource_", "mediationName_", "appState_", "vmVersion_", "isLowDataModeEnabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                GeneratedMessageLite.c cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sdk$SDKMetric.class) {
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

    @Override // com.vungle.ads.internal.protos.e
    public String getAdSource() {
        return this.adSource_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getAdSourceBytes() {
        return ByteString.copyFromUtf8(this.adSource_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public long getAppState() {
        return this.appState_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getConnectionType() {
        return this.connectionType_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getConnectionTypeBytes() {
        return ByteString.copyFromUtf8(this.connectionType_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getConnectionTypeDetail() {
        return this.connectionTypeDetail_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getConnectionTypeDetailBytes() {
        return ByteString.copyFromUtf8(this.connectionTypeDetail_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getCreativeId() {
        return this.creativeId_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getCreativeIdBytes() {
        return ByteString.copyFromUtf8(this.creativeId_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getEventId() {
        return this.eventId_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getEventIdBytes() {
        return ByteString.copyFromUtf8(this.eventId_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public long getIsHbPlacement() {
        return this.isHbPlacement_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public boolean getIsLowDataModeEnabled() {
        return this.isLowDataModeEnabled_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getMake() {
        return this.make_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getMakeBytes() {
        return ByteString.copyFromUtf8(this.make_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getMediationName() {
        return this.mediationName_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getMediationNameBytes() {
        return ByteString.copyFromUtf8(this.mediationName_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getMeta() {
        return this.meta_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getMetaBytes() {
        return ByteString.copyFromUtf8(this.meta_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getModel() {
        return this.model_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getModelBytes() {
        return ByteString.copyFromUtf8(this.model_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getOs() {
        return this.os_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getOsBytes() {
        return ByteString.copyFromUtf8(this.os_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getOsVersion() {
        return this.osVersion_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getOsVersionBytes() {
        return ByteString.copyFromUtf8(this.osVersion_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getPlacementReferenceId() {
        return this.placementReferenceId_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getPlacementReferenceIdBytes() {
        return ByteString.copyFromUtf8(this.placementReferenceId_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getPlacementType() {
        return this.placementType_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getPlacementTypeBytes() {
        return ByteString.copyFromUtf8(this.placementType_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    @Override // com.vungle.ads.internal.protos.e
    public SDKMetricType getType() {
        SDKMetricType forNumber = SDKMetricType.forNumber(this.type_);
        return forNumber == null ? SDKMetricType.UNRECOGNIZED : forNumber;
    }

    @Override // com.vungle.ads.internal.protos.e
    public int getTypeValue() {
        return this.type_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public long getValue() {
        return this.value_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public String getVmVersion() {
        return this.vmVersion_;
    }

    @Override // com.vungle.ads.internal.protos.e
    public ByteString getVmVersionBytes() {
        return ByteString.copyFromUtf8(this.vmVersion_);
    }
}
