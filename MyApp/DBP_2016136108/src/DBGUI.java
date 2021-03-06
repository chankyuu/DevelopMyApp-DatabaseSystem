
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javafx.util.Callback;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DBGUI extends Application {

// data members
	private Connection con = MyConnection.mackConnection();
	private TableView table;
	TreeView<String> tree;
	Button[] buttons;
	Label[] labels;
	TextField[] txt;
	TextArea txtArea; 
	private final String[] btntext = { "clear", "save", "update", "delete", "print", "search" };
	
// Clear button	
private void clearTextFields() {
	int noc = table.getColumns().size();
	for (int i =0; i < txt.length; i++) {
		txt[i].setText(" ");
		
	}
}

// print record using print
private void printBranch() {
	String fileName="C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\reportBranch.jrxml";
	try {
		JasperReport jr = JasperCompileManager.compileReport(fileName);
		JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
		JasperViewer.viewReport(jp, false);
	}
	catch(Exception e) {
		txtArea.appendText("There is a problem in printing report.." + "\n");
		txtArea.appendText(e.getMessage());
	}
	finally {}
}
//print record using print
private void printBuying() {
	String fileName="C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\reportBuying.jrxml";
	try {
		JasperReport jr = JasperCompileManager.compileReport(fileName);
		JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
		JasperViewer.viewReport(jp, false);
	}
	catch(Exception e) {
		txtArea.appendText("There is a problem in printing report.." + "\n");
		txtArea.appendText(e.getMessage());
	}
	finally {}
}
//print record using print
private void printContain() {
	String fileName="C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\reportContain.jrxml";
	try {
		JasperReport jr = JasperCompileManager.compileReport(fileName);
		JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
		JasperViewer.viewReport(jp, false);
	}
	catch(Exception e) {
		txtArea.appendText("There is a problem in printing report.." + "\n");
		txtArea.appendText(e.getMessage());
	}
	finally {}
}
//print record using print
private void printCustomer() {
	String fileName="C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\reportCustomer.jrxml";
	try {
		JasperReport jr = JasperCompileManager.compileReport(fileName);
		JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
		JasperViewer.viewReport(jp, false);
	}
	catch(Exception e) {
		txtArea.appendText("There is a problem in printing report.." + "\n");
		txtArea.appendText(e.getMessage());
	}
	finally {}
}
//print record using print
private void printStuff() {
	String fileName="C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\reportStuff.jrxml";
	try {
		JasperReport jr = JasperCompileManager.compileReport(fileName);
		JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
		JasperViewer.viewReport(jp, false);
	}
	catch(Exception e) {
		txtArea.appendText("There is a problem in printing report.." + "\n");
		txtArea.appendText(e.getMessage());
	}
	finally {}
}

// delete record using Stored Procedure
private void deleteBranchSP() {
	String sql = "{call sp_deleteBranch(?)}";
	
	try {
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());
		cst.execute();
		
		System.out.println(" record(s) are deleted...");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

//delete record using Stored Procedure
private void deleteBuyingSP() {
	String sql = "{call sp_deleteBuying(?)}";
	
	try {
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());
		cst.execute();
		
		System.out.println(" record(s) are deleted...");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

//delete record using Stored Procedure
private void deleteContainSP() {
	String sql = "{call sp_deleteContain(?)}";
	
	try {
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());
		cst.execute();
		
		System.out.println(" record(s) are deleted...");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}
//delete record using Stored Procedure
private void deleteCustomerSP() {
	String sql = "{call sp_deleteCustomer(?)}";
	
	try {
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());
		cst.execute();
		
		System.out.println(" record(s) are deleted...");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}
//delete record using Stored Procedure
private void deleteStuffSP() {
	String sql = "{call sp_deleteStuff(?)}";
	
	try {
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());
		cst.execute();
		
		System.out.println(" record(s) are deleted...");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

// update Record using Store Procedure
private void updateBranchSP() {
	String sql = "{call sp_updateBranch(?,?,?)}";
	try {
		// PreparedStatement 는 addBranchIS에서 사용(단지 Insert 할 띠ㅐ에)
		//PreparedStatement pst = con.prepareStatement(sql);
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					// Branch 테이블에는 3개의 밸류가 있음
		cst.setString(2,  txt[1].getText());					
		cst.setString(3,  txt[2].getText());					// setString의 index는 1부터 시작
		
		//pst.executeUpdate();	//  addBranchIS에서 (INSERT, DELETE, UPDATE), 
		cst.execute();			// 
		System.out.println(" record(s) are updated...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

//update Record using Store Procedure
private void updateBuyingSP() {
	String sql = "{call sp_updateBuying(?,?)}";
	try {
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					
		cst.setString(2,  txt[1].getText());					

		cst.execute();			
		System.out.println(" record(s) are updated...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

//update Record using Store Procedure
private void updateContainSP() {
	String sql = "{call sp_updateContain(?,?,?)}";
	try {
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					
		cst.setString(2,  txt[1].getText());
		cst.setString(3,  txt[2].getText());	

		cst.execute();			// 
		System.out.println(" record(s) are updated...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}
//update Record using Store Procedure
private void updateCustomerSP() {
	String sql = "{call sp_updateCustomer(?,?,?,?)}";
	try {
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					
		cst.setString(2,  txt[1].getText());
		cst.setString(3,  txt[2].getText());
		cst.setString(4,  txt[3].getText());	
 
		cst.execute();			
		System.out.println(" record(s) are updated...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}
//update Record using Store Procedure
private void updateStuffSP() {
	String sql = "{call sp_updateStuff(?,?,?)}";
	try {
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					
		cst.setString(2,  txt[1].getText());
		cst.setString(3,  txt[2].getText());	

		cst.execute();			
		System.out.println(" record(s) are updated...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

// Insert Record using Stored Procedure (Stored Procedure을 이용한 Insert 스토 프로시져가 더 잘 쓰이는 듯), SP를 내 앱의 모든 테이블에 대해서 만들기
private void addBranchSP() {
	String sql = "{call sp_insertBranch(?,?,?)}";
	try {
		// PreparedStatement 는 addBranchIS에서 사용(단지 Insert 할 때에)
		//PreparedStatement pst = con.prepareStatement(sql);
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					// Branch 테이블에는 4개의 밸류가 있음
		cst.setString(2,  txt[1].getText());					// branchNo, street, city, postcode	
		cst.setString(3,  txt[2].getText());					// setString의 index는 1부터 시작
		
		//pst.executeUpdate();	//  addBranchIS에서 (INSERT, DELETE, UPDATE), 
		cst.execute();			// 
		System.out.println(" record(s) are added...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

//Insert Record using Stored Procedure
private void addBuyingSP() {
	String sql = "{call sp_insertBuying(?,?)}";
	try {
		// PreparedStatement 는 addBranchIS에서 사용(단지 Insert 할 띠ㅐ에)
		//PreparedStatement pst = con.prepareStatement(sql);
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					
		cst.setString(2,  txt[1].getText());					

		cst.execute();			// 
		System.out.println(" record(s) are added...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

//Insert Record using Stored Procedure
private void addContainSP() {
	String sql = "{call sp_insertContain(?,?,?)}";
	try {
		// PreparedStatement 는 addBranchIS에서 사용(단지 Insert 할 띠ㅐ에)
		//PreparedStatement pst = con.prepareStatement(sql);
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					
		cst.setString(2,  txt[1].getText());
		cst.setString(3,  txt[2].getText());

		cst.execute();			// 
		System.out.println(" record(s) are added...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

//Insert Record using Stored Procedure
private void addCustomerSP() {
	String sql = "{call sp_insertCustomer(?,?,?,?)}";
	try {
		// PreparedStatement 는 addBranchIS에서 사용(단지 Insert 할 띠ㅐ에)
		//PreparedStatement pst = con.prepareStatement(sql);
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					
		cst.setString(2,  txt[1].getText());
		cst.setString(3,  txt[2].getText());
		cst.setString(4,  txt[3].getText());

		cst.execute();			// 
		System.out.println(" record(s) are added...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

//Insert Record using Stored Procedure
private void addStuffSP() {
	String sql = "{call sp_insertStuff(?,?,?)}";
	try {
		// PreparedStatement 는 addBranchIS에서 사용(단지 Insert 할 띠ㅐ에)
		//PreparedStatement pst = con.prepareStatement(sql);
		CallableStatement cst = con.prepareCall(sql);
		cst.setString(1,  txt[0].getText());					
		cst.setString(2,  txt[1].getText());
		cst.setString(3,  txt[2].getText());

		cst.execute();			// 
		System.out.println(" record(s) are added...");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {}
}

// 아주중요! (이 함수는 데이터베이스로부터 값을 가져와 GUI에 표시하는 것임)
private void rsToTableView(String s) {
		
		if(s.equals("About")) {
			
		}
		else {
			table.getColumns().clear();
			for ( int i = 0; i<table.getItems().size(); i++) {
			   table.getItems().clear();
			}
			
			ObservableList data = FXCollections.observableArrayList();
			try {
				String query = "select * from " + s + "";
				PreparedStatement pst = null;
				pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
	
				ResultSetMetaData rsmd = rs.getMetaData();
	
				int colCount = rsmd.getColumnCount();
	
				// get data rows
	
				for (int i = 0; i < colCount; i++) {
	
					int dataType = rsmd.getColumnType(i + 1);
	
					final int j = i;
					TableColumn col = new TableColumn(rsmd.getColumnName(i + 1));
	
					col.setCellValueFactory(
							new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
								public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
									return new SimpleStringProperty(param.getValue().get(j).toString());
								}
							});
	
					table.getColumns().addAll(col);
				}
				while (rs.next()) { // rs는 행
					ObservableList<String> row = FXCollections.observableArrayList();
					for (int k = 1; k <= colCount; k++) {
						String str1=rs.getString(k);			// k는 열(즉, 1개의 열에 있는 data를 모두 가져옴)
						if(str1==null)
							str1="null";
						row.add(str1);
					}
					data.add(row);
				}
	
				table.setItems(data);
	
				table.getSelectionModel().select(0);
				//showFields();
	
			} catch (Exception e) {
				txtArea.appendText(e.getMessage());
			} finally {
			}
		}
	}

	private void showFields() {
		clearFields();
		TablePosition pos = (TablePosition)table.getSelectionModel().getSelectedCells().get(0);
		System.out.println(table.getSelectionModel().getSelectedItem());
		int row = pos.getRow();
		int cols = table.getColumns().size();
		
		for(int j=0; j<cols; j++) {
			Object ch= ((TableColumnBase)table.getColumns().get(j)).getText();
			Object cell = ((TableColumnBase)table.getColumns().get(j)).getCellData(row).toString();
			
			if(cell==null) {txt[j].setText("");}
			else {
				txt[j].setText(cell.toString());
				txt[j].setVisible(true);
			}
			labels[j].setText(ch.toString());
			labels[j].setVisible(true);
		}
		
	}
	
	private void clearFields() {
		for(int i=0; i<txt.length;i++) {
			txt[i].setText("");
			txt[i].setVisible(false);
			labels[i].setText("");
			labels[i].setVisible(false);
		}
	}

// it returns selected node string 
	private String mySelectedNode() {
		
		TreeItem<String> ti=tree.getSelectionModel().selectedItemProperty().getValue();
		return ti.getValue().toString();
	}
	
// function members
	private HBox addCenterPane() {
		
		HBox hb1 = new HBox();
		
		// Add TableView
		VBox vb = new VBox();

		table = new TableView<>();
		table.setMinSize(700, 150);
		table.setMaxSize(700, 150);
		table.setStyle("-fx-border-color: Black;");
		table.prefWidthProperty().bind(vb.prefWidthProperty());
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);	// 1개 열만 선택하게끔
		table.getSelectionModel().setCellSelectionEnabled(false);
		
		table.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldValue, newValue)->{
				if(oldValue!=newValue)
					showFields();
		});
		// Add Labels and TextFields
		GridPane  gp = new GridPane (); 
		gp.setPadding(new Insets(15, 15, 15, 125));
		gp.setHgap(10);
		gp.setVgap(10);
		gp .setStyle("-fx-border-color: Blue;");
		gp.prefHeightProperty().bind(table.prefWidthProperty());
		  txt=new TextField[10]; 
		  labels= new Label[10];
		  
		  for (int i = 0; i < labels.length; i++) { 
			  labels[i]= new Label("Label..");
			  labels[i].setMinSize(150, 25);
		      txt[i]= new TextField(" Text.. "); 
		      txt[i].setMinSize(300, 20);
		      gp.addRow(i, labels[i],txt[i] );
		      labels[i].prefHeightProperty().bind(gp.widthProperty());
		      txt[i].prefHeightProperty().bind(gp.widthProperty());
		   }
	 
		  
		 vb.getChildren().addAll(table, gp);
		
		 // Add TreeView // 창 왼쪽 메뉴
				StackPane stack = new StackPane();

				// Create the tree
				
				tree = addNodestoTree();	// addNodestoTree 함수 보면 내 테이블에 맞춰서 바꿔야함
				tree.setShowRoot(true);
				
				tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
					if(newValue!=oldValue) {
						String str=mySelectedNode();
						txtArea.appendText("You have selected " + str + "\n"); //txtArea에 문제있음
						System.out.println("You have selected " + str + "\n"); // 테스트용
						
						if(str.equals(Nodes.Branch.toString()) ||
								str.equals(Nodes.Buying.toString()) ||
								str.equals(Nodes.Contain.toString()) ||
								str.equals(Nodes.Customer.toString()) ||
								str.equals(Nodes.Stuff.toString()) )
						{
							rsToTableView(str);	// very importatnt
						}
						else if(str.equals(Nodes.About.toString())) {
							MetaData md = new MetaData();
							md.getStage();
						}
					}
				});
			
				tree.setMaxWidth(150);
				tree.prefWidthProperty().bind(stack.prefWidthProperty());
				stack.getChildren().add(tree);

		hb1.getChildren().addAll(stack,vb);
		hb1.setStyle("-fx-border-color:black;");
		hb1.setSpacing(20);
		hb1.prefHeightProperty().bind(vb.prefWidthProperty());
	

		return hb1;
	}
	
	private StackPane addBottomPane() {

		StackPane  stack = new StackPane();
		
		stack.setStyle("-fx-border-color: #336699;");
		txtArea  = new TextArea();
		txtArea.setMaxHeight(200);
		txtArea.prefHeightProperty().bind(stack.prefWidthProperty());
		stack.getChildren().add(txtArea);
		return stack;
	}
	
	private HBox addTopPane() {

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 15, 15, 15));
		hbox.setSpacing(10); // Gap between nodes
		//hbox.setStyle("-fx-background-color: #336699;");
		hbox.setStyle("-fx-border-color: Blue;");
		

		buttons = new Button[6];
		for (int i = 0; i < buttons.length; i++) {

			buttons[i] = new Button(btntext[i]);
			buttons[i].setPrefSize(80, 20);
			buttons[i].prefHeightProperty().bind(hbox.prefWidthProperty());
		}
		
		for (int i = 0; i < buttons.length; i++) {
			final int j=i;
			
			buttons[j].setOnAction((event)->{				 // lambda 함수 
				String tname = mySelectedNode();
				String str = buttons[j].getText();			
				txtArea.appendText("You have selected " + str + "\n");
				
				if("clear".equals(str)) {
					clearTextFields();
				}
				else if("save".equals(str)) {		// save하는 방식은 insert, store procedure, result set 3가지 방법이 있음
					if(tname.equals("Branch")) {			
						addBranchSP();					// Stored Procedure 이용
					}
					else if(tname.equals("Buying"))
						addBuyingSP();
					else if(tname.equals("Contain"))
						addContainSP();
					else if(tname.equals("Customer"))
						addCustomerSP();
					else if(tname.equals("Stuff"))
						addStuffSP();
				}
				else if("update".equals(str)) {
					if(tname.equals("Branch")) 
						updateBranchSP();
					else if(tname.equals("Buying"))
						updateBuyingSP();
					else if(tname.equals("Contain"))
						updateContainSP();
					else if(tname.equals("Customer"))
						updateCustomerSP();
					else if(tname.equals("Stuff"))
						updateStuffSP();
				}
				else if("delete".equals(str)) {
					if(tname.equals("Branch"))
						deleteBranchSP();
					else if(tname.equals("Buying"))
						deleteBuyingSP();
					else if(tname.equals("Contain"))
						deleteContainSP();
					else if(tname.equals("Customer"))
						deleteCustomerSP();
					else if(tname.equals("Stuff"))
						deleteStuffSP();
				}
				else if("print".equals(str)) {
					if(tname.equals("Branch"))
						printBranch();
					else if(tname.equals("Buying"))
						printBuying();
					else if(tname.equals("Contain"))
						printContain();
					else if(tname.equals("Customer"))
						printCustomer();
					else if(tname.equals("Stuff"))
						printStuff();
				}
			
			});
		}
		hbox.getChildren().addAll(buttons);

		return hbox;
	}

	

private  TreeView<String> addNodestoTree() {
    	TreeView<String> tree = new TreeView<String>();
    	
    	TreeItem<String> root, tables, reports, exit, about;
    	
    		root = new TreeItem<String>("ConvenienceStore");
    		
    		tables = new TreeItem<String>("Tables");
    		
    		makeChild(Nodes.Branch.toString(), tables);
    		makeChild(Nodes.Buying.toString(), tables);
    		makeChild(Nodes.Contain.toString(), tables);
    		makeChild(Nodes.Customer.toString(), tables);
    		makeChild(Nodes.Stuff.toString(), tables);
     		
    		reports = new TreeItem<String>("Reports");
    		makeChild(Nodes.Report01.toString(), reports);
    		makeChild(Nodes.Report02.toString(), reports);
    		makeChild(Nodes.Report03.toString(), reports);
    		
    		exit = new TreeItem<String>(Nodes.Exit.toString());
    		about=  new TreeItem<String>(Nodes.About.toString());
     		root.getChildren().addAll(tables,reports, exit, about);
    	    tree.setRoot(root);
         return tree;

    }	
    
	// Create child
	private TreeItem<String> makeChild(String title, TreeItem<String> parent) {
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(false);
		parent.getChildren().add(item);
		return item;
	}


	@Override
	public void start(Stage stage) {

		// Add controls and Layouts
		
		VBox vbox = new VBox();
		vbox.setSpacing(20);
		vbox.setMinSize(900, 500);
		vbox.setMaxSize(1200, 700);
		vbox.setPadding(new Insets(15, 15, 15, 15));
		vbox.setSpacing(10); // Gap between nodes
		vbox.setStyle("-fx-border-color: Black;");
		// Top Box
		HBox tbox=addTopPane();
		tbox.prefHeightProperty().bind(vbox.prefWidthProperty());
		vbox.getChildren().add(tbox);
		
		// Center box
		HBox cbox=addCenterPane();
		cbox.prefHeightProperty().bind(vbox.prefWidthProperty());
		vbox.getChildren().add(cbox);
			
		StackPane bbox=addBottomPane();
		addBottomPane().prefHeightProperty().bind(vbox.prefWidthProperty());
		vbox.getChildren().add(bbox);

		//create and show stage 

		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.setTitle("Convenience Store");
		stage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

}
