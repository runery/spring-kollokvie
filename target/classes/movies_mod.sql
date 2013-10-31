CREATE TABLE categories (
  category_id int primary key ,
  category_name varchar(150)  NULL,
  remarks varchar(500)  NULL
);

INSERT INTO categories VALUES (1,'Comedy','Movies with humour');
INSERT INTO categories VALUES (2,'Romantic','Love stories');
INSERT INTO categories VALUES (3,'Epic','Story acient movies');
INSERT INTO categories VALUES (4,'Horror',NULL);
INSERT INTO categories VALUES (5,'Science Fiction',NULL);
INSERT INTO categories VALUES (6,'Thriller',NULL);
INSERT INTO categories VALUES (7,'Action',NULL);
INSERT INTO categories VALUES (8,'Romantic Comedy',NULL);

CREATE TABLE movies (
  movie_id int primary key,
  title varchar(300) NULL,
  director varchar(150) NULL,
  year_released int NULL,
  category_id int references categories(category_id)
);

INSERT INTO movies VALUES (1,'Pirates of the Caribean 4',' Rob Marshall',2011,1);
INSERT INTO movies VALUES (2,'Forgetting Sarah Marshal','Nicholas Stoller',2008,2);
INSERT INTO movies VALUES (3,'X-Men',NULL,2008,6);
INSERT INTO movies VALUES (4,'Code Name Black','Edgar Jimz',2010,7);
INSERT INTO movies VALUES (5,'Daddy Little Girls',NULL,2007,8);
INSERT INTO movies VALUES (6,'Angels and Demons',NULL,2007,6);
INSERT INTO movies VALUES (7,'Davinci Code',NULL,2007,6);
INSERT INTO movies VALUES (9,'Honey mooners','John Schultz',2005,8);
INSERT INTO movies VALUES (16,'67% Guilty',NULL,2012,8);

CREATE TABLE members (
  membership_number int primary key,
  full_names varchar(350) NOT NULL,
  gender varchar(6)NULL,
  date_of_birth date NULL,
  physical_address varchar(255)  NULL,
  postal_address varchar(255)  NULL,
  contact_number varchar(75)  NULL,
  email varchar(255)  NULL
);

INSERT INTO members VALUES (1,'Janet Jones','Female','1980-07-21','First Street Plot No 4','Private Bag','0759 253 542','janetjones@yagoo.cm');
INSERT INTO members VALUES (2,'Janet Smith Jones','Female','1980-06-23','Melrose 123',NULL,NULL,'jj@fstreet.com');
INSERT INTO members VALUES (3,'Robert Phil','Male','1989-07-12','3rd Street 34',NULL,'12345','rm@tstreet.com');
INSERT INTO members VALUES (4,'Gloria Williams','Female','1984-02-14','2nd Street 23',NULL,NULL,NULL);

CREATE TABLE payments (
  payment_id int primary key,
  membership_number int references members(membership_number),
  payment_date date NULL,
  description varchar(75) NULL,
  amount_paid float NULL,
  external_reference_number int NULL
);

INSERT INTO payments VALUES (1,1,'2012-07-23','Movie rental payment',2500,11);
INSERT INTO payments VALUES (2,1,'2012-07-25','Movie rental payment',2000,12);
INSERT INTO payments VALUES (3,3,'2012-07-30','Movie rental payment',6000,NULL);

CREATE TABLE movierentals (
  reference_number int primary key,
  transaction_date date  NULL,
  return_date date  NULL,
  membership_number int references members(membership_number),
  movie_id int references movies(movie_id),
  movie_returned int DEFAULT '0'
);

INSERT INTO movierentals VALUES (11,'2012-06-20',NULL,1,1,0);
INSERT INTO movierentals VALUES (12,'2012-06-22','2012-06-25',1,2,0);
INSERT INTO movierentals VALUES (13,'2012-06-22','2012-06-25',3,2,0);
INSERT INTO movierentals VALUES (14,'2012-06-21','2012-06-24',2,2,0);
INSERT INTO movierentals VALUES (15,'2012-06-23',NULL,3,3,0);