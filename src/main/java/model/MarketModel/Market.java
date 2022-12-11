/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Market {

  ArrayList<SolutionOffer> so;
  ArrayList<MarketChannelAssignment> channels;
  ArrayList<String> characteristics;
  ArrayList<Market> submarkets;
  int size;
  String name;

  public Market(String s) {
    characteristics = new ArrayList<String>();
    characteristics.add(s);
    submarkets = new ArrayList<>();
    // submarkets.add(new Market("female"));
    // submarkets.add(new Market("male"));
    // Market femaleSubmarket = submarkets.get(0);
    // Market maleSubmarket = submarkets.get(1);


    channels = new ArrayList<MarketChannelAssignment>();
    //channels.add(c);
    name = s;
  }
  public ArrayList<Market> getSubMarket(){
    return submarkets;
  }

  public Market setSubMarket(String gender){
    Market subMarket = new Market(gender);
    submarkets.add(subMarket);
    return subMarket;
  }

  // submarket -> {female, male}
  

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Market other = (Market) obj;
    if (size != other.size)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
  public String getName() {
    return name;
  }


}
