package cn.ledaikuan.ldkbatch.db.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.ledaikuan.ldkbatch.db.common.BaseDaoHibernate5;
import cn.ledaikuan.ldkbatch.db.entity.Contact;

//注入
@Repository
public class ContactDaoImpl extends BaseDaoHibernate5<Contact> {

    @SuppressWarnings("deprecation")
    public long findCountByCustomerId(String customerId){
        if(StringUtils.isEmpty(customerId))return -1;
        return (long)sessionFactory.getCurrentSession()
                .createQuery("select count(*) from Contact en where en.customerId = ?0")
                .setParameter(0, customerId)
                .uniqueResult();
    }
    
}
