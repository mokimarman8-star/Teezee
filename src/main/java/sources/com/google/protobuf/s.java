package com.google.protobuf;

import com.google.protobuf.y;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class s implements Comparable {
    private final Field cachedSizeField;
    private final boolean enforceUtf8;
    private final y.e enumVerifier;
    private final Field field;
    private final int fieldNumber;
    private final Object mapDefaultEntry;
    private final Class<?> messageClass;
    private final a1 oneof;
    private final Class<?> oneofStoredType;
    private final Field presenceField;
    private final int presenceMask;
    private final boolean required;
    private final FieldType type;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType;

        static {
            int[] iArr = new int[FieldType.values().length];
            $SwitchMap$com$google$protobuf$FieldType = iArr;
            try {
                iArr[FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$FieldType[FieldType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$FieldType[FieldType.MESSAGE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$FieldType[FieldType.GROUP_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class b {
        private Field cachedSizeField;
        private boolean enforceUtf8;
        private y.e enumVerifier;
        private Field field;
        private int fieldNumber;
        private Object mapDefaultEntry;
        private a1 oneof;
        private Class<?> oneofStoredType;
        private Field presenceField;
        private int presenceMask;
        private boolean required;
        private FieldType type;

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public s build() {
            a1 a1Var = this.oneof;
            if (a1Var != null) {
                return s.forOneofMemberField(this.fieldNumber, this.type, a1Var, this.oneofStoredType, this.enforceUtf8, this.enumVerifier);
            }
            Object obj = this.mapDefaultEntry;
            if (obj != null) {
                return s.forMapField(this.field, this.fieldNumber, obj, this.enumVerifier);
            }
            Field field = this.presenceField;
            if (field != null) {
                return this.required ? s.forLegacyRequiredField(this.field, this.fieldNumber, this.type, field, this.presenceMask, this.enforceUtf8, this.enumVerifier) : s.forExplicitPresenceField(this.field, this.fieldNumber, this.type, field, this.presenceMask, this.enforceUtf8, this.enumVerifier);
            }
            y.e eVar = this.enumVerifier;
            if (eVar != null) {
                Field field2 = this.cachedSizeField;
                return field2 == null ? s.forFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, eVar) : s.forPackedFieldWithEnumVerifier(this.field, this.fieldNumber, this.type, eVar, field2);
            }
            Field field3 = this.cachedSizeField;
            return field3 == null ? s.forField(this.field, this.fieldNumber, this.type, this.enforceUtf8) : s.forPackedField(this.field, this.fieldNumber, this.type, field3);
        }

        public b withCachedSizeField(Field field) {
            this.cachedSizeField = field;
            return this;
        }

        public b withEnforceUtf8(boolean z) {
            this.enforceUtf8 = z;
            return this;
        }

        public b withEnumVerifier(y.e eVar) {
            this.enumVerifier = eVar;
            return this;
        }

        public b withField(Field field) {
            if (this.oneof != null) {
                throw new IllegalStateException("Cannot set field when building a oneof.");
            }
            this.field = field;
            return this;
        }

        public b withFieldNumber(int i) {
            this.fieldNumber = i;
            return this;
        }

        public b withMapDefaultEntry(Object obj) {
            this.mapDefaultEntry = obj;
            return this;
        }

        public b withOneof(a1 a1Var, Class<?> cls) {
            if (this.field != null || this.presenceField != null) {
                throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
            }
            this.oneof = a1Var;
            this.oneofStoredType = cls;
            return this;
        }

        public b withPresence(Field field, int i) {
            this.presenceField = (Field) y.checkNotNull(field, "presenceField");
            this.presenceMask = i;
            return this;
        }

        public b withRequired(boolean z) {
            this.required = z;
            return this;
        }

        public b withType(FieldType fieldType) {
            this.type = fieldType;
            return this;
        }
    }

    private s(Field field, int i, FieldType fieldType, Class<?> cls, Field field2, int i2, boolean z, boolean z2, a1 a1Var, Class<?> cls2, Object obj, y.e eVar, Field field3) {
        this.field = field;
        this.type = fieldType;
        this.messageClass = cls;
        this.fieldNumber = i;
        this.presenceField = field2;
        this.presenceMask = i2;
        this.required = z;
        this.enforceUtf8 = z2;
        this.oneof = a1Var;
        this.oneofStoredType = cls2;
        this.mapDefaultEntry = obj;
        this.enumVerifier = eVar;
        this.cachedSizeField = field3;
    }

    private static void checkFieldNumber(int i) {
        if (i > 0) {
            return;
        }
        throw new IllegalArgumentException("fieldNumber must be positive: " + i);
    }

    public static s forExplicitPresenceField(Field field, int i, FieldType fieldType, Field field2, int i2, boolean z, y.e eVar) {
        checkFieldNumber(i);
        y.checkNotNull(field, "field");
        y.checkNotNull(fieldType, "fieldType");
        y.checkNotNull(field2, "presenceField");
        if (field2 == null || isExactlyOneBitSet(i2)) {
            return new s(field, i, fieldType, null, field2, i2, false, z, null, null, null, eVar, null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i2);
    }

    public static s forField(Field field, int i, FieldType fieldType, boolean z) {
        checkFieldNumber(i);
        y.checkNotNull(field, "field");
        y.checkNotNull(fieldType, "fieldType");
        if (fieldType == FieldType.MESSAGE_LIST || fieldType == FieldType.GROUP_LIST) {
            throw new IllegalStateException("Shouldn't be called for repeated message fields.");
        }
        return new s(field, i, fieldType, null, null, 0, false, z, null, null, null, null, null);
    }

    public static s forFieldWithEnumVerifier(Field field, int i, FieldType fieldType, y.e eVar) {
        checkFieldNumber(i);
        y.checkNotNull(field, "field");
        return new s(field, i, fieldType, null, null, 0, false, false, null, null, null, eVar, null);
    }

    public static s forLegacyRequiredField(Field field, int i, FieldType fieldType, Field field2, int i2, boolean z, y.e eVar) {
        checkFieldNumber(i);
        y.checkNotNull(field, "field");
        y.checkNotNull(fieldType, "fieldType");
        y.checkNotNull(field2, "presenceField");
        if (field2 == null || isExactlyOneBitSet(i2)) {
            return new s(field, i, fieldType, null, field2, i2, true, z, null, null, null, eVar, null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i2);
    }

    public static s forMapField(Field field, int i, Object obj, y.e eVar) {
        y.checkNotNull(obj, "mapDefaultEntry");
        checkFieldNumber(i);
        y.checkNotNull(field, "field");
        return new s(field, i, FieldType.MAP, null, null, 0, false, true, null, null, obj, eVar, null);
    }

    public static s forOneofMemberField(int i, FieldType fieldType, a1 a1Var, Class<?> cls, boolean z, y.e eVar) {
        checkFieldNumber(i);
        y.checkNotNull(fieldType, "fieldType");
        y.checkNotNull(a1Var, "oneof");
        y.checkNotNull(cls, "oneofStoredType");
        if (fieldType.isScalar()) {
            return new s(null, i, fieldType, null, null, 0, false, z, a1Var, cls, null, eVar, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i + " is of type " + fieldType);
    }

    public static s forPackedField(Field field, int i, FieldType fieldType, Field field2) {
        checkFieldNumber(i);
        y.checkNotNull(field, "field");
        y.checkNotNull(fieldType, "fieldType");
        if (fieldType == FieldType.MESSAGE_LIST || fieldType == FieldType.GROUP_LIST) {
            throw new IllegalStateException("Shouldn't be called for repeated message fields.");
        }
        return new s(field, i, fieldType, null, null, 0, false, false, null, null, null, null, field2);
    }

    public static s forPackedFieldWithEnumVerifier(Field field, int i, FieldType fieldType, y.e eVar, Field field2) {
        checkFieldNumber(i);
        y.checkNotNull(field, "field");
        return new s(field, i, fieldType, null, null, 0, false, false, null, null, null, eVar, field2);
    }

    public static s forRepeatedMessageField(Field field, int i, FieldType fieldType, Class<?> cls) {
        checkFieldNumber(i);
        y.checkNotNull(field, "field");
        y.checkNotNull(fieldType, "fieldType");
        y.checkNotNull(cls, "messageClass");
        return new s(field, i, fieldType, cls, null, 0, false, false, null, null, null, null, null);
    }

    private static boolean isExactlyOneBitSet(int i) {
        return i != 0 && (i & (i + (-1))) == 0;
    }

    public static b newBuilder() {
        return new b(null);
    }

    @Override // java.lang.Comparable
    public int compareTo(s sVar) {
        return this.fieldNumber - sVar.fieldNumber;
    }

    public Field getCachedSizeField() {
        return this.cachedSizeField;
    }

    public y.e getEnumVerifier() {
        return this.enumVerifier;
    }

    public Field getField() {
        return this.field;
    }

    public int getFieldNumber() {
        return this.fieldNumber;
    }

    public Class<?> getListElementType() {
        return this.messageClass;
    }

    public Object getMapDefaultEntry() {
        return this.mapDefaultEntry;
    }

    public Class<?> getMessageFieldClass() {
        int i = a.$SwitchMap$com$google$protobuf$FieldType[this.type.ordinal()];
        if (i == 1 || i == 2) {
            Field field = this.field;
            return field != null ? field.getType() : this.oneofStoredType;
        }
        if (i == 3 || i == 4) {
            return this.messageClass;
        }
        return null;
    }

    public a1 getOneof() {
        return this.oneof;
    }

    public Class<?> getOneofStoredType() {
        return this.oneofStoredType;
    }

    public Field getPresenceField() {
        return this.presenceField;
    }

    public int getPresenceMask() {
        return this.presenceMask;
    }

    public FieldType getType() {
        return this.type;
    }

    public boolean isEnforceUtf8() {
        return this.enforceUtf8;
    }

    public boolean isRequired() {
        return this.required;
    }
}
