/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.ArrayList;

import model.CustomerManagement.CustomerDirectory;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.MarketModel.MarketChannelComboCatalog;
import model.MarketingManagement.MarketingPersonDirectory;
import model.OrderManagement.MasterOrderList;
import model.Personnel.EmployeeDirectory;
import model.Personnel.PersonDirectory;
import model.ProductManagement.MasterSolutionOrderList;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOfferCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

  String name;
  PersonDirectory persondirectory;
  MasterOrderList masterorderlist;
  CustomerDirectory customers;
  SupplierDirectory suppliers;
  MarketCatalog marketcatalog;
  ChannelCatalog channelcatalog;
  // MarketChannelAssignment marketchannelassignment;
  SolutionOfferCatalog solutionoffercatalog;
  CustomerDirectory customerdirectory;
  EmployeeDirectory employeedirectory;
  SalesPersonDirectory salespersondirectory;
  UserAccountDirectory useraccountdirectory;
  MarketingPersonDirectory marketingpersondirectory;
  MarketChannelComboCatalog marketchannelcombocatalog;
  MasterSolutionOrderList mastersolutionorderlist;

  public Business(String n) {
    name = n;
    masterorderlist = new MasterOrderList();
    suppliers = new SupplierDirectory();
    solutionoffercatalog = new SolutionOfferCatalog();
    marketcatalog = new MarketCatalog();
    channelcatalog = new ChannelCatalog();
    persondirectory = new PersonDirectory();
    customerdirectory = new CustomerDirectory(this);
    salespersondirectory = new SalesPersonDirectory(this);
    useraccountdirectory = new UserAccountDirectory();
    marketingpersondirectory = new MarketingPersonDirectory(this);
    employeedirectory = new EmployeeDirectory(this);
    mastersolutionorderlist = new MasterSolutionOrderList();
    marketchannelcombocatalog = new MarketChannelComboCatalog();
    
  }

  public int getSalesVolume() {
    return masterorderlist.getSalesVolume();
  }

  public PersonDirectory getPersonDirectory() {
    return persondirectory;
  }

  public UserAccountDirectory getUserAccountDirectory() {
    return useraccountdirectory;
  }

  public MarketingPersonDirectory getMarketingPersonDirectory() {
    return marketingpersondirectory;
  }

  public SupplierDirectory getSupplierDirectory() {
    return suppliers;
  }

  public ProductsReport getSupplierPerformanceReport(String n) {
    Supplier supplier = suppliers.findSupplier(n);
    if (supplier == null) {
      return null;
    }
    return supplier.prepareProductsReport();
  }

  public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(
    String n
  ) {
    ProductsReport productsreport = getSupplierPerformanceReport(n);
    return productsreport.getProductsAlwaysAboveTarget();
  }

  public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
    ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
    int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
    return i;
  }

  public CustomerDirectory getCustomerDirectory() {
    return customerdirectory;
  }

  public SalesPersonDirectory getSalesPersonDirectory() {
    return salespersondirectory;
  }

  public MasterOrderList getMasterOrderList() {
    return masterorderlist;
  }

  public EmployeeDirectory getEmployeeDirectory() {
    return employeedirectory;
  }
  public MarketCatalog getMarketCatalog(){
    return marketcatalog;
  }
  public ChannelCatalog getChannelCatalog(){
    return channelcatalog;
  }
  public MarketChannelComboCatalog getMarketChannelComboCatalog(){
    return marketchannelcombocatalog;
  }
  public SolutionOfferCatalog getSolutionOfferCatalog(){
    return solutionoffercatalog;
  }
  public MasterSolutionOrderList getMasterSolutionOrderList(){
    return mastersolutionorderlist;
  }
  
}
