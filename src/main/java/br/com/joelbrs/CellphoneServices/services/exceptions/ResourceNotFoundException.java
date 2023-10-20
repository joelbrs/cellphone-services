package br.com.joelbrs.CellphoneServices.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException(Long id) {
        super("ID Not Found: " + id);
    }
}
