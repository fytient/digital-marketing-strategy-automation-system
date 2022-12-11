/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the templatCoe in the editor.
 */
package ui;


import java.util.ArrayList;
import java.util.Scanner;

import com.github.javafaker.Faker;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.MasterOrderList;
import model.ProductManagement.MasterSolutionOrderList;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    Business business = ConfigureABusiness.initialize();

    // Faker magicbox = new Faker();

    // String randomName = magicbox.name().fullName();
    // System.out.println(randomName);
    System.out.println("Choose your status(Teenagers/College Grads/Millenials/Z Generation/Senior)");
    System.out.println("Enter quit if you want to end this program.");

    Scanner sc = new Scanner(System.in);
    String status = sc.nextLine();

    while (!status.equalsIgnoreCase("quit")) {
      String gender = null;
      String channel = null;

      System.out.println("Choose your gender(Male/Female).");
      gender = sc.nextLine();    

      System.out.println("Choose your channel(TV/Web).");
      channel = sc.nextLine();
      

      // print market infos

      business.getSolutionOfferCatalog().printChosenBundle(status, gender, channel);


      System.out.println("Choose your status(Teenagers/College Grads/Millenials/Z Generation/Senior)");
      System.out.println("Enter quit if you want to end this program.");
      status = sc.nextLine();
    }

    // print report
    System.out.println("----------------------------");
    System.out.println("Sales revenue report ");
    System.out.println("----------------------------");
    ArrayList<Market> markets = business.getMarketCatalog().getMarkets();
    ArrayList<Channel> channels = business.getChannelCatalog().getChannellist();
    for (Channel channel : channels) {
      System.out.print("\t\t\t" + channel.getChannelType());
    }
    System.out.println("");
    for (int i = 0; i < channels.size(); i++) {
      System.out.print("\t" + "adBudget" + "\s" + "targetRev" + "\s" + "actualRev");
    }
    MasterSolutionOrderList msol = business.getMasterSolutionOrderList();
    
    for (Market market : markets){
      System.out.print("\n" + market.getName());
      if (market.getName().length() < 8)
        System.out.print("\t");
      for (Channel channel : channels) {
        int actualRev = msol.getActualRevenue(market, channel);
        int targetRev = msol.getTargetRevenueByMarketChannelCombo(market, channel);
        int adBudget = msol.getAdBudgetByMarketChannelComb(market, channel);
        System.out.print(  "\t" + adBudget + "\t" + targetRev + "\t" + actualRev);
      }
      System.out.println("");
    }
  }
}
