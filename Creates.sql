CREATE DATABASE IF NOT EXISTS `healthinformationsysystem`;
USE `healthinformationsysystem`;

CREATE TABLE IF NOT EXISTS Guardian(
	GuardianNo CHAR(100) NOT NULL,
	GivenName CHAR(100),
	FamilyName CHAR(100),
	Phone CHAR(100),
	Address CHAR(100),
	City CHAR(100),
	State CHAR(100),
	Zip CHAR(100),
	PRIMARY KEY (GuardianNo) 
);

CREATE TABLE IF NOT EXISTS InsuranceCompany (
	PayerID CHAR(100) NOT NULL,
	Name CHAR(100),
	Purpose CHAR(100),
	PolicyType CHAR(100),
	PRIMARY KEY (PayerID)
);

CREATE TABLE IF NOT EXISTS LabTestReport(
	LabTestResultID CHAR(100) NOT NULL,
	PatientVisitID CHAR(100) NOT NULL,
	LabTestPerformedDate Date,
	LabTestType CHAR(100),
	ReferenceRangeHigh CHAR(100),
	ReferenceRangeLow CHAR(100),
	TestResultValue CHAR(100),
	PRIMARY KEY (LabTestResultID),
	UNIQUE (LabTestResultID,PatientVisitID)
);

CREATE TABLE IF NOT EXISTS Patient(
	PatientID CHAR(100) NOT NULL,
	GivenName CHAR(100),
	FamilyName CHAR(100),
	Suffix CHAR(100),
	Gender CHAR(100),
	Birthtime Date,
	ProviderID CHAR(100) NOT NULL,
	Creation Date,
	PatientRole CHAR(100) NOT NULL,
	PayerID CHAR(100),
	PRIMARY KEY (PatientID),
	FOREIGN KEY (PayerID) REFERENCES InsuranceCompany(PayerID) ON DELETE NO ACTION,
	FOREIGN KEY (PatientRole) REFERENCES Guardian(GuardianNo) ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS Author(
	AuthorID CHAR(100) NOT NULL,
	AuthorTitle CHAR(100),
	AuthorFirstName CHAR(100),
	AuthorLastName CHAR(100),
	ParticipatingRole CHAR(100),
	PRIMARY KEY (AuthorID)
);


CREATE TABLE IF NOT EXISTS AuthorPatient(
	AuthorID CHAR(100) NOT NULL,
	PatientID CHAR(100) NOT NULL,
	PRIMARY KEY (AuthorID,PatientID),
	FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID) ON DELETE CASCADE,
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS FamilyHistory(
	Relationship CHAR(100),
	Age CHAR(100),
	PatientID CHAR(100) NOT NULL,
	FamilyMemberID CHAR(100) NOT NULL,
	Diagnosis CHAR(100),
	PRIMARY KEY (FamilyMemberID, PatientID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS Allergy(
	AllergyID CHAR(100) NOT NULL,
	substance_name CHAR(100),
	reaction CHAR(100),
	status CHAR(100),
	PatientID CHAR(100) NOT NULL,
	PRIMARY KEY (PatientID, AllergyID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Patient_Test(
	PatientID CHAR(100) NOT NULL,
	LabTestResultID CHAR(100) NOT NULL,
	PRIMARY KEY (PatientID,LabTestResultID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE,
	FOREIGN KEY (LabTestResultID) REFERENCES LabTestReport(LabTestResultID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Plan(
	PlanID CHAR(100) NOT NULL,
	Activity CHAR(100) NOT NULL,
	PatientID CHAR(100) NOT NULL,
	ActivityDate Date,
	PRIMARY KEY (PlanID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE
);