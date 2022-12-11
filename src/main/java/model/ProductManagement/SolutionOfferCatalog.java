/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {
    ArrayList<SolutionOffer> solutionoffers;

    public SolutionOfferCatalog() {
        this.solutionoffers = new ArrayList<>();
    }


    public SolutionOffer newSolutionOffer(MarketChannelAssignment mca) {
        SolutionOffer so = new SolutionOffer(mca);
        solutionoffers.add(so);
        return so;
    }

    public ArrayList<SolutionOffer> getSolutionoffers() {
        return solutionoffers;
    }
    
    public void printChosenBundle(String status, String gender, String channel) {
        ArrayList<SolutionOffer> pickedSos = new ArrayList<>();
        
        for (SolutionOffer so: solutionoffers) {
            MarketChannelAssignment mca = so.getMarketchannelcomb();

            boolean isThisSo = true;
            String statusName = mca.getMarket().getName();           
            String channelName = mca.getChannel().getChannelType();


            if ((StringUtils.isNotBlank(status) && !statusName.equalsIgnoreCase(status))
              ||(StringUtils.isNotBlank(channel) && ! channelName.equalsIgnoreCase(channel))) {
                isThisSo = false;
            }

            if (isThisSo) {
                pickedSos.add(so);
            }

        }

        for (SolutionOffer pickedSo : pickedSos) {

            MarketChannelAssignment pickedMca = pickedSo.getMarketchannelcomb();

            if (StringUtils.isNotBlank(gender) 
            && (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
                pickedMca.printMarketsAndChannel(gender);           
                System.out.print(" | ");
                pickedSo.printProductsAndSolutionPrice();
                System.out.println(); //change line
            } else if (StringUtils.isBlank(gender)){
                
                pickedMca.printMarketsAndChannel("female");           
                System.out.print(" | ");
                pickedSo.printProductsAndSolutionPrice();
                System.out.println(); //change line

                pickedMca.printMarketsAndChannel("male");           
                System.out.print(" | ");
                pickedSo.printProductsAndSolutionPrice();
                System.out.println(); //change line
            } 
        }

        Random randomGenerator = new Random();
        pickedSos.get(randomGenerator.nextInt(pickedSos.size())).printAd();
        
        System.out.println();
    }
}
