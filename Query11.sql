SELECT COUNT(DISTINCT students.snum) AS Count_Females_In_SoftwareEngineering FROM students
JOIN (
	SELECT major.snum FROM major WHERE major.name = "Software Engineering"
    UNION SELECT minor.snum FROM minor WHERE minor.name = "Software Engineering"
    )AS totalstudents ON students.snum = totalstudents.snum
    WHERE students.gender = "F"