package com.leanvienna.studentlife.client.composites;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.leanvienna.studentlife.client.interfaces.RetrieveEntitiesService;
import com.leanvienna.studentlife.client.interfaces.RetrieveEntitiesServiceAsync;
import com.leanvienna.studentlife.client.interfaces.StoreEntitiesService;
import com.leanvienna.studentlife.client.interfaces.StoreEntitiesServiceAsync;
import com.leanvienna.studentlife.domain.City;
import com.leanvienna.studentlife.domain.Country;
import com.leanvienna.studentlife.domain.Province;
import com.leanvienna.studentlife.domain.SharedGetters;
import com.leanvienna.studentlife.domain.University;

public class Settings extends Composite {

	interface MyUiBinder extends UiBinder<Widget, Settings> {
	}

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	StoreEntitiesServiceAsync storeEntities = GWT
			.create(StoreEntitiesService.class);

	RetrieveEntitiesServiceAsync retrieveEntities = GWT
			.create(RetrieveEntitiesService.class);

	@UiField
	SettingsForm country;

	@UiField
	SettingsForm province;

	@UiField
	SettingsForm city;

	@UiField
	SettingsForm university;
	
	@UiField
	SettingsForm course;

	public Settings() {
		initWidget(uiBinder.createAndBindUi(this));
		this.reloadCountries();
	}
	
	@UiHandler("country")
	void handleCountryValueChange(ChangeEvent event){
		reloadProvinces();
		city.clearList();
		university.clearList();
	}

	@UiHandler("country")
	void handleCountryClick(ClickEvent event) {
		Country countryInstance = new Country();
		countryInstance.setName(this.country.getText());
		storeEntities.addCountry(countryInstance, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Country could not be stored");
			}

			@Override
			public void onSuccess(Void result) {
				reloadCountries();
			}
		});
	}

	private void reloadCountries() {
		retrieveEntities.getCountries(new AsyncCallback<List<Country>>() {
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(List<Country> result) {
				updateElement(country, new ArrayList<SharedGetters>(result));
			}
		});
	}
	
	@UiHandler("province")
	void handleProvinceValueChange(ChangeEvent event){
		reloadCities();
		university.clearList();
	}

	@UiHandler("province")
	void handleProvinceClick(ClickEvent event) {
		Province provinceInstance = new Province();
		provinceInstance.setName(this.province.getText());
		String selectedElement = this.country.getSelectedElement();
		storeEntities.addProvince(selectedElement,provinceInstance, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Province could not be stored");
			}

			@Override
			public void onSuccess(Void result) {
				reloadProvinces();
			}
		});
	}
	
	private void reloadProvinces() {
		retrieveEntities.getProvinces( country.getSelectedElement(), new AsyncCallback<List<Province>>() {
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(List<Province> result) {
				updateElement(province, new ArrayList<SharedGetters>(result));
			}
		});
	}
	
	@UiHandler("city")
	void handleCityValueChange(ChangeEvent event){
		reloadUniversities();
	}
	
	@UiHandler("city")
	void handleCityClick(ClickEvent event) {
		City cityInstance = new City();
		cityInstance.setName(this.city.getText());
		String selectedElement = this.province.getSelectedElement();
		storeEntities.addCity(selectedElement,cityInstance, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Province could not be stored");
			}

			@Override
			public void onSuccess(Void result) {
				reloadCities();
			}
		});
	}
	
	private void reloadCities() {
		retrieveEntities.getCities( province.getSelectedElement(), new AsyncCallback<List<City>>() {
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(List<City> result) {
				updateElement(city, new ArrayList<SharedGetters>(result));
			}
		});
	}

	@UiHandler("university")
	void handleUniversityClick(ClickEvent event) {
		University universityInstance = new University();
		universityInstance.setName(this.university.getText());
		String selectedElement = this.city.getSelectedElement();
		storeEntities.addUniversity(selectedElement,universityInstance, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("University could not be stored");
			}

			@Override
			public void onSuccess(Void result) {
				reloadUniversities();
			}
		});
	}
	
	private void reloadUniversities() {
		retrieveEntities.getUniversities(city.getSelectedElement(), new AsyncCallback<List<University>>() {
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(List<University> result) {
				updateElement(university, new ArrayList<SharedGetters>(result));
			}
		});
	}
	
	void updateElement(SettingsForm toUpdate, List<SharedGetters> elements) {
		toUpdate.clearList();
		for (SharedGetters sharedGetters : elements) {
			toUpdate
					.addListItem(sharedGetters.getName(), sharedGetters.getId());
		}
	}
	
	@UiHandler("course")
	void handleCourseClick(ClickEvent event) {
		// TODO:
	}
	
	private void reloadCourses() {
		// TODO:
	}
	
	
}
