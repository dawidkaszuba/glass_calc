INSERT INTO TileGroup(name) VALUES("standard");
INSERT INTO TileGroup(name) VALUES("tempered");
INSERT INTO TileGroup(name) VALUES("ornament");
INSERT INTO TileGroup(name) VALUES("tempered ornament");
INSERT INTO TileGroup(name) VALUES("sunscreen");
INSERT INTO TileGroup(name) VALUES("selective");
INSERT INTO TileGroup(name) VALUES("laminated");
INSERT INTO TileGroup(name) VALUES("anti-condensation");


INSERT INTO FrameGroup(name) VALUES("Alu");
INSERT INTO FrameGroup(name) VALUES("Chromatech 7035");
INSERT INTO FrameGroup(name) VALUES("Chromatech 9005");
INSERT INTO FrameGroup(name) VALUES("Chromatech 9016");
INSERT INTO FrameGroup(name) VALUES("TGI 9016");
INSERT INTO FrameGroup(name) VALUES("TGI 9005");
INSERT INTO FrameGroup(name) VALUES("TGI 7035");
INSERT INTO FrameGroup(name) VALUES("Premium Edge 9016");
INSERT INTO FrameGroup(name) VALUES("Premium Edge 9005");
INSERT INTO FrameGroup(name) VALUES("Premium Edge 7035");

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

INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 Alu', 0,0.08,16,5,1);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 Alu', 0,0.08,10,5,1);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 Alu', 0,0.08,12,5,1);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 Alu', 0,0.08,14,5,1);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 Alu', 2.5,0.8,18,5,1);


INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 Chromatech 7035', 6,0.038,10,5,2);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 Chromatech 7035', 6,0.038,12,5,2);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 Chromatech 7035', 6,0.038,14,5,2);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('15 Chromatech 7035', 6,0.038,15,5,2);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 Chromatech 7035', 6,0.038,16,5,2);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 Chromatech 7035', 7,0.038,18,8,2);


INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 Chromatech 9005', 6,0.038,10,5,3);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 Chromatech 9005', 6,0.038,12,5,3);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 Chromatech 9005', 6,0.038,14,5,3);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('15 Chromatech 9005', 6,0.038,15,5,3);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 Chromatech 9005', 6,0.038,16,5,3);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 Chromatech 9005', 7,0.038,18,5,3);



INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 Chromatech 9016', 6,0.038,10,5,4);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 Chromatech 9016', 6,0.038,12,5,4);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 Chromatech 9016', 6,0.038,14,5,4);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('15 Chromatech 9016', 6,0.038,15,5,4);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 Chromatech 9016', 6,0.038,16,5,4);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 Chromatech 9016', 7,0.038,18,5,4);


INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 TGI 9016', 6,0.038,10,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 TGI 9016', 6,0.038,12,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 TGI 9016', 6,0.038,14,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('15 TGI 9016', 6,0.038,15,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 TGI 9016', 6,0.038,16,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 TGI 9016', 7,0.038,18,5,5);

INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 TGI 9005', 6,0.038,10,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 TGI 9005', 6,0.038,12,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 TGI 9005', 6,0.038,14,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('15 TGI 9005', 6,0.038,15,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 TGI 9005', 6,0.038,16,5,5);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 TGI 9005', 7,0.038,18,5,5);

INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 TGI 7035', 6,0.038,10,5,6);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 TGI 7035', 6,0.038,12,5,6);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 TGI 7035', 6,0.038,14,5,6);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('15 TGI 7035', 6,0.038,15,5,6);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 TGI 7035', 6,0.038,16,5,6);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 TGI 7035', 7,0.038,18,5,6);

INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 PremiumEdge 9016', 10,0.038,10,10,8);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 PremiumEdge 9016', 10,0.038,12,10,8);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 PremiumEdge 9016', 10,0.038,14,10,8);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('15 PremiumEdge 9016', 10,0.038,15,10,8);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 PremiumEdge 9016', 10,0.038,16,10,8);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 PremiumEdge 9016', 12,0.038,18,10,8);

INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 PremiumEdge 9005', 10,0.038,10,10,9);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 PremiumEdge 9005', 10,0.038,12,10,9);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 PremiumEdge 9005', 10,0.038,14,10,9);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('15 PremiumEdge 9005', 10,0.038,15,10,9);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 PremiumEdge 9005', 10,0.038,16,10,9);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 PremiumEdge 9005', 12,0.038,18,10,9);

INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('10 PremiumEdge 7035', 10,0.038,10,10,10);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('12 PremiumEdge 7035', 10,0.038,12,10,10);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('14 PremiumEdge 7035', 10,0.038,14,10,10);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('15 PremiumEdge 7035', 10,0.038,15,10,10);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('16 PremiumEdge 7035', 10,0.038,16,10,10);
INSERT INTO Frame(name,price,psi,thickness,deliveryTime,group_id) VALUES('18 PremiumEdge 7035', 12,0.038,18,10,10);


INSERT INTO BasePrice2Tile(name,value) VALUES("4Th 1.1 - 16 - 4fl", 71);
INSERT INTO BasePrice3Tile(name,value) VALUES("4Th 1.1 - 16 - 4fl - 16 - 4Th 1.1", 117.5);

INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Fl',0,0,0,4,1,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Th 1.1',0,0,0,4,2,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('8 Fl',0,42,0,8,1,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('5 Fl',0,18,0,5,1,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('5 Th 1.1 ',0,25,0,5,2,null,1,6);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 Fl',0,21,0,6,1,null,1,4);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 Th 1.1',0,30,0,6,2,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('10 Th 1.1 ',0,100,0,10,2,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('10 Fl ',0,88,0,10,1,null,1,8);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('12 Fl',0,128,0,12,1,null,1,10);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('5 Th 1.1',0,25 ,0,5,1,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Th 1.0 ',0,4,0,4,3,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('8 Th 1.1',0,62,0,8,1,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('5 Th 1.0 ',0,36,0,5,3,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 Th 1.0 ',0,38,0,6,3,null,1,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('8 Th 1.0 ',0,76,0,8,3,null,1,5);

INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('33.1 Th 1.1',0,49,1,6.38,2,1,7,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('33.1 Fl',0,45,1,6.38,1,1,7,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('44.2 Th 1.1 ',0,102,2,8.76,2,1,7,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('44.2 Fl',0,92,2,8.76,1,1,7,10);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('44.6 Fl',0,249,6,10.28,1,1,7,15);

INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Decormat Fl ',0,41,0,4,1,null,3,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Crepi Fl ',0,34,0,4,1,null,3,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Kura (Cotswold) clear Fl ',0,34,0,4,1,null,3,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Silvit clear Fl ',0,34,0,4,1,null,3,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Waterdrop clear Fl ',0,34,0,4,1,null,3,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Delta clear Fl ',0,78,0,4,1,null,3,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Delta mat Fl ',0,134,0,4,1,null,3,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('5 Niagara clear Fl ',0,107,0,5,1,null,3,5);

INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Antisol grey Fl',0,48,0,4,1,null,5,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Antisol green FL',0,48,0,4,1,null,5,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Antisol brown FL',0,48,0,4,1,null,5,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 Antisol blue Fl',0,114,0,6,1,null,5,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Stopsol grey FL',0,126,0,4,1,null,5,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Stopsol green Fl',0,126,0,4,1,null,5,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Stopsol brown Fl',0,126,0,4,1,null,5,5);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 Mirastar (SpyGlas) Fl',0,309,0,6,1,null,5,10);



INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Combi Neutral 70/40',0,71,0,4,4,null,6,10);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 Combi Neutral 70/40',0,114,0,6,4,null,6,10);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('8 Combi Neutral 70/40',0,141,0,8,4,null,6,10);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('33.1 Combi Neutral 70/40',0,169,1,6.38,4,1,6,10);



INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 ESG Tf 1.1',1,50,0,4,2,null,2,7);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('5 ESG Tf 1.1',1,81,0,5,2,null,2,25);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 ESG Tf 1.1',1,83,0,6,2,null,2,7);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('8 ESG Tf 1.1',1,167,0,8,2,null,2,7);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 ESG Fl',1,27,0,4,1,null,2,7);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('5 ESG Fl',1,45,0,5,1,null,2,7);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 ESG Fl',1,46,0,6,1,null,2,7);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('8 ESG Fl',1,71,0,8,1,null,2,7);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('10 ESG Fl',1,149,0,10,1,null,2,15);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('12 ESG Fl',1,176,0,12,1,null,2,15);




INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('33.1 Fl Mat ',0,87,1,6.38,1,3,7,5);

INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('4 Th 1.1 AF ',0,109,0,4,6,null,8,25);
INSERT INTO Tile(name,isTempered,price,quantityOfFoils,thickness,coating_id,foil_id,group_id,deliveryTime) VALUES('6 Th 1.1 AF ',0,175,0,6,6,null,8,25);


INSERT  INTO StandardPrice2TilesGlass(name,value) VALUES('4Th 1.1 - 16 - 4 FL',71);
INSERT  INTO StandardPrice3TilesGlass(name,value) VALUES('4Th 1.1 - 16 - 4 FL - 16 - 4Th 1.1',119);

INSERT INTO Addition(name, price, methodToCalculatePrice,deliveryTime) VALUES('HST 3mm',8,'BY_AREA',10);
INSERT INTO Addition(name, price, methodToCalculatePrice,deliveryTime) VALUES('HST 4mm',12,'BY_AREA',10);
INSERT INTO Addition(name, price, methodToCalculatePrice,deliveryTime) VALUES('Altimeter',26,'BY_PIECE',10);


Insert into Role(role) value('ROLE_ADMIN');
Insert into Role(role) value('ROLE_USER');



