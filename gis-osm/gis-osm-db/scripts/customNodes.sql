DROP TABLE IF EXISTS custom_nodes;
DROP TABLE IF EXISTS segments;
DROP TABLE IF EXISTS segments_set;

CREATE TABLE custom_nodes (
	custom_node_id SERIAL PRIMARY KEY,
	tags hstore
);

SELECT AddGeometryColumn('custom_nodes', 'geom', 4326, 'POINT', 2);

CREATE TABLE segments (
	segment_id SERIAL PRIMARY KEY,
	point_a integer,
	point_b integer,
	ordinal integer,
	set_id integer 
);

CREATE TABLE segment_set (
	segment_set_id SERIAL PRIMARY KEY,
	metadata text
);
