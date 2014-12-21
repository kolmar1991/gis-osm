-- Table: test

-- DROP TABLE test;

CREATE TABLE test
(
  lol text,
  id integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE test
  OWNER TO ztb2014;

INSERT INTO test(
            lol, id)
    VALUES ('huehuehue', 1);
