package jlg.codecontract.test;

import jlg.codecontract.CodeContractException;
import org.junit.Test;

import static jlg.codecontract.CodeContract.verifyNotNull;

public class CodeContractVerifyNotNullTest {
    @Test
    public void when_object_is_not_null_should_not_throw(){
        verifyNotNull(new Object());
    }

    @Test(expected = CodeContractException.class)
    public void when_object_is_null_should_throw(){
        verifyNotNull(null);
    }
}
