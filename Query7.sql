SELECT students.name, students.snum FROM students
JOIN register ON students.snum = register.snum
JOIN courses ON register.course_number = courses.number
JOIN major ON students.snum = major.snum
WHERE courses.name = 'database' AND (major.level = "MS" OR major.level = "PhD")
ORDER BY students.snum