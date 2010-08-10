package com.leanvienna.studentlife.server;

import javax.persistence.EntityManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AbstractEntitiesService extends RemoteServiceServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected EntityManager entityManager;

	public AbstractEntitiesService() {
		super();
	}

	protected void initEntityManager() {
		System.out.println("Init");
		this.entityManager = EMF.createEntityManager();
	}

	protected void closeEntityManager() {
		System.out.println("Close");
		this.entityManager.close();
		this.entityManager = null;
	}

}