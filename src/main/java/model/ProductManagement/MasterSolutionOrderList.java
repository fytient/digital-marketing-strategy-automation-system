package model.ProductManagement;

import java.util.ArrayList;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;

public class MasterSolutionOrderList {
    ArrayList<SolutionOrder> solutionorderlist;

    public MasterSolutionOrderList(){
        solutionorderlist = new ArrayList<>();
    }
    public SolutionOrder newSolutionOrder(SolutionOffer soffer){
        SolutionOrder so = new SolutionOrder(soffer);
        solutionorderlist.add(so);
        return so;

    }
    public int getTargetRevenueByMarket(Market m){
        int revenue = 0;
        for(SolutionOrder so : solutionorderlist) {
            MarketChannelAssignment mca = so.getSelectedSolutionOffer().getMarketchannelcomb();
            if (m.equals(mca.getMarket()))
                revenue += mca.getTargetRevenue();
        }
        return revenue;
    }
    public int getTargetRevenueByMarketChannelCombo(Market m, Channel c){
        //Go through each order in the solutionOrderList and see if the market/channel combo matches
        int revenueCombo = 0;
        for (SolutionOrder so: solutionorderlist){
            MarketChannelAssignment mca = so.getSelectedSolutionOffer().getMarketchannelcomb();
            if (mca.isMatch(m, c)) {
                for (Product product : so.getSelectedSolutionOffer().getProducts()) {
                revenueCombo += product.getTargetPrice();
                }
            }
        }
        return revenueCombo;
    }
    public int getAdBudgetByMarketChannelComb(Market m, Channel c){
        int adBudget = 0;
        for (SolutionOrder so: solutionorderlist){
            MarketChannelAssignment mca = so.getSelectedSolutionOffer().getMarketchannelcomb();
            if (mca.isMatch(m, c))
                adBudget += mca.getAdBudget();
        }
        return adBudget;
    }
    public int getActualRevenue(Market m, Channel c) {
        int actualRev = 0;
        for (SolutionOrder so: solutionorderlist){
            MarketChannelAssignment mca = so.getSelectedSolutionOffer().getMarketchannelcomb();
            if (mca.isMatch(m, c))
                actualRev += so.getSolutionPrice();
        }
        return actualRev;
    }
}
