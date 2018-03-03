CREATE TABLE Author
(
  id          BIGINT       NOT NULL PRIMARY KEY,
  dateOfBirth DATE         NULL,
  firstname   VARCHAR(255) NULL,
  lastname    VARCHAR(255) NULL
)
  ENGINE = InnoDB;

CREATE TABLE Book
(
  id             BIGINT       NOT NULL PRIMARY KEY,
  authorId       BIGINT       NOT NULL,
  dataVersion    BIGINT       NOT NULL,
  language       VARCHAR(255) NULL,
  publisherId    BIGINT       NOT NULL,
  publishingDate DATE         NULL,
  title          VARCHAR(255) NULL
)
  ENGINE = InnoDB;

CREATE TABLE Publisher
(
  id      BIGINT       NOT NULL PRIMARY KEY,
  city    VARCHAR(255) NULL,
  country VARCHAR(255) NULL,
  name    VARCHAR(255) NULL
)
  ENGINE = InnoDB;