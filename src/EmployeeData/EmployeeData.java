package EmployeeData;

public class EmployeeData {

	private int idno;
	private String name;
	private String surname;
	private int age;
	private String dob;
	private String gender;
	private String contact;
	private int yoj;
	private String department;
	private float salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getYoj() {
		return yoj;
	}

	public void setYoj(int yoj) {
		this.yoj = yoj;
	}

	public int getIdno() {
		return idno;
	}

	public void setIdno(int idno) {
		this.idno = idno;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public EmployeeData(int idno, String name, String surname, int age, String dob, String gender, String contact,
			int yoj, String department, float salary) {
		super();
		this.idno = idno;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.dob = dob;
		this.gender = gender;
		this.contact = contact;
		this.yoj = yoj;
		this.department = department;
		this.salary = salary;
	}

	public EmployeeData(String name, String surname, int age, String dob, String gender, String contact, int yoj,
			String department, float salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.dob = dob;
		this.gender = gender;
		this.contact = contact;
		this.yoj = yoj;
		this.department = department;
		this.salary = salary;
	}

	public EmployeeData() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeData [ idno=" + idno + " name=" + name + ", surname=" + surname + ", age=" + age + ", dob="
				+ dob + ", gender=" + gender + ", contact=" + contact + ", yoj=" + yoj + ", department=" + department
				+ ", salary=" + salary + "]";
	}

}
