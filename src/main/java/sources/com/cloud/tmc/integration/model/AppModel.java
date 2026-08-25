package com.cloud.tmc.integration.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 Ç\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Ç\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\t\u0010Ã\u0001\u001a\u00020\u000fH\u0016J\u001b\u0010Ä\u0001\u001a\u00030Å\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0007\u0010Æ\u0001\u001a\u00020\u000fH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR\u001c\u0010!\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\rR\u001c\u0010$\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\rR\u001c\u0010'\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010\rR\u001a\u0010*\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013R\u001c\u0010-\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000b\"\u0004\b/\u0010\rR\u001c\u00100\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\rR\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0011\"\u0004\bG\u0010\u0013R\u001a\u0010H\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010\u0013R\u001a\u0010K\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010M\"\u0004\b,\u0010NR\u001a\u0010O\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010M\"\u0004\bG\u0010NR\u001a\u0010P\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010M\"\u0004\bQ\u0010NR\u001c\u0010R\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u000b\"\u0004\bT\u0010\rR\u001c\u0010U\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000b\"\u0004\bW\u0010\rR\u001c\u0010X\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000b\"\u0004\bZ\u0010\rR\u001c\u0010[\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000b\"\u0004\b]\u0010\rR\u001c\u0010^\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u000b\"\u0004\b`\u0010\rR\"\u0010a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0018\"\u0004\bc\u0010\u001aR\u001c\u0010d\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u000b\"\u0004\bf\u0010\rR\u001c\u0010g\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u000b\"\u0004\bi\u0010\rR\u001c\u0010j\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u000b\"\u0004\bl\u0010\rR\u001c\u0010m\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u000b\"\u0004\bo\u0010\rR\u001c\u0010p\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u000b\"\u0004\br\u0010\rR\u001e\u0010s\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010x\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001c\u0010y\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u000b\"\u0004\b{\u0010\rR\u001c\u0010|\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u000b\"\u0004\b~\u0010\rR\u001e\u0010\u007f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u000b\"\u0005\b\u0081\u0001\u0010\rR\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u000b\"\u0005\b\u0084\u0001\u0010\rR\"\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R!\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0012\n\u0002\u0010x\u001a\u0005\b\u008c\u0001\u0010u\"\u0005\b\u008d\u0001\u0010wR\u001f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u000b\"\u0005\b\u0090\u0001\u0010\rR\u001f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u000b\"\u0005\b\u0093\u0001\u0010\rR\u001f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u000b\"\u0005\b\u0096\u0001\u0010\rR\u001d\u0010\u0097\u0001\u001a\u000204X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u00106\"\u0005\b\u0099\u0001\u00108R\u001f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010\u000b\"\u0005\b\u009c\u0001\u0010\rR&\u0010\u009d\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u009e\u0001\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010\u0018\"\u0005\b \u0001\u0010\u001aRA\u0010¡\u0001\u001a$\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010¢\u0001j\u0011\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`£\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R\u001f\u0010¨\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010\u000b\"\u0005\bª\u0001\u0010\rR\u001f\u0010«\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u000b\"\u0005\b\u00ad\u0001\u0010\rR\u001f\u0010®\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010\u000b\"\u0005\b°\u0001\u0010\rR\u001f\u0010±\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010\u000b\"\u0005\b³\u0001\u0010\rR\u001f\u0010´\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010\u000b\"\u0005\b¶\u0001\u0010\rR\u001f\u0010·\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010\u000b\"\u0005\b¹\u0001\u0010\rR\u001f\u0010º\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010\u000b\"\u0005\b¼\u0001\u0010\rR\u001f\u0010½\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0001\u0010\u000b\"\u0005\b¿\u0001\u0010\rR\u001f\u0010À\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0001\u0010\u000b\"\u0005\bÂ\u0001\u0010\r¨\u0006È\u0001"}, d2 = {"Lcom/cloud/tmc/integration/model/AppModel;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appinfoCategoryType", "", "getAppinfoCategoryType", "()I", "setAppinfoCategoryType", "(I)V", "classification", "", "Lcom/cloud/tmc/integration/model/ClassificationInfo;", "getClassification", "()Ljava/util/List;", "setClassification", "(Ljava/util/List;)V", "classificationNames", "getClassificationNames", "setClassificationNames", "compatiblePackageUrl", "getCompatiblePackageUrl", "setCompatiblePackageUrl", "currentUseCommonResVersion", "getCurrentUseCommonResVersion", "setCurrentUseCommonResVersion", "deployVersion", "getDeployVersion", "setDeployVersion", "desc", "getDesc", "setDesc", "devMode", "getDevMode", "setDevMode", "developer", "getDeveloper", "setDeveloper", "developerVersion", "getDeveloperVersion", "setDeveloperVersion", "expiresTime", "", "getExpiresTime", "()J", "setExpiresTime", "(J)V", "extend", "Lcom/cloud/tmc/integration/model/ExtendModel;", "getExtend", "()Lcom/cloud/tmc/integration/model/ExtendModel;", "setExtend", "(Lcom/cloud/tmc/integration/model/ExtendModel;)V", "extendInfos", "Lcom/google/gson/JsonObject;", "getExtendInfos", "()Lcom/google/gson/JsonObject;", "setExtendInfos", "(Lcom/google/gson/JsonObject;)V", "forceUpdate", "getForceUpdate", "setForceUpdate", "fromCacheType", "getFromCacheType", "setFromCacheType", "isDevMode", "", "()Z", "(Z)V", "isForceUpdate", "isTestVersion", "setTestVersion", "linkAndButtonColor", "getLinkAndButtonColor", "setLinkAndButtonColor", "logo", "getLogo", "setLogo", "lowestOpenedVersion", "getLowestOpenedVersion", "setLowestOpenedVersion", "lowestSupportTemplateVersion", "getLowestSupportTemplateVersion", "setLowestSupportTemplateVersion", "lowestSupportVersion", "getLowestSupportVersion", "setLowestSupportVersion", "mainPackagePages", "getMainPackagePages", "setMainPackagePages", "mainPackageUnZipFilePath", "getMainPackageUnZipFilePath", "setMainPackageUnZipFilePath", "mainPackageUrl", "getMainPackageUrl", "setMainPackageUrl", "mainPackageUrlEncryption", "getMainPackageUrlEncryption", "setMainPackageUrlEncryption", "mainPackageZipPath", "getMainPackageZipPath", "setMainPackageZipPath", "mainUrl", "getMainUrl", "setMainUrl", "miniappSubtype", "getMiniappSubtype", "()Ljava/lang/Integer;", "setMiniappSubtype", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "name", "getName", "setName", "packageSize", "getPackageSize", "setPackageSize", "packageUrl", "getPackageUrl", "setPackageUrl", "packageUrl_MD5", "getPackageUrl_MD5", "setPackageUrl_MD5", "permissions", "Lcom/cloud/tmc/kernel/model/permission/PermissionModel;", "getPermissions", "()Lcom/cloud/tmc/kernel/model/permission/PermissionModel;", "setPermissions", "(Lcom/cloud/tmc/kernel/model/permission/PermissionModel;)V", "popupStyle", "getPopupStyle", "setPopupStyle", "privacyPolicyUrl", "getPrivacyPolicyUrl", "setPrivacyPolicyUrl", "processingMethod", "getProcessingMethod", "setProcessingMethod", "registerType", "getRegisterType", "setRegisterType", "releaseTime", "getReleaseTime", "setReleaseTime", "slogan", "getSlogan", "setSlogan", "subPackagePages", "Lcom/cloud/tmc/integration/model/SubPackageInfo;", "getSubPackagePages", "setSubPackagePages", "subPackageUrls", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSubPackageUrls", "()Ljava/util/HashMap;", "setSubPackageUrls", "(Ljava/util/HashMap;)V", "templateDeployVersion", "getTemplateDeployVersion", "setTemplateDeployVersion", "templateMiniappId", "getTemplateMiniappId", "setTemplateMiniappId", "templatePackageUrl", "getTemplatePackageUrl", "setTemplatePackageUrl", "unzipFilePath", "getUnzipFilePath", "setUnzipFilePath", "userAgreement", "getUserAgreement", "setUserAgreement", "userAgreementUrl", "getUserAgreementUrl", "setUserAgreementUrl", "userAgreementVersion", "getUserAgreementVersion", "setUserAgreementVersion", "vhost", "getVhost", "setVhost", "zipPath", "getZipPath", "setZipPath", "describeContents", "writeToParcel", "", "flags", "CREATOR", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class AppModel extends BaseBean implements Serializable, Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String appId;
    private int appinfoCategoryType;
    private List<ClassificationInfo> classification;
    private List<String> classificationNames;
    private String compatiblePackageUrl;
    private String currentUseCommonResVersion;
    private String deployVersion;
    private String desc;
    private int devMode;
    private String developer;
    private String developerVersion;
    private long expiresTime;
    private ExtendModel extend;
    private JsonObject extendInfos;
    private int forceUpdate;
    private int fromCacheType;
    private boolean isDevMode;
    private boolean isForceUpdate;
    private boolean isTestVersion;
    private String linkAndButtonColor;
    private String logo;
    private String lowestOpenedVersion;
    private String lowestSupportTemplateVersion;
    private String lowestSupportVersion;
    private List<String> mainPackagePages;
    private String mainPackageUnZipFilePath;
    private String mainPackageUrl;
    private String mainPackageUrlEncryption;
    private String mainPackageZipPath;
    private String mainUrl;
    private Integer miniappSubtype;
    private String name;
    private String packageSize;
    private String packageUrl;
    private String packageUrl_MD5;
    private PermissionModel permissions;
    private Integer popupStyle;
    private String privacyPolicyUrl;
    private String processingMethod;
    private String registerType;
    private long releaseTime;
    private String slogan;
    private List<SubPackageInfo> subPackagePages;
    private HashMap<String, String> subPackageUrls;
    private String templateDeployVersion;
    private String templateMiniappId;
    private String templatePackageUrl;
    private String unzipFilePath;
    private String userAgreement;
    private String userAgreementUrl;
    private String userAgreementVersion;
    private String vhost;
    private String zipPath;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/cloud/tmc/integration/model/AppModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/cloud/tmc/integration/model/AppModel;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/cloud/tmc/integration/model/AppModel;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.cloud.tmc.integration.model.AppModel$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<AppModel> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppModel createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new AppModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppModel[] newArray(int size) {
            return new AppModel[size];
        }
    }

    public AppModel() {
        this.devMode = -1;
        this.popupStyle = 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppModel(Parcel parcel) {
        this();
        HashMap<String, String> hashMap;
        Intrinsics.h(parcel, "parcel");
        this.name = parcel.readString();
        this.mainUrl = parcel.readString();
        this.logo = parcel.readString();
        this.vhost = parcel.readString();
        this.appId = parcel.readString();
        this.deployVersion = parcel.readString();
        this.developerVersion = parcel.readString();
        this.packageUrl = parcel.readString();
        this.packageUrl_MD5 = parcel.readString();
        this.desc = parcel.readString();
        this.developer = parcel.readString();
        this.zipPath = parcel.readString();
        this.unzipFilePath = parcel.readString();
        this.registerType = parcel.readString();
        this.slogan = parcel.readString();
        this.expiresTime = parcel.readLong();
        this.releaseTime = parcel.readLong();
        this.fromCacheType = parcel.readInt();
        this.isForceUpdate = parcel.readByte() != 0;
        this.lowestSupportVersion = parcel.readString();
        this.packageSize = parcel.readString();
        this.classificationNames = parcel.createStringArrayList();
        this.permissions = parcel.readParcelable(PermissionModel.class.getClassLoader());
        this.isDevMode = parcel.readByte() != 0;
        this.devMode = parcel.readInt();
        this.appinfoCategoryType = parcel.readInt();
        this.extend = (ExtendModel) parcel.readParcelable(ExtendModel.class.getClassLoader());
        this.lowestOpenedVersion = parcel.readString();
        this.forceUpdate = parcel.readInt();
        this.isTestVersion = parcel.readByte() != 0;
        this.mainPackageUrl = parcel.readString();
        this.mainPackageUrlEncryption = parcel.readString();
        this.mainPackageZipPath = parcel.readString();
        this.mainPackageUnZipFilePath = parcel.readString();
        this.subPackagePages = parcel.createTypedArrayList(SubPackageInfo.INSTANCE);
        this.mainPackagePages = parcel.createStringArrayList();
        HashMap readHashMap = parcel.readHashMap(HashMap.class.getClassLoader());
        if (readHashMap != null) {
            hashMap = new HashMap<>();
            for (Object obj : readHashMap.keySet()) {
                if (readHashMap.get(obj) instanceof String) {
                    String obj2 = obj.toString();
                    Object obj3 = readHashMap.get(obj);
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    hashMap.put(obj2, (String) obj3);
                }
            }
        } else {
            hashMap = null;
        }
        this.subPackageUrls = hashMap;
        this.classification = parcel.createTypedArrayList(ClassificationInfo.INSTANCE);
        this.userAgreement = parcel.readString();
        this.userAgreementVersion = parcel.readString();
        this.userAgreementUrl = parcel.readString();
        this.privacyPolicyUrl = parcel.readString();
        this.linkAndButtonColor = parcel.readString();
        this.processingMethod = parcel.readString();
        this.popupStyle = Integer.valueOf(parcel.readInt());
        this.miniappSubtype = Integer.valueOf(parcel.readInt());
        this.templateMiniappId = parcel.readString();
        this.templatePackageUrl = parcel.readString();
        this.templateDeployVersion = parcel.readString();
        this.lowestSupportTemplateVersion = parcel.readString();
        this.compatiblePackageUrl = parcel.readString();
        this.currentUseCommonResVersion = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final int getAppinfoCategoryType() {
        return this.appinfoCategoryType;
    }

    public final List<ClassificationInfo> getClassification() {
        return this.classification;
    }

    public final List<String> getClassificationNames() {
        return this.classificationNames;
    }

    public final String getCompatiblePackageUrl() {
        return this.compatiblePackageUrl;
    }

    public final String getCurrentUseCommonResVersion() {
        return this.currentUseCommonResVersion;
    }

    public final String getDeployVersion() {
        return this.deployVersion;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getDevMode() {
        return this.devMode;
    }

    public final String getDeveloper() {
        return this.developer;
    }

    public final String getDeveloperVersion() {
        return this.developerVersion;
    }

    public final long getExpiresTime() {
        return this.expiresTime;
    }

    public final ExtendModel getExtend() {
        return this.extend;
    }

    public final JsonObject getExtendInfos() {
        return this.extendInfos;
    }

    public final int getForceUpdate() {
        return this.forceUpdate;
    }

    public final int getFromCacheType() {
        return this.fromCacheType;
    }

    public final String getLinkAndButtonColor() {
        return this.linkAndButtonColor;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getLowestOpenedVersion() {
        return this.lowestOpenedVersion;
    }

    public final String getLowestSupportTemplateVersion() {
        return this.lowestSupportTemplateVersion;
    }

    public final String getLowestSupportVersion() {
        return this.lowestSupportVersion;
    }

    public final List<String> getMainPackagePages() {
        return this.mainPackagePages;
    }

    public final String getMainPackageUnZipFilePath() {
        return this.mainPackageUnZipFilePath;
    }

    public final String getMainPackageUrl() {
        return this.mainPackageUrl;
    }

    public final String getMainPackageUrlEncryption() {
        return this.mainPackageUrlEncryption;
    }

    public final String getMainPackageZipPath() {
        return this.mainPackageZipPath;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final Integer getMiniappSubtype() {
        return this.miniappSubtype;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageSize() {
        return this.packageSize;
    }

    public final String getPackageUrl() {
        return this.packageUrl;
    }

    public final String getPackageUrl_MD5() {
        return this.packageUrl_MD5;
    }

    public final PermissionModel getPermissions() {
        return this.permissions;
    }

    public final Integer getPopupStyle() {
        return this.popupStyle;
    }

    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final String getProcessingMethod() {
        return this.processingMethod;
    }

    public final String getRegisterType() {
        return this.registerType;
    }

    public final long getReleaseTime() {
        return this.releaseTime;
    }

    public final String getSlogan() {
        return this.slogan;
    }

    public final List<SubPackageInfo> getSubPackagePages() {
        return this.subPackagePages;
    }

    public final HashMap<String, String> getSubPackageUrls() {
        return this.subPackageUrls;
    }

    public final String getTemplateDeployVersion() {
        return this.templateDeployVersion;
    }

    public final String getTemplateMiniappId() {
        return this.templateMiniappId;
    }

    public final String getTemplatePackageUrl() {
        return this.templatePackageUrl;
    }

    public final String getUnzipFilePath() {
        return this.unzipFilePath;
    }

    public final String getUserAgreement() {
        return this.userAgreement;
    }

    public final String getUserAgreementUrl() {
        return this.userAgreementUrl;
    }

    public final String getUserAgreementVersion() {
        return this.userAgreementVersion;
    }

    public final String getVhost() {
        return this.vhost;
    }

    public final String getZipPath() {
        return this.zipPath;
    }

    /* renamed from: isDevMode, reason: from getter */
    public final boolean getIsDevMode() {
        return this.isDevMode;
    }

    /* renamed from: isForceUpdate, reason: from getter */
    public final boolean getIsForceUpdate() {
        return this.isForceUpdate;
    }

    /* renamed from: isTestVersion, reason: from getter */
    public final boolean getIsTestVersion() {
        return this.isTestVersion;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setAppinfoCategoryType(int i) {
        this.appinfoCategoryType = i;
    }

    public final void setClassification(List<ClassificationInfo> list) {
        this.classification = list;
    }

    public final void setClassificationNames(List<String> list) {
        this.classificationNames = list;
    }

    public final void setCompatiblePackageUrl(String str) {
        this.compatiblePackageUrl = str;
    }

    public final void setCurrentUseCommonResVersion(String str) {
        this.currentUseCommonResVersion = str;
    }

    public final void setDeployVersion(String str) {
        this.deployVersion = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setDevMode(int i) {
        this.devMode = i;
    }

    public final void setDevMode(boolean z) {
        this.isDevMode = z;
    }

    public final void setDeveloper(String str) {
        this.developer = str;
    }

    public final void setDeveloperVersion(String str) {
        this.developerVersion = str;
    }

    public final void setExpiresTime(long j) {
        this.expiresTime = j;
    }

    public final void setExtend(ExtendModel extendModel) {
        this.extend = extendModel;
    }

    public final void setExtendInfos(JsonObject jsonObject) {
        this.extendInfos = jsonObject;
    }

    public final void setForceUpdate(int i) {
        this.forceUpdate = i;
    }

    public final void setForceUpdate(boolean z) {
        this.isForceUpdate = z;
    }

    public final void setFromCacheType(int i) {
        this.fromCacheType = i;
    }

    public final void setLinkAndButtonColor(String str) {
        this.linkAndButtonColor = str;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final void setLowestOpenedVersion(String str) {
        this.lowestOpenedVersion = str;
    }

    public final void setLowestSupportTemplateVersion(String str) {
        this.lowestSupportTemplateVersion = str;
    }

    public final void setLowestSupportVersion(String str) {
        this.lowestSupportVersion = str;
    }

    public final void setMainPackagePages(List<String> list) {
        this.mainPackagePages = list;
    }

    public final void setMainPackageUnZipFilePath(String str) {
        this.mainPackageUnZipFilePath = str;
    }

    public final void setMainPackageUrl(String str) {
        this.mainPackageUrl = str;
    }

    public final void setMainPackageUrlEncryption(String str) {
        this.mainPackageUrlEncryption = str;
    }

    public final void setMainPackageZipPath(String str) {
        this.mainPackageZipPath = str;
    }

    public final void setMainUrl(String str) {
        this.mainUrl = str;
    }

    public final void setMiniappSubtype(Integer num) {
        this.miniappSubtype = num;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPackageSize(String str) {
        this.packageSize = str;
    }

    public final void setPackageUrl(String str) {
        this.packageUrl = str;
    }

    public final void setPackageUrl_MD5(String str) {
        this.packageUrl_MD5 = str;
    }

    public final void setPermissions(PermissionModel permissionModel) {
        this.permissions = permissionModel;
    }

    public final void setPopupStyle(Integer num) {
        this.popupStyle = num;
    }

    public final void setPrivacyPolicyUrl(String str) {
        this.privacyPolicyUrl = str;
    }

    public final void setProcessingMethod(String str) {
        this.processingMethod = str;
    }

    public final void setRegisterType(String str) {
        this.registerType = str;
    }

    public final void setReleaseTime(long j) {
        this.releaseTime = j;
    }

    public final void setSlogan(String str) {
        this.slogan = str;
    }

    public final void setSubPackagePages(List<SubPackageInfo> list) {
        this.subPackagePages = list;
    }

    public final void setSubPackageUrls(HashMap<String, String> hashMap) {
        this.subPackageUrls = hashMap;
    }

    public final void setTemplateDeployVersion(String str) {
        this.templateDeployVersion = str;
    }

    public final void setTemplateMiniappId(String str) {
        this.templateMiniappId = str;
    }

    public final void setTemplatePackageUrl(String str) {
        this.templatePackageUrl = str;
    }

    public final void setTestVersion(boolean z) {
        this.isTestVersion = z;
    }

    public final void setUnzipFilePath(String str) {
        this.unzipFilePath = str;
    }

    public final void setUserAgreement(String str) {
        this.userAgreement = str;
    }

    public final void setUserAgreementUrl(String str) {
        this.userAgreementUrl = str;
    }

    public final void setUserAgreementVersion(String str) {
        this.userAgreementVersion = str;
    }

    public final void setVhost(String str) {
        this.vhost = str;
    }

    public final void setZipPath(String str) {
        this.zipPath = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.h(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.mainUrl);
        parcel.writeString(this.logo);
        parcel.writeString(this.vhost);
        parcel.writeString(this.appId);
        parcel.writeString(this.deployVersion);
        parcel.writeString(this.developerVersion);
        parcel.writeString(this.packageUrl);
        parcel.writeString(this.packageUrl_MD5);
        parcel.writeString(this.desc);
        parcel.writeString(this.developer);
        parcel.writeString(this.zipPath);
        parcel.writeString(this.unzipFilePath);
        parcel.writeString(this.registerType);
        parcel.writeString(this.slogan);
        parcel.writeLong(this.expiresTime);
        parcel.writeLong(this.releaseTime);
        parcel.writeInt(this.fromCacheType);
        parcel.writeByte(this.isForceUpdate ? (byte) 1 : (byte) 0);
        parcel.writeString(this.lowestSupportVersion);
        parcel.writeString(this.packageSize);
        parcel.writeStringList(this.classificationNames);
        parcel.writeParcelable(this.permissions, flags);
        parcel.writeByte(this.isDevMode ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.devMode);
        parcel.writeInt(this.appinfoCategoryType);
        parcel.writeParcelable(this.extend, flags);
        parcel.writeString(this.lowestOpenedVersion);
        parcel.writeInt(this.forceUpdate);
        parcel.writeByte(this.isTestVersion ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mainPackageUrl);
        parcel.writeString(this.mainPackageUrlEncryption);
        parcel.writeString(this.mainPackageZipPath);
        parcel.writeString(this.mainPackageUnZipFilePath);
        parcel.writeTypedList(this.subPackagePages);
        parcel.writeStringList(this.mainPackagePages);
        parcel.writeMap(this.subPackageUrls);
        parcel.writeTypedList(this.classification);
        parcel.writeString(this.userAgreement);
        parcel.writeString(this.userAgreementVersion);
        parcel.writeString(this.userAgreementUrl);
        parcel.writeString(this.privacyPolicyUrl);
        parcel.writeString(this.linkAndButtonColor);
        parcel.writeString(this.processingMethod);
        Integer num = this.popupStyle;
        parcel.writeInt(num != null ? num.intValue() : 0);
        Integer num2 = this.miniappSubtype;
        parcel.writeInt(num2 != null ? num2.intValue() : 0);
        parcel.writeString(this.templateMiniappId);
        parcel.writeString(this.templatePackageUrl);
        parcel.writeString(this.templateDeployVersion);
        parcel.writeString(this.lowestSupportTemplateVersion);
        parcel.writeString(this.compatiblePackageUrl);
        parcel.writeString(this.currentUseCommonResVersion);
    }
}
