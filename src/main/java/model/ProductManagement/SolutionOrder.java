package model.ProductManagement;

public class SolutionOrder {
    
    SolutionOffer selectedSolutionOffer;

    public SolutionOrder(SolutionOffer so){
        selectedSolutionOffer =so;
    }
    public int getSolutionPrice(){
        return selectedSolutionOffer.getSolutionPrice();
    }
    public SolutionOffer getSelectedSolutionOffer() {
        return selectedSolutionOffer;
    }
}
