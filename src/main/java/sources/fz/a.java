package fz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.w;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a {
    public static final void a(Object obj) {
        try {
            if (obj instanceof w) {
                ((w) obj).B();
            }
            Method method = obj.getClass().getMethod("execute", null);
            if (method != null) {
                method.invoke(obj, null);
                if (obj instanceof w) {
                    ((w) obj).J(null);
                    return;
                }
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No public ");
            stringBuffer.append("execute");
            stringBuffer.append("() in ");
            stringBuffer.append(obj.getClass());
            throw new BuildException(stringBuffer.toString());
        } catch (IllegalAccessException e) {
            throw new BuildException(e);
        } catch (NoSuchMethodException e2) {
            throw new BuildException(e2);
        } catch (InvocationTargetException e3) {
            Throwable targetException = e3.getTargetException();
            if (!(targetException instanceof BuildException)) {
                throw new BuildException(targetException);
            }
            throw ((BuildException) targetException);
        }
    }
}
