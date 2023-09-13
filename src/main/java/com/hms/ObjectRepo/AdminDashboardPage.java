package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {

	@FindBy(xpath = "//h2[text()='Manage Users']/following-sibling::p/descendant::a")
	private WebElement TotalUsersLink;

	@FindBy(xpath = "//h2[text()='Manage Doctors']/following-sibling::p/descendant::a")
	private WebElement TotalDoctorsLink;

	@FindBy(xpath = "//h2[text()=' Appointments']/following-sibling::p/descendant::a")
	private WebElement TotalAppointmentsLink;

	@FindBy(xpath = "//h2[text()='Manage Patients']/following-sibling::p/descendant::a")
	private WebElement TotalPatientsLink;

	@FindBy(xpath = "//h2[text()=' New Queries']/following-sibling::p/descendant::a[contains(text(),'Total New Queries')]")
	private WebElement TotalNewQueriesLink;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement ProfileIcon;

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	private WebElement ChangePassword;

	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement LogOut;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']")
	private WebElement DoctorsLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']")
	private WebElement DashboardLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Users ']")
	private WebElement UsersLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Patients ']")
	private WebElement PatientsLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Appointment History ']]")
	private WebElement AppointmentHistoryLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Conatctus Queries ']")
	private WebElement ConatctusQueries;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctor Session Logs ']")
	private WebElement DoctorSessionLogsLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' User Session Logs ']")
	private WebElement UserSessionLogsLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Reports ']")
	private WebElement ReportsLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Patient Search ']")
	private WebElement PatientSearchLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctor Specialization ']")
	private WebElement DoctorSpecializationLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Manage Doctors ']")
	private WebElement ManageDoctorsLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Add Doctor']")
	private WebElement AddDoctorLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Manage Users ']")
	private WebElement ManageUsersLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Manage Patients ']")
	private WebElement ManagePatientsLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Unread Query ']")
	private WebElement UnreadQueryLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()=' Read Query ']")
	private WebElement ReadQueryLink;

	@FindBy(xpath = "//ul[@class='main-navigation-menu']/descendant::span[text()='B/w dates reports ']")
	private WebElement BetweenwdatesreportsLink;

	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTotalUsersLink() {
		return TotalUsersLink;
	}

	public WebElement getTotalDoctorsLink() {
		return TotalDoctorsLink;
	}

	public WebElement getTotalAppointmentsLink() {
		return TotalAppointmentsLink;
	}

	public WebElement getTotalPatientsLink() {
		return TotalPatientsLink;
	}

	public WebElement getTotalNewQueriesLink() {
		return TotalNewQueriesLink;
	}

	public WebElement getProfileIcon() {
		return ProfileIcon;
	}

	public WebElement getChangePassword() {
		return ChangePassword;
	}

	public WebElement getLogOut() {
		return LogOut;
	}

	public WebElement getDoctorsLink() {
		return DoctorsLink;
	}

	public WebElement getDashboardLink() {
		return DashboardLink;
	}

	public WebElement getUsersLink() {
		return UsersLink;
	}

	public WebElement getPatientsLink() {
		return PatientsLink;
	}

	public WebElement getAppointmentHistoryLink() {
		return AppointmentHistoryLink;
	}

	public WebElement getConatctusQueries() {
		return ConatctusQueries;
	}

	public WebElement getDoctorSessionLogsLink() {
		return DoctorSessionLogsLink;
	}

	public WebElement getUserSessionLogsLink() {
		return UserSessionLogsLink;
	}

	public WebElement getReportsLink() {
		return ReportsLink;
	}

	public WebElement getPatientSearchLink() {
		return PatientSearchLink;
	}

	public WebElement getDoctorSpecializationLink() {
		return DoctorSpecializationLink;
	}

	public WebElement getManageDoctorsLink() {
		return ManageDoctorsLink;
	}

	public WebElement getAddDoctorLink() {
		return AddDoctorLink;
	}

	public WebElement getManageUsersLink() {
		return ManageUsersLink;
	}

	public WebElement getManagePatientsLink() {
		return ManagePatientsLink;
	}

	public WebElement getUnreadQueryLink() {
		return UnreadQueryLink;
	}

	public WebElement getReadQueryLink() {
		return ReadQueryLink;
	}

	public WebElement getBetweenwdatesreportsLink() {
		return BetweenwdatesreportsLink;
	}

}
