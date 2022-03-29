package com.empmgmt.dataservice;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

//@SpringBootTest
class DataServiceApplicationTests {

	@Test
	public void whenCreateMock_thenCreated() {
		List mockedList = Mockito.mock(ArrayList.class);

		mockedList.add("one");
		Mockito.verify(mockedList).add("one");

		assertEquals(0, mockedList.size());
	}

	@Test
	public void whenCreateSpy_thenCreate() {
		List spyList = Mockito.spy(new ArrayList());
		spyList.add("one");
		Mockito.verify(spyList).add("one");

		assertEquals(1, spyList.size());
	}

	@Test
	public void whenCreateSpy_thenCreate1() {
		List spyList = Mockito.spy(new ArrayList());

		//stubbing a method
		doReturn(true).when(spyList).add(Mockito.any());

		spyList.add("one");
		Mockito.verify(spyList).add("one");

		assertEquals(0, spyList.size());
	}

}
