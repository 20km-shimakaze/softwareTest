package com.FlightJUnitFestSwing.Test;

import static org.junit.Assert.*;
/*
 * 何海江 for JUnit Fest-Swing GUI测试
 */
import com.FlightJUnitFestSwing.HInputFlight;
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HInputFlightTest {
	DialogFixture jfDlg; //测试对应的对话框。
	HInputFlight hif; //被测对象，能够获取该对象的值。
	@Before
	public void setUp() throws Exception {
		hif = new HInputFlight(null,"测试：输入航班的相关数据");
		jfDlg = new DialogFixture( hif );
		jfDlg.show();
	}

	@After
	public void tearDown() throws Exception {
		hif.dispose();
		jfDlg.cleanUp();
	}
	
	//测试增加一个航班的座位数目
	//使用的测试技术：条件覆盖
	@Test
	public void testSeatForAddFlight1() {
		/*第一个测试用例，测试：座位数不能有0-9以外的字符，也就是	
		 *   在方法private boolean ValidSeat()内
		 *   可以跳到catch(Exception e)里面。
		 *注意：其它输入项必须正确，否则，如何测试ValidSeat	
		 */
		_set_data("93687","YE4002","Hguohang","800.5","126.0");
		assertFalse(hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight2(){
		/*第二个测试用例，测试：座位数不能小于100。
		 *注意：其它输入项必须正确，否则，如何测试ValidSeat
		 */
		_set_data("93687","YE4002","Hguohang","800.5","98");
		assertFalse(hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight3(){
		/*第三个测试用例，测试：座位数不能大于100。
		 *注意：其它输入项必须正确，否则，如何测试ValidSeat
		 */
		_set_data("93687","YE4002","Hguohang","800.5","298");
		assertFalse(hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight4(){
		/*第四个测试用例，测试：座位数不能大于100。
		 *注意：其它输入项必须正确，否则，如何测试ValidSeat
		 */
		_set_data("93687","YE4002","Hguohang","800.5","128");
		assertTrue(hif.GetValidFlight());
	}
	public void _set_data(String txtIDFest,String txtFnameFest,String txtCompanyFest,String txtPriceFest,String txtSeatFest){
		jfDlg.textBox("txtIDFest").setText(txtIDFest);
		jfDlg.textBox("txtFnameFest").setText(txtFnameFest);
		jfDlg.textBox("txtCompanyFest").setText(txtCompanyFest);
		jfDlg.textBox("txtPriceFest").setText(txtPriceFest);
		jfDlg.textBox("txtSeatFest").setText(txtSeatFest);
		jfDlg.button("btnOKFest").click();
	}

	//测试增加一个航班的价格
	//输入机票价格（允许小数，100<=价格<=1800
	//使用的测试技术：条件覆盖
	@Test
	public void validPriceTest(){
		/*
		price=&&
		 */
		_set_data("93687","YE4002","Hguohang","&&&","128");
		assertFalse(hif.GetValidFlight());
	}
	@Test
	public void validPriceTest2(){
		/*
		price=102(100<=price<=1800)
		 */
		_set_data("93687","YE4002","Hguohang","800.5","128");
		assertTrue(hif.GetValidFlight());
	}
	@Test
	public void validPriceTest3(){
		/*
		price=100000(>1800)
		 */
		_set_data("93687","YE4002","Hguohang","1111111","128");
		assertFalse(hif.GetValidFlight());
	}
	@Test
	public void validPriceTest4(){
		/*
		price=1(<100)
		 */
		_set_data("93687","YE4002","Hguohang","1","128");
		assertFalse(hif.GetValidFlight());
	}

	//验证航空公司名称是否输入正确。
	//输入航空公司名称（以H开头，后接5-19个任意字符）
	//有效，返回true;否则，返回false.
	//使用的测试技术：路径覆盖
	@Test
	public void validCompanyTest1(){
		// all true
		_set_data("93687","YE4002","Hguohang","800.5","128");
		assertTrue(hif.GetValidFlight());
	}
	@Test
	public void validCompanyTest2(){
		// com='H'(len<6)
		_set_data("93687","YE4002","H","800.5","128");
		assertFalse(hif.GetValidFlight());
	}
	@Test
	public void validCompanyTest3(){
		// com='A12345'
		_set_data("93687","YE4002","A12345","800.5","128");
		assertFalse(hif.GetValidFlight());
	}
}
