CREATE TABLE Patient(
	PatientID INTEGER NOT NULL,
	GivenName CHAR(100),
	FamilyName CHAR(100),
	Suffix CHAR(100),
	Gender CHAR(100),
	Birthtime CHAR(100),
	ProviderID CHAR(100) NOT NULL,
	Creation CHAR(100),
	PatientRole CHAR(100) NOT NULL,
	PRIMARY KEY (PatientID),
	FOREIGN KEY (ProviderID) REFERENCES InsuranceCompany(PayerID) ON DELETE NO ACTION,
	FOREIGN KEY (PatientRole) REFERENCES Guardian_of(GuardianNo) ON DELETE NO ACTION
);

CREATE TABLE Guardian_of(
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

CREATE TABLE Author(
	AuthorID CHAR(100) NOT NULL,
	AuthorTitle CHAR(100),
	AuthorFirstName CHAR(100),
	AuthorLastName CHAR(100),
	ParticipatingRole CHAR(100),
	PRIMARY KEY (AuthorID)
);

CREATE TABLE Author_Patient (
    AuthorID CHAR(100),
    PatientID INTEGER,
    PRIMARY KEY (AuthorID, PatientID),
    FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID),
    FOREIGN KEY (PatientID) REFERENCES Patient(PatientID)
);

CREATE TABLE InsuranceCompany (
	PayerID CHAR(100) NOT NULL,
	Name CHAR(100),
	Purpose CHAR(100),
	PolicyType CHAR(100),
	PRIMARY KEY (PayerID)
);

CREATE TABLE FamilyHistory(
	Relationship CHAR(100),
	Age CHAR(100),
	PatientID INTEGER NOT NULL,
	FamilyMemberID INTEGER NOT NULL,
	Diagnosis CHAR(100),
	PRIMARY KEY (FamilyMemberID, PatientID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID)
);

CREATE TABLE Patient_Allergy(
	AllergyID INTEGER NOT NULL,
	reaction CHAR(100),
	status CHAR(100),
	PatientID INTEGER NOT NULL,
	PRIMARY KEY (PatientID, AllergyID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE,
	FOREIGN KEY (AllergyID) REFERENCES Allergy(AllergyID) ON DELETE CASCADE
);

CREATE TABLE Allergy(
	AllergyID INTEGER NOT NULL,
	substance_name CHAR(100) NOT NULL,
	PRIMARY KEY (AllergyID)
);

CREATE TABLE Patient_Test(
	PatientID CHAR(100) NOT NULL,
	LabTestResultID CHAR(100) NOT NULL,
	PatientVisitID CHAR(100) NOT NULL,
	PRIMARY KEY (PatientID,LabTestResultID,PatientVisitID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE,
	FOREIGN KEY (LabTestResultID,PatientVisitID) REFERENCES Lab_Test_Report(LabTestResultID,PatientVisitID) ON DELETE CASCADE
);

CREATE TABLE Lab_Test_Report(
	LabTestResultID INTEGER NOT NULL,
	PatientVisitID INTEGER NOT NULL,
	LabTestPerformedDate DATE,
	LabTestType CHAR(30),
	ReferenceRangeHigh CHAR(100),
	ReferenceRangeLow CHAR(100),
	TestResultValue CHAR(100),
	PRIMARY KEY (LabTestResultID, PatientVisitID)
);

CREATE TABLE Plan(
	Activity CHAR(30) NOT NULL,
	PatientID INTEGER NOT NULL,
	ActivityDate DATE,
	PRIMARY KEY (Activity, PatientID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE
);