CREATE DATABASE `healthmessagesexchange` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `messagequeue` (
  `control_id` int(11) DEFAULT NULL,
  `xmlmessage` varchar(20000) DEFAULT NULL,
  `last_accessed` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `healthmessagesexchange`.`messagequeue`
(`control_id`,
`xmlmessage`,
`last_accessed`)
VALUES
(
'12', 
'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n
<Msg id = c123>\n

<patient>\n
<patientId>12345</patientId>\n
<patientRole/>\n
<GivenName>Adam</GivenName>\n
<FamilyName>Smith</FamilyName>\n
<BirthTime>19541125</BirthTime>\n
<providerId>2.16.840</providerId>\n
<creationDate></creationDate>\n
</patient>\n

<Guardian>\n
<GuardianNo >45678</GuardianNo>\n
<Relationship>Grandfather</Relationship>\n
<GivenName>Ralph</GivenName>\n
<FamilyName>Finnes</FamilyName>\n
<phone>781-555-1212</phone>\n
<address>12, Finnegan st., </address>\n
<city>Boston</city>\n
<state>MA</state>\n
<zip>02318</zip>\n
</Guardian>\n

<Author>\n
<AuthorId>KP00017</AuthorId>\n
<AuthorTitle>Mr.</AuthorTitle>\n
<AuthorFirstName>Henry</AuthorFirstName>\n
<AuthorLastName>Seven</AuthorLastName>\n
<ParticipatingRole>InsuranceCompany</ParticipatingRole>\n
</Author>\n

<InsuranceCompany>\n
<PayerId>3456</PayerId>\n
<Name>Good Health Insurance</Name>\n
<PolicyHolder>Patient’s father</PolicyHolder>\n
<PolicyType>Extended healthcare </PolicyType>\n
<Purpose>Kidney failure</Purpose>\n
</InsuranceCompany>\n

<FamilyHistory>\n
<RelativeId>45565</RelativeId>\n
<Relationship>Grandmother</Relationship>\n
<age>67</age>\n
<Diagnosis>Diabetes</Diagnosis>\n
</FamilyHistory>\n

<Allergies>\n
<Id>4556</Id>\n
<Substance>Codeine</Codeine>\n
<Reaction>Hives</Reaction>\n
<Status>Active</Status>\n
</Allergies>\n

<LabTestReports>\n
<LabTestResultId> 200203</LabTestResultId>\n
<PatientVisitId> 2043</PatientVisitId>\n
<LabTestPerformedDate> 20141212</LabtestPerformedDate>\n
<LabTestType> HGB</Labtesttype>\n
<TestResultValue> </testResultValue>\n
<ReferenceRangeHigh>18 g/dl </ReferenceRangeHigh>\n
<ReferenceRangeLow>13 g/dl </ReferenceRangeLow>\n
</LabTestReports>\n

<Plan>\n
<Plan Id>456</PlanId>\n
<Activity>Colonoscopy</Activity>\n
<Date>April 21, 2015</Date>\n
</Plan>\n

</Msg>', 
'2015-02-19 15:12:14'
);

