/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.io.Reader;
import model.Person;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.BankAccount;
import model.Barname;
import model.BoughtGood;
import model.Car;
import model.Good;
import model.PairPriceBank;
import model.Transaction;

/**
 *
 * @author Aardwolf
 */
public class database {
    private static ArrayList<Person> persons = new ArrayList<>();
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Barname> allBarnames = new ArrayList<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static ArrayList<Good> allGoods = new ArrayList<>();
    private static ArrayList<BoughtGood> allBoughtGoods = new ArrayList<>();
    private static Connection conn;
    
    public static void initiate(){
        
        conn = null;
        try {
            // jdbc:postgresql://localhost:5432/Farstarabar [HamidShayesteh on information_schema]
            conn = DriverManager.getConnection(
		"jdbc:postgresql://localhost:5432/Farstarabar", "HamidShayesteh",
		"123456789");

        } catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

	}
        
        if (conn != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
    }
    
        public static ArrayList<BankAccount> getAccounts() {
        ArrayList<BankAccount> bankRes = new ArrayList<>();
        
        try{
            String url = "SELECT * FROM \"public\".\"BankAccount\" ";
            PreparedStatement prep = conn.prepareStatement(url);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                Date initDate = rs.getDate("Initiation");
                int Val = rs.getInt("Value");
                int ID = rs.getInt("ID");
                String bankName = rs.getString("BankName");
                String accountType = rs.getString("AccountType");
                String accountNumber = rs.getString("AccountNumber");
                String cartNumber = rs.getString("CartNumber");
                BankAccount bankX = new BankAccount(bankName, accountType, 
                        accountNumber, cartNumber, initDate.toLocalDate(), Val, false);
                bankX.setID(ID);
                bankRes.add(bankX);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(bankRes.size());
        return bankRes;
    }

    public static int addAccount(BankAccount ba) {
        
        try{
        String url = "INSERT INTO \"public\".\"BankAccount\" (\"Initiation\", \"Value\", \"BankName\", "
                + "\"AccountType\", \"AccountNumber\", \"CartNumber\") VALUES (?, ?, ?, ?, ?,"
                + "?)";
        PreparedStatement prep = conn.prepareStatement(url);
        prep.setDate(1, java.sql.Date.valueOf(ba.getAccountInitiation()));
        prep.setInt(2, ba.getValue());
        prep.setString(3, ba.getBank());
        prep.setString(4, ba.getType());
        prep.setString(5, ba.getAccountNumber());
        prep.setString(6, ba.getCartNumber());
        //System.out.println(prep.toString());
        try{
            prep.executeQuery();
        }catch(Exception e){
        }
        String req = "SELECT \"ID\" FROM \"public\".\"BankAccount\" WHERE \"BankName\" = ? AND \"AccountNumber\" = ?";
        PreparedStatement reqPrep = conn.prepareStatement(req);
        reqPrep.setString(1, ba.getBank());
        reqPrep.setString(2, ba.getAccountNumber());
        ResultSet x = reqPrep.executeQuery();
        //System.out.println("it on :D");
        accounts.add(ba);
        if(x.next()){
            return x.getInt("ID");
        }else
            return -1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -10;
    }
    
    public static BankAccount getAccount(int Id){
        try{
            String url = "SELECT * FROM \"public\".\"BankAccount\" WHERE \"ID\" = ?";
            PreparedStatement prep = conn.prepareStatement(url);
            prep.setInt(1, Id);
            ResultSet rs = prep.executeQuery();
            if(rs.next()){
                Date initDate = rs.getDate("Initiation");
                int Val = rs.getInt("Value");
                int ID = rs.getInt("ID");
                String bankName = rs.getString("BankName");
                String accountType = rs.getString("AccountType");
                String accountNumber = rs.getString("AccountNumber");
                String cartNumber = rs.getString("CartNumber");
                BankAccount bankX = new BankAccount(bankName, accountType, 
                        accountNumber, cartNumber, initDate.toLocalDate(), Val, false);
                bankX.setID(ID);
                return bankX;
            }else
                return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static ObservableList<BankAccount> getObservalbleAccounts(){
        ObservableList<BankAccount> accs = FXCollections.observableArrayList(database.getAccounts());
        return accs;
    }
    
    
    public static void addPerson(Person p) {
        try{
        String url = "INSERT INTO \"public\".\"Person\" (\"firstName\", \"lastName\", \"nationCode\", "
                + "\"phoneNumber\", \"description\", \"brithday\", \"bankAccount\") VALUES (?, ?, ?, ?, ?,"
                + "?, ?)";
        
        PreparedStatement prep = conn.prepareStatement(url);
        prep.setString(1, p.getFirstName());
        prep.setString(2, p.getLastName());
        prep.setString(3, p.getNationCode());
        prep.setString(4, p.getPhoneNumber());
        prep.setString(5, p.getDesc());
        prep.setDate(6, java.sql.Date.valueOf(p.getBirthday()));
        prep.setInt(7, p.getAccount().getID());
        System.out.println(prep.toString());
        prep.executeQuery();
       
        persons.add(p);
        }catch (Exception e){
            //e.printStackTrace();
        }
        
        
    }
    
    public static ObservableList<Person> getObservalblePersons(){
        ObservableList<Person> pr = FXCollections.observableArrayList(database.getPersons());
        return pr;
    }

    public static Person getPerson(int Id){
        
        try{
            String url = "SELECT * FROM \"public\".\"Person\" WHERE \"ID\" = ?";
            PreparedStatement prep = conn.prepareStatement(url);
            prep.setInt(1, Id);
            ResultSet rs = prep.executeQuery();
            
            if(rs.next()){
                String fsName = rs.getString("firstName");
                String lsName = rs.getString("lastName");
                String ntCode = rs.getString("nationCode");
                String phNumber = rs.getString("phoneNumber");
                String descriptioin = rs.getString("description");
                LocalDate birth = rs.getDate("brithday").toLocalDate();
                int ID = rs.getInt("ID");
                int BankID = rs.getInt("bankAccount");
                BankAccount bank = database.getAccount(BankID);
                Person p = new Person(fsName, lsName, ntCode, phNumber, birth, descriptioin, false);
                p.setID(ID);
                p.setAccount(bank);
//                System.out.println(p.getFirstName());
                return p;
            }
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    public static ArrayList<Person> getPersons() {
        ArrayList<Person> resPerson = new ArrayList<>();
        try{
            String url = "SELECT * FROM \"public\".\"Person\" ";
            PreparedStatement prep = conn.prepareStatement(url);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                String fsName = rs.getString("firstName");
                String lsName = rs.getString("lastName");
                String ntCode = rs.getString("nationCode");
                String phNumber = rs.getString("phoneNumber");
                String descriptioin = rs.getString("description");
                LocalDate birth = rs.getDate("brithday").toLocalDate();
                int ID = rs.getInt("ID");
                int BankID = rs.getInt("bankAccount");
                BankAccount bank = database.getAccount(BankID);
                Person p = new Person(fsName, lsName, ntCode, phNumber, birth, descriptioin, false);
                p.setID(ID);
                p.setAccount(bank);
                resPerson.add(p);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return resPerson;
    }
    
    public static int addCar(Car c) {
        try{
            String url = "INSERT INTO \"public\".\"Car\" (\"PelakNumber\", \"PelakSeries\", \"EnsuranceCode\", "
                + "\"EnsuranceStart\", \"EnsuranceFinish\", \"ITINumber\", \"ITIFinish\", "
                    + "\"MeasuranceCode\", \"description\") VALUES (?, ?, ?, ?, ?,"
                + "?, ?, ?, ?)";
            
            PreparedStatement prep = conn.prepareStatement(url);
            prep.setString(1, c.getPelakNumber());
            prep.setString(2, c.getPelakSeries());
            prep.setString(3, c.getEnsuranceCode());
            prep.setDate(4, java.sql.Date.valueOf(c.getStartDate()));
            prep.setDate(5, java.sql.Date.valueOf(c.getFinishDate()));
            prep.setString(6, c.getITINumber());
            prep.setDate(7, java.sql.Date.valueOf(c.getITIfinish()));
            prep.setString(8, c.getMeasuranceCode());
            prep.setString(9, c.getDesc());
            prep.executeQuery();
            
            String req = "SELECT \"ID\" FROM \"public\".\"Car\" WHERE \"PelakNumber\" = ? AND \"PelakSeries\" = ?";
            PreparedStatement reqPrep = conn.prepareStatement(req);
            reqPrep.setString(1, c.getPelakNumber());
            reqPrep.setString(2, c.getPelakSeries());
            ResultSet rs = reqPrep.executeQuery();
            if(rs.next()){
                int ID = rs.getInt("ID");
                c.setID(ID);
                return ID;
            }else{
                return -1;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        //cars.add(c);
        return -10;

    }
    
    public static Car getCar(int Id){
        try{
            String url = "SELECT * FROM \"public\".\"Car\" WHERE \"ID\" = ?";
            PreparedStatement prep = conn.prepareStatement(url);
            prep.setInt(1, Id);
//            System.out.println(prep.toString());
            ResultSet rs = prep.executeQuery();
            
            if(rs.next()){
                
                String pnumber = rs.getString("PelakNumber");
                String pseries = rs.getString("PelakSeries");
                String ecode = rs.getString("EnsuranceCode");
                LocalDate estart = rs.getDate("EnsuranceStart").toLocalDate();
                LocalDate efinish = rs.getDate("EnsuranceFinish").toLocalDate();
                String ITInumber = rs.getString("ITINumber");
                LocalDate itifinish = rs.getDate("ITIFinish").toLocalDate();
                String MeasuranceCode = rs.getString("MeasuranceCode");
                String desc = rs.getString("description");
                int ID = rs.getInt("ID");
                
                Car c = new Car(pnumber, pseries, ecode, estart, efinish, 
                        ITInumber, itifinish, MeasuranceCode, null, desc, false);
                c.setID(ID);
                return c;
                // we should find driver first!
            }
                
            
        }catch(Exception e){
            return null;
        }
        return null;
    }
    
    public static ArrayList<Car> getCars() {
        ArrayList<Car> resCar = new ArrayList<>();
        try{
            String url = "SELECT * FROM \"public\".\"Car\"";
            PreparedStatement prep = conn.prepareStatement(url);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                String pnumber = rs.getString("PelakNumber");
                String pseries = rs.getString("PelakSeries");
                String ecode = rs.getString("EnsuranceCode");
                LocalDate estart = rs.getDate("EnsuranceStart").toLocalDate();
                LocalDate efinish = rs.getDate("EnsuranceFinish").toLocalDate();
                String ITInumber = rs.getString("ITINumber");
                LocalDate itifinish = rs.getDate("ITIFinish").toLocalDate();
                String MeasuranceCode = rs.getString("MeasuranceCode");
                String desc = rs.getString("description");
                int ID = rs.getInt("ID");
                Car c = new Car(pnumber, pseries, ecode, estart, efinish, 
                        ITInumber, itifinish, MeasuranceCode, null, desc, false);
                c.setID(ID);
                resCar.add(c);
            }
            
        }catch(Exception e){
        
        }
        return resCar;
        //return cars;
    }
    
    public static ObservableList<Car> getObservableCars(){
        ObservableList<Car> crs = FXCollections.observableArrayList(database.getCars());
        return crs;
    }

    public static int addBarname(Barname b) {
        //allBarnames.add(b);
        
        
        try{
            String url = "INSERT INTO \"public\".\"Barname\" (\"creationDate\", "
                    + "\"Car\", \"SourceCity\", \"Destination\", "
                    + "\"BijakNumber\", \"Distance\", \"WeightDestination\", "
                    + "\"WeightSource\", \"Price\", \"owner\") VALUES (?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?)";
            PreparedStatement prep = conn.prepareStatement(url);
            prep.setDate(1, java.sql.Date.valueOf(b.getInitiateDate()));
            prep.setInt(2, b.getCarInc().getID());
            prep.setString(3, b.getSource());
            prep.setString(4, b.getDestination());
            prep.setString(5, b.getBijak());
            prep.setDouble(6, b.getDistance());
            prep.setDouble(7, b.getWeightDest());
            prep.setDouble(8, b.getWeightSource());
            prep.setInt(9, b.getPrice());
            prep.setInt(10, b.getOwner().getID());
            try{
                prep.executeQuery();
            }catch(Exception e){
            }
            String reqUrl = "SELECT ID FROM \"public\".\"Barname\" WHERE BijakNumber = ?";
            PreparedStatement prepReq = conn.prepareStatement(reqUrl);
            prepReq.setString(1, b.getBijak());
            ResultSet rs = prepReq.executeQuery();
            if(rs.next()){
                int id = rs.getInt("ID");
                b.setID(id);
                return id;
            }
            // get id and set to the barname!
            
        }catch(Exception e){
            
            e.printStackTrace();
            return -1;
        }
        return -10;
    }
    
    
    public static ArrayList<Barname> getAllBarnames() {
        ArrayList<Barname> resBar = new ArrayList<>();
        try{
            String url = "SELECT * FROM \"public\".\"Barname\"";
            PreparedStatement prep = conn.prepareStatement(url);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                LocalDate creationDate = rs.getDate("creationDate").toLocalDate();
                int carId = rs.getInt("Car");
                String srcCity = rs.getString("SourceCity");
                String Destination = rs.getString("Destination");
                String bijak = rs.getString("BijakNumber");
                double Distance = rs.getDouble("Distance");
                double WDest = rs.getDouble("WeightDestination");
                double WSrc = rs.getDouble("WeightSource");
                int pp = rs.getInt("Price");
                int Id = rs.getInt("ID");
                int ownerId = rs.getInt("owner");
                Car c = database.getCar(carId);
                Person owner = database.getPerson(ownerId);
                
                Barname b = new Barname(creationDate, c, owner, Destination, bijak,
                        srcCity, Distance, WSrc, WDest, pp, false);
                resBar.add(b);
            }
            return resBar;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return resBar;
        //return allBarnames;
    }

    public static ObservableList<Barname> getObservableAllBarname(){
        ObservableList<Barname> brs = FXCollections.observableArrayList(database.getAllBarnames());
        return brs;
    }
    
    public static void addTransaction(Transaction tr) {
        // first complete transaction table! need some new col
        // for the transaction, first add it to transaction table, then add all 
        // needed shit to the two other tables!
        
        try{
            String url = "INSERT INTO \"public\".\"Transaction\" (\"FactorNumber\","
                    + "\"DateTrans\", \"Ttype\", \"Description\") VALUES (?, ?, ?, ?)";
            PreparedStatement prep = conn.prepareStatement(url);
            prep.setString(1, tr.getFactorNumber());
            prep.setDate(2, java.sql.Date.valueOf(tr.getDateTrans()));
            prep.setString(3, tr.getType());
            prep.setString(4, tr.getDescription());
            
            try{
                prep.executeQuery();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            String reqPrep = "SELECT \"ID\" FROM \"public\".\"Transaction\" WHERE "
                    + "\"FactorNumber\" = ?";
            PreparedStatement req = conn.prepareStatement(reqPrep);
            req.setString(1, tr.getFactorNumber());
            ResultSet rs = req.executeQuery();
            int transId = -1;
            if(rs.next()){
                 transId = rs.getInt("ID");
                tr.setID(transId);
            }
            
            for(int i=0; i<tr.getFromBank().size(); i++){
                PairPriceBank x = tr.getFromBank().get(i);
                int bankId = x.getBank().getID();
                String urlFromTrans = "INSERT INTO \"public\".\"FromTrans\" (\"BankAccount\","
                        + " \"Transaction\", \"Price\") VALUES(?, ?, ?)";
                PreparedStatement FromTransPrep = conn.prepareStatement(urlFromTrans);
                FromTransPrep.setInt(1, bankId);
                FromTransPrep.setInt(2, transId);
                FromTransPrep.setInt(3, x.getPrice());
                try{
                    FromTransPrep.executeQuery();}
                catch(Exception e){
                    e.printStackTrace();
                }
                String reqUrlFromTrans = "SELECT \"ID\" FROM \"public\".\"FromTrans\" "
                        + "WHERE \"Transaction\" = ? AND \"BankAccount\" = ?";
                PreparedStatement getIdFrom = conn.prepareStatement(reqUrlFromTrans);
                getIdFrom.setInt(1, transId);
                getIdFrom.setInt(2, bankId);
                ResultSet getRs = getIdFrom.executeQuery();
                if(getRs.next()){
                    int transFrom = getRs.getInt("ID");
                    x.setID(transFrom);
                }
            }
                    
            for(int i=0; i<tr.getToBank().size(); i++){
                PairPriceBank x = tr.getToBank().get(i);
                int bankId = x.getBank().getID();
                String urlToTrans = "INSERT INTO \"public\".\"ToTrans\" (\"BankAccount\","
                        + " \"Transaction\", \"Price\") VALUES(?, ?, ?)";
                PreparedStatement ToTransPrep = conn.prepareStatement(urlToTrans);
                ToTransPrep.setInt(1, bankId);
                ToTransPrep.setInt(2, transId);
                ToTransPrep.setInt(3, x.getPrice());
                try{
                ToTransPrep.executeQuery();}
                catch(Exception e){
                    e.printStackTrace();
                }
                String reqUrlToTrans = "SELECT \"ID\" FROM \"public\".\"FromTrans\" "
                        + "WHERE \"Transaction\" = ? AND \"BankAccount\" = ?";
                PreparedStatement getIdTo = conn.prepareStatement(reqUrlToTrans);
                getIdTo.setInt(1, transId);
                getIdTo.setInt(2, bankId);
                ResultSet getRs = getIdTo.executeQuery();
                if(getRs.next()){
                    int transTo = getRs.getInt("ID");
                    x.setID(transTo);
                }
            }
            
                    
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        transactions.add(tr);
    }
    
    public static Transaction getTrans(int id){
        
        try{
            String url = "SELECT * FROM \"public\".\"Transaction\" WHERE \"ID\" = ?";
            PreparedStatement prep = conn.prepareStatement(url);
            prep.setInt(1, id);
            ResultSet x = prep.executeQuery();
            x.next();
            String ftn = x.getString("FactorNumber");
            Date dd = x.getDate("DateTrans");
            String ttype = x.getString("Ttype");
            String Description = x.getString("Description");
            
            
            ArrayList<PairPriceBank> fromBank = new ArrayList<>();
            ArrayList<PairPriceBank> toBank = new ArrayList<>();
            
            String FromUrl = "SELECT * FROM \"public\".\"FromTrans\" WHERE \"Transaction\" = ?";
            PreparedStatement FromPrep = conn.prepareStatement(FromUrl);
            FromPrep.setInt(1, id);
            ResultSet rsFrom = FromPrep.executeQuery();
            while(rsFrom.next()){
                int pr = rsFrom.getInt("Price");
                int bankId = rsFrom.getInt("BankAccount");
                int PrId = rsFrom.getInt("ID");
                PairPriceBank prx = new PairPriceBank(pr, database.getAccount(bankId));
                prx.setID(PrId);
                fromBank.add(prx);
            }
            
            
            
            String ToUrl = "SELECT * FROM \"public\".\"ToTrans\" WHERE \"Transaction\" = ?";
            PreparedStatement ToPrep = conn.prepareStatement(ToUrl);
            ToPrep.setInt(1, id);
            ResultSet rsTo = ToPrep.executeQuery();
            while(rsTo.next()){
                int pr = rsTo.getInt("Price");
                int bankId = rsTo.getInt("BankAccount");
                int PrId = rsTo.getInt("ID");
                PairPriceBank prx = new PairPriceBank(pr, database.getAccount(bankId));
                prx.setID(PrId);
                toBank.add(prx);
            }
            
            Transaction res = new Transaction(toBank, fromBank, ttype, id,
                    dd.toLocalDate(), Description, ftn, false);
            return res;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> resTrans = new ArrayList<>();
        try{
            String url = "SELECT * FROM \"public\".\"Transaction\"";
            PreparedStatement prep = conn.prepareStatement(url);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                
                int x = rs.getInt("ID");
                resTrans.add(database.getTrans(x));
            }
            return resTrans;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    public static ObservableList<Transaction> getObservableTransactions(){
        ObservableList<Transaction> trs = FXCollections.observableArrayList(database.getTransactions());
        return trs;
    }
    
    
    
    
    
    
    
    
    
    public static ObservableList<Good> getObservableGoods(){
        ObservableList<Good> gd = FXCollections.observableArrayList(database.getGoods());
        return gd;
    }
    
    public static ArrayList<Good> getGoods(){
        return allGoods;
    }
    
    public static void addGood(Good gd){
        database.allGoods.add(gd);
    }
    

}
