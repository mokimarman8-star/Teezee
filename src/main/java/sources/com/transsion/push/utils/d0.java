package com.transsion.push.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.push.config.PushRepository;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d0 {
    private static boolean a() {
        if (!k0.e()) {
            return true;
        }
        try {
            Class.forName("com.transsion.tpush.tpms.PushContentProvider");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        if (!a()) {
            return false;
        }
        try {
            String str = (String) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_FCM_TOKEN, BuildConfig.FLAVOR);
            if (TextUtils.isEmpty(str)) {
                PushLogUtils.LOG.i("update provider active fail, token is empty");
                return false;
            }
            Uri parse = Uri.parse("content://com.transsion.tpush.tpms.PushContentProvider/active");
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(PushConstants.PROVIDER_VAID, AthenaAnalytics.H(yj.a.a(), true));
            contentValues.put(PushConstants.PROVIDER_FIELD_PKG, context.getPackageName());
            contentValues.put(PushConstants.PROVIDER_FIELD_APP_ID, PushUtils.e());
            contentValues.put(PushConstants.PROVIDER_FIELD_APP_KEY, PushUtils.f());
            contentValues.put("token", str);
            contentValues.put(PushConstants.PROVIDER_FIELD_UPDATE_TIME, Long.valueOf(System.currentTimeMillis()));
            contentValues.put(PushConstants.PROVIDER_FIELD_NOTICE_ENABLE, Integer.valueOf(NotificationAssistUtils.isOpenNotification(context) ? 1 : 2));
            contentValues.put(PushConstants.PROVIDER_FIELD_SDK_VERSION, "2.0.2.01");
            contentValues.put(PushConstants.PROVIDER_FIELD_SDK_VERSION_CODE, (Integer) 17004);
            contentResolver.update(parse, contentValues, null, null);
            return true;
        } catch (Exception e) {
            PushLogUtils.LOG.i("update provider active fail, e:" + e.getMessage());
            return false;
        }
    }

    public static boolean c(Context context) {
        if (!a()) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.transsion.tpush.tpms.PushContentProvider/config"), new String[]{PushUtils.e()}, null, null, null);
                if (cursor == null || cursor.getCount() <= 0) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                }
                cursor.moveToNext();
                int i = cursor.getInt(cursor.getColumnIndex(PushConstants.PROVIDER_FIELD_DESTROY));
                int i2 = cursor.getInt(cursor.getColumnIndex(PushConstants.PROVIDER_FIELD_SYNC_INFO_INTERVAL));
                PushLogUtils.LOG.g("updateConfig----->destroy:" + i + ", interval:" + i2);
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_SELF_DESTROYING, Integer.valueOf(i));
                PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_SELF_DESTROYING_INTERVAL, Integer.valueOf(i2));
                cursor.close();
                return true;
            } catch (Exception e) {
                PushLogUtils.LOG.i("update provider config fail, e:" + e.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }
}
