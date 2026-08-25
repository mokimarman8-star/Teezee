package com.alibaba.fastjson;

import a5.h;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class JSONArray extends a implements List<Object>, Cloneable, RandomAccess, Serializable {
    private static final long serialVersionUID = 1;
    protected transient Type componentType;
    private final List<Object> list;
    protected transient Object relatedArray;

    public JSONArray() {
        this.list = new ArrayList();
    }

    public JSONArray(int i) {
        this.list = new ArrayList(i);
    }

    public JSONArray(List<Object> list) {
        if (list == null) {
            throw new IllegalArgumentException("list is null.");
        }
        this.list = list;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        JSONObject.a.d();
        if (JSONObject.a.a != null && !JSONObject.a.b) {
            try {
                new JSONObject.a(objectInputStream).defaultReadObject();
                return;
            } catch (NotActiveException unused) {
            }
        }
        objectInputStream.defaultReadObject();
        for (Object obj : this.list) {
            if (obj != null) {
                String name = obj.getClass().getName();
                if (TypeUtils.R(name) == null) {
                    h.z.i(name, (Class) null);
                }
            }
        }
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        this.list.add(i, obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends Object> collection) {
        return this.list.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<?> collection) {
        return this.list.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
    }

    public Object clone() {
        return new JSONArray(new ArrayList(this.list));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof JSONArray ? this.list.equals(((JSONArray) obj).list) : this.list.equals(obj);
    }

    public JSONArray fluentAdd(int i, Object obj) {
        this.list.add(i, obj);
        return this;
    }

    public JSONArray fluentAdd(Object obj) {
        this.list.add(obj);
        return this;
    }

    public JSONArray fluentAddAll(int i, Collection<?> collection) {
        this.list.addAll(i, collection);
        return this;
    }

    public JSONArray fluentAddAll(Collection<?> collection) {
        this.list.addAll(collection);
        return this;
    }

    public JSONArray fluentClear() {
        this.list.clear();
        return this;
    }

    public JSONArray fluentRemove(int i) {
        this.list.remove(i);
        return this;
    }

    public JSONArray fluentRemove(Object obj) {
        this.list.remove(obj);
        return this;
    }

    public JSONArray fluentRemoveAll(Collection<?> collection) {
        this.list.removeAll(collection);
        return this;
    }

    public JSONArray fluentRetainAll(Collection<?> collection) {
        this.list.retainAll(collection);
        return this;
    }

    public JSONArray fluentSet(int i, Object obj) {
        set(i, obj);
        return this;
    }

    @Override // java.util.List
    public Object get(int i) {
        return this.list.get(i);
    }

    public BigDecimal getBigDecimal(int i) {
        return TypeUtils.i(get(i));
    }

    public BigInteger getBigInteger(int i) {
        return TypeUtils.j(get(i));
    }

    public Boolean getBoolean(int i) {
        Object obj = get(i);
        if (obj == null) {
            return null;
        }
        return TypeUtils.k(obj);
    }

    public boolean getBooleanValue(int i) {
        Object obj = get(i);
        if (obj == null) {
            return false;
        }
        return TypeUtils.k(obj).booleanValue();
    }

    public Byte getByte(int i) {
        return TypeUtils.l(get(i));
    }

    public byte getByteValue(int i) {
        Byte l = TypeUtils.l(get(i));
        if (l == null) {
            return (byte) 0;
        }
        return l.byteValue();
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public Date getDate(int i) {
        return TypeUtils.o(get(i));
    }

    public Double getDouble(int i) {
        return TypeUtils.q(get(i));
    }

    public double getDoubleValue(int i) {
        Double q = TypeUtils.q(get(i));
        if (q == null) {
            return 0.0d;
        }
        return q.doubleValue();
    }

    public Float getFloat(int i) {
        return TypeUtils.s(get(i));
    }

    public float getFloatValue(int i) {
        Float s = TypeUtils.s(get(i));
        if (s == null) {
            return 0.0f;
        }
        return s.floatValue();
    }

    public int getIntValue(int i) {
        Integer t = TypeUtils.t(get(i));
        if (t == null) {
            return 0;
        }
        return t.intValue();
    }

    public Integer getInteger(int i) {
        return TypeUtils.t(get(i));
    }

    public JSONArray getJSONArray(int i) {
        Object obj = this.list.get(i);
        return obj instanceof JSONArray ? (JSONArray) obj : obj instanceof List ? new JSONArray((List<Object>) obj) : (JSONArray) a.toJSON(obj);
    }

    public JSONObject getJSONObject(int i) {
        Object obj = this.list.get(i);
        return obj instanceof JSONObject ? (JSONObject) obj : obj instanceof Map ? new JSONObject((Map<String, Object>) obj) : (JSONObject) a.toJSON(obj);
    }

    public Long getLong(int i) {
        return TypeUtils.w(get(i));
    }

    public long getLongValue(int i) {
        Long w = TypeUtils.w(get(i));
        if (w == null) {
            return 0L;
        }
        return w.longValue();
    }

    public <T> T getObject(int i, Class<T> cls) {
        return (T) TypeUtils.u(this.list.get(i), cls);
    }

    public <T> T getObject(int i, Type type) {
        Object obj = this.list.get(i);
        return type instanceof Class ? (T) TypeUtils.u(obj, (Class) type) : (T) a.parseObject(a.toJSONString(obj), type, new Feature[0]);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public Short getShort(int i) {
        return TypeUtils.x(get(i));
    }

    public short getShortValue(int i) {
        Short x = TypeUtils.x(get(i));
        if (x == null) {
            return (short) 0;
        }
        return x.shortValue();
    }

    public Object getSqlDate(int i) {
        return TypeUtils.y(get(i));
    }

    public String getString(int i) {
        return TypeUtils.A(get(i));
    }

    public Object getTimestamp(int i) {
        return TypeUtils.B(get(i));
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i) {
        return this.list.listIterator(i);
    }

    @Override // java.util.List
    public Object remove(int i) {
        return this.list.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        if (i == -1) {
            this.list.add(obj);
            return null;
        }
        if (this.list.size() > i) {
            return this.list.set(i, obj);
        }
        for (int size = this.list.size(); size < i; size++) {
            this.list.add(null);
        }
        this.list.add(obj);
        return null;
    }

    public void setComponentType(Type type) {
        this.componentType = type;
    }

    public void setRelatedArray(Object obj) {
        this.relatedArray = obj;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.list.size();
    }

    @Override // java.util.List
    public List<Object> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.list.toArray(tArr);
    }

    public <T> List<T> toJavaList(Class<T> cls) {
        ArrayList arrayList = new ArrayList(size());
        h t = h.t();
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            arrayList.add(TypeUtils.f(it.next(), cls, t));
        }
        return arrayList;
    }
}
