package com.leanvienna.studentlife.client.composites;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class CalendarComposite extends Widget {

	interface MyUiBinder extends UiBinder<UListElement, CalendarComposite> {}
	  private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	  @UiField UListElement uL;

	  public CalendarComposite(){
	    // createAndBindUi initializes this.nameSpan
	    setElement(uiBinder.createAndBindUi(this));
	  }
	  
	  public void addElement(){
		  
	  }
}
