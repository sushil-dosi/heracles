package com.example.demo.controllertest;

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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    @InjectMocks
    private MainController mainController;

    @Mock
    private MainService mainService;

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void convertPositiveNumberTest() {
        String input = "1234.456";
        String expectedResult = "1 234.46";
        Mockito.when(mainService.convert(input)).thenReturn(expectedResult);
        String result = mainController.convert(input);

        assertThat(result, notNullValue());
        assertThat(result, containsString(expectedResult));
    }
}
