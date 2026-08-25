package e5;

import c5.h1;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bumptech.glide.load.Key;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class b implements MessageBodyReader, MessageBodyWriter {
    public static final Class[] f = {InputStream.class, Reader.class};
    public static final Class[] g = {InputStream.class, OutputStream.class, Writer.class, StreamingOutput.class, Response.class};
    protected Charset a = Charset.forName(Key.STRING_CHARSET_NAME);
    protected SerializerFeature[] b = new SerializerFeature[0];
    protected h1[] c = new h1[0];
    private d5.a d = new d5.a();
    private Class[] e = null;
}
