DROP TABLE IF EXISTS custom_nodes;
DROP TABLE IF EXISTS segments;
DROP TABLE IF EXISTS segments_set;

CREATE TABLE custom_nodes (
	id SERIAL PRIMARY KEY,
	tags hstore
);

SELECT AddGeometryColumn('custom_nodes', 'geom', 4326, 'POINT', 2);

CREATE TABLE segments (
	id SERIAL PRIMARY KEY,
	point_a integer, --TODO zamienic 2 kolumny z punktami na hstora albo join table'a zeby moglo byc wiecej niz 2
	point_b integer,
	ordinal integer,
	set_id integer --TODO zmienic relacje na join table, reuzytkowanie segmentow
);

CREATE TABLE segments_set (
	id SERIAL PRIMARY KEY,
	metadata text
);