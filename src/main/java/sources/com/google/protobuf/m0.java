package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.s0;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class m0 {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final Object key;
    private final b metadata;
    private final Object value;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static class b {
        public final Object defaultKey;
        public final Object defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public b(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
            this.keyType = fieldType;
            this.defaultKey = obj;
            this.valueType = fieldType2;
            this.defaultValue = obj2;
        }
    }

    private m0(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        this.metadata = new b(fieldType, obj, fieldType2, obj2);
        this.key = obj;
        this.value = obj2;
    }

    private m0(b bVar, Object obj, Object obj2) {
        this.metadata = bVar;
        this.key = obj;
        this.value = obj2;
    }

    static <K, V> int computeSerializedSize(b bVar, K k, V v) {
        return t.computeElementSize(bVar.keyType, 1, k) + t.computeElementSize(bVar.valueType, 2, v);
    }

    public static <K, V> m0 newDefaultInstance(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        return new m0(fieldType, k, fieldType2, v);
    }

    static <K, V> Map.Entry<K, V> parseEntry(i iVar, b bVar, o oVar) throws IOException {
        Object obj = bVar.defaultKey;
        Object obj2 = bVar.defaultValue;
        while (true) {
            int readTag = iVar.readTag();
            if (readTag == 0) {
                break;
            }
            if (readTag == WireFormat.makeTag(1, bVar.keyType.getWireType())) {
                obj = parseField(iVar, oVar, bVar.keyType, obj);
            } else if (readTag == WireFormat.makeTag(2, bVar.valueType.getWireType())) {
                obj2 = parseField(iVar, oVar, bVar.valueType, obj2);
            } else if (!iVar.skipField(readTag)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    static <T> T parseField(i iVar, o oVar, WireFormat.FieldType fieldType, T t) throws IOException {
        int i = a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()];
        if (i == 1) {
            s0.a builder = ((s0) t).toBuilder();
            iVar.readMessage(builder, oVar);
            return (T) builder.mo54buildPartial();
        }
        if (i == 2) {
            return (T) Integer.valueOf(iVar.readEnum());
        }
        if (i != 3) {
            return (T) t.readPrimitiveField(iVar, fieldType, true);
        }
        throw new RuntimeException("Groups are not allowed in maps.");
    }

    static <K, V> void writeTo(CodedOutputStream codedOutputStream, b bVar, K k, V v) throws IOException {
        t.writeElement(codedOutputStream, bVar.keyType, 1, k);
        t.writeElement(codedOutputStream, bVar.valueType, 2, v);
    }

    public int computeMessageSize(int i, Object obj, Object obj2) {
        return CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, obj, obj2));
    }

    public Object getKey() {
        return this.key;
    }

    b getMetadata() {
        return this.metadata;
    }

    public Object getValue() {
        return this.value;
    }

    public Map.Entry<Object, Object> parseEntry(ByteString byteString, o oVar) throws IOException {
        return parseEntry(byteString.newCodedInput(), this.metadata, oVar);
    }

    public void parseInto(MapFieldLite<Object, Object> mapFieldLite, i iVar, o oVar) throws IOException {
        int pushLimit = iVar.pushLimit(iVar.readRawVarint32());
        b bVar = this.metadata;
        Object obj = bVar.defaultKey;
        Object obj2 = bVar.defaultValue;
        while (true) {
            int readTag = iVar.readTag();
            if (readTag == 0) {
                break;
            }
            if (readTag == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) {
                obj = parseField(iVar, oVar, this.metadata.keyType, obj);
            } else if (readTag == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) {
                obj2 = parseField(iVar, oVar, this.metadata.valueType, obj2);
            } else if (!iVar.skipField(readTag)) {
                break;
            }
        }
        iVar.checkLastTagWas(0);
        iVar.popLimit(pushLimit);
        mapFieldLite.put(obj, obj2);
    }

    public void serializeTo(CodedOutputStream codedOutputStream, int i, Object obj, Object obj2) throws IOException {
        codedOutputStream.writeTag(i, 2);
        codedOutputStream.writeUInt32NoTag(computeSerializedSize(this.metadata, obj, obj2));
        writeTo(codedOutputStream, this.metadata, obj, obj2);
    }
}
