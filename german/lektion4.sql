DELETE FROM words
WHERE lektion_num = 4;


INSERT INTO words (german, hungarian, word_type_id, lektion_num)
	VALUES ('die Geburtstagsparty-s', 'születésnapi parti', 1, 4), ('organisieren', 'szervezni', 1, 4), ('heute', 'ma', 4, 4),
('der Geburtstag-e', 'születésnap', 0, 4), ('deswegen', 'ezért', 4, 4), ('aufgeregt', 'izgatott', 3, 4),
('gelingen+D', 'sikerül vkinek vmi', 1, 4), ('laufen', 'futni', 1, 4), ('die Milch-', 'tej', 0, 4), ('der Mensch-en', 'ember', 0, 4), ('die Torte-n', 'torta', 0, 4), ('schade', 'kár (vmiért)', 3, 4), ('alles', 'minden', 2, 4), ('zu', 'túl, túlzottan', 4, 4),
('spät', 'késő', 3, 4), ('der Gast-:e', 'vendég', 0, 4),
 ('backen', 'sütni', 1, 4), ('die Ordnung', 'rend', 0, 4), 
('die Zauberin-nen', 'varázslónő', 0, 4), ('der Zauber-s', 'varázslat', 0, 4), ('der Zauberer-s', 'varázsló', 0, 4), ('schmecken+D', 'ízlik vkinek vmi', 1, 4), ('ungeschickt', 'ügyetlen', 3, 4), 
('pessimistisch', 'pesszimista', 3, 4), ('pechschwarz', 'koromfekete', 3, 4), ('merken', 'megjegyezni(magának vmit)', 1, 4), 
('das Glas-:er', 'pohár', 0, 4), ('nie', 'soha', 4, 4), 
('halbleer', 'félig üres', 3, 4), ('sondern', 'hanem', 7, 4),
 ('halbvoll', 'félig teli', 3, 4), ('klingeln', 'csöngetni', 1, 4), ('öffnen', 'kinyitni', 1, 4), ('die Tür-en', 'ajtó', 0, 4), 
('empfangen', 'fogadni vkit', 1, 4), ('erledigen', 'elintezni vmit', 1, 4), ('todmüde', 'hullafáradt', 3, 4), ('ein wenig', 'egy kicsi', 10, 4), ('der Alkohol-e', 'alkohol', 0, 4),
 ('die Welt-en', 'világ', 0, 4), ('ganz', 'egész, teljes', 3, 4), ('anders', 'más, máshogy', 3, 4), ('der Wein-e', 'bor', 0, 4), ('für', 'számára, részére', 6, 4), ('der Champagner-', 'pezsgő', 0, 4), ('der Alkoholiker-', 'alkoholista', 0, 4), ('wissen', 'tudni', 1, 4), ('die Überraschung-en', 'meglepetés', 0, 4), ('der Bus-se', 'busz', 0, 4),
 ('fahren', 'utazni,vezetni', 1, 4), ('klar', 'világos', 3, 4), 
('der Tisch-e', 'asztal', 0, 4), ('hinten', 'hátul', 4, 4), 
('das Geschenk-e', 'ajándék', 0, 4), ('schenken+D', 'ajándékozni vkinek', 1, 4), ('vorne', 'elöl', 4, 4), ('kosten', 'kerül vmibe', 1, 4), ('geldgierig', 'pénzéhes,anyagias', 3, 4), ('der Bankier-s', 'bankár', 0, 4), ('der Politiker-', 'politikus', 0, 4), 
('Du siehst alles pechschwarz', 'Mindent koromfeketének látsz', 10, 4), ('Es klingelt', 'Csöngetnek', 10, 4), 
('Wie geht''s?', 'Hogy vagy?', 10, 4), ('Was für eine Überraschung!', 'Micsoda meglepetés!', 10, 4), ('Du hast Verspätung', 'Késel', 10, 4), 
('Alles klar!', 'Minden világos!', 10, 4), ('Was kostet das?', 'Mibe kerül(az)', 10, 4), ('Die Torte schmeckt nach Knoblauch', 'A torta fokhagyma ízű', 10, 4);
