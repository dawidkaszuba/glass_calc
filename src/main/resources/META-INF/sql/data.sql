INSERT INTO TileGroup(name) VALUES("standard");
INSERT INTO TileGroup(name) VALUES("tempered");
INSERT INTO TileGroup(name) VALUES("ornament");
INSERT INTO TileGroup(name) VALUES("tempered ornament");
INSERT INTO TileGroup(name) VALUES("sunscreen");
INSERT INTO TileGroup(name) VALUES("selective");
INSERT INTO TileGroup(name) VALUES("laminated");

INSERT INTO Coating(name,value,lowEmisly) VALUES("float", 0,0);
INSERT INTO Coating(name,value,lowEmisly) VALUES("Thermofloat 1.1", 1.1,1);
INSERT INTO Coating(name,value,lowEmisly) VALUES("Thermofloat 1.0", 1.1,1);
INSERT INTO Coating(name,value,lowEmisly) VALUES("CombiNeutral 70/40", 1.1,1);
INSERT INTO Coating(name,value,lowEmisly) VALUES("CombiNeutral 61/32", 1.0,1);

INSERT INTO Foil(name,isAcustic,isMat,price,thickness) VALUES("PVB",0,0,12,0.38 );
INSERT INTO Foil(name,isAcustic,isMat,price,thickness) VALUES("PVB Aku",1,0,15,0.38 );
INSERT INTO Foil(name,isAcustic,isMat,price,thickness) VALUES("PVB Mat",0,1,26,0.38 );

INSERT INTO Gas(name, price) VALUES("Ar 90", 0);
INSERT INTO Gas(name, price) VALUES("Kr 90", 100);
INSERT INTO Gas(name, price) VALUES("Air", 0);


INSERT INTO Frame(name,price,psi,thickness) VALUES('16 Alu', 0,0.8,16);
INSERT INTO Frame(name,price,psi,thickness) VALUES('18 Alu', 2.5,0.8,18);
INSERT INTO Frame(name,price,psi,thickness) VALUES('18 Chromatech 7035', 7,0.038,18);
INSERT INTO Frame(name,price,psi,thickness) VALUES('18 Chromatech 7040', 7,0.038,18);
INSERT INTO Frame(name,price,psi,thickness) VALUES('18 Chromatech 9016', 7,0.038,18);
INSERT INTO Frame(name,price,psi,thickness) VALUES('18 Chromatech 9005', 7,0.038,18);

INSERT INTO BasePrice2Tile(name,value) VALUES("4Th 1.1 - 16 - 4fl", 71);
INSERT INTO BasePrice3Tile(name,value) VALUES("4Th 1.1 - 16 - 4fl - 16 - 4Th 1.1", 117.5);

INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id) VALUES('4Th 1.1',0,0,0,4,2,null,1);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id) VALUES('4Fl',0,0,0,4,1,null,1);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id) VALUES('4 ESG Tf 1.1',1,50,0,4,1,null,2);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id) VALUES('6 Tf 1.1',0,26,0,6,2,null,1);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id) VALUES('6 float1.1',0,18,0,6,1,null,1);

INSERT  INTO StandardPrice2TilesGlass(name,value) VALUES('4Th 1.1 - 16 - 4 FL',71);
INSERT  INTO StandardPrice3TilesGlass(name,value) VALUES('4Th 1.1 - 16 - 4 FL - 16 - 4Th 1.1',119);