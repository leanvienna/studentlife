package com.leanvienna.studentlife.server;

import javax.persistence.EntityManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.leanvienna.studentlife.client.interfaces.StoreEntitiesService;

public class AbstractEntitiesService extends RemoteServiceServlet {

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