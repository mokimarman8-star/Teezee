package com.cloud.tmc.miniapp.defaultimpl;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.cloud.tmc.integration.callback.CommonDialogCallback;
import com.cloud.tmc.integration.callback.CommonDialogOperate;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.TmcGsonUtilsKt;
import com.cloud.tmc.miniapp.dialog.BottomActionSheetDialog$ActionItem;
import com.cloud.tmc.miniapp.dialog.OooOO0O;
import com.cloud.tmc.miniapp.dialog.OooOo;
import com.cloud.tmc.miniapp.dialog.OooOo00;
import com.cloud.tmc.miniapp.utils.toast.ToastUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ToastImp implements ToastProxy {
    public static final OooO00o Companion = new OooO00o();

    public static final class OooO implements CommonDialogOperate {
        public final /* synthetic */ OooOo00 OooO00o;

        public OooO(OooOo00 oooOo00) {
            this.OooO00o = oooOo00;
        }

        public void dismiss() {
            try {
                if (this.OooO00o.isShowing()) {
                    this.OooO00o.dismiss();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static final class OooO00o {
    }

    public static final class OooO0O0 implements OooOO0O {
        public final /* synthetic */ BridgeCallback OooO00o;

        public OooO0O0(BridgeCallback bridgeCallback) {
            this.OooO00o = bridgeCallback;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOO0O
        public void OooO00o(int i, BottomActionSheetDialog$ActionItem bottomActionSheetDialog$ActionItem) {
            Intrinsics.h(bottomActionSheetDialog$ActionItem, TmcConstants.KEY_BRIDGE_RESULT_DATA);
            TmcLogger.d("ToastImp", "showActionSheet: " + bottomActionSheetDialog$ActionItem);
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("tapIndex", Integer.valueOf(i));
                jsonObject.addProperty("content", bottomActionSheetDialog$ActionItem.getText());
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    public static final class OooO0OO implements OooOo {
        public final /* synthetic */ CommonDialogCallback OooO00o;

        public OooO0OO(CommonDialogCallback commonDialogCallback) {
            this.OooO00o = commonDialogCallback;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO00o(View view) {
            Intrinsics.h(view, "view");
            CommonDialogCallback commonDialogCallback = this.OooO00o;
            if (commonDialogCallback != null) {
                commonDialogCallback.onLeftClick();
            }
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO0O0(View view) {
            Intrinsics.h(view, "view");
            CommonDialogCallback commonDialogCallback = this.OooO00o;
            if (commonDialogCallback != null) {
                commonDialogCallback.onRightClick();
            }
        }
    }

    public static final class OooO0o implements OooOo {
        public final /* synthetic */ CommonDialogCallback OooO00o;

        public OooO0o(CommonDialogCallback commonDialogCallback) {
            this.OooO00o = commonDialogCallback;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO00o(View view) {
            Intrinsics.h(view, "view");
            CommonDialogCallback commonDialogCallback = this.OooO00o;
            if (commonDialogCallback != null) {
                commonDialogCallback.onLeftClick();
            }
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO0O0(View view) {
            Intrinsics.h(view, "view");
            CommonDialogCallback commonDialogCallback = this.OooO00o;
            if (commonDialogCallback != null) {
                commonDialogCallback.onRightClick();
            }
        }
    }

    public static final class OooOO0 implements OooOo {
        public final /* synthetic */ BridgeCallback OooO00o;
        public final /* synthetic */ boolean OooO0O0;
        public final /* synthetic */ OooOo00 OooO0OO;

        public OooOO0(BridgeCallback bridgeCallback, boolean z, OooOo00 oooOo00) {
            this.OooO00o = bridgeCallback;
            this.OooO0O0 = z;
            this.OooO0OO = oooOo00;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO00o(View view) {
            Intrinsics.h(view, "view");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("cancel", Boolean.TRUE);
                jsonObject.addProperty("confirm", Boolean.FALSE);
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooOo
        public void OooO0O0(View view) {
            Intrinsics.h(view, "view");
            BridgeCallback bridgeCallback = this.OooO00o;
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                boolean z = this.OooO0O0;
                OooOo00 oooOo00 = this.OooO0OO;
                jsonObject.addProperty("cancel", Boolean.FALSE);
                jsonObject.addProperty("confirm", Boolean.TRUE);
                if (z) {
                    TextView OooO0oO = oooOo00.OooO0oO();
                    jsonObject.addProperty("content", OooO0oO != null ? OooO0oO.getText().toString() : null);
                }
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
        }
    }

    public void showActionSheet(JsonArray jsonArray, String str, String str2, String str3, String str4, boolean z, String str5, String str6, Context context, String str7, BridgeCallback bridgeCallback) {
        ArrayList arrayList;
        ArrayList<BottomActionSheetDialog$ActionItem> arrayList2;
        boolean z2;
        String str8;
        String str9 = str5;
        Intrinsics.h(jsonArray, "actions");
        Intrinsics.h(str, NativeComponentConstants.KEY_COMPONENT_TYPE);
        Intrinsics.h(str9, "cancelText");
        Intrinsics.h(str6, "cancelColor");
        Intrinsics.h(context, "context");
        try {
            int size = jsonArray.size();
            if (1 > size || size >= 11) {
                if (bridgeCallback != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "Invalid " + size + ", must be between 1 and 10 : AS10003");
                    bridgeCallback.sendFailResponse(jsonObject);
                    return;
                }
                return;
            }
            try {
                String json = TmcGsonUtilsKt.toJson(jsonArray);
                Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.defaultimpl.ToastImp$showActionSheet$data$itemList$1
                }.getType();
                Intrinsics.g(type, "object : TypeToken<ArrayList<String>>() {}.type");
                arrayList = (ArrayList) TmcGsonUtils.fromJson(json, type);
            } catch (Throwable th) {
                TmcLogger.e("ToastImp", "itemList parse error!", th);
                arrayList = null;
            }
            if (arrayList != null) {
                arrayList2 = new ArrayList<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new BottomActionSheetDialog$ActionItem(null, (String) it.next(), str4, null, false, null, null, 121, null));
                }
            } else {
                String json2 = TmcGsonUtilsKt.toJson(jsonArray);
                Type type2 = new TypeToken<ArrayList<BottomActionSheetDialog$ActionItem>>() { // from class: com.cloud.tmc.miniapp.defaultimpl.ToastImp$showActionSheet$data$3
                }.getType();
                Intrinsics.g(type2, "object :\n               …og.ActionItem>>() {}.type");
                Iterable iterable = (Iterable) TmcGsonUtils.fromJson(json2, type2);
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String text = ((BottomActionSheetDialog$ActionItem) it2.next()).getText();
                    if (text == null || text.length() == 0) {
                        throw new IllegalArgumentException("Action's text is null or empty");
                    }
                }
                arrayList2 = (ArrayList) iterable;
            }
            com.cloud.tmc.miniapp.dialog.OooOO0 oooOO0 = new com.cloud.tmc.miniapp.dialog.OooOO0(context);
            if (str3 != null && str3.length() != 0) {
                AppCompatTextView OooO0OO2 = oooOO0.OooO0OO();
                if (OooO0OO2 != null) {
                    ViewExtKt.toVisibleOrGone(OooO0OO2, !(str2 == null || str2.length() == 0));
                }
                AppCompatTextView OooO0OO3 = oooOO0.OooO0OO();
                if (OooO0OO3 != null) {
                    OooO0OO3.setText(str2);
                }
                AppCompatTextView OooO0O02 = oooOO0.OooO0O0();
                if (OooO0O02 != null) {
                    ViewExtKt.toVisibleOrGone(OooO0O02, !(str3 == null || str3.length() == 0));
                }
                AppCompatTextView OooO0O03 = oooOO0.OooO0O0();
                if (OooO0O03 != null) {
                    OooO0O03.setText(str3);
                }
            }
            Intrinsics.h(str, "showType");
            com.cloud.tmc.miniapp.dialog.OooO0o oooO0o = oooOO0.OooO0oO;
            oooO0o.getClass();
            Intrinsics.h(str, "showType");
            oooO0o.OooO0O0 = str;
            oooOO0.OooO0oO.OooO0OO = str7;
            com.cloud.tmc.miniapp.dialog.OooOO0 OooO00o2 = oooOO0.OooO00o(arrayList2);
            if (z) {
                com.cloud.tmc.miniapp.dialog.OooO0o oooO0o2 = OooO00o2.OooO0oO;
                if (str9 != null) {
                    if (str5.length() <= 0) {
                        str9 = null;
                    }
                    if (str9 != null) {
                        str8 = str9;
                        z2 = true;
                        oooO0o2.addItem(new BottomActionSheetDialog$ActionItem("Cancel", str8, str6, "#4D191F2B", true, null, "#0F191F2B", 32, null));
                    }
                }
                str8 = "Cancel";
                z2 = true;
                oooO0o2.addItem(new BottomActionSheetDialog$ActionItem("Cancel", str8, str6, "#4D191F2B", true, null, "#0F191F2B", 32, null));
            } else {
                z2 = true;
            }
            OooO00o2.OooO0oo = new OooO0O0(bridgeCallback);
            OooO00o2.setCancelable(z2).setCanceledOnTouchOutside(z2).show();
        } catch (Throwable th2) {
            TmcLogger.e("ToastImp", th2);
            if (bridgeCallback != null) {
                com.cloud.tmc.miniapp.bridge.OooO00o.OooO00o("errMsg", "Parameter error: AS10001", bridgeCallback);
            }
        }
    }

    public void showAddHomeSuccessfulToast() {
        ToastUtils.showAddhomeSuccessToast();
    }

    public void showCommonDialog(String str, String str2, int i, Boolean bool, String str3, String str4, String str5, String str6, Context context, CommonDialogCallback commonDialogCallback) {
        TextView OooO0Oo;
        Intrinsics.h(context, "context");
        OooOo00 oooOo00 = new OooOo00(context, true);
        if (str != null && str.length() != 0) {
            oooOo00.OooO0Oo(str);
        }
        if (str2 != null && str2.length() != 0) {
            oooOo00.OooO00o(str2);
        }
        if (i > 0) {
            oooOo00.OooO00o(i);
        } else {
            oooOo00.OooO00o(true);
        }
        if (Intrinsics.c(bool, Boolean.TRUE)) {
            if (str3 != null && str3.length() != 0 && (OooO0Oo = oooOo00.OooO0Oo()) != null) {
                OooO0Oo.setText(oooOo00.OooO00o(str3, 12));
            }
            oooOo00.OooO0O0(true);
        }
        if (str5 != null && str5.length() != 0) {
            oooOo00.OooO0OO(str5);
        }
        if (str4 != null) {
            try {
                if (str4.length() != 0) {
                    oooOo00.OooO0O0(Color.parseColor(str4));
                }
            } catch (Exception e) {
                TmcLogger.e("[ToastImp]: set common dialog cancel button color error", e);
                toast("cancel button color error");
            }
        }
        if (str6 != null) {
            try {
                if (str6.length() != 0) {
                    oooOo00.OooO0OO(Color.parseColor(str6));
                }
            } catch (Exception e2) {
                TmcLogger.e("[ToastImp]: set common dialog confirm button color error", e2);
                toast("confirm button color error");
            }
        }
        oooOo00.OooO00o(new OooO0OO(commonDialogCallback)).setCanceledOnTouchOutside(false).show();
    }

    public CommonDialogOperate showCommonDialogWithOperate(String str, String str2, int i, Boolean bool, String str3, String str4, String str5, String str6, Context context, CommonDialogCallback commonDialogCallback) {
        TextView OooO0Oo;
        Intrinsics.h(context, "context");
        OooOo00 oooOo00 = new OooOo00(context, true);
        if (str != null && str.length() != 0) {
            oooOo00.OooO0Oo(str);
        }
        if (str2 != null && str2.length() != 0) {
            oooOo00.OooO00o(str2);
        }
        if (i > 0) {
            oooOo00.OooO00o(i);
        } else {
            oooOo00.OooO00o(true);
        }
        if (Intrinsics.c(bool, Boolean.TRUE)) {
            if (str3 != null && str3.length() != 0 && (OooO0Oo = oooOo00.OooO0Oo()) != null) {
                OooO0Oo.setText(oooOo00.OooO00o(str3, 12));
            }
            oooOo00.OooO0O0(true);
        }
        if (str5 != null && str5.length() != 0) {
            oooOo00.OooO0OO(str5);
        }
        if (str4 != null) {
            try {
                if (str4.length() != 0) {
                    oooOo00.OooO0O0(Color.parseColor(str4));
                }
            } catch (Exception e) {
                TmcLogger.e("[ToastImp]: set common dialog cancel button color error", e);
                toast("cancel button color error");
            }
        }
        if (str6 != null) {
            try {
                if (str6.length() != 0) {
                    oooOo00.OooO0OO(Color.parseColor(str6));
                }
            } catch (Exception e2) {
                TmcLogger.e("[ToastImp]: set common dialog confirm button color error", e2);
                toast("confirm button color error");
            }
        }
        oooOo00.OooO00o(new OooO0o(commonDialogCallback)).setCanceledOnTouchOutside(false).show();
        return new OooO(oooOo00);
    }

    public void showModal(String str, String str2, boolean z, boolean z2, String str3, String str4, String str5, String str6, String str7, Context context, BridgeCallback bridgeCallback) {
        TextView OooO0Oo;
        TextView OooO0oO;
        Intrinsics.h(context, "context");
        OooOo00 oooOo00 = new OooOo00(context, false);
        if (str != null && str.length() != 0) {
            oooOo00.OooO0Oo(str);
        }
        FrameLayout frameLayout = (FrameLayout) oooOo00.OooO0Oo.getValue();
        if (frameLayout != null) {
            ViewExtKt.toVisibleOrGone(frameLayout, !z2);
        }
        FrameLayout frameLayout2 = (FrameLayout) oooOo00.OooO0o0.getValue();
        if (frameLayout2 != null) {
            ViewExtKt.toVisibleOrGone(frameLayout2, z2);
        }
        if (str3 != null && str3.length() != 0 && str3 != null && str3.length() != 0 && (OooO0oO = oooOo00.OooO0oO()) != null) {
            OooO0oO.setHint(str3);
        }
        if (str2 != null && str2.length() != 0) {
            oooOo00.OooO00o(str2);
        }
        if (z) {
            if (str4 != null && str4.length() != 0 && (OooO0Oo = oooOo00.OooO0Oo()) != null) {
                OooO0Oo.setText(oooOo00.OooO00o(str4, 12));
            }
            oooOo00.OooO0O0(true);
        }
        if (str6 != null && str6.length() != 0) {
            oooOo00.OooO0OO(str6);
        }
        if (str5 != null) {
            try {
                if (str5.length() != 0) {
                    oooOo00.OooO0O0(Color.parseColor(str5));
                }
            } catch (Exception e) {
                TmcLogger.e("[ToastImp]: set common dialog cancel button color error", e);
                toast("cancel button color error");
            }
        }
        if (str7 != null) {
            try {
                if (str7.length() != 0) {
                    oooOo00.OooO0OO(Color.parseColor(str7));
                }
            } catch (Exception e2) {
                TmcLogger.e("[ToastImp]: set common dialog confirm button color error", e2);
                toast("confirm button color error");
            }
        }
        oooOo00.OooO00o(new OooOO0(bridgeCallback, z2, oooOo00)).OooO00o(true).setCanceledOnTouchOutside(false).show();
    }

    public void toast(int i) {
        ToastUtils.showToast$default(i, 0, 0L, false, 14, null);
    }

    public void toast(String str) {
        ToastUtils.showToast$default(StringExtKt.orDefault(str, ""), 0, 0L, false, null, 30, null);
    }

    public void toast(String str, int i) {
        ToastUtils.showToast$default(StringExtKt.orDefault(str, ""), i, 0L, false, null, 28, null);
    }
}
