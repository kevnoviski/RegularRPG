
create schema REGRPG;

CREATE TABLE REGRPG.ClasseCombate(
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    NOME VARCHAR(80),
    ALCANCE INT,
    ATAQUE INT,
    DEFESA INT);

create table REGRPG.PICTURE(
	ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
	NAME  VARCHAR(50),
	PATH VARCHAR(500)
);

CREATE TABLE REGRPG.TIER (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    tierNumber INT,
    requiredExp INT
);

CREATE TABLE REGRPG.WEAPON(
	ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
	NOME VARCHAR(80),
        ID_ClasseCombate INT NOT NULL,
	DANO DOUBLE,
	dps DOUBLE,
	durabilidade DOUBLE,
	alcance INT,
	quebrada BOOLEAN,
	idPicture INT,
	idTier INT);
Alter Table REGRPG.WEAPON Add FOREIGN KEY (ID_ClasseCombate) References REGRPG.ClasseCombate (ID);   
Alter Table REGRPG.WEAPON Add FOREIGN KEY (idPicture) References REGRPG.PICTURE (ID);   
Alter Table REGRPG.WEAPON Add FOREIGN KEY (idTier) References REGRPG.TIER (ID);   


CREATE TABLE REGRPG.ARMOR(
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    ID_ClasseCombate INT NOT NULL,
    defesa DOUBLE,
    ataque DOUBLE,
	idPicture INT,
	idTier INT);
Alter Table REGRPG.ARMOR Add FOREIGN KEY (ID_ClasseCombate) References REGRPG.ClasseCombate (ID);  
Alter Table REGRPG.ARMOR Add FOREIGN KEY (idPicture) References REGRPG.PICTURE (ID); 
Alter Table REGRPG.ARMOR Add FOREIGN KEY (idTier) References REGRPG.TIER (ID); 


CREATE TABLE REGRPG.ClasseMount (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    classe VARCHAR(50)
);


CREATE TABLE REGRPG.Mount (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    NOME VARCHAR(80),
    ID_ClasseMount INT,
    velocidade DOUBLE,
    health INT,
    armor INT,
	idPicture INT,
	idTier INT);
Alter Table REGRPG.Mount Add FOREIGN KEY (ID_ClasseMount) References REGRPG.ClasseMount (ID); 
Alter Table REGRPG.Mount Add FOREIGN KEY (idPicture) References REGRPG.PICTURE (ID);  
Alter Table REGRPG.Mount Add FOREIGN KEY (idTier) References REGRPG.TIER (ID);


CREATE TABLE REGRPG.Backpack (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    weightlimit DOUBLE,
    currentWeight DOUBLE,
	idPicture INT,
	idTier INT
);
Alter Table REGRPG.Backpack Add FOREIGN KEY (idPicture) References REGRPG.PICTURE (ID); 
Alter Table REGRPG.Backpack Add FOREIGN KEY (idTier) References REGRPG.TIER (ID);

CREATE TABLE REGRPG.Item (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    idWeapon INT ,
    idArmor INT 
);

Alter Table REGRPG.Item Add FOREIGN KEY (idWeapon) References REGRPG.WEAPON (ID);  

Alter Table REGRPG.Item Add FOREIGN KEY (idArmor) References REGRPG.ARMOR (ID);  


CREATE TABLE REGRPG.BackpackItem (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    idBackpack INT,
    idItem INT
);

Alter Table REGRPG.BackpackItem Add FOREIGN KEY (idBackpack) References REGRPG.Backpack (ID);  

Alter Table REGRPG.BackpackItem Add FOREIGN KEY (idItem) References REGRPG.Item (ID);  


CREATE TABLE REGRPG.Personagem (
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
Alter Table REGRPG.Personagem Add FOREIGN KEY (idArmor) References REGRPG.ARMOR (ID);  

Alter Table REGRPG.Personagem Add FOREIGN KEY (idWeapon) References REGRPG.WEAPON (ID);  

Alter Table REGRPG.Personagem Add FOREIGN KEY (idBackpack) References REGRPG.Backpack (ID);  

Alter Table REGRPG.Personagem Add FOREIGN KEY (idPicture) References REGRPG.PICTURE (ID); 

CREATE TABLE REGRPG.Jogador (    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),    nome VARCHAR(100));


create table REGRPG.JogadorPersonagem (
    ID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1),
    idJogador INT,
    idPersonagem INT
);

Alter Table REGRPG.JogadorPersonagem Add FOREIGN KEY (idJogador) References REGRPG.Jogador (ID);  
Alter Table REGRPG.JogadorPersonagem Add FOREIGN KEY (idPersonagem) References REGRPG.Personagem (ID);  