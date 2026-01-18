package application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MainPage {
	private Image ph = new Image("bb.jpg");
	private ImageView phVM = new ImageView(ph);

	private MenuBar menuBar = new MenuBar();
	private Menu fileM = new Menu("file");
	private MenuItem readAll = new MenuItem("read all data");

	private Menu exitM = new Menu("exit");
	private MenuItem exit = new MenuItem("exit");

	private Menu branch = new Menu("Branch");
	private MenuItem ab = new MenuItem("add branch");
	private MenuItem db = new MenuItem("delete branch");
	private MenuItem ub = new MenuItem("update branch");

	private MenuItem bt = new MenuItem("Retrieve all pharmacy branches in the system.");
	private MenuItem q5 = new MenuItem("Retrieve all pharmacy branches with their addresses and phone numbers.");

	private Menu cat = new Menu("Category");
	private MenuItem ac = new MenuItem("add category");
	private MenuItem dc = new MenuItem("delete category");
	private MenuItem uc = new MenuItem("update category");
	private MenuItem catt = new MenuItem("Categories");

	private Menu cus = new Menu("Customer");
	private MenuItem acs = new MenuItem("add customer");
	private MenuItem dcs = new MenuItem("delete customer");
	private MenuItem ucs = new MenuItem("update customer");
	private MenuItem ct = new MenuItem("Customers");

	private Menu doctor = new Menu("Doctor");
	private MenuItem ad = new MenuItem("add doctor");
	private MenuItem dd = new MenuItem("delete doctor");
	private MenuItem ud = new MenuItem("update doctor");
	private MenuItem dt = new MenuItem("Doctors");

	private Menu ic = new Menu("Inssurence Company");
	private MenuItem aic = new MenuItem("add inssurence Company");
	private MenuItem dic = new MenuItem("delete inssurence Company");
	private MenuItem uic = new MenuItem("update inssurence Company");
	private MenuItem ict = new MenuItem("Inssurence Companies");

	private Menu in = new Menu("Inventory Item");
	private MenuItem ain = new MenuItem("add inventory item");
	private MenuItem din = new MenuItem("delete inventory item");
	private MenuItem uin = new MenuItem("update inventory item");
	private MenuItem innt = new MenuItem("Inventory Items");

	private Menu iv = new Menu("Invoice");
	private MenuItem aiv = new MenuItem("add invoice");
	private MenuItem div = new MenuItem("delete invoice");
	private MenuItem uiv = new MenuItem("update invoice");
	private MenuItem it = new MenuItem("Invoices");

	private MenuItem q15 = new MenuItem("Retrieve all invoices with their total amounts, dates, and related branch names.");
	private MenuItem q17 = new MenuItem("Retrieve all stored sales transactions with invoice numbers and employee names.");
	private MenuItem q18 = new MenuItem("Retrieve total purchases and total sales for the current month.");
	private MenuItem q19 = new MenuItem("Retrieve total profits and total losses (expired or damaged) in each branch.");
	private MenuItem q20 = new MenuItem("Retrieve the branch that achieved the highest sales and profits.");
	private MenuItem q32 = new MenuItem("Retrieve all medicines sold within a specific time period and their total sales.");
	private MenuItem q33 = new MenuItem("Retrieve a summary report showing each branch’s total sales, profits, and best-selling drugs.");

	private Menu ivi = new Menu("Invoice Item");
	private MenuItem aivi = new MenuItem("add invoice item");
	private MenuItem divi = new MenuItem("delete invoice item");
	private MenuItem uivi = new MenuItem("update invoice item");
	private MenuItem iit = new MenuItem("Invoice Items");
	MenuItem qInvoiceItems = new MenuItem(    "Retrieve all invoice items with invoice number and medicine details"
		);

	private Menu ip = new Menu("Inssurence Policy");
	private MenuItem aip = new MenuItem("add inssurence policy");
	private MenuItem dip = new MenuItem("delete inssurence policy");
	private MenuItem uip = new MenuItem("update inssurence policy");
	private MenuItem ipt = new MenuItem("Inssurence Polices");

	private Menu med = new Menu("Medicine");
	private MenuItem amed = new MenuItem("add medicine");
	private MenuItem dmed = new MenuItem("delete medicine");
	private MenuItem umed = new MenuItem("update medicine");
	private MenuItem mt = new MenuItem("Medicins");

	private MenuItem q4 = new MenuItem("Retrieve all stored medicines in the system.");
	private MenuItem q9 = new MenuItem("Retrieve all stored medicines with their categories, suppliers, and expiry dates.");
	private MenuItem q10 = new MenuItem("Retrieve medicines that are expired or will expire within 30 days.");
	private MenuItem q11 = new MenuItem("Retrieve medicines that are out of stock or have less than 5 items left.");
	private MenuItem q12 = new MenuItem("Retrieve medicines supplied by each supplier along with supply dates.");
	private MenuItem q13 = new MenuItem("Retrieve the number of medicines supplied and their total cost for each    supplier.");
	private MenuItem q14 = new MenuItem("Retrieve medicines grouped by category such as antibiotics and painkillers.");
	private MenuItem q16 = new MenuItem("Retrieve medicines that were sold more than once and the best-selling medicine with total quantities.");

	private MenuItem q24 = new MenuItem("Retrieve all damaged or withdrawn medicines and their quantities by branch.");
	private MenuItem q25 = new MenuItem("Calculate total losses caused by expired and damaged medicines.");

	private Menu pay = new Menu("Payment");
	private MenuItem apay = new MenuItem("add payment");
	private MenuItem dpay = new MenuItem("delete payment");
	private MenuItem upay = new MenuItem("update payment");
	private MenuItem payt = new MenuItem("Payments");

	private Menu perMed = new Menu("Persception Medecein");
	private MenuItem aperMed = new MenuItem("add persception medecein");
	private MenuItem dperMed = new MenuItem("delete persception medecein");
	private MenuItem uperMed = new MenuItem("update persception medecein");
	private MenuItem perMedt = new MenuItem("Persception Medeceins");

	private Menu per = new Menu("Persception");
	private MenuItem aper = new MenuItem("add persception ");
	private MenuItem dper = new MenuItem("delete persception ");
	private MenuItem uper = new MenuItem("update persception ");
	private MenuItem pert = new MenuItem("Persceptions");

	private Menu pur = new Menu("Purchase");
	private MenuItem apur = new MenuItem("add purchase ");
	private MenuItem dpur = new MenuItem("delete purchase ");
	private MenuItem upur = new MenuItem("update purchase ");
	private MenuItem purt = new MenuItem("Purchases");

	private Menu sup = new Menu("Supplier");
	private MenuItem asup = new MenuItem("add supplier ");
	private MenuItem dsup = new MenuItem("delete supplier ");
	private MenuItem usup = new MenuItem("update supplier ");
	private MenuItem st = new MenuItem("Suppliers");
	private MenuItem q21 = new MenuItem("Retrieve supplier names, number of supplied medicines, and supply dates.");
	private MenuItem q22 = new MenuItem("Retrieve suppliers who provided specific medicines within a given time period.");
	private MenuItem q23 = new MenuItem("Retrieve suppliers who made the largest total orders during the last month.");

	private Menu e = new Menu("Employee");
	private MenuItem ae = new MenuItem("add employee ");
	private MenuItem de = new MenuItem("delete employee ");
	private MenuItem ue = new MenuItem("update employee ");
	private MenuItem et = new MenuItem("Employees");

	private MenuItem ebt = new MenuItem("Retrieve employee names, qualification, salaries");

	private MenuItem q6 = new MenuItem("Retrieve employee names, positions, and salaries for each branch.");
	private MenuItem q7 = new MenuItem("Retrieve employees whose salaries are higher than a specific amount or who   work in a selected branch.");
	private MenuItem q8 = new MenuItem("Retrieve the top-selling employees and their total sales.");

	private Menu account = new Menu("Account");
	private MenuItem logout = new MenuItem("Logout");

	private TabPane tabs = new TabPane();
	private Tab tab = new Tab("show");
	private Tab statTab = new Tab("Statistcs System");
	private VBox all = new VBox();

	public MainPage() {

		menuBar.getMenus().addAll(account, fileM, branch, cat, e, cus, doctor, ic, in, iv, ivi, ip, med, pay, per, perMed,
				pur, sup, exitM );

		fileM.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 15;");
		exitM.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");
		tab.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");
		statTab.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		fileM.getItems().addAll(readAll);

		account.getItems().addAll(logout);
		account.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		branch.getItems().addAll(ab, db, ub, bt, q5, q20);
		branch.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		cat.getItems().addAll(ac, dc, uc, catt);
		cat.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		cus.getItems().addAll(acs, dcs, ucs, ct);
		cus.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		doctor.getItems().addAll(ad, dd, ud, dt);
		doctor.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		ic.getItems().addAll(aic, dic, uic, ict);
		ic.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		in.getItems().addAll(ain, din, uin, innt);
		in.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		iv.getItems().addAll(aiv, div, uiv, it, q15, q17, q18, q19, q32, q33);
		iv.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		ivi.getItems().addAll(aivi, divi, uivi, iit);
		ivi.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		ip.getItems().addAll(aip, dip, uip, ipt);
		ip.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		med.getItems().addAll(amed, dmed, umed, mt, q4, q9, q10, q11, q12, q13, q14, q16, q24, q25);
		med.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		pay.getItems().addAll(apay, dpay, upay, payt);
		pay.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		per.getItems().addAll(aper, dper, uper, pert);
		per.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		perMed.getItems().addAll(aperMed, dperMed, uperMed, perMedt);
		perMed.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		pur.getItems().addAll(apur, dpur, upur, purt);
		pur.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		sup.getItems().addAll(asup, dsup, usup, st, q21, q22, q23);
		sup.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		e.getItems().addAll(ae, de, ue, et, ebt, q6, q7, q8);
		e.setStyle("-fx-background-color: #76a5af; -fx-text-fill: #0c343d;-fx-font-weight: bold;-fx-font-size:11px;-fx-background-radius: 25;-fx-border-radius: 25;");

		exitM.getItems().addAll(exit);

		tabs.getTabs().addAll(tab, statTab);
		all.getChildren().addAll(menuBar, tabs);
	}
	public void applyRole(String role) {

		if (role.equals("Admin")) {
			return;
		}

		if (role.equals("Manager")) {
			branch.setVisible(false);
			ic.setVisible(false);
			ip.setVisible(false);
			per.setVisible(false);
			perMed.setVisible(false);
			doctor.setVisible(false);
			return;
		}

		// employee
		if (role.equals("Employee")) {
			branch.setVisible(false);
			cat.setVisible(false);
			cus.setVisible(false);
			doctor.setVisible(false);
			ic.setVisible(false);
			ip.setVisible(false);
			per.setVisible(false);
			perMed.setVisible(false);
			pur.setVisible(false);
			sup.setVisible(false);
			e.setVisible(false);
			in.getItems().removeAll(ain, din, uin);

			return;
		}

		if (role.equals("Customer")) {
			branch.setVisible(false);
			cat.setVisible(false);
			e.setVisible(false);
			cus.setVisible(false);
			doctor.setVisible(false);
			ic.setVisible(false);
			in.setVisible(false);
			ivi.setVisible(false);
			ip.setVisible(false);
			pay.setVisible(false);
			per.setVisible(false);
			perMed.setVisible(false);
			pur.setVisible(false);
			sup.setVisible(false);
			iv.getItems().removeAll(aiv, div, uiv);
			med.getItems().removeAll(amed, dmed, umed);

			return;
		}
	}
	
	public MenuItem getReadAll() {
		return readAll;
	}
	public void setReadAll(MenuItem readAll) {
		this.readAll = readAll;
	}
	public Image getPh() {
		return ph;
	}
	public void setPh(Image ph) {
		this.ph = ph;
	}
	public ImageView getPhVM() {
		return phVM;
	}
	public void setPhVM(ImageView phVM) {
		this.phVM = phVM;
	}
	public MenuBar getMenuBar() {
		return menuBar;
	}
	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}
	public Menu getFileM() {
		return fileM;
	}
	public void setFileM(Menu fileM) {
		this.fileM = fileM;
	}
	
	
	public Menu getExitM() {
		return exitM;
	}
	public void setExitM(Menu exitM) {
		this.exitM = exitM;
	}
	public MenuItem getExit() {
		return exit;
	}
	public void setExit(MenuItem exit) {
		this.exit = exit;
	}
	public Menu getBranch() {
		return branch;
	}
	public void setBranch(Menu branch) {
		this.branch = branch;
	}
	public MenuItem getAb() {
		return ab;
	}
	public void setAb(MenuItem ab) {
		this.ab = ab;
	}
	public MenuItem getDb() {
		return db;
	}
	public void setDb(MenuItem db) {
		this.db = db;
	}
	public MenuItem getUb() {
		return ub;
	}
	public void setUb(MenuItem ub) {
		this.ub = ub;
	}
	public MenuItem getBt() {
		return bt;
	}
	public void setBt(MenuItem bt) {
		this.bt = bt;
	}
	public MenuItem getQ5() {
		return q5;
	}
	public void setQ5(MenuItem q5) {
		this.q5 = q5;
	}
	public Menu getCat() {
		return cat;
	}
	public void setCat(Menu cat) {
		this.cat = cat;
	}
	public MenuItem getAc() {
		return ac;
	}
	public void setAc(MenuItem ac) {
		this.ac = ac;
	}
	public MenuItem getDc() {
		return dc;
	}
	public void setDc(MenuItem dc) {
		this.dc = dc;
	}
	public MenuItem getUc() {
		return uc;
	}
	public void setUc(MenuItem uc) {
		this.uc = uc;
	}
	public MenuItem getCatt() {
		return catt;
	}
	public void setCatt(MenuItem catt) {
		this.catt = catt;
	}
	public Menu getCus() {
		return cus;
	}
	public void setCus(Menu cus) {
		this.cus = cus;
	}
	public MenuItem getAcs() {
		return acs;
	}
	public void setAcs(MenuItem acs) {
		this.acs = acs;
	}
	public MenuItem getDcs() {
		return dcs;
	}
	public void setDcs(MenuItem dcs) {
		this.dcs = dcs;
	}
	public MenuItem getUcs() {
		return ucs;
	}
	public void setUcs(MenuItem ucs) {
		this.ucs = ucs;
	}
	public MenuItem getCt() {
		return ct;
	}
	public void setCt(MenuItem ct) {
		this.ct = ct;
	}
	public Menu getDoctor() {
		return doctor;
	}
	public void setDoctor(Menu doctor) {
		this.doctor = doctor;
	}
	public MenuItem getAd() {
		return ad;
	}
	public void setAd(MenuItem ad) {
		this.ad = ad;
	}
	public MenuItem getDd() {
		return dd;
	}
	public void setDd(MenuItem dd) {
		this.dd = dd;
	}
	public MenuItem getUd() {
		return ud;
	}
	public void setUd(MenuItem ud) {
		this.ud = ud;
	}
	public MenuItem getDt() {
		return dt;
	}
	public void setDt(MenuItem dt) {
		this.dt = dt;
	}
	public Menu getIc() {
		return ic;
	}
	public void setIc(Menu ic) {
		this.ic = ic;
	}
	public MenuItem getAic() {
		return aic;
	}
	public void setAic(MenuItem aic) {
		this.aic = aic;
	}
	public MenuItem getDic() {
		return dic;
	}
	public void setDic(MenuItem dic) {
		this.dic = dic;
	}
	public MenuItem getUic() {
		return uic;
	}
	public void setUic(MenuItem uic) {
		this.uic = uic;
	}
	public MenuItem getIct() {
		return ict;
	}
	public void setIct(MenuItem ict) {
		this.ict = ict;
	}
	public Menu getIn() {
		return in;
	}
	public void setIn(Menu in) {
		this.in = in;
	}
	public MenuItem getAin() {
		return ain;
	}
	public void setAin(MenuItem ain) {
		this.ain = ain;
	}
	public MenuItem getDin() {
		return din;
	}
	public void setDin(MenuItem din) {
		this.din = din;
	}
	public MenuItem getUin() {
		return uin;
	}
	public void setUin(MenuItem uin) {
		this.uin = uin;
	}
	public MenuItem getInnt() {
		return innt;
	}
	public void setInnt(MenuItem innt) {
		this.innt = innt;
	}
	public Menu getIv() {
		return iv;
	}
	public void setIv(Menu iv) {
		this.iv = iv;
	}
	public MenuItem getAiv() {
		return aiv;
	}
	public void setAiv(MenuItem aiv) {
		this.aiv = aiv;
	}
	public MenuItem getDiv() {
		return div;
	}
	public void setDiv(MenuItem div) {
		this.div = div;
	}
	public MenuItem getUiv() {
		return uiv;
	}
	public void setUiv(MenuItem uiv) {
		this.uiv = uiv;
	}
	public MenuItem getIt() {
		return it;
	}
	public void setIt(MenuItem it) {
		this.it = it;
	}
	public MenuItem getQ15() {
		return q15;
	}
	public void setQ15(MenuItem q15) {
		this.q15 = q15;
	}
	public MenuItem getQ17() {
		return q17;
	}
	public void setQ17(MenuItem q17) {
		this.q17 = q17;
	}
	public MenuItem getQ18() {
		return q18;
	}
	public void setQ18(MenuItem q18) {
		this.q18 = q18;
	}
	public MenuItem getQ19() {
		return q19;
	}
	public void setQ19(MenuItem q19) {
		this.q19 = q19;
	}
	public MenuItem getQ20() {
		return q20;
	}
	public void setQ20(MenuItem q20) {
		this.q20 = q20;
	}
	public MenuItem getQ32() {
		return q32;
	}
	public void setQ32(MenuItem q32) {
		this.q32 = q32;
	}
	public MenuItem getQ33() {
		return q33;
	}
	public void setQ33(MenuItem q33) {
		this.q33 = q33;
	}
	public Menu getIvi() {
		return ivi;
	}
	public void setIvi(Menu ivi) {
		this.ivi = ivi;
	}
	public MenuItem getAivi() {
		return aivi;
	}
	public void setAivi(MenuItem aivi) {
		this.aivi = aivi;
	}
	public MenuItem getDivi() {
		return divi;
	}
	public void setDivi(MenuItem divi) {
		this.divi = divi;
	}
	public MenuItem getUivi() {
		return uivi;
	}
	public void setUivi(MenuItem uivi) {
		this.uivi = uivi;
	}
	public MenuItem getIit() {
		return iit;
	}
	public void setIit(MenuItem iit) {
		this.iit = iit;
	}
	public Menu getIp() {
		return ip;
	}
	public void setIp(Menu ip) {
		this.ip = ip;
	}
	public MenuItem getAip() {
		return aip;
	}
	public void setAip(MenuItem aip) {
		this.aip = aip;
	}
	public MenuItem getDip() {
		return dip;
	}
	public void setDip(MenuItem dip) {
		this.dip = dip;
	}
	public MenuItem getUip() {
		return uip;
	}
	public void setUip(MenuItem uip) {
		this.uip = uip;
	}
	public MenuItem getIpt() {
		return ipt;
	}
	public void setIpt(MenuItem ipt) {
		this.ipt = ipt;
	}
	public Menu getMed() {
		return med;
	}
	public void setMed(Menu med) {
		this.med = med;
	}
	public MenuItem getAmed() {
		return amed;
	}
	public void setAmed(MenuItem amed) {
		this.amed = amed;
	}
	public MenuItem getDmed() {
		return dmed;
	}
	public void setDmed(MenuItem dmed) {
		this.dmed = dmed;
	}
	public MenuItem getUmed() {
		return umed;
	}
	public void setUmed(MenuItem umed) {
		this.umed = umed;
	}
	public MenuItem getMt() {
		return mt;
	}
	public void setMt(MenuItem mt) {
		this.mt = mt;
	}
	public MenuItem getQ4() {
		return q4;
	}
	public void setQ4(MenuItem q4) {
		this.q4 = q4;
	}
	public MenuItem getQ9() {
		return q9;
	}
	public void setQ9(MenuItem q9) {
		this.q9 = q9;
	}
	public MenuItem getQ10() {
		return q10;
	}
	public void setQ10(MenuItem q10) {
		this.q10 = q10;
	}
	public MenuItem getQ11() {
		return q11;
	}
	public void setQ11(MenuItem q11) {
		this.q11 = q11;
	}
	public MenuItem getQ12() {
		return q12;
	}
	public void setQ12(MenuItem q12) {
		this.q12 = q12;
	}
	public MenuItem getQ13() {
		return q13;
	}
	public void setQ13(MenuItem q13) {
		this.q13 = q13;
	}
	public MenuItem getQ14() {
		return q14;
	}
	public void setQ14(MenuItem q14) {
		this.q14 = q14;
	}
	public MenuItem getQ16() {
		return q16;
	}
	public void setQ16(MenuItem q16) {
		this.q16 = q16;
	}
	public MenuItem getQ24() {
		return q24;
	}
	public void setQ24(MenuItem q24) {
		this.q24 = q24;
	}
	public MenuItem getQ25() {
		return q25;
	}
	public void setQ25(MenuItem q25) {
		this.q25 = q25;
	}
	public Menu getPay() {
		return pay;
	}
	public void setPay(Menu pay) {
		this.pay = pay;
	}
	public MenuItem getApay() {
		return apay;
	}
	public void setApay(MenuItem apay) {
		this.apay = apay;
	}
	public MenuItem getDpay() {
		return dpay;
	}
	public void setDpay(MenuItem dpay) {
		this.dpay = dpay;
	}
	public MenuItem getUpay() {
		return upay;
	}
	public void setUpay(MenuItem upay) {
		this.upay = upay;
	}
	public MenuItem getPayt() {
		return payt;
	}
	public void setPayt(MenuItem payt) {
		this.payt = payt;
	}
	public Menu getPerMed() {
		return perMed;
	}
	public void setPerMed(Menu perMed) {
		this.perMed = perMed;
	}
	public MenuItem getAperMed() {
		return aperMed;
	}
	public void setAperMed(MenuItem aperMed) {
		this.aperMed = aperMed;
	}
	public MenuItem getDperMed() {
		return dperMed;
	}
	public void setDperMed(MenuItem dperMed) {
		this.dperMed = dperMed;
	}
	public MenuItem getUperMed() {
		return uperMed;
	}
	public void setUperMed(MenuItem uperMed) {
		this.uperMed = uperMed;
	}
	public MenuItem getPerMedt() {
		return perMedt;
	}
	public void setPerMedt(MenuItem perMedt) {
		this.perMedt = perMedt;
	}
	public Menu getPer() {
		return per;
	}
	public void setPer(Menu per) {
		this.per = per;
	}
	public MenuItem getAper() {
		return aper;
	}
	public void setAper(MenuItem aper) {
		this.aper = aper;
	}
	public MenuItem getDper() {
		return dper;
	}
	public void setDper(MenuItem dper) {
		this.dper = dper;
	}
	public MenuItem getUper() {
		return uper;
	}
	public void setUper(MenuItem uper) {
		this.uper = uper;
	}
	public MenuItem getPert() {
		return pert;
	}
	public void setPert(MenuItem pert) {
		this.pert = pert;
	}
	public Menu getPur() {
		return pur;
	}
	public void setPur(Menu pur) {
		this.pur = pur;
	}
	public MenuItem getApur() {
		return apur;
	}
	public void setApur(MenuItem apur) {
		this.apur = apur;
	}
	public MenuItem getDpur() {
		return dpur;
	}
	public void setDpur(MenuItem dpur) {
		this.dpur = dpur;
	}
	public MenuItem getUpur() {
		return upur;
	}
	public void setUpur(MenuItem upur) {
		this.upur = upur;
	}
	public MenuItem getPurt() {
		return purt;
	}
	public void setPurt(MenuItem purt) {
		this.purt = purt;
	}
	public Menu getSup() {
		return sup;
	}
	public void setSup(Menu sup) {
		this.sup = sup;
	}
	public MenuItem getAsup() {
		return asup;
	}
	public void setAsup(MenuItem asup) {
		this.asup = asup;
	}
	public MenuItem getDsup() {
		return dsup;
	}
	public void setDsup(MenuItem dsup) {
		this.dsup = dsup;
	}
	public MenuItem getUsup() {
		return usup;
	}
	public void setUsup(MenuItem usup) {
		this.usup = usup;
	}
	public MenuItem getSt() {
		return st;
	}
	public void setSt(MenuItem st) {
		this.st = st;
	}
	public MenuItem getQ21() {
		return q21;
	}
	public void setQ21(MenuItem q21) {
		this.q21 = q21;
	}
	public MenuItem getQ22() {
		return q22;
	}
	public void setQ22(MenuItem q22) {
		this.q22 = q22;
	}
	public MenuItem getQ23() {
		return q23;
	}
	public void setQ23(MenuItem q23) {
		this.q23 = q23;
	}
	public Menu getE() {
		return e;
	}
	public void setE(Menu e) {
		this.e = e;
	}
	public MenuItem getAe() {
		return ae;
	}
	public void setAe(MenuItem ae) {
		this.ae = ae;
	}
	public MenuItem getDe() {
		return de;
	}
	public void setDe(MenuItem de) {
		this.de = de;
	}
	public MenuItem getUe() {
		return ue;
	}
	public void setUe(MenuItem ue) {
		this.ue = ue;
	}
	public MenuItem getEt() {
		return et;
	}
	public void setEt(MenuItem et) {
		this.et = et;
	}
	public MenuItem getEbt() {
		return ebt;
	}
	public void setEbt(MenuItem ebt) {
		this.ebt = ebt;
	}
	public MenuItem getQ6() {
		return q6;
	}
	public void setQ6(MenuItem q6) {
		this.q6 = q6;
	}
	public MenuItem getQ7() {
		return q7;
	}
	public void setQ7(MenuItem q7) {
		this.q7 = q7;
	}
	public MenuItem getQ8() {
		return q8;
	}
	public void setQ8(MenuItem q8) {
		this.q8 = q8;
	}
	public Menu getAccount() {
		return account;
	}
	public void setAccount(Menu account) {
		this.account = account;
	}
	public MenuItem getLogout() {
		return logout;
	}
	public void setLogout(MenuItem logout) {
		this.logout = logout;
	}
	public TabPane getTabs() {
		return tabs;
	}
	public void setTabs(TabPane tabs) {
		this.tabs = tabs;
	}
	public Tab getTab() {
		return tab;
	}
	public void setTab(Tab tab) {
		this.tab = tab;
	}
	public Tab getStatTab() {
		return statTab;
	}
	public void setStatTab(Tab statTab) {
		this.statTab = statTab;
	}
	public VBox getAll() {
		return all;
	}
	public void setAll(VBox all) {
		this.all = all;
	}
	
}
