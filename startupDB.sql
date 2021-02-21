

CREATE TABLE APP.ClasseCombate(
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    NOME VARCHAR(80),
    ALCANCE INT,
    ATAQUE INT,
    DEFESA INT);

create table APP.PICTURE(
	ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
	NAME  VARCHAR(50),
	PATH VARCHAR(500)
);

CREATE TABLE APP.TIER (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    tierNumber INT,
    requiredExp INT
);

CREATE TABLE APP.WEAPON(
	ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
	NOME VARCHAR(80),
        ID_ClasseCombate INT NOT NULL,
	DANO DOUBLE,
	dps DOUBLE,
	durabilidade DOUBLE,
	alcance INT,
	quebrada BOOLEAN,
	idPicture INT,
	idTier INT,
	PRICE DOUBLE);
Alter Table APP.WEAPON Add FOREIGN KEY (ID_ClasseCombate) References APP.ClasseCombate (ID);   
Alter Table APP.WEAPON Add FOREIGN KEY (idPicture) References APP.PICTURE (ID);   
Alter Table APP.WEAPON Add FOREIGN KEY (idTier) References APP.TIER (ID);   


CREATE TABLE APP.ARMOR(
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    ID_ClasseCombate INT NOT NULL,
    defesa DOUBLE,
    ataque DOUBLE,
	idPicture INT,
	idTier INT,
	PRICE DOUBLE);
Alter Table APP.ARMOR Add FOREIGN KEY (ID_ClasseCombate) References APP.ClasseCombate (ID);  
Alter Table APP.ARMOR Add FOREIGN KEY (idPicture) References APP.PICTURE (ID); 
Alter Table APP.ARMOR Add FOREIGN KEY (idTier) References APP.TIER (ID); 


CREATE TABLE APP.ClasseMount (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    classe VARCHAR(50)
);


CREATE TABLE APP.Mount (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    NOME VARCHAR(80),
    ID_ClasseMount INT,
    velocidade DOUBLE,
    health INT,
    armor INT,
	idPicture INT,
	idTier INT,
	PRICE DOUBLE);
Alter Table APP.Mount Add FOREIGN KEY (ID_ClasseMount) References APP.ClasseMount (ID); 
Alter Table APP.Mount Add FOREIGN KEY (idPicture) References APP.PICTURE (ID);  
Alter Table APP.Mount Add FOREIGN KEY (idTier) References APP.TIER (ID);


CREATE TABLE APP.Backpack (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    weightlimit DOUBLE,
    currentWeight DOUBLE,
	idPicture INT,
	idTier INT,
	PRICE DOUBLE
);
Alter Table APP.Backpack Add FOREIGN KEY (idPicture) References APP.PICTURE (ID); 
Alter Table APP.Backpack Add FOREIGN KEY (idTier) References APP.TIER (ID);

CREATE TABLE APP.Item (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    idWeapon INT ,
    idArmor INT ,
	idMount INT,
	idBackpack INT
);

Alter Table APP.Item Add FOREIGN KEY (idWeapon) References APP.WEAPON (ID);  

Alter Table APP.Item Add FOREIGN KEY (idArmor) References APP.ARMOR (ID);  
Alter Table APP.Item Add FOREIGN KEY (idMount) References APP.MOUNT (ID);  
Alter Table APP.Item Add FOREIGN KEY (idBackpack) References APP.Backpack (ID);  


CREATE TABLE APP.BackpackItem (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    idBackpack INT,
    idItem INT
);

Alter Table APP.BackpackItem Add FOREIGN KEY (idBackpack) References APP.Backpack (ID);  

Alter Table APP.BackpackItem Add FOREIGN KEY (idItem) References APP.Item (ID);  


CREATE TABLE APP.Personagem (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    name VARCHAR(50),
    health INT,
    exp INT,
    gold INT,
    SEXO VARCHAR(1),
    idArmor INT,
    idWeapon INT,
    idBackpack INT,
	idPicture INT
);
Alter Table APP.Personagem Add FOREIGN KEY (idArmor) References APP.ARMOR (ID);  

Alter Table APP.Personagem Add FOREIGN KEY (idWeapon) References APP.WEAPON (ID);  

Alter Table APP.Personagem Add FOREIGN KEY (idBackpack) References APP.Backpack (ID);  

Alter Table APP.Personagem Add FOREIGN KEY (idPicture) References APP.PICTURE (ID); 

CREATE TABLE APP.Jogador (    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),    nome VARCHAR(100));


create table APP.JogadorPersonagem (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    idJogador INT,
    idPersonagem INT
);

Alter Table APP.JogadorPersonagem Add FOREIGN KEY (idJogador) References APP.Jogador (ID);  
Alter Table APP.JogadorPersonagem Add FOREIGN KEY (idPersonagem) References APP.Personagem (ID);  