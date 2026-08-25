package k00;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import okhttp3.ResponseBody;
import retrofit2.k;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class c implements k {
    private final Gson a;
    private final TypeAdapter b;

    c(Gson gson, TypeAdapter typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    @Override // retrofit2.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object convert(ResponseBody responseBody) {
        JsonReader newJsonReader = this.a.newJsonReader(responseBody.charStream());
        try {
            Object read2 = this.b.read2(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read2;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
