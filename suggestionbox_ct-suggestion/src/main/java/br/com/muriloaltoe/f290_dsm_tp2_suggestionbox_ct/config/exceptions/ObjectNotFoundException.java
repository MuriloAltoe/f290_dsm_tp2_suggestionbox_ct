package br.com.muriloaltoe.f290_dsm_tp2_suggestionbox_ct.config.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
