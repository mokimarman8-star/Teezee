package fg;

import com.alibaba.fastjson.serializer.SerializerFeature;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.k;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b implements k {
    private static final MediaType a = MediaType.parse("application/json; charset=UTF-8");

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(Object obj) {
        return RequestBody.create(a, com.alibaba.fastjson.a.toJSONBytes(obj, new SerializerFeature[0]));
    }
}
