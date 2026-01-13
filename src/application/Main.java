package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			MainPage mb=new MainPage();

			AddBranch ab=new AddBranch();
			DeleteBranch db=new DeleteBranch();
			UpdateBranch ub=new UpdateBranch(); 
			BranchTableView bt=new BranchTableView();
			BranchNAPTable napt=new BranchNAPTable();

			Scene abscene = new Scene(ab.getAll(),400,400);
			Scene dbscene = new Scene(db.getAll(),400,400);
			Scene ubscene = new Scene(ub.getAll(),400,400);
			Scene btscene = new Scene(bt.getAll(),400,400);
			Scene naptscene = new Scene(napt.getAll(),400,400);

			mb.getAb().setOnAction(e->{
				primaryStage.setScene(abscene);
			});
			mb.getDb().setOnAction(e->{
				primaryStage.setScene(dbscene);
			});
			mb.getUb().setOnAction(e->{
				primaryStage.setScene(ubscene);
			});
			mb.getBt().setOnAction(e->{
				primaryStage.setScene(btscene);
			});
			mb.getNapt().setOnAction(e->{
				primaryStage.setScene(naptscene);
			});
			
			AddCategory ac=new AddCategory();
			DeleteCategory dc=new DeleteCategory();
			UpdateCategory uc=new UpdateCategory();
			CategoryTableView catt=new CategoryTableView();
			
			Scene acscene = new Scene(ac.getAll(),400,400);
			Scene dcscene = new Scene(dc.getAll(),400,400);
			Scene ucscene = new Scene(uc.getAll(),400,400);
			Scene cattscene = new Scene(catt.getAll(),400,400);

			mb.getAc().setOnAction(e->{
				primaryStage.setScene(acscene);
			});
			mb.getDc().setOnAction(e->{
				primaryStage.setScene(dcscene);
			});
			mb.getUc().setOnAction(e->{
				primaryStage.setScene(ucscene);
			});
			mb.getCatt().setOnAction(e->{
				primaryStage.setScene(cattscene);
			});
			
			AddCustomer acs=new AddCustomer();
			DeleteCustomer dcs=new DeleteCustomer();
			UpdateCustomer ucs=new UpdateCustomer();
			CustomerTableView ct=new CustomerTableView();

			Scene acsscene = new Scene(acs.getAll(),400,400);
			Scene dcsscene = new Scene(dcs.getAll(),400,400);
			Scene ucsscene = new Scene(ucs.getAll(),400,400);
			Scene ctscene = new Scene(ct.getAll(),400,400);

			mb.getAcs().setOnAction(e->{
				primaryStage.setScene(acsscene);
			});
			mb.getDcs().setOnAction(e->{
				primaryStage.setScene(dcsscene);
			});
			mb.getUcs().setOnAction(e->{
				primaryStage.setScene(ucsscene);
			});
			mb.getCt().setOnAction(e->{
				primaryStage.setScene(ctscene);
			});
			
			AddDoctor ad=new AddDoctor();
			DeleteDoctor dd=new DeleteDoctor();
			UpdateDoctor ud=new UpdateDoctor();
			DoctorTableView dt=new DoctorTableView();

			Scene adscene = new Scene(ad.getAll(),400,400);
			Scene ddscene = new Scene(dd.getAll(),400,400);
			Scene udscene = new Scene(ud.getAll(),400,400);
			Scene dtscene = new Scene(dt.getAll(),400,400);

			mb.getAd().setOnAction(e->{
				primaryStage.setScene(adscene);
			});
			mb.getDd().setOnAction(e->{
				primaryStage.setScene(ddscene);
			});
			mb.getUd().setOnAction(e->{
				primaryStage.setScene(udscene);
			});
			mb.getDt().setOnAction(e->{
				primaryStage.setScene(dtscene);
			});
			
			AddEmployee ae=new AddEmployee();
			DeleteEmployee de=new DeleteEmployee();
			UpdateEmployee ue=new UpdateEmployee();
			EmployeeTableView et=new EmployeeTableView();
			EmployeeBranchTableView ebt=new EmployeeBranchTableView();
			
			Scene aescene = new Scene(ae.getAll(),400,400);
			Scene descene = new Scene(de.getAll(),400,400);
			Scene uescene = new Scene(ue.getAll(),400,400);
			Scene etscene = new Scene(et.getAll(),400,400);
			Scene ebtscene = new Scene(ebt.getAll(),400,400);

			mb.getAe().setOnAction(e->{
				primaryStage.setScene(aescene);
			});
			mb.getDe().setOnAction(e->{
				primaryStage.setScene(descene);
			});
			mb.getUe().setOnAction(e->{
				primaryStage.setScene(uescene);
			});
			mb.getEt().setOnAction(e->{
				primaryStage.setScene(etscene);
			});
			mb.getEbt().setOnAction(e->{
				primaryStage.setScene(ebtscene);
			});
			
			AddIC aic=new AddIC();
			DeleteIC dic=new DeleteIC();
			UpdateIC uic=new UpdateIC();
			InsuranceCompanyTableView ict=new InsuranceCompanyTableView();

			Scene aicscene = new Scene(aic.getAll(),400,400);
			Scene dicscene = new Scene(dic.getAll(),400,400);
			Scene uicscene = new Scene(uic.getAll(),400,400);
			Scene ictscene = new Scene(ict.getAll(),400,400);

			mb.getAic().setOnAction(e->{
				primaryStage.setScene(aicscene);
			});
			mb.getDic().setOnAction(e->{
				primaryStage.setScene(dicscene);
			});
			mb.getUic().setOnAction(e->{
				primaryStage.setScene(uicscene);
			});
			mb.getIct().setOnAction(e->{
				primaryStage.setScene(ictscene);
			});
			
			AddInvoice aiv=new AddInvoice();
			DeleteInvoice div=new DeleteInvoice();
			UpdateInvoice uiv=new UpdateInvoice();
			InvoiceTableView it=new InvoiceTableView();
			
			Scene aivscene = new Scene(aiv.getAll(),400,400);
			Scene divscene = new Scene(div.getAll(),400,400);
			Scene uivscene = new Scene(uiv.getAll(),400,400);
			Scene itscene = new Scene(it.getAll(),400,400);

			mb.getAiv().setOnAction(e->{
				primaryStage.setScene(aivscene);
			});
			mb.getDiv().setOnAction(e->{
				primaryStage.setScene(divscene);
			});
			mb.getUiv().setOnAction(e->{
				primaryStage.setScene(uivscene);
			});
			mb.getIt().setOnAction(e->{
				primaryStage.setScene(itscene);
			});
			
			AddInvoiceItem aivi=new AddInvoiceItem();
			DeleteInvoiceItem divi=new DeleteInvoiceItem();
			UpdateInvoiceItem uivi=new UpdateInvoiceItem();
			InvoiceItemTableView iit=new InvoiceItemTableView();

			Scene aiviscene = new Scene(aivi.getAll(),400,400);
			Scene diviscene = new Scene(divi.getAll(),400,400);
			Scene uiviscene = new Scene(uivi.getAll(),400,400);
			Scene iitscene = new Scene(iit.getAll(),400,400);

			mb.getAivi().setOnAction(e->{
				primaryStage.setScene(aiviscene);
			});
			mb.getDivi().setOnAction(e->{
				primaryStage.setScene(diviscene);
			});
			mb.getUivi().setOnAction(e->{
				primaryStage.setScene(uiviscene);
			});
			mb.getIit().setOnAction(e->{
				primaryStage.setScene(iitscene);
			});
			
			AddIP aip=new AddIP();
			DeleteIP dip=new DeleteIP();
			UpdateIP uip=new UpdateIP();
			InsurancePolicyTableView ipt=new InsurancePolicyTableView();

			Scene aipscene = new Scene(aip.getAll(),400,400);
			Scene dipscene = new Scene(dip.getAll(),400,400);
			Scene uipscene = new Scene(uip.getAll(),400,400);
			Scene iptscene = new Scene(ipt.getAll(),400,400);

			mb.getAip().setOnAction(e->{
				primaryStage.setScene(aipscene);
			});
			mb.getDip().setOnAction(e->{
				primaryStage.setScene(dipscene);
			});
			mb.getUip().setOnAction(e->{
				primaryStage.setScene(uipscene);
			});
			mb.getIpt().setOnAction(e->{
				primaryStage.setScene(iptscene);
			});
			
			AddMedicine amed=new AddMedicine();
			DeleteMedicine dmed=new DeleteMedicine();
			UpdateMedicine umed=new UpdateMedicine();
			MedicineTableView mt=new MedicineTableView();
			MedQTable mebt=new MedQTable();
			MedQTable mebt2=new MedQTable();
			MedStockTable medStock=new MedStockTable();
			SupMedInvTable supMedInv=new SupMedInvTable();
			MedByCat medByCat=new MedByCat();
			MostSoldMedTable most=new MostSoldMedTable();
			
			Scene amedscene = new Scene(amed.getAll(),400,400);
			Scene dmedscene = new Scene(dmed.getAll(),400,400);
			Scene umedscene = new Scene(umed.getAll(),400,400);
			Scene mtscene = new Scene(mt.getAll(),400,400);
			Scene mebtscene = new Scene(mebt.getAll(),400,400);
			Scene mebt2scene = new Scene(mebt2.getAll(),400,400);
			Scene medStockscene = new Scene(medStock.getAll(),400,400);
			Scene supMedInvscene = new Scene(supMedInv.getAll(),400,400);
			Scene medByCatscene = new Scene(medByCat.getAll(),400,400);
			Scene mostscene = new Scene(most.getAll(),400,400);

			mb.getAmed().setOnAction(e->{
				primaryStage.setScene(amedscene);
			});
			mb.getDmed().setOnAction(e->{
				primaryStage.setScene(dmedscene);
			});
			mb.getUmed().setOnAction(e->{
				primaryStage.setScene(umedscene);
			});
			mb.getMt().setOnAction(e->{
				primaryStage.setScene(mtscene);
			});
			mb.getMebt().setOnAction(e->{
				primaryStage.setScene(mebtscene);
			});
			mb.getMebt2().setOnAction(e->{
				primaryStage.setScene(mebt2scene);
			});
			mb.getMedStock().setOnAction(e->{
				primaryStage.setScene(medStockscene);
			});
			mb.getSupMedInv().setOnAction(e->{
				primaryStage.setScene(supMedInvscene);
			});
			mb.getMedByCat().setOnAction(e->{
				primaryStage.setScene(medByCatscene);
			});
			mb.getMostSold().setOnAction(e->{
				primaryStage.setScene(mostscene);
			});
			
			AddPayment apay=new AddPayment();
			DeletePayment dpay=new DeletePayment();
			UpdatePayment upay=new UpdatePayment();
			PaymentTableView payt=new PaymentTableView();

			Scene apayscene = new Scene(apay.getAll(),400,400);
			Scene dpayscene = new Scene(dpay.getAll(),400,400);
			Scene upayscene = new Scene(upay.getAll(),400,400);
			Scene paytscene = new Scene(payt.getAll(),400,400);

			mb.getApay().setOnAction(e->{
				primaryStage.setScene(apayscene);
			});
			mb.getDpay().setOnAction(e->{
				primaryStage.setScene(dpayscene);
			});
			mb.getUpay().setOnAction(e->{
				primaryStage.setScene(upayscene);
			});
			mb.getPayt().setOnAction(e->{
				primaryStage.setScene(paytscene);
			});
			
			AddPerMed apermed=new AddPerMed();
			DeletePerMed dpermed=new DeletePerMed();
			UpdatePerMed upermed=new UpdatePerMed();

			Scene apermedscene = new Scene(apermed.getAll(),400,400);
			Scene dpermedscene = new Scene(dpermed.getAll(),400,400);
			Scene upermedscene = new Scene(upermed.getAll(),400,400);

			mb.getAperMed().setOnAction(e->{
				primaryStage.setScene(apermedscene);
			});
			mb.getDperMed().setOnAction(e->{
				primaryStage.setScene(dpermedscene);
			});
			mb.getUperMed().setOnAction(e->{
				primaryStage.setScene(upermedscene);
			});
			
			AddPre aper=new AddPre();
			DeletePre dper=new DeletePre();
			UpdatePre uper=new UpdatePre();
			PrescriptionTableView pert=new PrescriptionTableView();

			Scene aperscene = new Scene(aper.getAll(),400,400);
			Scene dperscene = new Scene(dper.getAll(),400,400);
			Scene uperscene = new Scene(uper.getAll(),400,400);
			Scene pertscene = new Scene(pert.getAll(),400,400);

			mb.getAper().setOnAction(e->{
				primaryStage.setScene(aperscene);
			});
			mb.getDper().setOnAction(e->{
				primaryStage.setScene(dperscene);
			});
			mb.getUper().setOnAction(e->{
				primaryStage.setScene(uperscene);
			});
			mb.getPert().setOnAction(e->{
				primaryStage.setScene(pertscene);
			});
			
			AddPurchase apur=new AddPurchase();
			DeletePurchase dpur=new DeletePurchase();
			UpdatePurchase upur=new UpdatePurchase();
			PurchaseTableView purt=new PurchaseTableView();

			Scene apurscene = new Scene(apur.getAll(),400,400);
			Scene dpurscene = new Scene(dpur.getAll(),400,400);
			Scene upurscene = new Scene(upur.getAll(),400,400);
			Scene purtscene = new Scene(purt.getAll(),400,400);

			mb.getApur().setOnAction(e->{
				primaryStage.setScene(apurscene);
			});
			mb.getDpur().setOnAction(e->{
				primaryStage.setScene(dpurscene);
			});
			mb.getUpur().setOnAction(e->{
				primaryStage.setScene(upurscene);
			});
			mb.getPurt().setOnAction(e->{
				primaryStage.setScene(purtscene);
			});
			
			AddSupplier asup=new AddSupplier();
			DeleteSupplier dsup=new DeleteSupplier();
			UpdateSupplier usup=new UpdateSupplier();
			SupplierTableView st=new SupplierTableView();
			
			Scene asupscene = new Scene(asup.getAll(),400,400);
			Scene dsupscene = new Scene(dsup.getAll(),400,400);
			Scene usupscene = new Scene(usup.getAll(),400,400);
			Scene stscene = new Scene(st.getAll(),400,400);

			mb.getAsup().setOnAction(e->{
				primaryStage.setScene(asupscene);
			});
			mb.getDsup().setOnAction(e->{
				primaryStage.setScene(dsupscene);
			});
			mb.getUsup().setOnAction(e->{
				primaryStage.setScene(usupscene);
			});
			mb.getSt().setOnAction(e->{
				primaryStage.setScene(stscene);
			});

			AddInventoryItem ain=new AddInventoryItem();
			DeleteInventoryItem din=new DeleteInventoryItem();
			UpdateInventoryItem uin=new UpdateInventoryItem();
			InventoryItemTableView intt=new InventoryItemTableView();
			invQTable intqt=new invQTable();

			Scene ainscene = new Scene(ain.getAll(),400,400);
			Scene dinscene = new Scene(din.getAll(),400,400);
			Scene uinscene = new Scene(uin.getAll(),400,400);
			Scene inttscene = new Scene(intt.getAll(),400,400);
			Scene intqtscene = new Scene(intqt.getAll(),400,400);

			mb.getAin().setOnAction(e->{
				primaryStage.setScene(ainscene);
			});
			mb.getDin().setOnAction(e->{
				primaryStage.setScene(dinscene);
			});
			mb.getUin().setOnAction(e->{
				primaryStage.setScene(uinscene);
			});
			mb.getInnt().setOnAction(e->{
				primaryStage.setScene(inttscene);
			});
			mb.getInnqt().setOnAction(e->{
				primaryStage.setScene(intqtscene);
			});
			mb.getExit().setOnAction(e->{
				primaryStage.close();
			});
			
			Scene scene = new Scene(mb.getAll(),400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			ab.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			db.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			ub.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			ain.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			din.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			uin.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			acs.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dcs.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			ucs.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			ac.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dc.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			uc.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			ad.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dd.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			ud.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			ae.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			de.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			ue.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			aic.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dic.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			uic.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			aiv.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			div.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			uiv.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			aivi.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			divi.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			uivi.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			aip.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dip.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			uip.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			amed.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dmed.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			umed.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			apay.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dpay.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			upay.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			apermed.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dpermed.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			upermed.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			aper.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dper.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			uper.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			apur.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dpur.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			upur.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			
			asup.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dsup.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			usup.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			bt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			mt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			it.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			st.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			iit.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			et.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			ct.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			catt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			dt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			ict.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			ipt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			payt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			pert.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			purt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			intt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			napt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			ebt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			intqt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			mebt.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			mebt2.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			medStock.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			supMedInv.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			medByCat.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			most.getBack().setOnAction(e->{
				primaryStage.setScene(scene);
			});
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
