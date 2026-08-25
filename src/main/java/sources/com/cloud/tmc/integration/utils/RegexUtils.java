package com.cloud.tmc.integration.utils;

import androidx.collection.x0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class RegexUtils {
    private static final x0 CITY_MAP = new x0();

    private RegexUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String extractEmailProvider(String str) {
        return str.substring(str.lastIndexOf("@") + 1);
    }

    public static String extractEmailUsername(String str) {
        return str.substring(0, str.lastIndexOf("@"));
    }

    public static List<String> getMatches(String str, CharSequence charSequence) {
        if (charSequence == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str).matcher(charSequence);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static String getReplaceAll(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceAll(str3);
    }

    public static String getReplaceFirst(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceFirst(str3);
    }

    public static String[] getSplits(String str, String str2) {
        return str == null ? new String[0] : str.split(str2);
    }

    public static boolean isDate(CharSequence charSequence) {
        return isMatch("^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$", charSequence);
    }

    public static boolean isEmail(CharSequence charSequence) {
        return isMatch("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", charSequence);
    }

    public static boolean isFromAnyOfEmailProviders(String str, String[] strArr) {
        return ArrayUtils.contains(strArr, extractEmailProvider(str));
    }

    public static boolean isFromEmailProvider(String str, String str2) {
        return extractEmailProvider(str).equalsIgnoreCase(str2);
    }

    public static boolean isIDCard15(CharSequence charSequence) {
        return isMatch("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$", charSequence);
    }

    public static boolean isIDCard18(CharSequence charSequence) {
        return isMatch("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$", charSequence);
    }

    public static boolean isIDCard18Exact(CharSequence charSequence) {
        if (isIDCard18(charSequence)) {
            int[] iArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            char[] cArr = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
            x0 x0Var = CITY_MAP;
            if (x0Var.isEmpty()) {
                x0Var.put("11", "北京");
                x0Var.put("12", "天津");
                x0Var.put("13", "河北");
                x0Var.put("14", "山西");
                x0Var.put("15", "内蒙古");
                x0Var.put("21", "辽宁");
                x0Var.put("22", "吉林");
                x0Var.put("23", "黑龙江");
                x0Var.put("31", "上海");
                x0Var.put("32", "江苏");
                x0Var.put("33", "浙江");
                x0Var.put("34", "安徽");
                x0Var.put("35", "福建");
                x0Var.put("36", "江西");
                x0Var.put("37", "山东");
                x0Var.put("41", "河南");
                x0Var.put("42", "湖北");
                x0Var.put("43", "湖南");
                x0Var.put("44", "广东");
                x0Var.put("45", "广西");
                x0Var.put("46", "海南");
                x0Var.put("50", "重庆");
                x0Var.put("51", "四川");
                x0Var.put("52", "贵州");
                x0Var.put("53", "云南");
                x0Var.put("54", "西藏");
                x0Var.put("61", "陕西");
                x0Var.put("62", "甘肃");
                x0Var.put("63", "青海");
                x0Var.put("64", "宁夏");
                x0Var.put("65", "新疆");
                x0Var.put("71", "台湾老");
                x0Var.put("81", "香港");
                x0Var.put("82", "澳门");
                x0Var.put("83", "台湾新");
                x0Var.put("91", "国外");
            }
            if (x0Var.get(charSequence.subSequence(0, 2).toString()) != null) {
                int i = 0;
                for (int i2 = 0; i2 < 17; i2++) {
                    i += (charSequence.charAt(i2) - '0') * iArr[i2];
                }
                return charSequence.charAt(17) == cArr[i % 11];
            }
        }
        return false;
    }

    public static boolean isIP(CharSequence charSequence) {
        return isMatch("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)", charSequence);
    }

    public static boolean isMatch(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }

    public static boolean isMobileExact(CharSequence charSequence) {
        return isMobileExact(charSequence, null);
    }

    public static boolean isMobileExact(CharSequence charSequence, List<String> list) {
        if (isMatch("^((13[0-9])|(14[579])|(15[0-35-9])|(16[2567])|(17[0-35-8])|(18[0-9])|(19[0-35-9]))\\d{8}$", charSequence)) {
            return true;
        }
        if (list != null && charSequence != null && charSequence.length() == 11) {
            String charSequence2 = charSequence.toString();
            for (char c : charSequence2.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (charSequence2.startsWith(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMobileSimple(CharSequence charSequence) {
        return isMatch("^[1]\\d{10}$", charSequence);
    }

    public static boolean isTel(CharSequence charSequence) {
        return isMatch("^0\\d{2,3}[- ]?\\d{7,8}$", charSequence);
    }

    public static boolean isURL(CharSequence charSequence) {
        return isMatch("[a-zA-z]+://[^\\s]*", charSequence);
    }

    public static boolean isUsername(CharSequence charSequence) {
        return isMatch("^[\\w\\u4e00-\\u9fa5]{6,20}(?<!_)$", charSequence);
    }

    public static boolean isZh(CharSequence charSequence) {
        return isMatch("^[\\u4e00-\\u9fa5]+$", charSequence);
    }
}
