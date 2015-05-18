package org.corporateforce.server.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.corporateforce.server.model.Offices;
import org.corporateforce.server.session.OfficesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class OfficesController extends PaginationController implements Serializable {
	private static final long serialVersionUID = 1L;

	// session beans

	@Autowired
	private OfficesBean officesBean;
	
	// constants

	private final String OFFICES_UPSERT_ERROR = "error_upsert";
	private final String OFFICES_ERROR_EMPTY_FIELDS = "error_empty_fields";

	// page variables

	private String errorMessage = null;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		//this.errorMessage = errorMessage;
	}

	private Offices editOffice = null;

	public Offices getEditOffice() {
		return editOffice;
	}

	public void setEditOffice(Offices editOffice) {
		this.editOffice = editOffice;	
	}

	private List<OfficesWrapper> officesList = null;

	public List<OfficesWrapper> getOfficesList() {
		if (officesList == null) refreshController();
		return officesList;
	}


	// controller methods

	public void refreshController() {
		try {
			List<Offices> result = this.officesBean.getOfficesList();
			this.setRecordCount(result.size());
			officesList = new ArrayList<OfficesWrapper>();
			for (int i=0; i<result.size(); i++) {
				officesList.add(new OfficesWrapper(i, result.get(i)));
			}
		} catch (Exception e) {
			this.setRecordCount(0);
			officesList = null;
			System.out.println(e.getMessage());
		} finally {
			resetController();
		}
	}
	
	public void resetController() {
		this.editOffice = null;
		this.errorMessage = null;
	}
	
	public void createOffice() {
		editOffice = new Offices();
	}
	
	public void deleteSelectedOffices() {
		for (OfficesWrapper u : officesList) {
			if (u.selected) {
				this.officesBean.remove(u.instance);
			}
		}
		this.refreshController();
	}
	
	public void saveEditOffice() throws Exception {
		this.errorMessage = null;
		if (this.editOffice.getName()==null || this.editOffice.getName().trim().equals("")) {
			this.errorMessage = OFFICES_ERROR_EMPTY_FIELDS;
			return;
		}
		if ((this.editOffice.getId() == null && !this.officesBean.create(this.editOffice)) 
			|| (this.editOffice.getId() != null && !this.officesBean.update(this.editOffice))) {
			this.errorMessage = OFFICES_UPSERT_ERROR;
			return;
		}
		refreshController();		
	}

	// wrapper

	public class OfficesWrapper {
		private Offices instance;
		private Integer listIndex;
		private Boolean selected;

		public OfficesWrapper(Integer number, Offices office) {
			this.instance = office;
			this.listIndex = number;
			this.selected = false;
		}
		
		public Offices getInstance() {
			return instance;
		}

		public void setInstance(Offices instance) {
			this.instance = instance;
		}

		public Integer getListIndex() {
			return listIndex;
		}

		public Integer getNumber() {
			return listIndex + 1;
		}

		public Boolean getSelected() {
			return selected;
		}

		public void setSelected(Boolean selected) {
			this.selected = selected;
		}

	}
}
