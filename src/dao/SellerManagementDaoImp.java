package dao;

import java.util.List;

import javax.annotation.Resource;

import model.Seller;
import service.SellerManagementService;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;



@Repository("sellerManagementDaoImp")
public abstract class SellerManagementDaoImp<SellerRegister> implements SellerManagementDao {
	// 声明sessionFactory

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SellerManagementDaoImp.class);
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
	public Seller checkSeller(String username, String password) {
		String hql = "from seller where Seller_Username= :username and Seller_Password= :password";
		Query query = getSession().createQuery(hql);
		query.setString("username", username);
		query.setString("password", password);
		Seller Seller = (Seller) query.uniqueResult();
		return Seller;
	}

	@Override
	public boolean updateSellerinfo(Seller seller) {

		String hql = "update Seller set  Seller_Name=:Seller_Name,Seller_Address=:Seller_Address,Seller_Telephone=:Seller_Telephone,"
				+ "Seller_Email=:Seller_Email ,Seller_Username=:Seller_Username,Seller_Password=:Seller_Password ,IndustryType_id=:IndustryType_id ,Seller_Logo=:Seller_Logo ,Seller_Description=:Seller_Description where Seller_id=:Seller_id";
		Query query = getSession().createQuery(hql);
		query.setInteger("Seller_id", seller.getSeller_id());
		query.setString("Seller_Name", seller.getSeller_Name());
		query.setString("Seller_Address", seller.getSeller_Address());
		query.setString("Seller_Telephone", seller.getSeller_Telephone());
		query.setString("Seller_Email", seller.getSeller_Email());
		query.setString("Seller_Username", seller.getSeller_Username());
		query.setString("Seller_Password", seller.getSeller_Password());
		query.setString("Seller_Status", seller.getSeller_Status());
		query.setString("IndustryType_id", seller.getIndustryType_id());
		query.setString("Seller_Logo", seller.getSeller_Logo());
		query.setString("Seller_Description", seller.getSeller_Description());
		int a = query.executeUpdate();
		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePassword(int Seller_id, String Seller_Password) {

		String hql = "update Seller set Seller_Password =:Seller_Password where Seller_id=:Seller_id";
		Query query = getSession().createQuery(hql);
		query.setInteger("seller", Seller_id);
		query.setString("password", Seller_Password);
		int a = query.executeUpdate();
		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateEmail(int Seller_id, String Seller_Email) {
		String hql = "update Seller set email =:email where sellerid=:sellerid";
		Query query = getSession().createQuery(hql);
		query.setInteger("seller", Seller_id);
		query.setString("email", Seller_Email);
		int a = query.executeUpdate();
		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePhone(int Seller_id, String Seller_Telephone) {
		String hql = "update Seller set phone =:phone where sellerid=:sellerid";
		Query query = getSession().createQuery(hql);
		query.setInteger("sellerid", Seller_id);
		query.setString("phone", Seller_Telephone);
		int a = query.executeUpdate();
		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean regist(Seller seller) {

		getSession().save(seller);

		return true;
	}

	@Override
	public boolean checkEmail(String Seller_Email) {
		long count = (long) getSession()
				.createQuery(
						"select count(email) from Seller where email =:Seller_Email")
				.setString("email", Seller_Email).uniqueResult();
		if (count == 0)
			return true;

		else
			return false;

	}

	@Override
	public boolean checkUsername(String username) {
		long count = (long) getSession()
				.createQuery(
						"select count(username) from User where username =:username")
				.setString("username", username).uniqueResult();
		if (count == 0)
			return true;

		else
			return false;
	}

	@Override
	public Seller getSellerById(int Seller_id) {
		Seller s=(Seller) getSession().createQuery("from Seller where sellerid=:seller ").setInteger("sellerid", Seller_id).uniqueResult();
		return s;
	}

}