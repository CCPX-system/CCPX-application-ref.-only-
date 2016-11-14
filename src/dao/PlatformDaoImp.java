package dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.Offer;
import model.Request;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PlatformDaoImp implements PlatformDao 
{
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private Session session;

	private Session getSession() {

		if (session == null) {
			session = sessionFactory.openSession();
		} else {
			session = sessionFactory.getCurrentSession();
		}
		return session;
	}


	@Override
	public List<Offer> searchExcahnge(Integer sellerFrom, Integer sellerTo,
			Integer pointsFrom, Integer pointsToMin) {
		List<Offer> list = new ArrayList<Offer>(); 
		String sql = "from Offer where pointsFrom>= :pointsToMin and pointsToMin<= :pointsFrom "
				+ "and sellerFrom =:sellerTo and sellerTo =:sellerFrom and status= :status";
		Query query = getSession().createQuery(sql);
		query.setInteger("sellerFrom", sellerFrom);
		query.setInteger("sellerTo", sellerTo);
		query.setInteger("pointsFrom", pointsFrom);
		query.setInteger("pointsToMin", pointsToMin);
		query.setInteger("status", 1);
		list = query.list();
		return list;
		
	}
	
	@Override
	public List<Request> showLatestTransaction(Integer sellerFrom, Integer sellerTo) {
		// TODO Auto-generated method stub
		String sql = "from request where " + "(SELLER_ID_FROM =? and SELLER_ID_TO =? "
				+ "and status = 'accepted')" + " or (SELLER_ID_TO =? and SELLER_ID_FROM =?"
				+ "and status = 'accepted')" + " order by UPDATE_TIME desc limit 5";
		Query query = getSession().createQuery(sql);
		query.setInteger(0, sellerFrom);
		query.setInteger(1, sellerTo);
		query.setInteger(2, sellerFrom);
		query.setInteger(3, sellerTo);
		List<Request> requests = query.list();
		return requests;
	}

	@Override
	public List<Offer> showRecommendationList(Integer sellerFrom, Integer sellerTo,
			Integer pointsFrom, Integer pointsToMin) {
			List<Offer> list = new ArrayList<Offer>(); 
			String hql = "from Offer where pointsFrom>= :pointsToMin and pointsToMin<= :pointsFrom "
					+ "and sellerFrom =:sellerTo and sellerTo =:sellerFrom and status= :2";
			Query query = getSession().createQuery(hql);
			query.setInteger("sellerFrom", sellerFrom);
			query.setInteger("sellerTo", sellerTo);
			query.setInteger("pointsFrom", pointsFrom);
			query.setInteger("pointsToMin", pointsToMin);
			Offer offer = (Offer) query.uniqueResult();
			list.add(offer);
			return list;
		}
		

	
}
