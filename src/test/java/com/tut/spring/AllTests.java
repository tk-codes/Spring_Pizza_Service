package com.tut.spring;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MapperTest.class, PizzaServiceTest.class, OrderServiceTest.class })
public class AllTests {

}
