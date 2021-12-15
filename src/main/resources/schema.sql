-- Role
INSERT INTO role (id, name) VALUES ( 1, 'ADMIN');
INSERT INTO role (id, name) VALUES ( 2, 'USER');

-- Users
INSERT INTO blog_user(id, active, email, name, password, username) VALUES ( 1, 'true', 'test@test.com', 'I am test', '$2a$10$HyFZ9W25W.ktMBx4cIb/0e.n5w2ZFlh2vV/Tx0SLTpQyI0FqJ3wqS', 'test' );
INSERT INTO blog_user(id, active, birth_date, email, name, password, username) VALUES ( 2, 'true', '1996-01-12', 'ronan.tapia@gmail.com', 'Ronan Tapia', '$2a$12$ipyb3TriZQXS6BGNZdI8nextg8HadI0Z9AjChpfiz6qwkWmU4VUGq', 'ronan' );
INSERT INTO blog_user(id, active, birth_date, email, name, password, username) VALUES ( 3, 'true', '1994-04-23', 'adeline.philip@gmail.com', 'Adeline Philip', '$2a$12$ipyb3TriZQXS6BGNZdI8nextg8HadI0Z9AjChpfiz6qwkWmU4VUGq', 'adeline' );
INSERT INTO blog_user(id, active, birth_date, email, name, password, username) VALUES ( 4, 'true', '1986-12-25', 'kaylie.moran@gmail.com', 'Kaylie moran', '$2a$12$ipyb3TriZQXS6BGNZdI8nextg8HadI0Z9AjChpfiz6qwkWmU4VUGq', 'kaylie' );
INSERT INTO blog_user(id, active, birth_date, email, name, password, username) VALUES ( 5, 'true', '1999-07-17', 'ronnie.payne@gmail.com', 'Ronnie Payne', '$2a$12$ipyb3TriZQXS6BGNZdI8nextg8HadI0Z9AjChpfiz6qwkWmU4VUGq', 'ronnie' );
INSERT INTO blog_user(id, active, birth_date, email, name, password, username) VALUES ( 6, 'true', '2002-11-12', 'francesco.fritz@gmail.com', 'Francesco Fritz', '$2a$12$ipyb3TriZQXS6BGNZdI8nextg8HadI0Z9AjChpfiz6qwkWmU4VUGq', 'francesco' );

-- User Role
INSERT INTO blog_user_roles(user_id, role_id) VALUES ( 1, 1 );
INSERT INTO blog_user_roles(user_id, role_id) VALUES ( 2, 2 );
INSERT INTO blog_user_roles(user_id, role_id) VALUES ( 3, 2 );
INSERT INTO blog_user_roles(user_id, role_id) VALUES ( 4, 2 );
INSERT INTO blog_user_roles(user_id, role_id) VALUES ( 5, 2 );
INSERT INTO blog_user_roles(user_id, role_id) VALUES ( 6, 2 );

-- Category
INSERT INTO category (id, title) VALUES (1, 'Personal');
INSERT INTO category (id, title) VALUES (2, 'Business');
INSERT INTO category (id, title) VALUES (3, 'Professional');
INSERT INTO category (id, title) VALUES (4, 'Lifestyle');
INSERT INTO category (id, title) VALUES (5, 'Home decor');
INSERT INTO category (id, title) VALUES (6, 'Health');
INSERT INTO category (id, title) VALUES (7, 'Affiliate');
INSERT INTO category (id, title) VALUES (8, 'Media');
INSERT INTO category (id, title) VALUES (9, 'Tech');


-- Post
INSERT INTO post (id, created_at, created_by, text, title, blog_user_id, category_id) VALUES (1, '2000-04-17', 'ronan' , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Elementum eu facilisis sed odio. Dui accumsan sit amet nulla facilisi morbi tempus. Duis at tellus at urna condimentum mattis. Platea dictumst quisque sagittis purus sit. Velit scelerisque in dictum non. Odio euismod lacinia at quis. Cras fermentum odio eu feugiat pretium nibh ipsum consequat. Nunc non blandit massa enim nec dui. Facilisi etiam dignissim diam quis enim. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Proin nibh nisl condimentum id venenatis a. Mauris rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar.', 'What is Lorem Ipsum?', 2, 1);
INSERT INTO post (id, created_at, created_by, text, title, blog_user_id, category_id) VALUES (2, '2005-06-21', 'adeline', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed velit dignissim sodales ut eu sem integer vitae justo. Lectus vestibulum mattis ullamcorper velit sed ullamcorper.', 'Title Lorem Ipsum?', 3, 7);
INSERT INTO post (id, created_at, created_by, text, title, blog_user_id, category_id) VALUES (3, '2007-07-13', 'kaylie', 'Tellus id interdum velit laoreet. Mauris nunc congue nisi vitae suscipit tellus mauris.', 'Tellus', 4, 2);
INSERT INTO post (id, created_at, created_by, text, title, blog_user_id, category_id) VALUES (4, '2012-10-01', 'ronnie', 'Vel elit scelerisque mauris pellentesque pulvinar pellentesque. Risus viverra adipiscing at in tellus integer feugiat.', 'Elite', 5, 8);
INSERT INTO post (id, created_at, created_by, text, title, blog_user_id, category_id) VALUES (5, '2020-09-07', 'francesco', 'Amet cursus sit amet dictum sit amet justo donec. Purus in mollis nunc sed id semper risus in. Ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget egestas.', 'Purus Lorem Ipsum', 6, 3);

-- Comment
INSERT INTO comment(id, created_at, created_by, text, post_id) VALUES ( 1, '2001-05-11', 'adeline', 'Tempor nec feugiat nisl pretium fusce.', 1);
INSERT INTO comment(id, created_at, created_by, text, post_id) VALUES ( 2, '2004-02-22', 'ronan', 'Nisi porta lorem mollis aliquam. ', 1);