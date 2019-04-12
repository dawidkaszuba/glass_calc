INSERT INTO TileGroup(name) VALUES("standard");
INSERT INTO TileGroup(name) VALUES("tempered");
INSERT INTO TileGroup(name) VALUES("ornament");
INSERT INTO TileGroup(name) VALUES("tempered ornament");
INSERT INTO TileGroup(name) VALUES("sunscreen");
INSERT INTO TileGroup(name) VALUES("selective");
INSERT INTO TileGroup(name) VALUES("laminated");

INSERT INTO Coating(name,value) VALUES("float", 0);
INSERT INTO Coating(name,value) VALUES("Thermofloat 1.1", 1.1);
INSERT INTO Coating(name,value) VALUES("Thermofloat 1.0", 1.1);
INSERT INTO Coating(name,value) VALUES("CombiNeutral 70/40", 1.1);
INSERT INTO Coating(name,value) VALUES("CombiNeutral 61/32", 1.0);

INSERT INTO Foil(name,isAcustic,isMat,price,thickness) VALUES("PVB",0,0,12,0.38 );
INSERT INTO Foil(name,isAcustic,isMat,price,thickness) VALUES("PVB Aku",1,0,15,0.38 );
INSERT INTO Foil(name,isAcustic,isMat,price,thickness) VALUES("PVB Mat",0,1,26,0.38 );

INSERT INTO Gas(name, price) VALUES("Argon 90", 0);
INSERT INTO Gas(name, price) VALUES("Krypton 90", 100);
INSERT INTO Gas(name, price) VALUES("Air", 0);


INSERT INTO Frame(name,price,psi,thickness) VALUES('Alu', 2.5,0.8,18);
INSERT INTO Frame(name,price,psi,thickness) VALUES('Chromatech 7035', 7,0.038,18);
INSERT INTO Frame(name,price,psi,thickness) VALUES('Chromatech 7040', 7,0.038,18);
INSERT INTO Frame(name,price,psi,thickness) VALUES('Chromatech 9016', 7,0.038,18);
INSERT INTO Frame(name,price,psi,thickness) VALUES('Chromatech 9005', 7,0.038,18);

INSERT INTO BasePrice2Tile(name,value) VALUES("4Th 1.1 - 16 - 4fl", 71);
INSERT INTO BasePrice3Tile(name,value) VALUES("4Th 1.1 - 16 - 4fl - 16 - 4Th 1.1", 117.5);
