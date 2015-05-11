package jlg.codecontract.test;

import jlg.codecontract.CodeContractException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static jlg.codecontract.CodeContract.verifyRegex;

@RunWith(JUnitParamsRunner.class)
public class CodeContractVerifyRegexTest {
    private String regex;

    @Before
    public void before(){
        String regExMathesAStringStartingWithAAndFollowedByAtLeastOneB = "ab+";
        this.regex = regExMathesAStringStartingWithAAndFollowedByAtLeastOneB;
    }

    @Test
    @Parameters({"ab","abb","abc","abbbd"})
    public void when_value_matches_regex_should_not_thorw(String value){
        verifyRegex(value, this.regex);
    }

    @Test(expected = CodeContractException.class)
    @Parameters({"ac","bc", "afbb"})
    public void when_value_does_not_match_regex_should_thorw(String value){
        verifyRegex(value, this.regex);
    }
}
