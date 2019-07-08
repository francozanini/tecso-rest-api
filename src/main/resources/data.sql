CREATE TRIGGER insert_lp_cuit BEFORE INSERT ON legal_person
    FOR EACH ROW CALL "coop.tecso.examen.triggers.CuitTrigger";
    
CREATE TRIGGER update_lp_cuit BEFORE UPDATE ON legal_person
    FOR EACH ROW CALL "coop.tecso.examen.triggers.CuitTrigger";
    
CREATE TRIGGER insert_np_cuit BEFORE INSERT ON natural_person
    FOR EACH ROW CALL "coop.tecso.examen.triggers.CuitTrigger";
    
CREATE TRIGGER update_np_cuit BEFORE UPDATE ON natural_person
	FOR EACH ROW CALL "coop.tecso.examen.triggers.CuitTrigger";