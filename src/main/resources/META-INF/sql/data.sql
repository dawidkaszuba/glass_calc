INSERT INTO TileGroup(name) VALUES("standard");
INSERT INTO TileGroup(name) VALUES("tempered");
INSERT INTO TileGroup(name) VALUES("ornament");
INSERT INTO TileGroup(name) VALUES("tempered ornament");
INSERT INTO TileGroup(name) VALUES("sunscreen");
INSERT INTO TileGroup(name) VALUES("selective");
INSERT INTO TileGroup(name) VALUES("laminated");

INSERT INTO Coating(name,value,lowEmisly,deliveryTime) VALUES("Float", 0,0,5);
INSERT INTO Coating(name,value,lowEmisly,deliveryTime) VALUES("Thermofloat 1.1", 1.1,1,5);
INSERT INTO Coating(name,value,lowEmisly,deliveryTime) VALUES("Thermofloat 1.0", 1.1,1,5);
INSERT INTO Coating(name,value,lowEmisly,deliveryTime) VALUES("CombiNeutral 70/40", 1.1,1,10);
INSERT INTO Coating(name,value,lowEmisly,deliveryTime) VALUES("CombiNeutral 61/32", 1.0,1,5);
INSERT INTO Coating(name,value,lowEmisly,deliveryTime) VALUES("Thermofloat 1.1 AF", 1.1,1,5);

INSERT INTO Foil(name,isAcustic,isMat,price,thickness,deliveryTime) VALUES("PVB",0,0,12,0.38,3 );
INSERT INTO Foil(name,isAcustic,isMat,price,thickness,deliveryTime) VALUES("PVB Aku",1,0,15,0.38,4 );
INSERT INTO Foil(name,isAcustic,isMat,price,thickness,deliveryTime) VALUES("PVB Mat",0,1,26,0.38 ,5);

INSERT INTO Gas(name, price,deliveryTime) VALUES("Ar 90", 0,5);
INSERT INTO Gas(name, price,deliveryTime) VALUES("Kr 90", 100,10);
INSERT INTO Gas(name, price,deliveryTime) VALUES("Air", 0,5);


INSERT INTO Frame(name,price,psi,thickness,deliveryTime) VALUES('16 Alu', 0,0.8,16,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime) VALUES('18 Alu', 2.5,0.8,18,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime) VALUES('18 Chromatech 7035', 7,0.038,18,8);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime) VALUES('18 Chromatech 7040', 7,0.038,18,3);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime) VALUES('18 Chromatech 9016', 7,0.038,18,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime) VALUES('18 Chromatech 9005', 7,0.038,18,10);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime) VALUES('10 Alu', 0,0.08,10);

INSERT INTO BasePrice2Tile(name,value) VALUES("4Th 1.1 - 16 - 4fl", 71);
INSERT INTO BasePrice3Tile(name,value) VALUES("4Th 1.1 - 16 - 4fl - 16 - 4Th 1.1", 117.5);

INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Th 1.1',0,0,0,4,2,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Fl',0,0,0,4,1,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 ESG Tf 1.1',1,50,0,4,2,null,2,10);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 Th 1.1',0,30,0,6,2,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 Fl',0,21,0,6,1,null,1,4);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('5 Fl',0,18,0,5,1,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('5 Th 1.1 ',0,25,0,5,2,null,1,6);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('10 Th 1.1 ',0,100,0,10,2,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('10 Fl ',0,88,0,10,1,null,1,8);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Decormat Fl ',0,40,0,4,1,null,3,5);

INSERT  INTO StandardPrice2TilesGlass(name,value) VALUES('4Th 1.1 - 16 - 4 FL',71);
INSERT  INTO StandardPrice3TilesGlass(name,value) VALUES('4Th 1.1 - 16 - 4 FL - 16 - 4Th 1.1',119);

INSERT INTO Addition(name, price, methodToCalculatePrice,deliveryTime) VALUES('HST 3mm',8,'BY_AREA',10);
INSERT INTO Addition(name, price, methodToCalculatePrice,deliveryTime) VALUES('HST 4mm',12,'BY_AREA',10);
INSERT INTO Addition(name, price, methodToCalculatePrice,deliveryTime) VALUES('Altimeter',26,'BY_PIECE',10);