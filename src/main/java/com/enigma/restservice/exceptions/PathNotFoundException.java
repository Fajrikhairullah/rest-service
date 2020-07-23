package com.enigma.restservice.exceptions;

public class PathNotFoundException extends ApplicationException {

    public PathNotFoundException() {
        super(ErrorCodes.PATH_NOT_FOUND, "exception.path.not.found");
    }
    
}
