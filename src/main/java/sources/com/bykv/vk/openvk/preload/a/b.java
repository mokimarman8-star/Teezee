package com.bykv.vk.openvk.preload.a;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class b implements c {
    public static final b a = new b("IDENTITY") { // from class: com.bykv.vk.openvk.preload.a.b.1
        {
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return field.getName();
        }
    };
    private static b b = new b("UPPER_CAMEL_CASE") { // from class: com.bykv.vk.openvk.preload.a.b.2
        {
            int i = 1;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(field.getName());
        }
    };
    private static b c = new b("UPPER_CAMEL_CASE_WITH_SPACES") { // from class: com.bykv.vk.openvk.preload.a.b.3
        {
            int i = 2;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(b.a(field.getName(), " "));
        }
    };
    private static b d = new b("LOWER_CASE_WITH_UNDERSCORES") { // from class: com.bykv.vk.openvk.preload.a.b.4
        {
            int i = 3;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    };
    private static b e = new b("LOWER_CASE_WITH_DASHES") { // from class: com.bykv.vk.openvk.preload.a.b.5
        {
            int i = 4;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };
    private static b f = new b("LOWER_CASE_WITH_DOTS") { // from class: com.bykv.vk.openvk.preload.a.b.6
        {
            int i = 5;
            byte b2 = 0;
        }

        @Override // com.bykv.vk.openvk.preload.a.c
        public final String a(Field field) {
            return b.a(field.getName(), InstructionFileId.DOT).toLowerCase(Locale.ENGLISH);
        }
    };

    private b(String str, int i) {
    }

    /* synthetic */ b(String str, int i, byte b2) {
        this(str, i);
    }

    static String a(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char charAt = str.charAt(i);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
