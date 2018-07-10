package kabak.DAO;


import kabak.Entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Repository
public class HbmDaoImp<T, PK> implements HbmDao<T, PK> {


    protected Class<T> clas;
    protected SessionFactory sessionFactory;

    @Autowired
    public HbmDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    @Override
    public void create(T t) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.persist(t);
    }

    @Override
    public Serializable save(T t) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Serializable id;
        id = session.save(t);
        return id;
    }

    @Override
    public void update(T t)  throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.update(t);
     }

    @Override
    public void saveOrUpdate(T t)  throws Exception{
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(t);
    }

    @Override
    public void delete(T t)  throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.merge(t));
    }

    public void remove(T t)  throws Exception {

        Session session = sessionFactory.getCurrentSession();
     //   Transaction transaction = session.beginTransaction();
        session.remove(session.merge(t));
     //   transaction.commit();

    }

    @Override
    public T get( PK id)  throws Exception {

        Session session = sessionFactory.getCurrentSession();
      //  Transaction transaction = session.beginTransaction();
        T entity = (T) session.get(clas, (Serializable) id);
     //   transaction.commit();

        return entity;
    }

    public T getWhereName( String entityName, String param, Object entityparam)  throws Exception {

        Session session = sessionFactory.getCurrentSession();
     //   Transaction transaction = session.beginTransaction();
        T entity;

        String qeryStr = "From " + entityName + " WHERE " + param + " = :entityparam";
        Query query = session.createQuery(qeryStr).setParameter("entityparam", entityparam);

        try {
            entity = (T) query.getSingleResult();
        } catch (NoResultException ex) {
            entity = null;
        } finally {
     //       transaction.commit();

        }
        return entity;
    }

    public List<T> getListWhereName( String entityName, String param, Object entityparam)  throws Exception {

        Session session = sessionFactory.getCurrentSession();
    //    Transaction transaction = session.beginTransaction();
        List<T> entity;

        String qeryStr = "From " + entityName + " WHERE " + param + " = :entityparam";
        Query query = session.createQuery(qeryStr).setParameter("entityparam", entityparam);

        try {
            entity = query.getResultList();
        } catch (NoResultException ex) {
            entity = null;
        } finally {
     //       transaction.commit();

        }
        return entity;
    }


    public T getListWhereNameJoin(String entityName, String entityname2, String param, String param2, Object entityparam)   throws Exception {

        Session session = sessionFactory.getCurrentSession();
     //   Transaction transaction = session.beginTransaction();
        T entity;

        Query query = session.createQuery("From Order nn left outer join fetch nn.listBasket where nn = :entity", Order.class)
                .setParameter("entity", entityparam);

        try {
            entity = (T) query.getSingleResult();
        } catch (NoResultException ex) {
            entity = null;
        } finally {
     //       transaction.commit();
        }
        return entity;

    }

    @Override
    public T read(Class<T> clazz, PK id)  throws Exception {

        Session session = sessionFactory.getCurrentSession();
     //   Transaction transaction = session.beginTransaction();
        this.clas = clazz;
        T entity = session.find(clas, id);
     //   transaction.commit();

        return entity;

    }

    public List<T> getAll()  throws Exception {

        List<T> list = null;

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clas);
        Root<T> root = query.from(clas);
        query.select(root);


        list = session.createQuery(query).getResultList();

        return list;
    }

    public void setClas(Class<T> clas) {
        this.clas = clas;
    }

    public Class<T> getClas() {
        return clas;
    }
}



