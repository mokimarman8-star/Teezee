package com.pgl.ssdk;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class s {
    private static AccessibilityManager a;

    private static AccessibilityManager a(Context context) {
        if (a == null) {
            a = (AccessibilityManager) context.getSystemService("accessibility");
        }
        return a;
    }

    public static String b(Context context) {
        AccessibilityManager a2;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        if (context == null || (a2 = a(context)) == null || (enabledAccessibilityServiceList = a2.getEnabledAccessibilityServiceList(-1)) == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < enabledAccessibilityServiceList.size(); i++) {
            AccessibilityServiceInfo accessibilityServiceInfo = enabledAccessibilityServiceList.get(i);
            if (accessibilityServiceInfo != null) {
                sb2.append(String.format("%s#%s", accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName, accessibilityServiceInfo.getResolveInfo().serviceInfo.name));
                if (i != enabledAccessibilityServiceList.size() - 1) {
                    sb2.append(",");
                }
            }
        }
        return sb2.toString();
    }
}
