/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import model.MarketModel.MarketChannelAssignment;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {

  ArrayList<Product> products;
  int price; //floor, ceiling, and target ideas
  String ad;
  MarketChannelAssignment marketchannelcomb;

  public SolutionOffer(MarketChannelAssignment m) {
    marketchannelcomb = m;
    products = new ArrayList<Product>();
  }

  public void addProduct(Product p) {
    products.add(p);
  }

  public ArrayList<Product> getProducts(){
    return products;
  }

  public void setPrice(int p) {
    price = p;
  }

  public int getSolutionPrice(){
    return price;
  }
  //this will allow one to retrieve all offers meant for this market/channel combo
  public boolean isOfferTargetMarketChannel(MarketChannelAssignment mca){
    if (marketchannelcomb == mca)return true;
    else return false;
  }
  public String getAd(){
    return ad;
  }
  public void setAd(String a){//This is an amazing solution for people like you
    ad = a;
  }

  public void printAd() {
    String marketName = marketchannelcomb.getMarket().getName();
    System.out.println("We're on Sale! Here's an amazing bundle offer for " + marketName + " like you!");
  }
  public MarketChannelAssignment getMarketchannelcomb(){
    return marketchannelcomb;
  }
// product1 + prodcut2 + prodcut3 + product4 = price
  public void printProductsAndSolutionPrice() {
    for (int i = 0; i < products.size(); i++) {
      Product product = products.get(i);
     
      System.out.print(product.getName());
      if (i == products.size() - 1) {
        System.out.print(" = ");
      } else {
        System.out.print(" + ");
      }
      
    }
    System.out.println("$" + price);
 
  }
}
