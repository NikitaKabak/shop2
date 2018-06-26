package kabak.DAO;

import java.io.Serializable;

public interface HbmDao<T, PK> {

    public void create(T t) throws Exception;

    public Serializable save(T t) throws Exception;

    public void update(T t) throws Exception;

    public void saveOrUpdate(T t) throws Exception;

    public T read(Class<T> clazz, PK id) throws Exception;

    public void delete(T t) throws Exception;

    public T get(PK id) throws Exception;
}
