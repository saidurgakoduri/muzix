package com.stackroute.muzix.exception;

import com.stackroute.muzix.domain.Track;

public class TrackNotFoundException extends Exception{
    private  String message;

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public TrackNotFoundException(){

    }

}
