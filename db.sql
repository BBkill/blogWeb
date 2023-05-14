create schema ltw;
use ltw;
create table users (
	id int primary key auto_increment,
    username varchar(255),
    name varchar(255),
    gender int,
    phone varchar(20),
    password varchar(255),
    email varchar(255)
);

create table book(
	id int primary key auto_increment,
    name varchar(255),
    description varchar(255),
    released int,
    total_pages int
);

create table author(
    id int primary key auto_increment,
    name varchar(255)
);

create table book_author(
	book_id INT,
    author_id INT,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (author_id) REFERENCES author(id)
);

create table category(
	id int primary key auto_increment,
	name varchar(255)
);

create table book_category(
	book_id INT,
    category_id INT,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

insert into users(username, name, gender, phone, password, email) 
values ('admin', 'admin', 1, '1234567890', '12345678', 'admin@gmail.com'),
('user1', 'user1', 1, '12345267890', '12345678', 'mail2@gmail.com'),
('user2', 'user2', 0, '1234567890', '12345678', 'mail3@gmail.com'),
('user3', 'user3', 1, '12342567890', '12345678', 'mail4mail.com'),
('user4', 'user4', 0, '12345678920', '12345678', 'mail5@gmail.com'),
('user5', 'user5', 1, '12345672890', '12345678', 'mail6@gmail.com'),
('user6', 'user6', 0, '1212234567890', '12345678', 'mail7@gmail.com'),
('user7', 'user7', 1, '12345647890', '12345678', 'mail8@gmail.com');


insert into book(name, description, released, total_pages) 
values
('The Great Gatsby', 'A novel by F. Scott Fitzgerald', 1925, 180),
('To Kill a Mockingbird', 'A novel by Harper Lee', 1960, 281),
('1984', 'A dystopian novel by George Orwell', 1949, 328),
('Pride and Prejudice', 'A romantic novel by Jane Austen', 1813, 279),
('The Catcher in the Rye', 'A novel by J.D. Salinger', 1951, 224),
('The Hobbit', 'A fantasy novel by J.R.R. Tolkien', 1937, 310),
('The Lord of the Rings', 'A high fantasy novel by J.R.R. Tolkien', 1954, 1178),
('Harry Potter and the Philosopher\'s Stone', 'A fantasy novel by J.K. Rowling', 1997, 223),
('The Da Vinci Code', 'A mystery thriller novel by Dan Brown', 2003, 454),
('The Hunger Games', 'A dystopian novel by Suzanne Collins', 2008, 374);

INSERT INTO author (name) VALUES 
('F. Scott Fitzgerald'),
('Harper Lee'),
('George Orwell'),
('Jane Austen'),
('J.D. Salinger'),
('J.R.R. Tolkien'),
('J.K. Rowling'),
('Dan Brown'),
('Suzanne Collins');


INSERT INTO book_author (book_id, author_id) VALUES 
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 5), 
(6, 6), 
(7, 6), 
(8, 7), 
(9, 8), 
(10, 9); 


INSERT INTO category (name) VALUES 
('Fiction'),
('Science Fiction'),
('Romance'),
('Mystery'),
('Thriller'),
('Horror'),
('Fantasy'),
('Biography'),
('History'),
('Science'),
('Self-Help'),
('Cooking'),
('Travel'),
('Art'),
('Poetry'),
('Religion'),
('Philosophy'),
('Business'),
('Finance'),
('Education');

INSERT INTO book_category (book_id, category_id) VALUES 
(1, 1), 
(2, 1), 
(3, 2),
(4, 3), 
(5, 5),
(6, 7),
(7, 7), 
(8, 7), 
(9, 4),
(10, 5);

