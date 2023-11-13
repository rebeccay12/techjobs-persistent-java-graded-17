--Part 1


--Part 2

--Part 3
DROP TABLE job;

--Part 4
SELECT skill.skill_name
FROM skill
JOIN job ON skill.skill_id = job.skill_id
ORDER BY skill.skill_name;
