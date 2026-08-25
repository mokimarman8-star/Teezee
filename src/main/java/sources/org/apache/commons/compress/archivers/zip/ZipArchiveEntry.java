package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.c;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class ZipArchiveEntry extends ZipEntry implements cz.a {

    public enum CommentSource {
        COMMENT,
        UNICODE_EXTRA_FIELD
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BEST_EFFORT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class ExtraFieldParsingMode {
        private static final /* synthetic */ ExtraFieldParsingMode[] $VALUES;
        public static final ExtraFieldParsingMode BEST_EFFORT;
        public static final ExtraFieldParsingMode DRACONIC;
        public static final ExtraFieldParsingMode ONLY_PARSEABLE_LENIENT;
        public static final ExtraFieldParsingMode ONLY_PARSEABLE_STRICT;
        public static final ExtraFieldParsingMode STRICT_FOR_KNOW_EXTRA_FIELDS;
        private final c.a onUnparseableData;

        static {
            c.a aVar = c.a.d;
            ExtraFieldParsingMode extraFieldParsingMode = new ExtraFieldParsingMode("BEST_EFFORT", 0, aVar) { // from class: org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.1
                @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode
                public t fill(t tVar, byte[] bArr, int i, int i2, boolean z) {
                    return ExtraFieldParsingMode.fillAndMakeUnrecognizedOnError(tVar, bArr, i, i2, z);
                }
            };
            BEST_EFFORT = extraFieldParsingMode;
            ExtraFieldParsingMode extraFieldParsingMode2 = new ExtraFieldParsingMode("STRICT_FOR_KNOW_EXTRA_FIELDS", 1, aVar);
            STRICT_FOR_KNOW_EXTRA_FIELDS = extraFieldParsingMode2;
            c.a aVar2 = c.a.c;
            ExtraFieldParsingMode extraFieldParsingMode3 = new ExtraFieldParsingMode("ONLY_PARSEABLE_LENIENT", 2, aVar2) { // from class: org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.2
                @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode
                public t fill(t tVar, byte[] bArr, int i, int i2, boolean z) {
                    return ExtraFieldParsingMode.fillAndMakeUnrecognizedOnError(tVar, bArr, i, i2, z);
                }
            };
            ONLY_PARSEABLE_LENIENT = extraFieldParsingMode3;
            ExtraFieldParsingMode extraFieldParsingMode4 = new ExtraFieldParsingMode("ONLY_PARSEABLE_STRICT", 3, aVar2);
            ONLY_PARSEABLE_STRICT = extraFieldParsingMode4;
            ExtraFieldParsingMode extraFieldParsingMode5 = new ExtraFieldParsingMode("DRACONIC", 4, c.a.b);
            DRACONIC = extraFieldParsingMode5;
            $VALUES = new ExtraFieldParsingMode[]{extraFieldParsingMode, extraFieldParsingMode2, extraFieldParsingMode3, extraFieldParsingMode4, extraFieldParsingMode5};
        }

        private ExtraFieldParsingMode(String str, int i, c.a aVar) {
            this.onUnparseableData = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static t fillAndMakeUnrecognizedOnError(t tVar, byte[] bArr, int i, int i2, boolean z) {
            try {
                return c.c(tVar, bArr, i, i2, z);
            } catch (ZipException unused) {
                j jVar = new j();
                jVar.b(tVar.getHeaderId());
                if (z) {
                    jVar.c(Arrays.copyOfRange(bArr, i, i2 + i));
                } else {
                    jVar.a(Arrays.copyOfRange(bArr, i, i2 + i));
                }
                return jVar;
            }
        }

        public static ExtraFieldParsingMode valueOf(String str) {
            return (ExtraFieldParsingMode) Enum.valueOf(ExtraFieldParsingMode.class, str);
        }

        public static ExtraFieldParsingMode[] values() {
            return (ExtraFieldParsingMode[]) $VALUES.clone();
        }

        public t createExtraField(ZipShort zipShort) throws ZipException, InstantiationException, IllegalAccessException {
            return c.a(zipShort);
        }

        public t fill(t tVar, byte[] bArr, int i, int i2, boolean z) throws ZipException {
            return c.c(tVar, bArr, i, i2, z);
        }

        public t onUnparseableExtraField(byte[] bArr, int i, int i2, boolean z, int i3) throws ZipException {
            return this.onUnparseableData.a(bArr, i, i2, z, i3);
        }
    }

    public enum NameSource {
        NAME,
        NAME_WITH_EFS_FLAG,
        UNICODE_EXTRA_FIELD
    }
}
