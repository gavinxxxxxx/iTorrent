package me.gavin.torrent.parser2;

import java.io.IOException;

public class InvalidBtEncodingException extends IOException {
    public static final long serialVersionUID = -1;
    public InvalidBtEncodingException(String message) {
        super(message);
    }
}