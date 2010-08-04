package com.leanvienna.studentlife.client.composites;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SettingsForm extends Composite {

	TextBox countryTextBox = new TextBox();

	Button countryButton = new Button();

	ListBox countryList = new ListBox();

	@UiConstructor
	public SettingsForm(String buttonText, boolean withList) {
		VerticalPanel panel = new VerticalPanel();
		panel.add(countryTextBox);
		this.countryButton.setText(buttonText);
		panel.add(countryButton);
		if (withList) {
			countryList.setVisibleItemCount(5);
			panel.add(countryList);
		}
		initWidget(panel);
	}

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return this.countryButton.addClickHandler(handler);
	}

	public void clearList() {
		this.countryList.clear();
	}

	public void addListItem(String item, String value) {
		this.countryList.addItem(item, value);
	}
	
	public String getText(){
		return this.countryTextBox.getText();
	}
	
	public String getSelectedElement(){
		String value = countryList.getValue(countryList.getSelectedIndex());
		return value;
	}
	
	public HandlerRegistration addChangeHandler(ChangeHandler handler){
		return this.countryList.addChangeHandler(handler);
	}
}
