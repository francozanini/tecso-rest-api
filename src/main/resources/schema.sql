CREATE TRIGGER cuit 
BEFORE UPDATE 
ON legal_person
CALL '.coop.tecso.examen.triggers.CuitTrigger'
