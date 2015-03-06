CREATE TABLE Patient(
	PatientID INTEGER NOT NULL,
	GivenName CHAR(30),
	FamilyName CHAR(30),
	Suffix CHAR(10),
	Gender CHAR(10),
	Birthtime DATE,
	ProviderID INTEGER NOT NULL,
	Creation DATE,
	PatientRole INTEGER NOT NULL,
	PRIMARY KEY (PatientID),
	FOREIGN KEY (ProviderID) REFERENCES InsuranceCompany(PayerID) ON DELETE NO ACTION,
	FOREIGN KEY (PatientRole) REFERENCES Guardian_of(GuardianNo) ON DELETE NO ACTION
);

CREATE TABLE Guardian_of(
	GuardianNo INTEGER NOT NULL,
	GivenName CHAR(30),
	FamilyName CHAR(30),
	Phone CHAR(10),
	Address CHAR(30),
	City CHAR(30),
	State CHAR(30),
	Zip CHAR(6),
	PRIMARY KEY (GuardianNo) 
);

CREATE TABLE Author(
	AuthorID INTEGER NOT NULL,
	AuthorTitle CHAR(10),
	AuthorFirstName CHAR(30),
	AuthorLastName CHAR(30),
	PatientID INTEGER NOT NULL,
	ParticipatingRole CHAR(30),
	PRIMARY KEY (AuthorID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE
);

CREATE TABLE InsuranceCompany (
	PayerID INTEGER NOT NULL,
	Name CHAR(30),
	Purpose CHAR(100),
	PolicyType CHAR(30),
	PRIMARY KEY (PayerID)
);

CREATE TABLE FamilyHistory(
	Relationship CHAR(30),
	Age INTEGER,
	PatientID INTEGER NOT NULL,
	FamilyMemberID INTEGER NOT NULL,
	Diagnosis CHAR(100),
	PRIMARY KEY (FamilyMemberID, PatientID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE NO ACTION,
	FOREIGN KEY (FamilyMemberID) REFERENCES Patient(PatientID) ON DELETE NO ACTION
);

CREATE TABLE Patient_Allergy(
	AllergyID CHAR(30) NOT NULL,
	reaction CHAR(30),
	status CHAR(30),
	PatientID INTEGER NOT NULL,
	PRIMARY KEY (PatientID, AllergyID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE 
	FOREIGN KEY (AllergyID) REFERENCES Allergy(AllergyID) ON DELETE CASCADE
);

CREATE TABLE Allergy(
	AllergyID INTEGER NOT NULL,
	substance_name CHAR(30) NOT NULL,
	PRIMARY KEY (AllergyID)
);

CREATE TABLE Patient_Test(
	PatientID INTEGER NOT NULL,
	LabTestResultID INTEGER NOT NULL,
	PatientVisitID INTEGER NOT NULL,
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
	PRIMARY KEY (LabTestResultID, PatientVisitID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE
);

CREATE TABLE Plan(
	Activity CHAR(30) NOT NULL,
	PatientID INTEGER NOT NULL,
	ActivityDate DATE,
	PRIMARY KEY (Activity, PatientID),
	FOREIGN KEY (PatientID) REFERENCES Patient(PatientID) ON DELETE CASCADE
);