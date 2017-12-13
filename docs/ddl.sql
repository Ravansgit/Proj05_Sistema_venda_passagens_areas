DROP TABLE hour_price;
CREATE TABLE hour_price(
    id INTEGER NOT NULL GENERATED ALWAYS 
        AS IDENTITY (START WITH 1, INCREMENT BY 1)
    , datetime timestamp not null
    , price numeric(10,2) not null
);
DROP TABLE users;
CREATE TABLE users(
    id INTEGER NOT NULL GENERATED ALWAYS 
        AS IDENTITY (START WITH 1, INCREMENT BY 1)
    , name varchar(200) not null
    , login varchar(50)  not null
    , pass_hash varchar(200) not null
);
DROP TABLE vehicles_stays;
CREATE TABLE vehicles_stays(
    id  INTEGER NOT NULL GENERATED ALWAYS 
        AS IDENTITY (START WITH 1, INCREMENT BY 1)
    , vehicle_model varchar(50) not null
    , vehicle_color varchar(20) not null
    , vehicle_plate varchar(7) not null
    , begin_stay timestamp not null
    , end_stay timestamp
    , price numeric(10,2)
);