package jlg.codecontract.test;

import jlg.codecontract.CodeContractException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static jlg.codecontract.CodeContract.verifyBetween;

@RunWith(JUnitParamsRunner.class)
public class CodeContractVerifyBetweenTest {

    @Test
    @Parameters({"1","2","3"})
    public void with_int_arg_when_argument_between_limit_should_not_throw(int value){
        //arrange
        int minValue = 1;
        int maxValue = 3;

        //act
        verifyBetween(value,minValue,maxValue);
    }

    @Test(expected = CodeContractException.class)
    @Parameters({"0","4"})
    public void with_int_arg_when_argument_outside_limit_should_throw(int value){
        //arrange
        int minValue = 1;
        int maxValue = 3;

        //act
        verifyBetween(value,minValue,maxValue);
    }

    @Test
    @Parameters({"1.0","2.0","3.0"})
    public void with_double_arg_when_argument_between_limit_should_not_throw(double value){
        //arrange
        double minValue = 1.0;
        double maxValue = 3.0;

        //act
        verifyBetween(value,minValue,maxValue);
    }

    @Test(expected = CodeContractException.class)
    @Parameters({"0.0","4.0"})
    public void with_double_arg_when_argument_outside_limit_should_throw(double value){
        //arrange
        double minValue = 1.0;
        double maxValue = 3.0;

        //act
        verifyBetween(value,minValue,maxValue);
    }
}
