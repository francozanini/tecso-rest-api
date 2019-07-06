package coop.tecso.examen.responses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public abstract class AppResponse {
	private Boolean success;
    private List<String> fullMessages;
    protected LocalDateTime timestamp;
    protected HttpStatus status;

    public Boolean getSuccess() {
        return success;
    }

    public List<String> getFullMessages() {
        return fullMessages;
    }

    public void setFullMessages(List<String> fullMessages) {
        this.fullMessages = fullMessages;
    }

    public AppResponse() {
        System.out.println("Created AppResponse");
    }

    protected AppResponse(boolean success) {
    	this.timestamp = LocalDateTime.now();
        this.success = success;
        fullMessages = new ArrayList<>();
    }

	public boolean isSuccess() {
        return success;
    }


    protected void addFullMessage(String message) {
        if (message == null)
            return;
        if (fullMessages == null)
            fullMessages = new ArrayList<>();

        fullMessages.add(message);
    }

	
}
