package com.cloud.tmc.miniutils.util;

import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ResourceUtils {
    private ResourceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean copyFileFromAssets(String str, String str2) {
        try {
            String[] list = Utils.getApp().getAssets().list(str);
            if (list == null || list.length <= 0) {
                return UtilsBridge.writeFileFromIS(str2, Utils.getApp().getAssets().open(str));
            }
            boolean z = true;
            for (String str3 : list) {
                z &= copyFileFromAssets(str + "/" + str3, str2 + "/" + str3);
            }
            return z;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getAnimIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "anim", Utils.getApp().getPackageName());
    }

    public static int getColorIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "color", Utils.getApp().getPackageName());
    }

    public static int getDimenIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "dimen", Utils.getApp().getPackageName());
    }

    public static Drawable getDrawable(int i) {
        return androidx.core.content.b.getDrawable(Utils.getApp(), i);
    }

    public static int getDrawableIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "drawable", Utils.getApp().getPackageName());
    }

    public static int getIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "id", Utils.getApp().getPackageName());
    }

    public static int getLayoutIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "layout", Utils.getApp().getPackageName());
    }

    public static int getMenuIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "menu", Utils.getApp().getPackageName());
    }

    public static int getMipmapIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "mipmap", Utils.getApp().getPackageName());
    }

    public static int getStringIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "string", Utils.getApp().getPackageName());
    }

    public static int getStyleIdByName(String str) {
        return Utils.getApp().getResources().getIdentifier(str, "style", Utils.getApp().getPackageName());
    }

    public static List<String> readAssets2List(String str) {
        return readAssets2List(str, "");
    }

    public static List<String> readAssets2List(String str, String str2) {
        try {
            return UtilsBridge.inputStream2Lines(Utils.getApp().getResources().getAssets().open(str), str2);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static String readAssets2String(String str) {
        return readAssets2String(str, null);
    }

    public static String readAssets2String(String str, String str2) {
        try {
            byte[] inputStream2Bytes = UtilsBridge.inputStream2Bytes(Utils.getApp().getAssets().open(str));
            return inputStream2Bytes.length == 0 ? "" : UtilsBridge.isSpace(str2) ? new String(inputStream2Bytes) : new String(inputStream2Bytes, str2);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
