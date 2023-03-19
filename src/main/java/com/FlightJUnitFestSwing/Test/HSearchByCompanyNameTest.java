package com.FlightJUnitFestSwing.Test;

import com.FlightJUnitFestSwing.HSearchByCompanyName;
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HSearchByCompanyNameTest {
	HSearchByCompanyName hsn;
	DialogFixture jfDlg;
	@Before
	public void init(){
		hsn = new HSearchByCompanyName(null);
		jfDlg = new DialogFixture(hsn);
		jfDlg.show();
	}
	@After
	public void destroy(){
		hsn.dispose();
		jfDlg.cleanUp();
	}
	public void _set_data(String txtCompanyName){
		jfDlg.textBox("txtCompanyName").setText(txtCompanyName);
		jfDlg.button("btnSearch").click();
	}
	@Test
	public void hSearchByCompanyNameTest1(){
		/*
		name=abcdefggf
		期望：True
		 */
		_set_data("abcdefggf");
		assertTrue(hsn.GetValidSearch());
	}
	@Test
	public void hSearchByCompanyNameTest2(){
		/*
		name=ab
		期望：True
		 */
		_set_data("ab");
		assertFalse(hsn.GetValidSearch());
	}
}
