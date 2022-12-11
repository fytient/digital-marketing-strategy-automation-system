/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import java.util.Random;

import model.ProductManagement.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {
    //ad budget and target revenue
    Market market;
    Channel channel;
    int adbudget;
    int targetrevenue;
    ArrayList<SolutionOrder> orders; //Actual revenue
    Random randomGenerator;
    
    public MarketChannelAssignment(Market m, Channel c){
        randomGenerator = new Random();
        market = m;
        channel = c;
        adbudget = randomInRange(100, 400);
        
    }
    

    public int randomInRange(int min, int max) {
        return min + randomGenerator.nextInt(max - min);
      }

    public boolean isMatch(Market m, Channel c) {
        if (market.equals(m) && channel.equals(c)) return true;
        else return false;
    }

    public Market getMarket() {
        return market;
    }

    public Channel getChannel() {
        return channel;
    }

    public int getAdBudget(){
        return adbudget;
    }
    public int getTargetRevenue(){
        return targetrevenue;
    }
    public int getActualRevenue(){
        int actualRevenue = 0;
        for ( SolutionOrder so : orders) {
            actualRevenue += so.getSolutionPrice();
        }      
        return actualRevenue;
    }
    
    public void printMarketsAndChannel(String gender) {
        //Ternary Operator
        Integer genderIndx = gender.equalsIgnoreCase("female") ? 0 : 1;

        String statusName = market.getName();
        String genderName = market.getSubMarket().get(genderIndx).getName();
        String channelName = channel.getChannelType();

        

        System.out.print("Market : " + statusName + " - " + genderName +
                           " | Channel : " + channelName );
    }
    
    
}
