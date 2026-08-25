package org.apache.commons.compress.archivers.dump;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class DumpArchiveEntry implements cz.a {
    private String a;
    private TYPE b = TYPE.UNKNOWN;
    private Set c = Collections.emptySet();
    private final a d = new a();
    private String e;
    private int f;

    public enum PERMISSION {
        SETUID(2048),
        SETGUI(1024),
        STICKY(512),
        USER_READ(256),
        USER_WRITE(128),
        USER_EXEC(64),
        GROUP_READ(32),
        GROUP_WRITE(16),
        GROUP_EXEC(8),
        WORLD_READ(4),
        WORLD_WRITE(2),
        WORLD_EXEC(1);

        private int code;

        PERMISSION(int i) {
            this.code = i;
        }

        public static Set<PERMISSION> find(int i) {
            HashSet hashSet = new HashSet();
            for (PERMISSION permission : values()) {
                int i2 = permission.code;
                if ((i & i2) == i2) {
                    hashSet.add(permission);
                }
            }
            return hashSet.isEmpty() ? Collections.emptySet() : EnumSet.copyOf((Collection) hashSet);
        }
    }

    public enum TYPE {
        WHITEOUT(14),
        SOCKET(12),
        LINK(10),
        FILE(8),
        BLKDEV(6),
        DIRECTORY(4),
        CHRDEV(2),
        FIFO(1),
        UNKNOWN(15);

        private int code;

        TYPE(int i) {
            this.code = i;
        }

        public static TYPE find(int i) {
            TYPE type = UNKNOWN;
            for (TYPE type2 : values()) {
                if (i == type2.code) {
                    type = type2;
                }
            }
            return type;
        }
    }

    static class a {
        private final byte[] a = new byte[512];

        a() {
        }
    }

    public String a() {
        return this.a;
    }

    String b() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DumpArchiveEntry dumpArchiveEntry = (DumpArchiveEntry) obj;
        return dumpArchiveEntry.d != null && this.f == dumpArchiveEntry.f;
    }

    public int hashCode() {
        return this.f;
    }

    public String toString() {
        return a();
    }
}
