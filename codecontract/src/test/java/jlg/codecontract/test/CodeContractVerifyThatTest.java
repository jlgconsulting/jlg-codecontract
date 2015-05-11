package jlg.codecontract.test;

import jlg.codecontract.CodeContractException;
import org.junit.Test;

import static jlg.codecontract.CodeContract.verifyThat;

public class CodeContractVerifyThatTest {

    @Test
    public void when_condition_is_true_should_not_throw_exception(){
        //arrange
        boolean someTrueCondition = true;

        //act
        verifyThat(someTrueCondition);
    }

    @Test(expected = CodeContractException.class)
    public void when_condition_is_false_should_throw_exception(){
        //arrange
        boolean someFalseCondition = false;

        //act
        verifyThat(someFalseCondition);
    }
}
