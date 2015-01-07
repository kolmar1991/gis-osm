CREATE OR REPLACE FUNCTION truncate_tables() RETURNS void AS $$
BEGIN
 TRUNCATE pagc_rules;
 TRUNCATE spatial_ref_sys;
 TRUNCATE pagc_lex ;
 TRUNCATE relation_members;
 TRUNCATE pagc_gaz ;
 TRUNCATE street_type_lookup ;
 TRUNCATE way_nodes ;
 TRUNCATE nodes ;
 TRUNCATE ways ;
 TRUNCATE state_lookup;
 TRUNCATE users ;
 TRUNCATE secondary_unit_lookup ;
 TRUNCATE relations   ;
 TRUNCATE direction_lookup  ;
 TRUNCATE loader_lookuptables  ;
 TRUNCATE geocode_settings ;
 TRUNCATE loader_platform  ;
 TRUNCATE loader_variables ;
 TRUNCATE place_lookup;
 TRUNCATE addrfeat  ;
 TRUNCATE zip_lookup_all ;
 TRUNCATE edges ;
 TRUNCATE featnames  ;
 TRUNCATE zip_lookup_base ;
 TRUNCATE addr ;
 TRUNCATE state ;
 TRUNCATE zip_state_loc ;
 TRUNCATE countysub_lookup ;
 TRUNCATE county  ;
 TRUNCATE faces ;
 TRUNCATE county_lookup  ;
 TRUNCATE zcta5  ;
 TRUNCATE tract  ;
 TRUNCATE zip_state ;
 TRUNCATE zip_lookup ;
 TRUNCATE place ;
 TRUNCATE tabblock ;
 TRUNCATE cousub  ;
 TRUNCATE bg  ;
END;
$$ LANGUAGE plpgsql;


