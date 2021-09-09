INSERT INTO USER
    (id, username, first_name, last_name)
VALUES
    (1, 'ivan', 'ivic', 'test1'),
    (2, 'peor', 'ivic', 'test2'),
    (3, 'bero', 'ivic', 'test3');

INSERT INTO AUTHOR
    (id, first_name, last_name)
VALUES
    (1, 'ivanAu', 'ivic'),
    (2, 'peorAu', 'ivic'),
    (3, 'beroAu', 'ivic');

INSERT INTO BOOK
    (id, ISBN, title, "YEAR", note)
VALUES
    (1, 'isbn1', 'book1', 2000, 'note'),
    (2, 'isbn2', 'book2', 2000, 'note'),
    (3, 'isbn3', 'book3', 2000, 'note');

--
-- INSERT INTO AUTHOR_BOOK
--     (book_id, author_id)
-- VALUES
--     (1, 1)
--     (2, 2)

-- INSERT INTO USER_BOOK_LOAN
--     (user_id, isbn, loan_time)
-- VALUES
--     (1, 'isbn1', NOW()),
--     (2, 'isbn2', NOW()),
--     (3, 'isbn3',NOW());
