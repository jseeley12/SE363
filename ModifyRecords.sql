SELECT * FROM students WHERE ssn = 144673371;
UPDATE students SET name = 'Scott' WHERE ssn = 144673371;

UPDATE major SET major.name='Computer Science' WHERE snum = (SELECT students.snum FROM students WHERE students.ssn = 144673371);
UPDATE major SET major.level = 'MS' WHERE snum = (SELECT students.snum FROM students WHERE students.ssn = 144673371);
SELECT * FROM major WHERE snum= (SELECT students.snum FROM students WHERE students.ssn = 144673371);

SELECT * FROM register WHERE regtime = 'Summer2024';
DELETE FROM register WHERE snum IN (SELECT snum FROM ( SELECT snum FROM register WHERE regtime = 'Summer2024')AS t);