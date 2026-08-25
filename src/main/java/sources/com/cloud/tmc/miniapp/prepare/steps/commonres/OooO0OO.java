package com.cloud.tmc.miniapp.prepare.steps.commonres;

import android.content.Context;
import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.callback.PackageInstallCallback;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PrepareContext;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.JsonUtil;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniapp.prepare.steps.StepType;
import com.cloud.tmc.miniapp.prepare.steps.o000oOoO;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0OO extends com.cloud.tmc.miniapp.prepare.steps.OooO00o {
    public static final void OooO00o(OooO0OO oooO0OO, AppModel appModel, Context context, PrepareController prepareController, boolean z, String str) {
        Intrinsics.h(oooO0OO, "this$0");
        Intrinsics.h(appModel, "$commonResModel");
        Intrinsics.h(context, "$context");
        if (!z) {
            TmcLogger.d(oooO0OO.OooO00o, "Step_LoadStep: tar 包解压失败，删除数据");
            AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel);
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("5", "unzip error" + appModel.getPackageUrl()));
                return;
            }
            return;
        }
        TmcLogger.d(oooO0OO.OooO00o, "Step_LoadStep: tar 包解压完成");
        try {
            AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
            if (!Intrinsics.c(JsonUtil.INSTANCE.getValueFromJson(appPrepareUtils.getManifestJson(appModel), "appId"), appModel.getAppId())) {
                appPrepareUtils.clearAllFilesForVersion(context, appModel);
                if (prepareController != null) {
                    prepareController.moveToError(new PrepareException(PrepareException.ERROR_MANIFEST_INFO, "manifest error"));
                    return;
                }
                return;
            }
            TmcLogger.d(oooO0OO.OooO00o, "Step_LoadStep: manifest 内容校验成功");
            appPrepareUtils.changeTarUnCompressStatus(context, appModel, true);
            oooO0OO.OooO0o0.delectDownloadFileForVersion(appModel);
            oooO0OO.OooO0O0.delectOldVersionFilesAndUpdate(context, appModel);
            if (prepareController != null) {
                prepareController.unlock(prepareController);
            }
            if (prepareController != null) {
                prepareController.moveToNext();
            }
        } catch (Throwable unused) {
            AppPrepareUtils.INSTANCE.clearAllFilesForVersion(context, appModel);
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException(PrepareException.ERROR_MANIFEST_INFO, "manifest error"));
            }
        }
    }

    public static final void OooO00o(OooO0OO oooO0OO, PrepareController prepareController, PrepareContext prepareContext, AppModel appModel, boolean z, String str) {
        Intrinsics.h(oooO0OO, "this$0");
        Intrinsics.h(prepareContext, "$context");
        Intrinsics.h(appModel, "$commonResModel");
        if (z) {
            TmcLogger.d(oooO0OO.OooO00o, "Step_LoadStep: zip 包解压完成");
            oooO0OO.OooO00o(prepareController, prepareContext, appModel);
            return;
        }
        TmcLogger.d(oooO0OO.OooO00o, "Step_LoadStep: zip 包解压失败");
        AppPrepareUtils.INSTANCE.clearAllFilesForVersion(prepareContext.getStartContext(), appModel);
        if (prepareController != null) {
            prepareController.moveToError(new PrepareException("5", "unzip error" + appModel.getPackageUrl()));
        }
    }

    public final void OooO00o(final PrepareContext prepareContext, final PrepareController prepareController, final AppModel appModel) {
        this.OooO0OO.installZip(prepareContext.getStartContext(), appModel, new PackageInstallCallback() { // from class: com.cloud.tmc.miniapp.prepare.steps.commonres.b
            public final void onResult(boolean z, String str) {
                OooO0OO.OooO00o(OooO0OO.this, prepareController, prepareContext, appModel, z, str);
            }
        });
    }

    public final void OooO00o(final PrepareController prepareController, PrepareContext prepareContext, final AppModel appModel) {
        final Context startContext = prepareContext.getStartContext();
        TmcLogger.d(this.OooO00o, "Step_LoadStep: sha256 校验");
        AppPrepareUtils appPrepareUtils = AppPrepareUtils.INSTANCE;
        if (appPrepareUtils.checkSHA256(appModel)) {
            TmcLogger.d(this.OooO00o, "Step_LoadStep: sha256 校验正确，解压 tar 包");
            this.OooO0OO.installApp(appModel, new PackageInstallCallback() { // from class: com.cloud.tmc.miniapp.prepare.steps.commonres.a
                public final void onResult(boolean z, String str) {
                    OooO0OO.OooO00o(OooO0OO.this, appModel, startContext, prepareController, z, str);
                }
            });
            return;
        }
        TmcLogger.d(this.OooO00o, "Step_LoadStep: sha256 校验不一致，删除所有缓存");
        appPrepareUtils.clearAllFilesForVersion(startContext, appModel);
        if (prepareController != null) {
            prepareController.moveToError(new PrepareException("7", "sign error" + appModel.getAppId() + "   " + appModel.getPackageUrl()));
        }
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.o0OoOo0
    public StepType OooO0O0() {
        return StepType.COMMON_RES_LOAD;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.OooO00o, com.cloud.tmc.miniapp.prepare.steps.o0OoOo0
    public void OooO0O0(PrepareController prepareController, PrepareContext prepareContext, o000oOoO o000oooo) {
        String appId;
        super.OooO0O0(prepareController, prepareContext, o000oooo);
        AppModel appModel = prepareContext.getAppModel();
        if (!AppUtils.INSTANCE.checkUesCommonresApp(appModel != null ? appModel.getMiniappSubtype() : null)) {
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        Context startContext = prepareContext.getStartContext();
        if (startContext == null) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("context is null"));
                return;
            }
            return;
        }
        AppModel commonResModel = prepareContext.getCommonResModel();
        if (commonResModel == null) {
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("commonResModel is null"));
                return;
            }
            return;
        }
        if (appModel != null && (appId = appModel.getAppId()) != null) {
            MiniAppLaunch miniAppLaunch = MiniAppLaunch.INSTANCE;
            miniAppLaunch.commonResTrack(appId, "d_e");
            miniAppLaunch.commonResTrack(appId, "l_s");
        }
        if (AppPrepareUtils.INSTANCE.checkTarUnCompressStatus(startContext, commonResModel)) {
            TmcLogger.d(this.OooO00o, "Step_LoadStep:tar包已解压，跳转到 startStep");
            if (prepareController != null) {
                prepareController.unlock(prepareController);
            }
            if (prepareController != null) {
                prepareController.moveToNext();
                return;
            }
            return;
        }
        this.OooO0o0.deleteFile(this.OooO0Oo.getZipUnCompressPath(commonResModel));
        try {
            OooO00o(prepareContext, prepareController, commonResModel);
            if (o000oooo != null) {
                o000oooo.updateStepProgress(LoadStepAction.STEP_FINISH_DECOMPRESS);
            }
        } catch (Throwable th) {
            TmcLogger.e(this.OooO00o, th);
            if (prepareController != null) {
                prepareController.moveToError(new PrepareException("5", "unzip error" + th.getMessage()));
            }
        }
    }
}
