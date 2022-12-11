package model.MarketModel;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class MarketChannelComboCatalog {
    ArrayList<MarketChannelAssignment>mcalist;

    public MarketChannelComboCatalog(){
        mcalist = new ArrayList<>();
    }
    public MarketChannelAssignment newMarketChannelCombo(Market m, Channel c){
        MarketChannelAssignment mcc = new MarketChannelAssignment(m, c);
        mcalist.add(mcc);
        return mcc;
    }
    public MarketChannelAssignment findMarketChannelCombo(Market m, Channel c){
        for(MarketChannelAssignment mca: mcalist){
            if (mca.isMatch(m,c))return mca;
        }
        return null;
    }
    public ArrayList<MarketChannelAssignment> getMarketChannelAssignments() {
        return mcalist;
    }

   
}
