package com.amazonaws.util.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.EOFException;
import java.io.Reader;
import java.io.Writer;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class GsonFactory implements AwsJsonFactory {

    /* renamed from: com.amazonaws.util.json.GsonFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[JsonToken.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private static final class GsonReader implements AwsJsonReader {
        private final JsonReader a;

        public GsonReader(Reader reader) {
            this.a = new JsonReader(reader);
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void a() {
            this.a.beginObject();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void b() {
            this.a.endObject();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void c() {
            this.a.skipValue();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void close() {
            this.a.close();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public boolean d() {
            JsonToken peek = this.a.peek();
            return JsonToken.BEGIN_ARRAY.equals(peek) || JsonToken.BEGIN_OBJECT.equals(peek);
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public String e() {
            return this.a.nextName();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public String f() {
            JsonToken peek = this.a.peek();
            if (!JsonToken.NULL.equals(peek)) {
                return JsonToken.BOOLEAN.equals(peek) ? this.a.nextBoolean() ? "true" : "false" : this.a.nextString();
            }
            this.a.nextNull();
            return null;
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public AwsJsonToken peek() {
            try {
                return GsonFactory.d(this.a.peek());
            } catch (EOFException unused) {
                return null;
            }
        }
    }

    private static final class GsonWriter implements AwsJsonWriter {
        private final JsonWriter a;

        public GsonWriter(Writer writer) {
            this.a = new JsonWriter(writer);
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter a() {
            this.a.beginObject();
            return this;
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter b() {
            this.a.endObject();
            return this;
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter c(String str) {
            this.a.name(str);
            return this;
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public void close() {
            this.a.close();
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter d(String str) {
            this.a.value(str);
            return this;
        }
    }

    GsonFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AwsJsonToken d(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (AnonymousClass1.a[jsonToken.ordinal()]) {
            case 1:
                return AwsJsonToken.BEGIN_ARRAY;
            case 2:
                return AwsJsonToken.END_ARRAY;
            case 3:
                return AwsJsonToken.BEGIN_OBJECT;
            case 4:
                return AwsJsonToken.END_OBJECT;
            case 5:
                return AwsJsonToken.FIELD_NAME;
            case 6:
                return AwsJsonToken.VALUE_BOOLEAN;
            case 7:
                return AwsJsonToken.VALUE_NUMBER;
            case 8:
                return AwsJsonToken.VALUE_NULL;
            case 9:
                return AwsJsonToken.VALUE_STRING;
            case 10:
                return null;
            default:
                return AwsJsonToken.UNKNOWN;
        }
    }

    @Override // com.amazonaws.util.json.AwsJsonFactory
    public AwsJsonWriter a(Writer writer) {
        return new GsonWriter(writer);
    }

    @Override // com.amazonaws.util.json.AwsJsonFactory
    public AwsJsonReader b(Reader reader) {
        return new GsonReader(reader);
    }
}
