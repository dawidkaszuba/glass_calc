INSERT INTO TileGroup(name) VALUES("standard");
INSERT INTO TileGroup(name) VALUES("tempered");
INSERT INTO TileGroup(name) VALUES("ornament");
INSERT INTO TileGroup(name) VALUES("tempered ornament");
INSERT INTO TileGroup(name) VALUES("sunscreen");
INSERT INTO TileGroup(name) VALUES("selective");
INSERT INTO TileGroup(name) VALUES("glued");

INSERT INTO Coating(name,value) VALUES("float", 0);
INSERT INTO Coating(name,value) VALUES("Thermofloat 1.1", 1.1);
INSERT INTO Coating(name,value) VALUES("Thermofloat 1.0", 1.1);
INSERT INTO Coating(name,value) VALUES("CombiNeutral 70/40", 1.1);
INSERT INTO Coating(name,value) VALUES("CombiNeutral 61/32", 1.0);

INSERT INTO Foil(name,isAcustic,isMat,price,thickness) VALUES("PVB foil",0,0,12,0.38 );
INSERT INTO Foil(name,isAcustic,isMat,price,thickness) VALUES("PVB Aku foil",1,0,15,0.38 );
INSERT INTO Foil(name,isAcustic,isMat,price,thickness) VALUES("PVB Mat foil",0,1,26,0.38 );