package org.zyq.huobi.other.bean;

import org.zyq.huobi.model.MyEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component
public class Dao {
    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;
    @Resource
    DataSource dataSource;

    @SuppressWarnings("unchecked")
    public <T> List<T> find(String hql, Map<String, Object> param, MyEntity<T> entity) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        for (Map.Entry<String, Object> map : param.entrySet()) {
            query.setParameter(map.getKey(), map.getValue());
        }
        List<T> list = query.list();
        ;
        session.close();
        return list;
    }

    public <T> T find(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        QueryRunner qr = new QueryRunner(dataSource);
        qr.query(sql, rsh, params);
        return null;
    }

    public void save(Object obj) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }
}
