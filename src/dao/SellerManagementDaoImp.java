package dao;

import javax.annotation.Resource;

import model.seller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("sellerManagementDaoImp")
public class SellerManagementDaoImp implements SellerManagementDao {
	// 声明sessionFactory

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session session;

	// 获取当前session的方法
	private Session getSession() {

		if (session == null) {
			session = sessionFactory.openSession();
		} else {
			session = sessionFactory.getCurrentSession();
		}
		return session;
	}

	@Override
	public seller checkSeller(String username, String password) {
		String hql = "from seller where Seller_Username= :username and Seller_Password= :password";
		Query query = getSession().createQuery(hql);
		query.setString("username", username);
		query.setString("password", password);
		seller Seller = (seller) query.uniqueResult();
		return Seller;
	}

}
