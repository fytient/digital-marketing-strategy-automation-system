/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class Channel {
    String channeltype; //tv, internet, mobile app

    public Channel(String c){
        channeltype = c;
    }
    public boolean isMatch(String c){
        if (channeltype.equalsIgnoreCase(c))return true;
        else return false;

    }
    public String getChannelType(){
        return channeltype;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Channel other = (Channel) obj;
        if (channeltype == null) {
            if (other.channeltype != null)
                return false;
        } else if (!channeltype.equals(other.channeltype))
            return false;
        return true;
    }

    
    
}
