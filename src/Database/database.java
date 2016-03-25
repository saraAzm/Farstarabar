/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import model.Person;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BankAccount;
import model.Barname;
import model.Car;
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
    
    public static ObservableList<Person> getObservalblePerson(){
        ObservableList<Person> pr = FXCollections.observableArrayList(database.getPersons());
        return pr;
    }
    
    public static ArrayList<Person> getPersons() {
        return persons;
    }

    public static ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public static ArrayList<Barname> getAllBarnames() {
        return allBarnames;
    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
    public static void addPerson(Person p) {
        persons.add(p);
    }

    public static void addAccount(BankAccount ba) {
        accounts.add(ba);
    }

    public static void addCar(Car c) {
        cars.add(c);
    }

    public static void addAllBarname(Barname b) {
        allBarnames.add(b);
    }

    public static void addTransaction(Transaction tr) {
        transactions.add(tr);
    }
    
    
}
