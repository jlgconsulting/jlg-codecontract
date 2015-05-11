package jlg.codecontract.test;

import jlg.codecontract.CodeContractException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jlg.codecontract.CodeContract.verifyNotEmpty;

public class CodeContractVerifyNotEmptyTest {
    @Test
    public void with_string_argument_when_string_is_not_null_or_empty_should_not_throw_exception(){
        //arrange
        String someValidString = "valid";

        //act
        verifyNotEmpty(someValidString);
    }

    @Test(expected = CodeContractException.class)
    public void with_string_argument_when_string_is_null_should_throw_exception(){
        //arrange
        String someInvalidString = null;

        //act
        verifyNotEmpty(someInvalidString);
    }

    @Test(expected = CodeContractException.class)
    public void with_string_argument_when_string_is_empty_should_throw_exception(){
        //arrange
        String someInvalidString = "";

        //act
        verifyNotEmpty(someInvalidString);
    }

    @Test
    public void with_collection_argument_when_collection_is_not_empty_should_not_throw(){
        //arrange
        List someValidList = new ArrayList<>(Arrays.asList(1));

        //act
        verifyNotEmpty(someValidList);
    }


    @Test(expected = CodeContractException.class)
    public void with_collection_argument_when_collection_is_null_should_throw(){
        //arrange
        List someNullCollection = null;

        //act
        verifyNotEmpty(someNullCollection);
    }
    
    @Test(expected = CodeContractException.class)
    public void with_collection_argument_when_collection_is_empty_should_throw(){
        //arrange
        List someEmptyList = new ArrayList<>();

        //act
        verifyNotEmpty(someEmptyList);
    }
}
