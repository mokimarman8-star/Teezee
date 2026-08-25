package com.cloud.tmc.kernel.security;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class DefaultPermission implements Permission {
    private String authority;
    private String description;
    public static final DefaultPermission ALL = new AnonymousClass1("ALL", 0, "all", "");
    private static final /* synthetic */ DefaultPermission[] $VALUES = $values();

    /* renamed from: com.cloud.tmc.kernel.security.DefaultPermission$1, reason: invalid class name */
    enum AnonymousClass1 extends DefaultPermission {
        private AnonymousClass1(String str, int i, String str2, String str3) {
            super(str, i, str2, str3);
        }
    }

    private static /* synthetic */ DefaultPermission[] $values() {
        return new DefaultPermission[]{ALL};
    }

    private DefaultPermission(String str, int i, String str2, String str3) {
        this.authority = str2;
        this.description = str3;
    }

    public static DefaultPermission valueOf(String str) {
        return (DefaultPermission) Enum.valueOf(DefaultPermission.class, str);
    }

    public static DefaultPermission[] values() {
        return (DefaultPermission[]) $VALUES.clone();
    }

    @Override // com.cloud.tmc.kernel.security.Permission
    public String authority() {
        return this.authority;
    }

    @Override // com.cloud.tmc.kernel.security.Permission
    public String description() {
        return this.description;
    }
}
