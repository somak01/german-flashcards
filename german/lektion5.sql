DELETE FROM words
WHERE lektion_num = 5;


INSERT INTO words (german, hungarian, word_type_id, lektion_num)
VALUES ('mich', 'engem', 2, 5), ('dich', 'téged', 2, 5), ('ihn', 'őt(fiú)', 2, 5), ('sie', 'őt(lány)', 2, 5), ('es', 'őt(semleges)', 2, 5), ('uns', 'minket', 2, 5), ('euch', 'titeket', 2, 5), ('sie', 'őket', 2, 5), ('Sie', 'önt/önöket', 2, 5);
