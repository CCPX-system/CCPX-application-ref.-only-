package dao;

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
	public Offer searchExcahnge(Integer sellerFrom, Integer sellerTo,
			Integer pointsFrom, Integer pointsToMin) {
		String sql = "";
		Query query = getSession().createQuery(sql);
		query.setInteger("e", sellerFrom);
		query.setInteger("d", sellerTo);
		query.setInteger("", pointsFrom);
		query.setInteger("", pointsToMin);
		query.setInteger("status", 1);
		Offer offer = (Offer) query.list();
		return offer;
		
	}

	@Override
	public Offer showRecommendationList(String sellerFrom, String sellerTo,
			String pointsFrom, String pointsToMin) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Request showLatestTransaction(Integer sellerFrom, Integer sellerto) {
		// TODO Auto-generated method stub
		return null;
	}
}
