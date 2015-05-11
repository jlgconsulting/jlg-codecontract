package jlg.codecontract;

/**
 * Custom runtime exception that is thrown each time a code contract is violated. The exception needs to be
 * a runtime one in order to not force the user to write try/catch statements each time a new condition is in place.
 */
public class CodeContractException extends RuntimeException {
    public CodeContractException(){
        super("Code contract condition has been violated. ");
    }

    public CodeContractException(String message){
        super("Code contract condition has been violated. " + message);
    }
}
