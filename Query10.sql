SELECT courses.number, courses.name, COUNT(DISTINCT register.snum) AS Count_Registered_Students
FROM courses 
LEFT JOIN register ON courses.number = register.course_number
GROUP BY courses.number, courses.name ORDER BY courses.number