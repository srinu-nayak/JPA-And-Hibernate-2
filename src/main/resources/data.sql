/*insert into book(name, imageUrl) values('Harry Potter and the Philosopher''s Stone', 'harry_potter_1.jpg');
insert into book(name, imageUrl) values('Harry Potter and the Chamber of Secrets','harry_potter_2.jpg');
insert into book(name, imageUrl) values('Harry Potter and the Goblet of Fire', 'harry_potter_3.jpg');
insert into book(name, imageUrl) values('Harry Potter and the Cursed Child','harry_potter_4.jpg');
insert into book(name, imageUrl) values('The 3 Mistakes of My Life', 'mistakes_life.jpg');
insert into book(name, imageUrl) values('Life of Pi', 'life_of_pi.jpg');
insert into book(name, imageUrl) values('One Night at the Call Center','one_night_acc.jpg');
insert into book(name, imageUrl) values('Half Girlfriend', 'half_gf.jpg');
insert into book(name, imageUrl) values('The Secret', 'secret.jpg');
insert into book(name, imageUrl) values('Rise', 'rise.jpg');



insert into publisher (publisherName) VALUES ('Bloomsbury Publishing');
insert into publisher (publisherName) VALUES ('Rupa Publications');
insert into publisher (publisherName) VALUES ('Knopf Canada');
insert into publisher (publisherName) VALUES ('Simon & Schuster');
insert into publisher (publisherName) VALUES ('Penguin Random House');
insert into publisher (publisherName) VALUES ('Viking Press');



insert into author(authorName) values('J.K.Rowling');
insert into author(authorName) values('Larry Niven');
insert into author(authorName) values('Jerry Pournelle');
insert into author(authorName) values('Stephen King');
insert into author(authorName) values('Peter Straub');
insert into author(authorName) values('Chetan Bhagat');
insert into author(authorName) values('Rhonda Byrne');



insert into book (name, imageUrl, publisherId) values ('Harry Potter and the Sorcerer''s Stone', 'harry_potter_and_the_sorcerers_stone.jpg', 1);
insert into book (name, imageUrl, publisherId) values ('Life of Pi', 'life_of_pi.jpg', 3);
insert into book (name, imageUrl, publisherId) values ('Harry Potter and the Chamber of Secrets', 'harry_potter_and_the_chamber.jpg', 1);
insert into book (name, imageUrl, publisherId) values ('East of Eden', 'east_of_eden.jpg', 6);
insert into book (name, imageUrl, publisherId) values ('The 3 Mistakes of My Life', 'the_3_mistakes_of_my_life.jpg', 2);
insert into book (name, imageUrl, publisherId) values ('One Night at the Call Center', 'one_night_at_the_call_center.jpg', 2);
insert into book (name, imageUrl, publisherId) values ('Half Girlfriend', 'half_girlfriend.jpg', 2);
insert into book (name, imageUrl, publisherId) values ('The Secret', 'the_secret.jpg', 4);
insert into book (name, imageUrl, publisherId) values ('The Rise of Theodore Roosevelt', 'the_rise_of_theodore_roosevelt.jpg', 5); */


insert into book_author(bookId, authorId) values (1, 1);
insert into book_author(bookId, authorId) values (2, 2);
insert into book_author(bookId, authorId) values (2, 3);
insert into book_author(bookId, authorId) values (3, 4);
insert into book_author(bookId, authorId) values (3, 5);
insert into book_author(bookId, authorId) values (4, 4);
insert into book_author(bookId, authorId) values (5, 4);
insert into book_author(bookId, authorId) values (5, 5);
insert into book_author(bookId, authorId) values (6, 6);
insert into book_author(bookId, authorId) values (7, 7);
insert into book_author(bookId, authorId) values (8, 6);