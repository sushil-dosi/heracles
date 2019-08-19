package com.example.demo.servicetest;

import com.example.demo.controller.MainController;
import com.example.demo.service.MainService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceTest {

    @InjectMocks
    private MainService mainService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void convertEmptyNumberErrorTest() {
        String input = "";
        String expectedResult = "Input cannot be empty";
        String result = mainService.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }

    @Test
    public void convertNullNumberErrorTest() {
        String input = null;
        String expectedResult = "Input cannot be empty";
        String result = mainService.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }

    @Test
    public void convertPositiveNumberTest() {
        String input = "2310000.159897";
        String expectedResult = "2 310 000.16";
        String result = mainService.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }

    @Test
    public void convertLongPositiveNumberTest() {
        String input = "2938478927345839624018972034572934680710237489027349610230417320847012374." +
                "90812734780237401273041237407102374829374089712034701730712347012304";
        String expectedResult = "2 938 478 927 345 839 624 018 972 034 572 934 680 710 237 489 027 349 610 230 417 320 847 012 374.91";
        String result = mainService.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }

    @Test
    public void convertPositiveNumberWithoutDecimalTest() {
        String input = "1600";
        String expectedResult = "1 600.00";
        String result = mainService.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }

    @Test
    public void convertNegativeNumberTest() {
        String input = "-2310000.159897";
        String expectedResult = "-2 310 000.16";
        String result = mainService.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }

    @Test
    public void convertNumberWithStringErrorTest() {
        String input = "$2310000.159897";
        String expectedResult = "NumberFormatException";
        String result = mainService.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }

    @Test
    public void convertSimpleStringErrorTest() {
        String input = "asdf7";
        String expectedResult = "NumberFormatException";
        String result = mainService.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }

    @Test
    public void convertStringWithNumberErrorTest() {
        String input = "5343523.32323dd";
        String expectedResult = "NumberFormatException";
        String result = mainService.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }
}
