package be.afelio.software_academy.spring.chinook.dto;

import java.util.List;

public class ReponseDto<T> {

	private ResponseDtoStatus status;
	private String message;
	private T payload;
	
	public ReponseDto() {}
	
	public ReponseDto(ResponseDtoStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseDtoStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseDtoStatus status) {
		this.status = status;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
}
