package com.leanvienna.studentlife.client.composites;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Tabs extends Composite {

	interface MyUiBinder extends UiBinder<Widget, Tabs> {}
	  private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	  public Tabs(){
	    initWidget(uiBinder.createAndBindUi(this));
	  }
}
