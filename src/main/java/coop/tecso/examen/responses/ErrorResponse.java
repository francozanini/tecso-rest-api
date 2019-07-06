package coop.tecso.examen.responses;

public class ErrorResponse extends AppResponse {

    public ErrorResponse(String errorMessage) 
    {
        super(false);
        addFullMessage(errorMessage);
    }

}