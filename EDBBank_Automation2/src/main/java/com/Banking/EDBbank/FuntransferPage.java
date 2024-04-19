package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FuntransferPage {
	public FuntransferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHomebutton() {
		return homebutton;
	}
	public WebElement getLogoutbutton() {
		return Logoutbutton;
	}
	public WebElement getMyaccountbutton() {
		return Myaccountbutton;
	}
	public WebElement getMyprofile() {
		return Myprofile;
	}
	public WebElement getChangepwd() {
		return changepwd;
	}
	public WebElement getFundTransfer() {
		return FundTransfer;
	}
	public WebElement getStatement() {
		return Statement;
	}
	
	public WebElement getChngapwdopt2() {
		return chngapwdopt2;
	}

	public WebElement getOldpasstext() {
		return oldpasstext;
	}

	public WebElement getConfirmpassfield() {
		return confirmpassfield;
	}

	public WebElement getNewpasswd() {
		return newpasswd;
	}

	public WebElement getPasswrdchange() {
		return passwrdchange;
	}

	public WebElement getaddbeneficiarybutton() {
		return addbeneficiarybutton;
	}

	public WebElement getBeneName() {
		return beneName;
	}

	public WebElement getBeneacnt() {
		return beneacnt;
	}

	public WebElement getIFSCcode() {
		return IFSCcode;
	}

	public WebElement getbenefacnttype() {
		return benefacnttype;
	}

	public WebElement getaddbenef() {
		return addbenef;
	}

	public WebElement getDeletebenef() {
		return deletebenef;
	}

	public WebElement getViewBenef() {
		return ViewBenef;
	}

	public WebElement getGobackbutton() {
		return Gobackbutton;
	}
	

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getDeletbutton() {
		return Deletbutton;
	}
	

	public WebElement getSelectBenef() {
		return SelectBenef;
	}
	public WebElement getRemarks() {
		return remarks;
	}
	public WebElement getTransferamount() {
		return transferamount;
	}
	public WebElement getOtptext() {
		return Otptext;
	}

	public WebElement getFundtransferbutton() {
		return fundtransferbutton;
	}
	public WebElement getOTPverifybutton() {
		return OTPverifybutton;}
		@FindBy(name="oldpass")private WebElement oldpasstext;
		@FindBy(name="cnfrm")private WebElement confirmpassfield;
		@FindBy(name="newpass")private WebElement newpasswd;
		@FindBy(name="change_pass")private WebElement passwrdchange;
		@FindBy(name="add_beneficiary")private WebElement addbenef;
		@FindBy(xpath="//input[@placeholder='Beneficiary Name']")private WebElement beneName;
		@FindBy(xpath="//input[@placeholder='Beneficiary A/c no']")private WebElement beneacnt;
		@FindBy(xpath="//input[@placeholder='IFSC Code']")private WebElement IFSCcode;
		@FindBy(name="beneficiary_acc_type")private WebElement benefacnttype;
		@FindBy(name="add_beneficiary_btn")private WebElement addbeneficiarybutton;
		@FindBy(name="delete_beneficiary")private WebElement deletebenef;
		@FindBy(name="view_beneficiary")private WebElement ViewBenef;
		@FindBy(name="go_back")private WebElement Gobackbutton;
		@FindBy(name="home")private WebElement homebutton;
		@FindBy(name="logout_btn")private WebElement Logoutbutton;
		@FindBy(xpath="//li[text()='My Account']")private WebElement Myaccountbutton;
		@FindBy(xpath="//li[text()='My Profile']")private WebElement Myprofile;
		@FindBy(xpath="//li[text()='Change Password']")private WebElement changepwd;
		@FindBy(xpath="//li[text()='Fund Transfer']")private WebElement FundTransfer;
		@FindBy(xpath="//li[text()='Statement']")private WebElement Statement;
		@FindBy(name="pass-chng")private WebElement chngapwdopt2;
		@FindBy(name="radio")private WebElement radiobutton;
		@FindBy(name="delete_beneficiary")private WebElement Deletbutton;
		@FindBy(name = "beneficiary")private WebElement SelectBenef;
		@FindBy(name="trnsf_amount")private WebElement transferamount;
		@FindBy(name="trnsf_remark")private WebElement remarks;
		@FindBy(name="fnd_trns_btn")private WebElement fundtransferbutton;
		@FindBy(xpath="//input[@placeholder='OTP Code']")private WebElement Otptext;
		@FindBy(name="verify-btn")private WebElement OTPverifybutton;
		
		}
		
		

	
