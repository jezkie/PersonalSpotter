CREATE TABLE users (  
  id integer NOT NULL PRIMARY KEY,  
  username varchar(20) NOT NULL,  
  password varchar(20) NOT NULL  
);

CREATE TABLE authorities (  
  username varchar(20) NOT NULL,  
  role varchar(20) NOT NULL 
);
