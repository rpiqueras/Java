package spring.example.forms.models;

public class PaginationCriteria {

	private Integer number;
	private Boolean isAscending;
	
	public PaginationCriteria() {
		super();
	}

	public PaginationCriteria(Integer number, Boolean isAscending) {
		super();
		this.number = number;
		this.isAscending = isAscending;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Boolean getIsAscending() {
		return isAscending;
	}

	public void setIsAscending(Boolean isAscending) {
		this.isAscending = isAscending;
	}
}
