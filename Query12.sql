SELECT degrees.name, degrees.level, COUNT(major.snum) AS count FROM degrees
JOIN major ON degrees.name = major.name AND degrees.level = major.level
GROUP BY degrees.name, degrees.level
ORDER BY count DESC, degrees.name
LIMIT 1;
