CREATE TRIGGER INV_INS BEFORE INSERT ON legal_person
    FOR EACH ROW CALL "coop.tecso.examen.triggers.CuitTrigger";