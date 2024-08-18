DELETE FROM words
WHERE lektion_num = 1;


INSERT INTO words(german, hungarian, word_type_id, lektion_num)
VALUES ('der Alptraum-s', 'rémálom', 0, 1),('die Visitenkarte-n', 'névjegykártya', 0, 1),
('ich', 'én', 2, 1), ('heißen', 'hívni', 1, 1),
('kommen', 'jönni', 1, 1), ('aus', '-ból, -ből', 6, 1),
('Ungarn', 'Magyarország', 0, 1), ('wohnen', 'lakni', 1, 1),
('in', '-ban, -ben, -ba, -be', 6, 1), ('die Straße-n', 'utca', 0, 1), ('sein', 'lenni', 1, 1), ('klug', 'okos', 3, 1), ('schlank', 'karcsú', 3, 1), ('und', 'és', 7, 1), ('natürlich', 'természetesen', 3, 1), ('bescheiden', 'szerény', 3, 1), ('Italien', 'Olaszország', 0, 1), ('faul', 'lusta', 3, 1), ('aber', 'de', 7,1), ('genial', 'zseniális', 3, 1), ('persönlich', 'személyesen', 3, 1), ('dünn', 'vékony', 3, 1), ('leise', 'halk', 3, 1), ('laut', 'hangos', 3, 1), ('gleich', 'egyenlő', 3, 1), ('hungrig', 'éhes', 3, 1), ('leben', 'élni', 1, 1), ('sehr', 'nagyon', 4, 1),('reich', 'gazdag', 3, 1), ('lustig', 'vidám', 3, 1), ('ein bisschen', 'egy kicsit', 10, 1), ('dumm', 'hülye', 3, 1), ('mein', 'enyém', 2, 1), ('der Name-n', 'név', 0, 1), ('dick', 'kövér', 3, 1), ('intelligent', 'inteligens', 3, 1), ('England', 'Anglia', 0, 1), ('die Gasse-n', 'utca(kicsi)', 0, 1), ('melankolisch', 'melankólikus', 3, 1), ('langsam', 'lassú', 3, 1), ('leider', 'sajnos',4 , 1),('immer', 'mindig', 4, 1), ('nervös', 'ideges', 3, 1), ('böse', 'mérges', 3, 1), ('selbstkritisch', 'önkritikus', 3, 1), ('traurig', 'szomorú', 3, 1),
('arm', 'szegény', 3, 1), ('stark', 'erős', 3, 1), ('schwach', 'gyenge', 3, 1), ('das Beispiel-e', 'példa', 0, 1), ('Ich habe keine Ahnung', 'Ötletem sincs', 10, 1), ('die Sprache-n', 'nyelv', 0, 1), ('Spanien', 'Spanyolország', 0, 1), ('die Polizei', 'rendőrség', 0, 1), ('der Tourist-en', 'turista', 0, 1), ('Welche?', 'Melyik?', 4, 1), ('das Fahrradgeschäft-e', 'kerékpárbolt', 0, 1), ('das Geschäft-e', 'bolt', 0, 1), ('das Foto-s', 'fotó', 0, 1), ('der Polizist-en', 'rendőr', 0, 1), ('der Pass-:e', 'útlevél', 0, 1);
