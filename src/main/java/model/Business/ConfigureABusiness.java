/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;



import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.apache.commons.lang3.RandomUtils;

import com.github.javafaker.service.RandomService;

import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.MarketModel.MarketChannelComboCatalog;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.MasterSolutionOrderList;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.ProductManagement.SolutionOrder;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.SupplierDirectory;
import model.Supplier.Supplier;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  public static Business initialize() {
    Business business = new Business("Amazon");

    // Create Persons
    PersonDirectory persondirectory = business.getPersonDirectory();
    // person representing sales organization        
    Person salesperson001 = persondirectory.newPerson("sales");
    Person marketingperson001 = persondirectory.newPerson("marketing");
    

    // Create Customers
    CustomerDirectory customedirectory = business.getCustomerDirectory();
    CustomerProfile customerprofile1 = customedirectory.newCustomerProfile(salesperson001);
    

    // Create Sales people
    SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
    SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(salesperson001);

    
   

    SupplierDirectory sd = business.getSupplierDirectory();
    
    
    Supplier sony = sd.newSupplier("Sony");
    ProductCatalog sonyCatalog = sony.getProductCatalog();
    Product s1p1 = sonyCatalog.newProduct("ICFC-1 Alarm Clock Radio LED Black", 10, 20, 13);
    Product s1p2 = sonyCatalog.newProduct("Wireless Bluetooth Portable Lightweight Travel Speaker", 100, 120, 109);
    Product s1p3 = sonyCatalog.newProduct("Noise Cancelling Headphones", 130, 150, 148);
    Product s1p4 = sonyCatalog.newProduct("Wireless Premium Noise Canceling Overhead Headphones", 300, 360, 348);
    Product s1p5 = sonyCatalog.newProduct("65 Inch 4K Ultra HD TV", 680, 710, 698);
    Product s1p6 = sonyCatalog.newProduct("Wireless Headphones WH-CH510", 30, 40, 38);
    Product s1p7 = sonyCatalog.newProduct("WF-C500 Truly Wireless In-Ear Bluetooth Earbud Headphones ", 60, 70, 68);
    Product s1p8 = sonyCatalog.newProduct("Glass Sound 360 Degrees All Directional Speaker", 240, 250, 248);
    Product s1p9 = sonyCatalog.newProduct("ZV-1 Digital Camera", 630, 650, 648);
    Product s1p10 = sonyCatalog.newProduct("Wireless Portable-BLUETOOTH-Karaoke Party-Speaker", 290, 300, 298);

    Supplier warner = sd.newSupplier("Warner Music Group");
    ProductCatalog warnerCatalog = warner.getProductCatalog();
    Product taylor = warnerCatalog.newProduct("Taylor Swift - Red", 20, 30, 25);
    Product adele = warnerCatalog.newProduct("Adele - 25", 20, 30, 25);
    Product backStreetBoys = warnerCatalog.newProduct("Back Street Boys - Backstreet's Back", 20, 30, 25);
    Product britneySpears = warnerCatalog.newProduct("Britney Spears - Oops!... I Did It Again", 20, 30, 25);
    Product conanGray = warnerCatalog.newProduct("Conan Gray - Kid Krow", 20, 30, 25);
    Product oliviaRodrigo = warnerCatalog.newProduct("Olivia Rodrigo - Sour", 20, 30, 25);
    Product elvisPresley = warnerCatalog.newProduct("Elvis Presley - Greatest Hits", 20, 30, 25);
    Product theBeatles = warnerCatalog.newProduct("The Beatles - Greatest Hits", 20, 30, 25);
    Product rihanna = warnerCatalog.newProduct("Rihanna - Greatest Hits", 20, 30, 25);
    Product kendricklamar = warnerCatalog.newProduct("Kendrick Lamar - Greatest Hits", 20, 30, 25);

    MarketCatalog mc = business.getMarketCatalog();
    Market teenmarket = mc.newMarket("Teenagers");
    Market collegeMarket = mc.newMarket("College Grads");
    Market milMarket = mc.newMarket("Millennial");
    Market zMarket = mc.newMarket("Z Generation");
    Market sMarket = mc.newMarket("Senior");
    
    Market fteen = teenmarket.setSubMarket("female");
    Market mteen = teenmarket.setSubMarket("male");
    Market fcollegegrad = collegeMarket.setSubMarket("female");
    Market mcollegegrad = collegeMarket.setSubMarket("male");
    Market fmil = milMarket.setSubMarket("female");
    Market mmil = milMarket.setSubMarket("male");
    Market fz = zMarket.setSubMarket("female");
    Market mz = zMarket.setSubMarket("male");
    Market fs = sMarket.setSubMarket("female");
    Market ms = sMarket.setSubMarket("male");
     
    ChannelCatalog channelCatalog = business.getChannelCatalog();
    Channel tvChannel = channelCatalog.newChannel("TV");
    Channel webChannel = channelCatalog.newChannel("Web");
    
    

  

    
    MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();
    MarketChannelAssignment tvchannelteenmarket = mccc.newMarketChannelCombo(teenmarket, tvChannel);
    MarketChannelAssignment webchannelteenmarmarket = mccc.newMarketChannelCombo(teenmarket, webChannel);
    MarketChannelAssignment tvchannelcollegemarket = mccc.newMarketChannelCombo(collegeMarket, tvChannel);
    MarketChannelAssignment webchannelcollegemarket = mccc.newMarketChannelCombo(collegeMarket, webChannel);
    MarketChannelAssignment tvchannelmilmarket = mccc.newMarketChannelCombo(milMarket, tvChannel);
    MarketChannelAssignment webchannelmilmarket = mccc.newMarketChannelCombo(milMarket, webChannel);
    MarketChannelAssignment tvchannelzmarket = mccc.newMarketChannelCombo(zMarket, tvChannel);
    MarketChannelAssignment webchannelzmarket = mccc.newMarketChannelCombo(zMarket, webChannel);
    MarketChannelAssignment tvchannelsmarket = mccc.newMarketChannelCombo(sMarket, tvChannel);
    MarketChannelAssignment webchannelsmarket = mccc.newMarketChannelCombo(sMarket, webChannel);
    SolutionOfferCatalog solutionOfferCatalog = business.getSolutionOfferCatalog();
    
    SolutionOffer solutiontvteen = solutionOfferCatalog.newSolutionOffer(tvchannelteenmarket);
    solutiontvteen.addProduct(s1p1);
    solutiontvteen.addProduct(taylor);
    setPriceBydiffStrategy(solutiontvteen);
    
    SolutionOffer solutionwebteen = solutionOfferCatalog.newSolutionOffer(webchannelteenmarmarket);
    solutionwebteen.addProduct(s1p1);
    solutionwebteen.addProduct(taylor);
    setPriceBydiffStrategy(solutionwebteen);
    SolutionOffer solutiontvcollege = solutionOfferCatalog.newSolutionOffer(tvchannelcollegemarket);
    solutiontvcollege.addProduct(adele);
    solutiontvcollege.addProduct(s1p2);
    setPriceBydiffStrategy(solutiontvcollege);
    SolutionOffer solutionwebcollege = solutionOfferCatalog.newSolutionOffer(webchannelcollegemarket);
    solutionwebcollege.addProduct(adele);
    solutionwebcollege.addProduct(s1p2);
    setPriceBydiffStrategy(solutionwebcollege);
    SolutionOffer solutiontvmil = solutionOfferCatalog.newSolutionOffer(tvchannelmilmarket);
    solutiontvmil.addProduct(rihanna);
    solutiontvmil.addProduct(s1p3);
    setPriceBydiffStrategy(solutiontvmil);
    SolutionOffer solutionwebmil = solutionOfferCatalog.newSolutionOffer(webchannelmilmarket);
    solutionwebmil.addProduct(rihanna);
    solutionwebmil.addProduct(s1p3);
    setPriceBydiffStrategy(solutionwebmil);
    SolutionOffer solutiontvz = solutionOfferCatalog.newSolutionOffer(tvchannelzmarket);
    solutiontvz.addProduct(oliviaRodrigo);
    solutiontvz.addProduct(s1p7);
    setPriceBydiffStrategy(solutiontvz);
    SolutionOffer solutionwebz = solutionOfferCatalog.newSolutionOffer(webchannelzmarket);
    solutionwebz.addProduct(oliviaRodrigo);
    solutionwebz.addProduct(s1p7);
    setPriceBydiffStrategy(solutionwebz);
    SolutionOffer solutiontvs = solutionOfferCatalog.newSolutionOffer(tvchannelsmarket);
    solutiontvs.addProduct(elvisPresley);
    solutiontvs.addProduct(s1p5);
    setPriceBydiffStrategy(solutiontvs);
    SolutionOffer solutionwebs = solutionOfferCatalog.newSolutionOffer(webchannelsmarket);
    solutionwebs.addProduct(elvisPresley);
    solutionwebs.addProduct(s1p5);
    setPriceBydiffStrategy(solutionwebs);
    MasterSolutionOrderList msol = business.getMasterSolutionOrderList();
    // SolutionOrder so = msol.newSolutionOrder(solutiontvteen);
    // so.getSolutionPrice();
    // SolutionOrder so2 = msol.newSolutionOrder(solutionwebteen);

    // each solution offer generate solution order and put in the MasterSolutionOrderList
  
    ArrayList<SolutionOffer> solOffs = business.getSolutionOfferCatalog().getSolutionoffers();
    RandomService rs = new RandomService();
    for (int i = 0; i < 100; i++) {
      msol.newSolutionOrder(solOffs.get(rs.nextInt(0, solOffs.size() - 1)));
    }

    

    return business;
  }

  private static SolutionOffer setPriceBydiffStrategy(SolutionOffer so) {
    Channel ch = so.getMarketchannelcomb().getChannel();
    Market market = so.getMarketchannelcomb().getMarket();
    String chName = ch.getChannelType();
    String marketName = market.getName();
    Product product1 = so.getProducts().get(0);
    Product product2 = so.getProducts().get(1);

    int price = 0;

    if (  marketName.equalsIgnoreCase("Senior") && chName.equalsIgnoreCase("Web") 
      || !marketName.equalsIgnoreCase("Senior") && chName.equalsIgnoreCase("TV")) {
      price = product1.getCeilingPrice() + product2.getCeilingPrice();
      
    } else {
      price = product1.getFloorPrice() + product2.getFloorPrice();
    }

    so.setPrice(price);

    return so;
  }


}
