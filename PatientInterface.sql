SELECT *
FROM Patient P
WHERE P.PatientID = PatientID

UPDATE Patient P
SET 	P.GivenName = GivenName,
    	P.FamilyName = FamilyName,
    	P.Suffix = Suffix,
    	P.Gender = Gender,
    	P.Birthtime = Birthtime,
    	P.ProviderID = ProviderID,
    	P.Creation = Creation,
    	PatientRole = PatientRole,
WHERE P.PatientID = PatientID

UPDATE Guardian_of G
SET G.GivenName = GivenName,
	G.FamilyName = FamilyName,
	G.Phone = Phone,
	G.Address = Address,
	G.City = City,
	G.State = State,
	G.Zip = Zip,
WHERE G.GuardianNo = GuardianNo

SELECT *
FROM Plan P
WHERE P.PatientID = PatientID

SELECT substance_name
FROM Allergy A, Patient_Allergy P
WHERE P.PatientID = PatientID AND A.AllergyID = P.AllergyID

SELECT COUNT(P.PatientID)
FROM Allergy A, Patient_Allergy P
WHERE A.substance_name = substance_name AND A.AllergyID = P.AllergyID

SELECT P.GivenName, P.FamilyName
FROM Patient P
WHERE 1 < (SELECT COUNT(*)
           FROM Patient_Allergy PA
           WHERE PA.PatientID = P.PatientID)

SELECT P.GivenName, P.FamilyName
FROM Plan Pl, Patient P
WHERE Pl.ActivityDate = CURDATE() AND P.PatientID = Pl.PatientID

SELECT A.AuthorFirstName, A.AuthorLastName
FROM Author AS A
WHERE 1 < (SELECT COUNT(*)
           FROM Author_Patient AP
           WHERE AP.AuthorID = A.AuthorID)

