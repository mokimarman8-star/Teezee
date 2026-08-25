package k00;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.k;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class b implements k {
    private static final MediaType c = MediaType.get("application/json; charset=UTF-8");
    private final Gson a;
    private final TypeAdapter b;

    b(Gson gson, TypeAdapter typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    @Override // retrofit2.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(Object obj) {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.a.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), StandardCharsets.UTF_8));
        this.b.write(newJsonWriter, obj);
        newJsonWriter.close();
        return RequestBody.create(c, buffer.readByteString());
    }
}
