package com.FlightJUnitFestSwing.Test;

import com.FlightJUnitFestSwing.HSearchPrice;
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HSearchPriceTest {
	DialogFixture jfDlg; //测试对应的对话框。
	HSearchPrice hsp;
	@Before
	public void init() throws Exception{
		hsp = new HSearchPrice(null);
		jfDlg = new DialogFixture(hsp);
		jfDlg.show();
	}
	@After
	public void destroy() throws Exception{
		hsp.dispose();
		jfDlg.cleanUp();
	}
	public void _set_data(String txtMinPrice,String txtMaxPrice){
		jfDlg.textBox("txtMinPrice").setText(txtMinPrice);
		jfDlg.textBox("txtMaxPrice").setText(txtMaxPrice);
		jfDlg.button("btnSearch").click();
	}

	//验证机票价格是否输入正确。
	//输入机票价格（允许小数，100<=价格<=1800  第一个价格必须小于第二个价格
	//有效，返回true;否则，返回false.
	//使用的测试技术：路径覆盖
	@Test
	public void HSearchPriceTest1(){
		/*
		第一个：&&
		第二个：103
		(第一个Float错误)
		期望：False
		 */
		_set_data("&&","103");
		assertFalse(hsp.GetValidSearch());
	}
	@Test
	public void HSearchPriceTest2(){
		/*
		第一个：1
		第二个：103
		(第一个范围错误)
		期望：False
		 */
		_set_data("1","103");
		assertFalse(hsp.GetValidSearch());
	}
	@Test
	public void HSearchPriceTest3(){
		/*
		第一个：103
		第二个：&&
		(第二个Float错误)
		期望：False
		 */
		_set_data("103","&&");
		assertFalse(hsp.GetValidSearch());
	}
	@Test
	public void HSearchPriceTest4(){
		/*
		第一个：103
		第二个：1
		(第二个范围错误)
		期望：False
		 */
		_set_data("103","1");
		assertFalse(hsp.GetValidSearch());
	}
	@Test
	public void HSearchPriceTest5(){
		/*
		第一个：103
		第二个：101
		(前大后小)
		期望：False
		 */
		_set_data("103","101");
		assertFalse(hsp.GetValidSearch());
	}
	@Test
	public void HSearchPriceTest6(){
		/*
		第一个：101
		第二个：103
		(前大后小)
		期望：True
		 */
		_set_data("101","103");
		assertTrue(hsp.GetValidSearch());
	}
}
