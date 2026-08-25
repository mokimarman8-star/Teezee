package y3;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface e extends AutoCloseable {
    boolean C0();

    void a(int i5, double d5);

    void c(int i5, long j5);

    @Override // java.lang.AutoCloseable
    void close();

    void g(int i5);

    boolean getBoolean(int i5);

    int getColumnCount();

    String getColumnName(int i5);

    double getDouble(int i5);

    long getLong(int i5);

    void i(int i5, String str);

    boolean isNull(int i5);

    String q0(int i5);

    void reset();
}
